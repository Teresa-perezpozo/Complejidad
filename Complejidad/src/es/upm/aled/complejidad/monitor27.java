package es.upm.aled.complejidad;

public class monitor27 {
	private boolean haypapel;
	private boolean haytabaco;
	private boolean haycerilla;
	
	
	public synchronized void fumar() {
		while(haypapel&&haytabaco&&haycerilla) {
			haypapel=false;
			haytabaco=false;
			haycerilla=false;
			
		}
	}
		while(!(haypapel&&haytabaco&&haycerilla)) {
			wait();
		}
	
	//aqui decimos q 0 es tabaco, papel es 1 y cerilla es 2
	public synchronized void colocarIngredientes(int cosa1, int cosa2)throws InterruptedException {
		if(cosa1 ==0||cosa2==0) haytabaco =true;//si alguna de las dos cosas son tabaco, hay tabaco
		if(cosa1==1||cosa2==1)haypapel = true;// si alguna de las dos cosas son papel , hay papel
		if(cosa1==2||cosa2==2)haycerilla = true;//si alguna de las dos cosas son cerilllas hay cerillas
	
	notifyAll();
	}
	
	public synchronized void cogerIngredientes(int ingredientetengo)throws InterruptedException{
		while(!puedoFumar(ingredientetengo)) {
			wait();//si no puedo fumar me espero
		}
		haytabaco = false;
		haypapel= false;
		haycerilla = false;
		
		
	}
		 private boolean puedoFumar(int tengo) {
		        if (tengo == 0) return haypapel && haycerilla;   // Tengo Tabaco -> Quiero P+C
		        if (tengo == 1) return haytabaco && haycerilla;  // Tengo Papel -> Quiero T+C
		        if (tengo == 2) return haytabaco && haypapel;    // Tengo Cerilla -> Quiero T+P
		        return false;
		    }
}
//	main string args
//	
//	monitor 27 = new monitor();
//	new Thread (()->{
//		try {
//			while(true) {
//elegir aleatoriamente que NO poner
//				int falta (int)(Math.random()*3;
//				int pone1=(falta+1)%3
//				monitor.recogerIngredientes();
//				monitor.puedoFumar();
//				
//			}
//		}
//			
//			
//			,"fumador").start();}
//
//
//}
