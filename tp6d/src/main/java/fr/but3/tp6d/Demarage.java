package fr.but3.tp6d;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import fr.but3.tp6d.repositories.AuteurRepository;
import fr.but3.tp6d.repositories.LivreRepository;

@Component
public class Demarage implements ApplicationRunner
{
	@Autowired
	private AuteurRepository auteurRepository;

	@Autowired
	private LivreRepository livreRepository;

	@Override
	public void run(ApplicationArguments args) throws Exception
	{
		auteurRepository.findAll().forEach(auteur -> System.out.println(auteur));

		livreRepository.findAll().forEach(livre -> System.out.println(livre));
	}

}
