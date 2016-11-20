package farmacia;

import java.io.FileOutputStream;

import javax.swing.JOptionPane;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import listas.ListaDevolucion;
import listas.ListaLaboratorio;
import listas.ListaMedicamento;
import listas.ListaPresentacion;
import listas.ListaUsuario;
import listas.ListaVenta;
import listas.NodoDevolucion;
import listas.NodoLaboratorio;
import listas.NodoMedicamento;
import listas.NodoPresentacion;
import listas.NodoUsuario;
import listas.NodoVenta;

public class EscribirArchivo {

	public static void escribirArchivoMedicamentos(ListaMedicamento lista){
		
		HSSFWorkbook libro = new HSSFWorkbook();		//Creamos una instancia de la clase HSSFWorkbook llamada libro
        
        HSSFSheet hoja = libro.createSheet("Medicamentos");			//Creamos una instancia de la clase HSSFSheet llamada hoja y la creamos     
        
        NodoMedicamento aux = lista.getInicio();
        
        HSSFRow fila = hoja.createRow(0);				//Creamos una instancia de la clase HSSFRow llamada fila y creamos la fila con el indice 0
        
        HSSFCell celda1 = fila.createCell(0);
        HSSFCell celda2 = fila.createCell(1);
        HSSFCell celda3 = fila.createCell(2);
        HSSFCell celda4 = fila.createCell(3);
        HSSFCell celda5 = fila.createCell(4);
        HSSFCell celda6 = fila.createCell(5);
        HSSFCell celda7 = fila.createCell(6);
        HSSFCell celda8 = fila.createCell(7);
        HSSFCell celda9= fila.createCell(8);
        
        HSSFRichTextString Codigo = new HSSFRichTextString("CODIGO");
    	HSSFRichTextString Nombre = new HSSFRichTextString("NOMBRE");
    	HSSFRichTextString Labo = new HSSFRichTextString("LABORATORIO");
    	HSSFRichTextString Cantidad = new HSSFRichTextString("CANTIDAD");
    	HSSFRichTextString Presentacion = new HSSFRichTextString("PRESENTACION");
    	HSSFRichTextString Fecha = new HSSFRichTextString("FECHA");
    	HSSFRichTextString Precio = new HSSFRichTextString("P/VENTA");
    	HSSFRichTextString Costo = new HSSFRichTextString("P/COMPRA");
    	HSSFRichTextString Dolencia = new HSSFRichTextString("DOLENCIA");
    		
    	celda1.setCellValue(Codigo);
    	celda2.setCellValue(Nombre);
    	celda3.setCellValue(Labo);
    	celda4.setCellValue(Cantidad);
    	celda5.setCellValue(Presentacion);
    	celda6.setCellValue(Fecha);
    	celda7.setCellValue(Precio);
    	celda8.setCellValue(Costo);
    	celda9.setCellValue(Dolencia);
        
        int i = 1;
        
        while(aux!=null){
        	
        	
        	fila = hoja.createRow(i);				//Creamos una instancia de la clase HSSFRow llamada fila y creamos la fila con el indice 0
            
        	HSSFCell celdaUno = fila.createCell(0);
            HSSFCell celdaDos = fila.createCell(1);
            HSSFCell celdaTres = fila.createCell(2);
            HSSFCell celdaCuatro = fila.createCell(3);
            HSSFCell celdaCinco = fila.createCell(4);
            HSSFCell celdaSeis = fila.createCell(5);
            HSSFCell celdaSiete = fila.createCell(6);
            HSSFCell celdaOcho = fila.createCell(7);
            HSSFCell celdaNueve= fila.createCell(8);
            	
            HSSFRichTextString txtCodigo = new HSSFRichTextString(Integer.toString(aux.getCodigo()));
            HSSFRichTextString txtNombre = new HSSFRichTextString(aux.getNombre());
            HSSFRichTextString txtLabo = new HSSFRichTextString(aux.getLaboratorio());
            HSSFRichTextString txtCantidad = new HSSFRichTextString(Integer.toString(aux.getCantidad()));
            HSSFRichTextString txtCategoria = new HSSFRichTextString(aux.getPresentacion());
            HSSFRichTextString txtFecha = new HSSFRichTextString(aux.getFecha());
            HSSFRichTextString txtPrecio = new HSSFRichTextString(Double.toString(aux.getPrecio()));
            HSSFRichTextString txtCosto = new HSSFRichTextString(Double.toString(aux.getCosto()));
            HSSFRichTextString txtDolencia = new HSSFRichTextString(aux.getDolencia());
            		
            celdaUno.setCellValue(txtCodigo);
           	celdaDos.setCellValue(txtNombre);
           	celdaTres.setCellValue(txtLabo);
           	celdaCuatro.setCellValue(txtCantidad);
           	celdaCinco.setCellValue(txtCategoria);
           	celdaSeis.setCellValue(txtFecha);
           	celdaSiete.setCellValue(txtPrecio);
           	celdaOcho.setCellValue(txtCosto);
           	celdaNueve.setCellValue(txtDolencia);
            	
            
           	aux=aux.getSiguiente();
           	i++;
                  	   
        } 
        
        try{
            FileOutputStream archivo = new FileOutputStream("medicamentos.xls");
            libro.write(archivo);
            archivo.close();
           
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "No se pudo crear el Excel :(", "Error",2);
        }
	}
	
	public static void escribirArchivoLaboratorios(ListaMedicamento lista){   
		
        HSSFWorkbook libro = new HSSFWorkbook();		//Creamos una instancia de la clase HSSFWorkbook llamada libro
         
        HSSFSheet hoja = libro.createSheet("Laboratorios");			//Creamos una instancia de la clase HSSFSheet llamada Laboratorios y la creamos     
      
        NodoMedicamento aux = lista.getInicio();
        
        HSSFRow fila = hoja.createRow(0);	
        
        HSSFCell celda1 = fila.createCell(0);
        
        HSSFRichTextString lab = new HSSFRichTextString("LABORATORIOS");

    	celda1.setCellValue(lab);
        
        int i = 1;
        
        while(aux!=null){
        	
        	
        	fila = hoja.createRow(i);				//Creamos una instancia de la clase HSSFRow llamada fila y creamos la fila con el indice 0
            
            HSSFCell celdaUno = fila.createCell(0);			// Creamos la celda
        	
        	HSSFRichTextString txtNombre = new HSSFRichTextString(aux.getNombre());  // Se da formato al string

        		
        	celdaUno.setCellValue(txtNombre);				// Se escribe en la celda
        	
        
        	aux=aux.getSiguiente();
        	i++;
        } 
        
        try{
            FileOutputStream archivo = new FileOutputStream("medicamentos.xls");
            libro.write(archivo);
            archivo.close();
           
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "No se pudo crear el Excel :(", "Error",2);
        }
    }
	
	public static void escribirArchivoUsuarios(ListaUsuario lista){   
		
        HSSFWorkbook libro = new HSSFWorkbook();		//Creamos una instancia de la clase HSSFWorkbook llamada libro
        
        HSSFSheet hoja = libro.createSheet("Usuarios");			//Creamos una instancia de la clase HSSFSheet llamada Laboratorios y la creamos     
      
        NodoUsuario aux = lista.getInicio();
        
        HSSFRow fila = hoja.createRow(0);	// CREA FILA 0
        
        HSSFCell celda1 = fila.createCell(0);
        
        HSSFRichTextString lab = new HSSFRichTextString("USUARIOS"); 

    	celda1.setCellValue(lab); // GUARDAR EN LA CELDA
        
        int i = 1;
        
        while(aux!=null){
        	
        	fila = hoja.createRow(i);				//Creamos una instancia de la clase HSSFRow llamada fila y creamos la fila con el indice 0
            
        	HSSFCell celdaUno = fila.createCell(0);
            HSSFCell celdaDos = fila.createCell(1);
            HSSFCell celdaTres = fila.createCell(2);
            HSSFCell celdaCuatro = fila.createCell(3);
            HSSFCell celdaCinco = fila.createCell(4);
            HSSFCell celdaSeis = fila.createCell(5);
            HSSFCell celdaSiete = fila.createCell(6);
            HSSFCell celdaOcho = fila.createCell(7);

            	
            HSSFRichTextString txtCodigo = new HSSFRichTextString(Integer.toString(aux.getCodigo()));
            HSSFRichTextString txtCargo = new HSSFRichTextString(aux.getCargo());
            HSSFRichTextString txtNombre = new HSSFRichTextString(aux.getNombre());
            HSSFRichTextString txtApellido = new HSSFRichTextString(aux.getApellido());
            HSSFRichTextString txtDir = new HSSFRichTextString(aux.getDireccion());
            HSSFRichTextString txtTel= new HSSFRichTextString(aux.getTelefono());
            HSSFRichTextString txtUsuario = new HSSFRichTextString(aux.getUsuario());
            HSSFRichTextString txtPass = new HSSFRichTextString(aux.getPassword());

            		
            celdaUno.setCellValue(txtCodigo);
           	celdaDos.setCellValue(txtCargo);
           	celdaTres.setCellValue(txtNombre);
           	celdaCuatro.setCellValue(txtApellido);
           	celdaCinco.setCellValue(txtDir);
           	celdaSeis.setCellValue(txtTel);
           	celdaSiete.setCellValue(txtUsuario);
           	celdaOcho.setCellValue(txtPass);
            
           	aux=aux.getSiguiente();
           	i++;
        	
        } 
        
        try{
            FileOutputStream archivo = new FileOutputStream("usuarios.xls");
            libro.write(archivo);
            archivo.close();
           
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "No se pudo crear el Excel :(", "Error",2);
        }
    }
	
	public static void escribirArchivoLaboratorio(ListaLaboratorio lista){
		
		HSSFWorkbook libro = new HSSFWorkbook();
		
		HSSFSheet hoja = libro.createSheet("Laboratorio");
		
		NodoLaboratorio aux = lista.getInicio();
		
		HSSFRow fila = hoja.createRow(0);
		
		HSSFCell celda1 = fila.createCell(0);
		
		HSSFRichTextString lab = new HSSFRichTextString("Laboratorios");
		
		celda1.setCellValue(lab);
		
		int i = 1;
		
		while(aux!=null){
			
			fila = hoja.createRow(i);
			
			HSSFCell celdaL = fila.createCell(0);
			
			HSSFRichTextString txtLaboratorio = new HSSFRichTextString(aux.getLaboratorio());
			
			celdaL.setCellValue(txtLaboratorio);
			
			aux= aux.getSiguiente();
			
			i++;
			
		}
		
		try{
			FileOutputStream archivo = new FileOutputStream("laboratorios.xls");
            libro.write(archivo);
            archivo.close();
            
		}catch(Exception e){
			
            JOptionPane.showMessageDialog(null, "No se pudo crear el Excel :(", "Error",2);
        }
		
	}
	
	public static void escribirArchivoPresentacion(ListaPresentacion lista){
		
		HSSFWorkbook libro = new HSSFWorkbook();
		
		HSSFSheet hoja = libro.createSheet("Presentacion");
		
		NodoPresentacion aux = lista.getInicio();
		
		HSSFRow fila = hoja.createRow(0);
		
		HSSFCell celda1 = fila.createCell(0);
		
		HSSFRichTextString lab = new HSSFRichTextString("Presentacion");
		
		celda1.setCellValue(lab);
		
		int i = 1;
		
		while(aux!=null){
			
			fila = hoja.createRow(i);
			
			HSSFCell celdaL = fila.createCell(0);
			
			HSSFRichTextString txtPresentacion = new HSSFRichTextString(aux.getPresentacion());
			
			celdaL.setCellValue(txtPresentacion);
			
			aux= aux.getSiguiente();
			
			i++;
			
		}
		
		try{
			FileOutputStream archivo = new FileOutputStream("presentacion.xls");
            libro.write(archivo);
            archivo.close();
            
		}catch(Exception e){
			
            JOptionPane.showMessageDialog(null, "No se pudo crear el Excel :(", "Error",2);
        }
		
	}
	
	public static void escribirArchivoVenta(ListaVenta lista){
		
		HSSFWorkbook libro = new HSSFWorkbook();		//Creamos una instancia de la clase HSSFWorkbook llamada libro
        
        HSSFSheet hoja = libro.createSheet("Venta");			//Creamos una instancia de la clase HSSFSheet llamada Laboratorios y la creamos     
      
        NodoVenta aux = lista.getInicio();
        
        HSSFRow fila = hoja.createRow(0);	// CREA FILA 0
        
        HSSFCell celda1 = fila.createCell(0);
        HSSFCell celda2 = fila.createCell(1);
        HSSFCell celda3 = fila.createCell(2);
        HSSFCell celda4 = fila.createCell(3);
        HSSFCell celda5 = fila.createCell(4);
        HSSFCell celda6 = fila.createCell(5);
        HSSFCell celda7 = fila.createCell(6);
        HSSFCell celda8 = fila.createCell(7);
        HSSFCell celda9= fila.createCell(8);
        
        HSSFRichTextString codigo = new HSSFRichTextString("Código"); 
        HSSFRichTextString nombre = new HSSFRichTextString("Producto");
        HSSFRichTextString cliente = new HSSFRichTextString("Cliente");
        HSSFRichTextString presentacion = new HSSFRichTextString("Presentación");
        HSSFRichTextString cantidad = new HSSFRichTextString("Cantidad");
        HSSFRichTextString precio = new HSSFRichTextString("P/Venta");
        HSSFRichTextString subtotal = new HSSFRichTextString("Subtotal");
        HSSFRichTextString descuento = new HSSFRichTextString("Descuento");
        HSSFRichTextString fecha = new HSSFRichTextString("Fecha");


    	celda1.setCellValue(codigo); // GUARDAR EN LA CELDA
    	celda2.setCellValue(nombre);
    	celda3.setCellValue(cliente);
    	celda4.setCellValue(presentacion);
    	celda5.setCellValue(cantidad);
    	celda6.setCellValue(precio);
    	celda7.setCellValue(subtotal);
    	celda8.setCellValue(descuento);
    	celda9.setCellValue(fecha);
        
        int i = 1;
        
        while(aux!=null){
        	
        	fila = hoja.createRow(i);				//Creamos una instancia de la clase HSSFRow llamada fila y creamos la fila con el indice 0
            
        	HSSFCell celdaUno = fila.createCell(0);
            HSSFCell celdaDos = fila.createCell(1);
            HSSFCell celdaTres = fila.createCell(2);
            HSSFCell celdaCuatro = fila.createCell(3);
            HSSFCell celdaCinco = fila.createCell(4);
            HSSFCell celdaSeis = fila.createCell(5);
            HSSFCell celdaSiete = fila.createCell(6);
            HSSFCell celdaOcho = fila.createCell(7);
            HSSFCell celdaNueve = fila.createCell(8);

            	
            HSSFRichTextString txtCodigo = new HSSFRichTextString(Integer.toString(aux.getCodigo()));
            HSSFRichTextString txtNombre = new HSSFRichTextString(aux.getNombre());
            HSSFRichTextString txtCantidad = new HSSFRichTextString(Integer.toString(aux.getCantidad()));
            HSSFRichTextString txtPresentacion = new HSSFRichTextString(aux.getPresentacion());
            HSSFRichTextString txtPrecio = new HSSFRichTextString(Double.toString(aux.getPrecio()));
            HSSFRichTextString txtSubtotal= new HSSFRichTextString(Double.toString(aux.getSubtotal()));
            HSSFRichTextString txtCliente = new HSSFRichTextString(aux.getCliente());
            HSSFRichTextString txtDescuento = new HSSFRichTextString(Double.toString(aux.getDescuento()));
            HSSFRichTextString txtFecha= new HSSFRichTextString(aux.getFecha());

            		
            celdaUno.setCellValue(txtCodigo);
           	celdaDos.setCellValue(txtNombre);
           	celdaTres.setCellValue(txtCliente);
           	celdaCuatro.setCellValue(txtPresentacion);
           	celdaCinco.setCellValue(txtCantidad);
           	celdaSeis.setCellValue(txtPrecio);
           	celdaSiete.setCellValue(txtSubtotal);
           	celdaOcho.setCellValue(txtDescuento);
           	celdaNueve.setCellValue(txtFecha);
           	aux=aux.getSiguiente();
           	i++;
        	
        } 
        
        try{
            FileOutputStream archivo = new FileOutputStream("ventas.xls");
            libro.write(archivo);
            archivo.close();
           
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "No se pudo crear el Excel :(", "Error",2);
        }
	}
	
	public static void escribirArchivoDevolucion(ListaDevolucion lista){
		
		HSSFWorkbook libro = new HSSFWorkbook();		//Creamos una instancia de la clase HSSFWorkbook llamada libro
        
        HSSFSheet hoja = libro.createSheet("Medicamentos");			//Creamos una instancia de la clase HSSFSheet llamada hoja y la creamos     
        
        NodoDevolucion aux = lista.getInicio();
        
        HSSFRow fila = hoja.createRow(0);				//Creamos una instancia de la clase HSSFRow llamada fila y creamos la fila con el indice 0
        
        HSSFCell celda1 = fila.createCell(0);
        HSSFCell celda2 = fila.createCell(1);
        HSSFCell celda3 = fila.createCell(2);
        HSSFCell celda4 = fila.createCell(3);
        HSSFCell celda5 = fila.createCell(4);
        HSSFCell celda6 = fila.createCell(5);
        HSSFCell celda7 = fila.createCell(6);
        
        HSSFRichTextString Codigo = new HSSFRichTextString("CODIGO");
    	HSSFRichTextString Nombre = new HSSFRichTextString("NOMBRE");
    	HSSFRichTextString Labo = new HSSFRichTextString("LABORATORIO");
    	HSSFRichTextString Cantidad = new HSSFRichTextString("CANTIDAD");
    	HSSFRichTextString Presentacion = new HSSFRichTextString("PRESENTACION");
    	HSSFRichTextString Precio = new HSSFRichTextString("P/VENTA");
    	HSSFRichTextString Razon = new HSSFRichTextString("RAZoN");
    		
    	celda1.setCellValue(Codigo);
    	celda2.setCellValue(Nombre);
    	celda3.setCellValue(Labo);
    	celda4.setCellValue(Cantidad);
    	celda5.setCellValue(Presentacion);
    	celda6.setCellValue(Precio);
    	celda7.setCellValue(Razon);
        
        int i = 1;
        
        while(aux!=null){
        	
        	
        	fila = hoja.createRow(i);				//Creamos una instancia de la clase HSSFRow llamada fila y creamos la fila con el indice 0
            
        	HSSFCell celdaUno = fila.createCell(0);
            HSSFCell celdaDos = fila.createCell(1);
            HSSFCell celdaTres = fila.createCell(2);
            HSSFCell celdaCuatro = fila.createCell(3);
            HSSFCell celdaCinco = fila.createCell(4);
            HSSFCell celdaSeis = fila.createCell(5);
            HSSFCell celdaSiete = fila.createCell(6);
            	
            HSSFRichTextString txtCodigo = new HSSFRichTextString(Integer.toString(aux.getCodigo()));
            HSSFRichTextString txtNombre = new HSSFRichTextString(aux.getNombre());
            HSSFRichTextString txtLabo = new HSSFRichTextString(aux.getLaboratorio());
            HSSFRichTextString txtCantidad = new HSSFRichTextString(Integer.toString(aux.getCantidad()));
            HSSFRichTextString txtCategoria = new HSSFRichTextString(aux.getPresentacion());
            HSSFRichTextString txtPrecio = new HSSFRichTextString(Double.toString(aux.getPrecio()));
            HSSFRichTextString txtRazon = new HSSFRichTextString(aux.getRazon());
            		
            celdaUno.setCellValue(txtCodigo);
           	celdaDos.setCellValue(txtNombre);
           	celdaTres.setCellValue(txtLabo);
           	celdaCuatro.setCellValue(txtCantidad);
           	celdaCinco.setCellValue(txtCategoria);
           	celdaSeis.setCellValue(txtPrecio);
           	celdaSiete.setCellValue(txtRazon);
            	
            
           	aux=aux.getSiguiente();
           	i++;
                  	   
        } 
        
        try{
            FileOutputStream archivo = new FileOutputStream("devolucion.xls");
            libro.write(archivo);
            archivo.close();
           
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "No se pudo crear el Excel :(", "Error",2);
        }
	}
}
