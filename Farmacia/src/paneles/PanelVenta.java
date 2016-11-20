package paneles;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import farmacia.EscribirArchivo;
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
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
	private JLabel lblAnuncio;
	
	public PanelVenta(ListaMedicamento listaM,ListaVenta listaV) {
		
		setLayout(null);
		this.listaM=listaM;
		this.listaV=listaV;

		JPanel panelOpciones = new JPanel();
		panelOpciones.setBorder(new TitledBorder(null, "Opciones", Font.BOLD, TitledBorder.TOP, null, null));
		panelOpciones.setBounds(10, 11, 418, 120);
		add(panelOpciones);
		panelOpciones.setLayout(null);
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				botonAgregar(e,listaM,listaV);
			}
		});
		btnAgregar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAgregar.setIcon(new ImageIcon(PanelVenta.class.getResource("/iconos/Plus Math-16.png")));
		btnAgregar.setBounds(21, 26, 112, 23);
		panelOpciones.add(btnAgregar);
		
		
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
		btnCancelar.setBounds(160, 26, 118, 23);
		panelOpciones.add(btnCancelar);
		
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
		btnModificar.setBounds(21, 72, 112, 23);
		panelOpciones.add(btnModificar);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnGuardar.setIcon(new ImageIcon(PanelVenta.class.getResource("/iconos/Save Close-16.png")));
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				botonGuardar(e);
			}
		});
		btnGuardar.setBounds(160, 72, 118, 23);
		panelOpciones.add(btnGuardar);
		
		
		
		JLabel lblSuCambioEs = new JLabel("Su cambio es :");
		lblSuCambioEs.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblSuCambioEs.setForeground(new Color(0, 0, 204));
		lblSuCambioEs.setBounds(313, 26, 89, 14);
		panelOpciones.add(lblSuCambioEs);
		
		tfDinero = new JTextField();
		tfDinero.setHorizontalAlignment(SwingConstants.CENTER);
		tfDinero.setBackground(new Color(253, 245, 230));
		tfDinero.setBounds(313, 62, 86, 20);
		panelOpciones.add(tfDinero);
		tfDinero.setColumns(10);
		
		lblCambio = new JLabel("0");
		lblCambio.setHorizontalAlignment(SwingConstants.CENTER);
		lblCambio.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCambio.setForeground(Color.RED);
		lblCambio.setBounds(334, 42, 46, 14);
		panelOpciones.add(lblCambio);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				botonVuelto(e);
			}
		});
		btnNewButton.setIcon(new ImageIcon(PanelVenta.class.getResource("/iconos/Bank-28.png")));
		btnNewButton.setBounds(346, 86, 21, 21);
		panelOpciones.add(btnNewButton);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(192, 192, 192));
		separator.setBounds(145, 26, 21, 69);
		panelOpciones.add(separator);
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBackground(new Color(224, 255, 255));
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setOrientation(SwingConstants.VERTICAL);
		separator_1.setForeground(Color.LIGHT_GRAY);
		separator_1.setBackground(new Color(224, 255, 255));
		separator_1.setBounds(288, 26, 21, 69);
		panelOpciones.add(separator_1);
		
		JPanel panelDetalle = new JPanel();
		panelDetalle.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Detalle", Font.BOLD, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelDetalle.setBounds(432, 11, 255, 120);
		add(panelDetalle);
		panelDetalle.setLayout(null);
		
		JLabel lblSubtotal = new JLabel("Subtotal   :");
		lblSubtotal.setForeground(new Color(0, 204, 153));
		lblSubtotal.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblSubtotal.setBounds(10, 31, 74, 14);
		panelDetalle.add(lblSubtotal);
		
		JLabel lblDescuento = new JLabel("Descuento   :");
		lblDescuento.setForeground(new Color(0, 204, 51));
		lblDescuento.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDescuento.setBounds(10, 56, 74, 14);
		panelDetalle.add(lblDescuento);
		
		JLabel lblTotalAPagar = new JLabel("Total a pagar   :");
		lblTotalAPagar.setForeground(Color.RED);
		lblTotalAPagar.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTotalAPagar.setBounds(10, 81, 94, 14);
		panelDetalle.add(lblTotalAPagar);
		
		lblnumSubTotal = new JLabel("0");
		lblnumSubTotal.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblnumSubTotal.setForeground(new Color(0, 204, 153));
		lblnumSubTotal.setBounds(114, 31, 46, 14);
		panelDetalle.add(lblnumSubTotal);
		
		lblnumDescuento = new JLabel("0");
		lblnumDescuento.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblnumDescuento.setForeground(new Color(0, 204, 102));
		lblnumDescuento.setBounds(114, 56, 46, 14);
		panelDetalle.add(lblnumDescuento);
		
		lblnumTotal = new JLabel("0");
		lblnumTotal.setForeground(Color.RED);
		lblnumTotal.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblnumTotal.setBounds(114, 81, 46, 14);
		panelDetalle.add(lblnumTotal);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setOrientation(SwingConstants.VERTICAL);
		separator_2.setForeground(Color.LIGHT_GRAY);
		separator_2.setBackground(new Color(224, 255, 255));
		separator_2.setBounds(151, 26, 21, 69);
		panelDetalle.add(separator_2);
		
		lblAnuncio = new JLabel("");
		lblAnuncio.setBounds(171, 31, 74, 64);
		panelDetalle.add(lblAnuncio);
		
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
        tabla.setBackground(new Color(220, 220, 220));
        tabla.setGridColor(new Color(0, 191, 255));
        tabla.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        tabla.setMinimumSize(new Dimension(119, 0));
        
        JTableHeader header = tabla.getTableHeader();
        header.setBackground(Color.DARK_GRAY);
        header.setForeground(Color.white);
        header.setFont(new Font("Tahoma", Font.BOLD, 11));
        
        
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
						JOptionPane.showMessageDialog(null, " Este producto ya está en la lista, si quiere \ningresar más stock, use el botón modificar ", "ERROR", JOptionPane.WARNING_MESSAGE);
						noRepetido = false;
					}
					
				}
				
				
				if(noRepetido){
					double subtotal = Redondear(cantidad*aux.getPrecio(),2);
					Object[] nuevaFila={aux.getCodigo(),aux.getNombre(),cantidad,aux.getPresentacion(),aux.getPrecio(),subtotal};
					DefaultTableModel model = (DefaultTableModel) table.getModel(); //OBTENCION DEL MODELO
			    	model.addRow(nuevaFila);	
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
    	lblnumSubTotal.setText(Double.toString(Redondear(sumador,2)));
    	double descuento = 0;
 
    	if(table.getRowCount()>=3){
    		
    		lblAnuncio.setText("<html>¡ Descuento por comprar más de 3 productos ! </html>");
    		lblAnuncio.setVisible(true);
    		double sub= Double.parseDouble(lblnumSubTotal.getText());
    		descuento = sub*0.1;
    		descuento=Redondear(descuento,2);
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
		
		DefaultTableModel model = (DefaultTableModel)table.getModel();
		model.removeRow(table.getSelectedRow()); 	
		
		if(table.getRowCount()<=2){
			
			lblAnuncio.setVisible(false);
			lblnumDescuento.setText("0");
			lblnumTotal.setText(Double.toString(sumador));
		}
	}
	
	
	public void botonModificar(ActionEvent e){
		int diferencia;
		
		int fila = table.getSelectedRow();
		
		int cantidadTabla = (int) table.getValueAt(fila, 2);
		
		int codigo = (int) table.getValueAt(fila, 0);
		
		double precio = (double) table.getValueAt(fila,4);
		
		double subtotal;
		
		try{
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
		}catch(Exception ex){
			JOptionPane.showMessageDialog(null, " ¡ Ingrese un número ! ", "ERROR", JOptionPane.WARNING_MESSAGE);
		}	
		
		
	}
	
	private void botonGuardar(ActionEvent e){
		
		
		Date fechaActual = new Date();
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		String fecha = dateFormat.format(fechaActual);
		String cliente="";
		ConfirmarVenta vc = new ConfirmarVenta();
		
		while(vc.getValido()){
			vc.setModal(true);
			vc.setVisible(true);
			cliente = vc.getCliente();
			
		}
		
	
		//String cliente = JOptionPane.showInputDialog(null, "Ingrese el nombre del cliente");
		
		int resp = JOptionPane.showConfirmDialog(null, "¿ Desea realizar esta venta ? ");
		
		if(JOptionPane.OK_OPTION == resp){
			
			for(int i=0;i<table.getRowCount();i++){
				
				int codigo = Integer.parseInt(table.getValueAt(i, 0).toString());
				String nombre = (String) table.getValueAt(i,1);
				int cantidad = (int) table.getValueAt(i, 2);
				String presentacion = table.getValueAt(i, 3).toString();
				double precio = (double) table.getValueAt(i, 4);
				double subtotal = (double) table.getValueAt(i, 5);
				double descuento = Double.parseDouble(lblnumDescuento.getText())/table.getRowCount() ;
				
			
				listaV.insertarFinal(codigo, nombre, cliente, presentacion,cantidad, precio, subtotal,descuento,fecha);
			}
			
			EscribirArchivo.escribirArchivoVenta(listaV);
			EscribirArchivo.escribirArchivoMedicamentos(listaM);
		
		}else{
			
			for(int i=0;i<table.getRowCount();i++){
				
				int codigo = Integer.parseInt(table.getValueAt(i, 0).toString());
				int cantidad = (int) table.getValueAt(i, 2);
				listaM.devolverCantidad(codigo, cantidad);

			}
	
			JOptionPane.showMessageDialog(null, " ¡ No se realizo la venta ! ");
		}
		
		setSumador(0);
		setDescuento(0);
		lblnumSubTotal.setText("0");
		lblnumDescuento.setText("0");
		lblnumTotal.setText("0");
		lblAnuncio.setVisible(false);
		limpiarTable();
			
	}
	
	private void botonVuelto(ActionEvent e){
		
		try{
			double dinero = Double.parseDouble(tfDinero.getText());
			double total =Double.parseDouble(lblnumTotal.getText());
			double cambio=Redondear(dinero-total,2);
			
			lblCambio.setText(Double.toString(cambio));
		}catch(Exception ex){
			JOptionPane.showMessageDialog(null, " ¡ Ingrese el dinero ! ", "ERROR", JOptionPane.WARNING_MESSAGE);
		}
		
	}
	
	public double Redondear(double numero,int digitos) { 
		int cifras=(int) Math.pow(10,digitos); 
		return Math.rint(numero*cifras)/cifras; 
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
	
	
	public double getSumador() {
		sumador=Redondear(sumador,2);
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
