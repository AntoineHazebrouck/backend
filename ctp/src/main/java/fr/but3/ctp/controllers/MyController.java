package fr.but3.ctp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	public String activer(ModelMap modelmap)
	{
		modelmap.put("questions", questionRepository.findAll());
		return "mavue";
	}

	@PostMapping(path = "/activer")
	public String activerPost(@RequestParam String my_question, ModelMap modelmap)
	{
		System.out.println(my_question);

		modelmap.put("questions", questionRepository.findAll());
		return "mavue";
	}


}
