package com.acechat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class AceChatApplication {
	
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
         return application.sources(AceChatApplication.class);
    }

	public static void main(String[] args) {
		SpringApplication.run(AceChatApplication.class, args);
		
	}

}
