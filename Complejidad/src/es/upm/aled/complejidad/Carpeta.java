package es.upm.aled.complejidad;

import java.util.ArrayList;
import java.util.List;

public class Carpeta {
	private String nombre;
	private List<Archivo> archivos; // Archivos directos en esta carpeta
	private List<Carpeta> subcarpetas; // Carpetas dentro de esta carpeta
	public Carpeta (String nombre) {
		this.nombre = nombre;
		this.archivos=new ArrayList<>();
		this.subcarpetas=new ArrayList<>();
	}
	public List<Archivo> getArchivos () { return this.archivos; }
	public List<Carpeta> getSubcarpetas () { return this.subcarpetas; }
	
	
	
public static double calcularPesoTotal (Carpeta inicio) {

	double pesoTotal =0.0F;
	for (Archivo archivo : this.archivos) {
        pesoTotal += archivo.getPesoMB();
    }


    for (Carpeta subcarpeta : this.subcarpetas) {
        pesoTotal += subcarpeta.calcularPesoTotal(subcarpeta);
    }

    return pesoTotal;
}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
