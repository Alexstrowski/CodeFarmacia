package farmacia;

import java.awt.HeadlessException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

public class ValidarCampo {
	
	public boolean validarCampo(JTextField tfNombre){
		
		if(tfNombre.getText().trim().compareTo("")==0){
			JOptionPane.showMessageDialog(null, "¡ El campo esta vacío !","Error",JOptionPane.ERROR_MESSAGE);
			tfNombre.requestFocusInWindow();
			return false;
		}
		
		return true;
	}

	public boolean validarNombre(JTextField tfNombre){
		
		if(tfNombre.getText().trim().compareTo("")==0){
			JOptionPane.showMessageDialog(null, "¡ El campo nombre esta vacío !","Error",JOptionPane.ERROR_MESSAGE);
			tfNombre.requestFocusInWindow();
			return false;
		}
		
		return true;
	}
	
	
	public boolean validarCantidad(JTextField tfCantidad){
		
		if(tfCantidad.getText().trim().compareTo("")==0){
			JOptionPane.showMessageDialog(null, "¡ El campo cantidad esta vacío !","Error",JOptionPane.ERROR_MESSAGE);
			tfCantidad.requestFocusInWindow();
			return false;
		}else{
			if(Integer.parseInt(tfCantidad.getText())<=0  ){
				JOptionPane.showMessageDialog(null, "¡ La cantidad no puede ser 0!","Error",JOptionPane.ERROR_MESSAGE);
				tfCantidad.requestFocusInWindow();
				return false;
			}
		}
		
		return true;
	}
	
	public boolean validarFecha(JDateChooser tfFecha){
		
		try {
			if(tfFecha.getDate()==null){
				JOptionPane.showMessageDialog(null, "¡ Seleccione una fecha !","Error",JOptionPane.ERROR_MESSAGE);
				return false;
			}else{
				if(evaluarFecha(tfFecha)<=0){
					JOptionPane.showMessageDialog(null, "¡ El producto esta vencido !","Error",JOptionPane.ERROR_MESSAGE);
					return false;
				}
			}
			
		} catch (HeadlessException e) {
			// TODO Bloque catch generado automáticamente
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Bloque catch generado automáticamente
			e.printStackTrace();
		}
		
		return true;
	}
	
	public boolean validarVenta(JTextField tfPrecio){
		
		if(tfPrecio.getText().trim().compareTo("")==0){
			JOptionPane.showMessageDialog(null, "¡ El campo P/Venta esta vacío !","Error",JOptionPane.ERROR_MESSAGE);
			tfPrecio.requestFocusInWindow();
			return false;
		}else{
			if(Double.parseDouble(tfPrecio.getText())<=0){
				JOptionPane.showMessageDialog(null, "¡ El precio no puede ser 0 !","Error",JOptionPane.ERROR_MESSAGE);
				tfPrecio.requestFocusInWindow();
				return false;
			}
		}
		return true;
	}
	
	public boolean validarCompra(JTextField tfCosto){
		
		if(tfCosto.getText().trim().compareTo("")==0){
			JOptionPane.showMessageDialog(null, "¡ El campo P/Compra esta vacío !","Error",JOptionPane.ERROR_MESSAGE);
			tfCosto.requestFocusInWindow();
			return false;
		}else{
			if(Double.parseDouble(tfCosto.getText())<=0){
				JOptionPane.showMessageDialog(null, "¡ El precio no puede ser 0 !","Error",JOptionPane.ERROR_MESSAGE);
				tfCosto.requestFocusInWindow();
				return false;
			}
		}
		return true;
	}
	
	public boolean validarDolencia(JTextField tfDolencia){
		
		if(tfDolencia.getText().trim().compareTo("")==0){
			JOptionPane.showMessageDialog(null, "¡ El campo dolencia esta vacio !","Error",JOptionPane.ERROR_MESSAGE);
			tfDolencia.requestFocusInWindow();
			return false;
		}
		
		return true;
	}
	
	private int evaluarFecha(JDateChooser tfFecha) throws ParseException{
		
		Date fechaActual = new Date();
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		fechaActual = dateFormat.parse(dateFormat.format(fechaActual));
		
		String dia = Integer.toString(tfFecha.getCalendar().get(Calendar.DAY_OF_MONTH));
		String mes = Integer.toString(tfFecha.getCalendar().get(Calendar.MONTH) + 1);
		String year = Integer.toString(tfFecha.getCalendar().get(Calendar.YEAR));
		Date calendario = dateFormat.parse(dia + "/" + mes+ "/" + year);
		
		
		return calendario.compareTo(fechaActual);
	}
}
