package es.upm.aled.complejidad;

import java.util.Random;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class LectorEscritor2_2 {
private int valor1 =0;
private int valor2=0;

private final ReentrantReadWriteLock rwLock1 = new ReentrantReadWriteLock(); // Para valor1
private final ReentrantReadWriteLock rwLock2 = new ReentrantReadWriteLock(); // Para valor2


private final Random rand = new Random();

//leyendo valor 1, con lock
public int leerValor1(String n) {
    boolean leerPrimeroValor1 = rand.nextBoolean();

boolean leyendoval1 = true;
rwLock.readLock().lock();
try {
	if(leyendoval1) {
		System.out.println(n+" está leyendo el valor 1 y es " + valor1 );
		return valor1;
	
	}finally {
		rwLock1.readLock().unlock();
}
}
}
//leyendo valor 2 con lock
public int leerValor2(String n) {
    boolean leerPrimeroValor1 = rand.nextBoolean();

boolean leyendoval2 = true;
rwLock2.readLock().lock();
try {
	if(leyendoval2) {
		System.out.println(n+" está leyendo el valor 2 y es " + valor2 );
		return valor2;

	}finally {
	rwLock2.readLock().unlock();
}
}
}




public void cambiarValor1(String n ) {
	rwLock1.writeLock().lock();
	try {
		valor1 = round.nextInt(10000);
		System.out.println("el nuevo valor es " + valor1 +" y lo ha cambiado " + n);
		
	}finally {
		rwLock1.writeLock().unlock();
	}
}
public void cambiarValor2(String n ) {
	rwLock2.writeLock().lock();
	try {
		valor1 = round.nextInt(10000);
		System.out.println("el nuevo valor es " + valor2 +" y lo ha cambiado " + n);
		
	}finally {
		rwLock2.writeLock().unlock();
	}
}
}
