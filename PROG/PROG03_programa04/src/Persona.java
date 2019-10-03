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
    
    public Persona(String nombre, String dni, int edad, float altura){
        this.nombre=nombre;
        this.dni=dni;
        this.edad=edad;
        this.altura=altura;
    }
            
    
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
        dni=this.dni;
        }
    
    void cambia_Edad(int edad){
        edad=this.edad;
        }
    
    void cambia_Altura(float altura){
        altura=this.altura;
        }
    
public static void main(String[] args) {
    
    String nombre;
    String dni;
    int edad;
    float altura;
    Scanner dato = new Scanner(System.in);
    
    System.out.print("Dame un nombre: ");
    nombre=dato.next();
    
    System.out.print("Dame el dni: ");
    dni=dato.next();
    
    System.out.print("Dame la edad: ");
    edad=dato.nextInt();
    
    System.out.print("Dame un altura(ejemplo: 1,75): ");
    altura=dato.nextFloat();
    
    
    Persona a = new Persona(nombre,dni,edad,altura);
         
        System.out.println("\n\nLos valores introducidos son:");
        System.out.println("El nombre es: "+a.consulta_Nombre());
        System.out.println("El dni es: "+a.consulta_Dni());
        System.out.println("La edad es: "+a.consulta_Edad());
        System.out.println("La altura es: "+a.consulta_Altura());
   
       
    }
}    

