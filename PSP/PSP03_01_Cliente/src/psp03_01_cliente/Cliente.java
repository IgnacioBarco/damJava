/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package psp03_01_cliente;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author Nacho
 */
public class Cliente {

    Socket cliente;
    int puerto = 2500;
    String HOST = "localhost";
    OutputStream auxOut;
    DataOutputStream flujoSalida;
    InputStream auxIn;
    DataInputStream flujoEntrada;

    String res = "";
    Scanner dato;
    boolean ver=true;

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
        
        //para capturar los numeros
        dato = new Scanner(System.in);
        
        
        ////////////////////////////////////////////////////////////////////////
        // logica del cliente //////////////////////////////////////////////////
        ////////////////////////////////////////////////////////////////////////

        
        
        do {
            //capturamos el mensaje del servidor y lo mostramos
            res = flujoEntrada.readUTF();
            System.out.print(res);
                
            /* si nos devuelve el mensaje de que no hemos acertado(ya hemos usado
            los 10 intentos) nos saltamos las otras verificaciones y salimos del 
            bucle do-while */
            if (res.equals("No has acertado!!!")) {
                ver = false;

            //si el mensaje es otro    
            } else {
                
                //capturamos el numero metido y lo enviamos al servidor
                flujoSalida.write(dato.nextInt());
                
                //capturamos el resultado del servidor y lo mostramos
                res = flujoEntrada.readUTF();
                System.out.println(res);
                
                //si es que hemos acertado salimos del bucle do-while
                if (res.equals("Has acertado!!!")){
                    ver=false;
                }
                
                
            }

        } while (ver);

        
        //cerramos el cliente
        try {
            cliente.close();
        } catch (IOException ex) {
            System.out.println("Fallo al cerrar el cliente: " + ex);
        }

    }

}
