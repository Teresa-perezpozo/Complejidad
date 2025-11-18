package es.upm.aled.complejidad;

public class mesa2_5 {
	//luego tendré que hacer un monitor que en este caso será mesa, y contorlña el comportamiento
	//los tenedores , los creo y le saco get
	private final tenedro2_5[] tenedores = new tenedro2_5[5];
	
	public mesa2_5 () {
	for(int i =0;i<5;i++) {
		tenedores[i] = new tenedro2_5();
	}
	}
	public tenedro2_5 getTenedor(int indice) {
        return tenedores[indice];
    }
}
