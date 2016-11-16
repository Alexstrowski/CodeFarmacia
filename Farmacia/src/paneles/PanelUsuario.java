package paneles;

import javax.swing.JPanel;

import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Date;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;

import java.awt.Font;
import java.awt.AWTException;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableRowSorter;

import farmacia.CargarArchivo;
import farmacia.EscribirArchivo;
import farmacia.Validacion;
import farmacia.ValidarCampo;
import farmacia.VentanaMenu;
import listas.ListaMedicamento;
import listas.ListaUsuario;
import listas.NodoMedicamento;
import listas.NodoUsuario;
import listas.NodoVenta;

import javax.swing.ImageIcon;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.DefaultComboBoxModel;

public class PanelUsuario extends JPanel {
	private JTextField tfNombre;
	private JTextField tfBuscar;
	private JTextField tfApellido;
	private JTextField tfDir;
	private JTextField tfTel;
	private JTextField tfUsuario;
	private JTextField tfPass;
	private JTable table;
	private DefaultTableModel dtm;	
	private JComboBox comboFiltro;
	private TableRowSorter trsFiltro;
	private JComboBox comboCargo;
	private boolean filtroTabla=false;
	

	private ListaUsuario lista;

	public PanelUsuario(ListaUsuario p) {
		setLayout(null);
		lista = p;
		
		JPanel panelDatos = new JPanel();
		panelDatos.setBorder(new TitledBorder(null, "Registro", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelDatos.setBounds(102, 0, 503, 164);
		add(panelDatos);
		panelDatos.setLayout(null);
		
		JLabel lblNombres = new JLabel("Nombres :");
		lblNombres.setBounds(10, 26, 70, 14);
		panelDatos.add(lblNombres);
		
		JLabel lblApellidos = new JLabel("Apellidos :");
		lblApellidos.setBounds(10, 65, 70, 14);
		panelDatos.add(lblApellidos);
		
		JLabel lblDireccion = new JLabel("Direcci\u00F3n :");
		lblDireccion.setBounds(10, 103, 95, 14);
		panelDatos.add(lblDireccion);
		
		JLabel lblTelefono = new JLabel("Telefono :");
		lblTelefono.setBounds(248, 26, 70, 14);
		panelDatos.add(lblTelefono);
		
		JLabel lblUsuario = new JLabel("Usuario :");
		lblUsuario.setBounds(248, 65, 70, 14);
		panelDatos.add(lblUsuario);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a :");
		lblContrasea.setBounds(248, 103, 86, 14);
		panelDatos.add(lblContrasea);
		
		tfNombre = new JTextField();
		tfNombre.setBounds(90, 23, 126, 20);
		panelDatos.add(tfNombre);
		tfNombre.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				Validacion.validarLetra(e);
			}
		});
		tfNombre.setColumns(10);
		
