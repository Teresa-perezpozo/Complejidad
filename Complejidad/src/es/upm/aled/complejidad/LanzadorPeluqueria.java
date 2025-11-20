package es.upm.aled.complejidad;

import java.util.Random;

public class LanzadorPeluqueria {
	int NUM_CLIENTES = 50;
monitorPelu monitor = new monitorPelu();
Random rand = new Random();


    for (int i = 0; i < NUM_CLIENTES; i++) {
        Cliente cliente = new Cliente(monitor, "Cliente-" + i);
        Thread hebraCliente = new Thread(cliente, "Cliente-" + i);
        hebraCliente.start();
        
        try {
            // Hacemos que los clientes lleguen en intervalos aleatorios
            Thread.sleep(rand.nextInt(100)); // Un nuevo cliente cada 0-100 ms
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
