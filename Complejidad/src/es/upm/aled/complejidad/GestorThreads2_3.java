package es.upm.aled.complejidad;
import java.util.concurrent.ThreadLocalRandom;

public class GestorThreads2_3 {
    private int dato = 0;
    private int numLectoresActivos = 0;
    private boolean escritorActivo = false;
    
    // Contadores para las hebras esperando (Clave para la lógica de prioridad)
    private int esperandoLectorAlta = 0;
    private int esperandoEscritorAlta = 0;
    private int esperandoLectorMedia = 0;
    private int esperandoEscritorMedia = 0;
    private int esperandoLectorBaja = 0;
    private int esperandoEscritorBaja = 0;

    // --- Lógica de Ayuda ---

    /** Obtiene el contador de espera para un tipo/prioridad dados. */
    /**
     * Obtiene el contador de hebras esperando para una prioridad y tipo dados.
     */
    private int getEsperando(Prioridad p, boolean esLector) {
        if (p == Prioridad.ALTA) {
            if (esLector) {
                return esperandoLectorAlta;
            } else {
                return esperandoEscritorAlta;
            }
        } else if (p == Prioridad.MEDIA) {
            if (esLector) {
                return esperandoLectorMedia;
            } else {
                return esperandoEscritorMedia;
            }
        } else { // Asumimos que la prioridad es Prioridad.BAJA
            if (esLector) {
                return esperandoLectorBaja;
            } else {
                return esperandoEscritorBaja;
            }
        }
    }
    // --- Lógica de Selección de Prioridad (Reglas 47, 51, 52) ---
    
    /**
     * Verifica si la hebra actual (dada su prioridad y tipo) tiene derecho a entrar 
     * según las hebras que esperan.
     */
    private boolean tienePrioridad(Prioridad p, boolean esLector) {
        // Regla 1: Se elige una de las hebras de mayor prioridad.
        if (esperandoLectorAlta > 0 || esperandoEscritorAlta > 0) {
            if (p != Prioridad.ALTA) return false;
        } else if (esperandoLectorMedia > 0 || esperandoEscritorMedia > 0) {
            if (p != Prioridad.MEDIA) return false;
        } 
        // Si no hay Alta o Media esperando, cualquier Baja puede pasar (si se cumplen las demás reglas)

        // Regla 2: Si hay varias hebras con la prioridad más alta, se elige una de lectura.
        // Solo aplica si hay hebras de ambos tipos esperando en la máxima prioridad.
        boolean hayLectoresMaxima = (p == Prioridad.ALTA && esperandoLectorAlta > 0) || 
                                    (p == Prioridad.MEDIA && esperandoLectorMedia > 0) || 
                                    (p == Prioridad.BAJA && esperandoLectorBaja > 0);
                                    
        boolean hayEscritoresMaxima = (p == Prioridad.ALTA && esperandoEscritorAlta > 0) || 
                                      (p == Prioridad.MEDIA && esperandoEscritorMedia > 0) || 
                                      (p == Prioridad.BAJA && esperandoEscritorBaja > 0);

        if (hayLectoresMaxima && hayEscritoresMaxima && !esLector) {
            // Si la máxima prioridad tiene lectores Y escritores esperando, 
            // y la hebra actual es una escritora, debe esperar.
            return false;
        }

        // Regla 3: Si hay varias hebras de lectura con la prioridad más alta, se elige una de ellas al azar.
        // Esta regla se implementa con una simplificación: si la hebra tiene el turno,
        // simplemente asume que fue "elegida al azar" para el propósito de este esquema.
        // En una implementación real más estricta, se usaría un semáforo de conteo o una cola.

        return true;
    }
    
    // --- MÉTODOS PÚBLICOS DE ACCESO ---

    public int empezarLeer(Prioridad p) throws InterruptedException {
        synchronized (this) {
            // Incrementar contador de espera ANTES de entrar al bucle wait
            if (p == Prioridad.ALTA) esperandoLectorAlta++;
            else if (p == Prioridad.MEDIA) esperandoLectorMedia++;
            else esperandoLectorBaja++;

            // Condición de espera: Escritor activo O No tengo la prioridad máxima
            while (escritorActivo || !tienePrioridad(p, true)) {
                wait();
            }

            // Decrementar contador de espera DESPUÉS de salir del bucle
            if (p == Prioridad.ALTA) esperandoLectorAlta--;
            else if (p == Prioridad.MEDIA) esperandoLectorMedia--;
            else esperandoLectorBaja--;
            
            numLectoresActivos++;
            return dato;
        }
    }

    public void terminarLeer() {
        synchronized (this) {
            numLectoresActivos--;
            if (numLectoresActivos == 0) {
                notifyAll(); // Despierta a todos para re-evaluar la prioridad
            }
        }
    }

    public void empezarEscribir(Prioridad p) throws InterruptedException {
        synchronized (this) {
            // Incrementar contador de espera
            if (p == Prioridad.ALTA) esperandoEscritorAlta++;
            else if (p == Prioridad.MEDIA) esperandoEscritorMedia++;
            else esperandoEscritorBaja++;

            // Condición de espera: Lector/Escritor activo O No tengo la prioridad máxima
            while (numLectoresActivos > 0 || escritorActivo || !tienePrioridad(p, false)) {
                wait();
            }

            // Decrementar contador de espera
            if (p == Prioridad.ALTA) esperandoEscritorAlta--;
            else if (p == Prioridad.MEDIA) esperandoEscritorMedia--;
            else esperandoEscritorBaja--;
            
            escritorActivo = true;
        }
    }

    public void terminarEscribir(int nuevoDato) {
        synchronized (this) {
            this.dato = nuevoDato;
            escritorActivo = false;
            notifyAll(); // Despierta a todos para re-evaluar la prioridad
        }
    }
}
