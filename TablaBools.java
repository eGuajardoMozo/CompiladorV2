/*
	MAGU Tabla de variables
	Adrián Martínez A01280252
	Estefanía Guajardo A00813202
*/

import java.util.Hashtable;
import java.lang.String;

class TablaBools 
{  
	public static Hashtable tBools = new Hashtable(); 	//Tabla que almacenara los valores de las exp en un bool
	  
	// Agregar a la tabla de tokens el id que esta siendo declarado junto con su valor, o sobreescribir su valor si ya estaba en la tabla
	public static void asignarValor(String id, int valor) {	
		tBools.put(id, valor);
	}
	
	public static int getValor(String id){
		return (Integer)tBools.get(id);
	}
 }
  
  
  
  
  
  
  