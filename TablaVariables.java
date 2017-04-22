/*
	MAGU Tabla de variables
	Adrián Martínez A01280252
	Estefanía Guajardo A00813202
*/

import java.util.Hashtable;
import java.lang.String;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

class TablaVariables
{
	  
	public static Hashtable tabla = new Hashtable(); 	//Tabla que almacenara los tokens declarados
	public static Hashtable tablaArr = new Hashtable();
	  
	// Agregar a la tabla de tokens el id que esta siendo declarado junto con su valor, o sobreescribir su valor si ya estaba en la tabla
	public static void asignarValor(Token id, int valor) {	
		tabla.put(id.image, valor);
		System.out.println("Se ha asignado " + id.image + " = " + getValor(id));
	}


	// Agregar un nuevo arreglo a la tabla de arreglos. Su id es la key y el arreglo mandado como parametro es su valor
	public static void declararArreglo(Token id, int[] arr) {	
		tablaArr.put(id.image, arr);
		System.out.println("Se ha agregado el arreglo " + id.image);
	}

	// Se asigna un valor a un arreglo dado su indice
	public static void asignarValorArreglo(Token id, int valor, int indice) {	
		int[] arreglo = (int[])tablaArr.get(id.image);
		arreglo[indice] = valor;
		System.out.println("Se ha asignado " + id.image + "[" + indice + "] = " + getValorArreglo(id,indice));
	}


	// Se obtiene el valor de un arreglo dado su indice
	public static int getValorArreglo(Token id, int indice){
		int[] arreglo = (int[])tablaArr.get(id.image);
		return arreglo[indice];
	}

	// Asignación de un id a id
	public static void asignarID(Token id, Token id2) {
		// Si el id que se trata de asignar existe
		if(tabla.containsKey(id2.image)) {
			tabla.put(id.image, (Integer)tabla.get(id2.image)); // Asignar el valor de id2 a id
			System.out.println("Se ha asignado " + id.image + " = " + getValor(id));
		}
		else {
			System.out.println("Error: El id " + id2.image + " no ha sido definido \r\nLinea: " + id2.beginLine);
		}
	}

	// Obtener el valor de una variable
	public static int getValor(Token id){
		return (Integer)tabla.get(id.image);	
	}

	public Hashtable getTable() {
		return tabla;
	}
	
	public static String getKey(int value){
		String key = "empty";
		Set set = tabla.entrySet();
		
		Iterator it = set.iterator();
		while (it.hasNext()) {
		Map.Entry entry = (Map.Entry) it.next();
		key = entry.getKey().toString();
		
		}	
		return key;
	}
 }
  
  
  
  
  
  
  