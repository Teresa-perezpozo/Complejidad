package es.upm.aled.complejidad;

import java.util.concurrent.ThreadLocalRandom;

public class Piti {
	private boolean papela;
	private boolean tabaco;
	
	
		public Piti() {
		    // La marmita empieza llena.
		    this.papela = papela;
		    this.tabaco = tabaco;
		}





		public synchronized void fumar(String n )throws InterruptedException {
				
			//si tengo las dos cosas, fumo
			while(papela ==true&&tabaco ==true) {
					System.out.println("El fumador se fuma un piti");
					
			}
					int eleccion = ThreadLocalRandom.current().nextInt(2);
					
		            // 
		            if (papela==true&&eleccion==0) {
		                fumador.pedir(tabaco);
		                
		            }if(papela==true&&eleccion==1) {
		            	fumador.prestar(papela);
		            	
		            }if (tabaco==true&&eleccion==0) {
		                fumador.pedir(papela);
		                
		            }if(tabaco==true&&eleccion==1) {
		            	fumador.prestar(tabaco);
		            }
		            
					
				}
				
			
		}

				
			
		

