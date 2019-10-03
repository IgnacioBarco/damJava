
import java.awt.Desktop;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

public class Programa2 {

    static String url = "jdbc:derby://localhost:1527/sample";
    static String user = "app";
    static String pass = "app";

    static Connection conexion = null;

    static Map<String, Object> parametros;
    static String reportSource = "./report/templates/TareaJasper.jasper";
    static String reportDest = "./report/results/";

    public static void main(String[] args) {

        //nos conectamos a la base de datos
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            conexion = DriverManager.getConnection(url, user, pass);
        } catch (Exception e) {
            System.out.println("Fallo al intentar conectar la base de datos: " + e);
        }

        //creamos los parametros
        parametros = new HashMap<String, Object>();
        parametros.put("titulo", "Informe  Segunda Tarea");
        parametros.put("autor", "Nacho");
        parametros.put("fecha", new Date().toString());

        try {
            //creamos el reporte
            JasperPrint reporte = JasperFillManager.fillReport(reportSource, parametros, conexion);
            //para verlo ejecutariamos
            //JasperViewer.viewReport(reporte);
            //aunque vamos a abrir el pdf despues, por lo que lo dejamos comentado
            
            //generamos ficheros pdf, html y xml
            JasperExportManager.exportReportToPdfFile(reporte, reportDest + "informePDF.pdf");
            JasperExportManager.exportReportToHtmlFile(reporte, reportDest + "informeHTML.html");
            JasperExportManager.exportReportToXmlFile(reporte, reportDest + "informeXML.xml", true);

            //abrimos el fichero pdf
            File pdf = new File(reportDest + "informePDF.pdf");
            Desktop.getDesktop().open(pdf);

        } catch (Exception e) {
            System.out.println("Fallo al crear el reporte: " + e);
        }

        //cerramos la conexion
        try {
            conexion.close();
        } catch (Exception e) {
            System.out.println("Fallo al cerra la conexión: " + e);
        }
    }

}
