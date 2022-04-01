package ru.exam.ruzana;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
//import org.springframework.context.annotation.ComponentScan;

@EnableScheduling
@SpringBootApplication
//@ComponentScan("ru.exam.ruzana")
public class PersonServiceApplication {

	public static void main(String[] args) {

		SpringApplication.run(PersonServiceApplication.class);
	}
}
