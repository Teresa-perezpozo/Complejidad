package es.upm.aled.complejidad;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class filosofos2_5 {
//para este problema habría que establecer prioridades, unas vececs a los pares y otras veces
	//a los impares, empezando desde algún stio a contar el 1.
	
	// o bien haceindo dos grupos de filósofos/threads:{1,3 y 5} y {2  4}
	//y q les toque coemr de manera aleatoria. entonces  y croe un int q puede valer 1  si no ha comido, 0 si ha comido
	//otra opción es hacer un thread para controlar a pares  y otro thread para controlar a impares, primero voy a hacer esto,
	//el filósofo 5 come aparte, ya que hahy 5 filósofos y 5 tenedorres, entonces como max, comen 2 a la vez
	
	rwLock.readLock().ReentrantReadWriteLock comeLock = new ReentrantReanWriteLock();
	private int platoPutanesca1=1;
	private int platoPutanesca2=1;
	private int platoPutanesca3=1;
	private int platoPutanesca4=1;
	private int platoPutanesca5=1;
//entones, aunq queda muy cutre tendria q hacer dos métodos, apra pares y para impares
	//método para comer 
	public void comiendoImpares(String n) {
		comeLock.readLock().lock();
		//me gustaría hacerlo con for pero no me sale
		platoPutanesca1 = 0;
		platoPutanesca3 = 0;
		platoPutanesca5 = 0;
		comeLock.readLock().unlock();
		System.out.println("el thread " + n + " que se encarga de los impares, ya ha hecho que coman los filósofos impares");

		}
	public void comiendoPares(String n) {
		comeLock.readLock().lock();
		//me gustaría hacerlo con for pero no me sale
		platoPutanesca2 = 0;
		platoPutanesca4 = 0;
		comeLock.readLock().unlock();
		System.out.println("el thread " + n + " que se encarga de los pares, ya ha hecho que coman los filósofos pares");

		}
	public void comiendo5(String n) {
		comeLock.readLock().lock();
		platoPutanesca5 = 0;
		comeLock.readLock().unlock();
		System.out.println("el thread " + n + " que se encarga de coma le filósofo 5");
		}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
