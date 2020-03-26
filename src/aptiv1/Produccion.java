package aptiv1;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.Connection;

import conexion.Conexion;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Produccion extends JFrame {

	private JPanel contentPane;
	private JTextField txtgafete;
	private JTextField txtfinal;
	private JTextField txtdefectos;
	private JTextField txtcodigo;
	
	Combo combo = new Combo();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Produccion frame = new Produccion();
					 frame.setLocationRelativeTo(null);
	                 frame.setResizable(false);
	               	frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Produccion() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 573, 495);
		contentPane = new Fondo();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblGafete = new JLabel("# Gafete");
		lblGafete.setForeground(Color.WHITE);
		lblGafete.setBounds(29, 86, 63, 14);
		contentPane.add(lblGafete);
		
		txtgafete = new JTextField();
		txtgafete.setBounds(91, 83, 143, 21);
		contentPane.add(txtgafete);
		txtgafete.setColumns(10);
		
		JLabel lblEstacion = new JLabel("Estacion:");
		lblEstacion.setForeground(Color.WHITE);
		lblEstacion.setBounds(29, 128, 63, 14);
		contentPane.add(lblEstacion);
		
		
		JComboBox cb_estacion = new JComboBox();
		combo.consultar_estacion(cb_estacion);
		cb_estacion.setBounds(101, 125, 133, 21);
		contentPane.add(cb_estacion);
		
		JLabel lblProduccionFinal = new JLabel("Cantidad Producida");
		lblProduccionFinal.setForeground(Color.WHITE);
		lblProduccionFinal.setBounds(307, 125, 120, 21);
		contentPane.add(lblProduccionFinal);
		
		txtfinal = new JTextField();
		txtfinal.setBounds(423, 125, 75, 20);
		contentPane.add(txtfinal);
		txtfinal.setColumns(10);
		
		JLabel lblDefectosOComentarios = new JLabel("Defectos o Comentarios");
		lblDefectosOComentarios.setForeground(Color.WHITE);
		lblDefectosOComentarios.setBounds(41, 258, 152, 14);
		contentPane.add(lblDefectosOComentarios);
		
		txtdefectos = new JTextField();
		txtdefectos.setBounds(203, 203, 204, 125);
		contentPane.add(txtdefectos);
		txtdefectos.setColumns(10);
		
		JLabel lblTurno = new JLabel("Turno");
		lblTurno.setForeground(Color.WHITE);
		lblTurno.setBounds(317, 79, 46, 14);
		contentPane.add(lblTurno);
		
		JComboBox cb_turno = new JComboBox();
		combo.consultar_turno(cb_turno);
		cb_turno.setBounds(360, 76, 115, 24);
		contentPane.add(cb_turno);
		
		JLabel lblCodigoCable = new JLabel("Codigo cable");
		lblCodigoCable.setForeground(Color.WHITE);
		lblCodigoCable.setBounds(9, 171, 83, 21);
		contentPane.add(lblCodigoCable);
		
		txtcodigo = new JTextField();
		txtcodigo.setBounds(101, 171, 133, 21);
		contentPane.add(txtcodigo);
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

			            JOptionPane.showMessageDialog(null, "Producto Guardado");
			          
			           
			         	            

			           

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
				Consult_produccion con= new Consult_produccion();
				 con.setLocationRelativeTo(null);
                 con.setResizable(false);
               	con.setVisible(true);
			}
		});
		btnConsultar.setBounds(292, 395, 135, 28);
		contentPane.add(btnConsultar);
	}
}
