package ej2ManejoDeConectores;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class jFrameMenu extends JFrame{
	JButton button1= new JButton();
	JButton button2= new JButton();
	JButton button3= new JButton();
	JButton button4= new JButton();
	JButton button5= new JButton();
	jFrameInsertar jFrameInsertar;
	jFrameBorrar jFrameBorrar;
	public jFrameMenu(){
		//Base frame del menu
		this.setLayout(new FlowLayout(FlowLayout.CENTER,20,20)); 
		this.setSize(250, 350);
		this.setTitle("Ej 2 SQL");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.getContentPane().setBackground(new Color(102, 153, 255));
		//Texto Butones
		button2.setText("Insertar Datos");
		button3.setText("Eliminar Datos");
		button1.setText("Crear y/o Borrar BD");
		button4.setText("Mostrar Datos");
		button5.setText("Salir");
		//para quitar el "border" del texto.
		button1.setFocusable(false);
		button2.setFocusable(false); 
		button3.setFocusable(false);
		button4.setFocusable(false);
		button5.setFocusable(false);
		//Tamaño buttones
		button1.setPreferredSize(new Dimension(200,50));
		button2.setPreferredSize(new Dimension(150,35));
		button3.setPreferredSize(new Dimension(150,35));
		button4.setPreferredSize(new Dimension(150,35));
		button5.setPreferredSize(new Dimension(150,35));
		//Meter Butones en Frame
		this.add(button1);
		this.add(button2);
		this.add(button3);
		this.add(button4);
		this.add(button5);
		//acciones de cada button
		button1.addActionListener(e->{
			index.crearBaseDeDatos();
			
		});
		button2.addActionListener(e->{
			jFrameInsertar = new jFrameInsertar();
			this.dispose();
			
		});
		//acciones de cada button
		button3.addActionListener(e->{
			jFrameBorrar = new jFrameBorrar();
			this.dispose();
			
		});
		//acciones de cada button
		button4.addActionListener(e->{
			jFrameMostrarDatos a = new jFrameMostrarDatos();
			this.dispose();
			
		});
		button5.addActionListener(e->{
			System.exit(0);
			
		});
		
		
		this.setVisible(true);
	}
}
