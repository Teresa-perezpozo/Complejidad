package es.upm.aled.complejidad;

public class LanzadordeLego {



	    public static void main(String[] args) {
	        
	    	CestaPiezas cestaRoja = new CestaPiezas("Roja");
			CestaPiezas cestaAzul = new CestaPiezas("Azul");
			
			int numGestores = 3;
			
			// 2. Lanzar Líneas de Producción (Productoras)
	        // CORREGIDO: Usando el nombre correcto de la clase: LineaProduccion
			Thread lineaRoja = new Thread(new LineProduccion("R", cestaRoja, "Roja-1"));
			Thread lineaAzul = new Thread(new LineProduccion("A", cestaAzul, "Azul-1"));

			lineaRoja.start();
			lineaAzul.start();
			
			// 3. Lanzar Gestores de Pedidos (Consumidores)
			for (int i = 0; i < numGestores; i++) {
	            // GestorPedidos ahora implementa Runnable
				Thread gestor = new Thread(new GestorPedidos(cestaRoja, cestaAzul, "G-" + (i + 1)));
				gestor.start();
			}
			
			System.out.println("\n*** Líneas y Gestores en funcionamiento. ***\n");
	    }
	}

