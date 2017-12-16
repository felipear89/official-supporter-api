package com.company.officialsupporterapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class OfficialSupporterApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(OfficialSupporterApiApplication.class, args);
	}
}
