package es.upm.aled.complejidad;

public class e5merge {
	
	private static void merge(int[] arr, int l, int m, int r) {
	    int n1 = m - l + 1;
	    int n2 = r - m;

	    int[] L = new int[n1];
	    int[] R = new int[n2];

	    // Copiar datos a los arrays temporales
	    for (int i = 0; i < n1; ++i) L[i] = arr[l + i];
	    for (int j = 0; j < n2; ++j) R[j] = arr[m + 1 + j];

	    // 2. Unificar los arrays temporales de nuevo en arr[l..r]
	    int i = 0, j = 0; // Punteros para L y R
	    int k = l;        // Puntero para el array original

	    while (i < n1 && j < n2) {
	        if (L[i] <= R[j]) {
	            arr[k] = L[i];
	            i++;
	        } else {
	            arr[k] = R[j]; // Si el de R es menor, lo elegimos
	            j++;
	        }
	        k++;
	    }

	    // 3. Copiar los elementos restantes de L[] o R[] (si quedan)
	    while (i < n1) {
	        arr[k] = L[i];
	        i++;
	        k++;
	    }
	    while (j < n2) {
	        arr[k] = R[j];
	        j++;
	        k++;
	    }
	}
	
	public static void merge(int[] arr, int[] L, int[] R) {
        int i = 0, j = 0, k = 0;

        while (i < L.length && j < R.length) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++; 
        }

        while (i < L.length) {
            arr[k] = L[i];
            i++;
            k++;
        }

        while (j < R.length) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
	
	
	
	public static void main(String[] args) {

	}

}
