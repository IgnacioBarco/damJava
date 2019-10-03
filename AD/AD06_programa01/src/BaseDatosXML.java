
import com.qizx.api.DataModelException;
import com.qizx.api.Library;
import com.qizx.api.LibraryException;
import com.qizx.api.LibraryManager;
import com.qizx.api.QizxException;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Administrador
 */
public class BaseDatosXML {

    Library library;
    LibraryManager libraryManager;
    String nombreBBDD = "C://tareaxmlIBC" ;
    public BaseDatosXML() {

        try {
            //Abre una conexion a la BD XML de nombre  bdNombre
            library = libraryManager.openLibrary(nombreBBDD);
        } catch (DataModelException ex) {
            Logger.getLogger(BaseDatosXML.class.getName()).log(Level.SEVERE, null, ex);
        }
        //Si no se ha abierto la BD (porque no existe)
        if (library == null) {
            System.out.println("Creando BD XML '" + nombreBBDD + "'...");
            try {
                //Crea la BD XML
                libraryManager.createLibrary(nombreBBDD, null);
            } catch (LibraryException ex) {
                Logger.getLogger(BaseDatosXML.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                //Abre una conexion a la BD creada
                library = libraryManager.openLibrary(nombreBBDD);
            } catch (DataModelException ex) {
                Logger.getLogger(BaseDatosXML.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

/*    
//Metodo que obtiene la conexion a una bd XML
    private static Library obtenerBD(LibraryManager bdManager, String bdNombre)
            throws QizxException {
        //Abre una conexion a la BD XML de nombre  bdNombre
        Library bd = bdManager.openLibrary(bdNombre);
        //Si no se ha abierto la BD (porque no existe)
        if (bd == null) {
            System.out.println("Creando BD XML '" + bdNombre + "'...");
            //Crea la BD XML
            bdManager.createLibrary(bdNombre, null);
            //Abre una conexion a la BD creada
            bd = bdManager.openLibrary(bdNombre);
        }
        //devuelve la conexion
        return bd;
    }
*/
    
}
