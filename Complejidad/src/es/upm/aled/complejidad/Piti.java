package es.upm.aled.complejidad;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Piti {
	private boolean papela= false;
	private boolean tabaco= false;
	private boolean mechero = false;
	private final Random random = new Random();

	
	
		


//MÉTODOS PARA FUMADORES
	 

		public synchronized void fumar( String fumadorIngrediente )throws InterruptedException {
				
			//si tengo las dos cosas, fumo
			while (true) {
	            boolean puedeFumar = false;	
	            if (fumadorIngrediente.equals("Tabaco")) {
	                puedeFumar = papela && mechero;
	            } else if (fumadorIngrediente.equals("Papel")) {
	                puedeFumar = tabaco && mechero;
	            } else if (fumadorIngrediente.equals("Cerillas")) {
	                puedeFumar = tabaco && papela;
	            }
	            if (puedeFumar) {
	                // Si puede fumar, toma los ingredientes y notifica al Estanquero
	                System.out.println(">>> FUMADOR con " + fumadorIngrediente + " está liando y fumando.");
	                //se gasta los ingredientes
	                tabaco = false;
	                papela = false;
	                mechero = false;
	                Thread.sleep(1000);
			
	            System.out.println("--- FUMADOR con " + fumadorIngrediente + " terminó. Avisando al Estanquero.");
                notifyAll(); // Despierta al Estanquero para que ponga nuevos ingredientes
				//muy impotante NO PONER RETURN AQUI pq sino formas interbloqueo
                //pq ya deja el tabaco y no quiere volver a fumar
				}
			//si no puede fumar espera
			System.out.println("--- FUMADOR con " + fumadorIngrediente + " está esperando ingredientes.");
	            wait();
		}
		}
		

//MÉTODOS PARA ESTANQUEROS
public synchronized void depositarIngredientes() throws InterruptedException {
		while (tabaco || papela || mechero) {
            System.out.println("   [ESTANQUERO] Mesa ocupada. Esperando...");
            wait(); // Espera a que un fumador lo notifique (después de fumar)
        }
		int eleccion = random.nextInt(3); 
        
        // 3. Depositar los ingredientes faltantes:
        if (eleccion == 0) {
            // Faltan Tabaco
        	Thread.sleep(100);
            papela = true;
            mechero = true;
            System.out.println("<<< [ESTANQUERO] Puso Papelas y mechero (para el de Tabaco).");
        } else if (eleccion == 1) {
        	Thread.sleep(100);

            // Faltan Papel
            tabaco = true;
            mechero = true;
            System.out.println("<<< [ESTANQUERO] Puso Tabaco y mechero (para el de Papel).");
        } else {
        	Thread.sleep(100);

            // Faltan Cerillas
            tabaco = true;
            papela = true;
            System.out.println("<<< [ESTANQUERO] Puso Tabaco y Papelas (para el de mechero).");
        }
        
        // 4. Notificar a los fumadores que la mesa tiene ingredientes
        notifyAll(); 
    
	}
	
}














				
			
		

