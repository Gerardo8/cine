package org.luger.resource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
public class ResourceApplication {
    public static void main(String[] args) throws Exception {
        SpringApplication.run(ResourceApplication.class, args);
    }
}