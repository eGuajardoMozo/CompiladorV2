/*
	MAGU Maquina Virtual
	Adrián Martínez A01280252
	Estefanía Guajardo A00813202
*/

import java.lang.String;
import javax.swing.*; 
import java.util.*;

public class MaquinaVirtual extends TurtleGraphicsWindow {

	public static String contexto = "global"; // Inicialmente, las variables declaradas son globales.

	public MaquinaVirtual() {
		super( 600, 600 );
	}

	public static void Ejecucion(Vector vector)
	{	
		int returnPoint = 0; // El punto al que regresa cuando termina una función

		// Para cada cuadruplo en el vector
		for (int i=0; i<vector.size(); i++)
		{
			Cuadruplo aux = (Cuadruplo)vector.get(i);
			String operador = aux.getOperador();
			
			switch (operador) {

				// SUMA
				case "+":
					funcTwoParam(aux, "+");
					break;

				// RESTA
				case "-":
					funcTwoParam(aux, "-");
					break;
			
				// MULTIPLICACION
				case "*":
					funcTwoParam(aux, "*");
					break;
			
				// DIVISION
				case "/":
					funcTwoParam(aux, "/");
					break;

				// NOT EQUAL
				case "<>":
					funcTwoParam(aux, "<>");
					break;

				// EQUAL
				case "==":
					funcTwoParam(aux, "==");
					break;

				// LESS THAN
				case "<":
					funcTwoParam(aux, "<");
					break;

				// GREATER THAN
				case ">":
					funcTwoParam(aux, ">");
					break;

				// ASSIGN
				case "=":
					asignacion(aux);
					break;

				// MAIN
				case "main":
					i = jump(aux);
					contexto = "main";

					System.out.println("Contexto: " + contexto);
					break;

				// GOTO
				case "Goto":
					i = jump(aux);
					break;

				// GOTOF
				case "GotoF":
					int bool = Memoria.getValor(contexto, aux.getOperador1());

					//si la condicion si es falsa y se debe hacer el salto
					if (bool == 0) { i = jump(aux); }
					break;

				// GOSUB
				case "gosub":
					returnPoint = i; // El punto a donde va a regresar cuando la función termine es el actual
					i = jump(aux); // Jump al punto marcado por gosub
					contexto = aux.getOperador1(); // El nuevo contexto es el nombre de la función

					System.out.println("Contexto: " + contexto);
					break;

				// ENDPROC
				case "endproc":
					i = returnPoint;
					contexto = "main"; // Cuando la función termina, regresa el contexto a main

					System.out.println("Contexto: " + contexto);
					break;

				// FORWARD
				case "f":
					funcOneParam(aux, "f");
					break;

				// LEFT
				case "l":
					funcOneParam(aux, "l");
					break;

				// RIGHT
				case "r":
					funcOneParam(aux, "r");
					break;

				// PRINT
				case "pr":
					print(aux);
					break;

				// PENCILUP
				case "pu":
					penup();
					break;

				// PENCILDOWN
				case "pd":
					pendown();
					break;

				// HOME
				case "h":
					home();
					break;

				// MOVE
				case "m":
					funcTwoParam(aux, "m");
					break;

				// CURVE
				case "cv":
					funcTwoParam(aux, "cv");
					break;

				// INPUT
				case "in":
					input(aux);
					break;

				// ARR
				case "arr":
					declararArr(aux);
					break;
			}
		}
	}
	
	// Checa si un string es un numero
	public static boolean isNumeric(String str)  
	{  
		try  
		{	  
			double d = Double.parseDouble(str);  
		}  
		catch(NumberFormatException nfe)  
		{  
			return false;  
		}	  
		return true;  
	}


	public static void declararArr(Cuadruplo aux){

		int op2 = getValorOperador(aux.getOperador2());

		// Declarar el arreglo
		Memoria.declararArreglo(aux.getOperador1(), new int [op2]);
	}


	// Para funciones con 2 parametros
	public static void funcTwoParam (Cuadruplo aux, String operador) {

		int resultado, op1, op2;

		String temp = aux.getResultado();
		String str_op1 = aux.getOperador1();
		String str_op2 = aux.getOperador2();

		op1 = getValorOperador(str_op1);
		op2 = getValorOperador(str_op2);


		// Hacer la operación dependiendo del operador mandado como parámetro
		switch(operador) {
			case "+":
				resultado = op1 + op2;
				Memoria.asignarValor(contexto, temp, resultado);
				break;

			case "-":
				resultado = op1 - op2;
				Memoria.asignarValor(contexto, temp, resultado);
				break;

			case "*":
				resultado = op1 * op2;
				Memoria.asignarValor(contexto, temp, resultado);
				break;

			case "/":
				resultado = op1 / op2;
				Memoria.asignarValor(contexto, temp, resultado);
				break;

			case "<>":
				if (op1 != op2) { resultado = 1; } else { resultado = 0; }
				Memoria.asignarValor(contexto, temp, resultado);
				break;

			case "==":
				if (op1 == op2) { resultado = 1; } else { resultado = 0; }
				Memoria.asignarValor(contexto, temp, resultado);
				break;

			case "<":
				if (op1 < op2) { resultado = 1; } else { resultado = 0; }
				Memoria.asignarValor(contexto, temp, resultado);
				break;

			case ">":
				if (op1 > op2) { resultado = 1; } else { resultado = 0; }
				Memoria.asignarValor(contexto, temp, resultado);
				break;

			case "m":
			 	setxy(op1, op2);
			 	break;

			case "cv":
				arc(op1, op2);
			 	break;
		}
	}

