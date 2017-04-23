/*
	MAGU Tabla de variables
	Adrián Martínez A01280252
	Estefanía Guajardo A00813202
*/

import java.lang.String;
import java.util.*;

public class MaquinaVirtual {
	
	public static void Ejecucion(Vector vector)
	{	
		for (int i=0; i<vector.size(); i++)
		{
			Cuadruplo aux = (Cuadruplo)vector.get(i);
			if (aux.getOperador() == "+")
			{
				System.out.println(Integer.parseInt(aux.getOperador1()) + Integer.parseInt(aux.getOperador2()));
			}
			else if (aux.getOperador() == "-")
			{
				System.out.println(Integer.parseInt(aux.getOperador1()) - Integer.parseInt(aux.getOperador2()));
			}
			else if (aux.getOperador() == "*")
			{
				System.out.println(Integer.parseInt(aux.getOperador1()) * Integer.parseInt(aux.getOperador2()));
			}
			else if (aux.getOperador() == "/")
			{
				System.out.println(Integer.parseInt(aux.getOperador1()) / Integer.parseInt(aux.getOperador2()));
			}
			else if (aux.getOperador() == "Goto")
			{
				int jumpTo = Integer.parseInt(aux.getResultado());
				int temp = 0;
				if (jumpTo > i)
				{
					temp = jumpTo - i;
					i = i + temp;
				}
				else if (jumpTo < i)
				{
					temp = i - jumpTo;
					i = i - temp;
				}
			}
			else if (aux.getOperador() == "GotoF")
			{
				int bool = Integer.parseInt(aux.getOperador1());
				//si la condicion si es falsa y se debe hacer el salto
				if (bool == 0)
				{
					int jumpTo = Integer.parseInt(aux.getResultado());
					int temp = 0;
					if (jumpTo > i)
					{
						temp = jumpTo - i;
						i = i + temp;
					}
					else if (jumpTo < i)
					{
						temp = i - jumpTo;
						i = i - temp;
					}
				}
			}
			else if (aux.getOperador() == ">")
			{
				//se hace la comparacion para saber si almacenar 0 o 1 en la temporal del resultado
				int op1 = Integer.parseInt(aux.getOperador1());
				int op2 = Integer.parseInt(aux.getOperador2());
				
				if (op1 > op2)
				{
					//EN LA TABLA DE VARIABLES CORRESPONDIENTE METER EL VALOR DE 1		
				}
				else if (op1 < op2)
				{
					//EN LA TABLA DE VARIABLES CORRESPONDIENTE METER EL VALOR DE 0
				}
			}
			
			else if (aux.getOperador() == "<")
			{
				//se hace la comparacion para saber si almacenar 0 o 1 en la temporal del resultado
				int op1 = Integer.parseInt(aux.getOperador1());
				int op2 = Integer.parseInt(aux.getOperador2());
				
				if (op1 < op2)
				{
					//EN LA TABLA DE VARIABLES CORRESPONDIENTE METER EL VALOR DE 1		
				}
				else if (op1 > op2)
				{
					//EN LA TABLA DE VARIABLES CORRESPONDIENTE METER EL VALOR DE 0
				}
			}
			
			else if (aux.getOperador() == "=")
			{
				//ALMACENAR EN TABLA DE VARIABLES RESULTADO
			}
		}
	}
}