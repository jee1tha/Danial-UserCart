package com.company.core;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource({"classpath:config/application.yml"})
@ComponentScan(basePackages = {"com.company"})
public class CoreApplication {
}
