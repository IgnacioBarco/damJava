
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Usuario
 */
public class Archivo {

    File archivo = null;
    Logger logger;

    public Archivo(String archivo, Logger logger) {

        this.archivo = new File("c:\\datos\\"+archivo);
        this.logger = logger;

    }

    /**
     * verifica si existe
     * @return true si existe
     */
    public boolean existe() {

        if (archivo.exists()) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * muestra el archivo
     * @return un string con el texto del archivo 
     */
    public String mostrarArchivo() {
        FileReader fr = null;
        BufferedReader br = null;
        String contenido = "";
        
        try {
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);

            String linea;
            //Obtenemos el contenido del archivo linea por linea
            while ((linea = br.readLine()) != null) {
                contenido += linea + "\n";
            }

        } catch (Exception e) {
            logger.log(Level.SEVERE, "Fallo al crear el buffer: " + e);

        } finally {
            try {
                br.close();
            } catch (Exception ex) {
                logger.log(Level.SEVERE, "Fallo al cerrar el buffer: " + ex);
            }
            return contenido;

        }

    }
}
