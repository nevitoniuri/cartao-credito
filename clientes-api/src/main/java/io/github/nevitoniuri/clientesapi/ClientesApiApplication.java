package io.github.nevitoniuri.clientesapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class ClientesApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClientesApiApplication.class, args);
    }

}
