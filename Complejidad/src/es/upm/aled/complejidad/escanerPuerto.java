package es.upm.aled.complejidad;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class escanerPuerto {

	public static void main(String[] args) {
		ServerSocket s;
		try {
			s = new ServerSocket(1234);
			System.out.println("conenctado al puerto");
			Socket remote = s.accept();
			InputStream in = remote.getInputStream();
			OutputStream out = remote.getOutputStream();
		} catch (Exception e) {
			System.out.println("el puerto está ocupado o no se puede conectar");
		}
		
	}
}
