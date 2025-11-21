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
				try {
					 while (true) { 
					System.out.println("el canibal número " + n +" está comiendo");
	                Thread.sleep(500 + (int)(Math.random() * 1500));
					marmita1.comer(n);
		            System.out.println("Caníbal " + n + " está satisfecho y deja de comer.");
					 }
				}catch(InterruptedException e ) {
					Thread.currentThread().interrupt();
				
				
		}
}
}
//EJERCICIO CLASE
//int sum = 0;
//for (int n = N; n > 0; n /= 2)
//for (int i = 0; i < n; i++)
//sum++;
//
//int sum = 0;
//for (int i = 1; i < N; i *= 2)
//for(int j = 0; j < i; j++)
//sum++;
//
//int sum = 0;
//for (int i = 1; i < N; i *= 2)
//for (int j = 0; j < N; j++)
//sum++
//


