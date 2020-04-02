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

import java.awt.Color;
import javax.swing.JComboBox;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Mod_produccion extends JDialog {

	private final JPanel contentPanel = new JPanel();
	public JTextField txtdefectos;
	public JTextField txtcodigo;
	public JTextField txtGafete;
	public JTextField txtcantidad;
	public JTextField txtid;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
	}

	/**
	 * Create the dialog.
	 * @param estacion 
	 * @param fin 
	 * @param turno 
	 */
	public Mod_produccion(String estacion, int turno, int fin) {
		setBounds(100, 100, 505, 430);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		txtdefectos = new JTextField();
		txtdefectos.setColumns(10);
		txtdefectos.setBounds(194, 204, 204, 125);
		contentPanel.add(txtdefectos);
		
		JLabel label = new JLabel("Defectos o Comentarios");
		label.setForeground(new Color(0, 0, 0));
		label.setBounds(32, 259, 152, 14);
		contentPanel.add(label);
		
		txtcodigo = new JTextField();
		txtcodigo.setColumns(10);
		txtcodigo.setBounds(92, 172, 133, 21);
		contentPanel.add(txtcodigo);
		
		JLabel label_1 = new JLabel("Codigo cable");
		label_1.setForeground(new Color(0, 0, 0));
		label_1.setBounds(10, 172, 83, 21);
		contentPanel.add(label_1);
		
		JLabel label_2 = new JLabel("Estacion:");
		label_2.setForeground(new Color(0, 0, 0));
		label_2.setBounds(20, 129, 63, 14);
		contentPanel.add(label_2);
		Combo combo= new Combo();
		JComboBox conestacion = new JComboBox();
		conestacion.setBounds(92, 126, 133, 21);
		conestacion.addItem(estacion);
		combo.consultar_estacion(conestacion);
		contentPanel.add(conestacion);
		
		JLabel label_3 = new JLabel("# Gafete");
		label_3.setForeground(new Color(0, 0, 0));
		label_3.setBounds(20, 87, 63, 14);
		contentPanel.add(label_3);
		
		txtGafete = new JTextField();
		txtGafete.setColumns(10);
		txtGafete.setBounds(82, 84, 143, 21);
		contentPanel.add(txtGafete);
		String tur="";
		if(turno==1) {
			tur="Matutino";
		}else if (turno==2) {
			 tur="Vespertino";
		}
		
		JComboBox conturno = new JComboBox();
		conturno.setBounds(351, 77, 115, 24);
		conturno.addItem(tur);
		if(tur.equals("Matutino")) {
			conturno.addItem("Vespertino");
		}else {
			conturno.addItem("Matutino");
		}
		
		contentPanel.add(conturno);
		
		JLabel label_4 = new JLabel("Turno");
		label_4.setForeground(new Color(0, 0, 0));
		label_4.setBounds(307, 80, 46, 14);
		contentPanel.add(label_4);
		
		JLabel label_5 = new JLabel("Cantidad Producida");
		label_5.setForeground(new Color(0, 0, 0));
		label_5.setBounds(297, 126, 120, 21);
		contentPanel.add(label_5);
		
		txtcantidad = new JTextField();
		txtcantidad.setColumns(10);
		txtcantidad.setBounds(413, 126, 75, 20);
		contentPanel.add(txtcantidad);
		
		JPanel panel = new JPanel();
		panel.setToolTipText("");
		panel.setBackground(new Color(173, 216, 230));
		panel.setBounds(0, 0, 497, 44);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		JLabel lblModificarProduccion = new JLabel("Modificar Produccion");
		lblModificarProduccion.setFont(new Font("Arial", Font.BOLD, 17));
		lblModificarProduccion.setBounds(133, 11, 190, 22);
		panel.add(lblModificarProduccion);
		
		txtid = new JTextField();
		txtid.setBounds(148, 55, 20, 21);
		contentPanel.add(txtid);
		txtid.setColumns(10);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Actualizar");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						
						 PreparedStatement ps = null;
						
						  try {
				        	    Conexion objCon = new Conexion();
						        Connection conn = (Connection) objCon.conexion();
						        
						       

			            

			                ps = conn.prepareStatement("UPDATE produccion SET num_gafet=?, fk_estacion=(select id_estacion from estacion where nombre_estacion='"+conestacion.getSelectedItem().toString() +"'), cantidad_atados=?, defectos=?, fk_turno=(select id_turno from turno where nombre_turno='"+conturno.getSelectedItem().toString() +"'), fk_final=?  WHERE id_produccion=?");

				            ps.setString(1, txtGafete.getText());
				            ps.setString(2, txtcantidad.getText());	
				            ps.setString(3, txtdefectos.getText());				            
				            ps.setString(4,txtcodigo.getText());
				            ps.setString(5,txtid.getText());

				            
				            
				            ps.execute();

				            JOptionPane.showMessageDialog(null, "Produccion Modificada");

			            } catch (SQLException e) {
			                JOptionPane.showMessageDialog(null, "SQLException:\n" + e.getMessage(), "Error: companiaNombreToInt()", JOptionPane.ERROR_MESSAGE);
			            }
				        
			          
			          

			           // limpiar();
			            				           
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
