package principal;

import java.io.BufferedReader;
import java.io.InputStreamReader;
/**
 * No se realiza manejo de errores
 */
public class Main {


	private int array[];
	private int length;

	public static void main(String[] args)throws Exception {
		int[] temperatures = new int[7];
		BufferedReader bufferReader = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0; i < 7; i++) {
			System.out.print("Por favor digite la temperatura para el dia ");
			switch (i) {
			case 0:
				System.out.println("lunes");
				break;
			case 1:
				System.out.println("martes");
				break;
			case 2:
				System.out.println("miércoles");
				break;
			case 3:
				System.out.println("jueves");
				break;
			case 4:
				System.out.println("viernes");
				break;
			case 5:
				System.out.println("sábado");
				break;
			case 6:
				System.out.println("domingo");
				break;
			}
			temperatures[i]=Integer.parseInt(bufferReader.readLine());
			
		}
		
		int count = 0;
		for (int j = 0; j < temperatures.length; j++) {
			if(temperatures[j]>30){
				count++;
			}
		}
		System.out.println("La temperatura superó los 30 grados durante "+count+" dias");
	}

}
