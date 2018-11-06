package com.astasko.pdp.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.astasko.pdp")
@SpringBootApplication
public class PdpApplication {

    public static void main(String[] args) {
        SpringApplication.run(PdpApplication.class, args);
    }
}
