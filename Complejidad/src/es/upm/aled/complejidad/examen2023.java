package es.upm.aled.complejidad;

public class examen2023 {
//	 El método computeNearStops nos devuelve un array de paradas, ordenado por proximidad
//	 a la parada que se pasa como primer parámetro. Es el mismo orden que la lista que devuelve el método
//	 IStopServicesP3::getNearStops que supondremos implementada. Pero la implementación de computeNearStops debe
//	 utilizar una de las hebras del ThreadPool executor, para hacer los cálculos, y la hebra que ejecuta la llamada a
//	 computeNearStops tendrá la menor ejecución posible
public Stop[] computerNearStops(Stop primera) {
	 Future<Stop[]> oneFut=executor.submit(new Callable<Stop[]>() {
		 @Override
		Future <Stop[]> oneFut = executor.submit(new Callable<Stop[]>){
			@Override
			public Stop[] call() throws Exception{
				if(executor==null) 
			}
		}
}
	 public static Stop[] rebuildNearStops(Stop[] stops, double newDistance) {
		 // Utilizamos una busqueda binaria para encontar donde está la última parada
		 // con una distancia menor que newDistance
		 int iz=0; int der=stops.length;
		 int med=0;
		 while (iz <= der) {
		 med=(iz+der)/2;
		 if (newDi



}
