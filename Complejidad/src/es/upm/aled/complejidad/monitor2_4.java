package es.upm.aled.complejidad;

public class monitor2_4 {
	public static void main (String[] args) {



		        
		        // 1. Crear la única instancia del Monitor (el recurso compartido)
		monitor2_4 monitor = new monitor2_4();

		        // 2. Configurar el número de hebras (configurable por el usuario)
		        int numProductores = 3; 
		        int numConsumidores = 2;

		        System.out.println("--- Iniciando Productor-Consumidor (Buffer Lineal) ---");
		        System.out.println("Productores: " + numProductores + ", Consumidores: " + numConsumidores);

		        // 3. Lanzar hebras productoras
		        for (int i = 0; i < numProductores; i++) {
		            // Se crea una nueva instancia de Thread que ejecutará el código de Productor.
		            Thread productorThread = new Thread(new Productor(monitor), "Productor-" + (i + 1));
		            // El método start() es esencial: le dice al SO que ejecute el run() en un nuevo hilo.
		            productorThread.start(); 
		        }

		        // 4. Lanzar hebras consumidoras
		        for (int i = 0; i < numConsumidores; i++) {
		            // Se crea una nueva instancia de Thread que ejecutará el código de Consumidor.
		            Thread consumidorThread = new Thread(new Consumidor(monitor), "Consumidor-" + (i + 1));
		            // Inicia la ejecución concurrente
		            consumidorThread.start();
		        }
		    }
		}
	}
	
}