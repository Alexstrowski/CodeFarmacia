package paneles;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import farmacia.CargarArchivo;
import farmacia.EscribirArchivo;
import farmacia.Validacion;
import listas.ListaLaboratorio;
import listas.ListaUsuario;
import listas.NodoLaboratorio;
import listas.NodoMedicamento;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class PanelLaboratorio extends JPanel {
	private JTextField tfLaboratorio;
	private JTable table;
	private JTable tabla;
	private ListaLaboratorio lista;
	private DefaultTableModel dtm;


	public PanelLaboratorio(ListaLaboratorio p) {
		setLayout(null);
		lista = p;
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Laboratorio", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setToolTipText("Laboratorio");
		panel.setBounds(80, 43, 519, 190);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblNombreDelLaboratorio = new JLabel("Nombre del laboratorio:");
		lblNombreDelLaboratorio.setBounds(71, 42, 137, 14);
		panel.add(lblNombreDelLaboratorio);
		
		tfLaboratorio = new JTextField();
		tfLaboratorio.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				Validacion.validarLetra(e);
			}
		});
		tfLaboratorio.setBounds(237, 39, 137, 20);
		panel.add(tfLaboratorio);
		tfLaboratorio.setColumns(10);
		
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
	
	private JTable crearTabla(ListaLaboratorio lista){
		Object[][] data = {};
		String[] columnNames = {"Laboratorios"};
		
		dtm= new DefaultTableModel(data, columnNames);
		JTable tabla = new JTable(dtm);	
        tabla.setMinimumSize(new Dimension(119, 0));
        
        // Dimensión a las tablas //
        
        tabla.getColumnModel().getColumn(0).setPreferredWidth(200);
        
        DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
        tcr.setHorizontalAlignment(SwingConstants.CENTER);
        
        tabla.getColumnModel().getColumn(0).setCellRenderer(tcr);
        
        
        // LLenado de la tabla //
		
        NodoLaboratorio aux = lista.getInicio();
        
        while(aux!=null){
        	Object[] nuevaFila={aux.getLaboratorio()};
        	dtm.addRow(nuevaFila);
        	aux=aux.getSiguiente();
        	
        }
		return tabla;
		
	}
	

	
	private void botonAgregar(java.awt.event.ActionEvent evt){
		
		String laboratorio = tfLaboratorio.getText();
		
		if(lista.verificarRepetido(laboratorio)){
			
			JOptionPane.showMessageDialog(null, "¡ El elemento ya está en la lista !","Error",JOptionPane.ERROR_MESSAGE);
		}else{
			
			if(!laboratorio.equals("")){
				lista.insertarFinal(laboratorio);
				
				Object[] newRow={laboratorio};
			
				dtm.addRow(newRow);
			
				escribirArchivo(lista);
			
				tfLaboratorio.setText("");
			
				JOptionPane.showMessageDialog(null, "¡ Laboratorio agregado !");
			
			}
			else{
				JOptionPane.showMessageDialog(null, "¡ Ingrese un laboratorio !");
			}
		}	
	}
	
	public void escribirArchivo(ListaLaboratorio lista){   
		
        EscribirArchivo.escribirArchivoLaboratorio(lista);
        
    }
	
	private void botonEliminar(java.awt.event.ActionEvent evt){
		
		int ax = JOptionPane.showConfirmDialog(null, "¿Está seguro de eliminar el laboratorio?");
        if(ax == JOptionPane.YES_OPTION){
        	DefaultTableModel model = (DefaultTableModel)table.getModel();
    		
    		int fila = table.getSelectedRow()+1;
    		
    		lista.eliminar(fila);
    		
    		model.removeRow(table.getSelectedRow()); 
    		
    		escribirArchivo(lista);
    		
    		JOptionPane.showMessageDialog(null, "Laboratorio eliminado");
        }    
  
	}
	
	private void botonEditar(java.awt.event.ActionEvent evt){
		
		DefaultTableModel model = (DefaultTableModel)table.getModel();
		int fila = table.getSelectedRow()+1;
		
		
		NodoLaboratorio aux=null;
		aux=lista.buscarNodo(fila);
		
		EditarLaboratorio el = new EditarLaboratorio(aux,lista,fila,dtm);
		el.setVisible(true);
		
	}
}
