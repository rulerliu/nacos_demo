package com.liuwq.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProviderController {

    Logger logger = LoggerFactory.getLogger(ProviderController.class);

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/hi")
    @SentinelResource(value = "hi")
    public String hi(@RequestParam(value = "name", defaultValue = "forezp", required = false) String name) {
        return "hi," + name + serverPort;
    }

}
