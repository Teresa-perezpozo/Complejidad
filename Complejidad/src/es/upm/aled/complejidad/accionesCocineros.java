package es.upm.aled.complejidad;

public class accionesCocineros implements Runnable{
	
	private final Marmita2_6 marmita1;
	private final String n;
	public accionesCocineros(Marmita2_6 marmita1 ,String n ) {
		this.marmita1= marmita1;
		this.n = n;
	}

	@Override
	public void run() {
		while(true) {
			try {
				System.out.println("el cocinero número " + n +" está cocinando");
				marmita1.rellenar(n);				Thread.sleep(100); //simulamos que come su puchero
				
			}catch(InterruptedException e ) {
				Thread.currentThread().interrupt();
			}return;
		}
	}
}
