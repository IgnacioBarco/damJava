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
public class programa02 {

    public static void main(String[] args) {
        
        Scanner dato = new Scanner(System.in);
        System.out.print("Dame el numero del mes: ");
        short mes = dato.nextShort();
        System.out.print("Dame el año: ");
        int año = dato.nextInt();
        
        Consulta consulta = new Consulta(mes, año);
        consulta.calcula_Dias();
        System.out.println("\nEl mes numero "+mes+" del año "+año+" tiene "+consulta.devuelve_Dias()+" dias");
        
    
    }
    
}
