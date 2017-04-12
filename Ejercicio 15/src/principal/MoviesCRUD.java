package principal;

import java.sql.Connection;
import java.sql.Statement;

public class MoviesCRUD {
	private Statement statement;
	private Connection connection;
	
	public MoviesCRUD(Statement statement, Connection connection){
		this.statement = statement;
		this.connection = connection;
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

	public void updateMovie(String pName, String nName){
		try {

			statement = connection.createStatement();
			String sql = "UPDATE PELICULAS set NOMBRE = '"+nName+"' WHERE NOMBRE = '"+pName+"' ;";
			statement.executeUpdate(sql);
			connection.commit();
			statement.close();
		} catch ( Exception e ) {
			System.err.println( e.getClass().getName()+": "+ e.getMessage() );
			System.exit(0);
		}
		System.out.println("Pelicula actualizada a: "+nName);
	}
}
