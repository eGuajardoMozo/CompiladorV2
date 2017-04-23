/*
	MAGU Tabla de strings
	Adrián Martínez A01280252
	Estefanía Guajardo A00813202
*/

import java.util.*;
import java.lang.String;

class TablaStrings
{
	public static Hashtable tablaStrings = new Hashtable(); // Tabla que almacena las strings

	// Método para agregar un nuevo vector de strings a la tabla
	public static void addString(String strName, Vector stringVector) {
		tablaStrings.put(strName, stringVector);
	}

	// Método para desplegar el vector de strings correspondiente al nombre de la string mandado
	public static void displayStringVector(String str) {

		Vector stringVector = (Vector) tablaStrings.get(str);
		
		System.out.print(str + ": ");

		for (int i=0; i < stringVector.size(); i++) {
			System.out.print( stringVector.get(i) + " ");
		}

		System.out.println("");
	}


}