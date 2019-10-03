
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
public class Cliente02 {

    Socket cliente;
    int puerto = 1500;
    String HOST = "localhost";
    OutputStream auxOut;
    DataOutputStream flujoSalida;
    InputStream auxIn;
    DataInputStream flujoEntrada;

    String res = "";
    Scanner dato;
    boolean ver = true;

    public Cliente02() throws IOException {

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
        
        //para capturar del nombre de fichero
        dato = new Scanner(System.in);

        //el servidor nos envia el mensaje de que fichero queremos abrir
        System.out.print(flujoEntrada.readUTF());

        //le pasamos el nombre del fichero
        flujoSalida.writeUTF(dato.nextLine());

        /* Leemos el mensaje, si es que no existe, lo escribimos y salimos
        Si existe, escribimos el primer mensaje(Enviando fichero) y nos
        metemos en un bucle hasta que nos llegue el mensaje de fichero finalizado*/
        res = flujoEntrada.readUTF();
        if (res.equals("No existe el fichero.")) {
            System.out.println(res);
        
        //si esxistye    
        } else {
            System.out.println(res);

            do {
                ver = true;
                res = flujoEntrada.readUTF();
                //si nos llega el mensajecambiamos ver para que salga despues de escribir
                if (res.equals("Fichero finalizado")) {
                    System.out.println(res);
                    ver = false;
                //si no ha terminado escribe la linea
                } else {
                    System.out.println(res);
                }

            } while (ver);

        }

        //cerramos el cliente
        try {
            cliente.close();
        } catch (IOException ex) {
            System.out.println("Fallo al cerrar el cliente: " + ex);
        }

    }
}
