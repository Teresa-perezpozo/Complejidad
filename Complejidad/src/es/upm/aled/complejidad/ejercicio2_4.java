package es.upm.aled.complejidad;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

public class ejercicio2_4 {

	
	private final int capacidad = 10;
	int[] buffer = new int[10];
	private int indexArray = 0;


	public synchronized void setValue(int value, String n) {
		while (indexArray == capacidad) {
			System.out.println(" el array está lleno ");
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} 
			buffer[indexArray] = value;
			indexArray++;
			System.out.println(" la hebra " + n + " ha introducido el número " + value);
			notifyAll();
		}
	//lo que tengo que hacer es ir cambiando el nomre del array y norificar luego cuando vaya cmaiado


	public synchronized int leerValue(String n) {
		while(indexArray==0) {
		System.out.println("el array no teiene ningún valor que leer y eliminar ");
		try {
			wait();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
