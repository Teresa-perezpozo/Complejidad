package es.upm.aled.complejidad;

public class GestorPedidos implements Runnable{
 //CestaPiezas cestaRoja, CestaPiezas cestaAzul. final int REQ_ROJAS, final int REQ_AZULES
	CestaPiezas cestaRoja;
	CestaPiezas cestaAzul;
	final int REQ_rojas=3;
	final int REQ_azules=2;
	final String nombreGestor;
	
	public GestorPedidos(CestaPiezas cestaRoja, CestaPiezas cestaAzul, String nombreGestor) {
        this.cestaRoja = cestaRoja;
        this.cestaAzul = cestaAzul;
        this.nombreGestor = nombreGestor;
    }	
	
	
	public void run () {
		while(true) {
			try {
				System.out.println("el gestor mira el pedido ");
				
				for (int i = 0; i < REQ_rojas; i++) {
                    cestaRoja.retirar();
                    System.out.println(" el gestor "+ nombreGestor + " consumió una roja");
                    // Pausa mínima para simular procesamiento
                    Thread.sleep(10); 
                }
				for (int i = 0; i < REQ_azules; i++) {
                    cestaAzul.retirar();
                    System.out.println(" [GESTOR " + nombreGestor + "] Consumió 1 Azul.");
                    Thread.sleep(10);
                }System.out.println("pedido completado");
			} catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
		}
	}
	
	
}
