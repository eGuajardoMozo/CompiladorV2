/*
	MAGU Tabla de variables
	Adrián Martínez A01280252
	Estefanía Guajardo A00813202
*/

import java.lang.String;

public class Cuadruplo {

	public String operador, oper1, oper2, resultado;

	// Constructor sin parametros
	public Cuadruplo() {
		operador = "";
		oper1 = "";
		oper2 = "";
		resultado = "";
	}

	// Constructor
	public Cuadruplo(String o, String op1, String op2, String r) {
		operador = o;
		oper1 = op1;
		oper2 = op2;
		resultado = r;
	}

	public static void displayCuadruplo(Cuadruplo cuadruplo) {
	System.out.println( cuadruplo.operador + "  \t" + cuadruplo.oper1 + "  \t" + cuadruplo.oper2 + "  \t" + cuadruplo.resultado );
	}

	public static String returnCuadruplo(Cuadruplo cuadruplo) {
		return cuadruplo.operador + "$" + cuadruplo.oper1 + "$" + cuadruplo.oper2 + "$" + cuadruplo.resultado;
	}
	
	public String getOperador()
	{
		return operador;
	}
	
	public String getOperador1()
	{
		return oper1;
	}
	
	public String getOperador2()
	{
		return oper2;
	}
	
	public String getResultado()
	{
		return resultado;
	}

}
