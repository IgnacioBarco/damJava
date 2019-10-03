
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Nacho
 */
public class ServidorAuxiliar extends Thread {

    int puerto = 6060;
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

    Banca banca;
    int estado = 1;
    String mensaje = "";
    String nombre = "";
    int[] baraja;
    int apuesta;

    public ServidorAuxiliar(Socket cliente, Banca banca) throws IOException {

        this.banca = banca;

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

    }

    ////////////////////////////////////////////////////////////////////////////
    /////   Hilo   ////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////
    public void run() {

        //creamos un nuevo juego
        Juego juego = new Juego();

        do {
            try {
                switch (estado) {

                    //recibimos el nombre y saludamos
                    case 1:
                        //primera apuesta
                        flujoSalida.writeUTF("Dime tu nombre: ");
                        nombre = flujoEntrada.readUTF();
                        System.out.println("Vamos a atender a " + nombre);
                        flujoSalida.writeUTF("Saludos " + nombre + "!!!");

                        flujoSalida.write(2);
                        estado = 2;

                        break;

                    //pedimos cuanto quiere apostar    
                    case 2:
                        flujoSalida.writeUTF("Cuanto quieres apostar? ");
                        apuesta = flujoEntrada.readInt();
                        
                        //si se puede cubrir la apuesta seguimos, si no cerramos
                        if (banca.retirar(apuesta)) {
                            flujoSalida.writeUTF("Apuesta aceptada");
                            flujoSalida.write(3);
                            System.out.println("La banca apuesta " + apuesta + " con " + nombre
                                    + " quedando un saldo de " + banca.devolverSaldoBanca());
                            estado = 3;
                        
                            //cerramos la conexion
                        } else {
                            flujoSalida.writeUTF("No hay suficiente dinero "
                                    + "en la banca, vuelva mas tarde");
                            flujoSalida.write(5);
                            System.out.println("No hay suficiente saldo en la banca"
                                    + " para cubrir la apuesta de " + nombre);
                            System.out.println("Cerramos la conexión de " + nombre);
                            flujoSalida.write(5);
                            estado = 5;
                        }

                        break;

                    //jugamos
                    case 3:

                        //enviamos un string con el resultado del juego
                        flujoSalida.writeUTF(juego.jugar());

                        //si ha ganado la banca ingresamos el doble de lo apostado
                        //(lo que habiamos retirado y lo que ha apostado el jugador)
                        if (juego.ganadorBanca) {
                            banca.ingresar(apuesta * 2);
                            System.out.println("La banca ha ganado " + apuesta
                                    + " , teniendo ahora un saldo de " + banca.devolverSaldoBanca());
                        }
                        
                        flujoSalida.write(4);
                        estado = 4;
                        break;

                    //enviamos si quiere otra partida o salir    
                    case 4:
                        flujoSalida.writeUTF("otra o salir? ");
                        mensaje = flujoEntrada.readUTF();
                        
                        //si nos devuelve otra nos vamos de nuevo al 2
                        if (mensaje.equals("otra")) {
                            flujoSalida.writeUTF("Volvamos a apostar");
                            flujoSalida.write(2);
                            estado = 2;
                            
                        //si nos devuelve salir, salimos    
                        } else if (mensaje.equals("salir")) {
                            flujoSalida.writeUTF("Hasta pronto!!!");
                            flujoSalida.write(5);
                            estado = 5;
                            System.out.println("Cerramos la conexión de " + nombre);
                        
                        //si no es ninguna de las dos, volvemos a preguntar
                        } else {
                            flujoSalida.writeUTF("Opcion incorrecta. otra o salir? ");
                            flujoSalida.write(4);
                        }

                        break;

                }

            } catch (IOException ex) {
                //System.out.println("Fallo: " + ex);
            }
        } while (estado != 5);
    }
}
