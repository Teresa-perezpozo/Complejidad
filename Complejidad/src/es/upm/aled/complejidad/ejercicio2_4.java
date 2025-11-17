package es.upm.aled.complejidad;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

public class ejercicio2_4 {

	
	//creo el array de dos enteros
	int[] buffer = new int[10] ;
	int cores = RunTime.getRunTime().avaibleProcessors();
	ExecutorService executor = 	Executor.newFixedThreadPool(cores);
	int indexArray =0;
	String n ;
	
	public synchronized void setValue(int value, String n ) {
		if(indexArray<10){
			buffer[indexArray]=value;
			indexArray++;
			System.out.println(" la hebra " + n +" ha introducido el número " + value);
		}else {
		System.out.println(" el array está lleno ");
		}
	}
		public synchronized int leerValue(String n ) {
			
			return buffer[indexArray];
			System.out.println(" la hebra " + n +" ha leido y borrado el número " + buffer[indexArray]);
			buffer[indexArray]=[];
			
		}
	
	
	
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
