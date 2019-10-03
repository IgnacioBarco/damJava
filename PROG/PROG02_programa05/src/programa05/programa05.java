/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programa05;

import java.util.Scanner;

/**
 *
 * @author Nacho
 */
public class programa05 {

    public static void main(String[] args) {
        
       Scanner dato = new Scanner(System.in);
              
       System.out.print("Teclee el primer número: ");
       int a = dato.nextInt();
       
       System.out.print("Ingrese el segundo número ");
       int b = dato.nextInt();
       
       String resultado;
       if (a%b == 0){
            resultado="El numero " + a + " es multiplo de " + b;
           }else resultado="El numero " + a + " no es multiplo de " + b;
            
      System.out.println(resultado); 
    }   
    
    
}
