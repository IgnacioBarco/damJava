
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nacho
 */
public class Lenguaje {

    static File archivo;
    static boolean existe = false;
    static int numeroPalabras;

    static RandomAccessFile raf = null;
    static FileLock bloqueo = null;

    static FileWriter fw;
    static PrintWriter pw;
    static int i = 0;
    static int numProceso;

    public static void main(String[] args) {

        //si no tiene argumentos le ponemos que nos genere 5 palabras
        //en un fichero que se llame prueba.txt
        //esto lo hacemos para probar el programa desde el netbeans        
        if (args.length == 0) {
            numeroPalabras = 5;
            archivo = new File("prueba.txt");
            numProceso = 999;
        } else if (args.length==3) {
            numeroPalabras = Integer.valueOf(args[0]);
            archivo = new File(args[1]);
            numProceso = Integer.valueOf(args[2]);
        } else {
            numeroPalabras = Integer.valueOf(args[0]);
            archivo = new File(args[1]);
            numProceso = -1;
        }
        
        //si no existe el archivo lo creamos
        if (!comprobarArchivo()) {
            crearArchivo();
        }

        seccionCritica();

    }

    /**
     * verificamos si existe el archivo o no
     * @return nos devuelve true si existe y false si no
     */
    public static boolean comprobarArchivo() {
        if (archivo.exists()) {
            existe = true;
            System.out.println("El archivo ya existe");
        } else {
            existe = false;
            System.out.println("El archivo no existe");
        }
        return existe;
    }

    /**
     * Crea el archivo
     */
    public static void crearArchivo() {
        try {
            archivo.createNewFile();
            System.out.println("Creamos el fichero");
        } catch (IOException ex) {
            System.out.println("Error al crear el archivo: " + ex);
        }
    }

    /**
     * Genera el numero de palabras aleatorias que le asignemos y las escribe en el fichero
     * @throws IOException 
     */
    public static void crearListado() throws IOException {
        String[] abecedario = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J",
            "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
        
        //nos ponemos al final del archivo
        raf.seek(raf.length());

        //para ver que proceso esta escribiendo
        //si es -1 significa que no le hemos puesto parametros del proceso
        if (numProceso!=-1){
            raf.writeBytes("Escribiendo el proceso numero " + numProceso + "\r\n");
        }
        
        
        //bucle que genera el numero de palabras
        for (int i = 0; i < numeroPalabras; i++) {
            
            String palabra = "";
            int num = (int) Math.round(Math.random() * 10 + 3);
            
            //genera una plabra aleatoria entre 3 y 8 letras
            for (int j = 0; j < num; j++) {
                palabra = palabra + abecedario[(int) Math.round(Math.random() * 25)];

            }

            //hacemos que cambie de linea cada vez que escriba una palabra
            String palabra2 = palabra + "\r\n";
            raf.writeBytes(palabra2);
            
            //tambien se puede hacer asi
            //raf.writeBytes(palabra+System.getProperty("line.separator"));
            //y otra opcion es pasandole el 10 como byte

            //volvemos a irnos al final del archivo
            raf.seek(raf.length());

            //para comprobar el numero de palabras:
            //lo desactivo ya que al hacer la longitud aleatoria
            //no funciona bien, si fuese fija nos valdria
            //System.out.println("reg " + raf.length() / 8);
            //System.out.println(palabra);
        }

    }

    public static void seccionCritica() {

        try {

            //abrimos el fichero
            raf = new RandomAccessFile(archivo, "rwd");

            bloqueo = raf.getChannel().lock();

            crearListado();
            
            //para validar datos
            cuentaLineas();

            bloqueo.release();
            bloqueo = null;

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Lenguaje.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Lenguaje.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (null != raf) {
                    raf.close();
                }
                if (null != bloqueo) {
                    bloqueo.release();
                }
            } catch (Exception e2) {
                System.out.println("Error al cerrar el fichero");

            }
        }
    }

    /**
     * Nos saca por consola el numero de lineas del fichero,
     * es para verificar que si ejecutamos varias veces el fichero
     * nos rellene el numero correcto de lineas
     * @throws IOException 
     */
    public static void cuentaLineas() throws IOException {
        raf.seek(0);
        while ((raf.readLine()) != null) {
            i++;
        }
        System.out.println("Hay " + i + " lineas.");
    }

}
