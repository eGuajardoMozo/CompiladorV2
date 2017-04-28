/*
	MAGU Memoria
	Adrián Martínez A01280252
	Estefanía Guajardo A00813202

	Guarda los distintos contextos locales y globales y sus tablas de variables correspondientes
*/

import java.util.Hashtable;
import java.lang.String;

class Memoria //extends TablaVariables
{
	public static Hashtable contextos = new Hashtable(); // Tabla que almacena los contextos: cada función de usuario, main y global.

	// Agrega una nueva función a la tabla y le asigna una tabla de variables locales
	public static void addFunc(String funcName) {
		Hashtable varLocales = new Hashtable();
		contextos.put(funcName, varLocales);
	}

	// Define para la función dada el cuadruplo donde inicia
	public static void setFuncStart(String funcName, int quadCounter){
		Hashtable varLocales = (Hashtable) contextos.get(funcName);
		varLocales.put( "funcStart" ,  quadCounter );
	}

	// Regresa el cuadruplo donde inicia la función
	public static int getFuncStart(String funcName){
		Hashtable varLocales = (Hashtable) contextos.get(funcName);
		int start = (Integer) varLocales.get("funcStart");
		return start;
	}

	// Dado un contexto, un id y un valor, crea la variable correspondiente o la sobreescribe si ya existía
	public static void asignarValor(String contexto, String id, int valor) {

		Hashtable varLocales = (Hashtable) contextos.get(contexto); // Tabla de variables de la función o contexto
		varLocales.put( id, valor ); // Dentro de la tabla, asigna el valor al id correspondiente

		System.out.println("Se ha asignado " + id + " = " +  (Integer) varLocales.get(id) +
			" en el contexto " + contexto);
	}

	// Agregar un nuevo arreglo a la tabla de variables. Su id es la key y el arreglo mandado como parametro es su valor
	public static void declararArreglo(String id, int[] arr) {	

		Hashtable varLocales = (Hashtable) contextos.get("global"); // Todos los arreglos estan en la tabla global

		varLocales.put(id, arr);
		System.out.println("Se ha agregado el arreglo " + id);
	}

	// Dado un contexto, un id de arreglo, un valor y un indice, asigna o sobreescribe el valor en ese indice
	public static void asignarValorArreglo(String id, int valor, int indice) {
		
		Hashtable varLocales = (Hashtable) contextos.get("global"); // Tabla de variables de la función o contexto

		int[] arreglo = (int[])varLocales.get(id); // Arreglo correspondiente al id mandado como parámetro
		arreglo[indice] = valor; // Asigna el valor al indice del arreglo correspondiente
		
		System.out.println("Se ha asignado " + id + "[" + indice + "] = " + getValorArreglo(id, indice));
	}

	// Se obtiene el valor de un arreglo dado su indice
	public static int getValorArreglo(String id, int indice){
		Hashtable varLocales = (Hashtable) contextos.get("global");

		int[] arreglo = (int[])varLocales.get(id);
		return arreglo[indice];
	}

	// Obtener el valor de una variable. Primero busca en el contexto local y si no existe checa en el global.
	public static int getValor(String contexto, String id){

		Hashtable varLocales = (Hashtable) contextos.get(contexto); // Tabla de variables de la función o contexto

		if(varLocales.containsKey(id)) { // Si la variable cuyo valor se quiere obtener existe en este contexto...
			return (Integer)varLocales.get(id);	// Regresar su valor
		}
		else { // Si no está en las locales

			Hashtable varGlobales = (Hashtable) contextos.get("global"); // Buscar en las variables globales

			if(varGlobales.containsKey(id)) { // Si la variable existe en las variables globales...
				return (Integer)varGlobales.get(id);	// Regresar su valor
			}
			else { // Si tampoco existe, mostrar error y terminar la ejecución del programa
				System.out.println("ERROR: La variable " + id + " no existe");
				System.exit(0);

				return 0;
			}
		}
	}



	
 }
  
  