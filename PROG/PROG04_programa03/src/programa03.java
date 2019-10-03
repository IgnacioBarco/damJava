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
public class programa03 {

    public static void main(String[] args) {
    
    Scanner dato = new Scanner(System.in);
    System.out.print("Dame el numero que quieres descomponer en factores primos: ");
    int numero = dato.nextInt();
    
   Calculo calculo = new Calculo(numero);
   
   calculo.factorizacion();
   
   System.out.println("\nLos factores primos de "+numero+" son:"+calculo.res);
   
   
    
            
    }
    
}
