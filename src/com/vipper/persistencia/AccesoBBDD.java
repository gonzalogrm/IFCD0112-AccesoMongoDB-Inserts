package com.vipper.persistencia;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.WriteResult;
import com.vipper.modelo.Almacen;
import com.vipper.modelo.Producto;

public class AccesoBBDD extends Conexion {
	//Atributos
	public DBCollection collection;
	
	public void insertarDocumentoSimple(Producto p) throws UnknownHostException {
		//Declaramos variables
		BasicDBObject documentoSimple = new BasicDBObject();
		
		//Conectamos al cliente, y obtenemos la db
		conectarCliente();
		
		//Si no existe la coleccion en la db, se crea la colleción
		collection = db.getCollection("productos");
		
		//Asignar valores al documento
		documentoSimple.put("_id", (int)collection.count());
		documentoSimple.put("nombre", p.getNombre());
		documentoSimple.put("cantidad", p.getCantidad());
		documentoSimple.put("precio", p.getPrecio());
		
		//Insertar el documento en la colecióm
		
		WriteResult resultado = null;
		try {
			resultado = collection.insert(documentoSimple);
		} catch (Exception e) {
			System.out.println("Error: " + e.toString());
			System.out.println("Resultado toString(): " + resultado.toString());			
		}

	
		//Desconectamos
		desconectarCliente();
	}
	
	public void insertarDocumentoEmbebido(Producto p, Almacen a) throws UnknownHostException {
		//Declaramos variables
		BasicDBObject documentoSimple = new BasicDBObject();
		BasicDBObject documentoEmbebido = new BasicDBObject();
		
		//Conectamos al cliente, y obtenemos la db
		conectarCliente();
		
		//Si no existe la coleccion en la db, se crea la colleción
		collection = db.getCollection("productos");
		
		//Asignar valores al documento
		documentoSimple.put("_id", (int)collection.count());
		documentoSimple.put("nombre", p.getNombre());
		documentoSimple.put("cantidad", p.getCantidad());
		documentoSimple.put("precio", p.getPrecio());
		
		//Documento embebido
		documentoEmbebido.put("nombre", a.getNombre());
		documentoEmbebido.put("calle", a.getCalle());
		documentoEmbebido.put("numero", a.getNumero());
		documentoEmbebido.put("poblacion", a.getPoblacion());
		
		//Añadimos el embebido al simple
		documentoSimple.put("almacen", documentoEmbebido);
		
		//Insertar el documento en la coleción
		
		WriteResult resultado = null;
		try {
			resultado = collection.insert(documentoSimple);
		} catch (Exception e) {
			System.out.println("Error: " + e.toString());
			System.out.println("Resultado toString(): " + resultado.toString());			
		}

		//Desconectamos
		desconectarCliente();
	}
	
	
	
	
	public List<Producto> mostrarTodosProducto() throws UnknownHostException{
		//3. Definción de variables
		List<Producto> result = new ArrayList<Producto>();
		DBCursor rs; //Obtiene los resultados de la coleccion, similar al ResultSet
		BasicDBObject documentoJSON;
		
		//2. Abrir Conexion - Conectarse al cliente
		conectarCliente();
		
		//3. Obtener la colección
		collection = db.getCollection("productos");
		System.out.println("Obtiene la coleción " + collection.getFullName());
		System.out.println("Contiene " + collection.count() + " documentos");
		
		
		//4. Obtener todos los documentos de la coleccion
		rs = collection.find();
		
		//5. Bucle para obtener los documentos
		while (rs.hasNext()) {
			documentoJSON = (BasicDBObject) rs.next();
			result.add(
				//int idproducto, String nombre, int cantidad, double precio
				new Producto(
					documentoJSON.getInt("_id"), 
				    documentoJSON.getString("nombre"), 
				    documentoJSON.getInt("cantidad"), 
				    documentoJSON.getDouble("precio")
			    )
			);
		}
		
		//6. Cerrar cliente
		desconectarCliente();
		
		return result;
	}

	/* 
	public List<Persona> mostrarMayoresX(int x) throws UnknownHostException{
		//3. Definción de variables
		List<Persona> result = new ArrayList<Persona>();
		DBCursor rs; //Obtiene los resultados de la coleccion, similar al ResultSet
		BasicDBObject documentoJSON;
		
		//2. Abrir Conexion - Conectarse al cliente
		abrirConexion();
		
		//3. Obtener la colección
		detalle = db.getCollection("detalle");
		System.out.println("Obtiene la coleción " + detalle.getFullName());
		System.out.println("Contiene " + detalle.count() + " documentos");
		
		
		//4. Obtener todos los documentos de la coleccion
		//Usamos un new BasicDBObject("$gt", 35) porque es un nuevo key value tipo BSON, 
		//Si fuese un literal quedaria: BasicDBObject query = new BasicDBObject("age", 35);
		BasicDBObject query = new BasicDBObject("age", new BasicDBObject("$gt", x));
		System.out.println("query: " + query.toString());
		rs = detalle.find(query);
		
		//5. Bucle para obtener los documentos
		while (rs.hasNext()) {
			documentoJSON = (BasicDBObject) rs.next();
			result.add(
				new Persona(
					documentoJSON.getString("_id"), 
				    documentoJSON.getString("name"), 
				    documentoJSON.getInt("age"), 
				    documentoJSON.getString("email"), 
				    documentoJSON.getString("gender"),  
				    documentoJSON.getString("company"), 
				    documentoJSON.getString("phone")
			    )
			);
		}
		
		//6. Cerrar cliente
		cerrarConexion();
		
		return result;
	}

	*/
}
