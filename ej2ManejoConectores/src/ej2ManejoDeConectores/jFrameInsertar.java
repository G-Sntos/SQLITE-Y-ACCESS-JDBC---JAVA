package ej2ManejoDeConectores;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.InputMismatchException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class jFrameInsertar extends JFrame{
	String titulo,autor,editorial,nombreSocio,apellidoSocio;
	int isbn,anyo,numPaginas,numEjemplares,
	numTelefono,edad,numSocio
	,prestamoLibro,prestamoSocio;
	
	boolean error;
	//textfield insertar libro
	JTextField jTextTitulo = new JTextField("");
	JTextField jTextAutor = new JTextField("");
	JTextField jTextIsbn = new JTextField("");
	JTextField jTextEditorial = new JTextField("");
	JTextField jTextAnyo = new JTextField("");
	JTextField jTextNumPaginas = new JTextField("");
	JTextField jTextNumEjemplares = new JTextField("");
	//textfield insertar socio
	JTextField jTextNumSocio= new JTextField("");
	JTextField jTextNumTelefonoSocio = new JTextField("");
	JTextField jTextEdadSocio = new JTextField("");
	JTextField jTextNombreSocio = new JTextField("");
	JTextField jTextApellidoSocio = new JTextField("");
	//prestamo jText
	JTextField jTextprestamoLibro = new JTextField("");
	JTextField jTextprestamoSocio = new JTextField("");
	
	
	JButton button1= new JButton();
	JButton button2= new JButton();
	JButton button3= new JButton();
	JButton button4= new JButton();
	JButton button5= new JButton();
	JButton button6= new JButton();
	//Cambie el nombre pq ya me estan confundiendo los buttones
	JButton insertarSocios= new JButton();
	JButton volverSocios= new JButton();
	//prestamo buttones
	JButton insertarPrestamo= new JButton();
	JButton volverPrestamo= new JButton();
	
	
	
	public jFrameInsertar() {
		//Base frame del menu
		this.setLayout(new FlowLayout(FlowLayout.CENTER,20,20)); 
		this.setSize(250, 300);
		this.setTitle("Insertar Datos");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.getContentPane().setBackground(new Color(102, 153, 255));
		//para quitar el "border" del texto.
		button1.setFocusable(false);
		button2.setFocusable(false); 
		button3.setFocusable(false);
		button4.setFocusable(false);
		//tamaño buttones
		button4.setPreferredSize(new Dimension(150,35));
		button2.setPreferredSize(new Dimension(150,35));
		button3.setPreferredSize(new Dimension(150,35));
		button1.setPreferredSize(new Dimension(150,35));
		//Texto Butones
		button2.setText("Insertar Socio");
		button3.setText("Insertar Prestamo");
		button1.setText("Insertar Libro");
		button4.setText("Volver al Menu");
		//Meter Butones en Frame
		this.add(button1);
		this.add(button2);
		this.add(button3);
		this.add(button4);
		
		//acciones de cada button
				button1.addActionListener(e->{ //InsertarLibro
					
					JFrame libroInsertar = new JFrame(); // nuevo jFrame para recoger datos a insertar
					libroInsertar.setLayout(new FlowLayout(FlowLayout.CENTER,20,20)); 
					libroInsertar.setSize(350, 520);
					libroInsertar.setTitle("Insertar Datos");
					libroInsertar.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					libroInsertar.setResizable(false);
					libroInsertar.getContentPane().setBackground(new Color(102, 153, 255));
					//montar buttones
					button5.setPreferredSize(new Dimension(150,35));
					button6.setPreferredSize(new Dimension(150,35));
					
					button5.setFocusable(false);
					button6.setFocusable(false);
					
					button5.setText("Insertar Datos");
					button6.setText("Volver");
					
				
					
					//montar input de textfield
					jTextTitulo.setPreferredSize(new Dimension(240,30));
					jTextTitulo.setText("Titulo");
					
					jTextAutor.setPreferredSize(new Dimension(240,30));
					jTextAutor.setText("Autor");
					
					jTextIsbn.setPreferredSize(new Dimension(240,30));
					jTextIsbn.setText("ISBN");
					
					jTextEditorial.setPreferredSize(new Dimension(240,30));
					jTextEditorial.setText("Editorial");
					
					jTextAnyo.setPreferredSize(new Dimension(240,30));
					jTextAnyo.setText("Año");
					
					jTextNumPaginas.setPreferredSize(new Dimension(240,30));
					jTextNumPaginas.setText("Numero de pagina");
					
					jTextNumEjemplares.setPreferredSize(new Dimension(240,30));
					jTextNumEjemplares.setText("Numero de Ejemplares");
					
					
					//añadir components y poner lo visible
					libroInsertar.add(button5); //nuevo buttones, porque si uso algunos de los declarado en el main JFrame de este clase, se repite el funcion cuando doy al click.
					libroInsertar.add(button6);
					libroInsertar.add(jTextTitulo);
					libroInsertar.add(jTextAutor);
					libroInsertar.add(jTextIsbn);
					libroInsertar.add(jTextEditorial);
					libroInsertar.add(jTextAnyo);
					libroInsertar.add(jTextNumPaginas);
					libroInsertar.add(jTextNumEjemplares);
					libroInsertar.setVisible(true);
	
					this.dispose();//quitar el antiguo menu de insertar, this - porque es el mainFrame de este "clase".
					button5.addActionListener(f->{ //si hagan click al button de insertar, se recoge datos introducidos al jText, y inicia el funcion de insertLibro.
						try { 
							titulo = jTextTitulo.getText();
							autor = jTextAutor.getText();
							isbn = Integer.valueOf(jTextIsbn.getText());
							editorial = jTextEditorial.getText();
							anyo = Integer.valueOf(jTextAnyo.getText());
							numPaginas =Integer.valueOf(jTextNumPaginas.getText());
							numEjemplares =Integer.valueOf(jTextNumEjemplares.getText());
							
							
						}catch(InputMismatchException | NumberFormatException | NullPointerException a) {  // acaso que intentan meter datos fuera de lo que pide
							JOptionPane.showMessageDialog(null, "Dato(s) INVALIDO, VUELVA A INTRODUCIR.","Insertar Datos", JOptionPane.WARNING_MESSAGE);
							 error = true;
							
							
						}
						if(!error) {
							insertLibro(isbn, titulo, autor, numEjemplares, anyo, editorial, numPaginas);
						}else {
							this.dispose();
						}
					});
					button6.addActionListener(f->{
					jFrameInsertar xx = new jFrameInsertar();
					libroInsertar.dispose(); //quitar este frame cuando vuelva al menu
					});
				});
				button2.addActionListener(e->{ //Insertar Socio
					JFrame socioInsertar = new JFrame(); // nuevo jFrame para recoger datos a insertar
					socioInsertar.setLayout(new FlowLayout(FlowLayout.CENTER,20,20)); 
					socioInsertar.setSize(300, 450);
					socioInsertar.setTitle("Insertar Datos");
					socioInsertar.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					socioInsertar.setResizable(false);
					socioInsertar.getContentPane().setBackground(new Color(102, 153, 255));
					
					//montar buttones
					insertarSocios.setPreferredSize(new Dimension(150,35));
					volverSocios.setPreferredSize(new Dimension(150,35));
					
					insertarSocios.setFocusable(false);
					volverSocios.setFocusable(false);
					
					insertarSocios.setText("Insertar Datos");
					volverSocios.setText("Volver");
					//montar textfield
					jTextNumSocio.setPreferredSize(new Dimension(240,30));
					jTextNumSocio.setText("Numero Socio");
					
					jTextNombreSocio.setPreferredSize(new Dimension(240,30));
					jTextNombreSocio.setText("Nombre");

					jTextApellidoSocio.setPreferredSize(new Dimension(240,30));
					jTextApellidoSocio.setText("Apellido");
					
					jTextNumTelefonoSocio.setPreferredSize(new Dimension(240,30));
					jTextNumTelefonoSocio.setText("Numero de Telefono");
					
					jTextEdadSocio.setPreferredSize(new Dimension(240,30));
					jTextEdadSocio.setText("Edad");
					
					//añadir componentes en el frame
					socioInsertar.add(insertarSocios);
					socioInsertar.add(volverSocios);
					socioInsertar.add(jTextNumSocio);
					socioInsertar.add(jTextNombreSocio);
					socioInsertar.add(jTextApellidoSocio);
					socioInsertar.add(jTextNumTelefonoSocio);
					socioInsertar.add(jTextEdadSocio);
					
					socioInsertar.setVisible(true);
					//accion button insertar datos
					insertarSocios.addActionListener(f->{
						try {
						numSocio = Integer.valueOf(jTextNumSocio.getText());
						nombreSocio = jTextNombreSocio.getText();
						apellidoSocio = jTextApellidoSocio.getText();
						numTelefono = Integer.valueOf(jTextNumTelefonoSocio.getText());
						edad = Integer.valueOf(jTextEdadSocio.getText());
						}catch(InputMismatchException | NumberFormatException | NullPointerException a) {  // acaso que intentan meter datos fuera de lo que pide
							JOptionPane.showMessageDialog(null, "Dato(s) INVALIDO, VUELVA A INTRODUCIR.","Insertar Datos", JOptionPane.WARNING_MESSAGE);
							 error = true;
						}
						if(!error) {
							insertSocio(numSocio, nombreSocio, apellidoSocio, numTelefono, edad);
						}else {
							this.dispose();
						}
					});
					volverSocios.addActionListener(f->{
						jFrameInsertar xx = new jFrameInsertar();
						socioInsertar.dispose(); //quitar este frame cuando vuelva al menu
					});
					
				});
				//acciones button insertar prestamo
				button3.addActionListener(e->{
					JFrame prestamoInsertar = new JFrame(); // nuevo jFrame para recoger datos a insertar
					prestamoInsertar.setLayout(new FlowLayout(FlowLayout.CENTER,20,20)); 
					prestamoInsertar.setSize(300, 280);
					prestamoInsertar.setTitle("Insertar Datos");
					prestamoInsertar.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					prestamoInsertar.setResizable(false);
					prestamoInsertar.getContentPane().setBackground(new Color(102, 153, 255));
					
					//montar buttones
					insertarPrestamo.setPreferredSize(new Dimension(150,35));
					volverPrestamo.setPreferredSize(new Dimension(150,35));
					
					insertarPrestamo.setFocusable(false);
					volverPrestamo.setFocusable(false);
					
					insertarPrestamo.setText("Insertar Datos");
					volverPrestamo.setText("Volver");
					
					//montar textfield
					jTextprestamoLibro.setPreferredSize(new Dimension(240,30));
					jTextprestamoLibro.setText("Libro");
					
					jTextprestamoSocio.setPreferredSize(new Dimension(240,30));
					jTextprestamoSocio.setText("Socio");
					
					prestamoInsertar.add(insertarPrestamo);
					prestamoInsertar.add(volverPrestamo);
					prestamoInsertar.add(jTextprestamoSocio);
					prestamoInsertar.add(jTextprestamoLibro);
					prestamoInsertar.setVisible(true);
					//buttones prestamo accion
					insertarPrestamo.addActionListener(f->{
						
						try {
						prestamoLibro = Integer.valueOf((jTextprestamoLibro.getText()));
						prestamoSocio =	Integer.valueOf((jTextprestamoSocio.getText()));
						}catch(InputMismatchException | NumberFormatException | NullPointerException a) {  // acaso que intentan meter datos fuera de lo que pide
							JOptionPane.showMessageDialog(null, "Dato(s) INVALIDO, VUELVA A INTRODUCIR.","Insertar Datos", JOptionPane.WARNING_MESSAGE);
							 error = true;
						}
						if(!error) {
							insertPrestamo(prestamoLibro, numSocio);
						}else {
							this.dispose();
						}
						
					});
					volverPrestamo.addActionListener(f->{
						jFrameInsertar xx = new jFrameInsertar();
						prestamoInsertar.dispose();
					});
					
					
					
				});
				//acciones de cada button
				button4.addActionListener(e->{
					jFrameMenu b = new jFrameMenu();
					this.dispose();
					
				});
		this.setVisible(true);
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
	 
	 public void insertLibro(int isbn, String titulo,String autor,int numejemplares,int anyopublicacion,String editorial,int numpag) {

	        String sql = "INSERT INTO libro(ISBN,titulo,autor,numejemplares,anyopublicacion,editorial,numpag) VALUES(?,?,?,?,?,?,?)";

	        try (Connection conn = this.connect();
	                PreparedStatement pstmt = conn.prepareStatement(sql)) { //usando el conn del sqlite
	            pstmt.setInt(1, isbn);
	            pstmt.setString(2, titulo);
	            pstmt.setString(3, autor);
	            pstmt.setInt(4, numejemplares);
	            pstmt.setInt(5, anyopublicacion);
	            pstmt.setString(6, editorial);
	            pstmt.setInt(7, numpag);
	            pstmt.executeUpdate();
	            JOptionPane.showMessageDialog(null, "HAS INSERTADO INFORMACION en LIBRO!","INSERTAR DATOS", JOptionPane.INFORMATION_MESSAGE);
	        } catch (SQLException e) {
	            System.out.println(e.getMessage());
	            JOptionPane.showMessageDialog(null, "ERROR,MIRA CONSOLA","INSERTAR DATOS", JOptionPane.WARNING_MESSAGE);
	        }
	    }
	 public void insertSocio(int numSocio, String nombreSocio, String apellidoSocio, int telefono, int edad) {
	        String sql = "INSERT INTO socio(numsocio,nombre,apellidos,telefono,edad,falta) VALUES(?,?,?,?,?,?)";

	        try (Connection conn = this.connect();
	                PreparedStatement pstmt = conn.prepareStatement(sql)) { //usando el conn del sqlite
	            pstmt.setInt(1, numSocio);
	            pstmt.setString(2, nombreSocio);
	            pstmt.setString(3, apellidoSocio);
	            pstmt.setInt(4, telefono);
	            pstmt.setInt(5, edad);
	            pstmt.setString(6, String.valueOf(java.time.LocalDate.now()));
	            
	            pstmt.executeUpdate();
	            JOptionPane.showMessageDialog(null, "HAS INSERTADO INFORMACION en SOCIO!","INSERTAR DATOS", JOptionPane.INFORMATION_MESSAGE);
	        } catch (SQLException e) {
	            System.out.println(e.getMessage());
	            JOptionPane.showMessageDialog(null, "ERROR,MIRA CONSOLA","INSERTAR DATOS", JOptionPane.WARNING_MESSAGE);
	        }
	    }
	 public void insertPrestamo(int libro,int socio) {
	        String sql = "INSERT INTO prestamo(libro,socio,fprestamo,fdevolucion) VALUES(?,?,?,?)";

	        try (Connection conn = this.connect();
	                PreparedStatement pstmt = conn.prepareStatement(sql)) { //usando el conn del sqlite
	            pstmt.setInt(1, libro);
	            pstmt.setInt(2, socio);
	            pstmt.setString(3, String.valueOf(java.time.LocalDate.now()));
	            pstmt.setString(4, String.valueOf(java.time.LocalDate.now()));
	   
	            pstmt.executeUpdate();
	            JOptionPane.showMessageDialog(null, "HAS INSERTADO INFORMACION! en PRESTAMO","INSERTAR DATOS", JOptionPane.INFORMATION_MESSAGE);
	        } catch (SQLException e) {
	            System.out.println(e.getMessage());
	            JOptionPane.showMessageDialog(null, "ERROR,MIRA CONSOLA","INSERTAR DATOS", JOptionPane.WARNING_MESSAGE);
	        }
	    }
	
}
