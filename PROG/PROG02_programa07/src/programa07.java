/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.Scanner;
/**
 *
 * @author Nacho
 */
public class programa07 {

    public static void main(String[] args) {
        
        Scanner dato = new Scanner(System.in);   
        
        System.out.println("Ecuacion ==>  C1x + C2 = 0");
        System.out.print("Dame C1: ");
        int c1 = dato.nextInt();
        System.out.print("Dame C2: ");
        int c2 = dato.nextInt();
        System.out.println("X tiene un valor de " + (float)-c2/(float)c1 + " en la ecuación " + c1+"x + "+c2+" = 0");
   }
}    
    
