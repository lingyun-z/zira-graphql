package com.example.ziragraphql;

import com.example.ziragraphql.config.EssSettings;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableConfigurationProperties({EssSettings.class})
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@EnableAspectJAutoProxy
public class ZiraGraphqlApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZiraGraphqlApplication.class, args);
	}

}
