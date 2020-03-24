package aptiv1;

import java.sql.PreparedStatement;

import java.sql.ResultSet;
import java.sql.SQLException;


import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import com.mysql.jdbc.Connection;
import conexion.Conexion;

public class Combo 
{
	public void consultar_estacion(JComboBox cb_estacion)
	{

	//Creamos objeto tipo Connection    
	java.sql.Connection conectar = null;    
	PreparedStatement ps = null;
	ResultSet result = null;

	//Creamos la Consulta SQL
	String SQL = "SELECT nombre_estacion FROM estacion";

	//Establecemos bloque try-catch-finally
		try 
		{
		       
		   //Establecemos conexión con la BD 
			Conexion con = new Conexion();
	        Connection c=(Connection) con.conexion();  
		   //Preparamos la consulta SQL
		   ps = c.prepareStatement(SQL);
		   //Ejecutamos la consulta
		   result = ps.executeQuery();
		   
           cb_estacion.addItem("Seleccione una opción");
			   
		   
		   while ( result.next())
			   
		   {
			   cb_estacion.addItem(result.getString("nombre_estacion"));
		   }
		   		   
		  
		   
		  
		       //JOptionPane.showMessageDialog(null, cb_estacion);
		} 
	catch (SQLException e) 
		{
	
		    JOptionPane.showMessageDialog(null, e);
		    
		}
		
	finally
		{
	
		    if(conectar!=null)
		    {
		        
				        try {
				        
					            conectar.close();
					            result.close();
					            
					            conectar=null;
					            result=null;
				            
				            } 
		        catch (SQLException ex) 
			        {
			            
			            JOptionPane.showMessageDialog(null, ex);
			        
			        }
		    
		    }
	
		}
	    

	}
      
	public void consultar_turno(JComboBox cb_turno)
	{

	//Creamos objeto tipo Connection    
	java.sql.Connection conectar = null;    
	PreparedStatement pst = null;
	ResultSet result = null;

	//Creamos la Consulta SQL
	String SQL = "SELECT nombre_turno FROM turno";

	//Establecemos bloque try-catch-finally
		try 
		{
		       
		   //Establecemos conexión con la BD 
			Conexion con = new Conexion();
	        Connection c=(Connection) con.conexion();  
		   //Preparamos la consulta SQL
		   pst = c.prepareStatement(SQL);
		   //Ejecutamos la consulta
		   result = pst.executeQuery();
		   
		   cb_turno.addItem("Seleccione una opción");
			   
		   
		   while ( result.next())
			   
		   {
			   cb_turno.addItem(result.getString("nombre_turno"));
		   }
		   		   
		  
		   
		  
		     //System.out.println(turnos);
		} 
	catch (SQLException e) 
		{
	
		    JOptionPane.showMessageDialog(null, e);
		    
		}
		
	finally
		{
	
		    if(conectar!=null)
		    {
		        
				        try {
				        
					            conectar.close();
					            result.close();
					            
					            conectar=null;
					            result=null;
				            
				            } 
		        catch (SQLException ex) 
			        {
			            
			            JOptionPane.showMessageDialog(null, ex);
			        
			        }
		    
		    }
	
		}
	    

	}
	
	
	
	

}

