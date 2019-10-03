
import java.util.Scanner;

/**
 *
 * @author Nacho
 */
public class Persona {
    
    String nombre;
    String dni;
    int edad;
    float altura;

    public String consulta_Nombre(){
        return nombre;
    }

    void cambia_Nombre(String nom){
        nombre=nom;
    }
        
    
public static void main(String[] args) {

    Persona a = new Persona(); 
    
    Scanner dato = new Scanner(System.in);
    System.out.print("Dame un nombre: ");
    String nombre = dato.nextLine();
        
    a.cambia_Nombre(nombre);
    
    System.out.println("El nombre dado es: "+a.consulta_Nombre());
}
    
    
}
