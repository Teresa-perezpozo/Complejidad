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
		int me = hi-lo/2;
		if(me == num) return me;
		if(num<me) return busqusquedaBinaria(n, me, lo, num);
		if(num>me)return busqusquedaBinaria(n, me, hi, num);
		
		else		return -1;
	}
	public int fachadaBusquedaBinaria(int [] n, int num) {
		int hi=n.length;
		int lo=0;
		return busqusquedaBinaria(n, hi, lo, num);
	}
	
	public static void main(String[] args) {
		e2busquedaBinaria e = new e2busquedaBinaria();
		int resultado =e.busqusquedaBinaria(a, , 0, 0)
	}

}
