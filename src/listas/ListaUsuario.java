package listas;

public class ListaUsuario {
	
	private NodoUsuario inicio;
	private int tamanio;
		
	public ListaUsuario(){
		inicio=null;
		tamanio=0;	
	}
	
	 public boolean esVacia(){ 	// Consulta si la lista esta vacia.
	      return inicio == null;
	 }

	 public int getTamanio(){
	      return tamanio;
	 }
	 
	 public void insertarFinal(int codigo,String cargo,String nombre,String apellido,String dir,String tel,String usuario,String pass){
	        
	        NodoUsuario nuevo = new NodoUsuario();
	        
	        nuevo.setCodigo(codigo);
	        nuevo.setCargo(cargo);
	        nuevo.setNombre(nombre);
	        nuevo.setApellido(apellido);
	        nuevo.setDireccion(dir);
	        nuevo.setTelefono(tel);	
	        nuevo.setUsuario(usuario);
	        nuevo.setPassword(pass);
	       
	        
	        if (esVacia()) {
	           
	            inicio = nuevo;		 // Inicializa la lista agregando como inicio al nuevo nodo.
	            
	        }else{
	           
	            NodoUsuario aux = inicio;
	            
	            while(aux.getSiguiente() != null){
	                aux = aux.getSiguiente();
	            }
	            
	            aux.setSiguiente(nuevo);	// Agrega el nuevo nodo al final de la lista.
	        }
	        
	        tamanio++;
	    }
	 
	 public void eliminar(int pos){
	    	NodoUsuario aux = inicio;
	    	int n=1;
	    	while(n!=pos ){
	    		aux=aux.getSiguiente();
	    		n++;
	    	}
	    	
	        aux.setNombre("");
	        aux.setApellido("");
	        aux.setDireccion("");
	        aux.setTelefono("");
	        aux.setUsuario("");
	        aux.setPassword("");
	    }
	 
	 public int dimension(){
	    	NodoUsuario aux = inicio;
	    	
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
	            NodoUsuario aux = inicio;
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
	    
	    
	public boolean buscarUsuario(String usuario,String pass){
		
		NodoUsuario aux = inicio;
		
		while(aux!=null){
			if(aux.getUsuario().equals(usuario) && aux.getPassword().equals(pass)){
		
				return true;
			}
			aux=aux.getSiguiente();
		}
		
	
		return false;
	}
	
	
	public NodoUsuario retornarUsuario(String usuario,String pass){
		
		NodoUsuario aux = inicio;
		
		while(aux!=null){
			if(aux.getUsuario().equals(usuario) && aux.getPassword().equals(pass)){
		
				return aux;
			}
			aux=aux.getSiguiente();
		}
		
	
		return aux;
	}
	    
	public NodoUsuario getInicio() {
		return inicio;
	}

	public void setInicio(NodoUsuario inicio) {
		this.inicio = inicio;
	}
}
