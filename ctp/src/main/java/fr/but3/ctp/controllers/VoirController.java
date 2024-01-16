package fr.but3.ctp.controllers;

import java.security.Principal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import fr.but3.ctp.entities.Question;
import fr.but3.ctp.repositories.QuestionRepository;
import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class VoirController {
	private final QuestionRepository questionRepository;

	@GetMapping("/voir")
	public String voir(ModelMap modelmap, Principal principal)
	{
		Question current = questionRepository.findByActive(true).get(0);
		
		System.out.println(current);
		modelmap.put("username", principal.getName());
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

		long percentage;
		if (total <= 0) {
			percentage = 0;
		} else {
			percentage = nbGood * 100 / total;
		}
		modelmap.put("percentage", percentage + "%");

		return "voir";
	}
}
