package es.upm.aled.complejidad;

public class Estanquero implements Runnable{
	private boolean  papela;
	private boolean tabaco;
	public Estanquero(boolean papela, boolean tabaco) {
		this.papela= papela;
		this.tabaco = tabaco;
	}

	@Override
	public void run() {
			try {
			    while (true) {
				System.out.println("el estanquero ofrece una papela ");
				piti.fuamar(papela);				
				Thread.sleep(800); 
				System.out.println("el estanquero ofrece tabaco ");
				piti.fumar(tabaco);
			    }
			}catch(InterruptedException e ) {
				Thread.currentThread().interrupt();
			}
			}	
}
