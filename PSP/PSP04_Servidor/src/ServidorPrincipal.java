
import java.io.File;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
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
public class ServidorPrincipal {

    int puerto = 6060;
    ServerSocket server;
    Banca banca;
    Scanner dato;

    public ServidorPrincipal() {

        //creamos el servidor
        try {
            server = new ServerSocket(puerto);
            System.out.println("Servidor activo, escuchando en el puerto: " + puerto);

        } catch (IOException ex) {
            System.out.println("Fallo al crear el server: " + ex);
        }

        //scaner para saber el saldo inicial
        dato = new Scanner(System.in);
        System.out.print("Dime la cantidad de dinero que va a tener la banca: ");

        //inicializamos la banca
        banca = new Banca(dato.nextInt());
        System.out.println("Saldo inicial de la banca: " + banca.devolverSaldoBanca());

        while (true) {
            try {
                // Se conecta un cliente
                Socket cliente = server.accept();
                System.out.println("Cliente conectado");
                // Atiendo al cliente mediante un thread
                new ServidorAuxiliar(cliente, banca).start();
            } catch (IOException ex) {
                //System.out.println("Fallo: "+ex);
            }

        }

    }
}
