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
	public static boolean esPalindromo (String texto) {
		
		if(texto.length()<=1) {
			return true;
		}
		 char primera = texto.charAt(0);
	     char ultima = texto.charAt(texto.length() - 1);
	        
	        if (primera != ultima) {
	            return false; // No son iguales, la recursión termina aquí con FALSE.
	        }
		
	        String subcadenaInterna = texto.substring(1, texto.length() - 1);
	        
	        return esPalindromo(subcadenaInterna);
	}

}
