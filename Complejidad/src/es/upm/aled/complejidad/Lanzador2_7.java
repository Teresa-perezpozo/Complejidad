package es.upm.aled.complejidad;

public class Lanzador2_7 {

	public static void main(String[] args) {

		int numFumadores = 3;
		int numEstanqueros = 1;
		Piti piti = new Piti();
		Thread hebra1 = new Thread(new Fumador(false, false));//los fumadores empiezan sin tabaco ni papelas
		Thread hebra2 = new Thread(new Fumador(false, false));//los fumadores empiezan sin tabaco ni papelas
		Thread hebra3 = new Thread(new Fumador(false, false));//los fumadores empiezan sin tabaco ni papelas

		hebra1.start();
		hebra2.start();
		hebra3.start();
		Thread hebra4 = new Thread(new Estanquero(true, true));//el estanquero empieza con las dos, el problema esq se lo fume el 
		hebra4.start();
	}

}
