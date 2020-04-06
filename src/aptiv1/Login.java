package aptiv1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import Atxy2k.CustomTextField.RestrictedTextField;
import conexion.Conexion;
//import controlador.Menu;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import org.apache.commons.codec.digest.DigestUtils;

import javax.swing.JPasswordField;
import java.awt.Color;

public class Login  {

	private JFrame frmLogin;
	public JTextField txtusuario;
	private JPasswordField passwordField;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
	
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frmLogin.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
		
		
	}
	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		
		Fondo fondo=new Fondo();
		
		frmLogin = new JFrame();
		frmLogin.setResizable(false);
		frmLogin.setTitle("Login");
		frmLogin.setBounds(100, 100, 354, 372);
		frmLogin.setLocationRelativeTo(null);
		frmLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLogin.setContentPane(fondo);
		frmLogin.getContentPane().setLayout(null);
		
			
		
		JLabel lblUsuario = new JLabel("USUARIO:");
		lblUsuario.setForeground(new Color(255, 69, 0));
		lblUsuario.setBounds(44, 180, 82, 25);
		lblUsuario.setFont(new Font("Tahoma", Font.BOLD, 14));
		frmLogin.getContentPane().add(lblUsuario);
		
		JLabel lblContrasea = new JLabel("CONTRASE\u00D1A:");
		lblContrasea.setForeground(new Color(255, 69, 0));
		lblContrasea.setBounds(26, 216, 105, 25);
		lblContrasea.setFont(new Font("Tahoma", Font.BOLD, 14));
		frmLogin.getContentPane().add(lblContrasea);
		
		txtusuario = new JTextField();
		txtusuario.setBounds(151, 179, 146, 30);
		RestrictedTextField restricted = new RestrictedTextField(txtusuario);
		restricted.setOnlyNums(true);
		restricted.setLimit(8);
		frmLogin.getContentPane().add(txtusuario);
		txtusuario.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(151, 216, 146, 29);
		 restricted = new RestrictedTextField(passwordField);
		//restricted.setOnlyNums(true);
		restricted.setLimit(8);
		frmLogin.getContentPane().add(passwordField);
		
      	
      
		
		
	String contraencriptadamd5=DigestUtils.md5Hex(passwordField.getText());
	String encriptadaconsha= DigestUtils.sha1Hex(contraencriptadamd5);
    

	
		
		JButton btnIniciarSecion = new JButton("INICIAR SESION");
		btnIniciarSecion.setBounds(110, 292, 129, 25);
		btnIniciarSecion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				try{
		            Conexion con = new Conexion();
		            Connection c=(Connection) con.conexion();
		            //System.out.println(encriptadaconsha);
		            if(txtusuario.getText().length()==0) {
		               // JOptionPane.showMessageDialog(null, "");
		            }else if(c!=null){
		                PreparedStatement selec_pat =(PreparedStatement) c.prepareStatement("SELECT id_acceso, privilegios FROM acceso where usuario ='"+txtusuario.getText()+"'AND contra='"+ 
		               	encriptadaconsha+"';");
		                ResultSet rs= selec_pat.executeQuery();
		               
		                if(rs.next()){		        
		                	
		                	if(rs.getInt("privilegios")== 1) {
		                		
		                		String nombre=txtusuario.getText();
		 		                 Menu menu=new Menu(nombre);                 
		 		                 menu.setLocationRelativeTo(null);
		 		                 menu.setResizable(false);
		 		                 menu.setVisible(true);
		 		                 frmLogin.setVisible(false);
		 		                 rs.next();
		                	} else if(rs.getInt("privilegios")== 3 ){
		                		String nombre=txtusuario.getText();
		                		int privilegio=rs.getInt("privilegios");
		                		 Produccion menu= new Produccion(privilegio, nombre);		                 
		 		                 menu.setLocationRelativeTo(null);
		 		                 menu.setResizable(false);
		 		                 menu.setVisible(true);
		 		                 frmLogin.setVisible(false);
		 		                rs.next();
		                	} else if(rs.getInt("privilegios")== 2 ){
		                		String nombre=txtusuario.getText();
		                		int privilegio=rs.getInt("privilegios");
		                		 Consult_produccion menu= new Consult_produccion(privilegio, nombre);		                 
		 		                 menu.setLocationRelativeTo(null);
		 		                 menu.setResizable(false);
		 		                 menu.setVisible(true);
		 		                 frmLogin.setVisible(false);
		 		                rs.next();
		                	}
		            
		               
	                   
		               // JOptionPane.showMessageDialog(frame,contraencriptadamd5);
		                //JOptionPane.showMessageDialog(frame,encriptadaconsha);

		                
		                }else{
		                    JOptionPane.showMessageDialog(null,"Usuario o contraseña incorrecta!!!");
		    		txtusuario.setText("");
		    		passwordField.setText("");
		                }
				
		            }
				
			}catch(SQLException e1){
		        JOptionPane.showMessageDialog(null,e1.getMessage());
	        }
				
				
			}
		});
		frmLogin.getContentPane().add(btnIniciarSecion);
		
		
		JLabel lblBienvenido = new JLabel("BIENVENIDO");
		lblBienvenido.setForeground(Color.BLACK);
		lblBienvenido.setBounds(89, 87, 161, 30);
		lblBienvenido.setHorizontalAlignment(SwingConstants.CENTER);
		lblBienvenido.setFont(new Font("Arial", Font.PLAIN, 20));
		frmLogin.getContentPane().add(lblBienvenido);
		
		JLabel logo = new JLabel();
		logo.setBounds(72, 11, 202, 66);
		logo.setIcon(new ImageIcon(Login.class.getResource("/imagenes/logo.png")));	
		ImageIcon foto2 = new ImageIcon("/imagenes/logo.png");
		ImageIcon icono_linea2 = new ImageIcon(foto2.getImage().getScaledInstance(logo.getWidth(), logo.getHeight(), Image.SCALE_DEFAULT));
		logo.setIcon(icono_linea2);
		fondo.add(logo);
		logo.repaint();
		
	}
}
