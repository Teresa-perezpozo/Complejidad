package es.upm.aled.complejidad;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class DescargarImagen  {

	public static void main(String[] args) {
		InputStream in = null;
		OutputStream out = null;
		try {
			URL url = new URL("https://www.google.com/images/branding/googlelogo/1x/googlelogo_color_272x92dp.png");
			in = url.openStream();
			out = new FileOutputStream("Desktop"); 
			int b = in.read();
			while(b!=-1) {
				out.write(b);
				b = in.read();
				out.flush();
			}
		} catch (Exception e) { // Maneja errores de red, URL, o disco
            System.err.println("Ocurrió un error de I/O: " + e.getMessage());
            e.printStackTrace();
            
        } finally { // Bloque finally para asegurar el cierre de recursos
            try {
                if (out != null) out.close(); // Se recomienda cerrar el out antes
                if (in != null) in.close();
            } catch (Exception e) {
                System.err.println("Error al cerrar los streams: " + e.getMessage());
            }
        }
	}
}