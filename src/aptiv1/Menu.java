package aptiv1;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import conexion.Conexion;

import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.SystemColor;
import javax.swing.JMenuBar;
import javax.swing.SwingConstants;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.Font;

public class Menu extends JFrame {

	private JPanel contentPane;
	public int idacceso;
	

	

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
	 * @param nombre 
	 * @throws SQLException 
	 */
	public Menu(String nombre) throws SQLException {
		getComponents();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 569, 456);
		
		contentPane= new Fondo2();
		//contentPane.setBackground(SystemColor.inactiveCaption);
		
		contentPane.setBorder(new EmptyBorder(5,5,5,5));
    	
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		JButton btnAdministrarOrdenes = new JButton("Administrar cable ");
		btnAdministrarOrdenes.setBounds(185, 66, 186, 38);
		btnAdministrarOrdenes.setForeground(new Color(0, 0, 0));
		btnAdministrarOrdenes.setBackground(Color.WHITE);
		btnAdministrarOrdenes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				Administracable f=new Administracable();
            	//f.setExtendedState(MAXIMIZED_BOTH);
            	f.setSize(800,600);
            	f.setLocationRelativeTo(null);
            	f.setResizable(false);
            	f.setVisible(true);
				
			
			}
		});
		
		
		contentPane.add(btnAdministrarOrdenes);
		
		JButton btnControlInventario = new JButton("Control Inventario");
		btnControlInventario.setBounds(185, 227, 186, 42);
		btnControlInventario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				Admin_inventario f=new Admin_inventario();
            	//f.setExtendedState(MAXIMIZED_BOTH);
            	f.setSize(800,600);
            	f.setLocationRelativeTo(null);
            	f.setResizable(false);
            	f.setVisible(true);
				
			}
		});
		
		contentPane.add(btnControlInventario);
		
		JButton btnAdministrarPersonal = new JButton("Administrar Personal");
		btnAdministrarPersonal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Admin_Personal per=new Admin_Personal();
				per.setSize(800,600);
            	per.setLocationRelativeTo(null);
            	per.setResizable(false);
            	per.setVisible(true);
			}
		});
		btnAdministrarPersonal.setBounds(185, 168, 186, 38);
		
		contentPane.add(btnAdministrarPersonal);
		
		JLabel lblBienvenido = new JLabel("Bienvenido:");
		lblBienvenido.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblBienvenido.setForeground(Color.WHITE);
		lblBienvenido.setBounds(361, 8, 80, 14);
		contentPane.add(lblBienvenido);
		
		
		JLabel lblYVer = 
				new JLabel();
		lblYVer.setBounds(232, 8, 67, 20);
		contentPane.add(lblYVer);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon("C:\\Users\\ElGabino\\Pictures\\aptiv_logo_color_rgb.png"));
		label_1.setBounds(0, 2, 152, 53);
		ImageIcon foto5= new ImageIcon("C:\\Users\\ElGabino\\Pictures\\aptiv_logo_color_rgb.png");
		ImageIcon icono_linea5 = new ImageIcon(foto5.getImage().getScaledInstance(label_1.getWidth(), label_1.getHeight(), Image.SCALE_DEFAULT));
		label_1.setIcon(icono_linea5);
		contentPane.add(label_1);
		
		JButton btnAdministrarCableTratado = new JButton("Administrar cable tratado ");
		btnAdministrarCableTratado.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				Administracable2 f=new Administracable2();
            	//f.setExtendedState(MAXIMIZED_BOTH);
            	f.setSize(800,600);
            	f.setLocationRelativeTo(null);
            	f.setResizable(false);
            	f.setVisible(true);
				
				
			}
		});
		btnAdministrarCableTratado.setForeground(Color.BLACK);
		btnAdministrarCableTratado.setBackground(Color.WHITE);
		btnAdministrarCableTratado.setBounds(185, 115, 186, 42);
		contentPane.add(btnAdministrarCableTratado);
		
		JLabel lblAdministrarCableTratado = new JLabel("");
		lblAdministrarCableTratado.setBounds(87, 176, 165, 20);
		contentPane.add(lblAdministrarCableTratado);
		
		JButton btnEstaciones = new JButton("Estaciones");
		btnEstaciones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 Adminestaciones tur= new Adminestaciones();
		    	 tur.setVisible(true);
		    	 tur.setSize(800,600);
		    	 tur.setLocationRelativeTo(null);
		    	 tur.setResizable(false);
				
			}
		});
		btnEstaciones.setBounds(185, 293, 186, 38);
		contentPane.add(btnEstaciones);
		String usua="";
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
		
        JLabel label = new JLabel();
		label.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label.setText(usua);
		label.setForeground(Color.WHITE);
		label.setBounds(440, 5, 80, 20);
		contentPane.add(label);
		
       
		
	
		
		
		

		
	}
}
