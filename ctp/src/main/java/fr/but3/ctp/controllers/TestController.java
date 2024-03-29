package fr.but3.ctp.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import fr.but3.ctp.entities.Choix;
import fr.but3.ctp.entities.Question;
import fr.but3.ctp.repositories.ChoixRepository;
import fr.but3.ctp.repositories.QuestionRepository;
import lombok.AllArgsConstructor;



@RestController
@AllArgsConstructor
public class TestController
{
	private final ChoixRepository choixRepository;
	private final QuestionRepository questionRepository;

	@GetMapping("/test")
	public String hello() {
		return "<h1>Hello World!</h1>";
	}
	
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
