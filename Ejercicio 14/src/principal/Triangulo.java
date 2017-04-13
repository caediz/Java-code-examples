package principal;

import javax.swing.*;
public class Triangulo{
	private int side1;
	private int side2;
	private int side3;
	private String largestSide;
	private boolean isEquilateral;

	public void inicializar(int side1, int side2, int side3){
		this.side1 = side1;
		this.side2 = side2;
		this.side3 = side3;

		this.largestSide = "";
		this.isEquilateral = false;
	}
	public void ladoMayor(){
		if(!isEquilateral){
			if(side1>side2){
				if(side1>side3){
					this.largestSide="lado 1 = "+ side1;
				}
			}else if(side2>side3){
				this.largestSide="lado 2 = "+ side2;
			}else {
				this.largestSide="lado 3 = "+side3;
			}
			System.out.println("El lado mayor es el "+largestSide+" unidades");
		}
	}
	public void equilatero(){
		if(this.side1==this.side2 && this.side2==this.side3){
			this.isEquilateral = true;
			System.out.println("El triángulo es equilatero");
		}
	}
	public static void main(String []ar){
		Triangulo triangle1= new Triangulo();
		triangle1.inicializar(2,3,1);
		triangle1.equilatero();
		triangle1.ladoMayor();

		Triangulo triangle2= new Triangulo();
		triangle2.inicializar(2,2,2);
		triangle2.equilatero();
		triangle2.ladoMayor();
	}
}