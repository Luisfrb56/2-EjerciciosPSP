package ex2cliente;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

public class Ex2Cliente {

    public static void main(String[] args) {
                try{
            System.out.println("Creando socket cliente");
            Socket clienteSocket=new Socket();
            System.out.println("Estableciendo la conexion");

            InetSocketAddress addr=new InetSocketAddress("localhost",5555);
            clienteSocket.connect(addr);

            InputStream is = clienteSocket.getInputStream();
            OutputStream os= clienteSocket.getOutputStream();

            System.out.println("Enviando mensaje");
            
            int[] numeros={1,2,3,4,5};
            for(int i=0;i<=4;i++){
                
            os.write(numeros[i]);
            
            }
            os.write(0);
            System.out.println("Mensaje enviado");
            
            byte[] suma=new byte[25];
            is.read(suma);
            System.out.println("Mensaje recibido: "+ new String(suma));
            System.out.println("Cerrando el socket cliente");

            clienteSocket.close();

            System.out.println("Terminado");

        }catch (IOException e) {
                e.printStackTrace();
        }
    }
    
}
