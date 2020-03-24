package aptiv1;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.ImageIcon;

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
		btnAgregar.setIcon(new ImageIcon(Produccion.class.getResource("/imagenes/guadar.png")));
		btnAgregar.setBounds(214, 397, 120, 29);
		contentPane.add(btnAgregar);
	}
}
