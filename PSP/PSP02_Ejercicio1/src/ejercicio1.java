/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Nacho
 */
public class ejercicio1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Bufer contenedor = new Bufer();
        
        Productor productor= new Productor(contenedor);
        Consumidor consumidor = new Consumidor(contenedor);
        
        productor.start();
        consumidor.start();
    }
    
}
