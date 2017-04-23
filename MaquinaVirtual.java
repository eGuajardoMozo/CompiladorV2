/*
	MAGU Tabla de variables
	Adrián Martínez A01280252
	Estefanía Guajardo A00813202
*/

import java.lang.String;
import java.util.*;

public class MaquinaVirtual extends TurtleGraphicsWindow{
	
	public static void Ejecucion(Vector vector)
	{	
		for (int i=0; i<vector.size(); i++)
		{
			Cuadruplo aux = (Cuadruplo)vector.get(i);
			
			//SUMA
			if (aux.getOperador() == "+")
			{
				int valor, valor1, valor2;
				String temp = aux.getResultado();
				if (isNumeric(aux.getOperador1()))
				{
					valor1 = Integer.parseInt(aux.getOperador1());
					if (isNumeric(aux.getOperador2()))
					{
						valor2 = Integer.parseInt(aux.getOperador2());
						valor = valor1 + valor2;
						TablaVariables.asignarValor(temp, valor);
					}
					else
					{
						valor2 = TablaVariables.getValor(aux.getOperador2());
						valor = valor1 + valor2;
						TablaVariables.asignarValor(temp, valor);
					}
				}
				else
				{
					valor1 = TablaVariables.getValor(aux.getOperador1());
					if (isNumeric(aux.getOperador2()))
					{
						valor2 = Integer.parseInt(aux.getOperador2());
						valor = valor1 + valor2;
						TablaVariables.asignarValor(temp, valor);
					}
					else
					{
						valor2 = TablaVariables.getValor(aux.getOperador2());
						valor = valor1 + valor2;
						TablaVariables.asignarValor(temp, valor);
					}
				}		
			}
			else if (aux.getOperador() == "-")
			{
				int valor, valor1, valor2;
				String temp = aux.getResultado();
				if (isNumeric(aux.getOperador1()))
				{
					valor1 = Integer.parseInt(aux.getOperador1());
					if (isNumeric(aux.getOperador2()))
					{
						valor2 = Integer.parseInt(aux.getOperador2());
						valor = valor1 - valor2;
						TablaVariables.asignarValor(temp, valor);
					}
					else
					{
						valor2 = TablaVariables.getValor(aux.getOperador2());
						valor = valor1 - valor2;
						TablaVariables.asignarValor(temp, valor);
					}
				}
				else
				{
					valor1 = TablaVariables.getValor(aux.getOperador1());
					if (isNumeric(aux.getOperador2()))
					{
						valor2 = Integer.parseInt(aux.getOperador2());
						valor = valor1 - valor2;
						TablaVariables.asignarValor(temp, valor);
					}
					else
					{
						valor2 = TablaVariables.getValor(aux.getOperador2());
						valor = valor1 - valor2;
						TablaVariables.asignarValor(temp, valor);
					}
				}
			}
			else if (aux.getOperador() == "*")
			{
				int valor, valor1, valor2;
				String temp = aux.getResultado();
				if (isNumeric(aux.getOperador1()))
				{
					valor1 = Integer.parseInt(aux.getOperador1());
					if (isNumeric(aux.getOperador2()))
					{
						valor2 = Integer.parseInt(aux.getOperador2());
						valor = valor1 * valor2;
						TablaVariables.asignarValor(temp, valor);
					}
					else
					{
						valor2 = TablaVariables.getValor(aux.getOperador2());
						valor = valor1 * valor2;
						TablaVariables.asignarValor(temp, valor);
					}
				}
				else
				{
					valor1 = TablaVariables.getValor(aux.getOperador1());
					if (isNumeric(aux.getOperador2()))
					{
						valor2 = Integer.parseInt(aux.getOperador2());
						valor = valor1 * valor2;
						TablaVariables.asignarValor(temp, valor);
					}
					else
					{
						valor2 = TablaVariables.getValor(aux.getOperador2());
						valor = valor1 * valor2;
						TablaVariables.asignarValor(temp, valor);
					}
				}
			}
			else if (aux.getOperador() == "/")
			{
				int valor, valor1, valor2;
				String temp = aux.getResultado();
				if (isNumeric(aux.getOperador1()))
				{
					valor1 = Integer.parseInt(aux.getOperador1());
					if (isNumeric(aux.getOperador2()))
					{
						valor2 = Integer.parseInt(aux.getOperador2());
						valor = valor1 / valor2;
						TablaVariables.asignarValor(temp, valor);
					}
					else
					{
						valor2 = TablaVariables.getValor(aux.getOperador2());
						valor = valor1 / valor2;
						TablaVariables.asignarValor(temp, valor);
					}
				}
				else
				{
					valor1 = TablaVariables.getValor(aux.getOperador1());
					if (isNumeric(aux.getOperador2()))
					{
						valor2 = Integer.parseInt(aux.getOperador2());
						valor = valor1 / valor2;
						TablaVariables.asignarValor(temp, valor);
					}
					else
					{
						valor2 = TablaVariables.getValor(aux.getOperador2());
						valor = valor1 / valor2;
						TablaVariables.asignarValor(temp, valor);
					}
				}
			}
			else if (aux.getOperador() == "Goto")
			{
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
			}
			else if (aux.getOperador() == "GotoF")
			{
				int bool = TablaVariables.getValor(aux.getOperador1());
				//si la condicion si es falsa y se debe hacer el salto
				if (bool == 0)
				{
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
				}
			}
			else if (aux.getOperador() == ">")
			{
				int op1, op2;
				if (isNumeric(aux.getOperador1()))
				{
					op1 = Integer.parseInt(aux.getOperador1());
					if (isNumeric(aux.getOperador2()))
					{
						op2 = Integer.parseInt(aux.getOperador2());
					}
					else
					{
						op2 = TablaVariables.getValor(aux.getOperador2());
					}
				}
				else
				{
					op1 = TablaVariables.getValor(aux.getOperador1());
					if (isNumeric(aux.getOperador2()))
					{
						op2 = Integer.parseInt(aux.getOperador2());
					}
					else
					{
						op2 = TablaVariables.getValor(aux.getOperador2());
					}
				}
					
				//se hace la comparacion para saber si almacenar 0 o 1 en la temporal del resultado
				if (op1 > op2)
				{
					TablaVariables.asignarValor(aux.getResultado(), 1);	
				}
				else if (op1 < op2)
				{
					TablaVariables.asignarValor(aux.getResultado(), 0);	
				}
			}
			
			else if (aux.getOperador() == "<")
			{
				int op1, op2;
				if (isNumeric(aux.getOperador1()))
				{
					op1 = Integer.parseInt(aux.getOperador1());
					if (isNumeric(aux.getOperador2()))
					{
						op2 = Integer.parseInt(aux.getOperador2());
					}
					else
					{
						op2 = TablaVariables.getValor(aux.getOperador2());
					}
				}
				else
				{
					op1 = TablaVariables.getValor(aux.getOperador1());
					if (isNumeric(aux.getOperador2()))
					{
						op2 = Integer.parseInt(aux.getOperador2());
					}
					else
					{
						op2 = TablaVariables.getValor(aux.getOperador2());
					}
				}
					
				//se hace la comparacion para saber si almacenar 0 o 1 en la temporal del resultado
				if (op1 > op2)
				{
					TablaVariables.asignarValor(aux.getResultado(), 1);	
				}
				else if (op1 < op2)
				{
					TablaVariables.asignarValor(aux.getResultado(), 0);	
				}
			}
			
			else if (aux.getOperador() == "=")
			{
				String temp = aux.getResultado();
				if (isNumeric(aux.getOperador1()))
				{
					int valor = Integer.parseInt(aux.getOperador1());
					TablaVariables.asignarValor(temp, valor);
				}
				else
				{
					int valor = TablaVariables.getValor(aux.getOperador1());
					TablaVariables.asignarValor(temp, valor);
				}					
			}
			
			else if (aux.getOperador() == "f")
			{
				int valor;
				if (isNumeric(aux.getOperador1()))
					{
						valor = Integer.parseInt(aux.getOperador1());
						forward(valor);
					}
				else
					{
						valor = TablaVariables.getValor(aux.getOperador1());
						forward(valor);
					}
			}
			
			else if (aux.getOperador() == "l")
			{
				int valor;
				if (isNumeric(aux.getOperador1()))
					{
						valor = Integer.parseInt(aux.getOperador1());
						left(valor);
					}
				else
					{
						valor = TablaVariables.getValor(aux.getOperador1());
						left(valor);
					}
			}
			
			else if (aux.getOperador() == "r")
			{
				int valor;
				if (isNumeric(aux.getOperador1()))
					{
						valor = Integer.parseInt(aux.getOperador1());
						right(valor);
					}
				else
					{
						valor = TablaVariables.getValor(aux.getOperador1());
						right(valor);
					}
			}
			
			else if (aux.getOperador() == "pu")
			{
				penup();
			}
			
			else if (aux.getOperador() == "pd")
			{
				pendown();
			}
			
			else if (aux.getOperador() == "h")
			{
				home();
			}
			
			else if (aux.getOperador() == "m")
			{
				int valor1, valor2;
				if (isNumeric(aux.getOperador1()))
				{
					valor1 = Integer.parseInt(aux.getOperador1());
					if (isNumeric(aux.getOperador2()))
					{
						valor2 = Integer.parseInt(aux.getOperador2());
						setxy(valor1, valor2);
					}
					else
					{
						valor2 = TablaVariables.getValor(aux.getOperador2());
						setxy(valor1, valor2);
					}
				}
				else
				{
					valor1 = TablaVariables.getValor(aux.getOperador1());
					if (isNumeric(aux.getOperador2()))
					{
						valor2 = Integer.parseInt(aux.getOperador2());
						setxy(valor1, valor2);
					}
					else
					{
						valor2 = TablaVariables.getValor(aux.getOperador2());
						setxy(valor1, valor2);
					}
				}	
			}
			
			else if (aux.getOperador() == "cv")
			{
				int valor1, valor2;
				if (isNumeric(aux.getOperador1()))
				{
					valor1 = Integer.parseInt(aux.getOperador1());
					if (isNumeric(aux.getOperador2()))
					{
						valor2 = Integer.parseInt(aux.getOperador2());
						arc(valor1, valor2);
					}
					else
					{
						valor2 = TablaVariables.getValor(aux.getOperador2());
						arc(valor1, valor2);
					}
				}
				else
				{
					valor1 = TablaVariables.getValor(aux.getOperador1());
					if (isNumeric(aux.getOperador2()))
					{
						valor2 = Integer.parseInt(aux.getOperador2());
						arc(valor1, valor2);
					}
					else
					{
						valor2 = TablaVariables.getValor(aux.getOperador2());
						arc(valor1, valor2);
					}
				}	
			}
		}
	}
	
	//checa si un string es un numero
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
}