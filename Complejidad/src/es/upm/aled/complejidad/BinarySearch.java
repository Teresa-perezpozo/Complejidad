package es.upm.aled.complejidad;

public class BinarySearch {

	private static int binarySearch(int[] list, int lo, int hi, int value) {
		// DEBERES: ¿Implementarlo con recursividad?
		/*do {
			int me = (int) Math.floor(lo + (hi-lo)/2);
			int v = list[me]; // O(1)
			if (v == value) {
				return me;
			}
			else if (v > value) {
				hi = me;
			}
			else {
				lo = me +1;
			}
		} while (lo<hi);
		return -1;
	}
	*/
		//MÉTODO RECURSIVO
	
			
//caso base 			
		int me = (int) Math.floor(lo + (hi-lo)/2);
		 if (list[me] == value) {
	            return me;
		 }
		 
		 
		 
//paso recursivo		 
		if(list[me] < value) {//importante que tengo que acceder al valor y no quedarme en la posición!!!
            return binarySearch(list, me + 1, hi, value);

		}
		else {
            return binarySearch(list, lo, me - 1, value);//es importante el menos uno es en la posición no en eel valor

		}
		
	}
		
	// Método facade
	public static int binarySearch(int[] list, int value) {
		return binarySearch(list, 0, list.length, value);
	}//el método fachada es para que realmente el usuario no tenga que lidiar con cosas complejas
	//además el metodo recursivo siempre tiene que devolver algo para realimentarse y si queremos que el método realmente no devuelva nada o devuelva un tipo disitnto, tenemos que hacer un método fachada
	
	public static void main(String[] args) {
		// Array ORDENADO
		int[] list = { 1,3,5,7,9,11,13,15,17,19,21,23,25,27,29,31 };
		int value = 19;
		int posicion = binarySearch(list, value);
		System.out.println("Posición: " + posicion);
	}
	
	
	
	
	
	
	
}
