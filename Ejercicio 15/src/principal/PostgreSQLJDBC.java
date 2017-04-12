package principal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class PostgreSQLJDBC {

	private Connection connection;
	private Statement statement;
	private boolean isValidOption;
	private char inputOption;
	private MoviesCRUD moviesCRUD;
	private boolean isExit;

	public PostgreSQLJDBC(){
		this.connection = null;
		this.statement = null;
		this.isValidOption = false;
		this.inputOption = ' ';
		this.isExit = false;
		BufferedReader bufferReader = new BufferedReader(new InputStreamReader(System.in));
		connect();
		createTable();
		do{
			this.inputOption = readAction(bufferReader);
			moviesCRUD = new MoviesCRUD(statement, connection);
			performAction(inputOption, bufferReader);
			if(inputOption != 0){
				printMovies();}
		}while(inputOption != 'S');
		//Tests de desarrollador
		//insertMovie("Cantinflas, el sube y baja.");
		//deleteMovie("Cantinflas, el sube y baja.");
		//insertMovie("La Pasión de Cristo");
		//updateMovie("La Pasión de Cristo", "La Resurrección de Cristo");
		//deleteMovie("La vie est belle");
		//deleteTable();
		//updateMovie("Cantinflas, el sube y baja.", "Loco por Mary");
	}
	/**
	 * Método principal, llama al constructor
	 * @param args
	 */
	public static void main(String args[]) {
		PostgreSQLJDBC PS = new PostgreSQLJDBC();
	}

	//Lee una acción por pantalla
	public char readAction(BufferedReader bufferReader){
		System.out.print("Para insertar una pelicula digite 'I' \n"
				+ "Para eliminar una pelicula digite 'E' \n"
				+ "Para actualizar una pelicula digite 'A'"
				+ "Para salir 'S'");
		try {
			inputOption = bufferReader.readLine().charAt(0);
			if (inputOption == ' '){
				System.out.println("Por favor digite una opción");
				return 0;
			}else if (inputOption == 'I'||inputOption == 'E'||inputOption == 'A') {
				this.isValidOption=true;
				return inputOption;
			}else if (inputOption == 'S'){
				return inputOption;
			}else {
				return 0;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	/**
	 * Método de conexión a la base de datos
	 */
	public void connect(){
		try {
			Class.forName("org.postgresql.Driver");
			this.connection = DriverManager
					.getConnection("jdbc:postgresql://localhost:5432/videotienda",
							"admin", "123");
			this.connection.setAutoCommit(false);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getClass().getName()+": "+e.getMessage());
			System.exit(0);
		}
		System.out.println("La base de datos se abrió exitosamente");
	}

	/**
	 * Método para crear una tabla
	 */
	public void createTable(){

		try{
			statement = connection.createStatement();
			String sql = "CREATE TABLE IF NOT EXISTS PELICULAS " +
					"(ID BIGSERIAL PRIMARY KEY   NOT NULL," +
					"NOMBRE TEXT UNIQUE NOT NULL)";
			statement.executeUpdate(sql);
			statement.close();
		} catch ( Exception e ) {
			System.err.println( e.getClass().getName()+": "+ e.getMessage() );
			System.exit(0);
		}
		System.out.println("La tabla PELICULAS está creada");
	}

	public void performAction(char action, BufferedReader bufferReader){
		switch (inputOption) {
		case 'I':
			System.out.print("Por favor digite el nombre de la pelicula");
			String name = "";
			try {
				name = bufferReader.readLine();
				moviesCRUD.insertMovie(name);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case 'E':
			System.out.print("Por favor digite el nombre de la pelicula a eliminar");
			String nameDel = "";
			try {
				nameDel = bufferReader.readLine();
				moviesCRUD.deleteMovie(nameDel);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case 'A':
			System.out.print("Por favor digite el nombre de la pelicula \n"
					+ " que desea cambiar");
			String oName;
			String nName;
			try {
				oName = bufferReader.readLine();
				System.out.print("Por favor digite el  nombre de la nueva "
						+ "pelicula \n");
				nName = bufferReader.readLine();
				moviesCRUD.updateMovie(oName, nName);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		case 0:{
			System.out.println("Opción no válida");
		}

		break;
		default:
			System.out.println("Opción no válida");
			break;
		}

	}

	public void deleteTable(){
		try {
			statement = connection.createStatement();
			String sql = "DROP TABLE PELICULAS";
			statement.executeUpdate(sql);

			statement.close();
			connection.commit();

		} catch (Exception e) {
			System.err.println( e.getClass().getName()+": "+ e.getMessage() );
			System.exit(0);
		}
		System.out.println("La tabla PELICULAS ha sido borrada");
	}

	/**
	 * Imprime la lista de las peliculas que hay en la tabla PELICULAS
	 */
	public void printMovies(){
		try {
			System.out.println("Lista de peliculas recuperada");
			statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery( "SELECT * FROM PELICULAS;" );
			while ( resultSet.next() ) {
				int id = resultSet.getInt("id");
				String  name = resultSet.getString("nombre");
				System.out.println( "ID = " + id );
				System.out.println( "Nombre = " + name );
				System.out.println();
			}
			resultSet.close();
			statement.close();
		} catch ( Exception e ) {
			System.err.println( e.getClass().getName()+": "+ e.getMessage() );
			System.exit(0);
		}
	}

}




