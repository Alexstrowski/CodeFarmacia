package paneles;

import javax.swing.JPanel;
import java.awt.Rectangle;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import farmacia.CargarArchivo;
import farmacia.EscribirArchivo;
import listas.ListaMedicamento;
import listas.ListaUsuario;
import listas.NodoMedicamento;
import listas.NodoUsuario;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;

public class PanelUsuario extends JPanel {
	private JTextField tfNombre;
	private JTextField tfBuscar;
	private JTextField tfApellido;
	private JTextField tfDir;
	private JTextField tfTel;
	private JTextField tfUsuario;
	private JTextField tfPass;
	private JTable table;
	private DefaultTableModel dtm;	
	private JComboBox comboFiltro;
	private TableRowSorter trsFiltro;
	private JComboBox comboCargo;

	private ListaUsuario lista;

	public PanelUsuario(ListaUsuario p) {
		setLayout(null);
		lista = p;
		
		JPanel panelDatos = new JPanel();
		panelDatos.setBorder(new TitledBorder(null, "Registro", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelDatos.setBounds(102, 0, 503, 164);
		add(panelDatos);
		panelDatos.setLayout(null);
		
		JLabel lblNombres = new JLabel("Nombres :");
		lblNombres.setBounds(10, 26, 70, 14);
		panelDatos.add(lblNombres);
		
		JLabel lblApellidos = new JLabel("Apellidos :");
		lblApellidos.setBounds(10, 65, 70, 14);
		panelDatos.add(lblApellidos);
		
		JLabel lblDireccion = new JLabel("Direcci\u00F3n :");
		lblDireccion.setBounds(10, 103, 95, 14);
		panelDatos.add(lblDireccion);
		
		JLabel lblTelefono = new JLabel("Telefono :");
		lblTelefono.setBounds(248, 26, 70, 14);
		panelDatos.add(lblTelefono);
		
		JLabel lblUsuario = new JLabel("Usuario :");
		lblUsuario.setBounds(248, 65, 46, 14);
		panelDatos.add(lblUsuario);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a :");
		lblContrasea.setBounds(248, 103, 86, 14);
		panelDatos.add(lblContrasea);
		
		tfNombre = new JTextField();
		tfNombre.setBounds(90, 23, 126, 20);
		panelDatos.add(tfNombre);
		tfNombre.setColumns(10);
		
		tfApellido = new JTextField();
		tfApellido.setColumns(10);
		tfApellido.setBounds(90, 62, 126, 20);
		panelDatos.add(tfApellido);
		
		tfDir = new JTextField();
		tfDir.setColumns(10);
		tfDir.setBounds(90, 100, 126, 20);
		panelDatos.add(tfDir);
		
		tfTel = new JTextField();
		tfTel.setColumns(10);
		tfTel.setBounds(333, 23, 126, 20);
		panelDatos.add(tfTel);
		
		tfUsuario = new JTextField();
		tfUsuario.setColumns(10);
		tfUsuario.setBounds(333, 62, 126, 20);
		panelDatos.add(tfUsuario);
		
		tfPass = new JTextField();
		tfPass.setColumns(10);
		tfPass.setBounds(333, 100, 126, 20);
		panelDatos.add(tfPass);
		
		JLabel lblCargo = new JLabel("Cargo :");
		lblCargo.setBounds(10, 139, 46, 14);
		panelDatos.add(lblCargo);
		
		comboCargo = new JComboBox();
		comboCargo.setModel(new DefaultComboBoxModel(new String[] {"Administrador", "Farmaceutico"}));
		comboCargo.setBounds(90, 134, 126, 20);
		panelDatos.add(comboCargo);
		
		JLabel label_3 = new JLabel("Buscar :");
		label_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_3.setBounds(75, 239, 46, 14);
		add(label_3);
		
		tfBuscar = new JTextField();
		tfBuscar.setColumns(10);
		tfBuscar.setBackground(new Color(224, 255, 255));
		tfBuscar.setBounds(305, 236, 322, 20);
		add(tfBuscar);
		
		comboFiltro = new JComboBox();
		comboFiltro.setBounds(167, 236, 108, 20);
		add(comboFiltro);
		
		JButton button = new JButton((String) null);
		button.setIcon(new ImageIcon(PanelUsuario.class.getResource("/iconos/Delete-32.png")));
		button.setBounds(319, 181, 89, 44);
		add(button);
		
		JButton button_1 = new JButton("");
		button_1.setIcon(new ImageIcon(PanelUsuario.class.getResource("/iconos/Edit File Filled-32.png")));
		button_1.setBounds(447, 181, 89, 44);
		add(button_1);
		
		JButton button_2 = new JButton("");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				botonAgregar(e);
			}
		});
		button_2.setIcon(new ImageIcon(PanelUsuario.class.getResource("/iconos/Plus-32.png")));
		button_2.setBounds(192, 181, 89, 44);
		add(button_2);
		
