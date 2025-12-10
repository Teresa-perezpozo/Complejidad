package es.upm.aled.complejidad;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

public class descargaPrueba {
	public  void descargar() throws InterruptedException{
InputStream entrada = null;
OutputStream salida = null;
try {
	URL unaPagina = new URL ("https://concepto.de/montana/");
	entrada = unaPagina.openStream();
	salida = new FileOutputStream("montaña.png");
	byte buffer[]= new byte[4096];
	while(entrada.read(buffer)!=-1) {
		salida.write(buffer);
		salida.flush();
		
	}
}catch(Exception e) {
		
	}finally {
		if(entrada!=null)
			try {
				entrada.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		if(salida!=null)
			try {
				salida.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
}

}