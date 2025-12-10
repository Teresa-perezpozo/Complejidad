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
	salida = new FileOutputStream("C:\\Users\\Teresa\\Desktop\\pagina_descargada.html");
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
	public  void cambiarTitulo(String s) throws InterruptedException{
		URL pagina = new URL(s);
		fichBytes = pagina.openStream();
		InputStramReader r1 = new InputStramReader(fichBytes);
		BufferedReader fichTxt = new BufferedReader(r1);
		String textoOriginal = "",linea;
		while((linea=fich.txt.readLine())!=null) {
			textoOriginal+=linea;S
		}
	}
	public static void main(String[] args) {
	   
	    descargaPrueba dp = new descargaPrueba();
	    try {
			dp.descargar("https://concepto.de/montana/");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}

}