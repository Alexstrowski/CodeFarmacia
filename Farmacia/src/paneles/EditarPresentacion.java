package paneles;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import listas.ListaPresentacion;
import listas.NodoPresentacion;
import farmacia.EscribirArchivo;
import farmacia.Validacion;
import farmacia.ValidarCampo;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class EditarPresentacion extends JFrame {

	private final JPanel contentPanels;
	private JTextField tfPres;
	private ListaPresentacion lista;
	private int pos;
	private DefaultTableModel dtm;
	private NodoPresentacion aux;

	/**
	 * Create the frame.
	 */
	public EditarPresentacion(NodoPresentacion aux, ListaPresentacion lista, int fila, DefaultTableModel dtm) {
		this.lista=lista;
		this.pos=fila;
		this.dtm=dtm;
		this.aux=aux;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 257);
		contentPanels = new JPanel();
		contentPanels.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPanels);
		contentPanels.setLayout(null);
		
		JLabel lblLaboratorio = new JLabel("Presentaci\u00F3n :");
		lblLaboratorio.setBounds(48, 68, 85, 14);
		contentPanels.add(lblLaboratorio);
		
		tfPres = new JTextField();
		tfPres.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				Validacion.validarLetra(e);
			}
		});
		tfPres.setBounds(167, 65, 132, 20);
		contentPanels.add(tfPres);
		tfPres.setColumns(10);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.setIcon(new ImageIcon(EditarLaboratorio.class.getResource("/iconos/Save Close-16.png")));
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				botonGuardar(e);
			}
		});
		btnGuardar.setBounds(64, 138, 118, 21);
		contentPanels.add(btnGuardar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnCancelar.setIcon(new ImageIcon(EditarPresentacion.class.getResource("/iconos/Close Window-16.png")));
		btnCancelar.setBounds(241, 139, 124, 20);
		contentPanels.add(btnCancelar);
	}
	
	public void botonGuardar(ActionEvent evt){
		
		ValidarCampo vc = new ValidarCampo();
		
		if(vc.validarCampo(tfPres)){
			
			String presentacion = tfPres.getText();
			
			if(lista.verificarRepetido(presentacion)){
				
				JOptionPane.showMessageDialog(null, "¡ El elemento ya está en la lista !","Error",JOptionPane.ERROR_MESSAGE);
				
			}else{
			
				lista.editarPorPosicion(pos,presentacion);
			
				dtm.setValueAt(aux.getPresentacion(),pos-1,0);
		
				EscribirArchivo.escribirArchivoPresentacion(lista);
			
				JOptionPane.showMessageDialog(null, "¡Modificado!");
			
				setVisible(false);
			}	
			
		}
	}

}
