
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Nacho
 */
public class VisualizarDepartamentos extends javax.swing.JDialog {

    String[] cabecera = new String[]{"DEPT-NO", "NOMBRE-DEPAR", "NUMERO-EMPLEADOS", "SALARIO-MEDIO", "NÚMERO-OFICIOS"};
    DefaultTableModel modelo;
    String[] fila;
    String resultadoString;

    public VisualizarDepartamentos(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        modelo = new DefaultTableModel();
        modelo.setColumnIdentifiers(cabecera);

        initComponents();
        jTable1.setEnabled(false);
    }

    public void actualizarDatos(ResultSet resultado) {
        
        modelo = new DefaultTableModel();
        modelo.setColumnIdentifiers(cabecera);
        jTable1.setModel(modelo);
        jTable1.setEnabled(false);
        
        try {
            while (resultado.next()) {
                resultadoString = "";
                resultadoString = resultadoString + resultado.getString(1) + ",";
                resultadoString = resultadoString + resultado.getString(2) + ",";
                resultadoString = resultadoString + resultado.getString(3) + ",";
                if (resultado.getObject(4) == null) {
                    resultadoString = resultadoString + "0,";
                } else {
                    resultadoString = resultadoString + resultado.getString(4) + ",";
                }

                resultadoString = resultadoString + resultado.getString(5);
                fila = resultadoString.split(",");
                modelo.addRow(fila);
            }
        } catch (SQLException ex) {
            Logger.getLogger(VisualizarEmpleados.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jTable1.setModel(modelo);
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 761, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
