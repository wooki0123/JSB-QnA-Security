package com.back.sbb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class SbbTest01Application {

    public static void main(String[] args) {
        SpringApplication.run(SbbTest01Application.class, args);
    }

}
