package es.upm.aled.complejidad;

public class e1BusquedaLineal {
/*
 * Encontrar un Número en un Arreglo Simple:

Problema: Dada una lista de números enteros pequeños y desordenados, implementa la
 búsqueda lineal para determinar si un número específico está presente. Si lo está,
 devuelve su índice; si no, devuelve -1.
 Problema: Modifica el algoritmo de búsqueda lineal para que cuente cuántas veces 
 aparece un elemento específico en la lista.
 */
	public int busquedaNum(int[] n, int indice, int numero) {
        // Caso Base: El índice se ha salido del arreglo. No hay más números que contar.
        if (indice >= n.length) {
            return 0; // Devuelve 0, ya que no se encontró nada más
        }
        
        // Inicializa el contador para el elemento actual.
        int cuentaActual = 0;
        
        // Verifica si el número en la posición actual coincide con el objetivo.
        if (n[indice] == numero) {
            cuentaActual = 1; // Si coincide, suma 1 a la cuenta actual.
        }
        
        // Paso Recursivo: La función devuelve la suma de:
        // 1. La cuentaActual (1 o 0).
        // 2. El resultado de la búsqueda en el resto del arreglo.
        return cuentaActual + busquedaNum(n, indice + 1, numero);
    }
    
    /**
     * Función "fachada" para simplificar la llamada inicial.
     */
    public int fachadaBusqueda(int[] n, int numero) {
        // El parámetro 'resultado' (contador) ya no es necesario en la firma pública
        // porque se construye recursivamente.
        return busquedaNum(n, 0, numero);
    }
    
    public static void main(String[] args) {
        e1BusquedaLineal e = new e1BusquedaLineal();
        int[] a = {9, 0, 9, 0, 1, 1, 2};
        
        // Prueba 1: Buscando el 9 (debería dar 2)
        int resultado9 = e.fachadaBusqueda(a, 9);
        System.out.println("Buscando 9: " + resultado9); 
        
        // Prueba 2: Buscando el 0 (debería dar 2)
        int resultado0 = e.fachadaBusqueda(a, 0);
        System.out.println("Buscando 0: " + resultado0); 

        // Prueba 3: Buscando el 5 (no existe, debería dar 0)
        int resultado5 = e.fachadaBusqueda(a, 5);
        System.out.println("Buscando 5: " + resultado5); 
    }
}


public class e1BusquedaLinealIterativa {

    /**
     * Implementación iterativa de la búsqueda lineal para contar ocurrencias.
     * @param n El arreglo de números.
     * @param numero El número a buscar.
     * @return La cuenta total de veces que aparece 'numero'.
     */
    public int contarOcurrencias(int[] n, int numero) {
        int contador = 0;
        
        // Recorre todo el arreglo (de inicio a fin)
        for (int i = 0; i < n.length; i++) {
            // Si el elemento actual coincide con el número buscado, incrementa el contador
            if (n[i] == numero) {
                contador++;
            }
        }
        return contador;
    }
    
    public static void main(String[] args) {
        e1BusquedaLinealIterativa e = new e1BusquedaLinealIterativa();
        int[] a = {9, 0, 9, 0, 1, 1, 2};
        
        int resultado = e.contarOcurrencias(a, 9);
        System.out.println("Buscando 9 (iterativa): " + resultado); // Salida: 2
    }
}