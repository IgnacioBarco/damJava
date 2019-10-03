
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Nacho
 */
public class Aplicacion {

    Scanner dato;
    String usuario, archivo;
    Pattern pat = null;
    Matcher mat = null;
    Archivo fichero;
    boolean ver;
    Logger logger;
    FileHandler fh;

    /**
     * verificamos si coincide con el patron
     *
     * @param dato dato a verificar
     * @param pat patron
     * @param mat el matcher
     * @return devuelve si concuerda con el patron o no
     */
    public String verificar(String dato, Pattern pat, Matcher mat) {

        mat = pat.matcher(dato);

        if (mat.find()) {
            // Coincide con el patrón 
            ver = true;
            return "coincide";
        } else {
            // NO coincide con el patrón
            ver = false;
            return "erroneo";
        }

    }

    /**
     * pide el nombre del usuario hasta que nos da uno correcto
     *
     * @param opcion si coincide con el patron
     */
    public void operativaUsuario(String opcion) {

        if (opcion.equals("coincide")) {

            logger.log(Level.INFO, "LOGIN: Se ha logado " + usuario);
            System.out.println("Usuario corecto");

        }
        if (opcion.equals("erroneo")) {
            logger.log(Level.WARNING, "USUARIO INCORRECTO: Se ha intentado logar " + usuario);
            System.out.println("El usuario no es correcto");

        }

    }

    /**
     * pide el nombre del fichero y lo lista
     *
     * @param opcion si coincide con el patron
     */
    public void operativaArchivo(String opcion) {

        if (opcion.equals("coincide")) {
            fichero = new Archivo(archivo, logger);
            logger.log(Level.INFO, "FILE: Se muestra el archivo " + archivo);

            System.out.println("Mostrando el archivo");
            System.out.println("--------------------");
            System.out.println(fichero.mostrarArchivo());
            System.out.println("--------------------");

        }
        if (opcion.equals("erroneo")) {
            logger.log(Level.WARNING, "FILE: El fichero " + archivo + " no existe");
            System.out.println("El fichero no existe");
        }
    }

    /**
     * crea el log y nos pregunta si queremos añadir las lineas o crearlo desde
     * 0
     */
    public void crearLog() {
        boolean log = false;
        boolean condicion = true;
        do {
            System.out.println("¿Quieres crear un log nuevo? si/no");
            String logNuevo = dato.next();
            if (logNuevo.equals("si")) {
                condicion = false;
                log = true;
            } else if (logNuevo.equals("no")) {
                condicion = true;
                log = true;
            } else {
                System.out.println("Opcion incorrecta, debe indicar si o no");
            }

        } while (!log);

        // Buscar o crear el logger que queremos utilizar.
        logger = Logger.getLogger("MiLog");
        try {

            //lo asociamos a un fichero log
            //true para que siga escribiendo, false para crear nuevo
            fh = new FileHandler("Log.txt", condicion);
            logger.addHandler(fh);

            //para no ver los mensajes por pantalla
            logger.setUseParentHandlers(false);

            //si queremos registrar todos los eventos utilizaremos
            logger.setLevel(Level.ALL);

            //Establecer el formato del fichero
            SimpleFormatter formatter = new SimpleFormatter();
            fh.setFormatter(formatter);

            // Añado un mensaje al log si se crea uno nuevo
            if (!condicion) {
                logger.log(Level.CONFIG, "Se inicia el log");

            }

        } catch (SecurityException e) {
            logger.log(Level.SEVERE, null, e);

        } catch (IOException ex) {
            logger.log(Level.SEVERE, null, ex);
        }

    }

    public Aplicacion() {

        dato = new Scanner(System.in);

        crearLog();

        /*pat = Pattern.compile("[a-z]{8}");
        mat = pat.matcher(usuario);*/
        
        do {
            System.out.print("Dime el usuario: ");
            usuario = dato.next();
            operativaUsuario(verificar(usuario, Pattern.compile("[a-z]{8}"), mat));

        } while (!ver);

        System.out.print("Dime el archivo: ");
        archivo = dato.next();
        operativaArchivo(verificar(archivo, Pattern.compile("[A-Za-z0-9]{1,8}\\.[a-zA-Z]{3}"), mat));

    }
}
