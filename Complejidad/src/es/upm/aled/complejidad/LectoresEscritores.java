package es.upm.aled.complejidad;

import java.util.List;
import java.util.Random;
import java.util.concurrent.Executor;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class LectoresEscritores {
	
	int lectores =0;
	int escritores =0;
	int valor =0;
	
	private final ReentrantReadWriteLock rwLock = new ReentrantReadWriteLock();
	
	public synchronized int getValor() {
		return valor;
	}
	
	public synchronized void modificarValor() {
		valor++;
	}
	public int leerValor(String n) {
		rwLock.readLock().lock();
		try {
			System.out.println("la hebra n " +  " está leyendo " + valor);

			return valor;
		}finally {
			rwLock.readLock().unlock();
		}
	}
	
	public void cambiarValor(String n ) {
	rwLock.writeLock().lock();
	try {
		valor = Random.nextInt(10000);
		System.out.println("el nuevo valor es " + valor + " y lo ha cambiado " + n);
	}finally {
		rwLock.writeLock().unlock();
	}
	
	}
	
	public static void main(String[] args) {
		
	}

}
