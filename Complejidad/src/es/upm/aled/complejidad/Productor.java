package es.upm.aled.complejidad;

public class Productor extends Thread{

	Monitor24 monitor = new Monitor24();
	private String name;
	@Override
	public void run() {
		try {
			while(true) {
				monitor.accesoEscribir(name);
				Thread.sleep(200);
				monitor.escribiendo();
				monitor.terminoEscribir(name);
			}
		}
	}
	
}
