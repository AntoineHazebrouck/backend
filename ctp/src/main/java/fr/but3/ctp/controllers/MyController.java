package fr.but3.ctp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;
import com.fasterxml.jackson.annotation.JsonCreator.Mode;
import fr.but3.ctp.entities.Choix;
import fr.but3.ctp.entities.Question;
import fr.but3.ctp.repositories.ChoixRepository;
import fr.but3.ctp.repositories.QuestionRepository;



@Controller
public class MyController
{
	@Autowired
	private ChoixRepository choixRepository;
	@Autowired
	private QuestionRepository questionRepository;

	@GetMapping("/voir")
	public String voir(ModelMap modelmap)
	{
		Question current = questionRepository.findByActive(true).get(0);
		
		System.out.println(current);
		modelmap.put("currentQuestion", current);
		modelmap.put("choix", current.getChoix());

		var nbGood = current.getChoix()
				.stream()
				.filter(choix -> choix.getStatut() == true)
				.mapToInt(choix -> choix.getNbchoix())
				.sum();
		var total = current.getChoix()
				.stream()
				.mapToInt(choix -> choix.getNbchoix())
				.sum();

		long percentage = nbGood * 100 / total;
		modelmap.put("percentage", percentage + "%");

		return "mavue3";
	}


	@GetMapping("/activer")
	public String activer(ModelMap modelmap)
	{
		modelmap.put("questions", questionRepository.findAll());
		return "mavue";
	}

	@GetMapping("/voter")
	public String voter(ModelMap modelmap)
	{
		Iterable<Question> questions = questionRepository.findAll();
		Question current = null;
		for (Question question : questions)
		{
			if (question.getActive())
			{
				current = question;
			}
		}
		System.out.println(current);
		modelmap.put("currentQuestion", current);
		modelmap.put("choix", current.getChoix());
		return "mavue2";
	}

	@PostMapping("/voter")
	public RedirectView voterPost(@RequestParam String my_choix)
	{
		Iterable<Choix> choix = choixRepository.findAll();
		Choix current = null;
		for (Choix aChoix : choix)
		{
			if (
				aChoix.getCno()
						.equals(Integer.parseInt(my_choix.strip()))
			)
			{
				current = aChoix;
			}
		}
		if (current.getNbchoix() == null)
		{
			current.setNbchoix(1);
		} else
		{
			current.setNbchoix(current.getNbchoix() + 1);
		}

		choixRepository.save(current);

		return new RedirectView("/voir");
	}

	@PostMapping(path = "/activer")
	public RedirectView activerPost(@RequestParam String my_question, ModelMap modelmap)
	{
		Iterable<Question> questions = questionRepository.findAll();
		questions.forEach(question -> {
			question.setActive(false);
		});
		questionRepository.saveAll(questions);

		Question question = questionRepository.findById(Integer.parseInt(my_question.strip()))
				.get();
		question.setActive(true);
		questionRepository.save(question);

		modelmap.put("questions", questionRepository.findAll());
		return new RedirectView("/voter");
	}


}
