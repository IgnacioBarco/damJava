
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;
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
public class Servidor02 {

    int puerto = 1500;
    ServerSocket server;
    Socket cliente;
    OutputStream auxOut;
    DataOutputStream flujoSalida;
    InputStream auxIn;
    DataInputStream flujoEntrada;

    String fichero;
    boolean ver = true;
    File archivo;
    RandomAccessFile raf;

    public Servidor02() throws IOException {

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

        ////////////////////////////////////////////////////////////////////////
        // logica de servidor //////////////////////////////////////////////////
        ////////////////////////////////////////////////////////////////////////
        
        //preguntamos al cliente el nombre del fichero
        flujoSalida.writeUTF("Dime que fichero quieres: ");
        
        //escuchamos el nombre del fichero y creamos una variable con el
        fichero = flujoEntrada.readUTF().trim();
        archivo = new File("archivos\\" + fichero);
        
        /* si el fichero no existe devolvemos que no, y cerramos el servidor
        si existe, le metemos en un randomaccesfile y se lo pasamos linea por
        linea, hasta que se termina, que le enviamos el mensaje de Fichero
        finalizado 
        la ruta es la carpeta archivos del proyecto, hemos creado prueba.txt
        y abecedario.txt*/
        if (archivo.isFile()) {
            //enviamos el texto de apertura de fichero
            flujoSalida.writeUTF("Enviando fichero:");
            raf = new RandomAccessFile(archivo, "r");

            /*mientras que sea verdadero nos envia linea a linea, cuando salta
            la excepcion es que ya ha terminado y le enviamos ficher finalizado*/
                raf.seek(0);
                String linea = raf.readLine();
                while (linea != null) {
                    flujoSalida.writeUTF(linea);
                    linea = raf.readLine();
                }
                flujoSalida.writeUTF("Fichero finalizado");
                
        /* otra opcion, aunque menos elegante
                try {
                raf.seek(0);
                while (true) {
                    flujoSalida.writeUTF(raf.readLine());
                }
            } catch (Exception e) {
                flujoSalida.writeUTF("Fichero finalizado");
            }
                */        
        
                  

                
        //cuando no existe el fichero    
        } else {
            flujoSalida.writeUTF("No existe el fichero.");
        }

        //cerramos el servidor
        try {
            server.close();
            System.out.println("Servidor cerrado.");
        } catch (IOException ex) {
            System.out.println("Fallo al cerrar el servidor: " + ex);
        }

    }
}
