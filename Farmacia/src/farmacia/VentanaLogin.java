package farmacia;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import listas.ListaUsuario;
import listas.NodoUsuario;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JPasswordField;


public class VentanaLogin extends JDialog {
	private JTextField tfUsuario;
	private JPasswordField tfPass;

	private ListaUsuario listaU = new ListaUsuario();
	
	public static void main(String[] args) {
		try {
			VentanaLogin dialog = new VentanaLogin();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public VentanaLogin() {
		
		
		getContentPane().setBackground(new Color(204, 204, 204));
		setTitle("Proyecto Farmacia");
		setBounds(100, 100, 1288, 715);
		getContentPane().setLayout(null);
		
		tfUsuario = new JTextField("");
		tfUsuario.setToolTipText("");
		tfUsuario.setBounds(577, 267, 157, 26);
		getContentPane().add(tfUsuario);
		tfUsuario.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(VentanaLogin.class.getResource("/iconos/User-32.png")));
		lblNewLabel.setBounds(535, 261, 32, 32);
		getContentPane().add(lblNewLabel);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(VentanaLogin.class.getResource("/iconos/Key-32.png")));
		label.setBounds(535, 321, 32, 32);
		getContentPane().add(label);
		
		JButton btnIniciarSesin = new JButton("");
		btnIniciarSesin.setIcon(new ImageIcon(VentanaLogin.class.getResource("/fondos/boton-resized.jpg")));
		btnIniciarSesin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				verificarPerfil(e);
			}
		});
		btnIniciarSesin.setBounds(535, 388, 202, 32);
		getContentPane().add(btnIniciarSesin);
		
		tfPass = new JPasswordField();
		tfPass.setBounds(577, 327, 157, 26);
		getContentPane().add(tfPass);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setForeground(Color.BLACK);
		lblUsuario.setBackground(Color.WHITE);
		lblUsuario.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblUsuario.setBounds(577, 253, 46, 14);
		getContentPane().add(lblUsuario);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setForeground(Color.BLACK);
		lblContrasea.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblContrasea.setBounds(577, 314, 65, 14);
		getContentPane().add(lblContrasea);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(VentanaLogin.class.getResource("/fondos/loginoficial-resized.png")));
		label_1.setBounds(0, 0, 1279, 685);
		getContentPane().add(label_1);
	}
	
	public void verificarPerfil(ActionEvent e){
		
		int band;
		boolean valido;
		NodoUsuario aux = new NodoUsuario();
		String usuario = tfUsuario.getText();
		String pass = tfPass.getText();
		
		
		CargarArchivo.cargarArchivoUsuarios(listaU);
		
		
		valido=listaU.buscarUsuario(usuario, pass);
		
		
		
		if(valido){
			JOptionPane.showMessageDialog(null, "Usuario válido","Usuario válido", JOptionPane.WARNING_MESSAGE);
				aux=listaU.retornarUsuario(usuario, pass);
				
				if(aux.getCargo().equals("Administrador")){
					band=0;
				}else{
					band=1;
				}
				VentanaMenu vm = new VentanaMenu(band);
				JOptionPane.showMessageDialog(null, "!   Bienvenido "+aux.getUsuario()+"  ! ");
				vm.setVisible(true);
				dispose();
			
		}else{
			JOptionPane.showMessageDialog(null, "Usuario inválido",
					  "Usuario inválido", JOptionPane.WARNING_MESSAGE);
		}
		
		
		
		
	}
}
