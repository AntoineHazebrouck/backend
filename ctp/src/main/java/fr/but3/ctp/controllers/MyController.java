package fr.but3.ctp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import fr.but3.ctp.repositories.ChoixRepository;
import fr.but3.ctp.repositories.QuestionRepository;


@Controller
public class MyController
{
	@Autowired
	private ChoixRepository choixRepository;
	@Autowired
	private QuestionRepository questionRepository;

	@GetMapping("/activer")
	public String activer()
	{
		return "mavue";
	}

}
