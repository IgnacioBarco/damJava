
import java.awt.Desktop;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Nacho
 */
public class Programa02 {

    static String url = "jdbc:derby://localhost:1527/sample";
    static String user = "app";
    static String password = "app";
    
    static Connection conexion = null;
    
    static Map<String,Object> parametros;
    static String reportSource = "./reportes/templates/informe.jasper"; 
    static String reportDest = "./reportes/";
    
    
    public static void main(String[] args) {
        
        //abrimos la conexion a la base de datos
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            conexion = DriverManager.getConnection(url, user, password);
        }catch (ClassNotFoundException ex) {
            Logger.getLogger(Programa02.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Programa02.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //Cargamos los parametros del informe en una tabla Hash
        parametros = new HashMap<String,Object>();
        parametros.put("Titulo","Resumen de ventas de los clientes");
        parametros.put("Autor","Nacho");
        parametros.put("Fecha",new Date().toString());
        
        try
        {
            //si lo queremos hacer con la plantilla, con el .jasper
            // JasperReport jasperReport= JasperCompileManager.compileReport(xxx.jasper);
            //JasperPrint print = JasperFillManager.fillReport(jasperReport, parametros, conexion);
            
            //Generamos el informe en memoria
            JasperPrint print = JasperFillManager.fillReport(reportSource, parametros, conexion);
            //parar verlo
            //JasperViewer.viewReport(print);

            // Exporta el informe a PDF  
            JasperExportManager.exportReportToPdfFile(print, "informe.pdf");

            //Abre el archivo PDF generado
            File path = new File ("informe.pdf");
            Desktop.getDesktop().open(path);
            
            // Exportar a Html
            JasperExportManager.exportReportToHtmlFile(print, reportDest+"informe.html");
            // Exportar a XML
            JasperExportManager.exportReportToXmlFile(print, reportDest+"informe.xml", true);
        }

        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,e.toString(),"Error",JOptionPane.WARNING_MESSAGE);
        }
        
        //cerramos la conexion
        try {
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(Programa02.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
    
    
    
    
    
            
    
}
