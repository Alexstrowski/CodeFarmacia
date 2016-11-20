package listas;

public class NodoDevolucion {
	private int codigo;
	private String nombre;
	private int cantidad;
	private String laboratorio;
	private String presentacion;
	private double precio;
	private String razon;
	

	private NodoDevolucion siguiente;
	
	public NodoDevolucion(){
        this.nombre = "";
        this.cantidad = 0;
        this.precio = 0;
        this.siguiente = null;
    }
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
	public NodoDevolucion getSiguiente() {
		return siguiente;
	}

	public void setSiguiente(NodoDevolucion siguiente) {
		this.siguiente = siguiente;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getLaboratorio() {
		return laboratorio;
	}

	public void setLaboratorio(String laboratorio) {
		this.laboratorio = laboratorio;
	}

	public String getRazon() {
		return razon;
	}

	public void setRazon(String razon) {
		this.razon = razon;
	}

	public String getPresentacion() {
		return presentacion;
	}

	public void setPresentacion(String presentacion) {
		this.presentacion = presentacion;
	}
}
