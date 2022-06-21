package io.github.nevitoniuri.cartoesapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class CartoesApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(CartoesApiApplication.class, args);
    }

}
