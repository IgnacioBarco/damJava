/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Nacho
 */
public class Filosofo extends Thread {

    Mesa mesa;
    int filosofo;

    public Filosofo(Mesa mesa, int filosofo) {

        this.mesa = mesa;
        this.filosofo = filosofo;

    }

    public void run() {
        while (true) {
            mesa.comer(filosofo);
            mesa.pensar(filosofo);
        }
    }

}
