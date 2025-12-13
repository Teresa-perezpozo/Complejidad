package es.upm.aled.complejidad;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.Buffer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class DescargarImagen  {

	public static void main(String[] args) {
	        try {
	            // URL del recurso
	        	URL unaPagina= new URL("http://web.dit.upm.es/index.html");
	        	InputStream fichBytes = unaPagina.openStream();
	        	InputStreamReader reader1 = new InputStreamReader(fichBytes);
	        	BufferedReader fichTxt = new BufferedReader(reader1);

	            // Leer la respuesta
	        	String textoOriginal = "", linea;
	        	while ((linea = fichTxt.readLine()) != null)
	        	textoOriginal += linea;
	        	String textoModif = textoOriginal.replace("<h2></h2>", "<h2>Hola</h2>");
	        	FileOutputStream salidaBytes = new FileOutputStream("aaoc1.html");
	        	PrintWriter salidaTxt = new PrintWriter(salidaBytes);
	        	salidaTxt.print(textoModif);
	        	
	        	System.out.println("he llegado al final pero no me descargo ");
	        	salidaTxt.close();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	}
