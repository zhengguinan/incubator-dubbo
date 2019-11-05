package com.alibaba.dubbo.samples.echo;

import com.alibaba.dubbo.samples.echo.api.EchoService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Echo客户端，基于XML方式消费服务
 *
 * @author zhengguinan
 */
public class EchoConsumer {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"spring/echo-consumer.xml"});

        context.start();
        EchoService echoService = (EchoService) context.getBean("echoService");
        String status = echoService.echo("Hello world!");
        System.out.println("echo result:" + status);

    }
}
