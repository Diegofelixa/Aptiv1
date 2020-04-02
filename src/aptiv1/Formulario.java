package aptiv1;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.Connection;

import Atxy2k.CustomTextField.RestrictedTextField;
import conexion.Conexion;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Formulario extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtCodigo;
	private JTextField txtColor;
	private JTextField txtLongitud;
	private JTextField txtNumero_hilos;
	private JTextField txtCalibre;
	private JTextField txtAislante;
	public int nuevo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
				
		
	}
	
	
	/**
	 * Create the dialog.
	 * @param b 
	 * @param administracable 
	 */
	public Formulario(Administracable administracable, boolean b){
		setBounds(100, 100, 325, 409);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(173, 216, 230));
		panel.setBounds(0, 0, 317, 50);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		JLabel lblRegistrar = new JLabel("Registrar");
		lblRegistrar.setFont(new Font("Arial", Font.BOLD, 15));
		lblRegistrar.setBounds(28, 11, 116, 28);
		panel.add(lblRegistrar);
		
		JLabel label = new JLabel();
		label.setForeground(new Color(0, 191, 255));
		label.setText("C\u00F3digo");
		label.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label.setBounds(66, 79, 37, 15);
		contentPanel.add(label);
		
		txtCodigo = new JTextField();
		txtCodigo.setForeground(new Color(0, 0, 0));
		txtCodigo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtCodigo.setBounds(142, 73, 150, 21);
		RestrictedTextField restricted = new RestrictedTextField(txtCodigo);
		//restricted.setOnlyNums(true);
		restricted.setLimit(8);
		contentPanel.add(txtCodigo);
		
		JLabel label_1 = new JLabel();
		label_1.setForeground(new Color(0, 191, 255));
		label_1.setText("Color");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_1.setBounds(76, 116, 27, 15);
		contentPanel.add(label_1);
		
		txtColor = new JTextField();
		txtColor.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtColor.setBounds(142, 113, 150, 21);
		 restricted = new RestrictedTextField(txtColor);
			restricted.setOnlyText(true);
			restricted.setLimit(20);
		contentPanel.add(txtColor);
		
		JLabel label_2 = new JLabel();
		label_2.setForeground(new Color(0, 191, 255));
		label_2.setText("Longitud");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_2.setBounds(65, 160, 48, 15);
		contentPanel.add(label_2);
		
		txtLongitud = new JTextField();
		txtLongitud.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtLongitud.setBounds(142, 154, 150, 21);
		 restricted = new RestrictedTextField(txtColor);
			restricted.setOnlyNums(true);
			restricted.setLimit(5);
		contentPanel.add(txtLongitud);
		
		JLabel label_3 = new JLabel();
		label_3.setForeground(new Color(0, 191, 255));
		label_3.setText("Numero de Hilos");
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_3.setBounds(24, 189, 89, 15);
		contentPanel.add(label_3);
		
		txtNumero_hilos = new JTextField();
		txtNumero_hilos.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtNumero_hilos.setBounds(151, 186, 141, 21);
		 restricted = new RestrictedTextField(txtColor);
			restricted.setOnlyNums(true);
			restricted.setLimit(4);
		contentPanel.add(txtNumero_hilos);
		
		JLabel label_4 = new JLabel();
		label_4.setForeground(new Color(0, 191, 255));
		label_4.setText("Calibre");
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_4.setBounds(64, 221, 49, 15);
		contentPanel.add(label_4);
		
		txtCalibre = new JTextField();
		txtCalibre.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtCalibre.setBounds(142, 218, 150, 21);
		 restricted = new RestrictedTextField(txtColor);
			restricted.setOnlyNums(true);
			restricted.setLimit(2);
		contentPanel.add(txtCalibre);
		
		JLabel label_5 = new JLabel();
		label_5.setText("Aislante");
		label_5.setForeground(new Color(0, 191, 255));
		label_5.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_5.setBounds(60, 267, 53, 15);
		contentPanel.add(label_5);
		
		txtAislante = new JTextField();
		txtAislante.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtAislante.setBounds(142, 264, 150, 21);
		 restricted = new RestrictedTextField(txtColor);
			restricted.setOnlyText(true);
			restricted.setLimit(6);
		contentPanel.add(txtAislante);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBounds(0, 311, 337, 38);
			contentPanel.add(buttonPane);
			buttonPane.setLayout(null);
			
			JButton btnRegistrar = new JButton("Registrar");
			btnRegistrar.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					Administracable ad=new Administracable();
					 PreparedStatement ps = null;
				        try {
				            Conexion objCon = new Conexion();
				            Connection conn = (Connection) objCon.conexion();
				            ps = conn.prepareStatement("INSERT INTO cable ( leadcode, color, longuitud, numero_hilos, calibre, aislante) VALUES (?,?,?,?,?,?)");
				            
				            ps.setString(1, txtCodigo.getText());
				            ps.setString(2, txtColor.getText());
				            ps.setString(3, txtLongitud.getText());
				            ps.setString(4, txtNumero_hilos.getText());
				            ps.setString(5, txtCalibre.getText());
				            ps.setString(6, txtAislante.getText());

				            ps.execute();

				            JOptionPane.showMessageDialog(null, "Producto Guardado");
				          
				           
				           
				            dispose();
				            

				           

				        } catch (SQLException ex) {
				            JOptionPane.showMessageDialog(null, "Error al Guardar Producto");
				            System.out.println(ex);
				        }
				    }//GEN-LAST:event_btnGuardarActionPerformed

				
			});
			btnRegistrar.setBounds(76, 5, 95, 23);
			btnRegistrar.setBackground(Color.WHITE);
			btnRegistrar.setForeground(new Color(0, 0, 0));
			buttonPane.add(btnRegistrar);
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent arg0) {
						dispose();
					}
				});
				cancelButton.setBounds(203, 5, 84, 23);
				cancelButton.setBackground(Color.WHITE);
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
