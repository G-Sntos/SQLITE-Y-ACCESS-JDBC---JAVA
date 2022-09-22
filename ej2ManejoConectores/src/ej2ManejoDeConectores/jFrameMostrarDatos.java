package ej2ManejoDeConectores;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

public class jFrameMostrarDatos extends JFrame {
	JButton mostrarLibro= new JButton();
	JButton mostrarSocio= new JButton();
	JButton mostrarPrestamo= new JButton();
	JButton volverMostrar= new JButton();
	//area para mostrar resultado
	JTextArea mostrarInfo = new JTextArea();
	public jFrameMostrarDatos() {
		//Base frame del menu
				this.setLayout(new FlowLayout(FlowLayout.CENTER,20,20)); 
				this.setSize(250, 300);
				this.setTitle("Mostrar Datos");
				this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				this.setResizable(false);
				this.getContentPane().setBackground(new Color(102, 153, 255));
				//montar buttones
				mostrarLibro.setFocusable(false);
				mostrarSocio.setFocusable(false);
				mostrarPrestamo.setFocusable(false);
				volverMostrar.setFocusable(false);
				
				mostrarLibro.setPreferredSize(new Dimension(150,35));
				mostrarPrestamo.setPreferredSize(new Dimension(150,35));
				mostrarSocio.setPreferredSize(new Dimension(150,35));
				volverMostrar.setPreferredSize(new Dimension(150,35));
				
				mostrarLibro.setText("Mostrar Libro");
				mostrarPrestamo.setText("Mostrar Prestamo");
				mostrarSocio.setText("Mostrar Socio");
				volverMostrar.setText("Volver");
				//añadir componente
				this.add(mostrarLibro);
				this.add(mostrarSocio);
				this.add(mostrarPrestamo);
				this.add(volverMostrar);

				this.setVisible(true);
				//acciones del buttones
				mostrarLibro.addActionListener(e->{
					
					JFrame mostrarLibroFrame = new JFrame();
					mostrarLibroFrame.setLayout(new FlowLayout(FlowLayout.CENTER,20,20)); 
					mostrarLibroFrame.setSize(600, 300);
					mostrarLibroFrame.setTitle("Mostrar Datos");
					mostrarLibroFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // asi no cierra la programa cuando dan el X
					mostrarLibroFrame.setResizable(false);
					mostrarLibroFrame.getContentPane().setBackground(new Color(102, 153, 255));
					mostrarInfo.setBounds(0, 0, 250, 300);
					mostrarInfo.append(selectLibro());
					mostrarLibroFrame.add(mostrarInfo);
					mostrarLibroFrame.setVisible(true);
					
				});
				mostrarSocio.addActionListener(e->{
					JFrame mostrarLibroFrame = new JFrame();
					mostrarLibroFrame.setLayout(new FlowLayout(FlowLayout.CENTER,20,20)); 
					mostrarLibroFrame.setSize(650, 300);
					mostrarLibroFrame.setTitle("Mostrar Datos");
					mostrarLibroFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					mostrarLibroFrame.setResizable(false);
					mostrarLibroFrame.getContentPane().setBackground(new Color(102, 153, 255));
					mostrarInfo.setBounds(0, 0, 250, 300);
					mostrarInfo.append(selectSocio());
					mostrarLibroFrame.add(mostrarInfo);
					mostrarLibroFrame.setVisible(true);
				});
				mostrarPrestamo.addActionListener(e->{
					JFrame mostrarLibroFrame = new JFrame();
					mostrarLibroFrame.setLayout(new FlowLayout(FlowLayout.CENTER,20,20)); 
					mostrarLibroFrame.setSize(650, 300);
					mostrarLibroFrame.setTitle("Mostrar Datos");
					mostrarLibroFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					mostrarLibroFrame.setResizable(false);
					mostrarLibroFrame.getContentPane().setBackground(new Color(102, 153, 255));
					mostrarInfo.setBounds(0, 0, 250, 300);
					mostrarInfo.append(selectPrestamo());
					mostrarLibroFrame.add(mostrarInfo);
					mostrarLibroFrame.setVisible(true);
				});
				volverMostrar.addActionListener(e->{
					jFrameMenu xx = new jFrameMenu();
					this.dispose();
				});
				
	}
	 private Connection connect() {
	        // SQLite connection string
	        String url = "jdbc:sqlite:"+"main.db";
	        Connection conn = null;
	        try {
	            conn = DriverManager.getConnection(url);
	        } catch (SQLException e) {
	            System.out.println(e.getMessage());
	        }
	        return conn;
	    }
    
	public String selectLibro(){ //mostrar lo que lleva aquel BD
        String sql = "SELECT ISBN, titulo, autor,numejemplares,anyopublicacion,editorial,numpag FROM libro";
        String resultado="";
        try (Connection conn = this.connect();  //usando el conn del sqlite
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){
            
            // loop del resulta a mostrar
            while (rs.next()) {
                resultado+=(rs.getInt("ISBN") +  "\t" + 
                                   rs.getString("titulo") + "\t" +
                                   rs.getString("autor") + "\t" +
                                   rs.getInt("numejemplares") + "\t" +
                                   rs.getInt("anyopublicacion") + "\t" +
                                   rs.getString("editorial") + "\t" +
                                   rs.getInt("numpag"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return resultado; //devuelve el conjunto del loop como un string
    }
	public String selectPrestamo(){ 
        String sql = "SELECT libro, socio, fprestamo,fdevolucion FROM prestamo"; 
        String resultado="";
        try (Connection conn = this.connect(); //usando el conn del sqlite
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){
            
        
            while (rs.next()) {
                resultado+=(rs.getInt("libro") +  "\t" + 
                                   rs.getString("socio") + "\t" +
                                   rs.getString("fprestamo") + "\t" +
                                   rs.getString("fdevolucion"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return resultado;
    }
	public String selectSocio(){ 
        String sql = "SELECT numsocio,nombre,apellidos,telefono,edad,falta FROM socio";
        String resultado = "";
        try (Connection conn = this.connect();  //usando el conn del sqlite
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){
            
         
            while (rs.next()) {
                resultado+=(rs.getInt("numsocio") +  "\t" + 
                                   rs.getString("nombre") + "\t" +
                                   rs.getString("apellidos") + "\t" +
                                   rs.getInt("telefono") + "\t" +
                                   rs.getInt("edad") + "\t" +
                                   rs.getString("falta"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return resultado;
    }
}
