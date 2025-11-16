package es.upm.aled.complejidad;

public class ThreadManager {
	public static void main(String[] args) throws InterruptedException {
		int cores = Runtime.getRuntime().avaibleProcessors();
		Exececutor service ex = Executor.newFixedThreadPool(cores);
		LectoresEscritores compartido = new LecoresEscritores();
		int numEscritores = cores%2;
		int numLectores = cores-numEscritores;
		
		System.out.println(" este ordenador tiene "+ cores + " cores.");
			
		//ahora voy a asignaro todos los threads a sus labores
		for (int i =0;i<numEscritores;i++) {
			
		}
	}
}
