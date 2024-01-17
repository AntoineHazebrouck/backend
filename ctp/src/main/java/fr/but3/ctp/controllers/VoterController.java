package fr.but3.ctp.controllers;

import java.security.Principal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;
import fr.but3.ctp.entities.Choix;
import fr.but3.ctp.entities.Question;
import fr.but3.ctp.repositories.ChoixRepository;
import fr.but3.ctp.repositories.QuestionRepository;
import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class VoterController {
	private final ChoixRepository choixRepository;
	private final QuestionRepository questionRepository;

	@GetMapping("/voter")
	public String voter(ModelMap modelmap, Principal principal)
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

		modelmap.put("username", principal.getName());
		modelmap.put("currentQuestion", current);
		modelmap.put("choix", current.getChoix());
		return "voter";
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

		return new RedirectView("/apres-voter/" + current.getCno());
	}

	@GetMapping("/apres-voter/{cno}")
	public String apresVoter(@PathVariable Integer cno, ModelMap modelmap, Principal principal)
	{
		modelmap.put("username", principal.getName());
		modelmap.put("choix", choixRepository.findById(cno).get());
		return "apres_voter";
	}
}
