/*
	MAGU Maquina Virtual
	Adrián Martínez A01280252
	Estefanía Guajardo A00813202
*/

import java.lang.String;
import javax.swing.*; 
import java.util.*;

public class MaquinaVirtual extends TurtleGraphicsWindow {

	public MaquinaVirtual() {
		super( 600, 600 );
	}

	public static void Ejecucion(Vector vector)
	{	
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

				// GOTO
				case "Goto":
					i = jump(aux, i);
					break;

				// GOTOF
				case "GotoF":
					int bool = TablaVariables.getValor(aux.getOperador1());

					//si la condicion si es falsa y se debe hacer el salto
					if (bool == 0)
					{
						i = jump(aux, i);
					}
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


	// Para funciones con 2 parametros
	public static void funcTwoParam (Cuadruplo aux, String operador) {

		int resultado, op1, op2;
		String temp = aux.getResultado();

		// Si el primer operador es constante
		if (isNumeric(aux.getOperador1()))
		{
			op1 = Integer.parseInt(aux.getOperador1());

			// Si el segundo operador es constante
			if (isNumeric(aux.getOperador2()))
			{
				op2 = Integer.parseInt(aux.getOperador2());
			}

			// Si el segundo es variable
			else
			{
				op2 = TablaVariables.getValor(aux.getOperador2());
			}
		}

		// Si el primer operador es variable
		else
		{
			op1 = TablaVariables.getValor(aux.getOperador1());

			// Si el segundo es constante
			if (isNumeric(aux.getOperador2()))
			{
				op2 = Integer.parseInt(aux.getOperador2());
			}

			// Si el segundo es variable
			else
			{
				op2 = TablaVariables.getValor(aux.getOperador2());
			}
		}

		// Hacer la operación dependiendo del operador mandado como parámetro
		switch(operador) {
			case "+":
				resultado = op1 + op2;
				TablaVariables.asignarValor(temp, resultado);
				break;

			case "-":
				resultado = op1 - op2;
				TablaVariables.asignarValor(temp, resultado);
				break;

			case "*":
				resultado = op1 * op2;
				TablaVariables.asignarValor(temp, resultado);
				break;

			case "/":
				resultado = op1 / op2;
				TablaVariables.asignarValor(temp, resultado);
				break;

			case "<>":
				if (op1 != op2) { resultado = 1; } else { resultado = 0; }
				TablaVariables.asignarValor(temp, resultado);
				break;

			case "==":
				if (op1 == op2) { resultado = 1; } else { resultado = 0; }
				TablaVariables.asignarValor(temp, resultado);
				break;

			case "<":
				if (op1 < op2) { resultado = 1; } else { resultado = 0; }
				TablaVariables.asignarValor(temp, resultado);
				break;

			case ">":
				if (op1 > op2) { resultado = 1; } else { resultado = 0; }
				TablaVariables.asignarValor(temp, resultado);
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
	public static int jump (Cuadruplo aux, int i) {

		int jumpTo = Integer.parseInt(aux.getResultado());
		int temp = 0;

		if (jumpTo > i)
		{
			temp = (jumpTo - i) - 1;
			i = (i + temp) - 1;
		}
		else if (jumpTo < i)
		{
			temp = (i - jumpTo) - 1;
			i = (i - temp) - 1;
		}

		return i;
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
				TablaVariables.asignarValor(var,  Integer.parseInt( s ) );
			}
			else {
				System.out.println("Valor invalido");
				System.exit(0);
			}
		}
	}


	// Para funciones con 1 parametro
	public static void funcOneParam (Cuadruplo aux, String operador) {
		int valor;
		String op1;

		if (isNumeric(aux.getOperador1())) { valor = Integer.parseInt(aux.getOperador1()); }
		else { valor = TablaVariables.getValor(aux.getOperador1()); }

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

			case "pr":
			
				break;
		}	
	}

	// Asignación de valores
	public static void asignacion (Cuadruplo aux) {

		int valor;

		//ALMACENAR EN TABLA DE VARIABLES RESULTADO
		String temp = aux.getResultado();
		if (isNumeric(aux.getOperador1())) {
			valor = Integer.parseInt(aux.getOperador1());	
		}
		else {
			valor = TablaVariables.getValor(aux.getOperador1());
		}

		TablaVariables.asignarValor(temp, valor);
	}

}