/*
	MAGU Tabla de variables
	Adrián Martínez A01280252
	Estefanía Guajardo A00813202
*/

import java.lang.String;

public class Cuadruplo {

	public Token operador, oper1, oper2, resultado;

	// Constructor sin parametros
	public Cuadruplo() {
	}

	// Constructor
	public Cuadruplo(Token o, Token op1, Token op2, Token r) {
		operador = o;
		oper1 = op1;
		oper2 = op2;
		resultado = r;
	}

	public static void displayCuadruplo(Cuadruplo cuadruplo) {
		System.out.println( cuadruplo.operador + " " + cuadruplo.oper1 + " " + cuadruplo.oper2 + " " + cuadruplo.resultado );
	}

}
