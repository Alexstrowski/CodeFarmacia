package farmacia;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import java.awt.CardLayout;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import java.awt.Font;

import javax.swing.table.DefaultTableModel;

import javax.swing.table.TableRowSorter;

import listas.ListaLaboratorio;
import listas.ListaMedicamento;
import listas.ListaPresentacion;
import listas.ListaUsuario;
import listas.ListaVenta;
import listas.NodoMedicamento;
import paneles.PanelDevolucion;
import paneles.PanelLaboratorio;
import paneles.PanelMedicamentos;
import paneles.PanelPresentacion;
import paneles.PanelReporte;
import paneles.PanelUsuario;
import paneles.PanelVenta;

import javax.swing.JTextField;

import javax.swing.JComboBox;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


import javax.swing.JTable;

import com.toedter.calendar.JDateChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class VentanaMenu extends JFrame {

	private JPanel contentPane;

	private JPanel panelPerfil;
	private JPanel panelBotonesFarma;
	private JPanel panelBotones;
	private JPanel panelesAdmi;
	private JPanel panelesFarmaceutico;
	private JButton btnMedicamentos;
	private JButton btnLab;
	private JButton btnUsuarios;
	private JButton btnVenta;
	private JButton btnPresentacion;
	private PanelMedicamentos pm;
	
	
	ListaMedicamento listaM = new ListaMedicamento();
	ListaUsuario listaU = new ListaUsuario();
	ListaVenta listaV = new ListaVenta();
	ListaLaboratorio listaL = new ListaLaboratorio();
	ListaPresentacion listaP = new ListaPresentacion();
	private JButton btnReporte;
	private JButton btnDevolucion;
	
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaMenu frame = new VentanaMenu(0);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	


	public VentanaMenu(int num) {
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 712, 601);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		setResizable(false);
		setTitle("Menú");
		
		

		//<-------------------------------------------------------------------- PANEL DE USUARIOS --------------------------------------------------------------------------------->

		panelPerfil = new JPanel();
		contentPane.add(panelPerfil, BorderLayout.CENTER);
		panelPerfil.setLayout(new CardLayout(0, 0));
		
		panelBotones = new JPanel();
		panelBotones.setBackground(Color.LIGHT_GRAY);
		panelPerfil.add(panelBotones, "panelBotones");
		panelBotones.setLayout(null);
		
		panelBotonesFarma = new JPanel();
		panelPerfil.add(panelBotonesFarma, "panelBotonesFarma");
		panelBotonesFarma.setLayout(null);
		
		botonesPerfil(num);
		
		//<------------------------------------------------------------------------ BOTONES ------------------------------------------------------------------------------------>
		
		btnMedicamentos = new JButton("Medicamentos");
		btnMedicamentos.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnMedicamentos.setHorizontalTextPosition(SwingConstants.CENTER);
		btnMedicamentos.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnMedicamentos.setIcon(new ImageIcon(VentanaMenu.class.getResource("/iconos/Pill-32.png")));
		btnMedicamentos.setBounds(0, 0, 118, 83);
		btnMedicamentos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				botonesAdmi(e);
			}
		});
		panelBotones.add(btnMedicamentos);
		
		
		btnLab = new JButton("Laboratorios");
		btnLab.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnLab.setHorizontalTextPosition(SwingConstants.CENTER);
		btnLab.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnLab.setIcon(new ImageIcon(VentanaMenu.class.getResource("/iconos/Test Tube Filled-32.png")));
		btnLab.setBounds(115, 0, 118, 83);
		btnLab.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				botonesAdmi(e);
			}
		});
		panelBotones.add(btnLab);
		
		
		btnPresentacion = new JButton("Presentaci\u00F3n");
		btnPresentacion.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				botonesAdmi(e);
			}
		});
		btnPresentacion.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnPresentacion.setHorizontalTextPosition(SwingConstants.CENTER);
		btnPresentacion.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnPresentacion.setIcon(new ImageIcon(VentanaMenu.class.getResource("/iconos/Training-32.png")));
		btnPresentacion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnPresentacion.setBounds(231, 0, 118, 83);
		panelBotones.add(btnPresentacion);
		
		btnUsuarios = new JButton("Usuarios");
		btnUsuarios.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
					botonesAdmi(e);		
			}
		});
		btnUsuarios.setHorizontalTextPosition(SwingConstants.CENTER);
		btnUsuarios.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnUsuarios.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnUsuarios.setIcon(new ImageIcon(VentanaMenu.class.getResource("/iconos/Add User Group Woman Man-32.png")));
		btnUsuarios.setBounds(347, 0, 118, 83);
		panelBotones.add(btnUsuarios);
		
		btnReporte = new JButton("Reporte");
		btnReporte.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				botonesAdmi(e);
			}
		});
		btnReporte.setHorizontalTextPosition(SwingConstants.CENTER);
		btnReporte.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnReporte.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnReporte.setForeground(new Color(0, 0, 0));
		btnReporte.setIcon(new ImageIcon(VentanaMenu.class.getResource("/iconos/Banknotes-32.png")));
		btnReporte.setBounds(463, 0, 118, 83);
		panelBotones.add(btnReporte);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaLogin vm = new VentanaLogin();
				vm.setVisible(true);	
				dispose();
			}
		});
		btnSalir.setIcon(new ImageIcon(VentanaMenu.class.getResource("/iconos/Exit Sign-32.png")));
		btnSalir.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnSalir.setHorizontalTextPosition(SwingConstants.CENTER);
		btnSalir.setForeground(Color.BLACK);
		btnSalir.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnSalir.setBounds(579, 0, 118, 83);
		panelBotones.add(btnSalir);
		
		//<---------------------------------------------------------------PANEL DE LOS BOTONES ---------------------------------------------------------------------->

		//<---------------------------------------------------------------PANEL ADMI -------------------------------------------------------------------------------->
		
		cargarArchivo(listaL);
		cargarArchivo(listaP);
		cargarArchivo(listaV);
		
		
		panelesAdmi = new JPanel();
		panelesAdmi.setBounds(0, 83, 697, 484);
		panelBotones.add(panelesAdmi);
		panelesAdmi.setLayout(new CardLayout(0, 0));
		
		pm = new PanelMedicamentos(listaM,listaL,listaP);
		JPanel panelMedicamentos = pm;
		panelesAdmi.add(panelMedicamentos, "panelMedicamentos");
		
		PanelUsuario pu = new PanelUsuario(listaU);
		JPanel panelUsuarios = pu;
		panelesAdmi.add(panelUsuarios, "panelUsuarios");
		
		PanelLaboratorio pl = new PanelLaboratorio(listaL);
		JPanel panelLaboratorios = pl;
		panelesAdmi.add(panelLaboratorios, "panelLaboratorios");
		
		PanelPresentacion pp = new PanelPresentacion(listaP);
		JPanel panelPresentacion = pp;
		panelesAdmi.add(panelPresentacion, "panelPresentacion");
		
		PanelReporte pr = new PanelReporte(listaV);
		JPanel panelReporte = pr;
		panelesAdmi.add(panelReporte, "panelReporte");
		
		//<---------------------------------------------------------------PANEL FARMACEUTICO -------------------------------------------------------------------------->
		
		
		
		btnVenta = new JButton("Venta");
		btnVenta.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				botonesFarma(e);
			}
		});

		btnVenta.setIcon(new ImageIcon(VentanaMenu.class.getResource("/iconos/Sell-32.png")));
		btnVenta.setBounds(0, 0, 118, 83);
		btnVenta.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnVenta.setHorizontalTextPosition(SwingConstants.CENTER);
		btnVenta.setFont(new Font("Tahoma", Font.BOLD, 11));
		panelBotonesFarma.add(btnVenta);
		
		panelesFarmaceutico = new JPanel();
		panelesFarmaceutico.setBounds(0, 81, 697, 484);
		panelBotonesFarma.add(panelesFarmaceutico);
		panelesFarmaceutico.setLayout(new CardLayout(0, 0));
		
		PanelVenta pv = new PanelVenta(listaM,listaV);
		JPanel panelVenta = pv;
		panelesFarmaceutico.add(panelVenta,"panelVenta");
		
		PanelDevolucion pd = new PanelDevolucion(listaL,listaP,listaM);
		JPanel panelDevolucion = pd;
		panelesFarmaceutico.add(panelDevolucion, "panelDevolucion");
		
		JButton btnSalir2 = new JButton("Salir");
		btnSalir2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaLogin vm = new VentanaLogin();
				vm.setVisible(true);	
				dispose();
			}
		});
		btnSalir2.setIcon(new ImageIcon(VentanaMenu.class.getResource("/iconos/Exit Sign-32.png")));
		btnSalir2.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnSalir2.setHorizontalTextPosition(SwingConstants.CENTER);
		btnSalir2.setForeground(Color.BLACK);
		btnSalir2.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnSalir2.setBounds(233, 0, 118, 83);
		panelBotonesFarma.add(btnSalir2);
		
		btnDevolucion = new JButton("Devolucion");
		btnDevolucion.setIcon(new ImageIcon(VentanaMenu.class.getResource("/iconos/Refund-32.png")));
		btnDevolucion.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				botonesFarma(e);
			}
		});
		btnDevolucion.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnDevolucion.setHorizontalTextPosition(SwingConstants.CENTER);
		btnDevolucion.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnDevolucion.setBounds(117, 0, 118, 83);
		panelBotonesFarma.add(btnDevolucion);
		
		
				
	}
	
	
	private void botonesAdmi(java.awt.event.MouseEvent evt){
		if(evt.getSource()==btnMedicamentos){
			((CardLayout)panelesAdmi.getLayout()).show(panelesAdmi,"panelMedicamentos");
			pm.obtenerListaLabo(listaL);
			pm.obtenerListaPresentacion(listaP);
		}else{
			if(evt.getSource()==btnLab){
				((CardLayout)panelesAdmi.getLayout()).show(panelesAdmi,"panelLaboratorios");
			}else{
				if(evt.getSource()==btnUsuarios){
					((CardLayout)panelesAdmi.getLayout()).show(panelesAdmi,"panelUsuarios");
				}else{
					if(evt.getSource()==btnPresentacion){
						((CardLayout)panelesAdmi.getLayout()).show(panelesAdmi,"panelPresentacion");
					}else{
						if(evt.getSource()==btnReporte){
							((CardLayout)panelesAdmi.getLayout()).show(panelesAdmi,"panelReporte");
						}
					}
				}
			}
			
			
		}
	}
	
	private void botonesFarma(MouseEvent evt){
		if(evt.getSource()==btnVenta){
			((CardLayout)panelesFarmaceutico.getLayout()).show(panelesFarmaceutico,"panelVenta");
		}else{
			if(evt.getSource()==btnDevolucion){
				((CardLayout)panelesFarmaceutico.getLayout()).show(panelesFarmaceutico,"panelDevolucion");
			}
		}
	}
	
	private void botonesPerfil(int num){
		if(num==0){
			((CardLayout)panelPerfil.getLayout()).show(panelPerfil,"panelBotones");
		}else{
			if(num==1){
				((CardLayout)panelPerfil.getLayout()).show(panelPerfil,"panelBotonesFarma");
			}	
		}
	}
	
	public void cargarArchivo(ListaLaboratorio lista){
		CargarArchivo.cargarArchivoLaboratorios(lista);
	}
	
	public void cargarArchivo(ListaPresentacion lista){
		CargarArchivo.cargarArchivoPresentacion(lista);
	}
	
	public void cargarArchivo(ListaVenta lista){
		CargarArchivo.cargarArchivoVentas(lista);
	}
}
	
