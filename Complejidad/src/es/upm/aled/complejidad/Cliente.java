package es.upm.aled.complejidad;

public class Cliente implements Runnable {
public String nombre;
private monitorPelu monitor;


public Cliente(monitorPelu monitor, String nombre) {
	this.nombre = nombre;
	this.monitor=monitor;
}


@Override
public void run() {
    // El cliente intenta entrar
    boolean esAtendido = monitor.cortarPelo(nombre);
    
    // Si ha conseguido sitio
    if (esAtendido) {
        // Simula el corte de pelo (mientras ocupa la silla)
        monitor.simularCortePelo();
        
        // Libera la silla y se va
        monitor.salirPeluqueria();
    }
}
}