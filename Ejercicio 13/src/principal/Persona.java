package principal;
import javax.swing.*;
public class Persona{
	private String name;
	private static int age;
	private static boolean isAdult;
	public void inicializar(){
		name=JOptionPane.showInputDialog(null,"Escriba un nombre:");
		age=Integer.parseInt(JOptionPane.showInputDialog(null,"Escriba una edad"));
		isAdult = false;
	}
	public void imprimir(boolean isAdult){
		if(isAdult){		
			System.out.println(this.name+" es mayor de edad");
		}else{
			System.out.println(this.name+" es menor de edad");
		}
	}	
	public void esMayorEdad(int age){
		if(age>=18){
			this.isAdult=true;
		}
	}
	public static void main(String[] ar){
		Persona persona = new Persona();
		persona.inicializar();
		persona.esMayorEdad(persona.age);
		persona.imprimir(persona.isAdult);
	}
}