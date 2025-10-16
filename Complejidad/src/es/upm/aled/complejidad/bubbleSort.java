package es.upm.aled.complejidad;

public class bubbleSort {
	private static void bubbleSort(int[] list) {
		for(int i = 0;i<list.length;i++) {//por cada vez qie se ejecute ese for, se va a ejecutar todo el array entero
			for( int j = 0;j<list.length-1-i; j++) {//se para en menos uno pq como comparo uon con el siguiente me daría error por aout bound 
				//si es mayor que el sigiente lo cambio
				if (list[j]> list[j+1]) {
					int temp= list[j];
					list[j]= list[j+1];
					list[j+1]=temp;
				}// se hace menos i porque en ela primera vuelta se recorre el array entero, en la segunda vuelta se recorre el array menos 1
				//el siguiente como array menos dos y así , pq en cada vuelta estoy cerciorando un número al final, entonces esos hay que recorrerlo si o si
			}//realmente el -i no es necesario, simplemente te ahorara unas comparaciones que ya sabes
		}
	}
	public static void main(String[] args) {
		
	}

}
