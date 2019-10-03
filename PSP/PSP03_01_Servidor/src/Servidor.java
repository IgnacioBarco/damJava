
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Nacho
 */
public class Servidor {

    int puerto = 2500;
    ServerSocket server;
    Socket cliente;
    OutputStream auxOut;
    DataOutputStream flujoSalida;
    InputStream auxIn;
    DataInputStream flujoEntrada;

    int numero, numeroDado;
    int jugada = 1;
    boolean ver=true;

    public Servidor() throws IOException {

        //creamos el servidor
        try {
            server = new ServerSocket(puerto);
            System.out.println("Servidor activo, escuchando en el puerto: " + puerto);
        } catch (IOException ex) {
            System.out.println("Fallo al crear el server: " + ex);
        }

        //esperamos la conexion
        try {
            cliente = server.accept();
        } catch (IOException ex) {
            System.out.println("Fallo al recibir la conexion: " + ex);
        }

        //definimos los flujos de entrada y salida
        try {
            auxOut = cliente.getOutputStream();
            flujoSalida = new DataOutputStream(auxOut);
        } catch (IOException ex) {
            System.out.println("Fallo al crear el flujo de salida: " + ex);
        }
        try {
            auxIn = cliente.getInputStream();
            flujoEntrada = new DataInputStream(auxIn);
        } catch (IOException ex) {
            System.out.println("Fallo al crear el flujo de entrada: " + ex);

        }

        //creamos el numero aleatorio del 1 al 10        
        numero = (int) (Math.random() * 10) + 1;
        
        ////////////////////////////////////////////////////////////////////////
        // logica de servidor //////////////////////////////////////////////////
        ////////////////////////////////////////////////////////////////////////

        do {
            /*si ya hemos agotado los 10 intentos, mandamos un mensaje y 
            nos salimos del bucle do-while */
            if (jugada == 11 ) {
                flujoSalida.writeUTF("No has acertado!!!");
                ver = false;
            
                //si aun no llevamos 10 intentos
            } else {

                //pasamos al cliente el siguiente string
                flujoSalida.writeUTF("Te quedan " + (11-jugada) + " intentos."
                        + "Dime un numero: ");

                //capturamos el numero que nos pasa el cliente
                numeroDado = flujoEntrada.read();
                
                /*comprobamos el numero dado con el que hay que acertar, y 
                dependiendo como le pasamos un mensaje al cliente.
                si es igual, también nos salimos del bucle */
                if (numeroDado>numero){
                    flujoSalida.writeUTF("El numero es menor");
                } else if (numeroDado<numero){
                    flujoSalida.writeUTF("El numero es mayor");    
                }  else if (numeroDado==numero){
                    flujoSalida.writeUTF("Has acertado!!!");
                    ver=false;
                }

                //contador para llevar el numero de jugadas
                jugada++;
            }

        } while (ver);

        
        //cerramos el servidor
        try {
            server.close();
            System.out.println("Servidor cerrado.");
        } catch (IOException ex) {
            System.out.println("Fallo al cerrar el servidor: " + ex);
        }

    }

}
