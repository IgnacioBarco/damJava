/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Nacho
 */
public class ejercicio2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Mesa mesa = new Mesa();

        Filosofo filosofo1 = new Filosofo(mesa, 1);
        Filosofo filosofo2 = new Filosofo(mesa, 2);
        Filosofo filosofo3 = new Filosofo(mesa, 3);
        Filosofo filosofo4 = new Filosofo(mesa, 4);
        Filosofo filosofo5 = new Filosofo(mesa, 5);

        filosofo1.start();
        filosofo2.start();
        filosofo3.start();
        filosofo4.start();
        filosofo5.start();
    }

}
