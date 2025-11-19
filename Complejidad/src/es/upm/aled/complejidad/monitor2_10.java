package es.upm.aled.complejidad;

public class monitor2_10 {
	
	int pesoTotalPuente =0;
	int numVehiculos =0;
	int ambulanciasEsperando =0;
	public synchronized void entrarPuente (int peso, boolean ambulancia) throws InterruptedException{
		 if (ambulancia) {
	            ambulanciasEsperando++; // Si soy ambulancia, me cuento en la cola de prioridad
	            System.out.println("hay "+ ambulanciasEsperando + " ambulancias esperando");
	        }
		 while(true) {
			 if(pesoTotalPuente+peso>15000 || numVehiculos+1>10) {
				 System.out.println("el peso total se supera o ya son mas de 10 vehículos en el puente, me qeudo esperando");
			wait();
			 }
		pesoTotalPuente = pesoTotalPuente+peso;
		numVehiculos ++;
		break;
		 }
		 if (ambulancia) {
	            ambulanciasEsperando--; // La ambulancia deja de esperar
	        }
	        System.out.println(">>> VEHÍCULO ambulancia de (" + peso + "kg) ENTRA. Total: " + numVehiculos + ", Peso: " + pesoTotalPuente);

		}
	
	
	
	public synchronized void salirPuente (int peso, String nombre) {
		pesoTotalPuente -=peso;
		numVehiculos--;
		notifyAll();
		
		

	}


}
