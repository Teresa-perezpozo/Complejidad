package es.upm.aled.complejidad;

import java.util.ArrayList;
import java.util.List;

public class Suma {
//sumo todos los valores de 1 a n con método recursivo
	
	
	public int suma(int n) {
		//caso base
		int suma =0;
		if(n ==1) {
			return 1;
		}
		return  n+ suma(n-1);
	}
	
	
	//tener todos los descendientes de una persona de clase Persona
	//persona tiene una lista de descendentes que se consiguen ocn getDescendientes
	public List<Persona> Descendientes(Persona p){
		List <Persona> descendientes = new ArrayList<>();
		
		
		//caso base
		if(p.hijos.size()==0) {
			return p;
		}
		
		for(Persona p: hijo) {
		descendientes = return hijo.getDescendientes();
		descendientes.add(p);
//		String descendientes = hijo.descendientes();
//		misDescendientes = misDescendientes + descendientes + ", ";
		}
		public void invertedLinkedList(Node node){

			while (actual != null) {
		        
		        // 1. Guardar el puntero para NO perder el resto de la lista.
		        siguiente = actual.siguiente; 

		        // 2. INVERSIÓN: El nodo actual ahora apunta hacia atrás.
		        actual.siguiente = anterior; 

		        // 3. AVANCE: Mover los punteros.
		        anterior = actual;  // 'anterior' pasa a ser el nodo que acabamos de invertir (el nuevo 'head').
		        actual = siguiente; // 'actual' pasa a ser el nodo que guardamos en el paso 1.
		    }

		    return anterior; // 'anterior' es la nueva cabeza.
				
		}
		
	}
	
	
	
}
