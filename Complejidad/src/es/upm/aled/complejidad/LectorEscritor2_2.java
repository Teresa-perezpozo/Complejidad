package es.upm.aled.complejidad;

import java.util.Random;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class LectorEscritor2_2 {
private int valor1 =0;
private int valor2=0;

private final ReentrantReadWriteLock rwLock1 = new ReentrantReadWriteLock(); // Para valor1
private final ReentrantReadWriteLock rwLock2 = new ReentrantReadWriteLock(); // Para valor2

private final Random rand = new Random();


public int leerValore1(String n) {
    boolean leerPrimeroValor1 = rand.nextBoolean();

boolean leyendoval1 = true;
rwLock.readLock().lock();
try {
	if(leyendoval1) {
		System.out.println(n+" está leyendo el valor 1 y es " + valor1 );
		return valor1;
	}if(!leyendoval1) {
		System.out.println(n+" está leyendo el valor 1 y es " + valor1 );
		return valor2;
	}finally {
	rwLock.readLock().unLock();
}
}
}
public void cambiarValor(String n ) {
	rwLock.writeLock().lock();
	try {
		valor1 = round.nextInt(10000);
		System.out.println("el nuevo valor es " + valor +" y lo ha cambiado " + name);
		
	}finally {
		rwLock.writeLock().unlock()
	}
}

}
