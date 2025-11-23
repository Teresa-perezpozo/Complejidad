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






}
