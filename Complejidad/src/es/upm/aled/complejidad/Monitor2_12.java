package es.upm.aled.complejidad;

public class Monitor2_12 {

	
	Random temperatura ;
	int numPersonas;
	int aforo = 50;
	int aforoMedio = 35;
	int limTemperatura = 30;
	
	
	public  synchronized void entrarSala () {
		try {
		while(temperatura<limTemperatura) {
			if(numPersonas<aforo) {
				numPersonas++;
			}else {
				wait();
			}
		}
		
		//es decir si l atemperatura si que supera el límite de 30º
		if(numeroPersonas<aforoMedio) {
			numPersonas++;
		}else {
			wait();//les pongo a esperar a q salga otra persona
		}
		
		
	} catch (InterruptedException e) {
        Thread.currentThread().interrupt();
    }
	}
	
	
	
	public  synchronized void entrarSalaJubilado () {
		try {
		while(temperatura<limTemperatura) {
			if(numPersonas<aforo) {
				numPersonas++;
			}else {
				wait();
			}
		}
		
		//es decir si l atemperatura si que supera el límite de 30º
		if(numPersonas<aforoMedio) {
			numPersonas++;
		}else {
			wait();//les pongo a esperar a q salga otra persona
		}
		
		
	} catch (InterruptedException e) {
        Thread.currentThread().interrupt();
    }
	}
	
	public synchronized void salirSala() {
		numPersonas--;
		}
	
	public void synchronized notificarTemperatura (int temperatura) {
		Random rand = new Random(0,40);//mas  o menos temperatura media
		
		

	
	}



}
