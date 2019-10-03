
/**
 *
 * @author Nacho
 */
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class OrdenarNumeros {

    static InputStreamReader isr;
    static BufferedReader br;
    static String resultado = "";
    static String linea;
    static ArrayList array;

    public static void main(String[] args) {

        /*   isr = new InputStreamReader(System.in);
        br = new BufferedReader(isr);
        array = new ArrayList(); */
        capturarDatos();

        //imprimimos listado sin ordenar
        System.out.println("\nListado sin ordenar:\n");
        System.out.println(resultado);
        System.out.println("-----------------\n");

        //imprimimos listado ordenado
        System.out.println("Listado ordenado:\n");
        listarNumeros();

    }

    /**
     * capturamos los datos que no llegan por la entrada System.in y los
     * tratamos linea a linea, pasando los datos a un array
     */
    public static void capturarDatos() {
        isr = new InputStreamReader(System.in);
        br = new BufferedReader(isr);
        array = new ArrayList();

        try {
            while ((linea = br.readLine()) != null) {
                //para que no nos saque la ultima linea como null
                if (!linea.equals("null")) {
                    if (!linea.equals("")) {
                        array.add(Integer.parseInt(linea));
                        resultado = resultado + linea + "\n";
                    }
                }
            }
            ordenarNumeros();

        } catch (IOException ex) {
            System.out.println("Error " + ex);
        }

    }

    /**
     * ordena el array de numeros
     */
    public static void ordenarNumeros() {
        Collections.sort(array);

    }

    /**
     * Lista los numeros del array
     */
    public static void listarNumeros() {
        for (Object object : array) {
            System.out.println(object.toString());
        }
    }

}
