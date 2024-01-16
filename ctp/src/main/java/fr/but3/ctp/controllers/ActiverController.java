package fr.but3.ctp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;
import fr.but3.ctp.entities.Question;
import fr.but3.ctp.repositories.ChoixRepository;
import fr.but3.ctp.repositories.QuestionRepository;
import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class ActiverController {
	private final ChoixRepository choixRepository;
	private final QuestionRepository questionRepository;

	@GetMapping("/activer")
	public String activer(ModelMap modelmap)
	{
		modelmap.put("questions", questionRepository.findAll());
		return "activer";
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
