package paneles;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import farmacia.EscribirArchivo;
import farmacia.Validacion;
import listas.ListaLaboratorio;
import listas.ListaPresentacion;
import listas.NodoLaboratorio;
import listas.NodoPresentacion;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class PanelPresentacion extends JPanel {
	private JTextField tfPresentacion;
	private JTable table;
	private JTable tabla;
	private ListaPresentacion lista;
	private DefaultTableModel dtm;
	
	/**
	 * Create the panel.
	 */
	public PanelPresentacion(ListaPresentacion p) {
		setLayout(null);
		lista = p;
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Presentacion", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setToolTipText("Presentaci\u00F3n");
		panel.setBounds(80, 43, 519, 190);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblPresentacion = new JLabel("Nombre de Presentacion:");
		lblPresentacion.setBounds(71, 42, 156, 14);
		panel.add(lblPresentacion);
		
		tfPresentacion = new JTextField();
		tfPresentacion.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				Validacion.validarLetra(e);
			}
		});
		tfPresentacion.setBounds(237, 39, 137, 20);
		panel.add(tfPresentacion);
		tfPresentacion.setColumns(10);
		
		JButton botonAgregar = new JButton("");
		botonAgregar.setIcon(new ImageIcon(PanelLaboratorio.class.getResource("/iconos/Plus-32.png")));
		botonAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				botonAgregar(e);
			}
		});
		botonAgregar.setBounds(47, 116, 89, 41);
		panel.add(botonAgregar);
		
		JButton botonEliminar = new JButton("");
		botonEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(table.getSelectedRow()>-1){
					botonEliminar(e);
				}else{
					JOptionPane.showMessageDialog(null,"Debe seleccionar una fila primero","WARNING_MESSAGE",JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		botonEliminar.setIcon(new ImageIcon(PanelLaboratorio.class.getResource("/iconos/Delete-32.png")));
		botonEliminar.setBounds(223, 116, 89, 41);
		panel.add(botonEliminar);
		
		JButton botonEditar = new JButton("");
		botonEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(table.getSelectedRow()>-1){
					botonEditar(e);
				}else{
					JOptionPane.showMessageDialog(null,"Debe seleccionar una fila primero","WARNING_MESSAGE",JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		botonEditar.setIcon(new ImageIcon(PanelLaboratorio.class.getResource("/iconos/Edit File Filled-32.png")));
		botonEditar.setBounds(381, 116, 89, 41);
		panel.add(botonEditar);
		
		JLabel label = new JLabel("Agregar");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(new Color(34, 139, 34));
		label.setFont(new Font("Tahoma", Font.BOLD, 11));
		label.setBounds(47, 85, 89, 28);
		panel.add(label);
		
		JLabel label_1 = new JLabel("Eliminar");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setForeground(Color.RED);
		label_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_1.setBounds(223, 85, 89, 28);
		panel.add(label_1);
		
		JLabel label_2 = new JLabel("Editar");
		label_2.setBounds(381, 85, 89, 28);
		panel.add(label_2);
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setForeground(new Color(255, 153, 0));
		label_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		table=crearTabla(lista);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(216, 259, 247, 160);
		add(scrollPane);
	}
	
	private JTable crearTabla(ListaPresentacion lista){
		Object[][] data = {};
		String[] columnNames = {"Presentaciones"};
		
		dtm= new DefaultTableModel(data, columnNames){
        	
        	public boolean isCellEditable(int row, int column) {
				return false;
        	}
        	
        };
		
		
		
		JTable tabla = new JTable(dtm);	
        tabla.setMinimumSize(new Dimension(119, 0));
        
        // Dimensión a las tablas //
        
        tabla.getColumnModel().getColumn(0).setPreferredWidth(200);
        
        DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
        tcr.setHorizontalAlignment(SwingConstants.CENTER);
        
        tabla.getColumnModel().getColumn(0).setCellRenderer(tcr);
        
        
        // LLenado de la tabla //
		
        NodoPresentacion aux = lista.getInicio();
        
        while(aux!=null){
        	Object[] nuevaFila={aux.getPresentacion()};
        	dtm.addRow(nuevaFila);
        	aux=aux.getSiguiente();
        }
		return tabla;
	}
	
	private void botonAgregar(java.awt.event.ActionEvent evt){
		
		String presentacion = tfPresentacion.getText();
		
		if(lista.verificarRepetido(presentacion)){
			
			JOptionPane.showMessageDialog(null, "¡ El elemento ya está en la lista !","Error",JOptionPane.ERROR_MESSAGE);
		}else{
			if(!presentacion.equals("")){
				lista.insertarFinal(presentacion);
				Object[] newRow={presentacion};
				dtm.addRow(newRow);
				escribirArchivo(lista);
				tfPresentacion.setText("");
				JOptionPane.showMessageDialog(null, "¡ Presentación agregada !");
			}
			else{
				JOptionPane.showMessageDialog(null, "¡ Ingrese una presentación !");
			}
			
		}
	
	}
	
	public void escribirArchivo(ListaPresentacion lista){   
        EscribirArchivo.escribirArchivoPresentacion(lista);
    }
	
	private void botonEliminar(java.awt.event.ActionEvent evt){
		
		int ax = JOptionPane.showConfirmDialog(null, "¿ Está seguro de eliminar la presentación ?");
        if(ax == JOptionPane.YES_OPTION){
        	DefaultTableModel model = (DefaultTableModel)table.getModel();
    		
    		int fila = table.getSelectedRow()+1;
    		
    		lista.eliminar(fila);
    		
    		model.removeRow(table.getSelectedRow()); 
    		
    		escribirArchivo(lista);
    		
    		JOptionPane.showMessageDialog(null, "¡ Presentacion eliminada !");
        }    
  
	}
	
	private void botonEditar(java.awt.event.ActionEvent evt){
		
		DefaultTableModel model = (DefaultTableModel)table.getModel();
		int fila = table.getSelectedRow()+1;
		
		
		NodoPresentacion aux=null;
		aux=lista.buscarNodo(fila);
		
		
		EditarPresentacion el = new EditarPresentacion(aux,lista,fila,dtm);
		el.setVisible(true);
		
	}

}
