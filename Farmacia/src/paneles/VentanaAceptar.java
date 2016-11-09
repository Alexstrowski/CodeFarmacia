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

import listas.ListaMedicamento;
import listas.ListaVenta;
import listas.NodoMedicamento;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.SwingConstants;
import java.awt.Color;

public class VentanaAceptar extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private DefaultTableModel dtm;	
	private JComboBox comboFiltro;
	private TableRowSorter trsFiltro;
	private JTextField tfBuscar;
	private JTextField textField;
	private ListaMedicamento listaM = null;
	private ListaVenta listaV = null;


	public VentanaAceptar(ListaMedicamento listaM,ListaVenta listaV) {
		
		this.listaM=listaM;
		this.listaV=listaV;
		
		setBounds(100, 100, 663, 426);
		getContentPane().setLayout(null);
		contentPanel.setBounds(0, 0, 0, 0);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);
		
		JLabel lblBuscar = new JLabel("Buscar :");
		lblBuscar.setBounds(194, 29, 46, 14);
		getContentPane().add(lblBuscar);
		lblBuscar.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		tfBuscar = new JTextField();
		tfBuscar.setBackground(new Color(204, 255, 255));
		tfBuscar.setBounds(250, 26, 137, 20);
		getContentPane().add(tfBuscar);
		tfBuscar.setColumns(10);
		
		JLabel lblCantidad = new JLabel("Cantidad a vender :");
		lblCantidad.setBounds(194, 54, 109, 14);
		getContentPane().add(lblCantidad);
		lblCantidad.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		textField = new JTextField();
		textField.setBackground(new Color(204, 255, 255));
		textField.setBounds(313, 51, 73, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		table=crearTabla(listaM);
		
		table.setPreferredScrollableViewportSize(new Dimension(500, 70));
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(0, 85, 647, 303);
		getContentPane().add(scrollPane);
	}
	
	private JTable crearTabla(ListaMedicamento lista){
		
		Object[][] data = {};					//array bidimencional de objetos con los datos de la tabla
              
        //array de String's con los tÌtulos de las columnas
        String[] columnNames = {"Código",
        						"Nombre",
                                "Cantidad",
                                "Presentación",                          
                                "P/Venta",            
                                "Subtotal"};
        
     
        dtm= new DefaultTableModel(data, columnNames);	//creamos el Modelo de la tabla con los datos anteriores
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
  
        
        // CENTRADO DE LAS LETRAS //
        
        DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
        tcr.setHorizontalAlignment(SwingConstants.CENTER);
        for(int i=0; i<6 ; i++){
        	tabla.getColumnModel().getColumn(i).setCellRenderer(tcr);
        }
        
        // LLENADO DE LA TABLA //
        
        NodoMedicamento aux = lista.getInicio();
        
        /*while(aux!=null){
        	Object[] nuevaFila={aux.getCodigo(),aux.getNombre(),aux.getLaboratorio(),aux.getCantidad(),aux.getPresentacion(),aux.getFecha(),aux.getPrecio(),aux.getCosto(),aux.getDolencia()};
        	dtm.addRow(nuevaFila);
        	aux=aux.getSiguiente();
        	
        }*/
		
        return tabla;
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
}
