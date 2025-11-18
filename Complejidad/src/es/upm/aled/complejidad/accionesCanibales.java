package es.upm.aled.complejidad;

public class accionesCanibales implements Runnable {

		private final Marmita2_6 marmita1;
		private final String n;
		public accionesCanibales(Marmita2_6 marmita1 ,String n ) {
			this.marmita1= marmita1;
			this.n = n;
		}
	
		@Override
		public void run() {
			while(true) {
				try {
					System.out.println("el canibal número " + n +" está comiendo");
					marmita1.comer(n);
					Thread.sleep(100); //simulamos que come su puchero
					Thread.sleep(800);
				}catch(InterruptedException e ) {
					Thread.currentThread().interrupt();
				}return;
			}
		}
}
