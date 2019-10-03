
import java.util.Scanner;


/**
 *
 * @author Nacho
 */
public class Programa01 {

    
    public static void main(String[] args) {
        
        //pedimos los datos
        Scanner datos = new Scanner(System.in);
        System.out.print("Dame la linea: ");
        String datosIn = datos.nextLine();
        
        //creamos el objeto cliente pasandole al liena introducida
        Cliente cliente = new Cliente(datosIn);
        
        //verificamos que al menos tenga 5 campos introducidos
        if (cliente.checkearFormatoDatosIntroducidos()){
            //System.out.println("valido");
            
            cliente.obtenerCampos();
            
            cliente.construirXML();
            
        } else {
            System.out.println("El formato introducido no se puede pasar a XML");
        }
    }
  
    
}
