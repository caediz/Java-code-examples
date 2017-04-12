package principal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class PostgreSQLJDBC {

	private static Connection connection;
	private java.sql.Statement statement;

	public PostgreSQLJDBC(){
		this.connection = null;

	}
/**
 * Método principal, llama a los demás
 * @param args
 */
	public static void main(String args[]) {

		BufferedReader bufferReader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Para insertar una pelicula digite 'I' \n"
				+ "Para eliminar una pelicula digite 'E' \n"
				+ "Para actualizar una pelicula digite 'A'");
		char inputOption = ' ';
		try {
			inputOption = bufferReader.readLine().charAt(0);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		PostgreSQLJDBC PS = new PostgreSQLJDBC();
		PS.connect();
		PS.createTable();
		switch (inputOption) {
		case 'I':
			System.out.print("Por favor digite el nombre de la pelicula");
			String name;
			try {
				name = bufferReader.readLine();
				PS.insertMovie(name);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case 'E':
			System.out.print("Por favor digite el nombre de la pelicula a eliminar");
			String nameDel;
			try {
				nameDel = bufferReader.readLine();
				PS.deleteMovie(nameDel);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case 'U':
			System.out.print("Por favor digite el nombre de la pelicula \n"
					+ " que desea cambiar");
			String oName;
			String nName;
			try {
				oName = bufferReader.readLine();
				System.out.print("Por favor digite el  nombre de la nueva "
						+ "pelicula \n");
				nName = bufferReader.readLine();
				PS.updateMovie(oName, nName);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		break;
		default:
			System.out.println("Opción no válida");
			break;
		}
	
		//Tests de desarrollador
		//PS.insertMovie("Cantinflas, el sube y baja.");
		//PS.deleteMovie("La vie est belle");
		//PS.deleteTable();
		//PS.getMovies();
		//PS.updateMovie("Cantinflas, el sube y baja.", "Loco por Mary");
	}

	/**
	 * Método de conexión a la base de datos
	 */
	public void connect(){
		try {
			Class.forName("org.postgresql.Driver");
			connection = DriverManager
					.getConnection("jdbc:postgresql://localhost:5432/videotienda",
							"admin", "123");
			connection.setAutoCommit(false);
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

	/**
	 * Inserta una pelicula dado su nombre
	 * @param name
	 */
	public void insertMovie(String name){
		try {
			statement = connection.createStatement();
			String sql = "INSERT INTO PELICULAS (NOMBRE) VALUES ('"+name+"');";
			statement.executeUpdate(sql);
					
			statement.close();
			connection.commit();

		} catch (Exception e) {
			System.err.println( e.getClass().getName()+": "+ e.getMessage() );
			System.exit(0);
		}
		System.out.println("La pelicula fue agregada a la base de datos");
	}

	public void deleteMovie(String name){
		try {
			statement = connection.createStatement();
			String sql = "DELETE FROM PELICULAS "
					+ "WHERE NOMBRE = '"+name+"';";
			statement.executeUpdate(sql);

			statement.close();
			connection.commit();

		} catch (Exception e) {
			System.err.println( e.getClass().getName()+": "+ e.getMessage() );
			System.exit(0);
		}
		System.out.println("La pelicula fue borrada de la base de datos");
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
			}
			resultSet.close();
			statement.close();
		} catch ( Exception e ) {
			System.err.println( e.getClass().getName()+": "+ e.getMessage() );
			System.exit(0);
		}
	}
	
	/**
	 *  el nombre de una pelicula
	 * @param pName
	 * @param nName
	 */
	
	public void updateMovie(String pName, String nName){
		try {
		       
		         statement = connection.createStatement();
		         String sql = "UPDATE PELICULAS set NOMBRE = '"+nName+"' WHERE NOMBRE = '"+pName+"' ;";
		         statement.executeUpdate(sql);
		         connection.commit();

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
		       System.out.println("Pelicula actualizada a: "+nName);
		     }
	}



