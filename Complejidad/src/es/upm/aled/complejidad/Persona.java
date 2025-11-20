package es.upm.aled.complejidad;

public class Persona implements Runnable{
 private String nombre;
 private Monitor2_12 monitor;
public Persona (String nombre, Monitor2_12 monitor) {
	this.nombre= nombre;
	this.monitor=monitor;
}
 
@Override
public void run() {
	try {
		while(true) {
			System.out.println("el joven" + nombre + " va a entrar al museo " );
			monitor.entrarSala(null);
			
		}
	}
}

 
}
