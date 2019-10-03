
import java.util.Scanner;


/**
 *
 * @author Nacho
 */
public class programa01 {
    
    
    
    public static void main(String[] args) {
        
        Scanner dato = new Scanner(System.in);
        String opcion = "";
        
        //creamos un objeto fichero para actuar con el fichero
        Fichero fichero = new Fichero();
        
        do{ 
            System.out.println("\n1. Añadir cliente");
            System.out.println("2. Listar cliente");
            System.out.println("3. Buscar cliente");
            System.out.println("4. Borrar cliente");
            System.out.println("5. Borrar fichero de clientes completamente");
            System.out.println("6. Salir\n");
            System.out.print("Introduce la opcion deseada: ");
            opcion=dato.nextLine();
            
            switch(opcion){
                case "1": //1. Añadir cliente
                    Cliente clienteNuevo;
                    clienteNuevo=fichero.pedirDatosCliente();
                    fichero.anadeCliente(clienteNuevo);
                    break;
                
                case "2": //2. Listar clientes
                    fichero.listarClientes();
                    break;
                
                case "3": //3. Buscar cliente
                    fichero.buscarCliente();
                    break;
                
                case "4": //4. Borrar cliente
                    fichero.borrarCliente();
                    break;
                
                case "5": //5. Borrar fichero de clientes completamente    
                    fichero.borrarFichero();
                    break;
                
                case "6": //6. Salir
                    System.out.println("\n\n Ha elegido salir de la aplicación");
                    //cambiamos el valor de opcion para salir del bucle
                    opcion="salir";
                    break;
            
                //para cuando el usuario teclee algo que no sea del 1 al 6
                default:    
                    System.out.println("Opción incorrecta\n\n");
                    break;
            }
        }while(!opcion.equals("salir"));
    }            
    
    
}
