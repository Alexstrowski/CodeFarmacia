package listas;

public class NodoMedicamento {

	private String nombre;
	private String laboratorio;
	private int cantidad;
	private String presentacion;
	private String fecha;
	private double precio;
	private double costo;
	private int codigo; 
	private String dolencia;

	private NodoMedicamento siguiente;
 
    public NodoMedicamento(){
        this.nombre = "";
        this.laboratorio = "";
        this.cantidad = 0;
        this.presentacion = "";
        this.fecha = "";
        this.precio = 0;
        this.codigo = 0;
        this.dolencia = "";
        this.costo=0;
        this.siguiente = null;
    }
 
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getLaboratorio() {
		return laboratorio;
	}

	public void setLaboratorio(String laboratorio) {
		this.laboratorio = laboratorio;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public String getPresentacion() {
		return presentacion;
	}

	public void setPresentacion(String presentacion) {
		this.presentacion = presentacion;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public double getCosto() {
		return costo;
	}

	public void setCosto(double costo) {
		this.costo = costo;
	}

	public String getDolencia() {
		return dolencia;
	}

	public void setDolencia(String dolencia) {
		this.dolencia = dolencia;
	}
	
	public NodoMedicamento getSiguiente() {
		return siguiente;
	}

	public void setSiguiente(NodoMedicamento siguiente) {
		this.siguiente = siguiente;
	}
 
}
