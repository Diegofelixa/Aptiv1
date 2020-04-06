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
import javax.swing.JLabel;

public class Admin_Personal extends JFrame {

	private JPanel contentPane;
	



		DefaultTableModel modelo = new DefaultTableModel();
	    TableRowSorter trs;

	public Admin_Personal() 
	{
		setTitle("Administrar Personal");
		
	    
	    	
	    	
	    	setBounds(100,100,871,465);
	    	f_1= new Fondo();
	    	f_1.setBorder(new EmptyBorder(5,5,5,5));
	    	setContentPane(f_1);
	    	
	    	
	    	
	        initComponents();
	        

	        try 
	        {
	        	jtPersonal.setModel(modelo);
	            PreparedStatement ps = null;
	            ResultSet rs = null;
	            Conexion conn = new Conexion();
	            java.sql.Connection con = conn.conexion();

	            String sql = "SELECT op.id_ngafet, op.nombre,op.apellido, c1.nombre_estacion AS 'l1', c2.nombre_turno AS 'l2' FROM operador op INNER join estacion c1 on op.estacion=c1.id_estacion inner join turno c2 ON c2.id_turno=op.fk_turno";
	            ps = con.prepareStatement(sql);
	            rs = ps.executeQuery();

	            ResultSetMetaData rsMd = (ResultSetMetaData) rs.getMetaData();
	            int cantidadColumnas = rsMd.getColumnCount();

	            modelo.addColumn("#Gaffete");
	            modelo.addColumn("Nombre");
	            modelo.addColumn("Apellido");
	            modelo.addColumn("Estacion");
	            modelo.addColumn("Turno");

	            int[] anchos = {50, 50, 50, 50, 50};
	            for (int i = 0; i < jtPersonal.getColumnCount(); i++) 
		            {
	            	  jtPersonal.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
		            }

	            while (rs.next()) 
	            {
	                Object[] filas = new Object[cantidadColumnas];
	                for (int i = 0; i < cantidadColumnas; i++) 
	                {
	                    filas[i] = rs.getObject(i + 1);
	                }
	                modelo.addRow(filas);
	            }

	        } catch (SQLException ex) 
		        {
		            System.err.println(ex.toString());
		        }
	        
	       
	     

	    }

