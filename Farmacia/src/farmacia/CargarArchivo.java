package farmacia;

import java.io.File;
import java.io.IOException;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import listas.ListaLaboratorio;
import listas.ListaMedicamento;
import listas.ListaPresentacion;
import listas.ListaUsuario;
import listas.ListaVenta;

public class CargarArchivo {

	
	public static void cargarArchivoExcel(ListaMedicamento lista){
		

		File archivo = new File("medicamentos.xls");
		
		try {
			
			Workbook leerExcel = jxl.Workbook.getWorkbook(archivo);
			
			for(int hoja = 0 ; hoja<leerExcel.getNumberOfSheets(); hoja++){
				
				Sheet hojaP = leerExcel.getSheet(hoja);
				int columnas = hojaP.getColumns();
				int filas = hojaP.getRows();				
				
				String data[]= new String[columnas];
				
				for(int fila = 1; fila<filas; fila++){
					
					for(int columna = 0 ; columna<columnas ; columna++){
						
							data[columna]= hojaP.getCell(columna, fila).getContents();
							
					}
					lista.insertarFinal(Integer.parseInt(data[0]),data[1], data[2], Integer.parseInt(data[3]), data[4], data[5], Double.parseDouble(data[6]),Double.parseDouble(data[7]),data[8]);
				}
			}
			
			
		} catch (BiffException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	
	public static void cargarArchivoUsuarios(ListaUsuario lista){
		

		File archivo = new File("usuarios.xls");
		
		try {
			
			Workbook leerExcel = jxl.Workbook.getWorkbook(archivo);
			
			
				
				Sheet hojaP = leerExcel.getSheet("Usuarios");	// LEE LA HOJA DONDE GUARDA LOS DATOS
				int columnas = hojaP.getColumns();				// OBTIENE COLUMNAS
				int filas = hojaP.getRows();					// OBTIENE FILAS
				
				String data[]= new String[columnas];
				
				for(int fila = 1; fila<filas; fila++){
					
					for(int columna = 0 ; columna<columnas ; columna++){
						
							data[columna]= hojaP.getCell(columna, fila).getContents();
							
					}
					lista.insertarFinal(Integer.parseInt(data[0]),data[1], data[2], data[3], data[4], data[5],data[6],data[7]);
				}
			
			
			
		} catch (BiffException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	
	public static void cargarArchivoLaboratorios(ListaLaboratorio lista){
		File archivo = new File ("laboratorios.xls");
		
		try{
			Workbook leerExcel = jxl.Workbook.getWorkbook(archivo);
			Sheet hojaP = leerExcel.getSheet("Laboratorio");
			int columnas = hojaP.getColumns();			
			int filas = hojaP.getRows();					
			
			String data[]= new String[columnas];
			int columna=0;
			
			
			for(int fila = 1; fila<filas; fila++){
				
				data[columna]= hojaP.getCell(columna, fila).getContents();
				lista.insertarFinal(data[0]);
			}
			
		} catch (BiffException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}

	public static void cargarArchivoPresentacion(ListaPresentacion lista){
		File archivo = new File ("presentacion.xls");
		
		try{
			Workbook leerExcel = jxl.Workbook.getWorkbook(archivo);
			Sheet hojaP = leerExcel.getSheet("Presentacion");
			int columnas = hojaP.getColumns();			
			int filas = hojaP.getRows();					
			
			String data[]= new String[columnas];
			int columna=0;
			
			
			for(int fila = 1; fila<filas; fila++){
				
				data[columna]= hojaP.getCell(columna, fila).getContents();
				lista.insertarFinal(data[0]);
			}
			
		} catch (BiffException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	
	public static void cargarArchivoVentas(ListaVenta lista){
		
		File archivo = new File("ventas.xls");
		
		try {
			
			Workbook leerExcel = jxl.Workbook.getWorkbook(archivo);
			
			
				
				Sheet hojaP = leerExcel.getSheet("Venta");	// LEE LA HOJA DONDE GUARDA LOS DATOS
				int columnas = hojaP.getColumns();				// OBTIENE COLUMNAS
				int filas = hojaP.getRows();					// OBTIENE FILAS
				
				String data[]= new String[columnas];
				
				for(int fila = 1; fila<filas; fila++){
					
					for(int columna = 0 ; columna<columnas ; columna++){
						
							data[columna]= hojaP.getCell(columna, fila).getContents();
							
					}
					lista.insertarFinal(Integer.parseInt(data[0]),data[1],data[2],data[3],Integer.parseInt(data[4]),Double.parseDouble(data[5]),Double.parseDouble(data[6]),Double.parseDouble(data[7]),data[8]);
				}	
			
		} catch (BiffException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	
}
