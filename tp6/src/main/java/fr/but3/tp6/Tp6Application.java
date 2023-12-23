package fr.but3.tp6;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class Tp6Application
{
	public static void main(String[] args)
	{
		SpringApplication.run(Tp6Application.class, args);
	}

}
