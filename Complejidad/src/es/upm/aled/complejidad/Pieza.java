package es.upm.aled.complejidad;

import java.util.List;

public class Pieza {
	private String nombre;
	private boolean esDefectuosa;
	private List<Pieza> componentes; // Piezas necesarias para montar esta
	public boolean isDefectuosa () { return this.esDefectuosa; }
	public List<Pieza> getComponentes () { return this.componentes; }
	
	
	public static boolean contieneDefectos (Pieza piezaPrincipal) {
		
		if(piezaPrincipal.isDefectuosa()) {
			return true;
		}
		for(Pieza p1:piezaPrincipal.getComponentes()) {
			if (contieneDefectos(p1)) {
                return true; // ...propagamos ese TRUE hacia arriba inmediatamente.
            }
			}
		
		
		return false;
	}

}
