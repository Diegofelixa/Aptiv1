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

import conexion.Conexion;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Consult_produccion extends JDialog {

	

    DefaultTableModel modelo = new DefaultTableModel();
    TableRowSorter trs;
    private JTable jtProductos;
 public Consult_produccion() {
    	
    	
    	setBounds(100,100,757,464);
    	Fondo f_1= new Fondo();
    	f_1.setBorder(new EmptyBorder(5,5,5,5));
    	setContentPane(f_1);
    	f_1.setLayout(null);
    	
    	JScrollPane scrollPane = new JScrollPane();
    	scrollPane.setBounds(10, 82, 659, 213);
    	f_1.add(scrollPane);
    	
    	jtProductos = new JTable();
    	scrollPane.setColumnHeaderView(jtProductos);
    	
    	
    	
        getComponents();
        

        try {
            jtProductos.setModel(modelo);
            PreparedStatement ps = null;
            ResultSet rs = null;
            Conexion conn = new Conexion();
            java.sql.Connection con = conn.conexion();

            String sql = "SELECT `leadcode` , `color` , `longuitud` , `numero_hilos` , `calibre` , `aislante` FROM `cable`";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            ResultSetMetaData rsMd = (ResultSetMetaData) rs.getMetaData();
            int cantidadColumnas = rsMd.getColumnCount();

            modelo.addColumn("Código");
            modelo.addColumn("Color");
            modelo.addColumn("Longitud");
            modelo.addColumn("Numero de Hilos");
            modelo.addColumn("Calibre");
            modelo.addColumn("Aislante");

            int[] anchos = {50, 200, 50, 100, 50, 50};
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