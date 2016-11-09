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
	private JLabel lblNewLabel_1;
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
		setBounds(100, 100, 395, 300);
		getContentPane().setLayout(null);
		
		tfUsuario = new JTextField("");
		tfUsuario.setToolTipText("");
		tfUsuario.setBounds(114, 87, 157, 26);
		getContentPane().add(tfUsuario);
		tfUsuario.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(VentanaLogin.class.getResource("/iconos/User-32.png")));
		lblNewLabel.setBounds(55, 81, 32, 32);
		getContentPane().add(lblNewLabel);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(VentanaLogin.class.getResource("/iconos/Key-32.png")));
		label.setBounds(55, 141, 32, 32);
		getContentPane().add(label);
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(VentanaLogin.class.getResource("/iconos/Doctors Bag-32.png")));
		lblNewLabel_1.setBounds(90, 24, 32, 26);
		getContentPane().add(lblNewLabel_1);
		
		JButton btnIniciarSesin = new JButton("Iniciar Sesi\u00F3n");
		btnIniciarSesin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				verificarPerfil(e);
			}
		});
		btnIniciarSesin.setBounds(132, 213, 118, 23);
		getContentPane().add(btnIniciarSesin);
		
		JLabel lblFarmaciaUnmsm = new JLabel("FARMACIA UNMSM");
		lblFarmaciaUnmsm.setForeground(new Color(255, 51, 51));
		lblFarmaciaUnmsm.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblFarmaciaUnmsm.setBounds(132, 24, 140, 26);
		getContentPane().add(lblFarmaciaUnmsm);
		
		tfPass = new JPasswordField();
		tfPass.setBounds(114, 147, 157, 26);
		getContentPane().add(tfPass);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblUsuario.setBounds(114, 72, 46, 14);
		getContentPane().add(lblUsuario);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblContrasea.setBounds(114, 131, 65, 14);
		getContentPane().add(lblContrasea);
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
