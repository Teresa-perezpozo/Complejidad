package es.upm.aled.complejidad;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

public class ejercicio2_4 {

	
	//creo el array de dos enteros
	int[] buffer = new int[10] ;
	int cores = RunTime.getRunTime().avaibleProcessors();
	ExecutorService executor = 	Executor.newFixedThreadPool(cores);
	
	
	
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
