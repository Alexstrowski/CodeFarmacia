package paneles;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import farmacia.Validacion;
import farmacia.ValidarCampo;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;

public class ConfirmarVenta extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField tfCliente;
	private String cliente="";
	private boolean valido=true;

	public ConfirmarVenta() {
		setTitle("Confirmar cliente");
		setBounds(100, 100, 424, 197);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		setDefaultCloseOperation(0);
		
		JLabel lblNewLabel = new JLabel("Ingrese nombre  del cliente :");
		lblNewLabel.setBounds(10, 55, 167, 14);
		contentPanel.add(lblNewLabel);
		
		tfCliente = new JTextField();
		tfCliente.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				Validacion.validarLetra(e);
			}
		});
		tfCliente.setBounds(187, 53, 187, 17);
		contentPanel.add(tfCliente);
		tfCliente.setColumns(10);
		{
			JButton okButton = new JButton("OK");
			okButton.setBounds(130, 108, 123, 23);
			contentPanel.add(okButton);
			okButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					botonGuardar(arg0);
				}
			});
			okButton.setActionCommand("OK");
			getRootPane().setDefaultButton(okButton);
		}
	}
	public void botonGuardar(ActionEvent evt){
		
		ValidarCampo vc = new ValidarCampo();
		
		if(vc.validarCampo(tfCliente)){
		
			cliente=tfCliente.getText();
			setCliente(cliente);
			setValido(false);
		}else{
			JOptionPane.showMessageDialog(null, " ¡ Ingrese nombre !");
			setValido(true);
		}
		
		dispose();
	}
	
	public String getCliente() {
		return cliente;
	}
	public void setCliente(String cliente) {
		this.cliente = cliente;
	}
	public boolean getValido() {
		return valido;
	}
	public void setValido(boolean valido) {
		this.valido = valido;
	}
	

}
