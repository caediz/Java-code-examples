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
			
			BufferedReader bufferReader = new BufferedReader(new InputStreamReader(System.in));
			
			
			System.out.print("Por favor digite el valor correspondiente a los gastos del lunes o" +
					" \"Terminar\" para terminar la ejecución del programa y \n borrar el total de la RAM: ");
			String inputMonday = bufferReader.readLine();
			
			if(inputMonday.equalsIgnoreCase("Terminar")){
				System.out.println("Finalizando la ejecución");
				System.exit(0);
			}
			
			System.out.print("Por favor digite el valor correspondiente a los gastos del martes o" +
					" \"Terminar\" para terminar la ejecución del programa y \n borrar el total de la RAM: ");
			String inputTuesday = bufferReader.readLine();
			
			if(inputTuesday.equalsIgnoreCase("Terminar")){
				System.out.println("Finalizando la ejecución");
				System.exit(0);
			}
			
			System.out.print("Por favor digite el valor correspondiente a los gastos del lunes o" +
					" \"Terminar\" para terminar la ejecución del programa y \n borrar el total de la RAM: ");
			String inputWensday = bufferReader.readLine();
			
			if(inputWensday.equalsIgnoreCase("Terminar")){
				System.out.println("Finalizando la ejecución");
				System.exit(0);
			}
			
			System.out.print("Por favor digite el valor correspondiente a los gastos del lunes o" +
					" \"Terminar\" para terminar la ejecución del programa y \n borrar el total de la RAM: ");
			String inputThursday = bufferReader.readLine();
			
			if(inputThursday.equalsIgnoreCase("Terminar")){
				System.out.println("Finalizando la ejecución");
				System.exit(0);
			}
			
			System.out.print("Por favor digite el valor correspondiente a los gastos del lunes o" +
					" \"Terminar\" para terminar la ejecución del programa y \n borrar el total de la RAM: ");
			String inputFriday = bufferReader.readLine();
			
			if(inputFriday.equalsIgnoreCase("Terminar")){
				System.out.println("Finalizando la ejecución");
				System.exit(0);
			}
			
			total = Double.valueOf(inputMonday)+Double.valueOf(inputTuesday)+
					Double.valueOf(inputWensday)+Double.valueOf(inputThursday)+Double.valueOf(inputFriday);
			
			System.out.println("Los gastos totales causados en los 5 días laborales es:"+total +"\n \n");
			
		}while(!exit);
		System.exit(0);
	}
	
}
