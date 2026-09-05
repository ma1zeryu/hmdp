//package com.hmdp.service.impl;
//
//import com.aliyun.dysmsapi20170525.Client;
//import com.aliyun.dysmsapi20170525.models.SendSmsRequest;
//import com.aliyun.dysmsapi20170525.models.SendSmsResponse;
//import com.aliyun.teaopenapi.models.Config;
//import com.hmdp.service.SmsService;
//import org.springframework.stereotype.Service;
//
//
//@Service
//public class SmsServiceImpl implements SmsService {
//    @Override
//    public void sendCode(String phone, String code) throws Exception {
//        Config config = new Config()
//                // 配置 AccessKey ID，请确保代码运行环境设置了环境变量 ALIBABA_CLOUD_ACCESS_KEY_ID。
//                .setAccessKeyId(System.getenv("ALIBABA_CLOUD_ACCESS_KEY_ID"))
//                // 配置 AccessKey Secret，请确保代码运行环境设置了环境变量 ALIBABA_CLOUD_ACCESS_KEY_SECRET。
//                .setAccessKeySecret(System.getenv("ALIBABA_CLOUD_ACCESS_KEY_SECRET"));
//
//        // 配置 Endpoint
//        config.endpoint = "dysmsapi.aliyuncs.com";
//
//        Client client = new Client(config);
//
//        SendSmsRequest request = new SendSmsRequest()
//                .setPhoneNumbers(phone)
//                .setSignName("阿里云短信测试")
//                .setTemplateCode("SMS_154950909")
//                .setTemplateParam("{\"code\":\"" + code + "\"}");
//
//        SendSmsResponse response = client.sendSms(request);
//
//        System.out.println("Code: " + response.getBody().getCode());
//        System.out.println("Message: " + response.getBody().getMessage());
//        System.out.println("RequestId: " + response.getBody().getRequestId());
//        System.out.println("BizId: " + response.getBody().getBizId());
//    }
//}
