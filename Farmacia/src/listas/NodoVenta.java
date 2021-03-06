package listas;

public class NodoVenta {

	private String nombre;
	private int cantidad;
	private String presentacion;
	private double precio;
	private int codigo; 
	private double subtotal;
	private String cliente;
	private double descuento;
	private String fecha;
	
	private NodoVenta siguiente;

	public NodoVenta(){
        this.nombre = "";
        this.cantidad = 0;
        this.presentacion = "";
        this.precio = 0;
        this.codigo = 0;
        this.subtotal=0;
        this.cliente="";
        this.fecha="";
        this.descuento=0;
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
	public String getPresentacion() {
		return presentacion;
	}
	public void setPresentacion(String presentacion) {
		this.presentacion = presentacion;
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
	public double getSubtotal() {
		return subtotal;
	}
	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}
	
	public NodoVenta getSiguiente() {
		return siguiente;
	}

	public void setSiguiente(NodoVenta siguiente) {
		this.siguiente = siguiente;
	}
	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	
	public double getDescuento() {
		return descuento;
	}

	public void setDescuento(double descuento) {
		this.descuento = descuento;
	}
}