		JLabel label = new JLabel("Agregar");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(new Color(34, 139, 34));
		label.setFont(new Font("Tahoma", Font.BOLD, 11));
		label.setBounds(192, 156, 89, 28);
		add(label);
		
		JLabel label_1 = new JLabel("Eliminar");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setForeground(Color.RED);
		label_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_1.setBounds(319, 156, 89, 28);
		add(label_1);
		
		JLabel label_2 = new JLabel("Editar");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setForeground(new Color(255, 153, 0));
		label_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_2.setBounds(447, 156, 89, 28);
		add(label_2);
		
		cargarArchivo(lista);
		
		
		table=crearTabla(lista);
		
		table.setPreferredScrollableViewportSize(new Dimension(500, 70));
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 264, 677, 209);
		add(scrollPane);

	}
	
private JTable crearTabla(ListaUsuario lista){
		
		Object[][] data = {};					//array bidimencional de objetos con los datos de la tabla
              
        //array de String's con los tÌtulos de las columnas
        String[] columnNames = {"Código",
        						"Cargo",
        						"Nombres",
                                "Apellidos",
                                "Dirección",
                                "Telefono",
                                "Usuario",
                                "Contraseña"};
        
     
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
        tabla.getColumnModel().getColumn(6).setPreferredWidth(160);
        
        // CENTRADO DE LAS LETRAS //
        
        DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
        tcr.setHorizontalAlignment(SwingConstants.CENTER);
        for(int i=0; i<7 ; i++){
        	tabla.getColumnModel().getColumn(i).setCellRenderer(tcr);
        }
        
        // LLENADO DE LA TABLA //
        
        NodoUsuario aux = lista.getInicio();
        
        while(aux!=null){
        	Object[] nuevaFila={aux.getCodigo(),aux.getCargo(),aux.getNombre(),aux.getApellido(),aux.getDireccion(),aux.getTelefono(),aux.getUsuario(),aux.getPassword()};
        	dtm.addRow(nuevaFila);
        	aux=aux.getSiguiente();
        	
        }
		
        return tabla;
	}
	
	private void botonAgregar(java.awt.event.ActionEvent evt){
		
		
		int codigo = lista.dimension()+1;
		String cargo = comboCargo.getSelectedItem().toString();
		String nombre = tfNombre.getText();
		String apellido = tfApellido.getText();
		String dir = tfDir.getText();
		String tel = tfTel.getText();
		String usuario = tfUsuario.getText();
		String pass = tfPass.getText();
		
		lista.insertarFinal(codigo,cargo,nombre, apellido, dir, tel, usuario, pass);
		
		Object[] newRow={codigo,cargo,nombre,apellido, dir, tel, usuario, pass};
		dtm.addRow(newRow);
		
		escribirArchivo(lista);
		
		tfNombre.setText("");
		tfApellido.setText("");
		tfDir.setText("");
		tfTel.setText("");
		tfUsuario.setText("");
		tfPass.setText("");

		
		JOptionPane.showMessageDialog(null, "AGREGADO");	
		
	}
	
	public void escribirArchivo(ListaUsuario lista){   
		
        EscribirArchivo.escribirArchivoUsuarios(lista);
        
    }
	
	
	public void cargarArchivo(ListaUsuario lista){
			
		CargarArchivo.cargarArchivoUsuarios(lista);
			
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
