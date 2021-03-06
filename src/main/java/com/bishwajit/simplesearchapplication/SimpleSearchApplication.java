package com.bishwajit.simplesearchapplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
/*import org.springframework.boot.web.support.SpringBootServletInitializer;*/

@SpringBootApplication
public class SimpleSearchApplication {

    public static void main(String[] args) {
        SpringApplication.run(SimpleSearchApplication.class, args);
    }
   /* @Override*/
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(SimpleSearchApplication.class);
    }
}
