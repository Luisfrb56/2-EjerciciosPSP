package ex2servidor;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.ServerSocket;

public class Ex2Servidor {

    public static void main(String[] args) {
        try {
            System.out.println("Creando socket servidor");

            ServerSocket serverSocket = new ServerSocket();

            System.out.println("Realizando el bind");

            InetSocketAddress addr = new InetSocketAddress("localhost", 5555);
            serverSocket.bind(addr);

            System.out.println("Aceptando conexiones");

            Socket newSocket = serverSocket.accept();

            System.out.println("Conexion recibida");

            InputStream is = newSocket.getInputStream();
            OutputStream os = newSocket.getOutputStream();
            byte[] mensaje=new byte[1];
            byte[] mensaje2 = new byte[1];
            byte[] mensaje3=new byte[1];
            byte[] mensaje4 = new byte[1];
            byte[] mensaje5=new byte[1];
            is.read(mensaje);
            int a=Integer.valueOf(mensaje[0]);
            is.read(mensaje2);
            int b=Integer.valueOf(mensaje2[0]);
            is.read(mensaje3);
            int c=Integer.valueOf(mensaje3[0]);
            is.read(mensaje4);
            int d=Integer.valueOf(mensaje4[0]);
            is.read(mensaje5);
            int f=Integer.valueOf(mensaje5[0]);

            int suma=a+b+c+d+f;
            String sumat= "Resultado= " + suma;
            os.write(sumat.getBytes());
            

            

               
            

            System.out.println("Cerrando el nuevo socket");

            newSocket.close();

            System.out.println("Cerrando el socket servidor");

            serverSocket.close();

            System.out.println("Terminado");

        } catch (IOException e) {

        }
    }

}
