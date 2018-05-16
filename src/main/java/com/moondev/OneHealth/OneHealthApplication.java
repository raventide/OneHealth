package com.moondev.OneHealth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@Controller
public class OneHealthApplication {

	public static void main(String[] args) {
		SpringApplication.run(OneHealthApplication.class, args);
	}

	@RequestMapping("/")
	public String home() {
		return "redirect:/manage";
	}
}
