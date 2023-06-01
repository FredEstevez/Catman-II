package application;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import util.Conectadb;

public class RankingDB {

	public static void main(String[] args) {
		
		consulta_rank ();
	}
	
// genero el nuevo ranking del juego
	public static String consulta_rank () {
		// TODO Auto-generated method stub
		Statement stmt = null;
		ResultSet rs = null;
		String contenido = null;
		
		
		Conectadb conectadb = new Conectadb();
		try( Connection c = conectadb.conexionDB())
		{
			// System.out.println("Conexion Exitosa");	
			
			System.out.println("Datos de la tabla");
			stmt = c.createStatement();
			//rs = stmt.executeQuery("Select * from Usuario");
			// consulta para el ranking
			rs = stmt.executeQuery("SELECT POSICION, USUARIO, Puntuacion_Total FROM Ranking_Gen limit 5;");
			
			while (rs.next()) {
				
				String nombre =  rs.getString("Usuario");
				int Puntuacion = rs.getInt("Puntuacion_Total");
				
				contenido = nombre + " - "+ Puntuacion;
				
				System.out.println("L1: "+contenido);	 
			}//while
			 
			rs.close();
			stmt.close();
			
			
		} catch (Exception e ) {
			System.err.println("Error:  "+ e.getMessage());
		}
		return contenido;
		
		
	}
	

}
