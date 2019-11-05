package com.alibaba.dubbo.samples.annotation.echo.refer;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.samples.annotation.echo.api.EchoService;
import org.springframework.stereotype.Component;

@Component
public class EchoConsumer {
    @Reference
    private EchoService echoService;

    public String echo(String name) {
        return echoService.echo(name);
    }

}
