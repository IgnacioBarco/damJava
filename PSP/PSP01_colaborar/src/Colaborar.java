
import java.io.IOException;
import java.lang.Process;
import java.lang.Runtime;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nacho
 */
public class Colaborar {

    static Process nuevoProceso;

    public static void main(String[] args) {

        try {
            //ejecutamos 10 procesos
            //le pasamos un tercer parametro para ver como lo guarda en el fichero
            for (int i = 0; i < 10; i++) {
                //para ejecutar directamente desde netbenans y hacer pruebas usabamos este comando
                //String proceso = "java -jar D:\\programas\\JavaProgramas\\programacion\\PSP01_lenguaje\\dist\\PSP01_lenguaje.jar "+10*(i+1)+" aaa.txt " +(i+1) ;
                
                //para usarlo desde una misma carpeta usaremos este
                String proceso = "java -jar PSP01_lenguaje.jar "+10*(i+1)+" miFicheroDeLenguaje.txt " +(i+1) ;
                nuevoProceso = Runtime.getRuntime().exec(proceso);
                System.out.println(proceso);
            }
            

        } catch (IOException ex) {
            Logger.getLogger(Colaborar.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SecurityException ex) {
            Logger.getLogger(Colaborar.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(Colaborar.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
