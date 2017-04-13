//Se importa el paquete
package principal;

//Se define la clase pública "Triangulo".
public class Triangulo{
	//Se declaran las variables correspondientes a los lados del triángulo.
	private int side1;
	private int side2;
	private int side3;
	//Se declara la variable del lado mayor.
	private String largestSide;
	//Se declara la variable que almacena si el triángulo es equilatero o no.
	private boolean isEquilateral;

	//Se inicializan las variables, los laddos entran como parámetros
	public void inicializar(int side1, int side2, int side3){
		this.side1 = side1;
		this.side2 = side2;
		this.side3 = side3;

		this.largestSide = "";
		this.isEquilateral = false;
	}
	
	//Este método busca el lado mayor haciendo uso de estructuras if y lo imprime
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
	
	//Este método determina si el triángulo es equilatero e imprime un mensaje
	public void equilatero(){
		if(this.side1==this.side2 && this.side2==this.side3){
			this.isEquilateral = true;
			System.out.println("El triángulo es equilatero");
		}
	}
	
	/**El método principal crea dos objetos Triangulo y hace uso de sus métodos
	Usando parámetros diferentes para cada objeto*/
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