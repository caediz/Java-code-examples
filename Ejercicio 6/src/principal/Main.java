package principal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Totalizer{
	int totalize(int startingTotal, BufferedReader bufferReader){
		try {
			int newValue = Integer.parseInt(bufferReader.readLine().toLowerCase());
			startingTotal = startingTotal+newValue;
			return startingTotal;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}
}
class Sale extends Totalizer{
	int getSalesTotal(int salesTotal, BufferedReader bufferReader){
		return totalize(salesTotal, bufferReader);
	}
}

class Buy extends Totalizer{
	int getBuysTotal(int buysTotal, BufferedReader bufferReader){
		return totalize(buysTotal, bufferReader);
	}
}

public class Main {

	public static void main(String[] args) {
		
		String line = "";
		boolean exit = false;
		int salesTotal = 0;
		int buysTotal = 0;
		
		while(!exit){
			
			System.out.print("Para realizar una venta digite: V \n" +
					"Para ingresar una compra digite: C \n" +
					"Para visualizar la utilidad del día digite: U \n"+
					"Para salir digite: S \n");
			
			BufferedReader bufferReader = new BufferedReader(new InputStreamReader(System.in));
			
			try {
				line = bufferReader.readLine().toLowerCase();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			switch (line) {
			case "v":
				System.out.println("Por favor ingrese el valor de la venta:\n");
				Sale sale = new Sale();
				salesTotal = sale.getSalesTotal(salesTotal, bufferReader);
				System.out.println("Venta realizada correctamente:\n");
				break;
			case "c":
				System.out.println("Por favor ingrese el valor de la compra:\n");
				Buy buy = new Buy();
				buysTotal = buy.getBuysTotal(buysTotal, bufferReader);
				System.out.println("Compra ingresada correctamente:\n");
				break;
			case "u": 
				System.out.println("La utilidad del día es:"+(salesTotal-buysTotal)+"\n");
				break;
			case "s": 
				exit = true;
				break;
			default :
				System.out.println("No digitó una opción válida \n");
				break;
			}
		}
	}
}
