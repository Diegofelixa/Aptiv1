package aptiv1;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.Connection;

import Atxy2k.CustomTextField.RestrictedTextField;
import conexion.Conexion;

import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.ImageIcon;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.Font;

public class Produccion extends JFrame {

	private JPanel contentPane;
	private JTextField txtgafete;
	private JTextField txtfinal;
	private JTextField txtdefectos;
	private JTextField txtcodigo;
	
	Combo combo = new Combo();
	String usua="";
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				
			}
		});
	}

	/**
	 * Create the frame.
	 * @param privilegio 
	 * @param nombre 
	 * @throws SQLException 
	 */
	public Produccion(int privilegio, String nombre) throws SQLException {
		if (nombre!=null) 
		{
			Conexion con = new Conexion();
	        Connection c=(Connection) con.conexion();
			PreparedStatement selec_pat2 =(PreparedStatement)
		    c.prepareStatement("select nombre from operador where fk_acceso=(select id_acceso from acceso where usuario="+nombre+")");
			ResultSet rs2= selec_pat2.executeQuery();
			if(rs2.next()) 
				{
				 	usua = rs2.getString("nombre");
				}
		}
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mn_menu = new JMenu("Opciones ");
		//mn_menu.setIcon(new ImageIcon(Menu.class.getResource("/imagenes/configurar.png")));
		menuBar.add(mn_menu);
	
		
		JMenuItem mi_cc = new JMenuItem("Cambiar Contraseña");
		mi_cc.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
			  cambia C= new cambia(usua);
			  C.setVisible(true);
			  
			}
		});
		
		mn_menu.add(mi_cc);
		
		JMenuItem mi_cs = new JMenuItem("Cerrar Sesión");
		mi_cs.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
				{
					  int respuesta= JOptionPane.showConfirmDialog(null, "esta a punto de cerrar su sesión "," Estas Seguro? ", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE); 
					 
					  if(respuesta==JOptionPane.YES_OPTION) 
						  {
							 System.exit(0);
						  }
				
		       }
		});
		
		
		mn_menu.add(mi_cs);
		
		
		
		if (nombre!=null) {
			Conexion con = new Conexion();
	        Connection c=(Connection) con.conexion();
			PreparedStatement selec_pat2 =(PreparedStatement)
		    c.prepareStatement("select nombre from operador where fk_acceso=(select id_acceso from acceso where usuario="+nombre+")");
			ResultSet rs2= selec_pat2.executeQuery();
			if(rs2.next()) {
			 usua = rs2.getString("nombre");
			}
		}
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 573, 495);
		contentPane = new Fondo();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblGafete = new JLabel("# Gafete");
		lblGafete.setForeground(Color.WHITE);
		lblGafete.setBounds(30, 86, 63, 14);
		contentPane.add(lblGafete);
		
		txtgafete = new JTextField();
		txtgafete.setBounds(92, 83, 143, 21);
		RestrictedTextField restricted = new RestrictedTextField(txtgafete);
		//restricted.setOnlyNums(true);
		restricted.setLimit(8);
		contentPane.add(txtgafete);		
		txtgafete.setColumns(10);
		
		JLabel lblEstacion = new JLabel("Estacion:");
		lblEstacion.setForeground(Color.WHITE);
		lblEstacion.setBounds(30, 128, 63, 14);
		contentPane.add(lblEstacion);
		
		
		JComboBox cb_estacion = new JComboBox();
		combo.consultar_estacion(cb_estacion);
		cb_estacion.setBounds(102, 125, 133, 21);
		contentPane.add(cb_estacion);
		
		JLabel lblProduccionFinal = new JLabel("Cantidad Producida");
		lblProduccionFinal.setForeground(Color.WHITE);
		lblProduccionFinal.setBounds(307, 125, 120, 21);
		contentPane.add(lblProduccionFinal);
		
		txtfinal = new JTextField();
		txtfinal.setBounds(423, 125, 75, 20);
		 restricted = new RestrictedTextField(txtfinal);
		restricted.setOnlyNums(true);
		restricted.setLimit(5);
		contentPane.add(txtfinal);
		txtfinal.setColumns(10);
		
		JLabel lblDefectosOComentarios = new JLabel("Defectos o Comentarios");
		lblDefectosOComentarios.setForeground(Color.WHITE);
		lblDefectosOComentarios.setBounds(42, 258, 152, 14);
		contentPane.add(lblDefectosOComentarios);
		
		txtdefectos = new JTextField();
		txtdefectos.setBounds(204, 203, 204, 125);
		 restricted = new RestrictedTextField(txtdefectos);
			restricted.setOnlyText(true);
			restricted.setLimit(50);
		contentPane.add(txtdefectos);
		txtdefectos.setColumns(10);
		
		JLabel lblTurno = new JLabel("Turno");
		lblTurno.setForeground(Color.WHITE);
		lblTurno.setBounds(317, 79, 46, 14);
		contentPane.add(lblTurno);
		
		 
		
		JComboBox cb_turno = new JComboBox();
		combo.consultar_turno(cb_turno);
		cb_turno.setBounds(361, 76, 115, 24);
		contentPane.add(cb_turno);
		
		JLabel lblCodigoCable = new JLabel("Codigo cable");
		lblCodigoCable.setForeground(Color.WHITE);
		lblCodigoCable.setBounds(10, 171, 83, 21);
		contentPane.add(lblCodigoCable);
		
		txtcodigo = new JTextField();
		txtcodigo.setBounds(102, 171, 133, 21);
		contentPane.add(txtcodigo);
		 restricted = new RestrictedTextField(txtcodigo);
			//restricted.setOnlyNums(true);
			restricted.setLimit(8);
		txtcodigo.setColumns(10);
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				 PreparedStatement ps = null;
			        try {
			        	
                        Date date = new Date();
			        	
			        	DateFormat hourdateFormat = new SimpleDateFormat(" yyyy/MM/dd HH:mm:ss");
			        	//System.out.println("Hora y fecha: "+hourdateFormat.format(date));
			            Conexion objCon = new Conexion();
			            Connection conn = (Connection) objCon.conexion();
			            ps = conn.prepareStatement("INSERT INTO produccion ( num_gafet, fk_estacion, cantidad_atados, hora_fecha, defectos, fk_turno, fk_final) VALUES (?,(select id_estacion from estacion where nombre_estacion='"+cb_estacion.getSelectedItem().toString() +"'),?,?,?,(select id_turno from turno where nombre_turno='"+cb_turno.getSelectedItem().toString() +"'),?)");
			            
			            
			            
			            ps.setString(1, txtgafete.getText());
			            ps.setString(2, txtfinal.getText());
			            ps.setString(3,hourdateFormat.format(date));
			            ps.setString(4, txtdefectos.getText());
			            ps.setString(5, txtcodigo.getText());
			            
			            ps.execute();
			            
			            ps=conn.prepareStatement("Insert into inventario( cantidad_atados, fecha_hora, fk_final) values ('"+txtfinal.getText()+"','"+hourdateFormat.format(date)+"','"+ txtcodigo.getText()+"')");
			           

			            ps.execute();
			            

			            JOptionPane.showMessageDialog(null, "Guardado con exito");
			          
			           
			         	    txtgafete.setText("");  
			         	    txtfinal.setText("");
			         	    txtdefectos.setText("");
			         	    txtcodigo.setText("");
			           

			        } catch (SQLException ex) {
			        	
			            JOptionPane.showMessageDialog(null, "Error al Guardar Producto");
			            System.out.println(ex);
			        }
				
				
				
			}
		});
		btnAgregar.setIcon(new ImageIcon(Produccion.class.getResource("/imagenes/guadar.png")));
		btnAgregar.setBounds(142, 395, 120, 29);
		contentPane.add(btnAgregar);
		
		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.setIcon(new ImageIcon(Produccion.class.getResource("/imagenes/editar.png")));
		btnConsultar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Consult_produccion con;
				try {
					con = new Consult_produccion(privilegio, nombre);
					con.setLocationRelativeTo(null);
	                 con.setResizable(false);
	               	con.setVisible(true);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				 
			}
		});
		btnConsultar.setBounds(292, 395, 135, 28);
		contentPane.add(btnConsultar);
		
		JLabel lblUsua = new JLabel("");
		lblUsua.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblUsua.setText(usua);
		lblUsua.setBounds(481, 11, 84, 21);
		contentPane.add(lblUsua);
		
		JLabel lblBienvenido = new JLabel("Bienvenido");
		lblBienvenido.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblBienvenido.setBounds(398, 11, 100, 21);
		contentPane.add(lblBienvenido);
	}
}
