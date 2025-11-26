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
}
