package es.upm.aled.complejidad;

import java.util.List;

public class Habilidad {
	private String id;
	private int costePuntos; // Coste para desbloquear esta habilidad
	private List<Habilidad> desbloqueables; // Habilidades que dependen de esta
	public int getCoste () { return this.costePuntos; }
	public List<Habilidad> getDesbloqueables () { return this.desbloqueables; }
	
public static int costeRamaCompleta (Habilidad raiz) {
	
	int puntosTotales = raiz.costePuntos;
	for(Habilidad h1:raiz.getDesbloqueables()) {
		puntosTotales+=costeRamaCompleta(h1);
}
return puntosTotales;
}
}
