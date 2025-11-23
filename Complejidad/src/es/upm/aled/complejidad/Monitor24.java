package es.upm.aled.complejidad;

import java.util.Random;

public class Monitor24 {
	int[] buffer = new int[10];
	boolean escribiendo;
	int contador=0;
	Random random = new Random();
	public Monitor24(int[] buffer, boolean escribiendo) {
		this.buffer=buffer;
		this.escribiendo=escribiendo;
	}
	
	public synchronized void accesoEscribir(String n )throws InterruptedException {
		while(escribiendo) {
			wait();
		}
		escribiendo =true;
		
	}
	
	
	public synchronized void terminoEscribir(String n ) throws InterruptedException{
		escribiendo = false;
		notifyAll();
	}
	public synchronized void escribiendo (String n) throws InterruptedException{
		buffer[contador]=random.nextInt(0,10000);//random
		contador++;
	}
	public synchronized void accesoLeer(String n ) throws InterruptedException{
		while(escribiendo) {
			wait();
		}
		escribiendo = true;
	}
	public synchronized void terminoLeer(String n ) throws InterruptedException{
		escribiendo = false;
		notifyAll();
	}
	public synchronized void leyendo(String n )throws InterruptedException{
		
	}
}
