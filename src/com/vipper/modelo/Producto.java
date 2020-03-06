package com.vipper.modelo;

import java.io.Serializable;

public class Producto implements Serializable{
	//Atributos
	private static int contador = 0;
	private int idproducto;
	private String nombre;
	private int cantidad;
	private double precio;	
		
	//Metodos
	@Override
	public String toString() {
		return "Producto [idproducto=" + idproducto + ", nombre=" + nombre + ", cantidad=" + cantidad + ", precio="
				+ precio + "]";
	}
	
	public static int offsetContador(int initial){
		contador = initial;
		return contador;
	}
	
	public int nextContador(){
		return ++contador;
	}
	
	
	//Constructor
	public Producto() { }
	
	public Producto(int idproducto, String nombre, int cantidad, double precio) {
		this.idproducto = idproducto;
		this.nombre = nombre;
		this.cantidad = cantidad;
		this.precio = precio;
	}

	/*
	public Producto(String nombre, int cantidad, double precio) {
		this.idproducto = nextContador();
		this.nombre = nombre;
		this.cantidad = cantidad;
		this.precio = precio;
	}
	*/
	
	public Producto(String nombre, int cantidad, double precio) {
		this.nombre = nombre;
		this.cantidad = cantidad;
		this.precio = precio;
		nextContador();
	}
	
	
	//Getters y Setters
	public static int getContador() {
		return contador;
	}

	public int getIdproducto() {
		return idproducto;
	}

	public void setIdproducto(int idproducto) {
		this.idproducto = idproducto;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}
}
