package com.webtools.blogwebsite.springblog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//SpringBootApplication annotation takes care of all the auto configuration and components scan inside the application
@SpringBootApplication
public class SpringblogApplication {

	public static void main(String[] args) {
		//inside we are invoking run method from SpringApplication class which is responsible for bootstraping the application
		//that is it starts the application context, beans, setup database config etc.
		SpringApplication.run(SpringblogApplication.class, args);
	}

}
