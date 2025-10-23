package es.upm.aled.complejidad;

import java.util.HashMap;

public class agendaTelefonica {
private HashMap<String,Integer> agenda;
 public agendaTelefonica() {
	 this.agenda = new HashMap<>();
	 }
 
 public void anadirPersona(String p, Integer num) {
	 agenda.put(p, num);
 }
 public int obtenerTelefono(String p) {
	 return agenda.get(p);
 }
 
 
}