		tfApellido = new JTextField();
		tfApellido.setColumns(10);
		tfApellido.setBounds(90, 62, 126, 20);
		panelDatos.add(tfApellido);
		tfApellido.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				Validacion.validarLetra(e);
			}
		});
		
		tfDir = new JTextField();
		tfDir.setColumns(10);
		tfDir.setBounds(90, 100, 126, 20);
		panelDatos.add(tfDir);
		
		tfTel = new JTextField();
		tfTel.setColumns(10);
		tfTel.setBounds(333, 23, 126, 20);
		panelDatos.add(tfTel);
		tfTel.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				Validacion.validarNumero(e);
			}
		});
		
		tfUsuario = new JTextField();
		tfUsuario.setColumns(10);
		tfUsuario.setBounds(333, 62, 126, 20);
		panelDatos.add(tfUsuario);
		
		tfPass = new JTextField();
		tfPass.setColumns(10);
		tfPass.setBounds(333, 100, 126, 20);
		panelDatos.add(tfPass);
		
		JLabel lblCargo = new JLabel("Cargo :");
		lblCargo.setBounds(10, 139, 46, 14);
		panelDatos.add(lblCargo);
		
		comboCargo = new JComboBox();
		comboCargo.setModel(new DefaultComboBoxModel(new String[] {"Administrador", "Farmaceutico"}));
		comboCargo.setBounds(90, 134, 126, 20);
		panelDatos.add(comboCargo);
		
		JLabel label_3 = new JLabel("Buscar :");
		label_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_3.setBounds(75, 239, 46, 14);
		add(label_3);
		
		tfBuscar = new JTextField();
		tfBuscar.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				txtFiltroKeyTyped(e);
			}
		});
		tfBuscar.setColumns(10);
		tfBuscar.setBackground(new Color(224, 255, 255));
		tfBuscar.setBounds(305, 236, 322, 20);
		add(tfBuscar);
		
		comboFiltro = new JComboBox();
		comboFiltro.setModel(new DefaultComboBoxModel(new String[] {"Cargo", "Nombres"}));
		comboFiltro.setBounds(167, 236, 108, 20);
		add(comboFiltro);
		
		JButton btnEliminar= new JButton((String) null);
		btnEliminar.setIcon(new ImageIcon(PanelUsuario.class.getResource("/iconos/Delete-32.png")));
		btnEliminar.setBounds(319, 181, 89, 44);
		add(btnEliminar);
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(table.getSelectedRow()>-1){
					botonEliminar(e);
				}else{
					JOptionPane.showMessageDialog(null,"Debe seleccionar una fila primero","WARNING_MESSAGE",JOptionPane.WARNING_MESSAGE);
				}
					
			}
		});
		
		JButton btnEditar = new JButton("");
		btnEditar.setIcon(new ImageIcon(PanelUsuario.class.getResource("/iconos/Edit File Filled-32.png")));
		btnEditar.setBounds(447, 181, 89, 44);
		add(btnEditar);
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(table.getSelectedRow()>-1){
					botonEditar(e);
				}else{
					JOptionPane.showMessageDialog(null,"Debe seleccionar una fila primero","WARNING_MESSAGE",JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		
		JButton btnAgregar = new JButton("");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				botonAgregar(e);
			}
		});
		btnAgregar.setIcon(new ImageIcon(VentanaMenu.class.getResource("/iconos/Plus-32.png")));
		btnAgregar.setBounds(190, 181, 89, 44);
		add(btnAgregar);
		
		JLabel label = new JLabel("Agregar");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(new Color(34, 139, 34));
		label.setFont(new Font("Tahoma", Font.BOLD, 11));
		label.setBounds(192, 156, 89, 28);
		add(label);
		
		JLabel label_1 = new JLabel("Eliminar");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setForeground(Color.RED);
		label_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_1.setBounds(319, 156, 89, 28);
		add(label_1);
		
		JLabel label_2 = new JLabel("Editar");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setForeground(new Color(255, 153, 0));
		label_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_2.setBounds(447, 156, 89, 28);
		add(label_2);
		
		cargarArchivo(lista);
		
		
		table=crearTabla(lista);
		
		table.setPreferredScrollableViewportSize(new Dimension(500, 70));
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 264, 677, 209);
		add(scrollPane);

	}
	
	private JTable crearTabla(ListaUsuario lista){
		
		Object[][] data = {};					//array bidimencional de objetos con los datos de la tabla
              
        //array de String's con los tÌtulos de las columnas
        String[] columnNames = {"Código",
        						"Cargo",
        						"Nombres",
                                "Apellidos",
                                "Dirección",
                                "Telefono",
                                "Usuario",
                                "Contraseña"};
        
     
        dtm= new DefaultTableModel(data, columnNames){
        	
        	public boolean isCellEditable(int row, int column) {
				return false;
        	}
        	
        };	//creamos el Modelo de la tabla con los datos anteriores
        JTable tabla = new JTable(dtm);	 	//se crea la Tabla con el modelo DefaultTableModel
        tabla.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        tabla.setMinimumSize(new Dimension(119, 0));
        
        // DIMENSION A LAS COLUMNAS //
        
        tabla.getColumnModel().getColumn(0).setPreferredWidth(50);    // CODIGO
        tabla.getColumnModel().getColumn(1).setPreferredWidth(200);	  // NOMBRE
        tabla.getColumnModel().getColumn(2).setPreferredWidth(150);   // LABORATORIO
        tabla.getColumnModel().getColumn(3).setPreferredWidth(60);	  // CANTIDAD
        tabla.getColumnModel().getColumn(4).setPreferredWidth(160);	  // PRESENTACION
        tabla.getColumnModel().getColumn(5).setPreferredWidth(160);   // FECHA DE CADUCIDAD
        tabla.getColumnModel().getColumn(6).setPreferredWidth(160);
        
        // CENTRADO DE LAS LETRAS //
        
        DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
        tcr.setHorizontalAlignment(SwingConstants.CENTER);
        for(int i=0; i<7 ; i++){
        	tabla.getColumnModel().getColumn(i).setCellRenderer(tcr);
        }
        
        JTableHeader header = tabla.getTableHeader();
        header.setBackground(Color.DARK_GRAY);
        header.setForeground(Color.white);
        header.setFont(new Font("Tahoma", Font.BOLD, 11));
        
        // LLENADO DE LA TABLA //
        
        NodoUsuario aux = lista.getInicio();
        
        while(aux!=null){
        	Object[] nuevaFila={aux.getCodigo(),aux.getCargo(),aux.getNombre(),aux.getApellido(),aux.getDireccion(),aux.getTelefono(),aux.getUsuario(),aux.getPassword()};
        	dtm.addRow(nuevaFila);
        	aux=aux.getSiguiente();
        	
        }
		
        return tabla;
	}
	
	private void botonAgregar(java.awt.event.ActionEvent evt){
		
		
		ValidarCampo vc = new ValidarCampo();
		
		if(vc.validarCampo(tfNombre) && vc.validarCampo(tfApellido) && vc.validarCantidad(tfTel) && vc.validarCampo(tfDir) && vc.validarCampo(tfPass) && vc.validarCampo(tfUsuario)){
		
			int codigo = lista.dimension()+1;
			String nombre = tfNombre.getText();
			String apellido = tfApellido.getText();
			String telefono = tfTel.getText();
			String direccion = tfDir.getText();
			String password = tfPass.getText();
			String usuario = tfUsuario.getText();
			String cargo = comboCargo.getSelectedItem().toString();
			
			if(lista.verificarRepetido(nombre, apellido, usuario, cargo)){
					
				JOptionPane.showMessageDialog(null, "¡ El elemento ya está en la lista !","Error",JOptionPane.ERROR_MESSAGE);
			}else{
					
				lista.insertarFinal(codigo,cargo,nombre, apellido,direccion,telefono,usuario,password);
					
				Object[] newRow={codigo,cargo,nombre, apellido,direccion,telefono,usuario,password};
				dtm.addRow(newRow);
					
				escribirArchivo(lista);
					
				tfNombre.setText("");
				tfApellido.setText("");
				tfTel.setText("");
				tfDir.setText("");
				tfPass.setText("");
				tfUsuario.setText("");
					
				JOptionPane.showMessageDialog(null, "AGREGADO");	
			}
		}
		
	}
	
	private void botonEditar(java.awt.event.ActionEvent evt){
		
		tfBuscar.requestFocus();
		Robot robot;
		try {
			robot = new Robot();
			robot.keyPress(KeyEvent.VK_BACK_SPACE);
		} catch (AWTException e) {
			e.printStackTrace();
		}
		
		int fila = table.getSelectedRow();
		int modelIndex = 0;
		NodoUsuario aux=null;
		
		if(filtroTabla){
			
			modelIndex = table.convertRowIndexToModel(fila);
			modelIndex++;
			aux=lista.buscarNodo(modelIndex);
			fila = modelIndex;
			setFiltroTabla(false);
		}else{
			int indiceTablaOrdenada = table.convertRowIndexToView(fila);
			indiceTablaOrdenada++;
			aux=lista.buscarNodo(indiceTablaOrdenada);
			fila = indiceTablaOrdenada;
		}
	
		
		try{
			EditarUsuario em = new EditarUsuario(aux,lista,fila,dtm);
			em.setVisible(true);
		}catch(Exception ex){
			
		}
		
		tfBuscar.setText("");
			
	}
	
	private void botonEliminar(java.awt.event.ActionEvent evt){
		
		
		int ax = JOptionPane.showConfirmDialog(null, "¿ Está seguro de eliminar el usuario ?");
        if(ax == JOptionPane.YES_OPTION){
        	DefaultTableModel model = (DefaultTableModel)table.getModel();
        	
    		
    		int modelIndex = 0;
    		int fila = table.getSelectedRow();
    		
    		if(filtroTabla){
    			
    			modelIndex = table.convertRowIndexToModel(fila);
    			modelIndex++;
    			lista.eliminar(modelIndex);
    			model.removeRow(table.getSelectedRow()); 
    			setFiltroTabla(false);
    		}else{
    			int indiceTablaOrdenada = table.convertRowIndexToView(fila);
    			indiceTablaOrdenada++;
    			lista.eliminar(indiceTablaOrdenada);
    			model.removeRow(table.getSelectedRow()); 
    		}
     
            
            JOptionPane.showMessageDialog(null, "¡ Usuario eliminado !");
        }
        
      	tfBuscar.requestFocus();
    		Robot robot;
    		try {
    			robot = new Robot();
    			robot.keyPress(KeyEvent.VK_BACK_SPACE);
    		} catch (AWTException e) {
    			e.printStackTrace();
    		}
    		tfBuscar.setText("");
    		
    		((DefaultTableModel)table.getModel()).setRowCount( 0); // limpiar JTABLE OPTIMIZADO
    		actualizarTabla();
	}

	

	
	public void escribirArchivo(ListaUsuario lista){   
		
        EscribirArchivo.escribirArchivoUsuarios(lista);
        
    }
	
	
	public void cargarArchivo(ListaUsuario lista){
			
		CargarArchivo.cargarArchivoUsuarios(lista);
			
	}
	
	
	public void filtro() {
        int columnaABuscar = 0;
        
        if (comboFiltro.getSelectedItem().toString() == "Cargo") {
            columnaABuscar = 1;
            
        }
        
        if (comboFiltro.getSelectedItem().toString() == "Nombres") {
            columnaABuscar = 2;
            
        }
        

        trsFiltro.setRowFilter(RowFilter.regexFilter(tfBuscar.getText(), columnaABuscar));
	}
	
	private void txtFiltroKeyTyped(java.awt.event.KeyEvent e) {
 
		tfBuscar.addKeyListener(new KeyAdapter() {	
			public void keyReleased(KeyEvent ke){
				String cadena = (tfBuscar.getText());
				tfBuscar.setText(cadena);
				repaint();
				filtro();
			}
		});
		
		setFiltroTabla(true);
		trsFiltro = new TableRowSorter(table.getModel());
		table.setRowSorter(trsFiltro);
    }
	


	private void limpiarTable(){
		
		try {
	        DefaultTableModel modelo=(DefaultTableModel) table.getModel();
	        int filas=table.getRowCount();
	        for (int i = 0;i<filas; i++) {
	            modelo.removeRow(0);
	        }
	    } catch (Exception e) {
	        JOptionPane.showMessageDialog(null, "Error al limpiar la tabla.");
	    }
	}
	
	private void actualizarTabla(){
		
		NodoUsuario aux = lista.getInicio();
		int i = 1;
	    
	    while(aux!=null){
	    	
	    	aux.setCodigo(i);
	    	Object[] nuevaFila={aux.getCodigo(),aux.getCargo(),aux.getNombre(),aux.getApellido(),aux.getDireccion(),aux.getTelefono(),aux.getUsuario(),aux.getPassword()};
	    	dtm.addRow(nuevaFila);
	    	aux=aux.getSiguiente();
	    	
	    	i++;
	    }
	    
	    escribirArchivo(lista);
	}
	
	
	public boolean isFiltroTabla() {
		return filtroTabla;
	}

	public void setFiltroTabla(boolean filtroTabla) {
		this.filtroTabla = filtroTabla;
	}
	
}
