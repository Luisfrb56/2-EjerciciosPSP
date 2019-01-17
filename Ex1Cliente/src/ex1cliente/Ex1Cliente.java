package ex1cliente;


import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

public class Ex1Cliente {

    public static void main(String[] args) {
 try{
            System.out.println("Creando socket cliente");
            Socket clienteSocket=new Socket();
            System.out.println("Estableciendo la conexion");

            InetSocketAddress addr=new InetSocketAddress("localhost",6666);
            clienteSocket.connect(addr);

            InputStream is = clienteSocket.getInputStream();
            OutputStream os= clienteSocket.getOutputStream();

            System.out.println("Enviando mensaje");

            String mensaje="mensaje desde el cliente";
            os.write(mensaje.getBytes());

            System.out.println("1º Mensaje enviado de cliente");
            
            byte[] message=new byte[25];
            is.read(message);
            
            System.out.println("Mensaje recibido del servidor 1: "+ new String(message));
           
            mensaje="2º mensaje cliente";
            os.write(mensaje.getBytes());
            
            System.out.println("2º Mensaje enviado de cliente");
            
            is.read(message);
            
            System.out.println("Mensaje recibido del servidor 2: "+ new String(message));
           
            mensaje="3º mensaje cliente";
            os.write(mensaje.getBytes());
            
            System.out.println("3º Mensaje enviado de cliente");
            
            is.read(message);
            
            System.out.println("Mensaje recibido del servidor 3: "+ new String(message));
            
             System.out.println("Cerrando el socket cliente");
            clienteSocket.close();

            System.out.println("Terminado");

        }catch (IOException e) {
                e.printStackTrace();
        }
    }
    
}
