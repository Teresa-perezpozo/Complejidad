package es.upm.aled.complejidad;

import java.util.concurrent.ThreadLocalRandom;

public class LineProduccion implements Runnable {
	private final CestaPiezas cesta;
    private final String colorProducido;
    private final String nombreLinea;
	
	public LineProduccion (String colorProducido, CestaPiezas cesta, String nombreLinea) {
		this.colorProducido=colorProducido;
		this.cesta=cesta;
		this.nombreLinea = nombreLinea;
	}
	@Override
	public void run () {
		while(true) {
			try {
			System.out.println("la linea de produciión ahora está trabajando");
            // Simulamos tiempo de producción
            Thread.sleep(ThreadLocalRandom.current().nextInt(50, 150)); 
            
            // Intentar depositar la pieza
            cesta.depositar(colorProducido); 

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return;
        }
    }
}

		
	}

