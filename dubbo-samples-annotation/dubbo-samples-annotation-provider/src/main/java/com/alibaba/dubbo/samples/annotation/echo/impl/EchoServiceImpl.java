package com.alibaba.dubbo.samples.annotation.echo.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.dubbo.rpc.RpcContext;
import com.alibaba.dubbo.samples.annotation.echo.api.EchoService;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.SimpleFormatter;

/**
 * 使用注解后，由dubbo服务将这个实现类提升为Spring容器的bean，并且负责配置初始化和服务暴露
 *
 * @author zhengguinan
 */
@Service

public class EchoServiceImpl implements EchoService {
    @Override
    public String echo(String message) {
        String now = new SimpleDateFormat("HH:mm:ss").format(new Date());
        System.out.println("[" + now + "] Hello " + message + ", request from consumer:" + RpcContext.getContext().getRemoteAddress());
        return message;
    }
}
