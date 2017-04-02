package principal;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args)throws Exception {
		boolean exit = false;
		do {
			System.out.print("Por favor digite el dividendo, debe ser un número de tres cifras \n" +
					"O escriba\"Terminar\" para terminar la ejecución del programa: ");
			BufferedReader bufferReader = new BufferedReader(new InputStreamReader(System.in));
			String dividend = bufferReader.readLine();
			System.out.print("Por favor digite el divisor\n" +
					"O escriba\"Terminar\" para terminar la ejecución del programa: ");
			String divisor = bufferReader.readLine();
			if(dividend.length() == 3){
				//dividimos
				try {
					int quotient = Integer.parseInt(dividend)/Integer.parseInt(divisor);
					System.out.println("El resultado de la división es: " + quotient);
				} catch (ArithmeticException e) {
					// TODO: handle exception
					System.out.println("Java realizó la validación de la división y no es posible "
							+ "realizarla porque la división por cero (0) no existe");
				}			
			}else if(dividend.equalsIgnoreCase("Terminar")){
				exit = true;
			}else{
				System.out.println("El dividendo debe ser un número de tres cifras");
			}
						
		}while(!exit);
		System.exit(0);
	}

}
