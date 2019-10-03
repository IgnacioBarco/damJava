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
public class programa04 {

   public static void main(String[] args) {
      
       int edad;
       String nombre;
       
       Scanner dato = new Scanner(System.in);
       System.out.print("Dame tu nombre: ");
       nombre = dato.next();
       System.out.print("Dame tu edad: ");
       edad = dato.nextInt();
       
       Calculo calculo = new Calculo(nombre, edad);
       
       calculo.get_mayorEdad();
       
       calculo.get_dentro10();
       
       calculo.get_clasificaEdad();
    }
}
