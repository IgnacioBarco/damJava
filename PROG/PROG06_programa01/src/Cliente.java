import java.io.*;
import java.util.logging.Logger;

/**
 *
 * @author Nacho
 */

//Clase para crear los clientes, implementando Serializable para pasar los objetos a un fichero
public class Cliente implements Serializable{
 
    //aunque en este caso no haria falta, es conveniente controlar el UID por si hubiese desfase de version
    private static final long serialVersionUID= 1L;
    
    String nif, nombre,direccion, telefono;
    int deuda;
    
    public Cliente(String nombre, String nif, String direccion, String telefono, int deuda){
        this.nombre = nombre;
        this.nif = nif;
        this.direccion = direccion;
        this.telefono = telefono;
        this.deuda = deuda;
    }

    //nos muestra el cliente en una linea de texto
    public String toString() {
        return "NOMBRE: "+nombre+
                "  NIF: "+nif+
                "  DIRECCION: "+direccion+
                "  TELEFONO: "+telefono+
                "  DEUDA: "+deuda;
    }



    
    
}
