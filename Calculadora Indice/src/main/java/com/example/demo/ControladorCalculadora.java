package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ControladorCalculadora {
	
	@RequestMapping(value="/calculadora",method=RequestMethod.GET)
	public String calculador_get() {
		return "calculadora";
	}
	
	@RequestMapping(value="/calculadora", method=RequestMethod.POST)
	public String calculadora_post(Model model,
			@RequestParam int peso,
			@RequestParam double altura,
			@RequestParam int edad,
			@RequestParam String hm
			) {
		
		double masaCorp = peso / (altura * altura);
		double grasaCorp = 1.2 * masaCorp + 0.23 * edad - 10.8 * Integer.valueOf(hm) - 5.4;
		String categoria="";
		
		
		switch(hm) {
			case "0" :
				if(grasaCorp > 10 && grasaCorp < 14)
					 categoria = "Grasa esencial";
				else if(grasaCorp < 21)
					categoria = "Atleta";
				else if(grasaCorp < 25)
					categoria = "Fitness";
				else if(grasaCorp <= 31)
					categoria = "Aceptable";
				else if(grasaCorp >31)
					categoria = "Obesidad";
				else 
					categoria ="Ha ocurrido un error inesperado";
			case "1" :
				if( grasaCorp > 2 && grasaCorp < 5)
					 categoria = "Grasa esencial";
				else if(grasaCorp < 13)
					categoria = "Atleta";
				else if(grasaCorp < 17)
					categoria = "Fitness";
				else if(grasaCorp <= 24)
					categoria = "Aceptable";
				else if(grasaCorp > 24)
					categoria = "Obesidad";
				else 
					categoria ="Ha ocurrido un error inesperado";
			
		}
		
		model.addAttribute("peso_form",peso);
		model.addAttribute("altura_form",altura);
		model.addAttribute("edad_form",edad);
		model.addAttribute("hm_form",Integer.valueOf(hm));
		model.addAttribute("masaCorp_form",masaCorp);
		model.addAttribute("grasaCorp_form",grasaCorp);
		model.addAttribute("categoria_form",categoria);
		return "datosCalculadora";
	}
	
}
