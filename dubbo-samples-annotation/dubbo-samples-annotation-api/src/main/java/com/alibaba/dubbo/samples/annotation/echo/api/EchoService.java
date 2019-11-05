package com.alibaba.dubbo.samples.annotation.echo.api;


public interface EchoService {

    /**
     * 响应传入的消息
     *
     * @param message
     * @return
     */
    String echo(String message);
}
