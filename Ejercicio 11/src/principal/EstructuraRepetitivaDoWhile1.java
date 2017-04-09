package principal;
//Se importa la libreria swing que permite mostrar el diálogo de entrada
import javax.swing.*;
/**Se crea una clase pública, es decir que puede ser accedida por cualquier 
otra clase*/
public class EstructuraRepetitivaDoWhile1 {
	/**
	 * Se crea el metodo estático main, necesario para que la aplicación funcione
	 * @param ar, este es el parámetro.
	 */
	public static void main(String[] ar) {
		/**
		 * Se crear una variable entera denominada valor.
		 */
		int valor;
		/**
		 * Se crea una estructura repetitiva que se ejecuta hasta que
		 * la variable valor sea igual a cero.
		 */
		do {
			/**
			 * Se muestra un diálogo por pantalla en el que se recibe una variable
			 * de tipo String, luego se convierte a entero y se le asigna a la
			 * variable valor.
			 */
			valor=Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese un valor entre 0 y 999 (0 finaliza):"));
			/**
			 * Se evalua si la variable valor es mayor o igual a cien para ingresar
			 * a la linea 33
			 */
			if (valor>=100)
			{	//Se imprime por consola el mensaje entre comillas.
				System.out.println("Tiene 3 dígitos.");
			}
			/**
			 * Si la variable valor no es mayor ni igual a cien va a la linea 40 
			 */
			else
			{
				/**
				 * Se evalua si la variable valor es mayor o igual a diez para ingresar
				 * a la linea 33
				 */
				if (valor>=10)
				{
					//Se imprime por consola el mensaje entre comillas.
					System.out.println("Tiene 2 dígitos.");
				}
				/**
				 * Si la variable valor no es mayor ni igual a diez va a la linea 55 
				 */
				else
				{
					//Se imprime por consola el mensaje entre comillas.
					System.out.println("Tiene 1 dígito.");
				}
			}
		/**
		 * Este punto es el final del ciclo do-while, se evalua si la variable valor es
		 * igual a 0, en caso afirmativo se termina la ejecución del ciclo, en caso 
		 * negativo vuelve a empezar desde la linea 26
		 */
		} while (valor!=0);
	}
}
/**
El objetivo del programa es evaluar la cantidad de dígitos de un número ingresado
a través de un diálogo, debe ser menor de tres dígitos, el programa evalua de forma
eronea un número de más de tres dígitos, mostrando el mensaje de la linea 33*/