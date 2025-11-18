package es.upm.aled.complejidad;
 //antes lo he hecho mal, lo q haré ahora será una clase tenedor donde implementaré  un lock 
// para uqe cuando se coja el tenedor, este se bloque
//luego tendré que hacer un monitor que en este caso será mesa, y contorlña el comportamiento
//los tenedores , los creo y le saco get
//finalmente haré la clase filósofo donde haré hebras por filósofos en vez de en grupos
// por útltmio un lanzador dodne cree las 5 hebras
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class tenedro2_5 {
	public final ReentrantLock lock = new ReentrantLock();
}
