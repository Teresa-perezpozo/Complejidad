package es.upm.aled.complejidad;

import java.util.Random;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class LectorEscritor2_2 {
    private int valor1 = 0;
    private int valor2 = 0;

    private final ReentrantReadWriteLock rwLock1 = new ReentrantReadWriteLock();
    private final ReentrantReadWriteLock rwLock2 = new ReentrantReadWriteLock();
    private final Random rand = new Random();

    // 1. Método para la HEBRA LECTORA: Lee AMBOS valores en orden aleatorio.
    public void leerValores(String n) throws InterruptedException {
        boolean leerPrimeroValor1 = rand.nextBoolean();
//de manera aleatoria leera primero el 1 y  luego el 2 y sino al revés
        try {
            if (leerPrimeroValor1) {
                leerValorProtegido(n, 1); // Lee valor 1
                leerValorProtegido(n, 2); // Lee valor 2
            } else {
                leerValorProtegido(n, 2); // Lee valor 2
                leerValorProtegido(n, 1); // Lee valor 1
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    // hago los locks aparte para que no sea tanto lio
    private void leerValorProtegido(String n, int numRecurso) throws InterruptedException {
        ReentrantReadWriteLock.ReadLock lock;
        int valorLeido;
        String nombreValor;

        // Seleccionar el lock y la variable
        if (numRecurso == 1) {
            lock = rwLock1.readLock();
            nombreValor = "valor 1";
        } else { // numRecurso == 2
            lock = rwLock2.readLock();
            nombreValor = "valor 2";
        }

        lock.lock(); // Adquirir el lock de lectura
        try {
            // Leer la variable de instancia dentro del bloque protegido
        	if (numRecurso == 1) {
        	    valorLeido = valor1;
        	} else {
        	    valorLeido = valor2;
        	}            System.out.println(n + " está leyendo el " + nombreValor + " y es " + valorLeido);
        } catch (InterruptedException e) {
             Thread.currentThread().interrupt();
        } finally {
            lock.unlock(); // Asegurar el desbloqueo
        }
    }

    // 3. Método para la HEBRA ESCRITORA: Cambia UNO de los dos valores al azar.
    public void cambiarValor(String n) {
        int valorACambiar = rand.nextInt(2) + 1; // 1 o 2

        if (valorACambiar == 1) {
            cambiarValorProtegido(n, 1);
        } else {
            cambiarValorProtegido(n, 2);
        }
    }

//cambiador de números
    private void cambiarValorProtegido(String n, int numRecurso) {
        ReentrantReadWriteLock.WriteLock lock;
        String nombreValor;
        
        // Seleccionar el lock
        if (numRecurso == 1) {
            lock = rwLock1.writeLock();
            nombreValor = "valor 1";
        } else { // numRecurso == 2
            lock = rwLock2.writeLock();
            nombreValor = "valor 2";
        }
        
        lock.lock(); // Adquirir el lock de escritura
        try {
            int nuevoValor = rand.nextInt(10001); // 0 a 10.000
            
            // Modificar la variable de instancia correcta
            if (numRecurso == 1) {
                valor1 = nuevoValor;
            } else {
                valor2 = nuevoValor;
            }
            
            System.out.println(n + " ha cambiado el " + nombreValor + " a " + nuevoValor);
            // Simular trabajo
            Thread.sleep(50); 
        } catch (InterruptedException e) {
             Thread.currentThread().interrupt();
        } finally {
            lock.unlock();
        }
    }
    
    // Método para leer el valor final (para el Main Thread)
    public String leerValoresFinales() {
        return "Valor 1: " + valor1 + " | Valor 2: " + valor2;
    }
}