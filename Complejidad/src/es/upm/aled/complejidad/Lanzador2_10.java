package es.upm.aled.complejidad;

import java.util.concurrent.ThreadLocalRandom;

public class Lanzador2_10 {

	public static void main(String[] args) {
		System.out.println("--- Iniciando Simulación puente de talavera  ---");
        
        monitor2_10 monitor = new monitor2_10();
        int numVehiculos = 15; // Número total de vehiculos que cruzarán el puente

       
        
        // 2. Lanzar a los vehículos (se van creando y llegando con pausas), vamos a hacer un boolean 
        //para saber si son ambulancias o no, van a pasar muchas ambulancias, pero bueno, eso es q 
        //hay un hospital al lado
        for (int i = 0; i < numVehiculos; i++) {
            // Decisión aleatoria de ambulancia
            int peso = ThreadLocalRandom.current().nextInt(14999); 
            boolean ambulancia = ThreadLocalRandom.current().nextBoolean(); 
            final String nombre = (ambulancia ? "AMB-" : "V-") + (i + 1);
            
            Vehiculo tareaVehiculo = new Vehiculo(monitor, peso, ambulancia, nombre);
            Thread vehiculoThread = new Thread(tareaVehiculo);
            vehiculoThread.start();
            // Simular tiempo de llegada entre vehiculos
            try {
                Thread.sleep(ThreadLocalRandom.current().nextInt(50, 200)); 
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        
        System.out.println("\n*** Todos los " + numVehiculos + " vehiculos han sido lanzados. ***\n");
    }
}