package es.upm.aled.complejidad;

public class LectorEscritor2_2 {
private int valor1 =0;
private int valor2=0;
private final ReentrantReadWeiteLock rwLock = new ReentrantReanWeiteLock();
private final ReentrantReadWeiteLock rwLock = new ReentrantReanWeiteLock();
private final Random rand = new Random();


public int leerValore1(String n) {

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
	}
}
}
