package es.upm.aled.complejidad;
//2.5 repetición
public class filosofo implements Runnable{
	//finalmente haré la clase filósofo donde haré hebras por filósofos en vez de en grupos
	//es decir, la clase runnable
	
	private final mesa2_5 mesa;
    private final int numF; 
    private final int tenedorIzquierda;
    private final int tenedorDerecha;

	 public filosofo (tenedro2_5 monitor, int numF) {
		 this.mesa = mesa;
	        this.numF = numF;
	        
	        this.tenedorIzquierda = numF;
	        this.tenedorDerecha = (numF + 1) % 5;
	        //para que el filósofo 5 coja el tenedor 5 y el 1 y no el 5 y 6 , pq no existe
	 }
	@Override
	public void run() {
		try {
			while(true) {
				monitor.getTenedor();
			}
		}
	}
}
