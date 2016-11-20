package paneles;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import farmacia.EscribirArchivo;
import farmacia.Validacion;
import farmacia.ValidarCampo;
import listas.ListaLaboratorio;
import listas.ListaMedicamento;
import listas.NodoLaboratorio;
import listas.NodoMedicamento;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class EditarLaboratorio extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField tfLabo;
	private ListaLaboratorio lista;
	private int pos;
	private DefaultTableModel dtm;
	private NodoLaboratorio aux;


	public EditarLaboratorio(NodoLaboratorio aux, ListaLaboratorio lista, int fila, DefaultTableModel dtm) {
		
		this.lista=lista;
		this.pos=fila;
		this.dtm=dtm;
		this.aux=aux;
		
		setTitle("Editar Laboratorio");
		setBounds(100, 100, 410, 228);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblLaboratorio = new JLabel("Laboratorio:");
		lblLaboratorio.setBounds(48, 68, 85, 14);
		contentPanel.add(lblLaboratorio);
		
		tfLabo = new JTextField();
		tfLabo.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				Validacion.validarLetra(e);
			}
		});
		tfLabo.setBounds(167, 65, 132, 20);
		contentPanel.add(tfLabo);
		tfLabo.setColumns(10);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.setIcon(new ImageIcon(EditarLaboratorio.class.getResource("/iconos/Save Close-16.png")));
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				botonGuardar(e);
			}
		});
		btnGuardar.setBounds(64, 138, 104, 23);
		contentPanel.add(btnGuardar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnCancelar.setIcon(new ImageIcon(EditarLaboratorio.class.getResource("/iconos/Close Window-16.png")));
		btnCancelar.setBounds(226, 138, 109, 23);
		contentPanel.add(btnCancelar);
	}
	
	public void botonGuardar(ActionEvent evt){
		
		ValidarCampo vc = new ValidarCampo();
		
		if(vc.validarCampo(tfLabo)){	
			
			String laboratorio = tfLabo.getText();
			
			if(lista.verificarRepetido(laboratorio)){
				
				JOptionPane.showMessageDialog(null, "¡ El elemento ya está en la lista !","Error",JOptionPane.ERROR_MESSAGE);
				
			}else{
			
				lista.editarPorPosicion(pos,laboratorio);
			
				dtm.setValueAt(aux.getLaboratorio(),pos-1,0);
		
				EscribirArchivo.escribirArchivoLaboratorio(lista);
			
				JOptionPane.showMessageDialog(null, "¡Modificado!");
			
				setVisible(false);
			}
		}			
	
	}
}
