package fr.but3.tp6;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class MyOwnScheduling
{

	@Scheduled(initialDelay = 2000, fixedDelay = 500)
	public void print()
	{
		System.out.println("DELAY");
	}

}
