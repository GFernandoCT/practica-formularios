package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ControladorFormulario {
	
	@RequestMapping(value="/formulario", method=RequestMethod.GET)
	public String formulario_get() {
		return "formulario";
	}
	
	@RequestMapping(value="/formulario", method=RequestMethod.POST)
	public String formulario_post(Model model,
		@RequestParam String nombre,
		@RequestParam String primerApe,
		@RequestParam String segundoApe,
		@RequestParam String eCorreo,
		@RequestParam String nacido,
		@RequestParam String password,
		@RequestParam String hm,
		@RequestParam String direccion,
		
		@RequestParam String titulo,
		@RequestParam String articulo) {
		
		model.addAttribute("nombre_form",nombre);
		model.addAttribute("apellidoUno_form",primerApe);
		model.addAttribute("apellidoDos_form",segundoApe);
		model.addAttribute("correo_form",eCorreo);
		model.addAttribute("nacido_form",nacido);
		model.addAttribute("password_form",password);
		model.addAttribute("hm_form",hm);
		model.addAttribute("direccion_form",direccion);
		
		model.addAttribute("titulo_form",titulo);
		model.addAttribute("articulo_form",articulo);
		
		
		return "datosFormulario";
	}
	
}
