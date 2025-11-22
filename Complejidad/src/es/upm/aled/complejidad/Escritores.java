package es.upm.aled.complejidad;

public class Escritores extends Thread{

	LectoresMONITOR monitor = new LectoresMONITOR(3);
    private final String nombre;
    public HebraLectora(RecursoCompartido recurso, String nombre) {
        this.recurso = recurso;
        this.nombre = nombre;
    }

	//realmente aqui no hacen falta el while true pq no hay agente
	@Override
	public void run() {
		try {
			while(true) {
				monitor.escribir();
			}
		}catch(InterruptedException e ) {
			e.printStackTrace();
			Thread.currentThread().interrupt();
			}
	}
	
}
