package es.upm.aled.complejidad;

public class Funcionario implements Runnable {
	private final monitor monitor;

    public Funcionario(monitor monitor) {
        this.monitor = monitor;
    }

    @Override
    public void run() {
        while (true) { // Debe estar continuamente atento
            try {
                monitor.atenderCiudadano();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
        }
    }
}