package com.smarthouse.device;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@SpringBootApplication
@EnableDiscoveryClient
@EnableResourceServer
@EntityScan("com.smarthouse.commonutil.entities")
public class DeviceApplication {
    public static void main(String[] args) {
        SpringApplication.run(DeviceApplication.class, args);
    }
}
