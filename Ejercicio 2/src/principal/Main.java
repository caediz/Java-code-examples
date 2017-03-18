package principal;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Main {

	public static void main(String[] args)throws Exception {
		boolean exit = false;
		Double total = 0.0;
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		Date dateobj = new Date();
		do {
			System.out.print("Por favor digite el valor de la venta o escriba" +
					" \"Terminar\" para terminar la ejecución del programa y \n borrar el total de la RAM: ");
			BufferedReader bufferReader = new BufferedReader(new InputStreamReader(System.in));
			String input = bufferReader.readLine();
			if(!input.equalsIgnoreCase("Terminar")){
				Double sale = Double.valueOf(input);
				total = total+sale;
				System.out.println("El total de ventas del día " +df.format(dateobj)+" es de: $ " + total);
			}else{
				exit = true;
			}
		}while(!exit);
		System.exit(0);
	}
	
}
