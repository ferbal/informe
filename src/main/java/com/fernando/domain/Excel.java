package com.fernando.domain;

public class Excel {
	
	private String nombreArchivo;
	private String pathArchivo;
	
	public void setNombreArchivo(String nombre){
		this.nombreArchivo = nombre;
	}
	
	public void setPathArchivo(String path){
		this.pathArchivo = path;
	}
	
	public String getNombreArchivo(){
		return this.nombreArchivo;
	}
	
	public String getPathArchivo(){
		return this.pathArchivo;
	}
}
