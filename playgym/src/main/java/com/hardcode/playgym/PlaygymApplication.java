package com.hardcode.playgym;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class PlaygymApplication {

	public static void main(String[] args) {
		SpringApplication.run(PlaygymApplication.class, args);
	}

}