		    public void salir() 
			    {
			    	dispose();
			    }
	    public void  actualizar() 
	    {
	    	modelo.setRowCount(0);
	    try 
	    {
	        PreparedStatement ps = null;
	        ResultSet rs = null;
	        Conexion conn = new Conexion();
	        java.sql.Connection con = conn.conexion();

	        String sql = "SELECT op.id_ngafet, op.nombre,op.apellido, c1.nombre_estacion AS 'l1', c2.nombre_turno AS 'l2' FROM operador op INNER join estacion c1 on op.estacion=c1.id_estacion inner join turno c2 ON c2.id_turno=op.fk_turno";
	        ps = con.prepareStatement(sql);
	        rs = ps.executeQuery();

	        ResultSetMetaData rsMd = (ResultSetMetaData) rs.getMetaData();
	        int cantidadColumnas = rsMd.getColumnCount();

	        while (rs.next()) 
	        {
	            Object[] filas = new Object[cantidadColumnas];
	            for (int i = 0; i < cantidadColumnas; i++) 
	            {
	                filas[i] = rs.getObject(i + 1);
	            }
	            modelo.addRow(filas);
	        }

	    } catch (SQLException ex) 
		    {
		        System.err.println(ex.toString());
		    }
	   
	    	
	    }
	    @SuppressWarnings("unchecked")
	    
	    
	    private void initComponents() 
	    {

	        tabla_operador = new javax.swing.JScrollPane();
	        tabla_operador.setBounds(15, 95, 558, 214);
	        jtPersonal = new javax.swing.JTable();
	        jLabel5 = new javax.swing.JLabel();
	        jLabel5.setForeground(Color.WHITE);
	        jLabel5.setFont(new Font("Tahoma", Font.BOLD, 13));
	        jLabel5.setIcon(new ImageIcon(Admin_Personal.class.getResource("/imagenes/busqueda.png")));
	        jLabel5.setBounds(18, 47, 37, 14);
	         jLabel5.setText("Busqueda:");

	        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

	        
	        jtPersonal.setModel(new javax.swing.table.DefaultTableModel(
	            new Object [][] 
		            {
			                {null, null, null, null, null, null},
			                {null, null, null, null, null, null},
			                {null, null, null, null, null, null},
			                {null, null, null, null, null, null}
		            },
	            new String [] 
			            {
			                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6"
			            }
	        ));
	       
	        tabla_operador.setViewportView(jtPersonal);
	        f_1.setLayout(null);
	        
	        txt_busqueda = new JTextField();
	        txt_busqueda.addKeyListener(new KeyAdapter() 
	        {
	        	@Override
	        	public void keyReleased(KeyEvent Ke) 
		        	{
		        		trs.setRowFilter(RowFilter.regexFilter(txt_busqueda.getText() ));
		        	}
	        });
	        trs=new TableRowSorter(modelo);
	        jtPersonal.setRowSorter(trs);
	        txt_busqueda.setColumns(10);
	        
	        panel = new JPanel();
	        
	        JLabel lbl_letrero = new JLabel("Selecciona el Registro a eliminar o modificar ");
	        lbl_letrero.setFont(new Font("Tahoma", Font.BOLD, 13));
	        lbl_letrero.setForeground(Color.WHITE);

	       

	        javax.swing.GroupLayout gl_f_1 = new javax.swing.GroupLayout(getContentPane());
	        gl_f_1.setHorizontalGroup(
	        	gl_f_1.createParallelGroup(Alignment.TRAILING)
	        		.addGroup(gl_f_1.createSequentialGroup()
	        			.addContainerGap()
	        			.addGroup(gl_f_1.createParallelGroup(Alignment.LEADING)
	        				.addGroup(gl_f_1.createSequentialGroup()
	        					.addComponent(jLabel5, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)
	        					.addPreferredGap(ComponentPlacement.UNRELATED)
	        					.addComponent(txt_busqueda, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE)
	        					.addGap(49)
	        					.addComponent(lbl_letrero, GroupLayout.PREFERRED_SIZE, 310, GroupLayout.PREFERRED_SIZE))
	        				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 659, Short.MAX_VALUE)
	        				.addComponent(tabla_operador, GroupLayout.PREFERRED_SIZE, 659, GroupLayout.PREFERRED_SIZE))
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
	        				.addComponent(txt_busqueda, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
	        				.addComponent(lbl_letrero))
	        			.addPreferredGap(ComponentPlacement.RELATED)
	        			.addComponent(tabla_operador, GroupLayout.PREFERRED_SIZE, 213, GroupLayout.PREFERRED_SIZE)
	        			.addContainerGap(75, Short.MAX_VALUE))
	        );
	        panel.setLayout(null);
	        
	        JButton btnRegistrar = new JButton("Nuevo");
	        btnRegistrar.setBackground(Color.WHITE);
	        btnRegistrar.setIcon(new ImageIcon(Admin_Personal.class.getResource("/imagenes/agreg.png")));
	        btnRegistrar.addActionListener(new ActionListener() 
	        {
	        	public void actionPerformed(ActionEvent arg0) 
		        	{
		        		Agregar_p p = new  Agregar_p();
		        		p.setVisible(true);
		        	}
	        
	        });
	       
	        btnRegistrar.setBounds(10, 6, 104, 23);
	        
	        panel.add(btnRegistrar);
	        btnEliminar = new javax.swing.JButton();
	        btnEliminar.setIcon(new ImageIcon(Admin_Personal.class.getResource("/imagenes/elimin.png")));
	        btnEliminar.setBounds(265, 6, 101, 23);
	        panel.add(btnEliminar);
	        
	                btnEliminar.setText("Eliminar");
	                
	                JButton btnModificar_1 = new JButton("Modificar");
	                btnModificar_1.setIcon(new ImageIcon(Admin_Personal.class.getResource("/imagenes/edit.png")));
	                btnModificar_1.addActionListener(new ActionListener()
	                {
	                	
	                		public void actionPerformed(ActionEvent evt) 
		                		{
		                			jtPersonalMouseClicked(evt);
		                   	    }
	                });
	               
	                btnModificar_1.setBounds(532, 6, 115, 23);
	                panel.add(btnModificar_1);
	                btnEliminar.addActionListener(new java.awt.event.ActionListener() 
	                {
	                    public void actionPerformed(java.awt.event.ActionEvent evt)
		                    {
		                      btnEliminarActionPerformed(evt);
		                    }
	                });
	        getContentPane().setLayout(gl_f_1);

