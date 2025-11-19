package es.upm.aled.complejidad;

public class Fumador implements Runnable {
	// vamos a encontrarnos una clase fumador que será la que tenga los métodos
	// fumar/liarse un piti, prestar y pedir
	// luego tendremos la clase estanquero, que irá dejando o tabaco o papelas para
	// q lo cojan
	// luego tendremos el lanzador donde crearemos cuatro hebras, tres fumadoras y
	// otra estanquera
	// luego el último sería
	
	private final Piti piti;
	private String ingredienteFijo ;
	
	 public Fumador(Piti piti, String ingredienteFijo) {
	        this.piti = piti;
	        this.ingredienteFijo = ingredienteFijo;
	    }
	@Override
	public void run() {
		try {
			while (true) {
			piti.fumar(ingredienteFijo);//es MUY IMPORTANTE que aqui nos fumamos el objeto piti, no su clase Piti
			Thread.sleep(300);//hay q parar un poco antes de intentar volver a fumar, par q puedan pasar cosas
			}

		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();

		}

	}
	
	
}
