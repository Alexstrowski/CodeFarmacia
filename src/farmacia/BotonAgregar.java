package farmacia;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import listas.ListaMedicamento;

public class BotonAgregar {

	
	public void agregarMedicamento(ListaMedicamento lista,DefaultTableModel dtm,int codigo,String nombre,String laboratorio,int cantidad,String categoria,String fecha, double precio, double costo,String dolencia){
	
		
		
		lista.insertarFinal(codigo,nombre, laboratorio, cantidad, categoria, fecha, precio,costo,dolencia);
		
		Object[] newRow={codigo,nombre,laboratorio,cantidad,categoria,fecha,precio,costo,dolencia};
		dtm.addRow(newRow);
		
		
		JOptionPane.showMessageDialog(null, "AGREGADO");
	}
}
