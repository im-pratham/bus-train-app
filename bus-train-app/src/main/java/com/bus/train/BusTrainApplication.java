package com.bus.train;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.freemarker.FreeMarkerAutoConfiguration;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication(exclude = {FreeMarkerAutoConfiguration.class})
public class BusTrainApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(BusTrainApplication.class, args);
    }
}
