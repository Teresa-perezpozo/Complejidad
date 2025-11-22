package es.upm.aled.complejidad;

public class Lectores extends  Thread {
	LectoresMONITOR monitor = new LectoresMONITOR(3);
    private final String nombre;
    public HebraLectora(RecursoCompartido recurso, String nombre) {
        this.recurso = recurso;
        this.nombre = nombre;
    }
	@Override
	public void run() {
		try {
			while(true) {
				monitor.leer();
				
			}
		}catch(InterruptedException e ) {
			e.printStackTrace();
			Thread.currentThread().interrupt();
		}
	}
}
