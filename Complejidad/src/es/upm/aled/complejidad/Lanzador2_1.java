package es.upm.aled.complejidad;

public class Lanzador2_1 {

	//MAIN
	
	Runnable escribir = new Runnable();
	Runnable leer = new Runnable();

	Thread hebra = new Thread(escribir);
	Thread hebra1 = new Thread(leer);
	hebra.start();
	hebra1.start();
	
	try {
		// Crear y arrancar hebras
		for (int i = 0; i < NUM_LECTORAS; i++) {
			Thread t = new HebraLectora(recurso, "L" + i);
			t.start();
			// 1 escritora por cada N lectoras
			if (i % RATIO_LECTORAS_ESCRITORAS == 0) {
				Thread t2 = new HebraEscritora(recurso, "E" + i);
				t2.start();
			}
			// Esperar hasta 500 ms entre creación de hebras.
			Thread.sleep((long) (Math.random() * 500));
		}
	} catch (InterruptedException e) {}
}
}
