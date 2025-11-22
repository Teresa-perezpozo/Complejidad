package es.upm.aled.complejidad;

import java.util.List;

public class Carpeta {
//		private String nombre;
//		private List<Archivo> archivos; // Archivos directos en esta carpeta
//		private List<Carpeta> subcarpetas; // Carpetas dentro de esta carpeta
//		public Carpeta (String nombre) {this.nombre = nombre; }
//		public List<Archivo> getArchivos () { return this.archivos; }
//		public List<Carpeta> getSubcarpetas () { return this.subcarpetas; }
////		
////public static double calcularPesoTotal (Carpeta inicio) {
////int sumTotal =0.0F;
////	if(archivos.size!=null) 
////	for(Archivo a :INICIO.getArchivos)
////	{sumTotal +=a.getPesoMB;}
////	
////	if(subcarpetas.size()!=null) {for(Carpeta c :subcarpetas) { pesoTotal += calcularPesoTotal(sub)();}
//
//		
//		public class Empleado {
//			private String nombre;
//			private double salario;
//			private List<Empleado> subordinados; // Lista de empleados a su cargo
//			public Empleado (String nombre, double salario) { ... }
//			public double getSalario () { return this.salario; }
//			public List<Empleado> getSubordinados () { return this.subordinados; }
//			}
//		
//		public static double presupuestoEquipo (Empleado jefe) {}
//		public static double presupuestoEquipo(Empleado jefe) {
//			if (jefe == null)
//				return 0.0;
//		double dineroTotal+=jefe.getSalario();
//		
//		for(Empleado e: jefe.getSubordinados) {
//			dineroTotal += presupuestoEquipo(e);
//		}
////		if (jefe.getSubordinados() != null) {
////			for (Empleado sub : jefe.getSubordinados()) {
////				total += presupuestoEquipo(sub);
//		
//		return dineroTotal;
//		
//		
//		
//		
//		public class Habilidad {
//			private String id;
//			private int costePuntos; // Coste para desbloquear esta habilidad
//			private List<Habilidad> desbloqueables; // Habilidades que dependen de esta
//			public int getCoste () { return this.costePuntos; }
//			public List<Habilidad> getDesbloqueables () { return this.desbloqueables; }
//			}
//		
//		public static int costeRamaCompleta(Habilidad raiz) {
//		    if (raiz == null) return 0;
//
//		    // Coste de la habilidad actual
//		    int total = raiz.getCoste();
//
//		    // Paso recursivo: sumar costes de las habilidades desbloqueables
//		    if (raiz.getDesbloqueables() != null) {
//		        for (Habilidad h : raiz.getDesbloqueables()) {
//		            total += costeRamaCompleta(h);
//		        }
//		    }
//
//		    return total;
//		}
//		public static int costeRamaCompleta (Skill raiz) {if(raiz==nul) {return 0}double puntosTotales= raiz.costePuntos for(Habilidad h:raiz.getDesbloqueables) {puntosTotales+=h.costeRamaCompleta(h)}}
//		
//		public class ElementoHTML {
//			private String tag; // Ejemplo: "div", "p", "img"
//			private List<ElementoHTML> hijos;
//			public String getTag () { return this.tag; }
//			public List<ElementoHTML> getHijos () { return this.hijos; }
//			}
//		
//		
//		
//		public static int contarEtiquetas (ElementoHTML elemento, String tagBuscado) {}
//		if(elemento ==null||tagBuscado == null) {
//			return 0;
//		}
//		int conteo = 0;
//		if(elemento.getTag().equals(tagBuscado)) 	{
//			conteo=1;//pq luego como hago lo de +=
//			}
//		if (elemento.getHijos() != null) {
//		for(ElementoHTML e :elemento.getHijos) {
//			conteo+= contarEtiquetas(e,tagBuscado);
//		}
//		}
//		return conteo;
//		}
//		
//		
//		public class Pieza {
//			private String nombre;
//			private boolean esDefectuosa;
//			private List<Pieza> componentes; // Piezas necesarias para montar esta
//			public boolean isDefectuosa () { return this.esDefectuosa; }
//			public List<Pieza> getComponentes () { return this.componentes; }
//			}
//		
//		public static boolean contieneDefectos (Pieza piezaPrincipal) {
//
//		boolean esDefectuosa = false;
//		
//		if(piezaPrincipal ==null) {
//			return false;
//		}
//		if(piezaPrincipal.esDefectuosa) {
//			return true;
//		}
//		if(piezaPrincipal.getComponentes()!=null) {
//			for(Pieza p : piezaPrincipal.getComponentes()) {
//				if (contieneDefectos(p)) {
//					return true;
//				}
//			}
//		}
//		
//		
//		public static boolean esPalindromo (String texto) {
//		
//		if(texto.length()==0||texto.length()==1) {
//			return true;
//		}
//		char primera = texto.charAt(0);
//        char ultima = texto.charAt(texto.length() - 1);
//        
//        if (primera != ultima) {
//            return false; // No son iguales, NO es palíndromo.
//        }
//        String subcadenaInterna = texto.substring(1, texto.length() - 1);
//
//        return esPalindromo(subcadenaInterna);
//		}
//		
//		public class Nodo { int valor; Nodo izq, der; }
//		public static boolean esBST (Nodo nodo) {
//		return esBSTAux(nodo, Integer.MIN_VALUE, Integer.MAX_VALUE);
//		}
//		private static boolean esBSTAux (Nodo nodo, int min, int max) {
//			
//			if (nodo == null) {
//				return true;
//			}
//			if(nodo.valor <=min ||nodo.valor >=max) {
//				return false;
//			
//		}
//		
//		
//		return esBSTAux(izq,min,nodo) && esBSTAux(der, nodo, max);
//		
		
		
		public class NodoLista { int dato; NodoLista siguiente; }
		public static NodoLista invertirRecursivo (NodoLista actual) {
			if (actual == null || actual.siguiente == null) {
				return actual;
				}
			
			NodoLista nuevaCabecera = invertirRecursivo(actual.siguiente);
			actual.siguiente.siguiente = actual;
			actual.siguiente = null;
			return nuevaCabecera;

			NodoLista siguiente actual=actual.siguiente;
			actual.siguiente=anterior;
			actual= siguiente;
			invertirRecursivo(siguiente);
		
		return siguiente;
		
		}
		
		public static int contarFormasCambio (int objetivo, int[] monedas) {
			if(objetivo==0||objetivo<0||monedas.length==0) {
				return 0;
			}
			int solución =0;
			
			if(objetivo%1 ==0) {
				solucion++;
				
			
			
			
			
		}

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
}