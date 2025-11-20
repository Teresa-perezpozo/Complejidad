package es.upm.aled.complejidad;

import java.util.LinkedList;
import java.util.List;

public class NodoLista {
	
	private List<Nodo> listaInvertida = new LinkedList<>();
	
	public static NodoLista invertirRecursivo (NodoLista actual) {
		// Caso base: lista vacía o único elemento
		if (actual == null || actual.siguiente == null) {
		return actual;
		}
		// Paso recursivo:
		// TODO: Complete este código
		listaInvertida.add(actual.getLast());
		Nodo nodoNuevo = actual.removeLast();
		return invertirRecursivo(nodoNuevo);
		
		
		
		}
}
