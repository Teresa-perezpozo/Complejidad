package es.upm.aled.complejidad;

import java.util.concurrent.ThreadLocalRandom;

public class Ciudadano implements Runnable {

	 private final monitor monitor;
	    private final String nombre;
	    private final boolean esVentanilla1;

	    public Ciudadano(monitor monitor, String nombre, boolean esVentanilla1) {
	        this.monitor = monitor;
	        this.nombre = nombre;
	        this.esVentanilla1 = esVentanilla1;
	    }

	    @Override
	    public void run() {
	        try {
	            // El ciudadano llega
	            if (esVentanilla1) {
	                monitor.esperarVentanilla1(nombre);
	            } else {
	                monitor.esperarVentanilla2(nombre);
	            }
	            
	            // Una vez que el método retorna, el ciudadano fue atendido.
	            System.out.println("   <-- Ciudadano " + nombre + " fue atendido y se marcha.");
	            
	        } catch (InterruptedException e) {
	            Thread.currentThread().interrupt();
	        }
	    }
	}