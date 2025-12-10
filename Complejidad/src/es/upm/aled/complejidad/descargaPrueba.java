package es.upm.aled.complejidad;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

public class descargaPrueba {
	public  void descargar(String s) throws InterruptedException{
InputStream entrada = null;
OutputStream salida = null;
try {
	URL unaPagina = new URL (s);
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
				e.printStackTrace();
			}
		if(salida!=null)
			try {
				salida.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
	}
}
	public static void main(String[] args) {
	   
	    descargaPrueba dp = new descargaPrueba();
	    try {
			dp.descargar("https://www.istockphoto.com/es/foto/hombre-en-piedra-en-la-colina-y-hermosas-monta%C3%B1as-en-bruma-en-la-colorida-puesta-de-gm1443409611-482395177");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}

}