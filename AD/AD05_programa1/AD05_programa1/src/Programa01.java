
import java.sql.SQLException;
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
public class Programa01 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            jfMain jf = new jfMain();
            jf.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(Programa01.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
