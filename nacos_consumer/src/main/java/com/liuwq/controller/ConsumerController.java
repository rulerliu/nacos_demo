package com.liuwq.controller;

import com.liuwq.feign.ProviderClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ConsumerController {

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/hi-resttemplate")
    public String hiResttemplate() {
        return restTemplate.getForObject("http://nacos-provider/hi?name=resttemplate", String.class);
    }

    @Autowired
    ProviderClient providerClient;

    @GetMapping("/hi-feign")
    public String hiFeign(){
        return providerClient.hi("feign");
    }

}