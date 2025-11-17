package es.upm.aled.complejidad;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class threadManager2_2 {
	public static void main(String[] args) throws InterruptedException {

		LectorEscritor2_2 recursoCompartido = new LectorEscritor2_2();

		int cores = Runtime.getRuntime().availableProcessors();
		ExecutorService executor = Executors.newFixedThreadPool(cores * 2); // Más pool para simular

		int numEscritores = cores - 5;
		int numLectores = cores - numEscritores;

		System.out.println("Este ordenador tiene " + cores + " cores.");
		System.out.println("Se asignarán " + numEscritores + " escritores y " + numLectores + " lectores.");

		// --- Asignación de Escritores ---
		for (int i = 0; i < numEscritores; i++) {
			final String name = "Escritor-" + i;
			executor.submit(() -> {
				for (int j = 0; j < 5; j++) { // Repetir la tarea varias veces
					// CORRECCIÓN: Llamar al método que elige al azar qué valor escribir
					recursoCompartido.cambiarValor(name);
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						Thread.currentThread().interrupt();
					}
				}
			}
		);
	}

        // --- Asignación de Lectores ---
        for (int i = 0; i < numLectores; i++) {
            final String name = "Lector-" + i;
            executor.submit(() -> { 
                for (int j = 0; j < 10; j++) { // Repetir la tarea varias veces
                    // CORRECCIÓN: Llamar al método que lee AMBOS valores en orden aleatorio
                    try {
						recursoCompartido.leerValores(name);
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} 
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            });
        }

        executor.shutdown();
        executor.awaitTermination(60, TimeUnit.SECONDS); 
        
        System.out.println("\n--- Tareas Finalizadas ---");
        // CORRECCIÓN: Llamar al método final para leer ambos valores
        System.out.println("Valor final de los recursos compartidos: " + recursoCompartido.leerValoresFinales());
    }
}