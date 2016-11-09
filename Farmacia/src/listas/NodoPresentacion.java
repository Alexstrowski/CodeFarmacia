package listas;

public class NodoPresentacion {
	private String presentacion;
	private NodoPresentacion siguiente;
	
	public void Nodo(){
        this.setPresentacion("");
        this.setSiguiente(null);
    }

	public String getPresentacion() {
		return presentacion;
	}

	public void setPresentacion(String presentacion) {
		this.presentacion = presentacion;
	}

	public NodoPresentacion getSiguiente() {
		return siguiente;
	}

	public void setSiguiente(NodoPresentacion siguiente) {
		this.siguiente = siguiente;
	}

}
