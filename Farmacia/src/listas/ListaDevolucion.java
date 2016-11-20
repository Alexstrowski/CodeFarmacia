package listas;

public class ListaDevolucion {
	private NodoDevolucion inicio;
	private int tamanio;
	
	public void Lista(){
	        inicio = null;
	        tamanio = 0;
	}
	 
	public NodoDevolucion getInicio() {
		return inicio;
	}

	public void setInicio(NodoDevolucion inicio) {
		this.inicio = inicio;
	}
		
	public boolean esVacia(){ 	// Consulta si la lista esta vacia.
		return inicio == null;
    }

    public int getTamanio(){
    	return tamanio;
    }
    
    public void insertarFinal(int codigo, String nombre, String laboratorio,int cantidad,String presentacion,double precio,String razon){
        
        NodoDevolucion nuevo = new NodoDevolucion();
        
        nuevo.setCodigo(codigo);
        nuevo.setNombre(nombre);
        nuevo.setLaboratorio(laboratorio);
        nuevo.setCantidad(cantidad);
        nuevo.setPresentacion(presentacion);
        nuevo.setPrecio(precio);
        nuevo.setRazon(razon);
        
        if (esVacia()) {
           
            inicio = nuevo;		 // Inicializa la lista agregando como inicio al nuevo nodo.
            
        }else{
           
            NodoDevolucion aux = inicio;
            
            while(aux.getSiguiente() != null){
                aux = aux.getSiguiente();
            }
            
            aux.setSiguiente(nuevo);	// Agrega el nuevo nodo al final de la lista.
        }
        
        tamanio++;
    }
}
