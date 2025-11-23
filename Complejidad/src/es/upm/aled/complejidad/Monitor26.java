package es.upm.aled.complejidad;

public class Monitor26 {
	int capacidad;
	int racionesRestantes;
	boolean alguienComiendo;
	boolean rellenando;
	boolean cocineroLlamado;
	//constructor	
//	join 
	
	
	//metodo paracanibales, comer
	
	public synchronized void comer(String n )throws InterruptedException {
		while(racionesRestantes ==0) {
			if(!cocineroAvisado) {
				cocienroAvisado = true;
				notifyAll();
			}
			cocineroLlamado = true;
			n.join();
		}
		
		while(alguienComiendo||rellenando) {
			wait();
		}
		alguienComiendo = true;
		racionesRestantes--;
	}
	
	public synchronized void rellenar (String n) throws InterruptedException{
		while(!cocineroLlamado) {
			wait();
			
		}
		racionesRestantes =capacidad;
		cocineroLlamado = false;
		notifyAll();
		}
	
	//main
	
	public static void main (String[] args) {
		Marmita marmita = new Marmita(5);
		
		//hebra cocinero
		new Thread(()->{
		try {
			while(true) {
				marmita.rellenar();
			}
			}catch(InterruptedException e ) {}
		},"Cocinero").start();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//metodo para cocineros, rellenar
}
