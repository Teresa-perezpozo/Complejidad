package es.upm.aled.complejidad;

public class threadManager2_2 {

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreadManager {
	public static void main(String[] args) throws InterruptedException {
        // Asumiendo que esta clase existe y usa ReentrantReadWriteLock
        LectorEscritor2_2 recursoCompartido = new LectorEscritor2_2(); 

        int cores = Runtime.getRuntime().availableProcessors();
        ExecutorService executor = Executors.newFixedThreadPool(cores); 
        
        
        int numEscritores = 10; 
        int numLectores = cores - numEscritores;
        
        System.out.println("Este ordenador tiene "+ cores + " cores.");
        System.out.println("Se asignarán " + numEscritores + " escritores y " + numLectores + " lectores.");
            
        //asigno a los escritores sus tareas
        
        for (int i = 0; i < numEscritores; i++) {
            final String name = "Escritor-" + i;
            // 5. Usa la variable 'executor' y el nombre de variable 'name'
            executor.submit(() -> { 
                    // 6. Usa la variable 'recursoCompartido' y el nombre 'name'
                    recursoCompartido.cambiarValor(name); 
                    try {
                        Thread.sleep(100); // Pausa para simular trabajo
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    
                }
            }); // 7. Paréntesis y punto y coma faltantes aquí
        }
        
        // --- Asignación de Lectores (Añadido para completar la lógica) ---
        for (int i = 0; i < numLectores; i++) {
            final String name = "Lector-" + i;
            executor.submit(() -> { 
                    recursoCompartido.leerValore1(name); 
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                
            });
        }
        
        executor.shutdown();
        executor.awaitTermination(60, TimeUnit.SECONDS); // Esperar a que terminen
        System.out.println("\n--- Tareas Finalizadas ---");
        System.out.println("Valor final del recurso compartido: " + recursoCompartido.leerValor("Main Thread"));
    }
}
}
