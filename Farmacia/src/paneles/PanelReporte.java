package paneles;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import com.toedter.calendar.JDateChooser;

import listas.ListaVenta;
import listas.NodoMedicamento;
import listas.NodoVenta;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import javax.swing.ImageIcon;

public class PanelReporte extends JPanel {

	private DefaultTableModel dtm;
	private JTable table;
	private ListaVenta listaV;
	private JDateChooser dcDesde;
	private JDateChooser dcHasta;
	private JLabel lblVenta;
	private JLabel lblDescuento;
	private JLabel lblGanancia;
	
	public PanelReporte(ListaVenta lista) {
		setLayout(null);
		this.listaV = lista;
		
		JPanel panelBuscar = new JPanel();
		panelBuscar.setBorder(new TitledBorder(null, "Buscar", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelBuscar.setBounds(10, 11, 417, 122);
		add(panelBuscar);
		panelBuscar.setLayout(null);
		
		JLabel lblDesde = new JLabel("Desde :");
		lblDesde.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDesde.setBounds(28, 44, 46, 14);
		panelBuscar.add(lblDesde);
		
		dcDesde = new JDateChooser();
		dcDesde.setBounds(84, 44, 95, 20);
		panelBuscar.add(dcDesde);
		
		JLabel lblHasta = new JLabel("Hasta :");
		lblHasta.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblHasta.setBounds(244, 44, 46, 14);
		panelBuscar.add(lblHasta);
		
		dcHasta = new JDateChooser();
		dcHasta.setBounds(300, 44, 95, 20);
		panelBuscar.add(dcHasta);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnBuscar.setIcon(new ImageIcon(PanelReporte.class.getResource("/iconos/Search-16.png")));
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					botonBuscar(e);
				} catch (ParseException e1) {
					// TODO Bloque catch generado automáticamente
					e1.printStackTrace();
				}
			}
		});
		btnBuscar.setBounds(163, 88, 95, 23);
		panelBuscar.add(btnBuscar);
		
		JPanel panelDetalle = new JPanel();
		panelDetalle.setBorder(new TitledBorder(null, "Detalle", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelDetalle.setBounds(437, 11, 250, 122);
		add(panelDetalle);
		panelDetalle.setLayout(null);
		
		JLabel lblTotalDeVenta = new JLabel("Total de venta :");
		lblTotalDeVenta.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTotalDeVenta.setBounds(10, 31, 98, 14);
		panelDetalle.add(lblTotalDeVenta);
		
		JLabel lblTotalDeDescuento = new JLabel("Total de descuento :");
		lblTotalDeDescuento.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTotalDeDescuento.setBounds(10, 60, 126, 14);
		panelDetalle.add(lblTotalDeDescuento);
		
		JLabel lblTotalDeGanancia = new JLabel("Total de ganancia :");
		lblTotalDeGanancia.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTotalDeGanancia.setBounds(10, 85, 113, 14);
		panelDetalle.add(lblTotalDeGanancia);
		
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setForeground(Color.LIGHT_GRAY);
		separator.setBackground(new Color(224, 255, 255));
		separator.setBounds(146, 27, 21, 72);
		panelDetalle.add(separator);
		
		lblVenta = new JLabel("");
		lblVenta.setBounds(177, 31, 46, 14);
		panelDetalle.add(lblVenta);
		
		lblDescuento = new JLabel("");
		lblDescuento.setBounds(177, 60, 46, 14);
		panelDetalle.add(lblDescuento);
		
		lblGanancia = new JLabel("");
		lblGanancia.setBounds(177, 85, 46, 14);
		panelDetalle.add(lblGanancia);
		
	
		
		table=crearTabla();
		
		table.setPreferredScrollableViewportSize(new Dimension(500, 70));
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 144, 677, 335);
		add(scrollPane);

	}
	
	private JTable crearTabla(){
		
		Object[][] data = {};					//array bidimencional de objetos con los datos de la tabla
              
        //array de String's con los tÌtulos de las columnas
        String[] columnNames = {"Código",
        						"Producto",
        						"Cliente",
        						"Presentación", 
                                "Cantidad", 
                                "P/Venta",     
                                "Subtotal",
                                "Descuento",
                                "Fecha"};
        
     
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
        tabla.getColumnModel().getColumn(6).setPreferredWidth(100);	  // PRESENTACION
        tabla.getColumnModel().getColumn(7).setPreferredWidth(160);	  // P/VENTA
        tabla.getColumnModel().getColumn(8).setPreferredWidth(160);   // FECHA DE CADUCIDAD*/
        
        // CENTRADO DE LAS LETRAS //
        
        DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
        tcr.setHorizontalAlignment(SwingConstants.CENTER);
        for(int i=0; i<9 ; i++){
        	tabla.getColumnModel().getColumn(i).setCellRenderer(tcr);
        }
        


		
        return tabla;
	}

	public void botonBuscar(ActionEvent e) throws ParseException{
		
		try{
			double sumaTotal = 0;
			double descuentoTotal = 0;
			double ganancia = 0;
			
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			
			String dia1 = Integer.toString(dcDesde.getCalendar().get(Calendar.DAY_OF_MONTH));
			String mes1 = Integer.toString(dcDesde.getCalendar().get(Calendar.MONTH) + 1);
			String year1 = Integer.toString(dcDesde.getCalendar().get(Calendar.YEAR));
			Date calendario = dateFormat.parse(dia1 + "/" + mes1+ "/" + year1);
			
			String dia2 = Integer.toString(dcHasta.getCalendar().get(Calendar.DAY_OF_MONTH));
			String mes2 = Integer.toString(dcHasta.getCalendar().get(Calendar.MONTH) + 1);
			String year2 = Integer.toString(dcHasta.getCalendar().get(Calendar.YEAR));
			Date calendario2 = dateFormat.parse(dia2 + "/" + mes2+ "/" + year2);
			
			NodoVenta aux = listaV.getInicio();
	        
			limpiarTable();
			
	        while(aux!=null){
	        	
	        	Date fechaCompra = dateFormat.parse(aux.getFecha());
	        	
	        	if( (fechaCompra.after(calendario) ||fechaCompra.equals(calendario)) && (fechaCompra.before(calendario2) || fechaCompra.equals(calendario2))){
	        		Object[] nuevaFila={aux.getCodigo(),aux.getNombre(),aux.getCliente(),aux.getPresentacion(),aux.getCantidad(),aux.getPrecio(),aux.getSubtotal(),aux.getDescuento(),aux.getFecha()};
	            	dtm.addRow(nuevaFila);
	     	
	        	}
	        
	        	aux=aux.getSiguiente();
	        }
	        
	        
	        for(int i=0;i<table.getRowCount();i++){
				
				double subtotal = (double) table.getValueAt(i, 6);
				sumaTotal = sumaTotal + subtotal;
			
			}
	        
	        lblVenta.setText(Double.toString(Redondear(sumaTotal,2)));
	        
	        for(int i=0;i<table.getRowCount();i++){
				
				double descuento = (double) table.getValueAt(i, 7);
				descuentoTotal = descuentoTotal + descuento;
			
			}
	        
	        lblDescuento.setText(Double.toString(Redondear(descuentoTotal,2)));
	        ganancia = sumaTotal-descuentoTotal;
	        lblGanancia.setText(Double.toString(Redondear(ganancia,2)));
		}catch(Exception ex){
			 JOptionPane.showMessageDialog(null, " ¡ Ingrese las fechas ! ");
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
	
	public double Redondear(double numero,int digitos) { 
		int cifras=(int) Math.pow(10,digitos); 
		return Math.rint(numero*cifras)/cifras; 
	}
}
