package es.upm.aled.complejidad;

import java.util.LinkedList;
import java.util.List;

public class Monitor2_12 {
//hay que hacer 4 hebras, en promer lugar la del monitor, que controla todas las prioridad,es temperaturas, 
	// recursos compartidos, osea temperatura aforo, aforo medio...etc
	// en segundo lugar haremos una clase de personas , con un random q me dirá si
	// es jubilado o no
	// por último hacermos un lanzador de hebras, a ser posible de manera aleatoria
	// mi duda es si hacer entrar sala para jubilados o todos a la misma, si hago
	// todos a la misma
	// luego no tendría q hacer dos clases distintas para personas y jubilados??
	int temperatura;
	int numPersonas;// numero de personas dentro, dentro son todos personas, no discernimos
	int aforo = 50;
	int aforoMedio = 35;
	int aforoActual=50;
	int limTemperatura = 30;
	private List<String> numJovenes= new LinkedList<>();// esta sería la cola basicamente
	private List<String> numJubilados= new LinkedList<>();// la voy a hacer de string con el nombre pero ralmente podría hacerla
	// de personas

	public synchronized void entrarSala(String nombre) {
		numJovenes.add(nombre);
		try {
			if(temperatura<limTemperatura) {
				aforoActual=aforo;
					
				}else {
					aforoActual=aforoMedio;
				}
			if(numPersonas<aforoActual) {
				numPersonas++;
				numJovenes.remove(nombre);
			}else {
				System.out.println(nombre+" esperando a entrar");

			wait();
			}
			
				
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	}

	public synchronized void entrarSalaJubilados(String nombre) {
		numJubilados.add(nombre);
		try {
			if(temperatura<limTemperatura) {
				aforoActual=aforo;
					
				}else {
					aforoActual=aforoMedio;
				}
			if(numPersonas<aforoActual) {
				numPersonas++;
				numJubilados.remove(nombre);
			}else {
				System.out.println(nombre+" esperando a entrar");
			wait();
			}
			
				
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	}

	public synchronized void salirSala() {
		numPersonas--;
		notifyAll();
	}

	public  synchronized void notificarTemperatura (int temperaturaCogida) {
		temperatura =temperaturaCogida;
		System.out.println("acabo de actualizar la temperatura y esta es"+ temperaturaCogida);
		notifyAll();
		

	
	}
}
//este método estaría de locos para no tener que crear dos hebras para personas jubildas y no
//y ponerlo simplemente como atributo en cada una 
//	public  synchronized void entrarSala (Persona p) {
//		try {
//		while(temperatura<limTemperatura) {
//			if(numPersonas<aforo) {
//				if(p.esJubilado) {//aqui ya damos poer hecho q haremos una clase de personas y ya discernimos denrto 
//					numJubilados.remove(p);
//					numPersonas++;
//				}else {
//				numPersonas++;
//				numJovenes.remove(p);
//			}
//		}
//		
//		//es decir si la temperatura si que supera el límite de 30º
//		}if(numPersonas<aforoMedio) {
//			if(p.esJubilado) {//aqui ya damos poer hecho q haremos una clase de personas y ya discernimos denrto 
//				numJubilados.remove(p);
//				numPersonas++;
//			}else {
//			numPersonas++;
//			numJovenes.remove(p);
//		}
//		
//		}else {
//			wait();
//		}
//	} catch (InterruptedException e) {
//        Thread.currentThread().interrupt();
//    }
//	}
//	


