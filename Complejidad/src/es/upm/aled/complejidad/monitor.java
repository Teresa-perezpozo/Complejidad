package es.upm.aled.complejidad;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
//cuando hay q establecer una prioridad se establece lo mejor en el monitor
//lo ideal es que en ciudadanos y funcionarios solo le pida al monitor q ejecute
//el try catch es tanto en los runnables como en los void	
public class monitor {
	int cores = Runtime.getRuntime().availableProcessors();

	 private final List<String> colaVentanilla1 = new ArrayList<>();
	 private final List<String> colaVentanilla2 = new ArrayList<>();
	    private boolean andresDurmiendo = false;

	   int ultimoCola1 =0;
	   int ultimoCola2 =0;
//MÉTODOS PARA CIUDADANOS
	
	//MÉTODO PARA ESPERAR VENTANILLA 1

	public synchronized void esperarVentanilla1(String nombreCiudadano) throws InterruptedException{
        colaVentanilla1.add(nombreCiudadano);
        System.out.println("-> Ciudadano " + nombreCiudadano + " llega a Ventanilla11. Total V1: " + colaVentanilla1.size());
        
        // 2. Verificar si estaba durmiendo y despertar si es el primero en llegar
        if (colaVentanilla1.size() + colaVentanilla2.size() == 1 && andresDurmiendo) {
             System.out.println("--- Ciudadano " + nombreCiudadano + " (V1) carraspea. Despierta a Andrés.");
             andresDurmiendo = false; // Ya no está durmiendo
             notifyAll(); // Despierta al Funcionario
        }
        while (colaVentanilla1.contains(nombreCiudadano)) {
            wait();
        }
	}

	

//MÉTODO PARA ESPERAR VENTANILLA 2

	public synchronized void esperarVentanilla2(String nombreCiudadano) throws InterruptedException {
        // 1. El ciudadano se une a la cola
        colaVentanilla2.add(nombreCiudadano);
        System.out.println("-> Ciudadano " + nombreCiudadano + " llega a V2. Total V2: " + colaVentanilla2.size());
        
        // 2. Verificar si estaba durmiendo y despertar si es el primero en llegar
        if (colaVentanilla1.size() + colaVentanilla2.size() == 1 && andresDurmiendo) {
             System.out.println("--- Ciudadano " + nombreCiudadano + " (V2) carraspea. Despierta a Andrés.");
             andresDurmiendo = false;
             notifyAll();
        }
        
        // 3. El ciudadano espera pasivamente a ser atendido
        while (colaVentanilla2.contains(nombreCiudadano)) {
            wait();
        }
    }

	public synchronized void atenderCiudadano() throws InterruptedException {
        // Lógica de la siesta: si no hay nadie, se duerme.
        while (colaVentanilla1.isEmpty() && colaVentanilla2.isEmpty()) {
            System.out.println("   [ANDRÉS] No hay nadie. Echa una siesta rápida...");
            andresDurmiendo = true;
            wait(); // Duerme hasta que un ciudadano lo despierte (notifyAll)
        }
        andresDurmiendo = false; // Si se despertó o había gente, ya no duerme.

        // 1. DECISIÓN DE ATENCIÓN (Prioridad: Más larga, V1 en empate)
        String ciudadanoAtendido = null;
        int ventanillaAtendida;

        // Reglas de prioridad:
        if (colaVentanilla1.size() >= colaVentanilla2.size()) {
            // Atender V1 (por ser más larga o por empate)
            ciudadanoAtendido = colaVentanilla1.remove(0); // Atender al primero (FIFO)
            ventanillaAtendida = 1;
        } else {
            // Atender V2 (solo si es estrictamente más larga)
            ciudadanoAtendido = colaVentanilla2.remove(0); // Atender al primero (FIFO)
            ventanillaAtendida = 2;
        }

        // 2. Proceso de Atención
        System.out.println(">>> [ANDRÉS] Atiende C." + ciudadanoAtendido + " de V" + ventanillaAtendida + ". (V1:" + colaVentanilla1.size() + ", V2:" + colaVentanilla2.size() + ")");
        
        // Simular tiempo de atención
        Thread.sleep(500); 

        // 3. Desbloquear al ciudadano y notificar a otros que la cola se movió
        notifyAll(); 
    }
}
