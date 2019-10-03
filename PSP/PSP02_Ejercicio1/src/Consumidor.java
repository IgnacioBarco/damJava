/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Nacho
 */
public class Consumidor extends Thread {

    Bufer bufer;
    String dato;

    public Consumidor(Bufer bufer) {
        this.bufer = bufer;
        System.out.println("Hilo creado");
    }

    public void run() {

        for (int i = 0; i<15; i++) {

            bufer.obtenerDato(14-i);
        }

    }

}
