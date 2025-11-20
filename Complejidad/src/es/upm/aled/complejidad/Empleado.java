package es.upm.aled.complejidad;

import java.util.List;

public class Empleado {
	private String nombre;
	private double salario;
	private List<Empleado> subordinados; // Lista de empleados a su cargo
	public Empleado (String nombre, double salario) { ... }
	public double getSalario () { return this.salario; }
	public List<Empleado> getSubordinados () { return this.subordinados; }
	
	
	public static double presupuestoEquipo (Empleado jefe) {

		double costeTotal =jefe.getSalario();
		for (Empleado e1 : jefe.getSubordinados()) {
			costeTotal += presupuestoEquipo(e1);
	    }

	    return costeTotal;
	}

}
