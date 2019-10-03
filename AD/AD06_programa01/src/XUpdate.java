
import com.qizx.api.ItemSequence;
import java.io.IOException;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import com.qizx.api.QizxException;
import com.qizx.api.Message;
import com.qizx.api.CompilationException;
import com.qizx.api.Configuration;
import com.qizx.api.Expression;
import com.qizx.api.LibraryMember;
import com.qizx.api.Library;
import com.qizx.api.LibraryManager;

/**
 * ****************************************************************************
 * clase para ejecutar scripts de actualización XQuery
 *
 * @author IMCG
 */
public class XUpdate {

    private String resultado = "";

//ruta del Grupo de BD
    private static String directorioGrupoRoot = "c:\\tareaxmlIBC";
    //Base de Datos
    private static String bdNombre = "ColeccionNotas";
    //fichero con script de actualización
    private String ficheroScriptRoot = "";
//          "C:\\BDCursillosXML\\cursillos_query\\12update_insert.xq";
//     "C:\\BDCursillosXML\\cursillos_query\\13update_delete.xq";
//   "C:\\BDCursillosXML\\cursillos_query\\14update_replace_node_value.xq";
//   "C:\\BDCursillosXML\\cursillos_query\\15update_rename_varios_nodos.xq";

    /**
     * **************************************************************************
     *
     * @param args
     * @throws IOException
     * @throws QizxException
     */
    public void consulta()
            throws IOException, QizxException {

        //variables locales
        LibraryMember queryRoot = null;
        File scriptFile;
        //crea el objeto file apuntando a esa ruta
        File directorioGrupo = new File(directorioGrupoRoot);

        // Conexión o apertura del gestor del grupo de BD
        LibraryManager bdManager
                = Configuration.openLibraryGroup(directorioGrupo);

        //abre conexión a la BD
        Library bd = bdManager.openLibrary(bdNombre);

        try {
            scriptFile = new File(getFicheroScriptRoot());

            //carga el contenido del fichero de script en una cadena
            String script = cargarScript(scriptFile);
            System.out.println("---\n" + script + "\n---");

            //compila la consulta de actualización
            Expression expr = compilaExpression(bd, script, queryRoot);

            //evalúa la consulta compilada
            evaluaExpression(expr, bd);
        } finally {
            cerrar(bd, bdManager);
        }
    }

    /**
     * **************************************************************************
     * Compila la consulta
     *
     * @param bd: base de datos
     * @param script: script con consulta de actualización
     * @param queryRoot: camino localización consulta
     * @return expression compilada
     * @throws IOException
     * @throws QizxException
     */
    private static Expression compilaExpression(Library bd,
            String script,
            LibraryMember queryRoot)
            throws IOException, QizxException {
        Expression expr;
        try {
            expr = bd.compileExpression(script);
        } catch (CompilationException e) {
            Message[] messages = e.getMessages();
            for (int i = 0; i < messages.length; ++i) {
                System.out.println(messages[i].toString());
            }

            throw e;
        }

        if (queryRoot != null) {
            expr.bindImplicitCollection(queryRoot);
        }
        return expr;
    }

    /**
     * **************************************************************************
     * Evalúa la expresión compilada
     *
     * @param expr: expresión compilada
     * @param library: base de datos
     * @throws QizxException
     */
    private static void evaluaExpression(Expression expr, Library library)
            throws QizxException {
        /*ItemSequence results =*/
        ItemSequence evaluate = expr.evaluate();
        // confirmar cambios en BD
        library.commit();
    }

    /**
     * **************************************************************************
     * Cierra la base d edatos y el su grupo
     *
     * @param bd
     * @param bdManager
     * @throws QizxException
     */
    private static void cerrar(Library bd, LibraryManager bdManager)
            throws QizxException {
        bd.close();
        bdManager.closeAllLibraries(10000 /*ms*/);
    }

    /**
     * **************************************************************************
     * Carga el script de consulta de actualización en una cadena
     *
     * @param file: ruta del script
     * @return: cadena con consulta de actualización
     * @throws IOException
     */
    private static String cargarScript(File file)
            throws IOException {
        InputStreamReader in
                = new InputStreamReader(new FileInputStream(file), "UTF-8");

        StringBuilder build = new StringBuilder();
        char[] chars = new char[8192];
        int count;

        try {
            while ((count = in.read(chars, 0, chars.length)) != -1) {
                if (count > 0) {
                    build.append(chars, 0, count);
                }
            }
        } finally {
            in.close();
        }
        return build.toString();
    }

    /**
     * @return the resultado
     */
    public String getResultado() {
        return resultado;
    }

    /**
     * @param resultado the resultado to set
     */
    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    /**
     * @return the ficheroScriptRoot
     */
    public String getFicheroScriptRoot() {
        return ficheroScriptRoot;
    }

    /**
     * @param aFicheroScriptRoot the ficheroScriptRoot to set
     */
    public void setFicheroScriptRoot(String aFicheroScriptRoot) {
        ficheroScriptRoot = aFicheroScriptRoot;
    }
}
