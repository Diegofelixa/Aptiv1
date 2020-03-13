package aptiv1;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.Connection;

import conexion.Conexion;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Actualizar_inventario extends JDialog {

	private final JPanel contentPanel = new JPanel();
	public JTextField txtCodigo;
	public JTextField txtAtados;
	public JTextField txtCable;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
	}

	/**
	 * Create the dialog.
	 * @param rootPaneCheckingEnabled 
	 * @param object 
	 */
	public Actualizar_inventario(Object object, boolean rootPaneCheckingEnabled) {
		setBounds(100, 100, 319, 346);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel label = new JLabel();
		label.setText("C\u00F3digo");
		label.setForeground(new Color(0, 191, 255));
		label.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label.setBounds(52, 90, 37, 15);
		contentPanel.add(label);
		
		txtCodigo = new JTextField();
		txtCodigo.setForeground(Color.BLACK);
		txtCodigo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtCodigo.setBounds(128, 84, 150, 21);
		contentPanel.add(txtCodigo);
		
		JLabel lblCantidadDeAtados = new JLabel();
		lblCantidadDeAtados.setText("Cantidad de Atados");
		lblCantidadDeAtados.setForeground(new Color(0, 191, 255));
		lblCantidadDeAtados.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCantidadDeAtados.setBounds(10, 127, 118, 15);
		contentPanel.add(lblCantidadDeAtados);
		
		txtAtados = new JTextField();
		txtAtados.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtAtados.setBounds(138, 124, 140, 21);
		contentPanel.add(txtAtados);
		
		JLabel lblCodigoDeCable = new JLabel();
		lblCodigoDeCable.setText("Codigo de cable");
		lblCodigoDeCable.setForeground(new Color(0, 191, 255));
		lblCodigoDeCable.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCodigoDeCable.setBounds(10, 166, 108, 15);
		contentPanel.add(lblCodigoDeCable);
		
		txtCable = new JTextField();
		txtCable.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtCable.setBounds(137, 163, 141, 21);
		contentPanel.add(txtCable);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(173, 216, 230));
		panel.setBounds(0, 0, 303, 50);
		contentPanel.add(panel);
		
		JLabel label_4 = new JLabel("Registrar");
		label_4.setFont(new Font("Arial", Font.BOLD, 15));
		label_4.setBounds(28, 11, 116, 28);
		panel.add(label_4);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Actualizar");
				okButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent arg0) {
						
						 
				        int id=0;
				        PreparedStatement ps = null;
				        try {
				        	
				            Conexion objCon = new Conexion();
				            Connection conn = (Connection) objCon.conexion();
				            
				          

				            // Java 7 try-with-resources
				         

				            ps = conn.prepareStatement("UPDATE inventario SET id_inventario=?, cantidad_atados=?, fk_final=? WHERE id_inventario=?");

				            ps.setString(1, txtCodigo.getText());
				            ps.setString(2, txtAtados.getText());				            
				            ps.setString(3, txtCable.getText());
				            ps.setString(4, txtCodigo.getText());
				           
				            
				            
				            ps.execute();

				            JOptionPane.showMessageDialog(null, "Producto Modificado");
				          

				           // limpiar();
				            id=0;				           
							dispose();
				           

				        } catch (SQLException ex) {
				            JOptionPane.showMessageDialog(null, "Error al Modificar Producto");
				            System.out.println(ex);
				           
				        }
					}
				});
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
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
