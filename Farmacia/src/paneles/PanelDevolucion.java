package paneles;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import listas.ListaDevolucion;
import listas.ListaLaboratorio;
import listas.ListaMedicamento;
import listas.ListaPresentacion;
import listas.NodoDevolucion;
import listas.NodoMedicamento;
import farmacia.CargarArchivo;
import farmacia.EscribirArchivo;
import farmacia.Validacion;
import farmacia.ValidarCampo;
import farmacia.VentanaMenu;

import javax.swing.DefaultComboBoxModel;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class PanelDevolucion extends JPanel {
	
	private JTextField tfCantidad;
	private JComboBox tfRazon;
	private JComboBox tfCodigo;
	private JLabel tfNombre;
	private JLabel tfPresentacion;
	private JLabel tfLaboratorio;
	private JLabel tfPrecio;
	
	private JTable table;
	private DefaultTableModel dtm;	
	
	ListaMedicamento listaM = new ListaMedicamento();
	ListaDevolucion listaD = new ListaDevolucion();
	ListaLaboratorio listaL = new ListaLaboratorio();
	ListaPresentacion listaP = new ListaPresentacion();
	
	public PanelDevolucion(ListaLaboratorio listaL,ListaPresentacion listaP, ListaMedicamento listaM) {
		setLayout(null);
		NodoMedicamento nodoM=null;
		this.listaL = listaL;
		this.listaP = listaP;
		this.listaM = listaM;

		JPanel DatosMedi = new JPanel();
		DatosMedi.setLayout(null);
		DatosMedi.setBorder(new TitledBorder(UIManager.getBorder("TitledBorde.border"), "Medicamento", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		DatosMedi.setBounds(10,11,561,174);
		add(DatosMedi);
		
		JLabel lblCdigo = new JLabel("C\u00F3digo");
		lblCdigo.setBounds(10, 30, 46, 14);
		DatosMedi.add(lblCdigo);
		
		tfCodigo = new JComboBox();
		cargarComboBoxCodigo(listaM);
		tfCodigo.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
			          int index =  tfCodigo.getSelectedIndex();
			          index++;
			          elementoCambiado(index);
			       }
			}
		});

		
		tfCodigo.setBounds(80, 27, 62, 20);
		DatosMedi.add(tfCodigo);
		
		JLabel lblNombre= new JLabel("Nombre :");
		lblNombre.setFont(new Font("Segoe UI Semilight", Font.BOLD, 12));
		lblNombre.setBounds(10,61,64,14);
		DatosMedi.add(lblNombre);
		
		JLabel lblCantidad = new JLabel("Cantidad :");
		lblCantidad.setFont(new Font("Segoe UI Semilight", Font.BOLD, 12));
		lblCantidad.setBounds(10, 91, 64, 14);
		DatosMedi.add(lblCantidad);
		
		JLabel lblPrecio = new JLabel("Precio :");
		lblPrecio.setFont(new Font("Segoe UI Semilight", Font.BOLD, 12));
		lblPrecio.setBounds(239, 61, 113, 14);
		DatosMedi.add(lblPrecio);
		
		JLabel lblRazn = new JLabel("Raz\u00F3n:");
		lblRazn.setFont(new Font("Segoe UI Semilight", Font.BOLD, 12));
		lblRazn.setBounds(239, 91, 46, 14);
		DatosMedi.add(lblRazn);
		
		JLabel lblLaboratorio =new JLabel("Laboratorio :" );
		lblLaboratorio.setFont(new Font("Segoe UI Semilight", Font.BOLD, 12));
		lblLaboratorio.setBounds(10, 121, 113, 14);
		DatosMedi.add(lblLaboratorio);
		
		JLabel lblPresentacion =new JLabel("Presentacion :" );
		lblPresentacion.setFont(new Font("Segoe UI Semilight", Font.BOLD, 12));
		lblPresentacion.setBounds(239, 121, 113, 14);
		DatosMedi.add(lblPresentacion);
		
		JLabel label_8 = new JLabel("Agregar");
		label_8.setHorizontalAlignment(SwingConstants.CENTER);
		label_8.setForeground(new Color(34, 139, 34));
		label_8.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_8.setBounds(586, 11, 89, 14);
		add(label_8);
		
		nodoM=listaM.buscarNodo(Integer.parseInt(tfCodigo.getSelectedItem().toString()));
		
		//if(nodoM!=null){
			tfNombre = new JLabel();
			tfNombre.setBounds(103, 60, 113, 20);
			DatosMedi.add(tfNombre);
			
			tfLaboratorio = new JLabel();
			tfLaboratorio.setBounds(103, 120, 113, 20);
			DatosMedi.add(tfLaboratorio);
			
			tfPresentacion = new JLabel();
			tfPresentacion.setBounds(372, 120, 113, 20);
			DatosMedi.add(tfPresentacion);
			
			tfCantidad = new JTextField();
			tfCantidad.addKeyListener(new KeyAdapter() {
				public void keyTyped(KeyEvent e) {
					Validacion.validarNumero(e);
				}
			});
			tfCantidad.setColumns(10);
			tfCantidad.setBounds(103, 90, 113, 20);
			DatosMedi.add(tfCantidad);
			
			tfPrecio = new JLabel();
			tfPrecio.addKeyListener(new KeyAdapter() {
				public void keyTyped(KeyEvent e) {
					Validacion.validarNumeroYPunto(e);
				}
			});
			tfPrecio.setBounds(372, 58, 113, 20);
			DatosMedi.add(tfPrecio);
			
			tfRazon = new JComboBox();
			tfRazon.setModel(new DefaultComboBoxModel(new String[] {"Medicamento equivocado", "Mal estado", "Vencido"}));
			tfRazon.setBounds(372, 90, 113, 20);
			DatosMedi.add(tfRazon);
		
		
		JButton btnAgregar = new JButton("");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				botonAgregar(e);
			}
		});
		btnAgregar.setIcon(new ImageIcon(VentanaMenu.class.getResource("/iconos/Plus-32.png")));
		btnAgregar.setBounds(586, 27, 89, 44);
		add(btnAgregar);
		
		cargarArchivo(listaD);
		
		table=crearTabla(listaD);
		
		
		table.setPreferredScrollableViewportSize(new Dimension(500, 70));
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 241, 677, 232);
		add(scrollPane);
	}
	
	private JTable crearTabla(ListaDevolucion lista){
		
		Object[][] data = {};					//array bidimencional de objetos con los datos de la tabla
              
        //array de String's con los tÌtulos de las columnas
        String[] columnNames = {"Código",
        						"Nombre",
        						"Laboratorio",
                                "Cantidad",
                                "Presentación",
                                "P/Venta",
                                "Razon"};
        
     
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
        tabla.getColumnModel().getColumn(2).setPreferredWidth(200);	  // LABORATORIO
        tabla.getColumnModel().getColumn(3).setPreferredWidth(150);   // CANTIDAD
        tabla.getColumnModel().getColumn(4).setPreferredWidth(200);	  // PRESENTACION
        tabla.getColumnModel().getColumn(5).setPreferredWidth(150);	  // P.VENTA
        tabla.getColumnModel().getColumn(6).setPreferredWidth(200);   // RAZON
        
        // CENTRADO DE LAS LETRAS //
        
        DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
        tcr.setHorizontalAlignment(SwingConstants.CENTER);
        for(int i=0; i<7 ; i++){
        	tabla.getColumnModel().getColumn(i).setCellRenderer(tcr);
        }
        
        // LLENADO DE LA TABLA //
        
        
        NodoDevolucion aux = lista.getInicio();
        
        while(aux!=null){
        	Object[] nuevaFila={aux.getCodigo(),aux.getNombre(),aux.getLaboratorio(),aux.getCantidad(),aux.getPresentacion(),aux.getPrecio(),aux.getRazon()};
        	dtm.addRow(nuevaFila);
        	aux=aux.getSiguiente();
        	
        }
        
        return tabla;
	}
	
	private void botonAgregar(java.awt.event.ActionEvent evt){
		
		
		ValidarCampo vc = new ValidarCampo();
		
		if(vc.validarCantidad(tfCantidad)){
		
			int codigo = Integer.parseInt(tfCodigo.getSelectedItem().toString());
			String nombre = tfNombre.getText();
			String laboratorio = tfLaboratorio.getText();
			int cantidad = Integer.parseInt(tfCantidad.getText());
			String presentacion = tfPresentacion.getText();
			double precio = Double.parseDouble(tfPrecio.getText());
			String razon = tfRazon.getSelectedItem().toString();
	
			if(listaM.buscar(codigo)){
				listaD.insertarFinal(codigo,nombre,laboratorio, cantidad, presentacion, precio,razon);
				
				Object[] newRow={codigo,nombre,laboratorio,cantidad,presentacion,precio,razon};
				dtm.addRow(newRow);
				
				escribirArchivo(listaD);
				
				tfNombre.setText("");
				tfLaboratorio.setText("");
				tfCantidad.setText("");
				tfPrecio.setText("");
				tfPresentacion.setText("");
		
				JOptionPane.showMessageDialog(null, "AGREGADO");
				
			}else{
				JOptionPane.showMessageDialog(null, "¡ El elemento no existe en nuestro formulario de medicamentos !","Error",JOptionPane.ERROR_MESSAGE);
			}
				
		}
						
	}
	
	private void cargarComboBoxCodigo(ListaMedicamento listaM){
		String arreglo[]=listaM.retornarArregloPre();
		for(int i=0;i<arreglo.length;i++){
			tfCodigo.addItem(arreglo[i]);
		}
	}
	
	public void obtenerListaCodigo(ListaMedicamento listaM){
		this.listaM=listaM;
		tfCodigo.removeAllItems();
		
		String arreglo[]=listaM.retornarArregloPre();
		for(int i=0;i<arreglo.length;i++){
			tfCodigo.addItem(arreglo[i]);
		}
	}
	
	public void elementoCambiado(int index) {
 
        NodoMedicamento aux = listaM.buscarNodo(index);
        tfNombre.setText(aux.getNombre());
        tfLaboratorio.setText(aux.getLaboratorio());
        tfPresentacion.setText(aux.getPresentacion());
        tfPrecio.setText(Double.toString(aux.getPrecio()));
	}


	
	public void escribirArchivo(ListaDevolucion lista){   
		
        EscribirArchivo.escribirArchivoDevolucion(lista);
        
    }
	
	
	public void cargarArchivo(ListaDevolucion lista){
			
		CargarArchivo.cargarArchivoDevolucion(lista);
			
	}
}
