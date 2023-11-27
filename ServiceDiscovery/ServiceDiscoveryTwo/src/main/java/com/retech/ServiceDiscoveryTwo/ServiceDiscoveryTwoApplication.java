package com.retech.ServiceDiscoveryTwo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class ServiceDiscoveryTwoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceDiscoveryTwoApplication.class, args);
	}

}
