package fr.but3.tp6;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class MyOwnScheduling2
{
	@Scheduled(initialDelay = 1000, fixedDelay = 3000)
	public void print()
	{
		System.out.println("ANOTHER DELAY");
	}

}
