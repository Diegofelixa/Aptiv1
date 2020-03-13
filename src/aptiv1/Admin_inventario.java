package aptiv1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import com.mysql.jdbc.Connection;

import conexion.Conexion;

public class Admin_inventario extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	 DefaultTableModel modelo = new DefaultTableModel();
	    TableRowSorter trs;
	public Admin_inventario() {
		setBounds(100,100,757,464);
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

            String sql = "Select inv.id_inventario, inv.cantidad_atados, inv.fecha_hora, cf.id_final AS 'l1' from inventario inv inner join cable_fin cf on inv.fk_final=cf.id_final ";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            ResultSetMetaData rsMd = (ResultSetMetaData) rs.getMetaData();
            int cantidadColumnas = rsMd.getColumnCount();

            modelo.addColumn("# Inventario");
            modelo.addColumn("Cantidad de Atados");
            modelo.addColumn("Fecha y Hora");
            modelo.addColumn("Codigo del cable");
           

            int[] anchos = {100, 100, 100, 100};
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

   
    public void  actualizar() {
    	modelo.setRowCount(0);
    try {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Conexion conn = new Conexion();
        java.sql.Connection con = conn.conexion();

        String sql = "Select inv.id_inventario, inv.cantidad_atados, inv.fecha_hora, cf.id_final AS 'l1' from inventario inv inner join cable_fin cf on inv.fk_final=cf.id_final ";
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
        jLabel5.setForeground(Color.WHITE);
        jLabel5.setFont(new Font("Tahoma", Font.BOLD, 13));
        jLabel5.setIcon(new ImageIcon(Admin_inventario.class.getResource("/imagenes/busqueda.png")));
        jLabel5.setBounds(18, 47, 37, 14);
         jLabel5.setText("Busqueda:");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        
        jtProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
       /* jtProductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
            	
                jtProductosMouseClicked(evt);
            }
        });*/
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

       

        javax.swing.GroupLayout gl_f_1 = new javax.swing.GroupLayout(getContentPane());
        gl_f_1.setHorizontalGroup(
        	gl_f_1.createParallelGroup(Alignment.TRAILING)
        		.addGroup(gl_f_1.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(gl_f_1.createParallelGroup(Alignment.LEADING)
        				.addGroup(gl_f_1.createSequentialGroup()
        					.addComponent(jLabel5, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)
        					.addPreferredGap(ComponentPlacement.UNRELATED)
        					.addComponent(textField, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE))
        				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 659, Short.MAX_VALUE)
        				.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 659, GroupLayout.PREFERRED_SIZE))
        			.addGap(600))
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
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 213, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap(75, Short.MAX_VALUE))
        );
        panel.setLayout(null);
        btnEliminar = new javax.swing.JButton();
        btnEliminar.setIcon(new ImageIcon(Admin_inventario.class.getResource("/imagenes/elimin.png")));
        btnEliminar.setBounds(10, 6, 101, 23);
       
        panel.add(btnEliminar);
        
                btnEliminar.setText("Eliminar");
                
                JButton btnModificar_1 = new JButton("Modificar");
                btnModificar_1.setIcon(new ImageIcon(Admin_inventario.class.getResource("/imagenes/edit.png")));
               
                btnModificar_1.addActionListener(new ActionListener() {
                	
                		public void actionPerformed(ActionEvent evt) {
                			 jtProductosMouseClicked(evt);
                       		 JDialog dialog= new Actualizar_inventario(Admin_inventario.this, true);
                           	 dialog.addWindowListener(new WindowAdapter() {
                                    public void windowClosed(WindowEvent e) {
                                        actualizar();
                                    }
                                });   			
                		
                            		
                   	               		
                	}
                });
                btnModificar_1.addMouseListener(new MouseAdapter() {
                	@Override
                	public void mouseClicked(MouseEvent evt) {
                		
                	}
                });
                btnModificar_1.setBounds(121, 6, 115, 23);
                btnModificar_1.setVisible(false);
                panel.add(btnModificar_1);
                btnEliminar.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        btnEliminarActionPerformed(evt);
                    }
                });
        getContentPane().setLayout(gl_f_1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

   
   
    
    private void jtProductosMouseClicked(ActionEvent evt) {//GEN-FIRST:event_jtProductosMouseClicked
    	
      Actualizar_inventario actualizar=new Actualizar_inventario(null, rootPaneCheckingEnabled);
    	PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            Conexion objCon = new Conexion();
            Connection conn = (Connection) objCon.conexion();

            
            
            int Fila = jtProductos.getSelectedRow();
            String codigo = jtProductos.getValueAt(Fila, 0).toString();
         

            ps = conn.prepareStatement("Select inv.id_inventario, inv.cantidad_atados, inv.fecha_hora, cf.id_final AS 'l1' from inventario inv inner join cable_fin cf on inv.fk_final=cf.id_final where inv.id_inventario=?");
            ps.setString(1, codigo);
            rs = ps.executeQuery();
           


            while (rs.next()) {
            	
                actualizar.txtCodigo.setText(rs.getString("id_inventario"));               
                actualizar. txtAtados.setText(rs.getString("cantidad_atados"));
                actualizar.txtCable.setText(rs.getString("l1"));
            
               
                
            }
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
        actualizar.addWindowListener(new WindowAdapter() {
            public void windowClosed(WindowEvent e) {
                actualizar();
            }
        });
        actualizar.setVisible(true);
       actualizar.setLocationRelativeTo(null);

        
    }//GEN-LAST:event_jtProductosMouseClicked

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed

        PreparedStatement ps = null;
        try {

            Conexion objCon = new Conexion();
            Connection conn = (Connection) objCon.conexion();

            int Fila = jtProductos.getSelectedRow();
            String codigo = jtProductos.getValueAt(Fila, 0).toString();

            
            int respuesta= JOptionPane.showConfirmDialog(null, "Realmente quiere eliminar este cable?","Confirmacion de Eliminar", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
            if(respuesta==JOptionPane.YES_OPTION) {
            	 ps = conn.prepareStatement("DELETE FROM inventario WHERE id_inventario=?");
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
    }//GEN-LAST:event_btnEliminarActionPerformed
    
   /* private void limpiar() {
        txtCodigo.setText("");
        txtColor.setText("");
        txtlonguitud.setText("");
        txtNumhilos.setText("");
        txtCalibre.setText("");
        txtAislante.setText("");
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
            java.util.logging.Logger.getLogger(Admin_inventario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Admin_inventario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Admin_inventario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Admin_inventario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
            	
            	Admin_inventario f=new Admin_inventario();
            	//f.setExtendedState(MAXIMIZED_BOTH);
            	f.setSize(800,600);
            	f.setResizable(false);
            	f.setVisible(true);
            	
               
            }
        });
    }
    private javax.swing.JButton btnEliminar;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtProductos;
    private Fondo f_1;
    private JTextField textField;
    private JPanel panel;
}
