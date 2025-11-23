package es.upm.aled.complejidad;

public class Lanzador26 {
    public static void main(String[] args) {
    	
    	int numCocineros = 2;
    	int numCanivales = 6;
    	Monitor26 monitor = new Monitor26();
    	for(int i =0;i<numCocineros;i++) {
    	
    		Thread t = new Cocinero(monitor, "cocinero"+i);
    		t.start();
    	}
    	
    	
    	
    }
}
