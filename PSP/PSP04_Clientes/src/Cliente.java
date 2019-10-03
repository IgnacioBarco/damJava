
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Nacho
 */
public class Cliente {

    Socket cliente;
    int puerto = 6060;
    String HOST = "localhost";
    OutputStream auxOut;
    DataOutputStream flujoSalida;
    InputStream auxIn;
    DataInputStream flujoEntrada;

    String res = "";
    Scanner dato;
    boolean ver = true;
    String mensaje = "";
    int estado;

    public Cliente() throws IOException {

        //creamos el cliente
        try {
            cliente = new Socket(HOST, puerto);
        } catch (IOException ex) {
            System.out.println("Fallo al crear el cliente: " + ex);
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

        ////////////////////////////////////////////////////////////////////////
        // logica del cliente //////////////////////////////////////////////////
        ////////////////////////////////////////////////////////////////////////
        
        //definimos un scanner para la entrada de datos
        dato = new Scanner(System.in);
        //ponemos el estado
        int estado = 1;

        do {
            switch (estado) {

                //damos el nombre y recibimos el saludo del servidor
                case 1:
                    System.out.print(flujoEntrada.readUTF());
                    flujoSalida.writeUTF(dato.nextLine());
                    System.out.println(flujoEntrada.readUTF());
                    estado = flujoEntrada.read();
                    break;

                //mandamos la cantidad a apostar    
                case 2:
                    System.out.print(flujoEntrada.readUTF());
                    flujoSalida.writeInt(dato.nextInt());

                    System.out.println(flujoEntrada.readUTF());
                    estado = flujoEntrada.read();
                    break;

                //recibimos el resultado del juego    
                case 3:
                    System.out.println(flujoEntrada.readUTF());

                    estado = flujoEntrada.read();
                    break;

                //enviamos si quieere otra partida o salir    
                case 4:
                    System.out.print(flujoEntrada.readUTF());
                    flujoSalida.writeUTF(dato.next());

                    System.out.println(flujoEntrada.readUTF());
                    estado = flujoEntrada.read();
                    break;
            }

        } while (estado != 5);

        //cerramos el cliente
        try {
            cliente.close();
        } catch (IOException ex) {
            //System.out.println("Fallo al cerrar el cliente: " + ex);
        }

    }

}
