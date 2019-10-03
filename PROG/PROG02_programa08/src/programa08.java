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
public class programa08 {

    public static void main(String[] args) {
        
    Scanner dato = new Scanner(System.in);
    System.out.print("Dame el primer número: ");
    float d1 = dato.nextInt();
    System.out.print("Dame el segundo número: ");
    float d2 = dato.nextInt();
    System.out.println("x = "+d1+"  y = "+d2);
    System.out.println("x + y = "+(d1+d2));
    System.out.println("x - y = "+(d1-d2));
    System.out.println("x * y = "+(d1*d2));
    System.out.println("x / y = "+(d1/d2));
    System.out.println("x ^ 2 = "+Math.pow(d1,2));
    System.out.println("? x = "+Math.sqrt(d1));      
                
    }
    
}
