package es.upm.aled.complejidad;

import java.util.concurrent.ThreadLocalRandom;

public class Vehiculo implements Runnable{
	//SIEMPRE SE ME OLVIDA
private monitor2_10 monitor;
//hay q ponerle nombre para ser capaz de distinguir dos coches 
//uqe entran con el mismo peso q no son ambulancias
private int peso;
private boolean ambulancia;
private String nombre;

//hago un constructor
public Vehiculo(monitor2_10 monitor, int peso, boolean ambulancia,String nombre) {
	this.monitor=monitor;
	this.peso = peso;
	this.ambulancia = ambulancia;
	this.nombre = nombre;
}
public void run() {
	try {
		//entramos y salimos, lo ponemos aleatorio el tiempo para que sea más realista
		monitor.entrarPuente(peso, ambulancia);
		Thread.sleep(ThreadLocalRandom.current().nextInt(1000, 3000));
        monitor.salirPuente(peso, nombre);
        
	}catch(InterruptedException e ){
    Thread.currentThread().interrupt();

}
}
}
