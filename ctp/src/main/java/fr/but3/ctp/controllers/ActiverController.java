package fr.but3.ctp.controllers;

import java.security.Principal;
import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;
import fr.but3.ctp.entities.Question;
import fr.but3.ctp.repositories.QuestionRepository;
import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class ActiverController {
	private final QuestionRepository questionRepository;

	@GetMapping({"/activer", "/"})
	public String activer(ModelMap modelmap, Principal principal)
	{
		modelmap.put("username", principal.getName());
		modelmap.put("questions", questionRepository.findAll());
		return "activer";
	}

	@PostMapping(path = "/activer")
	public RedirectView activerPost(@RequestParam String my_question, ModelMap modelmap)
	{
		desactiverQuestions();


		int questionId = Integer.parseInt(my_question.strip());
		activerQuestion(questionId);

		modelmap.put("questions", questionRepository.findAll());
		return new RedirectView("/voir");
	}

	private void activerQuestion(int questionId)
	{
		Question question = questionRepository.findById(questionId).orElseThrow(() -> {
			throw new NoSuchElementException("La question " + questionId + " n'existe pas");
		});
		question.setActive(true);
		questionRepository.save(question);
	}

	private void desactiverQuestions()
	{
		List<Question> questionsDesactivees = questionRepository.findAll().stream()
			.map(question -> {
				question.setActive(false);
				return question;
			})
			.toList();
		questionRepository.saveAll(questionsDesactivees);
	}
}
