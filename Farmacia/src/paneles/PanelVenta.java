package paneles;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import listas.ListaMedicamento;
import listas.ListaVenta;
import listas.NodoMedicamento;

import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;

public class PanelVenta extends JPanel {
	
	private JTextField tfDinero;
	private JTable table;
	private DefaultTableModel dtm;
	
	private ListaMedicamento listaM;
	private ListaVenta listaV;
	
	public PanelVenta(ListaMedicamento listaM,ListaVenta listaV) {
		
		setLayout(null);
		this.listaM=listaM;
		this.listaV=listaV;
		
		JSeparator s = new JSeparator(SwingConstants.VERTICAL);
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Opciones", Font.BOLD, TitledBorder.TOP, null, null));
		panel.setBounds(10, 11, 412, 120);
		add(panel);
		panel.setLayout(null);
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				botonAgregar(e,listaM,listaV);
			}
		});
		btnAgregar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAgregar.setIcon(new ImageIcon(PanelVenta.class.getResource("/iconos/Plus Math-16.png")));
		btnAgregar.setBounds(10, 26, 112, 23);
		panel.add(btnAgregar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnCancelar.setIcon(new ImageIcon(PanelVenta.class.getResource("/iconos/Delete-16.png")));
		btnCancelar.setBounds(132, 26, 118, 23);
		panel.add(btnCancelar);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnModificar.setIcon(new ImageIcon(PanelVenta.class.getResource("/iconos/Edit-16.png")));
		btnModificar.setBounds(10, 61, 112, 23);
		panel.add(btnModificar);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnGuardar.setIcon(new ImageIcon(PanelVenta.class.getResource("/iconos/Save Close-16.png")));
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnGuardar.setBounds(132, 60, 118, 23);
		panel.add(btnGuardar);
		
		
		panel.add(s);
		
		JLabel lblSuCambioEs = new JLabel("Su cambio es :");
		lblSuCambioEs.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblSuCambioEs.setForeground(new Color(0, 0, 204));
		lblSuCambioEs.setBounds(295, 26, 89, 14);
		panel.add(lblSuCambioEs);
		
		tfDinero = new JTextField();
		tfDinero.setBackground(new Color(253, 245, 230));
		tfDinero.setBounds(295, 62, 86, 20);
		panel.add(tfDinero);
		tfDinero.setColumns(10);
		
		JLabel lblCambio = new JLabel("0");
		lblCambio.setHorizontalAlignment(SwingConstants.CENTER);
		lblCambio.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCambio.setForeground(Color.RED);
		lblCambio.setBounds(316, 42, 46, 14);
		panel.add(lblCambio);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Detalle", Font.BOLD, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(432, 11, 255, 120);
		add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblSubtotal = new JLabel("Subtotal   :");
		lblSubtotal.setForeground(new Color(0, 204, 153));
		lblSubtotal.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblSubtotal.setBounds(10, 31, 74, 14);
		panel_1.add(lblSubtotal);
		
		JLabel lblDescuento = new JLabel("Descuento   :");
		lblDescuento.setForeground(new Color(0, 204, 51));
		lblDescuento.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDescuento.setBounds(10, 56, 74, 14);
		panel_1.add(lblDescuento);
		
		JLabel lblTotalAPagar = new JLabel("Total a pagar   :");
		lblTotalAPagar.setForeground(Color.RED);
		lblTotalAPagar.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTotalAPagar.setBounds(10, 81, 94, 14);
		panel_1.add(lblTotalAPagar);
		
		JLabel lblnumSubTotal = new JLabel("0");
		lblnumSubTotal.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblnumSubTotal.setForeground(new Color(0, 204, 153));
		lblnumSubTotal.setBounds(114, 31, 46, 14);
		panel_1.add(lblnumSubTotal);
		
		JLabel lblnumDescuento = new JLabel("0");
		lblnumDescuento.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblnumDescuento.setForeground(new Color(0, 204, 102));
		lblnumDescuento.setBounds(114, 56, 46, 14);
		panel_1.add(lblnumDescuento);
		
		JLabel lblnumTotal = new JLabel("0");
		lblnumTotal.setForeground(Color.RED);
		lblnumTotal.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblnumTotal.setBounds(114, 81, 46, 14);
		panel_1.add(lblnumTotal);
		
		
		table=crearTabla();
		
		table.setPreferredScrollableViewportSize(new Dimension(500, 70));
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 142, 677, 331);
		add(scrollPane);
		

	}
	
	private JTable crearTabla(){
		
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
        tabla.setBackground(Color.GRAY);
        tabla.setForeground(Color.GRAY);
        tabla.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        tabla.setMinimumSize(new Dimension(119, 0));
        
        // DIMENSION A LAS COLUMNAS //
        
        tabla.getColumnModel().getColumn(0).setPreferredWidth(50);    // CODIGO
        tabla.getColumnModel().getColumn(1).setPreferredWidth(200);	  // NOMBRE
        tabla.getColumnModel().getColumn(2).setPreferredWidth(50);   // CANTIDAD
        tabla.getColumnModel().getColumn(3).setPreferredWidth(100);	  // CANTIDAD
        tabla.getColumnModel().getColumn(4).setPreferredWidth(160);	  // PRESENTACION
        tabla.getColumnModel().getColumn(5).setPreferredWidth(160);   // FECHA DE CADUCIDAD*/

        
        // CENTRADO DE LAS LETRAS //
        
        DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
        tcr.setHorizontalAlignment(SwingConstants.CENTER);
        for(int i=0; i<6 ; i++){
        	tabla.getColumnModel().getColumn(i).setCellRenderer(tcr);
        }
        
        // LLENADO DE LA TABLA //
        
        /*NodoMedicamento aux = lista.getInicio();
        
        while(aux!=null){
        	Object[] nuevaFila={aux.getCodigo(),aux.getNombre(),aux.getLaboratorio(),aux.getCantidad(),aux.getPresentacion(),aux.getFecha(),aux.getPrecio(),aux.getCosto(),aux.getDolencia()};
        	dtm.addRow(nuevaFila);
        	aux=aux.getSiguiente();
        	
        }*/
		
        return tabla;
	}
	
	public void botonAgregar(ActionEvent e,ListaMedicamento listaM,ListaVenta listaV){
		
		VentanaAceptar va = new VentanaAceptar(listaM,listaV);
		va.setVisible(true);
	}
}
