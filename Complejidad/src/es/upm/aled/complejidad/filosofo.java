	package es.upm.aled.complejidad;
	
	import java.util.concurrent.ThreadLocalRandom;
	
	//2.5 repetición
	public class filosofo implements Runnable{
		//finalmente haré la clase filósofo donde haré hebras por filósofos en vez de en grupos
		//es decir, la clase runnable
		
		private final mesa2_5 mesa;
		private final int numF; 
	    private final int tenedorIzquierda;
	    private final int tenedorDerecha;
	
		 public filosofo (mesa2_5 mesa, int numF) {
			 	this.mesa = mesa;
		        this.numF = numF;
		        
		        this.tenedorIzquierda = numF;
		        this.tenedorDerecha = (numF + 1) % 5;
		        //para que el filósofo 5 coja el tenedor 5 y el 1 y no el 5 y 6 , pq no existe
		 }
		@Override
		public void run() {
			
			while (true) {
	            tenedro2_5 t1 = null; //los inicializo nulos
	            tenedro2_5 t2 = null; 
	            try {
	                // 1. Pensar
	                System.out.println("Filósofo " + numF + " está pensando.");
	                Thread.sleep(ThreadLocalRandom.current().nextInt(500, 1000));
	                
	                // 2. coger tenedor de mínimo, pq si le digo primero derecha y luego izquierda
	                //se interbloquea
	                int primero = Math.min(tenedorIzquierda, tenedorDerecha);
	                int segundo = Math.max(tenedorIzquierda, tenedorDerecha);
	                
	                t1 = mesa.getTenedor(primero); // Tenedor de menor índice
	                t2 = mesa.getTenedor(segundo); // Tenedor de mayor índice

	                // 3. Agarrar Tenedores en orden
	                t1.lock.lock(); 
	                System.out.println("Filósofo " + numF + " agarró tenedor " + primero);

	                t2.lock.lock(); 
	                System.out.println("Filósofo " + numF + " agarró tenedor " + segundo + " y EMPEZÓ A COMER");

	                // 4. comiendo espaguetis
	                Thread.sleep(ThreadLocalRandom.current().nextInt(100, 500)); 
	                
	            } catch (InterruptedException e) {
	                Thread.currentThread().interrupt();
	                return;
	            } finally {
	                // 5. Liberar los tenedores (USANDO las variables locales t1 y t2)
	                
	                // Asegurarse de que t2 no sea null y esté en manos del hilo actual antes de liberar
	                if (t2 != null && t2.lock.isHeldByCurrentThread()) {
	                    t2.lock.unlock();
	                }
	                // Asegurarse de que t1 no sea null y esté en manos del hilo actual antes de liberar
	                if (t1 != null && t1.lock.isHeldByCurrentThread()) {
	                    t1.lock.unlock();
	                }
	                
	                System.out.println("Filósofo " + numF + " TERMINÓ DE COMER y soltó ambos tenedores.");
	            }
		}
	}
	}
