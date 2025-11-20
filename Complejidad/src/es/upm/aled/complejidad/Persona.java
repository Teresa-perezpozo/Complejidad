package es.upm.aled.complejidad;

public class Persona {
 private String nombre;
 private int edad;
 private enum edad {joven, jubilado};
 
 public Persona (String nombre, int edad, enum edad) {
	 this.nombre = nombre;
	 this.edad = edad;
	 this.cedad = edad;
	 
	 
 }
  public void esJubilado(String nombre) {
	  if(edad>65) {
		  enum = jubilado;
	  }else {
		  enum = joven;
	  }
  }
  public void personaentra (String persona) {
	  persona.entrar();
	  
  }
  public void personasale(String persona) {
	  persona.salir();
	  
  }
 
}
