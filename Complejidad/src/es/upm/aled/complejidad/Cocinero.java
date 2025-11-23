package es.upm.aled.complejidad;

public class Cocinero extends Thread{
Monitor26 monitor;
String name;
//constructor con el monitor
	@Override
	public void run() {
		try {
			while(true) {
				monitor.rellenar(name);
			}
		}catch(InterruptedException e ) {}
	}
	
	public class Canival extends Thread{
//		name monitor constructor con eso
		@Override
		public void run() {
			try {
				while(true) {
					monitor.comer(name);
				}
			}catch(InterruptedException e ) {}
		}
	}
}
