package es.upm.aled.complejidad;

public class lanzador2_5 {

	public static void main(String[] args) {
		accionesFilosofos2_5 monitor = new accionesFilosofos2_5();
		Thread hebra1 = new Thread(new filosofos2_5(monitor, " filosofos 1 y 3"));
		Thread hebra2 = new Thread(new filosofos2_5(monitor," filosofos 2 y 4"));
		Thread hebra3 = new Thread(new filosofos2_5(monitor," filosofo 5"));
		hebra1.start();
		hebra2.start();
		hebra3.start();
	}

}
