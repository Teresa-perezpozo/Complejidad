package es.upm.aled.complejidad;

import java.util.LinkedList;
import java.util.List;

public class CestaPiezas {
//realmente es el monitor y gestor de una sola cesta, es decir unn color
	private List<String> cesta = new LinkedList<>();
	final int CapacidadMAX = 50;
	private final String nombreCesta;
	public CestaPiezas(String nombreCesta) {
		this.nombreCesta=nombreCesta;
	}
	
	public synchronized void depositar(String pieza) throws InterruptedException{
		try {
		while(cesta.size()==CapacidadMAX) {
			System.out.println(" vamos a esperar pq ya se ha llenado la capacidad de la cesta");
			
			wait();
		}
		cesta.add(pieza);
		System.out.println(" vamos a meter un LEGO a la cesta");
		notifyAll();
		}catch(InterruptedException e ){
		    Thread.currentThread().interrupt();
		}
	}
	public synchronized String retirar () throws InterruptedException{
		
		
		while(cesta.size() == 0) {
			System.out.println("la cesta está vacía y no puedo retirar nada");
			wait();
		}
		System.out.println(" voy a quitar la pieza pq está disponible en la cesta");
		String pieza = cesta.remove(0);
		cesta.remove(pieza);
		notifyAll();
		return pieza;
	
	
	
	}
}

