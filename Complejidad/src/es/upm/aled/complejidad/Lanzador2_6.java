package es.upm.aled.complejidad;

public class Lanzador2_6 {

	public static void main(String[] args) {

	int  numCocineros = 3;
	int  numCanibales = 8;
	
	System.out.println("--- Iniciando Simulación Lectores/Escritores ---");
    System.out.println("Configuración: " + numCocineros + " Lectores, " + numCanibales + " Escritores.\n");
    Marmita2_6 marmita1 = new Marmita2_6();
	
	for (int i = 0; i < numCocineros; i++) {
        Runnable tareaCocinero = new accionesCocineros(marmita1, "Cocinero-" + (i + 1));
        Thread hebra = new Thread(tareaCocinero);
        hebra.start(); 
    }
	for (int i = 0; i < numCanibales; i++) {
        Runnable tareaCanibal = new accionesCanibales(marmita1, "Caníbal-" + (i + 1));
        Thread hebra = new Thread(tareaCanibal);
        hebra.start();	
    }
}
}


