package paneles;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import farmacia.EscribirArchivo;
import farmacia.Validacion;
import farmacia.ValidarCampo;
import listas.ListaUsuario;
import listas.NodoUsuario;

public class EditarUsuario extends JDialog{

	private final JPanel contentPanel = new JPanel();
	private JTextField tfNombre;
	private JTextField tfApellido;
	private JTextField tfDireccion;
	private JTextField tfTelefono;
	private JTextField tfUsuario;
	private JTextField tfPassword;
	private JComboBox comboCargo;
	
	private ListaUsuario lista;
	private int pos;
	private DefaultTableModel dtm;
	private NodoUsuario aux;

	public EditarUsuario(NodoUsuario aux,ListaUsuario lista,int fila,DefaultTableModel dtm) {
		
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
		
		JLabel lblNombre = new JLabel("Nombre :");
		lblNombre.setBounds(48, 14, 91, 14);
		contentPanel.add(lblNombre);
		
		JLabel lblApellido = new JLabel("Apellido :");
		lblApellido .setBounds(48, 39, 91, 14);
		contentPanel.add(lblApellido );
		
		JLabel lblDireccion = new JLabel("Direcci\u00F3n :");
		lblDireccion.setBounds(48, 64, 80, 14);
		contentPanel.add(lblDireccion);
		
		JLabel lblTelefono = new JLabel("Telefono :");
		lblTelefono.setBounds(48, 89, 66, 14);
		contentPanel.add(lblTelefono);
		
		JLabel lblUsuario = new JLabel("Usuario :");
		lblUsuario.setBounds(48, 114, 105, 14);
		contentPanel.add(lblUsuario);
		
		JLabel lblPassword = new JLabel("Contraseña :");
		lblPassword.setBounds(48, 139, 120, 14);
		contentPanel.add(lblPassword);
		
		JLabel lblCargo = new JLabel("Cargo :");
		lblCargo.setBounds(48, 164, 55, 14);
		contentPanel.add(lblCargo);
		
		tfNombre = new JTextField(aux.getNombre().toString());
		tfNombre.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				Validacion.validarLetra(e);
			}
		});
		tfNombre.setBounds(178, 14, 135, 20);
		contentPanel.add(tfNombre);
		tfNombre.setColumns(10);
		
		tfApellido = new JTextField(aux.getApellido().toString());
		tfApellido.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				Validacion.validarLetra(e);
			}
		});
		tfApellido.setBounds(178, 39, 135, 20);
		contentPanel.add(tfApellido);
		tfApellido.setColumns(10);
		
		tfDireccion = new JTextField(aux.getDireccion().toString());
		tfDireccion.setBounds(178, 64, 135, 20);
		contentPanel.add(tfDireccion);
		tfDireccion.setColumns(10);
		
		tfTelefono = new JTextField(aux.getTelefono().toString());
		tfTelefono.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				Validacion.validarNumero(e);
			}
		});
		tfTelefono.setColumns(10);
		tfTelefono.setBounds(178, 89, 135, 20);
		contentPanel.add(tfTelefono);
		
		tfUsuario = new JTextField(aux.getUsuario().toString());
		tfUsuario.setBounds(178, 114, 135, 20);
		contentPanel.add(tfUsuario);
		tfUsuario.setColumns(10);
		
		tfPassword = new JTextField(aux.getPassword().toString());
		tfPassword.setBounds(178, 139, 135, 20);
		contentPanel.add(tfPassword);
		tfPassword.setColumns(10);
		
		comboCargo = new JComboBox();
		comboCargo.setModel(new DefaultComboBoxModel(new String[] {"Administrador", "Farmaceutico"}));
		comboCargo.setBounds(178, 164, 135, 20);
		contentPanel.add(comboCargo);
		
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
	}
	
	public void botonGuardar(ActionEvent evt){
		
		ValidarCampo vc = new ValidarCampo();
		String cargo=comboCargo.getSelectedItem().toString();
		if(vc.validarCampo(tfNombre) && vc.validarCampo(tfApellido) && vc.validarCantidad(tfTelefono) && vc.validarCampo(tfDireccion) && vc.validarCampo(tfPassword) && vc.validarCampo(tfUsuario)){
			if(lista.verificarRepetidoVentana(tfNombre.getText(), tfApellido.getText(), tfUsuario.getText(), tfPassword.getText(),cargo,pos)){
				JOptionPane.showMessageDialog(null, "¡ El elemento ya está en la lista !","Error",JOptionPane.ERROR_MESSAGE);
			}else{
				int codigo = lista.dimension()+1;
				String nombre = tfNombre.getText();
				String apellido = tfApellido.getText();
				String telefono = tfTelefono.getText();
				String direccion = tfDireccion.getText();
				String password = tfPassword.getText();
				String usuario = tfUsuario.getText();
				//String cargo = comboCargo.getSelectedItem().toString();
				
				lista.editarPorPosicion(pos,nombre,apellido,telefono,direccion,usuario,password,cargo);
				
				dtm.setValueAt(aux.getCodigo(),pos-1,0);
				dtm.setValueAt(aux.getCargo(), pos-1, 1);
				dtm.setValueAt(aux.getNombre(),pos-1,2);
				dtm.setValueAt(aux.getApellido(),pos-1,3);
				dtm.setValueAt(aux.getDireccion(), pos-1, 4);
				dtm.setValueAt(aux.getTelefono(),pos-1,5);
				dtm.setValueAt(aux.getUsuario(), pos-1, 6);
				dtm.setValueAt(aux.getPassword(), pos-1, 7);
				
				
				
				EscribirArchivo.escribirArchivoUsuarios(lista);
				
				JOptionPane.showMessageDialog(null, "¡Modificado!");
				
				setVisible(false);
			}
		}
	}

}
