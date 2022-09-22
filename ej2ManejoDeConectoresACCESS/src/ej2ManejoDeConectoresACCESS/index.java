package ej2ManejoDeConectoresACCESS;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import com.healthmarketscience.jackcess.ColumnBuilder;
import com.healthmarketscience.jackcess.DataType;
import com.healthmarketscience.jackcess.Database;
import com.healthmarketscience.jackcess.DatabaseBuilder;
import com.healthmarketscience.jackcess.IndexBuilder;
import com.healthmarketscience.jackcess.Table;
import com.healthmarketscience.jackcess.TableBuilder;
import com.healthmarketscience.jackcess.util.Joiner;

public class index {

	public static void main(String[] args) {
	
	jFrameMenu main = new jFrameMenu();
	//createDB();

		
		
		
		
	}

	
	public static void createDB() {//Funcion para crear un BD de access pero no consigo poner los foreign keys y null type por el codigo
									//Aquella restricciones lo puse a traves del MS Access, he adjuntado un foto.
		try {
			Database db = DatabaseBuilder.create(Database.FileFormat.V2000, new File("main.mdb"));
			  Table libro = new TableBuilder("libro")
					   
					    .addColumn(new ColumnBuilder("ISBN", DataType.INT).setLength(10))
					    .setPrimaryKey("ISBN")
					    .addColumn(new ColumnBuilder("titulo", DataType.TEXT).setLength(30))
					    .addColumn(new ColumnBuilder("autor", DataType.TEXT).setLength(30))
					    .addColumn(new ColumnBuilder("numejemplares", DataType.BYTE).setLength(2))
					    .addColumn(new ColumnBuilder("anyopublicacion", DataType.BYTE).setLength(10))
					    .addColumn(new ColumnBuilder("editorial", DataType.TEXT).setLength(30))
					    .addColumn(new ColumnBuilder("numpag", DataType.BYTE).setLength(4))
					    .toTable(db);
			  Table socio = new TableBuilder("socio")
					  .addColumn(new ColumnBuilder("numsocio",DataType.BYTE).setLength(5))
					  .setPrimaryKey("numsocio")
					  .addColumn(new ColumnBuilder("nombre", DataType.TEXT).setLength(15))
					  .addColumn(new ColumnBuilder("apellido", DataType.TEXT))
					  .addColumn(new ColumnBuilder("telefono", DataType.INT).setLength(10))
					  .addColumn(new ColumnBuilder("edad", DataType.INT).setLength(3))
					  .addColumn(new ColumnBuilder("falta",DataType.SHORT_DATE_TIME))
					  .toTable(db);
			 Table prestamo = new TableBuilder("prestamo")
					  .addColumn(new ColumnBuilder("libro",DataType.BYTE).setLength(10))
					  .addColumn(new ColumnBuilder("socio", DataType.BYTE).setLength(5))
					  .addColumn(new ColumnBuilder("fprestamo", DataType.SHORT_DATE_TIME))
					  .addColumn(new ColumnBuilder("devolucion", DataType.SHORT_DATE_TIME))
					  .setPrimaryKey("libro","socio","fprestamo")
					  .toTable(db);

		} catch (IOException e) {
			  JOptionPane.showMessageDialog(null, "ERROR,MIRA CONSOLA","BORRAR DATOS", JOptionPane.WARNING_MESSAGE);
			System.out.println(e);
		}

	
	}
}
	 
	   
	

