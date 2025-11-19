package es.upm.aled.complejidad;

import java.util.concurrent.ThreadLocalRandom;

public class LanzadorHacienda {
//en este ejercicio vamos a encontrar, un monitor ocn los métodos que nos han dihco 
//una clase ciudadano
//una clase funcionario
	public static void main(String[] args) {
		//si hago un boolean lo tengo que hacer cuando cree las hebras
		
System.out.println("--- Iniciando Simulación Hacienda (Andrés Trozado) ---");
        
        monitor monitor = new monitor();
        int numCiudadanos = 15; // Número total de ciudadanos que irán a la oficina

        // 1. Lanzar al Funcionario (Andrés)
        Thread funcionarioThread = new Thread(new Funcionario(monitor), "Funcionario-Andrés");
        funcionarioThread.start();
        
        // 2. Lanzar a los Ciudadanos (se van creando y llegando con pausas)
        for (int i = 0; i < numCiudadanos; i++) {
            // Decisión aleatoria de ventanilla
            boolean esVentanilla1 = ThreadLocalRandom.current().nextBoolean(); 
            String nombreCiudadano = "C" + (i + 1);
            
            Thread ciudadanoThread = new Thread(new Ciudadano(monitor, nombreCiudadano, esVentanilla1));
            ciudadanoThread.start();
            
            // Simular tiempo de llegada entre ciudadanos
            try {
                Thread.sleep(ThreadLocalRandom.current().nextInt(50, 200)); 
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        
        System.out.println("\n*** Todos los " + numCiudadanos + " ciudadanos han sido lanzados. ***\n");
    }
}