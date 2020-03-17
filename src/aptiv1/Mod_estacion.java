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
import javax.swing.JComboBox;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Mod_estacion extends JDialog {

	private final JPanel contentPanel = new JPanel();
	public JTextField txtDescripcion;
	public JTextField txtNombre;
	JTextField Nombreant;
	private JLabel Nombreest;
	private JLabel estado2;
	public JLabel descripcion;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
	
	}

	/**
	 * Create the dialog.
	 * @param estado2 
	 */
	public Mod_estacion(String estado) {
		setBounds(100, 100, 334, 385);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
					txtDescripcion = new JTextField();
			txtDescripcion.setFont(new Font("Tahoma", Font.PLAIN, 12));
			txtDescripcion.setBounds(121, 164, 173, 73);
			contentPanel.add(txtDescripcion);
		
			JLabel label;
			descripcion = new JLabel();
			descripcion.setText("Descripcion");
			descripcion.setFont(new Font("Tahoma", Font.PLAIN, 12));
			descripcion.setBounds(29, 181, 130, 15);
			contentPanel.add(descripcion);
		
		   
			
			JLabel label_2;
			estado2 = new JLabel();
			estado2.setText("Estado:");
			estado2.setFont(new Font("Tahoma", Font.PLAIN, 12));
			estado2.setBounds(91, 132, 59, 15);
			contentPanel.add(estado2);
		
		
			JComboBox status = new JComboBox();
			status.setBounds(150, 130, 107, 20);
			status.addItem(estado);
			if(estado=="Activa") {
			status.addItem("Inactiva");	
				
			}else {
			 status.addItem("Activa");
			}
			
			
			
			contentPanel.add(status);
		
		  
			txtNombre = new JTextField();
			txtNombre.setFont(new Font("Tahoma", Font.PLAIN, 12));
			txtNombre.setBounds(150, 82, 144, 21);
			contentPanel.add(txtNombre);
			Nombreant=txtNombre;
		
			JLabel label_1;
			Nombreest = new JLabel();
			Nombreest.setText("Nombre de Estacion:");
			Nombreest.setFont(new Font("Tahoma", Font.PLAIN, 12));
			Nombreest.setBounds(29, 85, 130, 15);
			contentPanel.add(Nombreest);
		
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(173, 216, 230));
		panel.setBounds(0, 0, 324, 50);
		contentPanel.add(panel);
		
		JLabel lblModificar = new JLabel("Modificar");
		lblModificar.setFont(new Font("Arial", Font.BOLD, 15));
		lblModificar.setBounds(28, 11, 116, 28);
		panel.add(lblModificar);
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
				       int esta=0;
				        PreparedStatement ps = null;
				        PreparedStatement ps2 = null;
				        
				       
				       
				       
				        try {
				        	    Conexion objCon = new Conexion();
						        Connection conn = (Connection) objCon.conexion();
						        

			            	 ps = conn.prepareStatement("SELECT id_estacion FROM estacion WHERE nombre_estacion = ?");
			                 ps.setString(1,Nombreant.getText());
			                 ResultSet rs = ps.executeQuery();
			                
			            


			                if (rs.next()) { //Para leer varias posibles filas se cambia el while por el if
			                    id = rs.getInt("id_estacion");
                                     if(status.getSelectedItem().toString()=="Activa") {
			        	         esta=1;
			        	   
                                     }else if(status.getSelectedItem().toString()=="Inactiva") {
			        	        esta=0;
                                     }
			                }
			                ps = conn.prepareStatement("UPDATE estacion SET nombre_estacion=?, descripcion=?, status=?  WHERE id_estacion=?");

				            ps.setString(1, txtNombre.getText());
				            ps.setString(2, txtDescripcion.getText());	
				            ps.setInt(3, esta);				            
				            ps.setLong(4,id);
				            
				            
				            ps.execute();

				            JOptionPane.showMessageDialog(null, "Producto Modificado");

			            } catch (SQLException e) {
			                JOptionPane.showMessageDialog(null, "SQLException:\n" + e.getMessage(), "Error: companiaNombreToInt()", JOptionPane.ERROR_MESSAGE);
			            }
				        
			          
			          

			           // limpiar();
			            id=0;				           
						dispose();
			           

			        
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
