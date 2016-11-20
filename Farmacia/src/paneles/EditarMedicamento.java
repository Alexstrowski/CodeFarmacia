package paneles;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import listas.ListaLaboratorio;
import listas.ListaMedicamento;
import listas.ListaPresentacion;
import listas.NodoMedicamento;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import com.toedter.calendar.JDateChooser;

import farmacia.EscribirArchivo;
import farmacia.Validacion;
import farmacia.ValidarCampo;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class EditarMedicamento extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField tfNombre;
	private JTextField tfCantidad;
	private JTextField tfPrecio;
	private JTextField tfCosto;
	private JTextField tfDolencia;
	private JComboBox tfLabo;
	private JComboBox tfPresentacion;
	
	private JDateChooser tfFecha;
	private ListaMedicamento lista;
	private int pos;
	private DefaultTableModel dtm;
	private NodoMedicamento aux;


	public EditarMedicamento(NodoMedicamento aux,ListaMedicamento lista,ListaLaboratorio listaL,ListaPresentacion listaP,int fila,DefaultTableModel dtm) {
		
		this.lista=lista;
		this.pos=fila;
		this.dtm=dtm;
		this.aux=aux;
		
		setTitle("Editar");
		setBounds(100, 100, 354, 305);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblProducto = new JLabel("Producto :");
		lblProducto.setBounds(48, 14, 91, 14);
		contentPanel.add(lblProducto);
		
		JLabel lblPresentacion = new JLabel("Presentaci\u00F3n :");
		lblPresentacion.setBounds(48, 39, 91, 14);
		contentPanel.add(lblPresentacion);
		
		JLabel lblLaboratorio = new JLabel("Laboratorio :");
		lblLaboratorio.setBounds(48, 64, 80, 14);
		contentPanel.add(lblLaboratorio);
		
		JLabel lblCantidad = new JLabel("Cantidad :");
		lblCantidad.setBounds(48, 89, 66, 14);
		contentPanel.add(lblCantidad);
		
		JLabel lblPrecioDeVenta = new JLabel("Precio de venta :");
		lblPrecioDeVenta.setBounds(48, 114, 105, 14);
		contentPanel.add(lblPrecioDeVenta);
		
		JLabel lblPrecioDeCompra = new JLabel("Precio de compra :");
		lblPrecioDeCompra.setBounds(48, 139, 120, 14);
		contentPanel.add(lblPrecioDeCompra);
		
		JLabel lblVencimiento = new JLabel("Vencimiento :");
		lblVencimiento.setBounds(48, 164, 91, 14);
		contentPanel.add(lblVencimiento);
		
		JLabel lblDolencia = new JLabel("Dolencia :");
		lblDolencia.setBounds(48, 189, 55, 14);
		contentPanel.add(lblDolencia);
		
		tfNombre = new JTextField(aux.getNombre().toString());
		tfNombre.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				Validacion.validarLetra(e);
			}
		});
		tfNombre.setBounds(178, 8, 135, 20);
		contentPanel.add(tfNombre);
		tfNombre.setColumns(10);
		
		tfCantidad = new JTextField(Integer.toString(aux.getCantidad()));
		tfCantidad.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				Validacion.validarNumero(e);
			}
		});
		tfCantidad.setColumns(10);
		tfCantidad.setBounds(178, 83, 135, 20);
		contentPanel.add(tfCantidad);
		
		tfPrecio = new JTextField(Double.toString(aux.getPrecio()));
		tfPrecio.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				Validacion.validarNumeroYPunto(e);
			}
		});
		tfPrecio.setColumns(10);
		tfPrecio.setBounds(178, 108, 135, 20);
		contentPanel.add(tfPrecio);
		
		tfCosto = new JTextField(Double.toString(aux.getCosto()));
		tfCosto.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				Validacion.validarNumeroYPunto(e);
			}
		});
		tfCosto.setColumns(10);
		tfCosto.setBounds(178, 133, 135, 20);
		contentPanel.add(tfCosto);
		
		tfDolencia = new JTextField(aux.getDolencia());
		tfDolencia.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				Validacion.validarLetra(e);
			}
		});
		tfDolencia.setColumns(10);
		tfDolencia.setBounds(178, 183, 135, 20);
		contentPanel.add(tfDolencia);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				botonGuardar(e);
			}
		});
		btnGuardar.setIcon(new ImageIcon(EditarMedicamento.class.getResource("/iconos/Save Close-16.png")));
		btnGuardar.setBounds(42, 233, 116, 23);
		contentPanel.add(btnGuardar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnCancelar.setIcon(new ImageIcon(EditarMedicamento.class.getResource("/iconos/Close Window-16.png")));
		btnCancelar.setBounds(168, 233, 116, 23);
		contentPanel.add(btnCancelar);
		
		tfFecha = new JDateChooser();
		tfFecha.setDateFormatString("dd/MMM/yyyy");
		tfFecha.setBounds(178, 158, 135, 20);
		contentPanel.add(tfFecha);
		
		tfLabo = new JComboBox();
		cargarComboBoxLab(listaL);
		tfLabo.setBounds(178, 58, 135, 20);
		contentPanel.add(tfLabo);
		
		tfPresentacion = new JComboBox();
		cargarComboBoxPre(listaP);
		tfPresentacion.setBounds(178, 33, 135, 20);
		contentPanel.add(tfPresentacion);
	}
	
	public void botonGuardar(ActionEvent evt){
		
		ValidarCampo vc = new ValidarCampo();
		
		if(vc.validarNombre(tfNombre) && vc.validarCantidad(tfCantidad) && vc.validarFecha(tfFecha) && vc.validarVenta(tfPrecio) && vc.validarCompra(tfCosto) && vc.validarDolencia(tfDolencia) && vc.validarPrecios(tfPrecio, tfCosto)){
		
			int codigo = lista.dimension()+1;
			String nombre = tfNombre.getText();
			String laboratorio = tfLabo.getSelectedItem().toString();
			int cantidad = Integer.parseInt(tfCantidad.getText());
			String presentacion = tfPresentacion.getSelectedItem().toString();
			
			String formato = "dd/MMM/yyyy";
			Date date = tfFecha.getDate();
			SimpleDateFormat sdf = new SimpleDateFormat(formato);
			String fecha = sdf.format(date);
			
			double precio = Double.parseDouble(tfPrecio.getText());
			double costo = Double.parseDouble(tfCosto.getText());
			String dolencia = tfDolencia.getText();
			
			
			lista.editarPorPosicion(pos,nombre, laboratorio, cantidad, presentacion, fecha, precio,costo,dolencia);
			
			dtm.setValueAt(aux.getCodigo(),pos-1,0);
			dtm.setValueAt(aux.getNombre(),pos-1,1);
			dtm.setValueAt(aux.getLaboratorio(),pos-1,2);
			dtm.setValueAt(aux.getCantidad(),pos-1,3);
			dtm.setValueAt(aux.getPresentacion(),pos-1,4);
			dtm.setValueAt(aux.getFecha(),pos-1,5);
			dtm.setValueAt(aux.getPrecio(),pos-1,6);
			dtm.setValueAt(aux.getCosto(),pos-1,7);
			dtm.setValueAt(aux.getDolencia(),pos-1,8);
			
			
			EscribirArchivo.escribirArchivoMedicamentos(lista);
			
			JOptionPane.showMessageDialog(null, "¡Modificado!");
			
			setVisible(false);
		}
	}
	
	private void cargarComboBoxLab(ListaLaboratorio listaL){
		
		String arreglo[]=listaL.retornarArregloLab();
		
		for(int i=0;i<arreglo.length;i++){
			tfLabo.addItem(arreglo[i]);
		}
	}
	
	private void cargarComboBoxPre(ListaPresentacion listaP){
		
		String arreglo[]=listaP.retornarArregloPre();
		
		for(int i=0;i<arreglo.length;i++){
			tfPresentacion.addItem(arreglo[i]);
		}
	}
}
