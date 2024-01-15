package fr.but3.ctp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import fr.but3.ctp.entities.Choix;
import fr.but3.ctp.entities.Question;
import fr.but3.ctp.repositories.ChoixRepository;
import fr.but3.ctp.repositories.QuestionRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class TestController
{
	@Autowired
	private ChoixRepository choixRepository;
	@Autowired
	private QuestionRepository questionRepository;

	@GetMapping("/questions")
	public Iterable<Question> allQuestions()
	{
		return questionRepository.findAll();
	}

	@GetMapping("/choix")
	public Iterable<Choix> allChoix()
	{
		return choixRepository.findAll();
	}

}
