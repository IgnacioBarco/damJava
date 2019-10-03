/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Nacho
 */
public class programa06 {

    enum meses{enero,febrero,marzo,abril,mayo,junio,julio,agosto,septiembre,octubre,noviembre,diciembre}; 
    
    public static void main(String[] args) {
       
        meses m = meses.marzo;
        System.out.println("La variable m tiene como valor " + m);
                
        
        m = meses.valueOf("MARZO".toLowerCase());                
        System.out.println("La variable m tiene como valor " + m );
        
    }
    
}
