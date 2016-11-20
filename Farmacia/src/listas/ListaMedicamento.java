package listas;

public class ListaMedicamento {

	private NodoMedicamento inicio;
	private int tamanio;
  
    public void Lista(){
        inicio = null;
        tamanio = 0;
    }
    
    
    public NodoMedicamento getInicio() {
		return inicio;
	}

	public void setInicio(NodoMedicamento inicio) {
		this.inicio = inicio;
	}
  
	
	
    public boolean esVacia(){ 	// Consulta si la lista esta vacia.
        return inicio == null;
    }

    public int getTamanio(){
        return tamanio;
    }

    public void insertarFinal(int codigo,String nombre,String laboratorio, int cantidad, String presentacion, String fecha, double precio,double costo,String dolencia){
        
        NodoMedicamento nuevo = new NodoMedicamento();
        
        nuevo.setCodigo(codigo);
        nuevo.setNombre(nombre);
        nuevo.setLaboratorio(laboratorio);
        nuevo.setCantidad(cantidad);
        nuevo.setPresentacion(presentacion);
        nuevo.setFecha(fecha);
        nuevo.setPrecio(precio);
        nuevo.setCosto(costo);
        nuevo.setDolencia(dolencia);
       
        
        if (esVacia()) {
           
            inicio = nuevo;		 // Inicializa la lista agregando como inicio al nuevo nodo.
            
        }else{
           
            NodoMedicamento aux = inicio;
            
            while(aux.getSiguiente() != null){
                aux = aux.getSiguiente();
            }
            
            aux.setSiguiente(nuevo);	// Agrega el nuevo nodo al final de la lista.
        }
        
        tamanio++;
    }
    
    public void eliminar(int pos){
    	
    	
    	NodoMedicamento aux = inicio;
		NodoMedicamento p=null;
			
		if(pos==1){
			inicio=inicio.getSiguiente();
			aux=null;
		}
		else{
				
			
			int n=1;
				
			while(n!=pos){
				p=aux;
				aux=aux.getSiguiente();
				n++;
			}
			p.setSiguiente(aux.getSiguiente());
				
			aux=null;
		
		}
		
    }
    
    public int dimension(){
    	NodoMedicamento aux = inicio;
    	
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
            NodoMedicamento aux = inicio;
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
       
        NodoMedicamento aux = inicio;
       
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
    
    public NodoMedicamento buscarNodo(int referencia){
        
        NodoMedicamento aux = inicio;
       
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
    
    public void editarPorPosicion(int referencia, String nombre,String laboratorio, int cantidad, String presentacion, String fecha, double precio,double costo,String dolencia){
        
    	NodoMedicamento aux = inicio;
        
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
        
        aux.setNombre(nombre);
        aux.setLaboratorio(laboratorio);
        aux.setCantidad(cantidad);
        aux.setPresentacion(presentacion);
        aux.setFecha(fecha);
        aux.setPrecio(precio);
        aux.setCosto(costo);
        aux.setDolencia(dolencia);
        
    }
    
    public boolean verificarRepetido(String nombre,String laboratorio, String presentacion){
    	
    	NodoMedicamento aux = inicio;
    	
    	 while(aux!=null){
    		 
    		 if(aux.getNombre().toLowerCase().equals(nombre.toLowerCase()) && aux.getLaboratorio().toLowerCase().equals(laboratorio.toLowerCase()) && aux.getPresentacion().toLowerCase().equals(presentacion.toLowerCase())){
    			 return true;
    		 }
    		
			 aux=aux.getSiguiente();	
		 }
    	 
    	 return false;
    }
    
    public void devolverCantidad(int codigo,int cantidad){
    	
    	NodoMedicamento aux = inicio;
        
        boolean encontrado = false;
     
        while(aux != null && encontrado != true){
            
            if (codigo == aux.getCodigo()){
                
                aux.setCantidad(aux.getCantidad()+cantidad);
                encontrado=true;
            }
            else{
                
                aux = aux.getSiguiente();
            }
        }
    	
    }
    
    public void sacarCantidad(int codigo,int cantidad){
    	
    	NodoMedicamento aux = inicio;
        
        boolean encontrado = false;
     
        while(aux != null && encontrado != true){
            
            if (codigo == aux.getCodigo()){
                
                aux.setCantidad(aux.getCantidad()-cantidad);
                encontrado=true;
            }
            else{
                
                aux = aux.getSiguiente();
            }
        }
    	
    }
    
    public String [] retornarArregloPre(){
    	String arreglo [] = new String[dimension()];
    	int i=0;
    	
    	NodoMedicamento aux = inicio;
		 
		while(aux!=null){
			 
			 arreglo[i]=Integer.toString(aux.getCodigo());
			 aux=aux.getSiguiente(); 
			 i++;
		} 
    	
    	return arreglo;
    }
}
