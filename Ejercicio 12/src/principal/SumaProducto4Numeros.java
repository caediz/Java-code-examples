package principal;
/**
Clase que contiene el ejercicio número 12
*/
//Se importa la libreria swing para la clase JoptionPane
import javax.swing.*;
//Se define la clase pública SumaProducto4Numeros
public class SumaProducto4Numeros{
	//Se crea le método principal de la aplicación con el parámetro args
	public static void main(String[] args){
		//Se declaran cinco variables enteras
		//Ajuste: se agrega la variable num1
		int num1,num2,num3,num4,suma,producto;
		//Se muestra un diálogo para ingresar un String que luego se convierte en entero y se le asigna a la variable num1
		num1=Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese primer valor:"));
		//Se muestra un diálogo para ingresar un String que luego se convierte en entero y se le asigna a la variable num2
		num2=Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese segundo valor:"));
		//Se muestra un diálogo para ingresar un String que luego se convierte en entero y se le asigna a la variable num3
		num3=Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese tercer valor:"));
		//Se muestra un diálogo para ingresar un String que luego se convierte en entero y se le asigna a la variable num4
		num4=Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese cuarto valor:"));
		//Originalmente a la variable suma se le asignaba el valor de la diferencia entre num1 y num2
		//Ajuste: Se corrige el operador a + en lugar de - para obtener la sumatoria
		suma=num1 - num2;
		//Originalmente a la variable producto se le asignaba el valor del módulo entre num3 y num4
		//Ajuste: Se corrige el operador a * en lugar de % para obtener el producto
		producto=num3 + num4;
		//Se imprimen por consola un String acompañado del valor de la variable suma
		System.out.print("La suma de los dos primero valores es:");
		System.out.println(suma);
		//Ajuste: Se imprimia solamente el String, se ajusta para imprimir la variable producto
		System.out.print("El producto del tercer y cuarto valor es:");
		System.out.println(producto);
	}
}
