package com.fernando.spring;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.fernando.domain.Persona;

@Controller
public class RegistrarController {

	@RequestMapping("/irRegistrar")
	ModelAndView redireccion(){
		return new ModelAndView("registro","command",new Persona());
	}
	
	@RequestMapping("/irRegistrar"), method = {RequestMethod.GET;RequestMethod.POST}
	public String registrar(Persona per, ModelMap model){
		model.addAttribute("nombre", per.getNombre());
		model.addAttribute("apellido", per.getApellido());
		
		return "saludo";
	}
	
	
}