	        pack();
	    }

	   
	    
	    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) 
		    {
		      actualizar();
		    }

	    
	   
	    private void jtPersonalMouseClicked(java.awt.event.ActionEvent evt) 
	    {
	    	
	        actualiza actualizar=new actualiza();
	    	
	        PreparedStatement ps = null;
	        ResultSet rs = null;
	        try 
	        {
	            Conexion objCon = new Conexion();
	            Connection conn = (Connection) objCon.conexion();

	            
	            
	            int Fila = jtPersonal.getSelectedRow();
	            String codigo = jtPersonal.getValueAt(Fila, 0).toString();
	         

	            ps = conn.prepareStatement("SELECT op.id_ngafet,op.nombre,op.apellido, c1.nombre_estacion, c2.nombre_turno  FROM operador op INNER join estacion c1 on op.estacion=c1.id_estacion  inner join turno c2 ON c2.id_turno=op.fk_turno WHERE id_ngafet=? ");
	            ps.setString(1, codigo);
	            rs = ps.executeQuery();
	           


	            while (rs.next()) 
	            {
	            	actualizar.txt_ngafete.setText(rs.getString("id_ngafet"));
	                actualizar.txt_nombre.setText(rs.getString("nombre"));               
	                actualizar. txt_apellido.setText(rs.getString("apellido"));
	                actualizar. txt_estacion.setText(rs.getString("nombre_estacion"));
	                actualizar.txt_turno.setText(rs.getString("nombre_turno"));
	              
	           }
	       } 
	        
	        catch (SQLException ex) 
		        {
		          System.out.println(ex.toString());
		        }
	        actualizar.addWindowListener(new WindowAdapter() 
	        {
	            public void windowClosed(WindowEvent e) 
		            {
		              actualizar();
		            }
	        });
	        actualizar.setVisible(true);
	       actualizar.setLocationRelativeTo(null);

	        
	    }
 
	    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) 
	    {

	        PreparedStatement ps = null;
	        try {

	            Conexion objCon = new Conexion();
	            Connection conn = (Connection) objCon.conexion();

	            int Fila = jtPersonal.getSelectedRow();
	            String codigo = jtPersonal.getValueAt(Fila, 0).toString();

	            
	            int respuesta= JOptionPane.showConfirmDialog(null, "Realmente quiere eliminar este empleado?","Confirmacion de Eliminar", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
	            if(respuesta==JOptionPane.YES_OPTION) 
		            {
		            	 ps = conn.prepareStatement("DELETE FROM operador WHERE id_ngafet=?");
		                 ps.setString(1, codigo);
		                 ps.execute();
	
		                 modelo.removeRow(Fila);
		                 JOptionPane.showMessageDialog(null, "Empleado Eliminado");
		                // limpiar();
		            	
		            }
	           

	        } 
	        
	        catch (SQLException ex) 
		        {
		            JOptionPane.showMessageDialog(null, "Error al Eliminar Empleado");
		            System.out.println(ex.toString());
		        }
	    }
	    
	 

	    public static void main(String args[]) 
	    {
	     
	   
	        try 
	        {
	            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) 
	            {
	                if ("Windows".equals(info.getName())) 
		                {
		                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
		                    break;
		                }
	            }
	        } catch (ClassNotFoundException ex) {
	            java.util.logging.Logger.getLogger(Admin_Personal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	        } catch (InstantiationException ex) {
	            java.util.logging.Logger.getLogger(Admin_Personal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	        } catch (IllegalAccessException ex) {
	            java.util.logging.Logger.getLogger(Admin_Personal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
	            java.util.logging.Logger.getLogger(Admin_Personal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	        }
	      
	        java.awt.EventQueue.invokeLater(new Runnable() 
	        {
	            public void run() 
	            {
	            	
	            	Admin_Personal f=new Admin_Personal();
	            	//f.setExtendedState(MAXIMIZED_BOTH);
	            	f.setSize(800,600);
	            	f.setResizable(false);
	            	f.setVisible(true);
	            }
	        
	       });
	    }
	    
	    
	    private javax.swing.JButton btnEliminar;
	    private javax.swing.JLabel jLabel5;
	    private javax.swing.JScrollPane tabla_operador;
	    private javax.swing.JTable jtPersonal;
	    private Fondo f_1;
	    private JTextField txt_busqueda;
	    private JPanel panel;
	
}
		