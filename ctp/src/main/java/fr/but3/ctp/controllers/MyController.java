package fr.but3.ctp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class MyController
{

	@GetMapping("/activer")
	public String activer()
	{
		return "mavue";
	}

}
