package fr.but3.tp6c;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class Demarage implements ApplicationRunner
{
	@Autowired
	private AuteurRepository auteurRepository;

	@Override
	public void run(ApplicationArguments args) throws Exception
	{
		auteurRepository.findAll().forEach(auteur -> System.out.println(auteur));
	}

}
