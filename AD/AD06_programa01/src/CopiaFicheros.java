
import static com.xmlmind.util.FileUtil.copyFile;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Administrador
 */
public class CopiaFicheros {

    String dirOrigen = "resources\\ColeccionNotas";
    String dirDestino = "c:\\tareaxmlIBC";
    String dirAl = "\\Alumnos";
    String dirAs = "\\Asignaturas";
    String dirM = "\\Matriculas";

    File ficheroOrigen;
    File ficheroDestino;
    File carpeta;
    File cAlumnos, cAsignaturas, cMatriculas;
    File[] archivos, archivos2;
    
    String res ="";

    public CopiaFicheros() {

        try {
            File carpeta = new File(dirDestino);
            File carpetaOrigen = new File(dirOrigen);
            File cAlumnos = new File(dirDestino + dirAl );
            File cAsignaturas = new File(dirDestino + dirAs);
            File cMatriculas = new File(dirDestino + dirM);
            File cOAlumnos = new File(dirOrigen + dirAl);
            File cOAsignaturas = new File(dirOrigen + dirAs);
            File cOMatriculas = new File(dirOrigen + dirM);

            if (!carpeta.exists()) {
                carpeta.mkdir();
                if (!cAlumnos.exists()) {
                    cAlumnos.mkdir();

                }
                if (!cAsignaturas.exists()) {
                    cAsignaturas.mkdir();
                }
                if (!cMatriculas.exists()) {
                    cMatriculas.mkdir();
                }
            } else {
                if (!cAlumnos.exists()) {
                    cAlumnos.mkdir();
                }
                if (!cAsignaturas.exists()) {
                    cAsignaturas.mkdir();
                }
                if (!cMatriculas.exists()) {
                    cMatriculas.mkdir();
                }
            }

            copiaFicherosXML(cOAlumnos, cAlumnos, "c:\\tareaxmlIBC\\Alumnos\\");
            copiaFicherosXML(cOAsignaturas, cAsignaturas, "c:\\tareaxmlIBC\\Asignaturas\\");
            copiaFicherosXML(cOMatriculas, cMatriculas, "c:\\tareaxmlIBC\\Matriculas\\");
            

            res= "Se ha realizado la copia de seguridad";
            
        } catch (Exception ex) {
            res="fallo al realizar la copia: " + ex;
        }

    }

    public void copiaFicherosXML(File carpetaO, File carpetaDestino, String rutafinal) throws IOException {

        File[] listado = carpetaO.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                if (name.endsWith(".xml")) {
                    return true;

                }
                return false;

            }
        });
        for (File fich : listado) {
            File fichDest = new File(rutafinal + fich.getName());
            copyFile(fich, fichDest);
        }

    }

}
