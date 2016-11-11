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
import javax.swing.JOptionPane;

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
	
	
	private JLabel lblnumSubTotal;
	private JLabel lblnumDescuento;
	private JLabel lblnumTotal;
	private JLabel lblCambio;
	
	private double sumador=0;
	private double descuento = 0;


	private JTextField tfDinero;
	private JTable table;
	private DefaultTableModel dtm;
	
	private ListaMedicamento listaM;
	private ListaVenta listaV;
	private static int contador=1;
	
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
		
		JButton btnCancelar = new JButton("Eliminar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(table.getSelectedRow()>-1){
					botonEliminar(e);
				}else{
					JOptionPane.showMessageDialog(null,"Debe seleccionar una fila primero","WARNING_MESSAGE",JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnCancelar.setIcon(new ImageIcon(PanelVenta.class.getResource("/iconos/Delete-16.png")));
		btnCancelar.setBounds(132, 26, 118, 23);
		panel.add(btnCancelar);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(table.getSelectedRow()>-1){
					botonModificar(e);
				}else{
					JOptionPane.showMessageDialog(null,"Debe seleccionar una fila primero","WARNING_MESSAGE",JOptionPane.WARNING_MESSAGE);
				}	
			}
		});
		btnModificar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnModificar.setIcon(new ImageIcon(PanelVenta.class.getResource("/iconos/Edit-16.png")));
		btnModificar.setBounds(10, 61, 112, 23);
		panel.add(btnModificar);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnGuardar.setIcon(new ImageIcon(PanelVenta.class.getResource("/iconos/Save Close-16.png")));
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				botonGuardar(e);
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
		tfDinero.setHorizontalAlignment(SwingConstants.CENTER);
		tfDinero.setBackground(new Color(253, 245, 230));
		tfDinero.setBounds(295, 62, 86, 20);
		panel.add(tfDinero);
		tfDinero.setColumns(10);
		
		lblCambio = new JLabel("0");
		lblCambio.setHorizontalAlignment(SwingConstants.CENTER);
		lblCambio.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCambio.setForeground(Color.RED);
		lblCambio.setBounds(316, 42, 46, 14);
		panel.add(lblCambio);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				botonVuelto(e);
			}
		});
		btnNewButton.setIcon(new ImageIcon(PanelVenta.class.getResource("/iconos/Bank-28.png")));
		btnNewButton.setBounds(328, 86, 21, 21);
		panel.add(btnNewButton);
		
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
		
		lblnumSubTotal = new JLabel("0");
		lblnumSubTotal.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblnumSubTotal.setForeground(new Color(0, 204, 153));
		lblnumSubTotal.setBounds(114, 31, 46, 14);
		panel_1.add(lblnumSubTotal);
		
		lblnumDescuento = new JLabel("0");
		lblnumDescuento.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblnumDescuento.setForeground(new Color(0, 204, 102));
		lblnumDescuento.setBounds(114, 56, 46, 14);
		panel_1.add(lblnumDescuento);
		
		lblnumTotal = new JLabel("0");
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
        
     
        dtm= new DefaultTableModel(data, columnNames){
        	
        	public boolean isCellEditable(int row, int column) {
				return false;
        	}
        	
        };	//creamos el Modelo de la tabla con los datos anteriores y no editable
        
        
        JTable tabla = new JTable(dtm);	 	//se crea la Tabla con el modelo DefaultTableModel
        tabla.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        tabla.setMinimumSize(new Dimension(119, 0));
        
        
        //tabla.getTableHeader().setReorderingAllowed(false);  // COLUMNAS FIJAS
        
        // DIMENSION A LAS COLUMNAS //
        
        tabla.getColumnModel().getColumn(0).setPreferredWidth(50);    // CODIGO
        tabla.getColumnModel().getColumn(1).setPreferredWidth(160);	  // NOMBRE
        tabla.getColumnModel().getColumn(2).setPreferredWidth(60);   // CANTIDAD
        tabla.getColumnModel().getColumn(3).setPreferredWidth(100);	  // PRESENTACION
        tabla.getColumnModel().getColumn(4).setPreferredWidth(160);	  // P/VENTA
        tabla.getColumnModel().getColumn(5).setPreferredWidth(160);   // FECHA DE CADUCIDAD*/

        
        // CENTRADO DE LAS LETRAS //
        
        DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
        tcr.setHorizontalAlignment(SwingConstants.CENTER);
        for(int i=0; i<6 ; i++){
        	tabla.getColumnModel().getColumn(i).setCellRenderer(tcr);
        }
   

		
        return tabla;
	}
	
	public void botonAgregar(ActionEvent e,ListaMedicamento listaM,ListaVenta listaV){
		
		boolean noRepetido = true;
		VentanaAceptar va = new VentanaAceptar(listaM,listaV);
		va.setModal(true);
		va.setVisible(true);
		
		
		try{
			NodoMedicamento aux = va.getAux();
			int cantidad = va.getCantidad();

			
			if(cantidad<=aux.getCantidad()){
				
				for(int i=0;i<table.getRowCount();i++){
					String num =table.getValueAt(i, 0).toString();
					if(Integer.parseInt(num)==aux.getCodigo()){
						JOptionPane.showMessageDialog(null, " Este producto ya está en la lista, si quiere \ningresar más stock use el botón modificar ", "ERROR", JOptionPane.WARNING_MESSAGE);
						noRepetido = false;
					}
					
				}
				
				
				if(noRepetido){
					double subtotal = cantidad*aux.getPrecio();
					Object[] nuevaFila={aux.getCodigo(),aux.getNombre(),cantidad,aux.getPresentacion(),aux.getPrecio(),subtotal};
			    	dtm.addRow(nuevaFila);	
			    	aux.setCantidad(aux.getCantidad()-cantidad);
			    	
			    	calculo(subtotal);
			    	
			    	contador++;
			    	JOptionPane.showMessageDialog(null, " Agregado a la cola");
				}
				
			}else{
				JOptionPane.showMessageDialog(null, " No hay stock suficiente", "ERROR", JOptionPane.WARNING_MESSAGE);
			}
		}catch(Exception ex){
			JOptionPane.showMessageDialog(null, " No realizó ninguna operación ", "ERROR", JOptionPane.WARNING_MESSAGE);
		}
			
	}
	
	
	public void calculo(double subtotal){
		
		setSumador(getSumador()+subtotal);
    	lblnumSubTotal.setText(Double.toString(sumador));
    	double descuento = 0;
    	System.out.println(contador);
    	if(contador>=3){
    		
    		double sub= Double.parseDouble(lblnumSubTotal.getText());
    		descuento = sub*0.1;
    		lblnumDescuento.setText(Double.toString(descuento));
    		
    	}
    	
    	lblnumTotal.setText(Double.toString(getSumador()- descuento));
	}
	
	
	public void botonEliminar(ActionEvent e){
		
		int fila = table.getSelectedRow();
		
		int codigo = (int) table.getValueAt(fila, 0);
		
		int cantidad = (int) table.getValueAt(fila, 2);
		
		double subtotal = (double) table.getValueAt(fila,5);
		
		listaM.devolverCantidad(codigo, cantidad);
		
		setSumador(getSumador()-subtotal);
		lblnumSubTotal.setText(Double.toString(sumador));
		contador--;
		
		DefaultTableModel model = (DefaultTableModel)table.getModel();
		model.removeRow(table.getSelectedRow()); 	
		
	}
	
	
	public void botonModificar(ActionEvent e){
		int diferencia;
		
		int fila = table.getSelectedRow();
		
		int cantidadTabla = (int) table.getValueAt(fila, 2);
		
		int codigo = (int) table.getValueAt(fila, 0);
		
		double precio = (double) table.getValueAt(fila,4);
		
		double subtotal;
		
		int cantidad = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese la cantidad del producto "));
		
		NodoMedicamento aux = listaM.buscarNodo(codigo);
		
		
		if(cantidad <= aux.getCantidad()){
			table.setValueAt(cantidad, fila, 2);
			
			if(cantidadTabla>cantidad){
				diferencia = cantidadTabla-cantidad;
				listaM.devolverCantidad(codigo, diferencia);
				subtotal = precio*diferencia;
				setSumador(getSumador()-subtotal);
			
			}else{
				diferencia=cantidad-cantidadTabla;
				listaM.sacarCantidad(codigo, diferencia);
				subtotal = precio*diferencia;
				setSumador(getSumador()+subtotal);
		
			}
			
			
			double nuevoSubtotal = precio*cantidad;
			table.setValueAt(nuevoSubtotal, fila, 5);
			
			
			lblnumSubTotal.setText(Double.toString(sumador));
		}else{
			JOptionPane.showMessageDialog(null, " ¡ No hay stock suficiente ! \n Stock disponible : "+aux.getCantidad(), "ERROR", JOptionPane.WARNING_MESSAGE);
		}
		
		
		
	}
	
	private void botonGuardar(ActionEvent e){
		
		for(int i=0;i<table.getRowCount();i++){
			
			int codigo = Integer.parseInt(table.getValueAt(i, 0).toString());
			String nombre = (String) table.getValueAt(i,1);
			int cantidad = (int) table.getValueAt(i, 2);
			String presentacion = table.getValueAt(i, 3).toString();
			double precio = (double) table.getValueAt(i, 4);
			double subtotal = (double) table.getValueAt(i, 5);
		
			listaV.insertarFinal(codigo, nombre, cantidad, presentacion, precio, subtotal);
		}
		
		listaV.listar();
		
	}
	
	private void botonVuelto(ActionEvent e){
		
		double dinero = Double.parseDouble(tfDinero.getText());
		double total =Double.parseDouble(lblnumTotal.getText());
		
		lblCambio.setText(Double.toString(dinero-total));
	}
	
	
	public double getSumador() {
		return sumador;
	}

	public void setSumador(double sumador) {
		this.sumador = sumador;
	}
	
	public double getDescuento() {
		return descuento;
	}

	public void setDescuento(double descuento) {
		this.descuento = descuento;
	}
}
