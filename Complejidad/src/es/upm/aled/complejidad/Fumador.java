package es.upm.aled.complejidad;

public class Fumador implements Runnable {
	// vamos a encontrarnos una clase fumador que será la que tenga los métodos
	// fumar/liarse un piti, prestar y pedir
	// luego tendremos la clase estanquero, que irá dejando o tabaco o papelas para
	// q lo cojan
	// luego tendremos el lanzador donde crearemos cuatro hebras, tres fumadoras y
	// otra estanquera
	// luego el último sería
	private boolean papelas;
	private boolean tabaco;
	private String n ;
	
	public Fumador(boolean papelas, boolean tabaco, String n) {
		this.papelas = papelas;
		this.tabaco = tabaco;
		this.n = n;
	}

	@Override
	public void run() {
		try {
			while (true) {
			Piti.fumar(papelas, tabaco, n);
			}

		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();

		}

	}
	
	
}
