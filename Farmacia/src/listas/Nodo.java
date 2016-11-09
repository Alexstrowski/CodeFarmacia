package listas;

public class Nodo {
   
    private int valor;	 // Variable en la cual se va a guardar el valor.  
    private Nodo siguiente; // Variable para enlazar los nodos.
 
    public void Nodo(){
        this.valor = 0;
        this.siguiente = null;
    }
 
    
    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public Nodo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }   
}