package es.upm.aled.complejidad;

public class e3binary {
	/*
	 * Encontrar el Primer Elemento Mayor o Igual (Lower Bound):
	 * 
	 * Problema: Dada una lista ordenada, implementa la búsqueda binaria para
	 * encontrar el índice del primer elemento que sea mayor o igual al valor
	 * objetivo.
	 */
	public int busquedaNum (int[] n, int b, int lo, int hi) {
		int me = lo + (hi-lo)/2;
		if(n[me]<b) return busquedaNum(n,b,me+1,hi);
		if(n[me]>b) return n[me];
		else return-1;
	}
	public int fachadaBusquedaNum(int[] n, int b) {
		return busquedaNum(n,b,0,n.length);
	}
	
	
	public static void main(String[] args) {
		 e3binary e = new e3binary();
		 int[]a = {1,2,3,3,6,7};
		 int resultado = e.fachadaBusquedaNum(a, 6);
		 System.out.println(resultado);
	}

}
