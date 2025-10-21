package es.upm.aled.complejidad;

public class e4bubble {
	/*
	 * Ejercicio 1.1: Implementación Pura de Bubble Sort Problema: Implementa el
	 * algoritmo de Bubble Sort para ordenar una lista de números enteros de forma
	 * ascendente.
	 * 
	 * Ejemplo:
	 * 
	 * Entrada: [64, 34, 25, 12, 22, 11, 90]
	 * 
	 * Salida: [11, 12, 22, 25, 34, 64, 90]
	 */
	public int[]  BubbleSort(int [] arr ) {
		int n = arr.length;
		for(int i = 0;i<n-1;i++) {
			for(int j = 0;j<n-1-i;j++) {
				if(arr[j]>arr[j+1]) {
					int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
				}
				}
					
			}return arr;
		
		}
	
	
	public static void main(String[] args) {
		e4bubble a = new e4bubble();
		int [] arr = {1,5,4,8,101,40,3};
		int[] resultado =a.BubbleSort(arr);
		for(int i =0;i<arr.length;i++) {
			System.out.println(arr[i]);
		}

}
}
