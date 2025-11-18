package es.upm.aled.complejidad;

public class lanzador2_5rep {

	public static void main(String[] args) {
		mesa2_5 monitor = new mesa2_5(); // <-- O usar mesa2_5 si es el nombre original
		for (int i = 0; i < 5; i++) {
            Thread hebra = new Thread(new filosofo(monitor, i));
            hebra.start();
        }	
	}

}
