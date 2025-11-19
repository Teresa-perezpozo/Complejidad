package es.upm.aled.complejidad;

public class LineaRoja implements Runnable{
 private final Monitor2_11 monitor;
 private int numRojos;
 
 //hago el constructor
 public LineaRoja(Monitor2_11 monitor, int numRojos) {
	 this.monitor=monitor;
	 this.numRojos =numRojos;
 }
 
 public void run() {
	 try {
		 System.out.println("fabricación bloque rojo en marcha");
		 numRojos++;
		 System.out.println("bloque rojo creado");

	 }catch(InterruptedException e ) {
		 Thread.currentThread().interrupt();
	 }
 }
 
}
