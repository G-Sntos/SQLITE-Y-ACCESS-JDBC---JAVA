package ej2ManejoDeConectoresACCESS;

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

public class jFrameBorrar extends JFrame {
	int dato;
	boolean error;
	JButton borrarLibro= new JButton();
	JButton borrarSocio= new JButton();
	JButton borrarPrestamo= new JButton();
	JButton volverBorrar= new JButton();
	JTextField jTextDato = new JTextField("");
	
	public jFrameBorrar() {
		//Base frame del menu
				this.setLayout(new FlowLayout(FlowLayout.CENTER,20,20)); 
				this.setSize(300, 320);
				this.setTitle("Borrar Datos ACCESS");
				this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				this.setResizable(false);
				this.getContentPane().setBackground(new Color(102, 153, 255));
				
				borrarLibro.setFocusable(false);
				borrarSocio.setFocusable(false);
				borrarPrestamo.setFocusable(false);
				volverBorrar.setFocusable(false);
				
				borrarLibro.setPreferredSize(new Dimension(150,35));
				borrarPrestamo.setPreferredSize(new Dimension(150,35));
				borrarSocio.setPreferredSize(new Dimension(150,35));
				volverBorrar.setPreferredSize(new Dimension(150,35));
				
				borrarLibro.setText("Borrar Libro");
				borrarPrestamo.setText("Borrar Prestamo");
				borrarSocio.setText("Borrar Socio");
				volverBorrar.setText("Volver");
				
				jTextDato.setPreferredSize(new Dimension(200,30));
				jTextDato.setText("Num.Socio / Num.Libro / ISBN");
				
				this.add(borrarLibro);
				this.add(borrarSocio);
				this.add(borrarPrestamo);
				this.add(jTextDato);
				this.add(volverBorrar);
				this.setVisible(true);
				
				//accion buttones
				
				borrarLibro.addActionListener(e->{
					
					try { 
						
						dato = Integer.valueOf(jTextDato.getText());
						
					}catch(InputMismatchException | NumberFormatException | NullPointerException a) {  // acaso que intentan meter datos fuera de lo que pide
						JOptionPane.showMessageDialog(null, "Dato(s) INVALIDO, VUELVA A INTRODUCIR.","Borrar Datos", JOptionPane.WARNING_MESSAGE);
						 error = true;
						
						
					}
					if(!error) {
						deleteLibro(dato);
					}else {
						this.dispose();
					}
				});
				borrarSocio.addActionListener(e->{
					try { 
						
						dato = Integer.valueOf(jTextDato.getText());
						
					}catch(InputMismatchException | NumberFormatException | NullPointerException a) {  // acaso que intentan meter datos fuera de lo que pide
						JOptionPane.showMessageDialog(null, "Dato(s) INVALIDO, VUELVA A INTRODUCIR.","Borrar Datos", JOptionPane.WARNING_MESSAGE);
						 error = true;
						
						
					}
					if(!error) {
						deleteSocio(dato);
					}else {
						this.dispose();
					}
				});
				borrarPrestamo.addActionListener(e->{
					try { 
						
						dato = Integer.valueOf(jTextDato.getText());
						
					}catch(InputMismatchException | NumberFormatException | NullPointerException a) {  // acaso que intentan meter datos fuera de lo que pide
						JOptionPane.showMessageDialog(null, "Dato(s) INVALIDO, VUELVA A INTRODUCIR.","Borrar Datos", JOptionPane.WARNING_MESSAGE);
						 error = true;
						
						
					}
					if(!error) {
						deletePrestamo(dato);
					}else {
						this.dispose();
					}
	
				});
				
				volverBorrar.addActionListener(e->{
					jFrameMenu xx = new jFrameMenu();
					this.dispose();
				});
	}
	 private Connection connect() {
			Connection conn=null;
			try {
				conn = DriverManager.getConnection(  // USANDO EL DRIVER DEL UCANACCESS Y EL DB .MDB EN VEZ DE SQLITE
				        "jdbc:ucanaccess://"+"main.mdb");
			}catch (SQLException e) {
				e.printStackTrace();
			}
			return conn;
	 }
    
    public void deleteLibro(int id) {
        String sql = "DELETE FROM libro WHERE ISBN = ?";

        try (Connection conn = this.connect(); //usando el connect de ucanaccess jar
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // montar param
            pstmt.setInt(1, id);
            // ejecutar  delete statement
            pstmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "HAS BORRADO INFORMACION! en LIBRO","BORRAR DATOS", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "ERROR,MIRA CONSOLA","BORRAR DATOS", JOptionPane.WARNING_MESSAGE);
        }
    }
    public void deleteSocio(int id) {
        String sql = "DELETE FROM socio WHERE numsocio = ?";
 
        try (Connection conn = this.connect(); //usando el connect de ucanaccess jar
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // montar param
            pstmt.setInt(1, id);
            // ejecutar delete statement
            pstmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "HAS BORRADO INFORMACION! en SOCIO","BORRAR DATOS", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "ERROR,MIRA CONSOLA","BORRAR DATOS", JOptionPane.WARNING_MESSAGE);
        }
    }
    public void deletePrestamo(int id) {
        String sql = "DELETE FROM prestamo WHERE libro = ?";

        try (Connection conn = this.connect(); //usando el connect de ucanaccess jar
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // set the corresponding param
            pstmt.setInt(1, id);
            // ejecutar  delete statement
            pstmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "HAS BORRADO INFORMACION! en PRESTAMO","BORRAR DATOS", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "ERROR,MIRA CONSOLA","BORRAR DATOS", JOptionPane.WARNING_MESSAGE);
        }
    }

}

