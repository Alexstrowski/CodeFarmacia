package paneles;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import com.toedter.calendar.JDateChooser;

import farmacia.CargarArchivo;
import farmacia.EscribirArchivo;
import farmacia.Validacion;
import farmacia.ValidarCampo;
import farmacia.VentanaMenu;
import listas.ListaLaboratorio;
import listas.ListaMedicamento;
import listas.ListaPresentacion;
import listas.NodoMedicamento;

public class PanelMedicamentos extends JPanel {

	private JTextField tfNombre;
	private JTextField tfCantidad;
	private JTextField tfPrecio;
	private JTextField tfBuscar;
	private JTextField tfDolencia;
	private JTextField tfCosto;
	private JDateChooser tfFecha;
	private JTable table;
	private DefaultTableModel dtm;	
	private JComboBox comboFiltro;
	private TableRowSorter trsFiltro;
	private JComboBox tfLab;
	private JComboBox tfPresentacion;
	
	ListaMedicamento listaM = new ListaMedicamento();
	ListaLaboratorio listaL = new ListaLaboratorio();
	ListaPresentacion listaP = new ListaPresentacion();
	

	public PanelMedicamentos(ListaMedicamento listaM,ListaLaboratorio listaL,ListaPresentacion listaP) {
		setLayout(null);
		this.listaM = listaM;
		this.listaL = listaL;
		this.listaP = listaP;
	
		
		JPanel panelDatosMedicamento = new JPanel();
		panelDatosMedicamento.setLayout(null);
		panelDatosMedicamento.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Medicamento", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelDatosMedicamento.setBounds(10, 11, 561, 185);
		add(panelDatosMedicamento);
		
		
		JLabel lblNombre = new JLabel("Nombre :");
		lblNombre.setFont(new Font("Segoe UI Semilight", Font.BOLD, 12));
		lblNombre.setBounds(10, 26, 64, 14);
		panelDatosMedicamento.add(lblNombre);
		
		JLabel lblLabo = new JLabel("Laboratorio :");
		lblLabo.setFont(new Font("Segoe UI Semilight", Font.BOLD, 12));
		lblLabo.setBounds(10, 61, 83, 14);
		panelDatosMedicamento.add(lblLabo);
		
		JLabel lblCantidad = new JLabel("Cantidad :");
		lblCantidad.setFont(new Font("Segoe UI Semilight", Font.BOLD, 12));
		lblCantidad.setBounds(10, 93, 64, 14);
		panelDatosMedicamento.add(lblCantidad);
		
		JLabel lblPrecioVenta = new JLabel("Precio de venta :");
		lblPrecioVenta.setFont(new Font("Segoe UI Semilight", Font.BOLD, 12));
		lblPrecioVenta.setBounds(239, 61, 113, 14);
		panelDatosMedicamento.add(lblPrecioVenta);
		
		tfNombre = new JTextField();
		tfNombre.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				Validacion.validarLetra(e);
			}
		});
		tfNombre.setColumns(10);
		tfNombre.setBounds(103, 23, 113, 20);
		panelDatosMedicamento.add(tfNombre);
		
		tfCantidad = new JTextField();
		tfCantidad.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				Validacion.validarNumero(e);
			}
		});
		tfCantidad.setColumns(10);
		tfCantidad.setBounds(103, 93, 113, 20);
		panelDatosMedicamento.add(tfCantidad);
		
		tfPrecio = new JTextField();
		tfPrecio.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				Validacion.validarNumeroYPunto(e);
			}
		});
		tfPrecio.setColumns(10);
		tfPrecio.setBounds(372, 58, 113, 20);
		panelDatosMedicamento.add(tfPrecio);
		
		JLabel lblFecha = new JLabel("Fecha de caducidad :");
		lblFecha.setFont(new Font("Segoe UI Semilight", Font.BOLD, 12));
		lblFecha.setBounds(239, 26, 133, 14);
		panelDatosMedicamento.add(lblFecha);
		
		JLabel lblPresentacion = new JLabel("Presentaci\u00F3n :");
		lblPresentacion.setFont(new Font("Segoe UI Semilight", Font.BOLD, 12));
		lblPresentacion.setBounds(10, 128, 95, 14);
		panelDatosMedicamento.add(lblPresentacion);
		
		JLabel lblDolencia = new JLabel("Dolencia :");
		lblDolencia.setFont(new Font("Segoe UI Semilight", Font.BOLD, 12));
		lblDolencia.setBounds(239, 131, 83, 14);
		panelDatosMedicamento.add(lblDolencia);
		
		tfDolencia = new JTextField();
		tfDolencia.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				Validacion.validarLetra(e);
			}
		});
		tfDolencia.setColumns(10);
		tfDolencia.setBounds(372, 125, 113, 20);
		panelDatosMedicamento.add(tfDolencia);
		
		JLabel lblPreciodeCompra = new JLabel("Precio de compra :");
		lblPreciodeCompra.setFont(new Font("Segoe UI Semilight", Font.BOLD, 12));
		lblPreciodeCompra.setBounds(239, 96, 133, 14);
		panelDatosMedicamento.add(lblPreciodeCompra);
		
		tfCosto = new JTextField();
		tfCosto.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				Validacion.validarNumeroYPunto(e);
			}
		});
		tfCosto.setColumns(10);
		tfCosto.setBounds(372, 90, 113, 20);
		panelDatosMedicamento.add(tfCosto);
		
		tfFecha = new JDateChooser();
		tfFecha.setDateFormatString("dd/MMM/yyyy");
		tfFecha.setBounds(372, 20, 113, 20);
		panelDatosMedicamento.add(tfFecha);
		
		tfLab = new JComboBox();
		cargarComboBoxLab(listaL);
		tfLab.setBounds(103, 58, 113, 20);
		panelDatosMedicamento.add(tfLab);
		
		tfPresentacion = new JComboBox();
		cargarComboBoxPresentacion(listaP);
		tfPresentacion.setBounds(103, 126, 113, 20);
		panelDatosMedicamento.add(tfPresentacion);
		
		JLabel lblBuscar = new JLabel("Buscar :");
		lblBuscar.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblBuscar.setBounds(21, 207, 46, 14);
		add(lblBuscar);
		
		tfBuscar = new JTextField();
		tfBuscar.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				txtFiltroKeyTyped(e);
			}
		});

		tfBuscar.setBackground(new Color(224, 255, 255));
		tfBuscar.setColumns(10);
		tfBuscar.setBounds(249, 204, 322, 20);
		add(tfBuscar);
		
		JButton btnEliminar = new JButton((String) null);
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(table.getSelectedRow()>-1){
					botonEliminar(e);
				}else{
					JOptionPane.showMessageDialog(null,"Debe seleccionar una fila primero","WARNING_MESSAGE",JOptionPane.WARNING_MESSAGE);
				}
					
			}
		});
	
		btnEliminar.setIcon(new ImageIcon(VentanaMenu.class.getResource("/iconos/Delete-32.png")));

		btnEliminar.setBounds(586, 104, 89, 44);
		add(btnEliminar);
		
		JButton btnEditar = new JButton("");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(table.getSelectedRow()>-1){
					botonEditar(e);
				}else{
					JOptionPane.showMessageDialog(null,"Debe seleccionar una fila primero","WARNING_MESSAGE",JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		btnEditar.setIcon(new ImageIcon(VentanaMenu.class.getResource("/iconos/Edit File Filled-32.png")));
		btnEditar.setBounds(586, 177, 89, 44);
		add(btnEditar);
		
		JButton btnAgregar = new JButton("");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				botonAgregar(e);
			}
		});
		btnAgregar.setIcon(new ImageIcon(VentanaMenu.class.getResource("/iconos/Plus-32.png")));
		btnAgregar.setBounds(586, 27, 89, 44);
		add(btnAgregar);
		
		comboFiltro = new JComboBox();
		comboFiltro.setModel(new DefaultComboBoxModel(new String[] {"Código", "Nombre", "Laboratorio"}));
		comboFiltro.setBounds(111, 204, 108, 20);
		add(comboFiltro);
		
		JLabel label_8 = new JLabel("Agregar");
		label_8.setHorizontalAlignment(SwingConstants.CENTER);
		label_8.setForeground(new Color(34, 139, 34));
		label_8.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_8.setBounds(586, 11, 89, 14);
		add(label_8);
		
		JLabel label_9 = new JLabel("Eliminar");
		label_9.setHorizontalAlignment(SwingConstants.CENTER);
		label_9.setForeground(Color.RED);
		label_9.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_9.setBounds(586, 88, 89, 14);
		add(label_9);
		
		JLabel label_10 = new JLabel("Editar");
		label_10.setHorizontalAlignment(SwingConstants.CENTER);
		label_10.setForeground(new Color(255, 153, 0));
		label_10.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_10.setBounds(586, 161, 89, 14);
		add(label_10);
		
		cargarArchivo(listaM);
		
		table=crearTabla(listaM);
		
		
		table.setPreferredScrollableViewportSize(new Dimension(500, 70));
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 241, 677, 232);
		add(scrollPane);
		
	}

	private JTable crearTabla(ListaMedicamento lista){
		
		Object[][] data = {};					//array bidimencional de objetos con los datos de la tabla
              
        //array de String's con los tÌtulos de las columnas
        String[] columnNames = {"Código",
        						"Nombre",
                                "Laboratorio",
                                "Cantidad",
                                "Presentación",
                                "Fecha caducidad",
                                "P/Venta",
                                "P/Compra",
                                "Dolencia"};
        
     
        dtm= new DefaultTableModel(data, columnNames){
        	
        	public boolean isCellEditable(int row, int column) {
				return false;
        	}
        	
        };	//creamos el Modelo de la tabla con los datos anteriores
        JTable tabla = new JTable(dtm);	 	//se crea la Tabla con el modelo DefaultTableModel
        tabla.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        tabla.setMinimumSize(new Dimension(119, 0));
        

        // Instanciamos el TableRowSorter y lo añadimos al JTable

        tabla.getTableHeader().setReorderingAllowed(false); 
        
        // DIMENSION A LAS COLUMNAS //
        
        tabla.getColumnModel().getColumn(0).setPreferredWidth(50);    // CODIGO
        tabla.getColumnModel().getColumn(1).setPreferredWidth(200);	  // NOMBRE
        tabla.getColumnModel().getColumn(2).setPreferredWidth(150);   // LABORATORIO
        tabla.getColumnModel().getColumn(3).setPreferredWidth(60);	  // CANTIDAD
        tabla.getColumnModel().getColumn(4).setPreferredWidth(160);	  // PRESENTACION
        tabla.getColumnModel().getColumn(5).setPreferredWidth(160);   // FECHA DE CADUCIDAD
        tabla.getColumnModel().getColumn(6).setPreferredWidth(70);    // P.VENTA
        tabla.getColumnModel().getColumn(7).setPreferredWidth(70);    // P.COMPRA
        tabla.getColumnModel().getColumn(8).setPreferredWidth(160);   // DOLENCIA
        
        // CENTRADO DE LAS LETRAS //
        
        DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
        tcr.setHorizontalAlignment(SwingConstants.CENTER);
        for(int i=0; i<9 ; i++){
        	tabla.getColumnModel().getColumn(i).setCellRenderer(tcr);
        }
        
        // LLENADO DE LA TABLA //
        
        
        NodoMedicamento aux = lista.getInicio();
        
        while(aux!=null){
        	Object[] nuevaFila={aux.getCodigo(),aux.getNombre(),aux.getLaboratorio(),aux.getCantidad(),aux.getPresentacion(),aux.getFecha(),aux.getPrecio(),aux.getCosto(),aux.getDolencia()};
        	dtm.addRow(nuevaFila);
        	aux=aux.getSiguiente();
        	
        }
        
        
      
		
        return tabla;
	}
	
	
	
	
	private void botonAgregar(java.awt.event.ActionEvent evt){
		
		
		ValidarCampo vc = new ValidarCampo();
		
		if(vc.validarNombre(tfNombre) && vc.validarCantidad(tfCantidad) && vc.validarFecha(tfFecha) && vc.validarVenta(tfPrecio) && vc.validarCompra(tfCosto) && vc.validarDolencia(tfDolencia)){
		
			int codigo = listaM.dimension()+1;
			String nombre = tfNombre.getText();
			String laboratorio = tfLab.getSelectedItem().toString();
			int cantidad = Integer.parseInt(tfCantidad.getText());
			String presentacion = tfPresentacion.getSelectedItem().toString();
			
			String formato = "dd/MMM/yyyy";
			Date date = tfFecha.getDate();
			SimpleDateFormat sdf = new SimpleDateFormat(formato);
			String fecha = sdf.format(date);
			
			double precio = Double.parseDouble(tfPrecio.getText());
			double costo = Double.parseDouble(tfCosto.getText());
			String dolencia = tfDolencia.getText();
	
			if(listaM.verificarRepetido(nombre, laboratorio, presentacion)){
				
				JOptionPane.showMessageDialog(null, "¡ El elemento ya está en la lista !","Error",JOptionPane.ERROR_MESSAGE);
			}else{
				
				listaM.insertarFinal(codigo,nombre, laboratorio, cantidad, presentacion, fecha, precio,costo,dolencia);
				
				Object[] newRow={codigo,nombre,laboratorio,cantidad,presentacion,fecha,precio,costo,dolencia};
				dtm.addRow(newRow);
				
				escribirArchivo(listaM);
				
				tfNombre.setText("");
				tfFecha.setCalendar(null);
				tfCantidad.setText("");
				tfPrecio.setText("");
				tfCosto.setText("");
				tfDolencia.setText("");
				
				JOptionPane.showMessageDialog(null, "AGREGADO");	
			}
				
		}
						
	}
	
	private void botonEliminar(java.awt.event.ActionEvent evt){
		
		
		int ax = JOptionPane.showConfirmDialog(null, "¿ Está seguro de eliminar el medicamento ?");
        if(ax == JOptionPane.YES_OPTION){
        	DefaultTableModel model = (DefaultTableModel)table.getModel();
    		int fila = table.getSelectedRow()+1;
    		listaM.eliminar(fila);
    		model.removeRow(table.getSelectedRow()); 
    		
    		
    		limpiarTable();
    		// LLENADO DE LA TABLA //
            actualizarTabla();
            
            JOptionPane.showMessageDialog(null, "¡ Medicamento eliminado !");
        }
		
		
	
	}
	
	
	private void botonEditar(java.awt.event.ActionEvent evt){
		
		DefaultTableModel model = (DefaultTableModel)table.getModel();
		int fila = table.getSelectedRow()+1;
		
		NodoMedicamento aux=null;
		aux=listaM.buscarNodo(fila);
		
		EditarMedicamento em = new EditarMedicamento(aux,listaM,listaL,listaP,fila,dtm);
		em.setVisible(true);
		
		
	}
	
	
	
	public void escribirArchivo(ListaMedicamento lista){   
			
        EscribirArchivo.escribirArchivoMedicamentos(lista);
        
    }
	
	
	public void cargarArchivo(ListaMedicamento lista){
			
		CargarArchivo.cargarArchivoExcel(lista);
			
	}
	
	public void cargarArchivo(ListaLaboratorio lista){
		
		CargarArchivo.cargarArchivoLaboratorios(lista);
			
	}
	
	
	public void filtro() {
        int columnaABuscar = 0;
        
        if (comboFiltro.getSelectedItem().toString() == "Código") {
            columnaABuscar = 0;
            
        }
        if (comboFiltro.getSelectedItem().toString() == "Nombre") {
            columnaABuscar = 1;
            
        }
        if (comboFiltro.getSelectedItem().toString() == "Laboratorio") {
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
		
		
		trsFiltro = new TableRowSorter(table.getModel());
		table.setRowSorter(trsFiltro);
    }
	
	private void cargarComboBoxLab(ListaLaboratorio listaL){
		
		String arreglo[]=listaL.retornarArregloLab();
		
		for(int i=0;i<arreglo.length;i++){
			tfLab.addItem(arreglo[i]);
		}
	}
	
	public void obtenerListaLabo(ListaLaboratorio listaL){
		this.listaL=listaL;
		
		tfLab.removeAllItems();
		
		String arreglo[]=listaL.retornarArregloLab();
		
		for(int i=0;i<arreglo.length;i++){
			tfLab.addItem(arreglo[i]);
		}
	}
	
	private void cargarComboBoxPresentacion(ListaPresentacion listaP){
		
		String arreglo[]=listaP.retornarArregloPre();
		
		for(int i=0;i<arreglo.length;i++){
			tfPresentacion.addItem(arreglo[i]);
		}
	}
	
	public void obtenerListaPresentacion(ListaPresentacion listaP){
		this.listaP=listaP;
		
		tfPresentacion.removeAllItems();
		
		String arreglo[]=listaP.retornarArregloPre();
		
		for(int i=0;i<arreglo.length;i++){
			tfPresentacion.addItem(arreglo[i]);
		}
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
    	
    	NodoMedicamento aux = listaM.getInicio();
    	int i = 1;
        
        while(aux!=null){
        	
        	aux.setCodigo(i);
        	Object[] nuevaFila={aux.getCodigo(),aux.getNombre(),aux.getLaboratorio(),aux.getCantidad(),aux.getPresentacion(),aux.getFecha(),aux.getPrecio(),aux.getCosto(),aux.getDolencia()};
        	dtm.addRow(nuevaFila);
        	aux=aux.getSiguiente();
        	
        	i++;
        }
        
        escribirArchivo(listaM);
    }
}
	


