package es.upm.aled.complejidad;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

//marmita tiene que contener dos métodos, comer y rellenar, el priemro avisa a los caníbales
//de q hay q comer y el de rellenar avisa a los cocineros de que hay q rellenar la marmita
//además tengo que hacer una clase de caníbales donde ponga x cocineros y x canibales
//también hay q 
public class Marmita2_6 {
private int cucharones;
private boolean cocineroLlamado = false;
private final int CAPACIDAD_MAXIMA = 10;


public Marmita2_6() {
    // La marmita empieza llena.
    this.cucharones = CAPACIDAD_MAXIMA;
}





public synchronized void comer(String n )throws InterruptedException {
		while(cucharones ==0) {
			System.out.println("--- [CANÍBAL " + n + "] Marmita vacía. Llamando al cocinero...");
            
            // Si el cocinero aún no ha sido llamado (o ya terminó su relleno):
            if (!cocineroLlamado) {
                // Notificar al cocinero (o a todos, por si hay varios)
                cocineroLlamado = true;
                notifyAll(); 
            }
			wait();
			
		}
		cucharones--;
		System.out.println(" el canibal " + n +" se ha comido 1 cucharón ");
		
	}
		
		
	
public synchronized void rellenar(String n ) throws InterruptedException{
	while (!cocineroLlamado) {
        System.out.println("   [COCINERO " + n + "] Esperando ser llamado...");
        notifyAll();

        wait();
    } 
	System.out.println(">>> [COCINERO " + n + "] COMENZÓ a rellenar la marmita.");
    Thread.sleep(1000 + (int)(Math.random() * 2000)); // tarda en cocinar

    // Simular tiempo de relleno
    cucharones = CAPACIDAD_MAXIMA;
    System.out.println("<<< [COCINERO " + n + "] MARMITA LLENA (" + cucharones + "). Notificando caníbales.");
    cocineroLlamado = false; // El cocinero termina su tarea de relleno

    // Despertar a todos los caníbales que esperan para que puedan volver a comer
    notifyAll(); 
}
	
}

