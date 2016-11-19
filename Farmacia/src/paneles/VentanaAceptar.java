package paneles;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import farmacia.Validacion;
import listas.ListaMedicamento;
import listas.ListaVenta;
import listas.NodoMedicamento;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaAceptar extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private DefaultTableModel dtm;	
	private JComboBox comboFiltro;
	private TableRowSorter trsFiltro;
	private JTextField tfBuscar;
	private JTextField tfCantidad;
	private ListaMedicamento listaM = null;
	private ListaVenta listaV = null;
	
	private NodoMedicamento aux;
	private int cantidad;
	private boolean filtroTabla=false;


	public VentanaAceptar(ListaMedicamento listaM,ListaVenta listaV) {
		
		this.listaM=listaM;
		this.listaV=listaV;
		
		setTitle("Agregar venta");
		setBounds(100, 100, 663, 426);
		getContentPane().setLayout(null);
		contentPanel.setBounds(0, 0, 0, 0);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);
		
		JLabel lblBuscar = new JLabel("Buscar :");
		lblBuscar.setBounds(158, 29, 46, 14);
		getContentPane().add(lblBuscar);
		lblBuscar.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		comboFiltro = new JComboBox();
		comboFiltro.setModel(new DefaultComboBoxModel(new String[] {"Nombre", "Dolencia"}));
		comboFiltro.setBounds(214, 26, 73, 20);
		getContentPane().add(comboFiltro);
		
		tfBuscar = new JTextField();
		tfBuscar.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				Validacion.validarLetra(e);
				txtFiltroKeyTyped(e);
			}
			
						
		});
		tfBuscar.setBackground(new Color(204, 255, 255));
		tfBuscar.setBounds(297, 26, 137, 20);
		getContentPane().add(tfBuscar);
		tfBuscar.setColumns(10);
		
		JLabel lblCantidad = new JLabel("Cantidad a vender :");
		lblCantidad.setBounds(158, 54, 109, 14);
		getContentPane().add(lblCantidad);
		lblCantidad.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		tfCantidad = new JTextField();
		tfCantidad.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				Validacion.validarNumero(e);
			}
		});
		tfCantidad.setBackground(new Color(204, 255, 255));
		tfCantidad.setBounds(297, 51, 137, 20);
		getContentPane().add(tfCantidad);
		tfCantidad.setColumns(10);
		
		table=crearTabla(listaM);
		
		table.setPreferredScrollableViewportSize(new Dimension(500, 70));
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(0, 85, 647, 303);
		getContentPane().add(scrollPane);
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				botonAgregar(e);
			}
		});
		btnAgregar.setBounds(488, 25, 89, 23);
		getContentPane().add(btnAgregar);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(VentanaAceptar.class.getResource("/iconos/Search-16.png")));
		label.setBounds(132, 29, 16, 14);
		getContentPane().add(label);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(VentanaAceptar.class.getResource("/iconos/Sell Stock-16.png")));
		label_1.setBounds(132, 54, 16, 14);
		getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("");
		label_2.setBounds(0, 0, 637, 85);
		getContentPane().add(label_2);
		
	}
	
	private JTable crearTabla(ListaMedicamento lista){
		
		Object[][] data = {};					//array bidimencional de objetos con los datos de la tabla
              
        //array de String's con los tÌtulos de las columnas
        String[] columnNames = {"Código",
        						"Nombre",
                                "Cantidad",
                                "Presentación",                          
                                "P/Venta",            
                                "Fecha Vencimiento",
                                "Dolencia"};
        
     
        dtm= new DefaultTableModel(data, columnNames){
        	
        	public boolean isCellEditable(int row, int column) {
				return false;
        	}
        	
        };	//creamos el Modelo de la tabla con los datos anteriores y no editable 
        
        JTable tabla = new JTable(dtm);	 	//se crea la Tabla con el modelo DefaultTableModel
        tabla.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        tabla.setMinimumSize(new Dimension(119, 0));
        
        
        tabla.getTableHeader().setReorderingAllowed(false); // COLUMNAS FIJAS
        
        // DIMENSION A LAS COLUMNAS //
        
        tabla.getColumnModel().getColumn(0).setPreferredWidth(50);    // CODIGO
        tabla.getColumnModel().getColumn(1).setPreferredWidth(200);	  // NOMBRE
        tabla.getColumnModel().getColumn(2).setPreferredWidth(60);    // CANTIDAD
        tabla.getColumnModel().getColumn(3).setPreferredWidth(200);	  // PRESENTACION
        tabla.getColumnModel().getColumn(4).setPreferredWidth(60);	  // P/VENTA
        tabla.getColumnModel().getColumn(5).setPreferredWidth(160);   // FECHA DE CADUCIDAD
        tabla.getColumnModel().getColumn(6).setPreferredWidth(160);   // FECHA DE CADUCIDAD
  
        
        // CENTRADO DE LAS LETRAS //
        
        DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
        tcr.setHorizontalAlignment(SwingConstants.CENTER);
        for(int i=0; i<6 ; i++){
        	tabla.getColumnModel().getColumn(i).setCellRenderer(tcr);
        }
        
        // LLENADO DE LA TABLA //
        
        NodoMedicamento aux = lista.getInicio();
        
        while(aux!=null){
        	Object[] nuevaFila={aux.getCodigo(),aux.getNombre(),aux.getCantidad(),aux.getPresentacion(),aux.getPrecio(),aux.getFecha(),aux.getDolencia()};
        	dtm.addRow(nuevaFila);
        	aux=aux.getSiguiente();
        	
        }
		
        return tabla;
	}
	
	public void filtro() {
        int columnaABuscar = 1;
        
        if (comboFiltro.getSelectedItem().toString() == "Nombre") {
            columnaABuscar = 1;
            
        }
        if (comboFiltro.getSelectedItem().toString() == "Dolencia") {
            columnaABuscar = 6;
            
        }
        
        trsFiltro.setRowFilter(RowFilter.regexFilter("(?i)"+tfBuscar.getText(), columnaABuscar));
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
	
	public void botonAgregar(ActionEvent e){
		
		try{
			int fila;
			int modelIndex = 0;
			
			fila = table.getSelectedRow();
			
			if(filtroTabla){
				
				modelIndex = table.convertRowIndexToModel(fila);
				modelIndex++;
				setAux(listaM.buscarNodo(modelIndex));
				setFiltroTabla(false);
			}else{
				int indiceTablaOrdenada = table.convertRowIndexToView(fila);
				indiceTablaOrdenada++;
				setAux(listaM.buscarNodo(indiceTablaOrdenada));
			}
				
			
			setCantidad(Integer.parseInt(tfCantidad.getText()));
			dispose();
		}catch(Exception ex){
			
				JOptionPane.showMessageDialog(null, " ¡ Seleccione una fila e ingrese la cantidad !", "ERROR", JOptionPane.WARNING_MESSAGE);
		
			
			
		}
		
	}
	
	public NodoMedicamento getAux() {
		return aux;
	}

	public void setAux(NodoMedicamento aux) {
		this.aux = aux;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
	public boolean isFiltroTabla() {
		return filtroTabla;
	}

	public void setFiltroTabla(boolean filtroTabla) {
		this.filtroTabla = filtroTabla;
	}
}
