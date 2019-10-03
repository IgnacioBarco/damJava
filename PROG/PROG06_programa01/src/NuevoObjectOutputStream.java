
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;


/**
 *
 * @author Nacho
 */

//utilizamos esta clase para sobreescribir el metodo writeStreamHeader
//y asi que no nos imprima varias cabeceras dentro del fichero serializado
//y podamos leerlo de una sola vez
public class NuevoObjectOutputStream extends ObjectOutputStream {
    
    public NuevoObjectOutputStream(FileOutputStream nuevo) throws IOException{
        super(nuevo);
    }
        protected void writeStreamHeader() throws IOException
        {
            //vacio para que no escriba nada
        }    
    
    
    
    
}
