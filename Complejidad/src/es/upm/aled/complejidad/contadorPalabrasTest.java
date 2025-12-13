package es.upm.aled.complejidad;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class contadorPalabrasTest {
    public static void main(String[] args) {
        try {
            // URL del recurso
            URL url = new URL("https://testsockets.appspot.com/test?palabras=226");
            HttpURLConnection conexion = (HttpURLConnection) url.openConnection();
            conexion.setRequestMethod("GET");

            // Leer la respuesta
            BufferedReader in = new BufferedReader(new InputStreamReader(conexion.getInputStream()));
            String linea;
            String contenido ="";
            while ((linea = in.readLine()) != null) {
                contenido +=linea+"";
            }
            in.close();

            // Contar palabras
            String texto = contenido.trim();
            if (texto.isEmpty()) {
                System.out.println("Número de palabras: 0");
            } else {
                String[] palabras = texto.split("\\s+"); // separar por espacios
                System.out.println("Número de palabras: " + palabras.length);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
