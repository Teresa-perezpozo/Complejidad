package es.upm.aled.complejidad;

public class Lanzador2_7 {

	public static void main(String[] args) {
		Piti piti = new Piti();
		System.out.println("--- Iniciando Simulación Los Tres Fumadores ---");

		
		Thread hebra1 = new Thread(new Fumador(piti,  "Tabaco"), "Fumador-Tabaco");
		Thread hebra2 = new Thread(new Fumador(piti, "Papela"), "Fumador-Papela");
		Thread hebra3 = new Thread(new Fumador(piti, "Mechero"), "Fumador-mechero");
		hebra1.start();
		hebra2.start();
		hebra3.start();
		Thread hebra4 = new Thread(new Estanquero(piti), "Estanquero");
		hebra4.start();
	}

}
