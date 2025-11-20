package es.upm.aled.complejidad;

public class Persona implements Runnable{
 public String nombre;
 private Monitor2_12 monitor;
 private boolean esJubilado;
public Persona (String nombre, Monitor2_12 monitor, boolean esJubilado) {
	this.nombre= nombre;
	this.monitor=monitor;
	this.esJubilado=esJubilado;
}
 
@Override
public void run() {
	while(true) {
		if(!esJubilado) {
		System.out.println("el joven" + nombre + " va a entrar al museo " );
		monitor.entrarSala(nombre);
		System.out.println(nombre +" sale del museo");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			System.out.println(" ha habido un problema");
			e.printStackTrace();
		}//ya han visto la sala
		monitor.salirSala();
		//
		
		}if(esJubilado) {
			System.out.println("el jubilado" + nombre + " va a entrar al museo " );

			monitor.entrarSalaJubilados(nombre);
			System.out.println(nombre +" sale del museo");

			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				System.out.println(" ha habido un problema");

				// TODO Auto-generated catch block
				e.printStackTrace();
			}//los jubilados tardan más pq van más despacio
			monitor.salirSala();
		}
	}
}

 
}
