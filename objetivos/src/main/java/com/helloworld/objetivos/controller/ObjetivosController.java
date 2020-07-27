package com.helloworld.objetivos.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/objetivos")
public class ObjetivosController {
	
		@GetMapping
		public String objetivos() 
		
		{
			return "Meus objetivos de aprendizagem para essa semana, são::\n(1) Foco\n(2) Atenção aos detalhes \n(3) Mentalidade de crescimento \n(4) Proatividade";
		}

	
	

}
