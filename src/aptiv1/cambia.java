package aptiv1;

import java.awt.BorderLayout;




import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import Atxy2k.CustomTextField.RestrictedTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.commons.codec.digest.DigestUtils;

import com.mysql.jdbc.Connection;

import conexion.Conexion;
import javax.swing.JPasswordField;

public class cambia extends JDialog 
{

	private final JPanel contentPanel = new JPanel();
	RestrictedTextField rt;
	Conexion objCon = new Conexion();
	public JPasswordField pf_Ncontra;
	public JPasswordField pf_Ccontra;

	
	public static void main(String arg0) 
	{
		
	}
 
	
	public cambia(String usua) 
	{
		setTitle("Cambiar Contrase\u00F1a");
		setBounds(100, 100, 301, 258);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
				{
					JLabel lblNewLabel_1 = new JLabel("Nueva Contrase\u00F1a");
					lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
					lblNewLabel_1.setBounds(12, 68, 118, 16);
					contentPanel.add(lblNewLabel_1);
				}
							{
								JLabel lblNewLabel_2 = new JLabel("Confirmar Contrase\u00F1a");
								lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 16));
								lblNewLabel_2.setBounds(12, 129, 141, 16);
								contentPanel.add(lblNewLabel_2);
							}
		
										{
											JLabel lbl_letrero = new JLabel("Actualizaci\u00F3n de Contrase\u00F1a");
											lbl_letrero.setFont(new Font("Times New Roman", Font.PLAIN, 18));
											lbl_letrero.setBounds(25, 13, 217, 42);
											contentPanel.add(lbl_letrero);
										}
		
		pf_Ncontra = new JPasswordField();
		pf_Ncontra.setBounds(165, 66, 93, 22);
		contentPanel.add(pf_Ncontra);
		rt= new RestrictedTextField(pf_Ncontra);
		rt.setLimit(8);
		//rt.setOnlyText(true);
		
		pf_Ccontra = new JPasswordField();
		pf_Ccontra.setBounds(165, 127, 93, 22);
		rt= new RestrictedTextField(pf_Ccontra);
		rt.setLimit(8);
		//rt.setOnlyText(true);
		contentPanel.add(pf_Ccontra);
			{
				JPanel buttonPane = new JPanel();
				buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
				getContentPane().add(buttonPane, BorderLayout.SOUTH);
				{
						JButton okButton = new JButton("Cambiar Contrase\u00F1a");
						okButton.addMouseListener(new MouseAdapter() 
						{ 
							
							
							
							@Override
							public void mouseClicked(MouseEvent e) 
							{
								PreparedStatement ps = null;
								
								int tam1=pf_Ncontra.getText().length();
								int tam2=pf_Ccontra.getText().length();
							
								
								
								if ((tam1 & tam2) == 8)
								
								try 
								    {
									         String entrada1;
									         String entrada2;
									         String entrada;
											   
											   entrada = pf_Ncontra.getText();		   
											//   JOptionPane.showMessageDialog(null, "el num de mayus es ----> " + Mayus(entrada));   
											
											  // JOptionPane.showMessageDialog(null, "el num de num es ----> " + Numeros(entrada));
											   
											  // JOptionPane.showMessageDialog(null, "el num de especiales es ----> " + Especiales(entrada));
											   
										
										    Connection conn = (Connection) objCon.conexion();
										    
										    ps = conn.prepareStatement("SELECT op.id_ngafet FROM operador op INNER join acceso a on a.usuario=op.id_ngafet WHERE op.nombre= '"+usua +"'");
										    ps.execute();
										    
										    String c1=pf_Ncontra.getText();
										    String c2=pf_Ccontra.getText();
										    entrada1=pf_Ncontra.getText();
										            
										    entrada2=pf_Ccontra.getText();
										 
										   if (Mayus(entrada)>=1 &&  Numeros(entrada)>=1 && Especiales(entrada)>=1) 
										   {
										    
											    if (c1.equals(c2))
												    {
											    	    
											    	    String contraencriptadamd5=DigestUtils.md5Hex(pf_Ncontra.getText());
											        	
										                String encriptadaconsha= DigestUtils.sha1Hex(contraencriptadamd5);
											    	    ps = conn.prepareStatement("UPDATE acceso a JOIN operador op ON a.usuario=op.id_ngafet SET a.contra= '"+ encriptadaconsha + "' WHERE op.id_ngafet= '"+usua +"'");
											    	    ps.execute();                                                                                        
											       
											    	     
											    	    JOptionPane.showMessageDialog(null, " Se modifico la contraseña a ---> " + usua);
											    	}
											    	
											    	  else 
														    {
												    		  JOptionPane.showMessageDialog(null, " Error las Contraseñas no coinciden ");
														    }
								    
										   }// if entrada 
										   
										   else 
										   { 
											   JOptionPane.showMessageDialog(null, " la contraseña debe tener al menos 1 mayuscula, 1 numero y un Caracter Especial ");    
										   }
								
								    }// try  
								 
								catch (SQLException ex) 
									{
							           JOptionPane.showMessageDialog(null, " Error al Modificar la Contraseña ");
							           System.out.println(ex);
							        } 
							   
										else 
											{
											  JOptionPane.showMessageDialog(null, " Error, la contraseña minimo debe tener 8 caracteres ");	
											}
								
							
							}
								});
								okButton.setFont(new Font("Times New Roman", Font.PLAIN, 16));
								okButton.setActionCommand("OK");
								buttonPane.add(okButton);
								getRootPane().setDefaultButton(okButton);
					
				}// termina botón cambia contra 
								
				              {
									JButton cancelButton = new JButton("Cancel");
									cancelButton.addMouseListener(new MouseAdapter() 
									{
										@Override
										public void mouseClicked(MouseEvent e) 
											{
											   dispose();
											}
									});
									cancelButton.setFont(new Font("Times New Roman", Font.PLAIN, 16));
									cancelButton.setActionCommand("Cancel");
									buttonPane.add(cancelButton);
							}
			                                    
				     
			
			
			
			 }// termina pf_Ccontra
	
			
	
	 }// termina metodo cambia

	
	public static int Mayus (String cadena) 
	{
		    int numero=0;
		    
		    for (int i=0; i < cadena.length(); i++) 
			    {
				        if ( cadena.charAt(i)>=65 && cadena.charAt(i)<=90) 
					        {
					           numero++;  	
					        }
			    }
			
					return numero;
		
	 }

							public static int Numeros (String cadena) 
							{
								    int numero=0;
								    
								    for (int i=0; i < cadena.length(); i++) 
									    {
										        if ( cadena.charAt(i)>=48 && cadena.charAt(i)<=57) 
											        {
											           numero++;  	
											        }
									    }
									
											return numero;
								
							 }
	
	
							
							
												public static int Especiales (String cadena) 
												{
													    int numero=0;
													    
													    for (int i=0; i < cadena.length(); i++) 
														    {
															        if ( cadena.charAt(i)>=33 && cadena.charAt(i)<=47 || cadena.charAt(i)>=58 && cadena.charAt(i)<=64 || cadena.charAt(i)>=128 && cadena.charAt(i)<=255) 
																        {
																           numero++;  	
																        }
														    }
														
																return numero;
													
											  }
	
	
	
}// termina clase principal
