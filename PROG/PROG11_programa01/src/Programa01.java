
import javax.swing.JOptionPane;


/**
 *
 * @author Nacho
 */
public class Programa01 {

    static String opcion;
    static JOptionPane panelOpciones;
    public static void main(String[] args) {
        //creamos el objeto para operar con el
        BaseDatos baseDatos = new BaseDatos();
        
        //abrimos las conexiones con la base de datos
        baseDatos.abrirConexion();
        
        //creamos el menu principal, cuando salir sea true, salimos del bucle
        boolean salir = false;
        do{
            opcion="";
            opcion=panelOpciones.showInputDialog("Elige tu numero de opción:"
                    +"\n1. Crear tablas"
                    +"\n2. Insertar datos en tablas"
                    +"\n3. Recuperar datos de tablas"
                    +"\n4. Actualizar cliente"
                    +"\n5. Listar nombre de clientes que han realizado una compraventa"
                    +"\n6. Borrar tablas"
                    +"\n7. Salir"
                        ,"Introduce tu selección");
            System.out.println(opcion);
            //por si damos a cancelar, que no de fallo
            if (opcion==null){
                opcion="7";
            }
            //en cada opcion llamamos al metodo de la opcion
            switch(opcion){
                case "1":
                    System.out.println("opcion1");
                    baseDatos.crearTablas();
                    break;
                case "2":
                    System.out.println("opcion2");
                    baseDatos.insertarDatos();
                    break;
                case "3":
                    System.out.println("opcion3");
                    baseDatos.recuperarDatos();
                    break;
                case "4":
                    System.out.println("opcion4");
                    baseDatos.actualizarTabla();
                    break;
                case "5":
                    System.out.println("opcion5");
                    baseDatos.listarNombres();
                    break;
                case "6":
                    System.out.println("opcion6");
                    baseDatos.borrarTablas();
                    break;
                case "7":
                    System.out.println("salir");
                    salir=true;
                    break;
                                    
                default:
                    System.out.println("Opcion incorrecta");
                    mostrarMensaje("opcion incorrecta");
            } 
        }while(!salir); 
        
        //cerramos las conexiones antes de salir
        baseDatos.cerrarConexion(); 
    
    }
    
    //muestra panel con informacion del sistema 
    public static void mostrarMensaje(String mensaje){
        JOptionPane.showMessageDialog(null, mensaje, "Información del sistema", 
                JOptionPane.INFORMATION_MESSAGE);
    }
     
       
    
}
