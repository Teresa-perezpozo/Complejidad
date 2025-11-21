package es.upm.aled.complejidad;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class NodoLista { int dato; NodoLista siguiente; 
	
	
	public static NodoLista invertirRecursivo (NodoLista actual) {
		if (actual == null || actual.siguiente == null) {		
			return actual;		
		}
		NodoLista head = invertirRecursivo(actual.siguiente);
//		estamos apuntando el nodo actual siguiente hacia actual en vez de 
//		actual siguiente siguiente
		actual.siguiente.siguiente = actual;
		actual.siguiente = null;
		return head;
		
}

public static int contarFormasCambio (int objetivo, int[] monedas) {
	// es paso recursivo puede ir siendo o bien que llegue al final 
	if(objetivo==0) {
		return 000;
		
	}
	
	
	if(objetivo-5>0) {
		monedas[3] ++;
		return contarFormasCambio(objetivo-5,monedas);
	}if(objetivo-2>0) {
		monedas[2]++;
		return contarFormasCambio(objetivo-3, monedas);
	}if(objetivo-1>0) {
		monedas[1]++;
		return contarFormasCambio(objetivo-1, monedas);
	}

}
//3.1 
//la primera vez pasa 0 veces, la segunda pasa 1, luego 2, luego 3, así vamos sumando
//para n =3 p.ej daría seis, dos^3, para n = 4 contador +4 = 10
//n=0,contador =0;n=1, contador =1, n =2 contador =3, n =3 cont = 6
//n = 4, cont =3+6 =9, es decir, cada uno es (n-1)!, resumen sería n-1 + el contador anterior
//n+(n-1)+(n-2)....+1, la forma matemática sería la suma aritmética (n-1)*n/2

//complejidadComputacional=O(n^2) ya que el tiemop de ejecucion crece directamente 
//proporcional al tamaño de la entrada n

//3.2
// 5 2 4 6 1 3 
//n =6
//i=1
//clave =2
//j = 0
//datos[j] =5
//datos(j+1) = 2, osea en 2 va a haber 5
//siguiente iteración i =2
//clave = 4
//j = 1
//datos(j) = 2
//datos(j+1) = datos(j), es decir en 4 va 2, 
//estoy haciendo hueco en el primer puesto del array, el mejor caso es q N=1, solo se quedaría igual
//en el caso de n, tend´riamos que mover todo n veces, O (n^2)



//3.4
// me1 = 4.5- cogemos 4, 16 es menor, lo hacemos fuera del if
// ahora tenemos arr, inicio=5, fin=9, x=23
// me = 5 + (9-5)/ = 7, nos pasamos, siguiente
// en el if con arr, inicio = 5, fin = 6, x =23
//me = 5, y es la respuetas
//me1 = 4, me2=7 me3=5
//si no estuviese ordenado previamente habría que primero ordenarlo y luego bhscarlo o aplicar otro método
// la complejidad es o(logn)

//3.5
//cada bucle interno para cada j se hace 4 veces, en j = 1,2,4,8
//el bucle externo se hará 10 veces, entonces 4*10 = 40 
//la relación matemá tica será la del exteriorO(n) y la interiorr logn, entoncs la solucón será n*logn
// respecto al bucle iterno, e numero de pasos del bucle interno es igual a log2 n ya que crece j 
//exponencialemnte hasta llegar a n

//en el mejor paso, solo se haría una pasada del segunod for, O(n-1) ya que al variables intercambiado
//está ahí para si la primera vez está todo intercambiado, osea false, no haya q seguir
//en el caso de q no, sería la complejidadi O(n^2)

//3.8
//





















}