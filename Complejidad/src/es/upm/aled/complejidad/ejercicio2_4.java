package es.upm.aled.complejidad;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

public class ejercicio2_4 {

	
	//creo el array de dos enteros
	int cores = RunTime.getRunTime().avaibleProcessors();
	ExecutorService executor = 	Executor.newFixedThreadPool(cores);
	int indexArray =0;
	String n ;
	
	
		public synchronized int leerValue(String n ) {
			if(buffer.length ==0) {
			wait();
			}else {
			return buffer[indexArray];
			System.out.println(" la hebra " + n +" ha leido y borrado el número " + buffer[indexArray]);
			buffer[indexArray].clear();
			indexArray--;
			}
		}
	
	
	
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
