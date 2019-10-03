/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Nacho
 */
public class Banca {

    private int saldo = 0;

    public Banca(int saldo) {
        
        //le ponemos el saldo que nos indica el servidor
        this.saldo = saldo;

    }

    /**
     * devuelve el saldo actual de la banca
     *
     * @return saldo
     */
    public synchronized int devolverSaldoBanca() {
        return saldo;
    }

    /**
     * retiramos dinero
     *
     * @param cantidad lo que se saca
     * @return true si se ha sacado, y false si no hay saldo suficiente
     */
    public synchronized boolean retirar(int cantidad) {
        if (cantidad <= saldo) {
            saldo = saldo - cantidad;
            return true;
        } else {
            return false;
        }
    }

    /**
     * ingresamos dinero
     *
     * @param cantidad lo que se ingresa
     */
    public synchronized void ingresar(int cantidad) {
        saldo = saldo + cantidad;
    }

}
