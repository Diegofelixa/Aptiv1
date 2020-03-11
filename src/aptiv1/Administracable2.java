package aptiv1;

import com.mysql.jdbc.Connection;

import conexion.Conexion;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import org.json.JSONArray;

import javax.swing.GroupLayout.Alignment;
import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Panel;
import java.awt.event.KeyAdapter;

import javax.swing.JTextField;
import javax.swing.RowFilter;

import java.awt.Color;
import javax.swing.JScrollPane;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JPanel;

public class Administracable2 extends javax.swing.JFrame {

    DefaultTableModel modelo = new DefaultTableModel();
    TableRowSorter trs;
    public Administracable2() {
    	
    	
    	setBounds(100,100,1297,482);
    	f_1= new Fondo();
    	f_1.setBorder(new EmptyBorder(5,5,5,5));
    	setContentPane(f_1);
    	
    	
    	
        initComponents();
        

        try {
            jtProductos.setModel(modelo);
            PreparedStatement ps = null;
            ResultSet rs = null;
            Conexion conn = new Conexion();
            java.sql.Connection con = conn.conexion();

            String sql = "Select cf.id_final, cf.color, cf.longitud, cf.diametro, cf.otro_componente, c1.leadcode AS 'l1', c2.leadcode AS 'l2' from cable_fin cf inner join cable c1 on c1.id_cable=cf.fk_cable1 inner join cable c2 on c2.id_cable=cf.fk_cable2 ";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            ResultSetMetaData rsMd = (ResultSetMetaData) rs.getMetaData();
            int cantidadColumnas = rsMd.getColumnCount();

            modelo.addColumn("Código");
            modelo.addColumn("Color");
            modelo.addColumn("Longitud");
            modelo.addColumn("Diametro");
            modelo.addColumn("Otro Componente");
            modelo.addColumn("Cable 1");
            modelo.addColumn("Cable 2");
      

            int[] anchos = {50, 50, 50, 50, 200, 50,50};
            for (int i = 0; i < jtProductos.getColumnCount(); i++) {
                jtProductos.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
               
            }

            while (rs.next()) {
                Object[] filas = new Object[cantidadColumnas];
                for (int i = 0 ; i < cantidadColumnas; i++) {
                    filas[i] = rs.getObject(i + 1);
                    if(i==7) {
                    	 JButton btnnuevo = new JButton("Limpiar");
                    }
                   
                }
                  modelo.addRow(filas);
            }
           
         
        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }
     

    }
    
