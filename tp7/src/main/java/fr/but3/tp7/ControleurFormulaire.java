package fr.but3.tp7;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ControleurFormulaire
{
	@Autowired
	private EtudiantsRepository etudiantsRepository;

	@GetMapping("/etudiantForm")
	String etudiantFormGet()
	{
		return "etudiantForm";
	}

	@PostMapping("/etudiantForm")
	String etudiantFormPost(Etudiant etudiant, ModelMap modelMap)
	{
		etudiantsRepository.save(etudiant);

		modelMap.put("etudiants", etudiantsRepository.findAll());
		return "Lister";
	}
}
