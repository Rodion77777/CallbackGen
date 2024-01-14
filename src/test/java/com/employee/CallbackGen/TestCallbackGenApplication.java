package com.employee.CallbackGen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.TestConfiguration;

@TestConfiguration(proxyBeanMethods = false)
public class TestCallbackGenApplication {
	public static void main(String[] args) {
		SpringApplication.from(CallbackGenApplication::main).with(TestCallbackGenApplication.class).run(args);
	}
}
