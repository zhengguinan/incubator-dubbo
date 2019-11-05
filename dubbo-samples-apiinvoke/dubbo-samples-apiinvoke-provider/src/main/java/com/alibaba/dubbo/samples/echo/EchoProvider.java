package com.alibaba.dubbo.samples.echo;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.alibaba.dubbo.config.ServiceConfig;
import com.alibaba.dubbo.samples.apiinvoke.echo.api.EchoService;
import com.alibaba.dubbo.samples.echo.impl.EchoServiceImpl;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * 基于API编写Echo服务器
 *
 * @author zhengguinan
 */
public class EchoProvider {

    public static void main(String[] args) throws IOException {
        ServiceConfig<EchoService> service = new ServiceConfig<EchoService>();
        service.setApplication(new ApplicationConfig("java-echo-provider"));
        service.setRegistry(new RegistryConfig("zookeeper://127.0.0.1:2181"));
        service.setInterface(com.alibaba.dubbo.samples.apiinvoke.echo.api.EchoService.class);
        service.setRef(new EchoServiceImpl());
        service.export();
        System.out.println("java-echo-provider is running.");
        System.in.read();
    }
}
