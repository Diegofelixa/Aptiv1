package aptiv1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.Connection;

import conexion.Conexion;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Formularioactualizar extends JDialog {

	private final JPanel contentPanel = new JPanel();
	public JTextField txtCodigo;
	public JTextField txtColor;
	public JTextField txtLongitud;
	public JTextField txtNumero_hilos;
	public JTextField txtCalibre;
	public JTextField txtAislante;
	public JTextField txtid;

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
	public Formularioactualizar(Administracable administracable, boolean b) {
		setBounds(100, 100, 325, 389);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(173, 216, 230));
		panel.setBounds(0, 0, 383, 50);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		JLabel lblRegistrar = new JLabel("Actualizar");
		lblRegistrar.setFont(new Font("Arial", Font.BOLD, 15));
		lblRegistrar.setBounds(57, 11, 116, 28);
		panel.add(lblRegistrar);
		
		txtid = new JTextField();
		txtid.setBounds(243, 16, 25, 20);
		panel.add(txtid);
		//txtid.setVisible(false);
		txtid.setColumns(10);
		
		JLabel label = new JLabel();
		label.setForeground(new Color(0, 191, 255));
		label.setText("C\u00F3digo");
		label.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label.setBounds(66, 79, 37, 15);
		contentPanel.add(label);
		
		
		
		JLabel label_1 = new JLabel();
		label_1.setForeground(new Color(0, 191, 255));
		label_1.setText("Color");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_1.setBounds(76, 116, 27, 15);
		contentPanel.add(label_1);
		
		
		
		JLabel label_2 = new JLabel();
		label_2.setForeground(new Color(0, 191, 255));
		label_2.setText("Longitud");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_2.setBounds(65, 160, 48, 15);
		contentPanel.add(label_2);
		
		
		JLabel label_3 = new JLabel();
		label_3.setForeground(new Color(0, 191, 255));
		label_3.setText("Numero de Hilos");
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_3.setBounds(24, 189, 89, 15);
		contentPanel.add(label_3);
		
		
		
		JLabel label_4 = new JLabel();
		label_4.setForeground(new Color(0, 191, 255));
		label_4.setText("Calibre");
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_4.setBounds(64, 221, 49, 15);
		contentPanel.add(label_4);
		
		
		
		JLabel label_5 = new JLabel();
		label_5.setText("Aislante");
		label_5.setForeground(new Color(0, 191, 255));
		label_5.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_5.setBounds(60, 261, 53, 15);
		contentPanel.add(label_5);
		
		
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBounds(0, 311, 337, 38);
			contentPanel.add(buttonPane);
			buttonPane.setLayout(null);
			
			JButton btnRegistrar = new JButton("Actualizar");
			btnRegistrar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
				}
			});
			btnRegistrar.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					
					
					 
				       
				        PreparedStatement ps = null;
				        try {
				        	
				            Conexion objCon = new Conexion();
				            Connection conn = (Connection) objCon.conexion();
				            
				          

				         
				            ps = conn.prepareStatement("UPDATE cable SET leadcode=?, color=?, longuitud=?, numero_hilos=?, calibre=?, aislante=?  WHERE id_cable=?");

				            ps.setString(1, txtCodigo.getText());
				            ps.setString(2, txtColor.getText());
				            ps.setString(3, txtLongitud.getText());
				            ps.setString(4, txtNumero_hilos.getText());
				            ps.setString(5, txtCalibre.getText());
				            ps.setString(6, txtAislante.getText());
				            ps.setString(7,txtid.getText());
				            
				            
				            ps.execute();

				            JOptionPane.showMessageDialog(null, "Producto Modificado");
				          

				           // limpiar();
				            				           
							dispose();
				           

				        } catch (SQLException ex) {
				            JOptionPane.showMessageDialog(null, "Error al Modificar Producto");
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
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
					}
				});
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
		
		txtCodigo = new JTextField();
		txtCodigo.setBounds(127, 77, 111, 20);
		contentPanel.add(txtCodigo);
		txtCodigo.setColumns(10);
		
		txtColor = new JTextField();
		txtColor.setColumns(10);
		txtColor.setBounds(127, 114, 111, 20);
		contentPanel.add(txtColor);
		
		txtLongitud = new JTextField();
		txtLongitud.setColumns(10);
		txtLongitud.setBounds(127, 158, 111, 20);
		contentPanel.add(txtLongitud);
		
		txtNumero_hilos = new JTextField();
		txtNumero_hilos.setColumns(10);
		txtNumero_hilos.setBounds(127, 187, 111, 20);
		contentPanel.add(txtNumero_hilos);
		
		txtCalibre = new JTextField();
		txtCalibre.setColumns(10);
		txtCalibre.setBounds(127, 219, 111, 20);
		contentPanel.add(txtCalibre);
		
		txtAislante = new JTextField();
		txtAislante.setColumns(10);
		txtAislante.setBounds(127, 259, 111, 20);
		contentPanel.add(txtAislante);
	}
}
