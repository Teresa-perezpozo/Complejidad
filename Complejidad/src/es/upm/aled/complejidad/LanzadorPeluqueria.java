package es.upm.aled.complejidad;

public class LanzadorPeluqueria {
	monitorPelu monitor;
	int numClientes = 50;
	
	for(int i = 0;i<numClientes; i++) {
		Thread hebra = new Thread (monitor, ("cliente"+i));
		hebra.start();
	}
}
