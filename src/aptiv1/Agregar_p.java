package aptiv1;

import java.awt.Container;


import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JTextField;

import org.apache.commons.codec.digest.DigestUtils;

import com.mysql.jdbc.Connection;

import Atxy2k.CustomTextField.RestrictedTextField;
import conexion.Conexion;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

import com.toedter.calendar.JDateChooser;


public class Agregar_p extends JFrame {
	
	private JTextField txt_nombre;
	private JTextField txt_apellido;
	private JTextField txt_ngafete;
	
	public JComboBox cb_estacion;
	Combo combo = new Combo();
	Conexion objCon = new Conexion();
	RestrictedTextField rt;
	Admin_Personal admin = new Admin_Personal();
	
	
	public Agregar_p() 
	{
		
		
		
		
		setBounds(100, 100, 462, 383);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		ImageIcon foto2 = new ImageIcon ("C:\\Users\\Ricardo Hernandez\\eclipse-workspace\\aptiv\\src\\imagenes\\aptiv_logo_color_rgb.png");
		
		JLabel lbl_nombre = new JLabel("Nombre");
		lbl_nombre.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lbl_nombre.setBounds(38, 36, 116, 29);
		getContentPane().add(lbl_nombre);
		
		JLabel lbl_apellido = new JLabel("Apellido");
		lbl_apellido.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lbl_apellido.setBounds(261, 40, 108, 20);
		getContentPane().add(lbl_apellido);
		
		txt_nombre = new JTextField();
		txt_nombre.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		txt_nombre.setBounds(38, 64, 148, 20);
		getContentPane().add(txt_nombre);
		txt_nombre.setColumns(10);
		
		rt = new RestrictedTextField(txt_nombre);
		rt.setLimit(30);
		
		rt.setOnlyText(true);
		rt.setAcceptSpace(true);
		
		
		
		
		txt_apellido = new JTextField();
		txt_apellido.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		txt_apellido.setBounds(249, 64, 148, 20);
		getContentPane().add(txt_apellido);
		txt_apellido.setColumns(10);
		//rt = new RestrictedTextField(txt_apellido);
		rt.setLimit(30);
		rt.setOnlyText(true);
		rt.setAcceptSpace(true);
		
		JLabel lbl_ngafete = new JLabel("N\u00FAmero de Gaffete");
		lbl_ngafete.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lbl_ngafete.setBounds(38, 104, 189, 26);
		getContentPane().add(lbl_ngafete);
		
		JLabel lbl_fecha_nac = new JLabel("Fecha de Nacimiento");
		lbl_fecha_nac.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lbl_fecha_nac.setBounds(249, 104, 167, 20);
		getContentPane().add(lbl_fecha_nac);
		
		txt_ngafete = new JTextField();
		txt_ngafete.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		txt_ngafete.setColumns(10);
		txt_ngafete.setBounds(38, 132, 148, 20);
		getContentPane().add(txt_ngafete);
		rt.setOnlyNums(true);
		//v.res(txt_ngafete,8);
		rt.setLimit(8);
		rt.setOnlyNums(true);
		
		rt = new RestrictedTextField(txt_ngafete);
		rt.setLimit(8);
		rt.setOnlyNums(true);
		//restricted();
	
		
		JLabel lbl_turno = new JLabel("Turno");
		lbl_turno.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lbl_turno.setBounds(38, 163, 99, 26);
		getContentPane().add(lbl_turno);
		
		JLabel lbl_estacion = new JLabel("Estaci\u00F3n de Trabajo");
		lbl_estacion.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lbl_estacion.setBounds(249, 163, 189, 26);
		getContentPane().add(lbl_estacion);
		
		JComboBox cb_turno = new JComboBox();
		//Combo combo = new Combo();
		combo.consultar_turno(cb_turno);
		cb_turno.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		cb_turno.setBounds(38, 189, 148, 20);
		getContentPane().add(cb_turno);
		
	     
		
		JComboBox cb_estacion = new JComboBox();
		//Combo combo = new Combo();
		combo.consultar_estacion(cb_estacion);
		cb_estacion.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		cb_estacion.setBounds(249, 189, 148, 20);
		getContentPane().add(cb_estacion);
			
		
		JComboBox cb_privilegio = new JComboBox();
		cb_privilegio.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		cb_privilegio.addItem("Seleccione una opcion");
		cb_privilegio.addItem("Administrador");
		cb_privilegio.addItem("Lider-Soporte");
		cb_privilegio.addItem("Operador");
		
		
		
		cb_privilegio.setBounds(158, 234, 137, 20);
		getContentPane().add(cb_privilegio);
		//dc_fecha.setDateFormatString("dd-MM-yyyy"); 
		

		 Date dc_fechas = new Date();
		 SimpleDateFormat sdf = new SimpleDateFormat ();
		 String s = sdf.format(dc_fechas);
	
		JButton btn_registrar = new JButton("Registrar");
		btn_registrar.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseClicked(MouseEvent arg0) 
			{
				int Privilegios=0;
			    
				if ( cb_privilegio.getSelectedItem().toString() == "Administrador"  )
				  {
					Privilegios = 1; 
				  }
			    
				else if ( cb_privilegio.getSelectedItem().toString() == "Lider-Soporte"  )
				  {
					Privilegios = 2; 
				  }
			
				else if ( cb_privilegio.getSelectedItem().toString() == "Operador"  )
				  {
					Privilegios = 3; 
				  }
				
				
				PreparedStatement ps = null;
				
				
				try {
						
					   String contraencriptadamd5=DigestUtils.md5Hex(s);
			        	
					    String encriptadaconsha= DigestUtils.sha1Hex(contraencriptadamd5); 
					      
					       //Conexion objCon = new Conexion();
			              Connection conn = (Connection) objCon.conexion();
						
			              ps = conn.prepareStatement("INSERT INTO `acceso`( `usuario`, `contra`, `privilegios`) VALUES (?,?,?) ");
						
			              ps.setString(1, txt_ngafete.getText());
			              ps.setString(2, encriptadaconsha);
			              ps.setInt(3, Privilegios);
			              ps.execute();
			              
			              //res = ps.executeUpdate();
			              
			            
			                ps= conn.prepareStatement("INSERT INTO operador (id_ngafet, nombre,apellido, estacion, fk_turno, fk_acceso) VALUES (?,?,?,(SELECT id_estacion FROM estacion WHERE nombre_estacion =  '"+ cb_estacion.getSelectedItem().toString() + "' ), (SELECT id_turno FROM turno WHERE nombre_turno = '"+cb_turno.getSelectedItem().toString()+"' ), (SELECT id_acceso FROM acceso WHERE usuario = '"+  txt_ngafete.getText() +"'  ))");

				            ps.setString(1, txt_ngafete.getText());
				            ps.setString(2, txt_nombre.getText());
				            ps.setString(3, txt_apellido.getText());
				            ps.execute();
				            
				           
				            
				            JOptionPane.showMessageDialog(null, "Registro Exitoso");
				          
				             
				         
				} 
		        
		        catch (SQLException ex) 
				{
		            JOptionPane.showMessageDialog(null, "Error al Guardar Registro Completo ");
		            System.out.println(ex);
		        }
		
				
			}
		});
		btn_registrar.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		btn_registrar.setBounds(173, 300, 108, 29);
		getContentPane().add(btn_registrar);
		
	
		
		JLabel lbl_privilegio = new JLabel("Privilegio");
		lbl_privilegio.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lbl_privilegio.setBounds(63, 232, 123, 29);
		getContentPane().add(lbl_privilegio);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(248, 130, 153, 22);
		getContentPane().add(dateChooser);
		
		}
	
 /*	private void restricted (java.awt.event.KeyEvent evt )
	{
		int num=8;
		
		if (txt_ngafete.getText().length() == num )
		{
			evt.consume();
			JOptionPane.showMessageDialog(rootPane, " Error, El Gafet debe de ser minimo 8 caracteres  ");
		}
	}
*/
}
