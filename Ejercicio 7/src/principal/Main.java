package principal;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args)throws Exception {
		boolean exit = false;
		do {
			System.out.print("Por favor digite el apellido 1 \n" +
					"O escriba\"Terminar\" para terminar la ejecución del programa: ");
			BufferedReader bufferReader = new BufferedReader(new InputStreamReader(System.in));
			String lastname1 = bufferReader.readLine();
			System.out.print("Por favor digite el apellido 2 \n" +
					"O escriba\"Terminar\" para terminar la ejecución del programa: ");
			String lastname2 = bufferReader.readLine();
			if(lastname1.equalsIgnoreCase("")||lastname2.equalsIgnoreCase("")){
				System.out.println("Los apellidos no pueden estar vacios");
			}else{
				if(lastname1.equalsIgnoreCase("Terminar") || lastname2.equalsIgnoreCase("Terminar")){
					exit = true;
				}else if(lastname1.equalsIgnoreCase(lastname2))
					{
						System.out.println("Los dos apellidos son iguales");
					}else if(!lastname1.equalsIgnoreCase(lastname2))
						{
							System.out.println("los dos apellidos son diferentes");
						}
			}
				
			
			
		}while(!exit);
		System.exit(0);
	}

}
