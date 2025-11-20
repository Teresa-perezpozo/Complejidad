package es.upm.aled.complejidad;

public class Cliente implements Runnable {
public String nombre;
private monitorPelu monitor;


public Cliente(monitorPelu monitor, String nombre) {
	this.nombre = nombre;
	this.monitor=monitor;
}


@Override
public void run() {
	try {
		while(true) {
			System.out.println("el cliente va a intentear cortarse el pelo");
			monitor.cortarPelo(nombre);
			
		}
	}catch(InterruptedException e ) {
		Thread.currentThread().interrupt();
	}
}
}
