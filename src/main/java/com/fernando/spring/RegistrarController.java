package com.fernando.spring;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.fernando.domain.Excel;
import com.fernando.domain.Persona;

@Controller
public class RegistrarController {

	@RequestMapping("/irRegistrar")
	ModelAndView redireccion(){
		return new ModelAndView("registro","command",new Persona());
	}
	
	@RequestMapping(value = "/irRegistrar", method = {RequestMethod.GET , RequestMethod.POST})
	public String registrar(Persona per, ModelMap model){
		model.addAttribute("nombre", per.getNombre());
		model.addAttribute("apellido", per.getApellido());
		
		return "saludo";
	}
	
	@RequestMapping("/irFormulario")
	public ModelAndView irFormulario(){
		return new ModelAndView("formulario","command",new Persona());
	}
	
	@RequestMapping(value = "/agregar", method = {RequestMethod.GET , RequestMethod.POST})
	public String agregar(Persona per, ModelMap model){
		model.addAttribute("nombreModel", per.getNombre());
		model.addAttribute("apellidoModel", per.getApellido());
		
		return "exito";
	}
	
	@RequestMapping("/irExcel")
	public ModelAndView irExcel(){
		return new ModelAndView("Excel","command",new Excel());
	}
	
	@RequestMapping(value = "/AbrirArchivo", method = {RequestMethod.GET , RequestMethod.POST})
	public String AbrirArchivo(Excel file, ModelMap model){
		model.addAttribute("nombreModel", file.getNombreArchivo());
		model.addAttribute("pathModel", file.getPathArchivo());
		
		ExcelAcceso EA = new ExcelAcceso();
		
		//EA.openFile(file.getPathArchivo()+"'\'"+file.getNombreArchivo());
		
		EA.openFile("C:\\Users\\ballarinife\\Desktop\\Suma.xlsm");
		
		return "exito";
	}
}
