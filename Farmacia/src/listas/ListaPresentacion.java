package listas;

public class ListaPresentacion {
	private NodoPresentacion inicio;
	private int tamanio;
	
	public void Lista(){
	        inicio = null;
	        tamanio = 0;
	}
	
	public NodoPresentacion getInicio() {
		return inicio;
	}

	public void setInicio(NodoPresentacion inicio) {
		this.inicio = inicio;
	}
	
	public boolean esVacia(){ 	// Verifica si la lista esta vacia.
        return inicio == null;
    }
	
	public int getTamanio(){
        return tamanio;
    }
	
	public void insertarFinal(String presentacion){
		NodoPresentacion nuevo = new NodoPresentacion();
		
		nuevo.setPresentacion(presentacion);
		
		if(esVacia()){
			inicio = nuevo;                             //inicializa la lista agregando como inicio al nodo nuevo
		}
		else{
			NodoPresentacion aux = inicio;
			
			while(aux.getSiguiente()!=null){
				
				aux= aux.getSiguiente();	
			}
			
			aux.setSiguiente(nuevo);	                   // Agrega el nodo nuevo al final de la lista.
		}
		
		tamanio++;
	}
	
	public void eliminar(int pos){
			
		NodoPresentacion aux = inicio;
		NodoPresentacion p=null;
			
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
		NodoPresentacion aux = inicio;
		 int i = 0;
		 while(aux!=null){
			 aux=aux.getSiguiente();
			 i++;
		 }
		 
		 return i;
	}
	
	public void listar(){
		if(!esVacia()){
			NodoPresentacion aux=inicio;
			
			int i=0;
			
			while(aux!=null){
				System.out.print(i + ".[ " + aux.getPresentacion() + " ]" + " ->  ");
				aux=aux.getSiguiente();
				i++;
			}
		}else{
			System.out.println("Lista vacia");
		}
	}
	
    public NodoPresentacion buscarNodo(int referencia){
        
        NodoPresentacion aux = inicio;
        
        for(int i=0; i<referencia-1;i++){
        	aux=aux.getSiguiente();
        }
        
        return aux;
    }
    
    public void editarPorPosicion(int referencia, String laboratorio){
    	NodoPresentacion aux = inicio;
        
        for(int i=0; i<referencia-1;i++){
        	aux=aux.getSiguiente();
        }
    	aux.setPresentacion(laboratorio);
    }
	
    public String [] retornarArregloPre(){
    	String arreglo [] = new String[dimension()];
    	int i=0;
    	
    	NodoPresentacion aux = inicio;
		 
		while(aux!=null){
			 
			 arreglo[i]=aux.getPresentacion();
			 aux=aux.getSiguiente(); 
			 i++;
		} 
    	
    	return arreglo;
    }
    
    public boolean verificarRepetido(String cadena){
    	
    	NodoPresentacion aux = inicio;
    	
    	 while(aux!=null){
    		 
    		 if(aux.getPresentacion().toLowerCase().equals(cadena.toLowerCase())){
    			 return true;
    		 }
    		
			 aux=aux.getSiguiente();	
		 }
    	 
    	 return false;
    }
    
    public void eliminar(){
        // Elimina el valor y la referencia a los demas nodos.
        inicio = null;
        // Reinicia el contador de tamaño de la lista a 0.
        tamanio = 0;
    }
	
}
