package com.iron.ncp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.client.RestTemplate;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import tk.mybatis.spring.annotation.MapperScan;


@MapperScan(basePackages = "com.iron.ncp.dao")
@SpringBootApplication
@EnableScheduling
@EnableSwagger2
public class NcpApplication {

	public static void main(String[] args) {
		SpringApplication.run(NcpApplication.class, args);
		System.out.println("started !");
	}

	@Bean
	public RestTemplate RestTemplate() {
		return new RestTemplate();
	}
}
