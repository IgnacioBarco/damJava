
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
public class Bufer {

    String[] bufer;
    String dato = "";
    int posicionActual;

    public Bufer() {

        /*
        ponemos 3 datos para que se vea mejor la interaccion con los hilos,
        ya que si lo ponemos vacio me sale todo el rato que pone un dato
        y despues lo quita...        
         */
        bufer = new String[6];
        bufer[0] = "a";
        bufer[1] = "b";
        bufer[2] = "c";
        bufer[3] = "";
        bufer[4] = "";
        bufer[5] = "";

        posicionActual = 2;

    }

    /**
     * obtiene el primer dato del array 
     * y mueve las posiciones
     * @param pendientes numero de datos pendientea de sacar
     */
    public synchronized void obtenerDato(int pendientes) {
        //si la posicion es -1, significa que no hay datos
        //y que tiene que esperar
        while (posicionActual < 0) {
            try {
                wait();
            } catch (InterruptedException ex) {
            }
        }
        
        System.out.println("hilo " + Thread.currentThread().getName()
                + " dato sacado: " + bufer[0] + dato
                + ". Quedan " + pendientes + " datos por consumir.");

        moverArray();
        posicionActual--;
        notify();
      
    }

    /**
     * mete un valor en la posicion libre mayor del array
     * @param dato el valor a introducir
     * @param pendientes numero de datos pendientes de introducir
     */
    public synchronized void meterDato(String dato, int pendientes) {
        //si la posicion es 5, significa que el array esta lleno
        //y que tiene quie esperar a que haya un hueco para
        //meter datos
        while (posicionActual == 5) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("excepcion: " + e);
            }
        }

        posicionActual++;
        bufer[posicionActual] = dato;

        System.out.println("hilo " + Thread.currentThread().getName() 
                + " dato metido: " + dato
                + ". Quedan " + pendientes + " datos por producir.");

        notify();

    }

    /**
     * hace que se muevan las posiciones
     * introduciendo un puesto vacio en el ultimo elemente
     * y moviendo hacia abajo el resto
     */
    public void moverArray() {
        for (int i = 0; i <= 5; i++) {

            if (i == 5) {
                bufer[5] = "";
            } else {
                bufer[i] = bufer[i + 1];
            }

        }
    }

}
