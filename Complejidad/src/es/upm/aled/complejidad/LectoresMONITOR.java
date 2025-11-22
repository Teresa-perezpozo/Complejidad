package es.upm.aled.complejidad;

import java.util.concurrent.ThreadLocalRandom;

public class LectoresMONITOR {
	int valor;
	boolean escribiendo;
	int numLectores;
	public LectoresMONITOR(int valor, boolean escribiendo, int numLectores) {
		this.valor=valor;
		this.escribiendo=escribiendo;
		this.numLectores=numLectores;
	}
	
	
//metodos para escritores	
	public void accesoEscritura() {
		
		try {
			while(escribiendo) {
				wait();//esperamos a q dejen e escribir
			}
			escribiendo = true;
		}catch(InterruptedException e ) {}
			
		}
	public void terminoEscribir() {
			escribiendo =false;
			notifyAll();
	}
	
	
	
	public void accesoLectura() {
		while(escribiendo) {
			try {
				wait();

			}catch(InterruptedException e ) {}
		}
		numLectores++;
	}
	public synchronized void terminaLectura(String nombreLector) throws InterruptedException {
    	numLectores--;
        if (numLectores == 0) {
            notifyAll();
        }
}
	
	public void escribir(String n )throws InterruptedException {
		this.accesoEscritura();
		this.valor =  (int) (Math.random() * 10000); 
        Thread.sleep((long) (Math.random() * 500));
        this.terminaLectura(n);
	
	
	
	
	
	
	
	
	
	
	
	
	
	}
}
