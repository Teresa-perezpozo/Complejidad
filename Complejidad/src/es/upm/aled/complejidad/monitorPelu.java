package es.upm.aled.complejidad;

import java.util.Random;

public class monitorPelu {

	//en esta primera versión del problema hare un monitor, que tendra toods lo recursos compartidos
//	como van a ser los sillones y la silla, el numero de gente total en la pelu... aquí minimo necesitamos
//	el metodo sentarse en silla y cortarse el pelo, sentase en sofá a esperar, 
//	luego tenemos que hacer una clase que sea peluquero
	
	private int sofas = 5;
	private int sillaPeluqueria=1;
	private int sofasOcupados=0;
	public int sillasBarOcupadas =0;
	public int sillasBar=15;
	private boolean sillaPeluqueriaOcupada=false;
	private Random random = new Random();
	
	
	public synchronized boolean cortarPelo(String persona) throws InterruptedException {
		
		if (sillaPeluqueriaOcupada && sofasOcupados == sofas&& sillasBarOcupadas == sillasBar) {
	            System.out.println("Cliente " + persona + " se va de la pelu");
	            return false;
			
		}if(!sillaPeluqueriaOcupada) {
			sillaPeluqueriaOcupada=true;
			System.out.println(persona + " se ha sentado en la silla a q le corten el pelo ");
			return true;
		}
        if (sofasOcupados < sofas) {
            sofasOcupados++;
            System.out.println(persona + " espera en el sofá");
            
            // Espera en el sofá hasta que la silla quede libre
            while (sillaPeluqueriaOcupada) {
                try {
                    wait(); // Espera una notificación (de salirPeluqueria)
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            sofasOcupados--;
            sillaPeluqueriaOcupada = true;
            System.out.println(persona+ " ha estado esperando en el sofá y va a cortarse el pelo porfín");
            return true;
        }
        if (sillasBarOcupadas < sillasBar) {
            sillasBarOcupadas++;
            System.out.println(persona + " espera tomandose algo");
            
            // Espera en el bar hasta que la silla quede libre o el sofá
            while (sofasOcupados==sofas) {
                try {
                    wait(); // Espera una notificación (de sofaslibres)
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            sillasBarOcupadas--;
            sofasOcupados++;
            System.out.println(persona + " ha estado esperando en la barra y se va al sofá");
            return true;
        }
        
        
        return false; // No debería llegar aquí, pero por si acaso
    }
	
	 public synchronized void salirPeluqueria() {
	        sillaPeluqueriaOcupada = false;
	        System.out.println("Cliente " + Thread.currentThread().getName() + " SALE de la peluquería.");
	        
	         notifyAll();
	    }
	 public void simularCortePelo() {
	        try {
	            // Tiempo necesario para cortar el pelo: de 0 a 400 milisegundos
	            Thread.sleep(random.nextInt(401));
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
	    }
	
	
	
	
}
