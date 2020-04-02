 package aptiv1;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import com.mysql.jdbc.Connection;

import conexion.Conexion;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Consult_produccion extends JDialog {

	

    DefaultTableModel modelo = new DefaultTableModel();
    TableRowSorter trs;
    private JTable jtProductos;
    private JTextField textField;
   public Consult_produccion(int privilegio) {
    	
    	
    	setBounds(100,100,757,464);
    	Fondo f_1= new Fondo();
    	f_1.setBorder(new EmptyBorder(5,5,5,5));
    	setContentPane(f_1);
    	f_1.setLayout(null);
    	
    	JScrollPane scrollPane = new JScrollPane();
    	scrollPane.setBounds(10, 82, 659, 213);
    	f_1.add(scrollPane);
    	
    	jtProductos = new JTable();
    	scrollPane.setViewportView(jtProductos);
    	
    	
    	
        getComponents();
        

        
        try {
            jtProductos.setModel(modelo);
            
            textField = new JTextField();
            textField.addKeyListener(new KeyAdapter() {
            	@Override
            	public void keyReleased(KeyEvent Ke) {
            		
            		trs.setRowFilter(RowFilter.regexFilter(textField.getText() ));
            	}
            });
            trs=new TableRowSorter(modelo);
            jtProductos.setRowSorter(trs);
            textField.setColumns(10);
            textField.setBounds(123, 50, 121, 20);
            f_1.add(textField);
            
            JLabel label = new JLabel();
            label.setIcon(new ImageIcon(Consult_produccion.class.getResource("/imagenes/busqueda.png")));
            label.setText("Busqueda:");
            label.setForeground(Color.WHITE);
            label.setFont(new Font("Tahoma", Font.BOLD, 13));
            label.setBounds(10, 47, 103, 24);
            f_1.add(label);
            
            JButton mod = new JButton("Modificar");
            mod.setIcon(new ImageIcon(Consult_produccion.class.getResource("/imagenes/edit.png")));
            mod.setBounds(554, 48, 115, 23);
            f_1.add(mod);
            
            JButton elim = new JButton();
            elim.addMouseListener(new MouseAdapter() {
            	@Override
            	public void mouseClicked(MouseEvent arg0) {
            		
            		
            		  PreparedStatement ps = null;
            	        try {

            	            Conexion objCon = new Conexion();
            	            Connection conn = (Connection) objCon.conexion();

            	            int Fila = jtProductos.getSelectedRow();
            	            String codigo = jtProductos.getValueAt(Fila, 0).toString();

            	            
            	            int respuesta= JOptionPane.showConfirmDialog(null, "Realmente quiere eliminar este cable?","Confirmacion de Eliminar", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
            	            if(respuesta==JOptionPane.YES_OPTION) {
            	            	 ps = conn.prepareStatement("DELETE FROM produccion WHERE id_produccion=?");
            	                 ps.setString(1, codigo);
            	                 ps.execute();

            	                 modelo.removeRow(Fila);
            	                 JOptionPane.showMessageDialog(null, "Producto Eliminado");
            	                // limpiar();
            	            	
            	            }
            	           

            	        } catch (SQLException ex) {
            	            JOptionPane.showMessageDialog(null, "Error al Eliminar Producto");
            	            System.out.println(ex.toString());
            	        }
            		
            		
            	}
            });
            elim.setIcon(new ImageIcon(Consult_produccion.class.getResource("/imagenes/elimin.png")));
            elim.setText("Eliminar");
            elim.setBounds(443, 48, 101, 23);
            f_1.add(elim);
            PreparedStatement ps = null;
            ResultSet rs = null;
            Conexion conn = new Conexion();
            java.sql.Connection con = conn.conexion();

            if(privilegio==2) {
            	elim.setVisible(false);
            	mod.setVisible(false);
            }
            
            String sql = "Select pr.num_gafet, pr.cantidad_atados, pr.hora_fecha, pr.defectos, e1.nombre_estacion AS 'l1', tur.nombre_turno AS 'l2', cf.id_final AS 'l3' from produccion pr inner join estacion e1 on e1.id_estacion=pr.fk_estacion inner join turno tur on tur.id_turno=pr.fk_turno inner join cable_fin cf on cf.id_final=pr.fk_final";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            ResultSetMetaData rsMd = (ResultSetMetaData) rs.getMetaData();
            int cantidadColumnas = rsMd.getColumnCount();

            modelo.addColumn("Numero de gafet");
            modelo.addColumn("Cantidad de atados");
            modelo.addColumn("Hora y fecha");
            modelo.addColumn("Defectos");
            modelo.addColumn("Estacion");
            modelo.addColumn("Turno");
            modelo.addColumn("Codigo del cable");


            int[] anchos = {70, 100, 50, 100, 50, 50, 80};
            for (int i = 0; i < jtProductos.getColumnCount(); i++) {
                jtProductos.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
            }

            while (rs.next()) {
                Object[] filas = new Object[cantidadColumnas];
                for (int i = 0; i < cantidadColumnas; i++) {
                    filas[i] = rs.getObject(i + 1);
                }
                modelo.addRow(filas);
            }

        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }
        
       
     

    }
}