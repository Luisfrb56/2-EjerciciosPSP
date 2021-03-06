package procesoemisordg;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;

public class ProcesoEmisorDG {

    public static void main(String[] args) {
        try{
            System.out.println("Creando socket datagram");

            
            DatagramSocket datagramSocket=new DatagramSocket();


            System.out.println("enviando mensaje");

            String mensaje="mensaje desde el emisor";

            InetAddress addr=InetAddress.getByName("localhost");
            DatagramPacket datagrama=new DatagramPacket (mensaje.getBytes(),mensaje.getBytes().length,addr,5555);
            datagramSocket.send(datagrama);

            System.out.println("Mensaje enviado");

            System.out.println("Recibiendo mensaje");
            
            InetSocketAddress addr2=new InetSocketAddress("localhost",5556);
            datagramSocket=new DatagramSocket(addr2);
            byte[] mensaje2=new byte[25];
            DatagramPacket datagrama1=new DatagramPacket(mensaje2,25);
            datagramSocket.receive(datagrama1);
            System.out.println("Mensaje recibido: "+new String(mensaje2));
            
            System.out.println("Cerrando el socket datagrama");

            datagramSocket.close();

            System.out.println("Terminado");
            }catch(IOException e){
                
                e.printStackTrace();
                
            }
    }
}
