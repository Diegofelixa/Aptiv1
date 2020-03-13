package aptiv1;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JLabel;
import java.awt.Color;

public class Agregar_turno extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtNombre;
	private JTextField txtHorai;
	private JTextField txtHoraf;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Agregar_turno dialog = new Agregar_turno();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Agregar_turno() {
		setBounds(100, 100, 338, 384);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			txtNombre = new JTextField();
			txtNombre.setFont(new Font("Tahoma", Font.PLAIN, 12));
			txtNombre.setBounds(138, 94, 150, 21);
			contentPanel.add(txtNombre);
		}
		{
			JLabel lblNombre = new JLabel();
			lblNombre.setText("Nombre");
			lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblNombre.setBounds(25, 100, 103, 15);
			contentPanel.add(lblNombre);
		}
		{
			JLabel lblHoraDeInicio = new JLabel();
			lblHoraDeInicio.setText("Hora de Inicio");
			lblHoraDeInicio.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblHoraDeInicio.setBounds(25, 137, 105, 15);
			contentPanel.add(lblHoraDeInicio);
		}
		{
			txtHorai = new JTextField();
			txtHorai.setFont(new Font("Tahoma", Font.PLAIN, 12));
			txtHorai.setBounds(138, 134, 150, 21);
			contentPanel.add(txtHorai);
		}
		{
			JLabel lblHoraDeTermino = new JLabel();
			lblHoraDeTermino.setText("Hora de termino");
			lblHoraDeTermino.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblHoraDeTermino.setBounds(24, 181, 104, 15);
			contentPanel.add(lblHoraDeTermino);
		}
		{
			txtHoraf = new JTextField();
			txtHoraf.setFont(new Font("Tahoma", Font.PLAIN, 12));
			txtHoraf.setBounds(138, 175, 150, 21);
			contentPanel.add(txtHoraf);
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
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
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
