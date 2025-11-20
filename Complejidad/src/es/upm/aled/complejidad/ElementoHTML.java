package es.upm.aled.complejidad;

import java.util.List;

public class ElementoHTML {
	private String tag; // Ejemplo: "div", "p", "img"
	private List<ElementoHTML> hijos;
	public String getTag () { return this.tag; }
	public List<ElementoHTML> getHijos () { return this.hijos; }

	public static int contarEtiquetas (ElementoHTML elemento, String tagBuscado) {
		int contador =0;

		if(elemento.getTag().equals(tagBuscado)) {
			contador++;
		}
		for(ElementoHTML e1 :elemento.getHijos()) {
			 contador += contarEtiquetas(e1, tagBuscado);
		}
		
		return contador;
	}

}
