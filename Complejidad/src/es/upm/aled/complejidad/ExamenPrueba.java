package es.upm.aled.complejidad;

public class ExamenPrueba {
	public static double getTotalLength(Node startNode) {

	    if (startNode == null) {
	        return 0.0;
	    }

	    double total = 0.0;

	    if (startNode.getChildren() != null) {
	        for (Segment s : startNode.getChildren()) {
	            total += s.getLength();
	            total += getTotalLength(s.getEndNode());
	        }
	    }

	    return total;
	}
	
	//ejercicio 3
	public synchronized void solicitarImpresion(boolean esProfesor) {
	    try {
	        while (impresoraEnUso || (esProfesor && (profesoresEsperando >= 2))) {
	            if (esProfesor) profesoresEsperando++;
	            wait();
	        }

	        if (esProfesor) profesoresEsperando--;
	        impresoraEnUso = true;

	    } catch (InterruptedException e) {}
	}

	public synchronized void liberarImpresora() {
	    try {
	        impresoraEnUso = false;
	        notifyAll();
	    } catch (Exception e) {}
	}public class Estudiante extends Thread {
	    private Sala Impresion sala;

	    public Estudiante(Sala sala, Impresion sala) { 
	        this.sala = sala; 
	    }

	    public void run() {
	        try {
	            while (true) {
	                int eleccion = Random.Math(); // * int eleccion: Random.Math();
	                boolean esProfesor = eleccion > 0.5;

	                sala.solicitarImpresion(esProfesor);

	                sala.imprimir();

	                sala.liberarImpresora();

	            }
	        } catch (InterruptedException e) {
	            Thread.currentThread().interrupt();
	        }
	    }
	}
}
