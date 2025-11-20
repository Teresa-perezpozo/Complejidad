package es.upm.aled.complejidad;

public class Nodo2_7 {
	int valor;
	Nodo2_7 izq;
	Nodo2_7 der;
	
	 public Nodo2_7(int valor Nodo2_7 izq, Nodo2_7 der){
		 this.valor = valor;
		 this.izq = izq;
		 this.der=der;
	}

	
	//fachada
	public static boolean esBST (Nodo2_7 nodo) {
		
		return esBSTAux(nodo, Integer.MIN_VALUE, Integer.MAX_VALUE);
		}
	
	//programa
		private static boolean esBSTAux (Nodo nodo, int min, int max) {
			
			if(nodo=null) {
				return true;
			}
			
			if (nodo.valor <= min || nodo.valor >= max) {
				return false; // ¡El valor está fuera del rango permitido!
			}
			//izquierdo menor
			//derecha mayor
			if(izq.getValor()>nodo.getValor()||der.getValor()<nodo.getValor()) {
				return false;
			}
	        boolean izqEsValido = esBSTAux(nodo.izq, min, nodo.valor); 
	        boolean derEsValido = esBSTAux(nodo.der, nodo.valor, max);

	        
	        return izqEsValido&&derEsValido;
			
			
		}
}
