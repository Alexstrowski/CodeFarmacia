package listas;

public class ListaVenta {

	private NodoVenta inicio;
	private int tamanio;
  
    public void Lista(){
        inicio = null;
        tamanio = 0;
    }
    
    
    public NodoVenta getInicio() {
		return inicio;
	}

	public void setInicio(NodoVenta inicio) {
		this.inicio = inicio;
	}
  
	
	
    public boolean esVacia(){ 	// Consulta si la lista esta vacia.
        return inicio == null;
    }

    public int getTamanio(){
        return tamanio;
    }

    public void insertarFinal(int codigo,String nombre, int cantidad, String presentacion,double precio,double subtotal){
        
        NodoVenta nuevo = new NodoVenta();
        
        nuevo.setCodigo(codigo);
        nuevo.setNombre(nombre);
        nuevo.setCantidad(cantidad);
        nuevo.setPresentacion(presentacion);
        nuevo.setPrecio(precio);
        nuevo.setSubtotal(subtotal);
       
        
        if (esVacia()) {
           
            inicio = nuevo;		 // Inicializa la lista agregando como inicio al nuevo nodo.
            
        }else{
           
            NodoVenta aux = inicio;
            
            while(aux.getSiguiente() != null){
                aux = aux.getSiguiente();
            }
            
            aux.setSiguiente(nuevo);	// Agrega el nuevo nodo al final de la lista.
        }
        
        tamanio++;
    }
    
    public void insertarNodo(NodoVenta nodoNuevo){
        
        NodoVenta nuevo = nodoNuevo;
        
        
        if (esVacia()) {
           
            inicio = nuevo;		 // Inicializa la lista agregando como inicio al nuevo nodo.
            
        }else{
           
            NodoVenta aux = inicio;
            
            while(aux.getSiguiente() != null){
                aux = aux.getSiguiente();
            }
            
            aux.setSiguiente(nuevo);	// Agrega el nuevo nodo al final de la lista.
        }
        
        tamanio++;
    }
    
    public void eliminar(int pos){
    	NodoVenta aux = inicio;
    	int n=1;
    	while(n!=pos ){
    		aux=aux.getSiguiente();
    		n++;
    	}
    	
        aux.setCantidad(0);
        aux.setPresentacion("");
        aux.setPrecio(0);
        
    }
    
    public int dimension(){
    	NodoVenta aux = inicio;
    	
    	int i = 0;
    	
    	while(aux!=null){
    		aux=aux.getSiguiente();
    		i++;
    	}
    	
    	return i;
    }
    
    public void listar(){
        // Verifica si la lista contiene elementoa.
        if (!esVacia()) {
            // Crea una copia de la lista.
            NodoVenta aux = inicio;
            // Posicion de los elementos de la lista.
            int i = 0;
            // Recorre la lista hasta el final.
            while(aux != null){
                // Imprime en pantalla el valor del nodo.
                System.out.print(i + ".[ " + aux.getNombre() + " ]" + " ->  ");
                // Avanza al siguiente nodo.
                aux = aux.getSiguiente();
                // Incrementa el contador de la posión.
                i++;
            }
        }
    }
    
    public boolean buscar(int referencia){
       
        NodoVenta aux = inicio;
       
        boolean encontrado = false;
     
        while(aux != null && encontrado != true){
            
            if (referencia == aux.getCodigo()){
                
                encontrado = true;
            }
            else{
                
                aux = aux.getSiguiente();
            }
        }
        
        return encontrado;
    }
    
    public NodoVenta buscarNodo(int referencia){
        
        NodoVenta aux = inicio;
       
        boolean encontrado = false;
     
        while(aux != null && encontrado != true){
            
            if (referencia == aux.getCodigo()){
                
                encontrado = true;
            }
            else{
                
                aux = aux.getSiguiente();
            }
        }
        
        return aux;
    }
    
    public void editarPorPosicion(int referencia,int cantidad){
        
    	NodoVenta aux = inicio;
        
        boolean encontrado = false;
     
        while(aux != null && encontrado != true){
            
            if (referencia == aux.getCodigo()){
                
                encontrado = true;
            }
            else{
                
                aux = aux.getSiguiente();
            }
        }
        
            // Actualizamos el valor del nodo
        

        aux.setCantidad(cantidad);

        
    }
}
