package principal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) {
		String qualification;
		boolean exit = false;
		double nota1 = 0;
		double nota2 = 0;
		double nota3 = 0;
		double average = 0;
		
		do{
			System.out.print("Por favor digite la nota 1 o" +
					" \"Terminar\" para terminar la ejecución del programa ");
			BufferedReader bufferReader = new BufferedReader(new InputStreamReader(System.in));
			try {
				nota1 = Double.parseDouble(bufferReader.readLine());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}catch (NumberFormatException e) {
				// TODO: handle exception
				System.out.println("Debe digitar un número, ejecución finalizada");
				break;
			}
			System.out.print("Por favor digite la nota 2 o" +
					" \"Terminar\" para terminar la ejecución del programa ");
			try {
				nota2 = Double.parseDouble(bufferReader.readLine());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}catch (NumberFormatException e) {
				// TODO: handle exception
				System.out.println("Debe digitar un número, ejecución finalizada");
				break;
			}
			System.out.print("Por favor digite la nota 3 o" +
					" \"Terminar\" para terminar la ejecución del programa ");
			try {
				nota3 = Double.parseDouble(bufferReader.readLine());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}catch (NumberFormatException e) {
				// TODO: handle exception
				System.out.println("Debe digitar un número, ejecución finalizada");
				break;
			}
			
			average = (nota1+nota2+nota3)/3;
			
			if (average>=7) {
				qualification = "Promocionado";
				System.out.println(qualification);
				exit = true;
			}else if(average>=4){
				qualification = "Regular";
				System.out.println(qualification);
				exit = true;
			}else{
				qualification = "Reprobado";
				System.out.println(qualification);
				exit = true;
			}
			
		}while(!exit);	
	}
	
}
