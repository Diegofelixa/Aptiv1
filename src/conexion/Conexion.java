package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Conexion {
	public String user="root";
    public String password="";
	    Connection con=null;
	    public Connection conexion(){
	        try {
	            Class.forName("com.mysql.jdbc.Driver");
	            con=DriverManager.getConnection("jdbc:mysql://localhost/aptiv1",user,password);
	            //System.out.print("Conexion Establecida");
	           //JOptionPane.showMessageDialog(null, "Conexion Establecida");
	        } catch (ClassNotFoundException | SQLException e){
	         System.out.println("Error de Conexion");
	         JOptionPane.showMessageDialog(null, "Error de Conexion "+e);
	        }
			return con;
			
			
	        
	    }
		

}
