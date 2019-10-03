
import numeros.Complejo;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Nacho
 */
public class programa05 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        double real, imag, numero;
         
        Complejo a = new Complejo();
        System.out.println("Los datos por defecto son: "+a.toString());
        
        
        Scanner dato = new Scanner(System.in);
        System.out.println("\n\nAhora vamos a modificar los datos");
        System.out.print("Dame la parte real: ");
        real = dato.nextDouble();
        System.out.print("Dame la parte imaginaria: ");
        imag = dato.nextDouble();
        
        Complejo b = new Complejo(real, imag);
        System.out.println("\n\nLos datos del nuevo objeto son: ");
        System.out.println("Parte Real: "+b.consulta_Real()+"  Parte Imaginaria: "+b.consulta_Imag());
        System.out.println("String resultante: "+b.toString());
        
        System.out.println("\n\nAhora vamos a cambiarles los valores al objeto:");
        System.out.print("Dame la parte real nueva: ");
        real = dato.nextDouble();
        b.cambia_Real(real);
        System.out.print("Dame la parte imaginaria nueva: ");
        imag = dato.nextDouble();
        b.cambia_Imag(imag);
        System.out.println("\nAhora los datos del objeto han sido modificados: ");
        System.out.println("Parte Real: "+b.consulta_Real()+"  Parte Imaginaria: "+b.consulta_Imag());
        System.out.println("String resultante: "+b.toString());
        
        System.out.println("\n\nAhora vamos a crear un nuevo objeto y se lo vamos a sumar al creado");
        System.out.print("Dame la parte real del nuevo objeto: ");
        real = dato.nextDouble();
        System.out.print("Dame la parte imaginaria del nuevo objeto: ");
        imag = dato.nextDouble();
        Complejo c = new Complejo(real, imag);
        System.out.println("\n\nLos valores del objeto antiguo son: "+b.toString());
        System.out.println("Los valores del objeto nuevo son: "+c.toString());
        //creamos un nuevo objeto para no modificar valores a los anteriores
        Complejo d = new Complejo(b.consulta_Real(),b.consulta_Imag());
        d.sumar(c);
        System.out.println("La suma de objetos es: "+d.toString());
        
        
        
        
    }
    
}
