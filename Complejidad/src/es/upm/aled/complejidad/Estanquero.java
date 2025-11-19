package es.upm.aled.complejidad;

public class Estanquero implements Runnable{
	private Piti  piti;

	
	public Estanquero(Piti piti) {
		this.piti= piti;
		
	}

	@Override
	public void run() {
			try {
			    while (true) {
			    	piti.depositarIngredientes();
			    	Thread.sleep(300);//descanso un poco antes de volver a reponer
			    	}
			}catch(InterruptedException e ) {
				Thread.currentThread().interrupt();
			}
			}	
}
