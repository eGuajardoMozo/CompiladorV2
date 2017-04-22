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

class TablaVariablesLocal 
{
	  
	public static Hashtable tablaLocal = new Hashtable(); 	//Tabla que almacenara los tokens declarados
	public static Hashtable tablaLocalVariables = new Hashtable();
	public static TablaFunciones nombreFunc = new TablaFunciones();
	  
	// Agregar a la tabla de tokens el id que esta siendo declarado junto con su valor, o sobreescribir su valor si ya estaba en la tabla
	public static void asignarValor(Token id, int valor, Token nombre) {	
		Hashtable funcion = nombreFunc.getTable();
		tablaLocal.put(funcion.get(nombre.image), tablaLocalVariables);
		tablaLocalVariables.put(id.image, valor);
		System.out.println("Se ha asignado localmente " + id.image + " = " + getValor(id) + " en funcion " + nombre.image);
	}

	// Asignación de un id a id
	public static void asignarID(Token id, Token id2) {
		// Si el id que se trata de asignar existe
		if(tablaLocal.containsKey(id2.image)) {
			tablaLocal.put(id.image, (Integer)tablaLocal.get(id2.image)); // Asignar el valor de id2 a id
			System.out.println("Se ha asignado " + id.image + " = " + getValor(id));
		}
		else {
			System.out.println("Error: El id " + id2.image + " no ha sido definido \r\nLinea: " + id2.beginLine);
		}
	}

	// Obtener el valor de una variable
	public static int getValor(Token id){
		return (Integer)tablaLocalVariables.get(id.image);
	}
	
	public static String getKey(int value){
		String key = "empty";
		Set set = tablaLocalVariables.entrySet();
		
		Iterator it = set.iterator();
		while (it.hasNext()) {
		Map.Entry entry = (Map.Entry) it.next();
		key = entry.getKey().toString();
		
		}	
		return key;
	}
 }
  
  
  
  
  
  
  