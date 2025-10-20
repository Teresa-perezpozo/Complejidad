package es.upm.aled.complejidad;

public class e1BusquedaLineal {
/*
 * Encontrar un Número en un Arreglo Simple:

Problema: Dada una lista de números enteros pequeños y desordenados, implementa la
 búsqueda lineal para determinar si un número específico está presente. Si lo está,
 devuelve su índice; si no, devuelve -1.
 */
	public int busquedaNum(int [] n, int indice, int numero) {
		if(n.length < indice) return -1;
		
		
		if(n[indice]==numero) return indice;
		else return busquedaNum(n, indice+1,numero);
	}
	public int fachadaBusqueda(int[]n, int numero) {
		return busquedaNum(n, 0, numero);
	}
	public static void main(String[] args) {
		e1BusquedaLineal e = new e1BusquedaLineal();
		int[] a = {9,0,9,0,1,1,2};
		int resultado = e.fachadaBusqueda(a, 9);
		System.out.println(resultado);
	}
}
