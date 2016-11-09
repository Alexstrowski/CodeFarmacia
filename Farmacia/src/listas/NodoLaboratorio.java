package listas;

public class NodoLaboratorio {
	private String laboratorio;
	private NodoLaboratorio siguiente;
	
	public void Nodo(){
        this.laboratorio = "";
        this.siguiente = null;
    }
	
	/*public NodoLaboratorio(){
		this.laboratorio = "";
		this.siguiente = null;
	}*/
	public String getLaboratorio() {
		return laboratorio;
	}
	
	public void setLaboratorio(String laboratorio) {
		this.laboratorio = laboratorio;
	}
	
	public NodoLaboratorio getSiguiente() {
		return siguiente;
	}

	public void setSiguiente(NodoLaboratorio siguiente) {
		this.siguiente = siguiente;
	}

}
