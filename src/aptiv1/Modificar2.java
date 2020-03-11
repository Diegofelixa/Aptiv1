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
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Modificar2 extends JDialog {

	private final JPanel contentPanel = new JPanel();
	 JTextField textField;
	 JTextField textField_1;
	 JTextField textField_2;
	 JTextField textField_3;
	 JTextField textField_4;
	 JTextField textField_5;
	 JTextField textField_6;
	 JTextField txtOtro;
	 JTextField txtCable2;
	 JTextField txtCable1;
	 JTextField txtDiametro;
	 JTextField txtLongitud;
	 JTextField txtColor;
	JTextField txtCodigo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Modificar2 dialog = new Modificar2();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Modificar2() {
		setBounds(100, 100, 335, 409);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JPanel panel = new JPanel();
			panel.setBounds(175, 10, 1, 1);
			panel.setLayout(null);
			panel.setBorder(new EmptyBorder(5, 5, 5, 5));
			contentPanel.add(panel);
			{
				textField = new JTextField();
				textField.setColumns(10);
				textField.setBounds(169, 285, 140, 20);
				panel.add(textField);
			}
			{
				JLabel label = new JLabel("Otro Componente");
				label.setBounds(44, 288, 86, 14);
				panel.add(label);
			}
			{
				JLabel label = new JLabel();
				label.setText("Cable 2");
				label.setForeground(Color.BLACK);
				label.setFont(new Font("Tahoma", Font.PLAIN, 13));
				label.setBounds(46, 258, 47, 15);
				panel.add(label);
			}
			{
				textField_1 = new JTextField();
				textField_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
				textField_1.setBounds(159, 255, 150, 21);
				panel.add(textField_1);
			}
			{
				textField_2 = new JTextField();
				textField_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
				textField_2.setBounds(159, 223, 150, 21);
				panel.add(textField_2);
			}
			{
				JLabel label = new JLabel();
				label.setText("Cable 1");
				label.setFont(new Font("Tahoma", Font.PLAIN, 12));
				label.setBounds(44, 226, 49, 15);
				panel.add(label);
			}
			{
				JLabel label = new JLabel();
				label.setText("Diametro");
				label.setFont(new Font("Tahoma", Font.PLAIN, 12));
				label.setBounds(44, 194, 49, 15);
				panel.add(label);
			}
			{
				textField_3 = new JTextField();
				textField_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
				textField_3.setBounds(168, 191, 141, 21);
				panel.add(textField_3);
			}
			{
				textField_4 = new JTextField();
				textField_4.setFont(new Font("Tahoma", Font.PLAIN, 12));
				textField_4.setBounds(159, 159, 150, 21);
				panel.add(textField_4);
			}
			{
				JLabel label = new JLabel();
				label.setText("Longitud");
				label.setFont(new Font("Tahoma", Font.PLAIN, 12));
				label.setBounds(45, 165, 48, 15);
				panel.add(label);
			}
			{
				textField_5 = new JTextField();
				textField_5.setFont(new Font("Tahoma", Font.PLAIN, 12));
				textField_5.setBounds(159, 118, 150, 21);
				panel.add(textField_5);
			}
			{
				JLabel label = new JLabel();
				label.setText("Color");
				label.setFont(new Font("Tahoma", Font.PLAIN, 12));
				label.setBounds(56, 121, 27, 15);
				panel.add(label);
			}
			{
				JLabel label = new JLabel();
				label.setText("C\u00F3digo");
				label.setFont(new Font("Tahoma", Font.PLAIN, 12));
				label.setBounds(46, 84, 37, 15);
				panel.add(label);
			}
			{
				textField_6 = new JTextField();
				textField_6.setFont(new Font("Tahoma", Font.PLAIN, 12));
				textField_6.setBounds(159, 78, 150, 21);
				panel.add(textField_6);
			}
			{
				JPanel panel_1 = new JPanel();
				panel_1.setLayout(null);
				panel_1.setBackground(new Color(173, 216, 230));
				panel_1.setBounds(0, 0, 324, 50);
				panel.add(panel_1);
				{
					JLabel label = new JLabel("Registrar");
					label.setFont(new Font("Arial", Font.BOLD, 15));
					label.setBounds(28, 11, 116, 28);
					panel_1.add(label);
				}
			}
		}
		{
			JPanel panel = new JPanel();
			panel.setLayout(null);
			panel.setBorder(new EmptyBorder(5, 5, 5, 5));
			panel.setBounds(0, 0, 324, 339);
			contentPanel.add(panel);
			{
				txtOtro = new JTextField();
				txtOtro.setColumns(10);
				txtOtro.setBounds(169, 285, 140, 20);
				panel.add(txtOtro);
			}
			{
				JLabel label = new JLabel("Otro Componente");
				label.setBounds(44, 288, 86, 14);
				panel.add(label);
			}
			{
				JLabel label = new JLabel();
				label.setText("Cable 2");
				label.setForeground(Color.BLACK);
				label.setFont(new Font("Tahoma", Font.PLAIN, 13));
				label.setBounds(46, 258, 47, 15);
				panel.add(label);
			}
			{
				txtCable2 = new JTextField();
				txtCable2.setFont(new Font("Tahoma", Font.PLAIN, 12));
				txtCable2.setBounds(159, 255, 150, 21);
				panel.add(txtCable2);
			}
			{
				txtCable1 = new JTextField();
				txtCable1.setFont(new Font("Tahoma", Font.PLAIN, 12));
				txtCable1.setBounds(159, 223, 150, 21);
				panel.add(txtCable1);
			}
			{
				JLabel label = new JLabel();
				label.setText("Cable 1");
				label.setFont(new Font("Tahoma", Font.PLAIN, 12));
				label.setBounds(44, 226, 49, 15);
				panel.add(label);
			}
			{
				JLabel label = new JLabel();
				label.setText("Diametro");
				label.setFont(new Font("Tahoma", Font.PLAIN, 12));
				label.setBounds(44, 194, 49, 15);
				panel.add(label);
			}
			{
				txtDiametro = new JTextField();
				txtDiametro.setFont(new Font("Tahoma", Font.PLAIN, 12));
				txtDiametro.setBounds(168, 191, 141, 21);
				panel.add(txtDiametro);
			}
			{
				txtLongitud = new JTextField();
				txtLongitud.setFont(new Font("Tahoma", Font.PLAIN, 12));
				txtLongitud.setBounds(159, 159, 150, 21);
				panel.add(txtLongitud);
			}
			{
				JLabel label = new JLabel();
				label.setText("Longitud");
				label.setFont(new Font("Tahoma", Font.PLAIN, 12));
				label.setBounds(45, 165, 48, 15);
				panel.add(label);
			}
			{
				txtColor = new JTextField();
				txtColor.setFont(new Font("Tahoma", Font.PLAIN, 12));
				txtColor.setBounds(159, 118, 150, 21);
				panel.add(txtColor);
			}
			{
				JLabel label = new JLabel();
				label.setText("Color");
				label.setFont(new Font("Tahoma", Font.PLAIN, 12));
				label.setBounds(56, 121, 27, 15);
				panel.add(label);
			}
			{
				JLabel label = new JLabel();
				label.setText("C\u00F3digo");
				label.setFont(new Font("Tahoma", Font.PLAIN, 12));
				label.setBounds(46, 84, 37, 15);
				panel.add(label);
			}
			{
				txtCodigo = new JTextField();
				txtCodigo.setFont(new Font("Tahoma", Font.PLAIN, 12));
				txtCodigo.setBounds(159, 78, 150, 21);
				panel.add(txtCodigo);
			}
			{
				JPanel panel_1 = new JPanel();
				panel_1.setLayout(null);
				panel_1.setBackground(new Color(173, 216, 230));
				panel_1.setBounds(0, 0, 324, 50);
				panel.add(panel_1);
				{
					JLabel label = new JLabel("Registrar");
					label.setFont(new Font("Arial", Font.BOLD, 15));
					label.setBounds(28, 11, 116, 28);
					panel_1.add(label);
				}
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Actualizar");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						
				        int id=0;
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
				       	
				          

				            // Java 7 try-with-resources
				            ps = conn.prepareStatement("UPDATE cable_fin SET  color=?, longitud=?, diametro=?, fk_cable1=?, fk_cable2=?, otro_componente=?  WHERE id_final=?");

				            
				            ps.setString(1, txtColor.getText());
				            ps.setString(2, txtLongitud.getText());
				            ps.setString(3, txtDiametro.getText());
				            ps.setInt(4,idcable1);
				            ps.setInt(5, idcable2);
				            ps.setString(6,txtOtro.getText());
				            ps.setString(7, txtCodigo.getText());
				            
				            
				            ps.execute();

				            JOptionPane.showMessageDialog(null, "Producto Modificado");
				           
				           
				            id=0;
				            dispose();

				        } catch (SQLException ex) {
				            JOptionPane.showMessageDialog(null, "Error al Modificar Producto");
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
				cancelButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent arg0) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

}
