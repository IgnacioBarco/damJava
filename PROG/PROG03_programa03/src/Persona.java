

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
    
    public Persona(){
        nombre="Carmen Vega";
        dni="12345678P";
        edad=30;
        altura=1.58f;       
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
         
        Persona a = new Persona();
         
        System.out.println("El nombre es: "+a.consulta_Nombre());
        System.out.println("El dni es: "+a.consulta_Dni());
        System.out.println("La edad es: "+a.consulta_Edad());
        System.out.println("La altura es: "+a.consulta_Altura());
         
     }
   
       
    }
    

