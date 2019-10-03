/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Nacho
 */
public class Calculo {
    int edad;
    String nombre, res1, res2;
    
    public Calculo(String nombre, int edad){
        this.edad=edad;
        this.nombre=nombre;
    }
    
    public void get_mayorEdad(){
        if (edad<18) {
            System.out.println("\n"+nombre+" es menor de edad");
        } else System.out.println("\n"+nombre+" es mayor de edad");
    }
    
    public void get_dentro10(){
        System.out.println("Dentro de 10 años tendra "+(edad+10)+" años");
    }
    
    public void get_clasificaEdad(){
        if (edad<=25){
            System.out.println("La edad de "+nombre+" esta clasificada en A(menores de 25 años)" );
        }
        if (edad>25 && edad<=50){
            System.out.println("La edad de "+nombre+" esta clasificada en B(entre 25 y 50 años)" );
        }
        if (edad>=51){
            System.out.println("La edad de "+nombre+" esta clasificada en C(mayores de 50)" );
        }
        
    } 
}
