package aptiv1;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.Connection;

import conexion.Conexion;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Formulario2 extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtOtro;
	private JTextField txtCable2;
	private JTextField txtCable1;
	private JTextField txtDiametro;
	private JTextField txtLongitud;
	private JTextField txtColor;
	private JTextField txtCodigo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
	}

	/**
	 * Create the dialog.
	 * @param b 
	 * @param administracable2 
	 */
	public Formulario2(Administracable2 administracable2, boolean b) {
		setBounds(100, 100, 340, 410);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		txtOtro = new JTextField();
		txtOtro.setColumns(10);
		txtOtro.setBounds(169, 285, 140, 20);
		contentPanel.add(txtOtro);
		
		JLabel label = new JLabel("Otro Componente");
		label.setBounds(44, 288, 86, 14);
		contentPanel.add(label);
		
		JLabel label_1 = new JLabel();
		label_1.setText("Cable 2");
		label_1.setForeground(Color.BLACK);
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_1.setBounds(46, 258, 47, 15);
		contentPanel.add(label_1);
		
		txtCable2 = new JTextField();
		txtCable2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtCable2.setBounds(159, 255, 150, 21);
		contentPanel.add(txtCable2);
		
		txtCable1 = new JTextField();
		txtCable1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtCable1.setBounds(159, 223, 150, 21);
		contentPanel.add(txtCable1);
		
		JLabel label_2 = new JLabel();
		label_2.setText("Cable 1");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_2.setBounds(44, 226, 49, 15);
		contentPanel.add(label_2);
		
		JLabel label_3 = new JLabel();
		label_3.setText("Diametro");
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_3.setBounds(44, 194, 49, 15);
		contentPanel.add(label_3);
		
		txtDiametro = new JTextField();
		txtDiametro.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtDiametro.setBounds(168, 191, 141, 21);
		contentPanel.add(txtDiametro);
		
		txtLongitud = new JTextField();
		txtLongitud.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtLongitud.setBounds(159, 159, 150, 21);
		contentPanel.add(txtLongitud);
		
		JLabel label_4 = new JLabel();
		label_4.setText("Longitud");
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_4.setBounds(45, 165, 48, 15);
		contentPanel.add(label_4);
		
		txtColor = new JTextField();
		txtColor.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtColor.setBounds(159, 118, 150, 21);
		contentPanel.add(txtColor);
		
		JLabel label_5 = new JLabel();
		label_5.setText("Color");
		label_5.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_5.setBounds(56, 121, 27, 15);
		contentPanel.add(label_5);
		
		JLabel label_6 = new JLabel();
		label_6.setText("C\u00F3digo");
		label_6.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_6.setBounds(46, 84, 37, 15);
		contentPanel.add(label_6);
		
		txtCodigo = new JTextField();
		txtCodigo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtCodigo.setBounds(159, 78, 150, 21);
		contentPanel.add(txtCodigo);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(173, 216, 230));
		panel.setBounds(0, 0, 324, 50);
		contentPanel.add(panel);
		
		JLabel label_7 = new JLabel("Registrar");
		label_7.setFont(new Font("Arial", Font.BOLD, 15));
		label_7.setBounds(28, 11, 116, 28);
		panel.add(label_7);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Registrar");
				okButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent arg0) {
						
						 int idcable1=0;
					        int idcable2=0;
					    	PreparedStatement ps = null;
					    	PreparedStatement ps2 = null;
					        try {
					        	  Conexion objCon = new Conexion();
					              Connection conn = (Connection) objCon.conexion();
					        	 ps = conn.prepareStatement("SELECT id_cable FROM cable WHERE leadcode = ?");
					             ps.setString(1,txtCable1.getText());
					             ps2 = conn.prepareStatement("SELECT id_cable FROM cable WHERE leadcode = ?");
					             ps2.setString(1,txtCable2.getText());
					             ResultSet rs = ps.executeQuery();
					            
					        


					            if (rs.next()) { //Para leer varias posibles filas se cambia el while por el if
					                idcable1 = rs.getInt("id_cable");
					                idcable2 = rs.getInt("id_cable");
					            }
					        	
					          
					            ps = conn.prepareStatement("INSERT INTO `cable_fin`(`id_final`, `color`, `longitud`, `diametro`, `fk_cable1`, `fk_cable2`, `otro_componente`) VALUES (?,?,?,?,?,?,?)");
					            
					            
					            
					            ps.setString(1, txtCodigo.getText());
					            ps.setString(2, txtColor.getText());
					            ps.setString(3, txtLongitud.getText());
					            ps.setString(4, txtDiametro.getText());
					            ps.setInt(5,idcable1);
					            ps.setInt(6, idcable2);
					            ps.setString(7, txtOtro.getText());

					            ps.execute();

					            JOptionPane.showMessageDialog(null, "Producto Guardado");
					           
					          dispose();
					            
					           

					        } catch (SQLException ex) {
					            JOptionPane.showMessageDialog(null, "Error al Guardar Producto");
					            System.out.println(ex);
					        }
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
