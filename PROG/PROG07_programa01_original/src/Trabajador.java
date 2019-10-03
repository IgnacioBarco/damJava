
import java.util.Date;


/**
 *
 * @author Nacho
 */
public class Trabajador {
    
    String tipoTrabajador, interino, nombre, apellido1, apellido2,nif, email, 
            telefono, fechaAlta;

    public Trabajador(String tipoTrabajador, String interino, String nombre, String apellido1, String apellido2, String nif, String email, String telefono, String fechaAlta) {
        this.tipoTrabajador = tipoTrabajador;
        this.interino = interino;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.nif = nif;
        this.email = email;
        this.telefono = telefono;
        this.fechaAlta = fechaAlta;
    }
            
   
   
   public String toString(){
       return tipoTrabajador+","+interino+","+nombre+","+apellido1+","+apellido2+","
               +nif+","+email+","+telefono+","+fechaAlta;
   }
}