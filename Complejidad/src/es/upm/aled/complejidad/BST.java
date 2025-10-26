package es.upm.aled.complejidad;

public class BST {
	
	
	
	private int calcularProfundidad(Nodo nodoActual) {
		
		//CASO BASE
		if (nodoActual == null) {
            return 0;
        }
		int profIzq = calcularProfundidad(nodoActual.iz);
		int profDer = calcularProfundidad(nodoActual.der);
		return 1 + Math.max(profIzq, profDer);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
}
