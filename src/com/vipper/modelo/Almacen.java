package com.vipper.modelo;

public class Almacen {
	private String nombre;
	private String calle;
	private int numero;
	private String poblacion;
	
	
	@Override
	public String toString() {
		return "Almacen [nombre=" + nombre + ", calle=" + calle + ", numero=" + numero + ", poblacion=" + poblacion
				+ "]";
	}



	public Almacen(){}

	public Almacen(String nombre, String calle, int numero, String poblacion) {
		this.nombre = nombre;
		this.calle = calle;
		this.numero = numero;
		this.poblacion = poblacion;
	}



	public String getCalle() {
		return calle;
	}


	public void setCalle(String calle) {
		this.calle = calle;
	}


	public int getNumero() {
		return numero;
	}


	public void setNumero(int numero) {
		this.numero = numero;
	}


	public String getPoblacion() {
		return poblacion;
	}


	public void setPoblacion(String poblacion) {
		this.poblacion = poblacion;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
		
	
	
	
	
	
	
}
