package farmacia;

public class Validacion {
	
	public static void validarLetra(java.awt.event.KeyEvent evt){
    	char c=evt.getKeyChar();
    	
		if((c<65 || c>90) && (c<97 || c>122)&&(c!=164) && c!=165 && c!=32){
			evt.consume();
		}
			
    }
	
	public static void validarNumero(java.awt.event.KeyEvent evt){
    	char c=evt.getKeyChar();
    	
		if(c<48 || c>57){
			evt.consume();
		}			
    }
	
	public static void validarNumeroYPunto(java.awt.event.KeyEvent evt){
    	char c=evt.getKeyChar();
    	
		if((c<48 || c>57) && (c!=46)){
			evt.consume();
		}			
    }

}
