package es.upm.aled.complejidad;

public class Lanzador2_12 {

	public static void main(String[] args) {

		Monitor2_12 monitor = new Monitor2_12();//MUY IMPORTANTE AQUI CREAR OBJETO DE MONITOR Y PASARSELO A LOS THREADS
		
		Thread hebra1 = new Thread (new Persona("Jose", monitor, true));
		Thread hebra2 = new Thread (new Persona("Teresa",monitor,  true));
		Thread hebra3 = new Thread (new Persona("Maria", monitor, true));

		Thread hebra4 = new Thread (new Persona("Luisa",monitor,  true));
		Thread hebra5 = new Thread (new Persona("Raquel",monitor, true));
		Thread hebra6 = new Thread (new Persona("Helena",monitor, false));
		
		
		hebra1.start();
		hebra2.start();
		hebra3.start();
		hebra4.start();
		hebra5.start();
		hebra6.start();
		

	}

}
