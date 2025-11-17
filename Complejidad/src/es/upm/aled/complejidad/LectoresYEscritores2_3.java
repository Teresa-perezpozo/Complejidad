package es.upm.aled.complejidad;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
//Ejemplo para la hebra escritora

public class HebraEscritora extends Thread {
 private RecursoCompartidoSimplificado monitor;
 private Prioridad prioridad;

 public HebraEscritora(RecursoCompartidoSimplificado monitor, Prioridad p) {
     this.monitor = monitor;
     this.Prioridad = p;
 }

 @Override
 public void run() {
     try {
         monitor.empezarEscribir(prioridad);
         int nuevoValor = ThreadLocalRandom.current().nextInt(0, 10001); 
         System.out.println("Escritor (" + prioridad + ") escribió: " + nuevoValor);
         // Simular trabajo
         Thread.sleep(10);
         GestorThreads2_3.terminarEscribir(nuevoValor);
     } catch (InterruptedException e) {
         Thread.currentThread().interrupt();
     }
 }
}

