package es.upm.aled.complejidad;

public class monitor2_4 {
	private final int capacidad = 10;
	int[] buffer = new int[10];
	private int indexArray = 0;


	public synchronized void setValue(int value, String n) {
		while (indexArray == capacidad) {
			System.out.println(" el array está lleno ");
			wait();
		} 
			buffer[indexArray] = value;
			indexArray++;
			System.out.println(" la hebra " + n + " ha introducido el número " + value);
			notifyAll();
		}
	}

	public synchronized int leerValue(String n) {
		while(indexArray==0) {
		System.out.println("el array no teiene ningún valor que leer y eliminar ");
		wait();
		}
		int value = buffer[0];
		for(int i=0;i<indexArray;i++) {
			buffer[i] = buffer[i+1];
		}
		indexArray--;
		System.out.println(" la hebra " + n +" ha leido y eliminado el número " + value);
		notifyAll();
		return value;
	}

}
