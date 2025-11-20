package es.upm.aled.complejidad;

public class monitorPelu {

	//en esta primera versión del problema hare un monitor, que tendra toods lo recursos compartidos
//	como van a ser los sillones y la silla, el numero de gente total en la pelu... aquí minimo necesitamos
//	el metodo sentarse en silla y cortarse el pelo, sentase en sofá a esperar, 
//	luego tenemos que hacer una clase que sea peluquero
	
	private int sofas = 5;
	private int sillaPeluqueria=1;
	private int sofasOcupados;
	private boolean sillaPeluqueriaOcupada=false;
	
	public monitorPelu () {
		this.sofas = sofas;
		this.sillaPeluqueria=sillaPeluqueria;
		
	}
	
	
	public synchronized void cortarPelo(String persona) throws InterruptedException {
		
		while(sillaPeluqueriaOcupada) {
			if(sofasOcupados<=5) {
				sofasOcupados++;
				wait();
			}else {
				System.out.println(persona  +" no se va a cortar el pelo pq hay cola");
				break;//nos vamos de la peluquería
			}
			
		}
		sillaPeluqueriaOcupada = true;
		System.out.print(persona + " va a cortarse el pelo");

		Thread.sleep(400);//cortanto el pelo
		System.out.print(persona + " ya se ha cortado el pelo");
	}
	
	
	
	
	
}
