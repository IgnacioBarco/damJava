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
public class programa01 {

    public static void main(String[] args) {
    
    Scanner dato = new Scanner(System.in);
    System.out.print("Dame el primer numero: ");
    int a = dato.nextInt();
    System.out.print("Dame el segundo numero: ");
    int b = dato.nextInt();
    System.out.print("Dame el tercer numero: ");
    int c = dato.nextInt();
    
    Compara comparacion = new Compara(a,b,c);
    comparacion.condiciones();
    System.out.println("\n"+comparacion.devuelve_resultado());
    
    
    }
    
}
