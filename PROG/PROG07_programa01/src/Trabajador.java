


/**
 *
 * @author Nacho
 */


//para crear un objeto trabajador
public class Trabajador {
    
    String tipoTrabajador, interino, nombre, apellidos, sexo, edad, nif, email, 
            telefono, fechaAlta;

    public Trabajador(String tipoTrabajador, String interino, String nombre, 
            String apellidos, String sexo, String edad, String nif, String email, 
            String telefono, String fechaAlta) {
        this.tipoTrabajador = tipoTrabajador;
        this.interino = interino;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.sexo = sexo;
        this.edad = edad;
        this.nif = nif;
        this.email = email;
        this.telefono = telefono;
        this.fechaAlta = fechaAlta;
    }
            
   
   //escribe todos los valores del trabajador
   public String toString(){
       return tipoTrabajador+","+interino+","+nombre+","+apellidos+","+sexo+","
               +edad+","+nif+","+email+","+telefono+","+fechaAlta;
   }
}