package com.hmdp.service.impl;

import com.hmdp.utils.CacheClient;
import com.hmdp.utils.RedisIdWorker;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@SpringBootTest
class ShopServiceImplTest {

    @Resource
    private CacheClient cacheClient;

    @Resource
    private ShopServiceImpl shopService;

    @Resource
    private RedisIdWorker redisIdWorker;

    private ExecutorService executorService = Executors.newFixedThreadPool(500);

    @Test
    void testSaveShop() throws InterruptedException {

        // 500 个线程执行完成后，CountDownLatch 才会变成 0
        CountDownLatch latch = new CountDownLatch(500);

        // 每个线程执行的任务
        Runnable task = () -> {
            for (int i = 0; i < 100; i++) {
                long id = redisIdWorker.nextId("order");
                System.out.println("id = " + id);
            }

            // 当前线程任务执行完毕，计数 -1
            latch.countDown();
        };

        long begin = System.currentTimeMillis();

        // 提交 500 个任务
        for (int i = 0; i < 500; i++) {
            executorService.submit(task);
        }

        // 主线程等待，直到 500 个任务全部执行完成
        latch.await();

        long end = System.currentTimeMillis();

        System.out.println("生成 50000 个 ID 总耗时：" + (end - begin) + " ms");
    }
}