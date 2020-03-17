package aptiv1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
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

public class Administrarestaciones extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	  DefaultTableModel modelo = new DefaultTableModel();
	  TableRowSorter trs;
	 public Administrarestaciones() {
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

            String sql = "Select nombre_estacion,descripcion,status from estacion";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            ResultSetMetaData rsMd = (ResultSetMetaData) rs.getMetaData();
            int cantidadColumnas = rsMd.getColumnCount();

            modelo.addColumn("Nombre de la Estacion");
            modelo.addColumn("Descripcion");
            modelo.addColumn("Estatus");
           
      

            int[] anchos = {50, 100, 50};
            for (int i = 0; i < jtProductos.getColumnCount(); i++) {
                jtProductos.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
               
            }

            while (rs.next()) {
                Object[] filas = new Object[cantidadColumnas];
                for (int i = 0 ; i < cantidadColumnas; i++) {
                    filas[i] = rs.getObject(i + 1);
                    if(i==3) {
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

        String sql = "Select nombre_estacion,descripcion,status from estacion";
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
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3"
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
        		
        		JDialog dialog= new Agregar_estacion();
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
        button.setIcon(new ImageIcon(Administrarestaciones.class.getResource("/imagenes/agreg.png")));
        button.setBackground(Color.WHITE);
        button.setBounds(10, 6, 104, 23);
        panel.add(button);
        
        button_2 = new JButton("Modificar");
        button_2.setIcon(new ImageIcon(Administrarestaciones.class.getResource("/imagenes/edit.png")));
        button_2.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent arg0) {
        		jtProductosMouseClicked(arg0);
        		
        		  
        	}
        });
        button_2.setBounds(139, 6, 111, 23);
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
        				.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 513, GroupLayout.PREFERRED_SIZE))
        			.addContainerGap(938, Short.MAX_VALUE))
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
    	
       
    	PreparedStatement ps = null;
        ResultSet rs = null;
        String estado=null;
        try {
            Conexion objCon = new Conexion();
            Connection conn = (Connection) objCon.conexion();

            
           
            int Fila = jtProductos.getSelectedRow();
            String codigo = jtProductos.getValueAt(Fila, 0).toString();
            
            ps = conn.prepareStatement("Select * from estacion where nombre_estacion=?");
            ps.setString(1, codigo);
            rs = ps.executeQuery();
            if(rs.next()) {
            	
                	
               	 if(rs.getInt("status")==1) {
                    	estado="Activa";
                    }else if (rs.getInt("status")==0){
                    	estado="Inactiva";
                    }
            	
            }
             
             Mod_estacion mod=new Mod_estacion(estado);
             mod.txtNombre.setText(jtProductos.getValueAt(Fila, 0).toString());               
             mod.txtDescripcion.setText(jtProductos.getValueAt(Fila, 1).toString());
             
             mod.setVisible(true);
           	 mod.addWindowListener(new WindowAdapter() {
                    public void windowClosed(WindowEvent e) {
                        actualizar();
                    }
                });
    		
          
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }//GEN-LAST:event_jtProductosMouseClicked
    
  

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         *
         */
    	 Administrarestaciones tur= new Administrarestaciones();
    	 tur.setVisible(true);
    	 tur.setSize(800,600);
    	 tur.setResizable(false);
     	
   
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
    private JButton button_2;

}
