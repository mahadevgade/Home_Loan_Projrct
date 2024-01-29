package com.cjc.hl.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
@EntityScan("com.cjc.hl.main")
//@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class})
@SpringBootApplication
public class HomeLoanManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(HomeLoanManagementApplication.class, args);
	}

}
