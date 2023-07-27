package com.legalease.test.legaleasebackendtest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.TestConfiguration;

@TestConfiguration(proxyBeanMethods = false)
public class TestLegaleaseBackendTestApplication {

    public static void main(String[] args) {
        SpringApplication.from(LegaleaseBackendTestApplication::main)
                         .with(TestLegaleaseBackendTestApplication.class)
                         .run(args);
    }

}
