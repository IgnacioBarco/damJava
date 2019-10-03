
import java.util.Scanner;



/**
 *
 * @author Nacho
 */
public class Persona
    {
        String nombre;
        String dni;
        int edad;
        float altura;
                  
        
    String consulta_Nombre(){
        return nombre;
        }
    
    String consulta_Dni(){
        return dni;
        }
    
    int consulta_Edad(){
        return edad;
        }
    
    float consulta_Altura(){
        return altura;
        }

    void cambia_Nombre(String nom){
        nombre=nom;
        }
    
    void cambia_Dni(String dni){
        this.dni=dni;
        }
    
    void cambia_Edad(int edad){
        this.edad=edad;
        }
    
    void cambia_Altura(float altura){
        this.altura=altura;
        }
    
 public static void main(String[] args) {
     
        Persona a = new Persona();
     
        Scanner dato = new Scanner(System.in);
        System.out.print("Dame un nombre: ");
        a.cambia_Nombre(dato.next());
        
        System.out.print("Dame el dni: ");
        a.cambia_Dni(dato.next());
        
        System.out.print("Dame la edad: ");
        a.cambia_Edad(dato.nextInt());
        
        System.out.print("Dame un altura(ejemplo: 1,75): ");
        a.cambia_Altura(dato.nextFloat());
        
        System.out.println("\n\nEl nombre dado es: "+a.consulta_Nombre());
        System.out.println("El dni dado es: "+a.consulta_Dni());
        System.out.println("La edad dada es: "+a.consulta_Edad());
        System.out.println("La altura dada es: "+a.consulta_Altura());
        
        System.out.print("\n\nAhora vamos a modificar los datos:");
        System.out.print("\nEl nombre antiguo era "+a.consulta_Nombre()+". Dame ahora el nuevo:");
        a.cambia_Nombre(dato.next());
        
        System.out.print("El DNI antiguo era "+a.consulta_Dni()+". Dame ahora el nuevo:");
        a.cambia_Dni(dato.next());
        
        System.out.print("La edad antigua era "+a.consulta_Edad()+". Dame ahora la nueva:");
        a.cambia_Edad(dato.nextInt());
        
        System.out.print("La altura antigua era "+a.consulta_Nombre()+". Dame ahora la nueva:");
        a.cambia_Altura(dato.nextFloat());
        
        System.out.println("\n\nEstos son los datos nuevos:");
        System.out.println("El nombre nuevo dado es: "+a.consulta_Nombre());
        System.out.println("El dni nuevo dado es: "+a.consulta_Dni());
        System.out.println("La edad nueva dada es: "+a.consulta_Edad());
        System.out.println("La altura nueva dada es: "+a.consulta_Altura());
        
        
     
 }
       
       
}
    

