package com.alibaba.dubbo.samples.apiinvoke.echo;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ReferenceConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.alibaba.dubbo.samples.apiinvoke.echo.api.EchoService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 基于API编写Echo客户端
 *
 * @author zhengguinan
 */
public class EchoConsumer {

    public static void main(String[] args) {
        ReferenceConfig<EchoService> reference=new ReferenceConfig<EchoService>();
        reference.setApplication(new ApplicationConfig("java-echo-consumer"));
        reference.setRegistry(new RegistryConfig("zookeeper://127.0.0.1:2181"));
        reference.setInterface(EchoService.class);

        EchoService greetingService = reference.get();
        String message = greetingService.echo("Hello world!");
        System.out.println(message);

    }
}
