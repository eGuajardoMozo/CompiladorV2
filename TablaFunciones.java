/*
	MAGU Tabla de variables
	Adrián Martínez A01280252
	Estefanía Guajardo A00813202
*/

import java.util.Hashtable;
import java.lang.String;

class TablaFunciones extends TablaVariables
{
	  
	public static Hashtable tablafunc1 = new Hashtable(); 	//Tabla que almacenara las funciones
	public static Hashtable tablafunc2 = new Hashtable();	//Tabla que almacenara los parametros
	public static TablaVariables tabla = new TablaVariables()	; 
	  
	// Agregar a la tabla de funciones de un parametro el nombre de la funcion, o sobreescribir su valor si ya estaba en la tabla
	public static void asignarFuncionUnParametro(Token id, Token param) {	
		Hashtable variables = tabla.getTable(); 
		tablafunc1.put(id.image, tablafunc2);
		tablafunc2.put(param.image, variables.get(param.image));
		System.out.println("Se guardo la funcion '" + id.image + "' con el parametro '" + param.image + "'");
	}
	
	// Agregar a la tabla de funciones de un parametro el nombre de la funcion, o sobreescribir su valor si ya estaba en la tabla
	public static void asignarFuncionCeroParametros(Token id) {	 
		tablafunc1.put(id.image, 0);
		System.out.println("Se guardo la funcion '" + id.image + "' sin parametros ");
	}
	
	// Agregar a la tabla de funciones de dos parametros el nombre de la funcion, o sobreescribir su valor si ya estaba en la tabla
	public static void asignarFuncionDosParametros(Token id, Token param1, Token param2) {	
		Hashtable variables = tabla.getTable(); 
		tablafunc1.put(id.image, tablafunc2);
		String parametros = param1.image + ", " + param2.image;
		int valorParam1 = (Integer)variables.get(param1.image);
		int valorParam2 = (Integer)variables.get(param2.image);
		//el valor que se le da es la suma de los valores que ya tenian esos parametros
		tablafunc2.put(parametros,  valorParam1 + valorParam2);
		System.out.println("Se guardo la funcion '" + id.image + "' con los parametros '" + parametros + "'");
	}
	
	public Hashtable getTable() {
		return tablafunc1;
	}
 }
  
  