	// Para saltos
	public static int jump (Cuadruplo aux) {

		int jumpTo = Integer.parseInt(aux.getResultado());
		return jumpTo - 2;
		
	}

	// Para función de input
	public static void input(Cuadruplo aux) {

		String var = aux.getOperador1(); // El nombre de la variable a la cual se asignará el valor

		// Crea un cuadro de dialogo. El input se guarda en la string s.
		String s = (String)JOptionPane.showInputDialog(
	                null, "Escribe el valor de " + var, "Input", JOptionPane.PLAIN_MESSAGE, null, null, null);

		// Si el campo quedo vacío o se cerró la ventana, mostrar mensaje de error y terminar ejecucion.
		if(s==null || s.trim().isEmpty()) {
			System.out.println("No se dio valor a la variable " + var);
			System.exit(0);
		}
		// De lo contrario..
		else {
			// Si es numérica asignarla, si no marcar error y salir
			if (isNumeric(s)) {
				Memoria.asignarValor(contexto, var,  Integer.parseInt( s ) );
			}
			else {
				System.out.println("Valor invalido");
				System.exit(0);
			}
		}
	}


	// Para funciones con 1 parametro
	public static void funcOneParam (Cuadruplo aux, String operador) {

		int valor = getValorOperador(aux.getOperador1());

		switch (operador) {

			case "f":
				forward(valor);
				break;

			case "l":
				left(valor);
				break;

			case "r":
				right(valor);
				break;
		}	
	}


	// Print
	public static void print (Cuadruplo aux) {

		String str = aux.getOperador1(); // Nombre de la string en la tabla de strings
		Vector stringVector = (Vector) TablaStrings.tablaStrings.get(str);  // El vector correspondiente a esa string
		String s = ""; // String que se usará para el resultado, inicialmente vacia

		// Para cada elemento en el vector
		for (int i=0; i < stringVector.size(); i++) {

			String vectorElement = (String) stringVector.get(i); // Convertir el elemento a string

			// Si el primer caracter son comillas, quitar las comillas y concatenar al resultado
			if ( vectorElement.substring(0,1).equals("\"")   ) {
				s = s + vectorElement.substring(1, vectorElement.length() - 1);
			}
			// Si no, obtener su valor, hacerlo string y concatenarlo
			else {
				s = s + String.valueOf(getValorOperador(vectorElement));
			}
		}

		// Desplegar cuadro de dialogo con el mensaje
		JOptionPane.showMessageDialog(null, s, "Message",JOptionPane.PLAIN_MESSAGE);
	}



	// Dada una string, determina si es numérico, indice de arreglo o variable y regresa su valor
	public static int getValorOperador(String op) {

		int valor, indice;

		// Si el string que se manda es numérico, hacer parse.
		if (isNumeric(op)) {
			valor = Integer.parseInt(op);	
		}
		else if ( op.indexOf("-") != -1) { // Si contiene un -, es indice de arreglo

			int separador = op.indexOf("-");
			String index = op.substring(separador+1); // El indice es todo despues del separador

			op = op.substring(0,separador); // El nombre del arreglo es todo antes del separador

			if (isNumeric(index)) { // Si el indice es numérico, hacer parse
				indice = Integer.parseInt(index);	
			}
			else {
				indice = getValorOperador(index); // Si no, llamar recursivamente
			}

			valor = Memoria.getValorArreglo(op, indice); // Sacar su valor de la tabla
		}
		else { // De lo contrario es variable, sacar el valor
			valor = Memoria.getValor(contexto,op);
		}
		return valor;
	}




	// Asignación de valores
	public static void asignacion (Cuadruplo aux) {

		String temp = aux.getResultado(); // La variable a la cual se va a asignar el valor
		String op1 = aux.getOperador1();
		int valor = getValorOperador(op1); // Valor del primer operador


		if ( !(aux.getOperador2()).equals("") ) { // Si el segundo operador no está vacío la variable es un arreglo.


			int indice = getValorOperador(aux.getOperador2());

			//System.out.println("Se ha encontrado el arreglo " + temp + " con indice " + indice );

			Memoria.asignarValorArreglo(temp, valor, indice); // Asignar valor a ese arreglo en ese indice

			//System.out.println("Despues de la asigncion");
		}
		else { // Si no, está vacío y es variable. Asignarle el valor.
			Memoria.asignarValor(contexto, temp, valor);
		}
	}

}