package io.github.nevitoniuri.avaliadorapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class AvaliadorApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(AvaliadorApiApplication.class, args);
    }

}
