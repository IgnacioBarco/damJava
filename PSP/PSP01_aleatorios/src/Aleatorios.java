
import java.util.Scanner;

/**
 *
 * @author Nacho
 */
public class Aleatorios {

    static String resultado = "";

    public static void main(String[] args) {

        if (args.length==0){
            crearAleatorios(40);
        } else {
            crearAleatorios(Integer.valueOf(args[0]));
        }
        

        System.out.println(resultado);
    }

    /**
     * Crea una cantidad de numeros aleatorios segun el parametetro que le
     * pasemos
     *
     * @param cant int de numeros aleatorios que queremos
     */
    public static void crearAleatorios(int cant) {
        for (int i = 0; i < cant; i++) {
            int x = (int) Math.round(Math.random() * 101);
            resultado = resultado + x + "\n";

        }
    }

}
