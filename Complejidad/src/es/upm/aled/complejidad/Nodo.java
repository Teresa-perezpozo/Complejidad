package es.upm.aled.complejidad;

public class Nodo {
	protected int clave;
    protected int valor;
    protected Nodo iz;
    protected Nodo der;
    
    //constructor
    public Nodo(int clave, int valor) {
        this.clave = clave;
        this.valor = valor;
        this.iz = null;
        this.der = null;
    }

    
    
	public static void main(String[] args) {

	}

}
