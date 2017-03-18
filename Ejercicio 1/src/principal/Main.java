package principal;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args)throws Exception {
		boolean exit = false;
		do {
			System.out.print("Por favor digite el valor del producto o escriba" +
					" \"Terminar\" para terminar la ejecución del programa: ");
			BufferedReader bufferReader = new BufferedReader(new InputStreamReader(System.in));
			String input = bufferReader.readLine();
			if(!input.equalsIgnoreCase("Terminar")){
				String IVA = String.valueOf(Double.valueOf(input)*0.19);
				String withOutIVA = String.valueOf(Double.valueOf(input));
				String withIVA = String.valueOf(Double.valueOf(input)+Double.valueOf(input)*0.19);
				System.out.println("El IVA es de: $" + IVA);
				System.out.println("El valor del producto sin IVA es de: $" + withOutIVA);
				System.out.println("El valor del producto con IVA es de: $" + withIVA);
			}else{
				exit = true;
			}
		}while(!exit);
		System.exit(0);
	}
	
}
