package fr.but3.tp9.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MonControleur {
	@GetMapping("/public")
	public String publicView() {
		return "public/v1";
	}

	@GetMapping("/private")
	public String privateView() {
		return "private/v2";
	}

}
