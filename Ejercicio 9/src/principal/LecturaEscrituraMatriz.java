/**
 * Cada estudiante debe analizar el código que se le brinda enfocado a vectores; cada línea debe ser comentada
y de forma general explicar qué hace el programa, qué función cumple cada Ciclo for y para qué se utiliza el
math.abs dentro del algoritmo.
 */

package principal;
//Se importan las librerias necesarias.
//util es una libreria de utilidades usada en la función Random().
import java.util.*;
//swing es una libreria de interfaz gráfica usada para mostrar los diálogos.
import javax.swing.*;

//Se define la clase principal.
class LecturaEscrituraMatriz
{	//Se define el método main, necesario para ejecutar la aplicación.
	public static void main(String[] args)
	{	
		//Se muestra un diálogo de entrada para las filas. 
		int filas=Integer.parseInt(JOptionPane.showInputDialog(null,"Digite las Filas: "));
		//Se muestra un diálogo de entrada para las columnas. 
		int columnas=Integer.parseInt(JOptionPane.showInputDialog(null,"Digite las columnas: "));
		//Se definen dos indices enteros i y j.
		int i,j;
		//Se crea un generador de números seudoaleatorios r.	
		Random r=new Random();
		//Se define una matriz con los valores ingresados en los diálogos.
		int A[][]=new int[filas][columnas];
		//Lectura()
		//Recorre la matriz
		for(i=0;i<filas;i++)
			for(j=0;j<columnas;j++)
				//Asigna a cada elmento de la matriz el valor absoluto de 1 más
				//el módulo obtenido entre un entero aleatorio y 99 
				A[i][j]=Math.abs(r.nextInt()%99+1);
		//Escritura
		//Se recorre de nuevo la matriz para imprimirla por consola
		System.out.println(" ------ Matriz Leida -------");
		for(i=0;i<filas;i++)
		{
			System.out.println();
			for(j=0;j<columnas;j++)
			{
				if(A[i][j]>=10)
					System.out.print(A[i][j]+" ");
				else
					System.out.print(A[i][j]+" ");
			}
		}
		System.out.println();
		//Se termina la ejecución del programa con código 0 que indica que el programa finalizo de manera exitosa.
		System.exit(0);
	}
}