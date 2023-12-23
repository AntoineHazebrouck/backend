package fr.but3.tp7;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ControleurQ1
{
	@RequestMapping("/hello")
	String home(@RequestParam(defaultValue = "World", required = false) String name,
			ModelMap modelmap)
	{
		modelmap.put("name", name);
		return "mavue";
	}


}
