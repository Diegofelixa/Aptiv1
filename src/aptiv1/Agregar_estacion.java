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
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.JComboBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Agregar_estacion extends JDialog {

	private final JPanel contentPanel = new JPanel();
	public JTextField txtNombre;
	public JTextField txtDescripcion;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Agregar_estacion dialog = new Agregar_estacion();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Agregar_estacion() {
		setBounds(100, 100, 338, 384);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			txtNombre = new JTextField();
			txtNombre.setFont(new Font("Tahoma", Font.PLAIN, 12));
			txtNombre.setBounds(143, 103, 144, 21);
			contentPanel.add(txtNombre);
		}
		{
			JLabel lblNombre = new JLabel();
			lblNombre.setText("Nombre de Estacion:");
			lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblNombre.setBounds(22, 106, 130, 15);
			contentPanel.add(lblNombre);
		}
		{
			JPanel panel = new JPanel();
			panel.setLayout(null);
			panel.setBackground(new Color(173, 216, 230));
			panel.setBounds(0, 0, 324, 50);
			contentPanel.add(panel);
			{
				JLabel label = new JLabel("Registrar");
				label.setFont(new Font("Arial", Font.BOLD, 15));
				label.setBounds(28, 11, 116, 28);
				panel.add(label);
			}
		}
		{
			txtDescripcion = new JTextField();
			txtDescripcion.setFont(new Font("Tahoma", Font.PLAIN, 12));
			txtDescripcion.setBounds(114, 202, 173, 73);
			contentPanel.add(txtDescripcion);
		}
		{
			JLabel lblDescripcion = new JLabel();
			lblDescripcion.setText("Descripcion");
			lblDescripcion.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblDescripcion.setBounds(22, 202, 130, 15);
			contentPanel.add(lblDescripcion);
		}
		{
			JLabel lblEstado = new JLabel();
			lblEstado.setText("Estado:");
			lblEstado.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblEstado.setBounds(84, 153, 59, 15);
			contentPanel.add(lblEstado);
		}
		
				JComboBox status = new JComboBox();
				status.setBounds(143, 151, 107, 20);
				status.addItem("Selecciona un Estado");
				status.addItem("Activa");
				status.addItem("Inactiva");
				contentPanel.add(status);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Registrar");
				okButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent arg0) {
						
						Administracable ad=new Administracable();
						 PreparedStatement ps = null;
					        try {
					            Conexion objCon = new Conexion();
					            Connection conn = (Connection) objCon.conexion();
					            ps = conn.prepareStatement("INSERT INTO estacion (nombre_estacion, descripcion, status) VALUES (?,?,?)");
					            int estados=0;
					          if(status.getSelectedItem().toString()=="Activa") {
					        	  estados=1;
					        	  
					          }else if(status.getSelectedItem().toString()=="Inactiva") {
					        	  estados=0;
					          }
					            
					            ps.setString(1, txtNombre.getText());
					            ps.setString(2, txtDescripcion.getText());
					            ps.setInt(3, estados );
					           

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
