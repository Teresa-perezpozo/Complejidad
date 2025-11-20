package es.upm.aled.complejidad;

import java.util.concurrent.ThreadLocalRandom;

public class Temperatura implements Runnable{
private Monitor2_12 monitor;
//private int temperaturaCogida;
	public Temperatura (Monitor2_12 monitor) {
		this.monitor= monitor;
//		this.temperaturaCogida=temperaturaCogida;
	}
	public void run() {
			while(true) {
				int temperaturaCogida = ThreadLocalRandom.current().nextInt(15,40);

				monitor.notificarTemperatura(temperaturaCogida);
			}
		
	}
	
}
