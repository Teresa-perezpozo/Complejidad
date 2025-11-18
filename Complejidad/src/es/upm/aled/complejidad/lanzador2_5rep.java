package es.upm.aled.complejidad;

public class lanzador2_5rep {

	public static void main(String[] args) {
		for (int i = 0; i < 5; i++) {
            Thread hebra = new Thread(new Filosofo(monitor, i), "Filósofo-" + i);
            hebra.start();
        }	
	}

}
