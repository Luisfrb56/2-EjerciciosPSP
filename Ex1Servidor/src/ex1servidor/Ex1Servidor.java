
package ex1servidor;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.ServerSocket;

public class Ex1Servidor {

    public static void main(String[] args) {
        try{
            System.out.println("Creando socket servidor");
	
            ServerSocket serverSocket=new ServerSocket();

            System.out.println("Realizando el bind");

            InetSocketAddress addr=new InetSocketAddress("localhost",6666);
            serverSocket.bind(addr);

            System.out.println("Aceptando conexiones");

            Socket newSocket= serverSocket.accept();

            System.out.println("Conexion recibida");

            InputStream is=newSocket.getInputStream();
            OutputStream os=newSocket.getOutputStream();

            byte[] mensaje=new byte[25];
            is.read(mensaje);

            System.out.println("Mensaje recibido: "+new String(mensaje));

            String message="te devuelvo el mensaje";
            os.write(message.getBytes());
            
            System.out.println("1º Mensaje enviado de Servidor");
            
            is.read(mensaje);

            System.out.println("2º Mensaje recibido: "+new String(mensaje));
            
            message="te devuelvo el mensaje 2";
            os.write(message.getBytes());
            
            System.out.println("2º Mensaje enviado de Servidor");
            is.read(mensaje);

            System.out.println("3º Mensaje recibido: "+new String(mensaje));
            
            message="te devuelvo el mensaje 3";
            os.write(message.getBytes());
            
            System.out.println("3º Mensaje enviado de Servidor");
            
            
            System.out.println("Cerrando el nuevo socket");

            newSocket.close();

            System.out.println("Cerrando el socket servidor");

            serverSocket.close();

            System.out.println("Terminado");

	
        }catch (IOException e) {
			
                        }
    }
    
}
