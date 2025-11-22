package es.upm.aled.complejidad;

import java.util.List;

public class Carpeta {
		private String nombre;
		private List<Archivo> archivos; // Archivos directos en esta carpeta
		private List<Carpeta> subcarpetas; // Carpetas dentro de esta carpeta
		public Carpeta (String nombre) {this.nombre = nombre; }
		public List<Archivo> getArchivos () { return this.archivos; }
		public List<Carpeta> getSubcarpetas () { return this.subcarpetas; }
//		
//public static double calcularPesoTotal (Carpeta inicio) {
int sumTotal =0.0F;
	if(archivos.size!=null) 
	for(Archivo a :INICIO.getArchivos)
	{sumTotal +=a.getPesoMB;}
	
	if(subcarpetas.size()!=null) {for(Carpeta c :subcarpetas) {c.getArchivos().getPesoMB();}
		
}