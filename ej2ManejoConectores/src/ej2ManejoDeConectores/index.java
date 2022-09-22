package ej2ManejoDeConectores;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class index {

	public static void main(String[] args) {
		jFrameMenu a = new jFrameMenu();//empezar el GUI de la programa
		
		
	}
	 public static void crearBaseDeDatos() {
		 	boolean creado = false;
	        String url = "jdbc:sqlite:" + "main.db"; //hacer el bd via sqlite y nombrar "main" que se encuentra en el mismo ruta del proyecto

	        try (Connection conn = DriverManager.getConnection(url)) {  // tener conexion al bd
	            if (conn != null) {
	            	creado = true;
	                DatabaseMetaData meta = conn.getMetaData();
	                JOptionPane.showMessageDialog(null, "BASE DE DATOS CREADO!",meta.getDriverName(), JOptionPane.INFORMATION_MESSAGE);
	            }
	            createNewTable();
	            if(creado)JOptionPane.showMessageDialog(null, "TABLAS CREADO!","TABLAS BASES DE DATOS", JOptionPane.INFORMATION_MESSAGE);
	            
	        } catch (SQLException e) {
	            System.out.println(e.getMessage());
	        }
	    }
	 public static void createNewTable() {
	        // SQLite locacion del bd
	        String url = "jdbc:sqlite:"+"main.db";
	        
	        // SQL statement para crear tablas
	        String sqlLibro = "CREATE TABLE IF NOT EXISTS libro(\r\n"
	        		+ "ISBN INT(10) PRIMARY KEY,\r\n"
	        		+ "titulo CHAR(30) NOT NULL,\r\n"
	        		+ "autor CHAR(30),\r\n"
	        		+ "numejemplares INT(2),\r\n"
	        		+ "anyopublicacion INT(10),\r\n"
	        		+ "editorial CHAR(30),\r\n"
	        		+ "numpag INT(4));\r\n"
	        		+ ");";
	        String sqlSocio = "CREATE TABLE IF NOT EXISTS socio(\r\n"
	        		+ "numsocio INT(5) PRIMARY KEY,\r\n"
	        		+ "nombre CHAR(15) NOT NULL,\r\n"
	        		+ "apellidos CHAR(15) NOT NULL,\r\n"
	        		+ "telefono CHAR(10),\r\n"
	        		+ "edad INT(5),\r\n"
	        		+ "falta DATE);\r\n"
	        		+ ");";
	        String sqlPrestamo = "CREATE TABLE IF NOT EXISTS prestamo(\r\n"
	        		+ "libro INT(10) NOT NULL,\r\n"
	        		+ "socio INT(5) NOT NULL,\r\n"
	        		+ "fprestamo DATE NOT NULL,\r\n"
	        		+ "fdevolucion DATE,\r\n"
	        		+ "PRIMARY KEY (libro,socio,fprestamo),\r\n"
	        		+ "FOREIGN KEY (libro) REFERENCES libro,\r\n"
	        		+ "FOREIGN KEY (socio) REFERENCES socio);"
	        		+ ");";
	        
	        try (Connection conn = DriverManager.getConnection(url);
	                Statement stmt = conn.createStatement()) {
	            // crear los tablas
	            stmt.execute(sqlLibro);
	            stmt.execute(sqlSocio);
	            stmt.execute(sqlPrestamo);
	        } catch (SQLException e) {
	            System.out.println(e.getMessage());
	        }
	    }
	
	   
	
}
