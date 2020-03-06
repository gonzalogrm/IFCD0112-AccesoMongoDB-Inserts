package com.vipper.presentacion;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.vipper.modelo.Almacen;
import com.vipper.modelo.Producto;
import com.vipper.persistencia.AccesoBBDD;
import com.vipper.persistencia.Conexion;

public class ProbarMongoDB {

	public static void main(String[] args) {
		Conexion c1 = new Conexion();
		
		try {
			c1.conectarCliente();
		} catch (UnknownHostException e) {
			System.out.println(e.toString());
		}

		AccesoBBDD acceso = new AccesoBBDD();	
		List<Producto> list;
		
		/*
		try {
			//Es necesario que haya al menos una inserción para que se muestre la base de datos
			//acceso.insertarDocumentoSimple(p1);
			list = acceso.mostrarTodosProducto();
			Producto.offsetContador(list.size());
			Producto p1;
			
			for (int i = 0; i < 10; i++) {
				p1 = new Producto("Producto_"+Producto.getContador(), 10, 9.5);
				acceso.insertarDocumentoSimple(p1);
			}
			
			list = acceso.mostrarTodosProducto();
			for (Producto p : list) {
				System.out.println(p.toString());
			}
			
		} catch (UnknownHostException e) {
			System.out.println(e.toString());
		}
		*/
	
		/*
		try {
			//Es necesario que haya al menos una inserción para que se muestre la base de datos
			//acceso.insertarDocumentoSimple(p1);
			list = acceso.mostrarTodosProducto();
			Producto.offsetContador(list.size());
			Producto p1;
			Almacen a1;
			
			for (int i = 0; i < 10; i++) {
				p1 = new Producto("Producto_"+Producto.getContador(), 10, 9.5);
				a1 = new Almacen("Almacen_"+i, "Calle_"+i, i, "Poblacion_"+i);
				acceso.insertarDocumentoEmbebido(p1, a1);
			}
			
			list = acceso.mostrarTodosProducto();
			for (Producto p : list) {
				System.out.println(p.toString());
			}
			
		} catch (UnknownHostException e) {
			System.out.println(e.toString());
		}
		*/
		
		try {
			//Es necesario que haya al menos una inserción para que se muestre la base de datos
			//acceso.insertarDocumentoSimple(p1);
			list = acceso.mostrarTodosProducto();
			Producto.offsetContador(list.size());
			Producto p1;
			List<Integer> a1 = Arrays.asList(10, 20, 30, 40);
			
			for (int i = 0; i < 10; i++) {
				p1 = new Producto("Producto_"+Producto.getContador(), 10, 9.5);;
				acceso.insertarDocumentoConArray(p1, a1);
			}
			
			list = acceso.mostrarTodosProducto();
			for (Producto p : list) {
				System.out.println(p.toString());
			}
			
		} catch (UnknownHostException e) {
			System.out.println(e.toString());
		}
		
	}

}
