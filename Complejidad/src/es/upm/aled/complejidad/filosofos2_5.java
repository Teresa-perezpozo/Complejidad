package es.upm.aled.complejidad;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class filosofos2_5 implements Runnable {
//para este problema habría que establecer prioridades, unas vececs a los pares y otras veces
	// a los impares, empezando desde algún stio a contar el 1.

	// o bien haceindo dos grupos de filósofos/threads:{1,3 y 5} y {2 4}
	// y q les toque coemr de manera aleatoria. entonces y croe un int q puede valer
	// 1 si no ha comido, 0 si ha comido
	// otra opción es hacer un thread para controlar a pares y otro thread para
	// controlar a impares, primero voy a hacer esto,
	// el filósofo 5 come aparte, ya que hahy 5 filósofos y 5 tenedorres, entonces
	// como max, comen 2 a la vez

	private final accionesFilosofos2_5 filosofo;
	private final String n;

	public filosofos2_5(accionesFilosofos2_5 filosofo, String n) {
		this.filosofo = filosofo;
		this.n = n;
	}

	@Override
	public void run () {
		while(true) {
		try {
		filosofo.EmpiezoAComer(n);
		System.out.println("los " + n + " están comiendo");
		Thread.sleep(ThreadLocalRandom.current().nextInt(1,3));
		filosofo.TerminoDeComer(n);
		Thread.sleep(ThreadLocalRandom.current().nextInt(1,3));
		}catch(InterruptedException e ) {
		
		Thread.currentThread().interrupt();
		
	}
}

	}
}
