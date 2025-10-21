package es.upm.aled.complejidad;

public class e2busquedaBinaria {
	/*
	 * Búsqueda Binaria Fundamental:
	 * 
	 * Problema: Dada una lista de números ordenada, implementa la búsqueda binaria
	 * para encontrar la posición (índice) de un elemento dado. Si no está, devuelve
	 * -1.
	 */
	public int busqusquedaBinaria(int []n, int hi, int lo, int num) {
		int me = lo + (hi - lo) / 2;
		if (lo > hi) {
            return -1;
        }
		if(n[me] == num) return me;
		if(num<n[me]) return busqusquedaBinaria(n, me-1, lo, num);
		if(num>n[me])return busqusquedaBinaria(n, me+1, hi, num);
		
		else return -1;
	}
	public int fachadaBusquedaBinaria(int [] n, int num) {
		int hi=n.length;
		int lo=0;
		return busqusquedaBinaria(n, hi, lo, num);
	}
	
	public static void main(String[] args) {
		e2busquedaBinaria e = new e2busquedaBinaria();
		int[] a = {1,2, 3,4,6,7,9};
		int resultado =e.fachadaBusquedaBinaria(a, 3);
		System.out.println(resultado);
	}

}
