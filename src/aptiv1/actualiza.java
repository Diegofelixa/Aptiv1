package aptiv1;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.Connection;

import conexion.Conexion;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class actualiza extends JDialog 
{

	private final JPanel contentPanel = new JPanel();
	public JTextField txt_nombre;
	public JTextField txt_apellido;
	public JTextField txt_estacion;
	public JTextField txt_turno;
	public JTextField txt_ngafete;
	
	
	public static void main(String[] args)
	{
			try 
			{
				actualiza dialog = new actualiza();
				dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				dialog.setVisible(true);
			} 
					catch (Exception e) 
						{
							e.printStackTrace();
						}
    }

	
	public actualiza() 
	{
		setTitle("Actualizar Personal");
		setBounds(100, 100, 341, 393);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lbl_nombre = new JLabel("Nombre");
			lbl_nombre.setFont(new Font("Times New Roman", Font.PLAIN, 22));
			lbl_nombre.setBounds(30, 128, 85, 16);
			contentPanel.add(lbl_nombre);
		}
				{
					JLabel lbl_apellido = new JLabel("Apellido");
					lbl_apellido.setFont(new Font("Times New Roman", Font.PLAIN, 22));
					lbl_apellido.setBounds(30, 174, 85, 16);
					contentPanel.add(lbl_apellido);
				}
						{
							JLabel lbl_estacion = new JLabel("Estaci\u00F3n");
							lbl_estacion.setFont(new Font("Times New Roman", Font.PLAIN, 22));
							lbl_estacion.setBounds(30, 219, 85, 16);
							contentPanel.add(lbl_estacion);
						}
									{
										JLabel lbl_turno = new JLabel("Turno");
										lbl_turno.setFont(new Font("Times New Roman", Font.PLAIN, 22));
										lbl_turno.setBounds(30, 266, 62, 16);
										contentPanel.add(lbl_turno);
									}
		{
			txt_nombre = new JTextField();
			txt_nombre.setBounds(149, 128, 116, 22);
			contentPanel.add(txt_nombre);
			txt_nombre.setColumns(10);
		}
					{
						txt_apellido = new JTextField();
						txt_apellido.setBounds(149, 174, 116, 22);
						contentPanel.add(txt_apellido);
						txt_apellido.setColumns(10);
					}
								{
									txt_estacion = new JTextField();
									txt_estacion.setBounds(149, 219, 116, 22);
									contentPanel.add(txt_estacion);
									txt_estacion.setColumns(10);
								}
												{
													txt_turno = new JTextField();
													txt_turno.setBounds(149, 266, 116, 22);
													contentPanel.add(txt_turno);
													txt_turno.setColumns(10);
												}
		
		JLabel lbl_ngafete = new JLabel("N. Gaffet");
		lbl_ngafete.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		lbl_ngafete.setBounds(30, 83, 85, 16);
		contentPanel.add(lbl_ngafete);
		{
			txt_ngafete = new JTextField();
			txt_ngafete.setBounds(149, 83, 116, 22);
			contentPanel.add(txt_ngafete);
			txt_ngafete.setColumns(10);
		}
		
		JLabel lblNewLabel = new JLabel("Actualizar Informacion de Empleado");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel.setBounds(30, 32, 270, 22);
		contentPanel.add(lblNewLabel);
		
		
		  {
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
				{
					JButton okButton = new JButton("Actualizar Registro");
					okButton.addMouseListener(new MouseAdapter() 
					{
						@Override
						public void mouseClicked(MouseEvent arg0) 
						{
							 PreparedStatement ps = null;
							
						   try 
						   {  
							   Conexion objCon = new Conexion();
					            Connection conn = (Connection) objCon.conexion(); 
					            
					            ps = conn.prepareStatement("UPDATE operador op JOIN estacion e ON op.estacion=e.id_estacion JOIN  turno t ON t.id_turno=op.fk_turno SET op.nombre=?,op.apellido=?, e.nombre_estacion=?,t.nombre_turno=? WHERE op.id_ngafet=?");

					           
								
					            ps.setString(1, txt_nombre.getText());
					            ps.setString(2, txt_apellido.getText());
					            ps.setString(3, txt_estacion.getText());     
					            ps.setString(4, txt_turno.getText());
					            ps.setString(5, txt_ngafete.getText());
					            ps.execute();

					            JOptionPane.showMessageDialog(null, " Personal Modificado ");
					            dispose(); 
						   } 
						   
						   catch (SQLException ex) 
								{
						            JOptionPane.showMessageDialog(null, " Error al modificar Registro  ");
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
							cancelButton.addActionListener(new ActionListener() 
							{
								public void actionPerformed(ActionEvent e) 
									{
									  dispose();
									}
							});
							cancelButton.setActionCommand("Cancel");
							buttonPane.add(cancelButton);
						}
		
		}
	}
}
