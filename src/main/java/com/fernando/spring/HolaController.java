package com.fernando.spring;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HolaController {

	@RequestMapping("irHola")
	public ModelAndView redireccion(){
		ModelAndView MV = new ModelAndView();
		
		//VISTA A RESOLVER
		MV.setViewName("Hola");
		
		MV.addObject("mensaje", "Hola, Soy Fernando");
		return MV;
	}
}