    public void  actualizar() {
    	modelo.setRowCount(0);
    try {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Conexion conn = new Conexion();
        java.sql.Connection con = conn.conexion();

        String sql = "Select cf.id_final, cf.color, cf.longitud, cf.diametro, cf.otro_componente, c1.leadcode AS 'l1', c2.leadcode AS 'l2' from cable_fin cf inner join cable c1 on c1.id_cable=cf.fk_cable1 inner join cable c2 on c2.id_cable=cf.fk_cable2 ";
        ps = con.prepareStatement(sql);
        rs = ps.executeQuery();

        ResultSetMetaData rsMd = (ResultSetMetaData) rs.getMetaData();
        int cantidadColumnas = rsMd.getColumnCount();

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
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jScrollPane1.setBounds(15, 95, 558, 214);
        jtProductos = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jLabel5.setFont(new Font("Tahoma", Font.BOLD, 13));
        jLabel5.setForeground(Color.WHITE);
        jLabel5.setIcon(new ImageIcon(Administracable.class.getResource("/imagenes/busqueda.png")));
        jLabel5.setBounds(18, 47, 37, 14);
         jLabel5.setText("Busqueda:");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        
        jtProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6", "Title7"
            }
        ));
        jtProductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
            	
               // jtProductosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtProductos);
        f_1.setLayout(null);
        
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
        
        panel = new JPanel();
        panel.setLayout(null);
        
        button = new JButton("Nuevo");
        button.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent arg0) {
        		
        		
        		 JDialog dialog= new Formulario2(Administracable2.this, true);
            	 dialog.addWindowListener(new WindowAdapter() {
                     public void windowClosed(WindowEvent e) {
                         actualizar();
                     }
                 });
                  //hago visible el dialogo
                 dialog.setVisible(true);
                 dialog.setLocationRelativeTo(null);

        		
        	}
        });
        button.setIcon(new ImageIcon(Administracable2.class.getResource("/imagenes/agreg.png")));
        button.setBackground(Color.WHITE);
        button.setBounds(10, 6, 104, 23);
        panel.add(button);
        
        button_1 = new JButton();
        button_1.addMouseListener(new MouseAdapter() {
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
        	            	 ps = conn.prepareStatement("DELETE FROM cable_fin WHERE id_final=?");
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
        button_1.setIcon(new ImageIcon(Administracable2.class.getResource("/imagenes/elimin.png")));
        button_1.setText("Eliminar");
        button_1.setBounds(124, 6, 101, 23);
        panel.add(button_1);
        
        button_2 = new JButton("Modificar");
        button_2.setIcon(new ImageIcon(Administracable2.class.getResource("/imagenes/edit.png")));
        button_2.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent arg0) {
        		jtProductosMouseClicked(arg0);
        		
        		
        	}
        });
        button_2.setBounds(235, 6, 111, 23);
        panel.add(button_2);

       

        javax.swing.GroupLayout gl_f_1 = new javax.swing.GroupLayout(getContentPane());
        gl_f_1.setHorizontalGroup(
        	gl_f_1.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_f_1.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(gl_f_1.createParallelGroup(Alignment.LEADING)
        				.addGroup(gl_f_1.createSequentialGroup()
        					.addComponent(jLabel5, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(textField, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE))
        				.addComponent(panel, GroupLayout.PREFERRED_SIZE, 558, GroupLayout.PREFERRED_SIZE)
        				.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 623, GroupLayout.PREFERRED_SIZE))
        			.addContainerGap(873, Short.MAX_VALUE))
        );
        gl_f_1.setVerticalGroup(
        	gl_f_1.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_f_1.createSequentialGroup()
        			.addGap(38)
        			.addComponent(panel, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
        			.addGap(18)
        			.addGroup(gl_f_1.createParallelGroup(Alignment.BASELINE)
        				.addComponent(jLabel5)
        				.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addGap(18)
        			.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 214, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap(74, Short.MAX_VALUE))
        );
        getContentPane().setLayout(gl_f_1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    
    private void jtProductosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtProductosMouseClicked
    	
        Modificar2 mod=new Modificar2();
    	PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            Conexion objCon = new Conexion();
            Connection conn = (Connection) objCon.conexion();

            
            
            int Fila = jtProductos.getSelectedRow();
            String codigo = jtProductos.getValueAt(Fila, 0).toString();
         

            ps = conn.prepareStatement("Select cf.id_final, cf.color, cf.longitud, cf.diametro, cf.otro_componente, c1.leadcode AS 'l1', c2.leadcode AS 'l2' from cable_fin cf inner join cable c1 on c1.id_cable=cf.fk_cable1 inner join cable c2 on c2.id_cable=cf.fk_cable2 where cf.id_final=?");
            ps.setString(1, codigo);
            rs = ps.executeQuery();
           


            while (rs.next()) {
            	
                mod.txtCodigo.setText(rs.getString("cf.id_final"));               
                mod.txtColor.setText(rs.getString("cf.color"));
                mod.txtLongitud.setText(rs.getString("cf.longitud"));
                mod.txtDiametro.setText(rs.getString("cf.diametro"));
                mod.txtCable1.setText(rs.getString("l1"));
                mod.txtCable2.setText(rs.getString("l2"));
                mod.txtOtro.setText(rs.getString("cf.otro_componente"));



                
            }
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
        mod.addWindowListener(new WindowAdapter() {
            public void windowClosed(WindowEvent e) {
                actualizar();
            }
        });
        mod.setVisible(true);
       mod.setLocationRelativeTo(null);
    }//GEN-LAST:event_jtProductosMouseClicked
    
   /* private void limpiar() {
        txtCodigo.setText("");
        txtColor.setText("");
        txtlonguitud.setText("");
        txtDiametro.setText("");
        txtCable1.setText("");
        txtCable2.setText("");
        txtOtro.setText("");
    }*/
   

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         *
         */
    	 
   
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Administracable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Administracable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Administracable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Administracable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
            	
            	
            	
               
            }
        });
    }
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtProductos;
    private Fondo f_1;
    private JTextField textField;
    private JPanel panel;
    private JButton button;
    private JButton button_1;
    private JButton button_2;
}
