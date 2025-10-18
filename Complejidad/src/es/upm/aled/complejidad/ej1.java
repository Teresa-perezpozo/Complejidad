package es.upm.aled.complejidad;

public class ej1 {
	public static long calcularFactorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("El número debe ser no negativo.");
        }

        
        if (n == 0 || n == 1) {
            return 1;
        } 
        
        else {
            return n * calcularFactorial(n - 1);
        }
    }

    public static void main(String[] args) {
        int numero = 5;
        long resultado = calcularFactorial(numero);

        System.out.println("El factorial de " + numero + " es: " + resultado);

        System.out.println("El factorial de 0 es: " + calcularFactorial(0));
    }

}
