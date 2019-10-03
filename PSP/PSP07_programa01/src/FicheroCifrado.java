
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Nacho
 */
public class FicheroCifrado {

    File ficheroCifrado;
    KeyGenerator generadorLlave;
    SecureRandom secureRandom;
    byte[] semilla;
    SecretKey llave;
    String texto;
    Cipher cifrador;
    Cipher descifrador;
    byte[] buffer, bufferCifrado, bufferDescifrado, textoCifrado;
    FileInputStream fic;
    FileOutputStream foc;
    BufferedReader br;
    FileReader fr;
    ByteArrayOutputStream bos;
    int bytesLeidos = 0;

    /**
     * verifica si el fichero existe, y si es asi, lo borra
     *
     * @param file Archivo a buscar
     */
    public void verificarFichero(File file) {
        //borramos fichero antiguo si existe
        if (file.exists()) {
            file.delete();
            System.out.println("Borramos fichero: " + file.getName());
        }

        //creamos el fichero nuevo
        try {
            file.createNewFile();
            System.out.println("Creamos fichero: " + file.getName() + "\n");

        } catch (IOException ex) {
            System.out.println("Fallo al crear el archivo "
                    + file.getName() + ": " + ex);
        }
    }

    /**
     * generamos una clave: 
     * 
     * con semilla de la cadena del nombre de usuario + password.
     *
     * con un tamaño 128 bits.
     */
    public void generarClave() {

        try {
            generadorLlave = KeyGenerator.getInstance("AES");
        } catch (NoSuchAlgorithmException ex) {
            System.out.println("Fallo: " + ex);
        }

        semilla = ("IgnacioBarcoCano" + "contraseña").getBytes();

        secureRandom = new SecureRandom(semilla);

        generadorLlave.init(128, secureRandom);

        //SecretKey
        llave = generadorLlave.generateKey();

    }

    public String generarTexto() {

        return "xxxX Texto sin cifrar Xxxx";

    }

    public void crearFlujos() {
        buffer = new byte[1024];

        try {

            fic = new FileInputStream(ficheroCifrado);
            foc = new FileOutputStream(ficheroCifrado);

            fr = new FileReader(ficheroCifrado);
            br = new BufferedReader(fr);

            bos = new ByteArrayOutputStream();

        } catch (FileNotFoundException ex) {
            Logger.getLogger(FicheroCifrado.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * encriptamos el texto y lo escribimos en el fichero
     */
    public void cifrarArchivo() {

        try {
            //inicializamos el cifrador
            cifrador = Cipher.getInstance("Rijndael/ECB/PKCS5Padding");
        } catch (NoSuchAlgorithmException | NoSuchPaddingException ex) {
            Logger.getLogger(FicheroCifrado.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            //indicamos el modo de operacion de cifrar
            cifrador.init(Cipher.ENCRYPT_MODE, llave);
            //metemos en un array el texto cifrado
            byte[] textoCifradoBytes = cifrador.doFinal(generarTexto().getBytes());
            //metemos el array en el fichero
            foc.write(textoCifradoBytes);
            //cerramos el glujo
            foc.close();
        } catch (InvalidKeyException | IllegalBlockSizeException | BadPaddingException | IOException ex) {
            Logger.getLogger(FicheroCifrado.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * descifra el archivo
     *
     * @return devuelve un String con el resultado desscifrado
     */
    public String descifrarArchivo() throws UnsupportedEncodingException {

        try {
            //inicializamos el descifrador
            descifrador = Cipher.getInstance("Rijndael/ECB/PKCS5Padding");
        } catch (NoSuchAlgorithmException | NoSuchPaddingException ex) {
            Logger.getLogger(FicheroCifrado.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            //indicamos el modo de operacion de descifrar
            descifrador.init(Cipher.DECRYPT_MODE, llave);

        } catch (InvalidKeyException ex) {
            Logger.getLogger(FicheroCifrado.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            //leemos un byte del archivo 
            bytesLeidos = fic.read(buffer);
            while (bytesLeidos != -1) {
                //pasa texto cifrado al cifrador para que lo descifra 
                //y lo asigna al bufferDescifrado 
                bufferDescifrado = descifrador.update(buffer, 0, bytesLeidos);
                //pasa los datos a un buffer de array (ByteArrayOutputStream)
                bos.write(bufferDescifrado);
                //leemos un byte del archivo
                bytesLeidos = fic.read(buffer);
            }

            fic.close();

        } catch (IOException ex) {
            Logger.getLogger(FicheroCifrado.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            //metemos los datos que falten en el buffer de array
            //y finaliza el desencriptado
            byte[] bytesFinales = descifrador.doFinal();
            bos.write(bytesFinales);

        } catch (IllegalBlockSizeException | BadPaddingException | IOException ex) {
            Logger.getLogger(FicheroCifrado.class.getName()).log(Level.SEVERE, null, ex);
        }

            //devolvemos el array en un String
            return bos.toString("ISO-8859-1");
            
        
    }

    /**
     * Lee el fichero
     *
     * @return devuelve un string con el resultado
     */
    public String leerFichero() {
        String res = "";
        try {

            String linea = br.readLine();
            while (linea != null) {
                res += linea;
                linea = br.readLine();
            }
        } catch (IOException ex) {
            Logger.getLogger(FicheroCifrado.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;

    }

    public FicheroCifrado() {

        ficheroCifrado = new File("fichero.cifrado");

        //Si hay un fichero antiguo, lo borra y crea uno vacio;
        verificarFichero(ficheroCifrado);

        //generamos flujos
        crearFlujos();

        System.out.println("El texto a cifrar es: " + generarTexto());

        //genero clave y la saco por pantalla
        generarClave();
        System.out.println("La clave es: "
                + Base64.getEncoder().encodeToString(llave.getEncoded()));

        //ciframos el archivo
        cifrarArchivo();

        //mostramos el contenido del archivo cifrado
        System.out.println("\nVamos a leer el archivo cifrado: " + leerFichero());

        try {
            //mostramos el contenido del archivo descifrado
            System.out.println("\nVamos a leer el archivo descifrado: " + descifrarArchivo());
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(FicheroCifrado.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
