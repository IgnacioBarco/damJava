
import java.util.List;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import maps.Actor;
import maps.Film;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Nacho
 */
public class VisualizarResultado extends javax.swing.JDialog {

    String[] cabecera; // ejemplo: new String[];{"aaaa", "bbbb", "cccc"}; 
    DefaultTableModel modelo;
    List<Film> listaFilm;
    List<Actor> listaActor;
    String linea;
    String[] campos;
    
    
    public VisualizarResultado(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        cabecera = new String[]{};
        modelo = new DefaultTableModel();
        modelo.setColumnIdentifiers(cabecera);
        
        initComponents();
        jTable1.setEnabled(false);
    }

    public void mostrarTablaFilm(String[] cabeceras, List<Film> lista){
        setTitle("Busqueda de Pelicula");
        listaFilm = lista;
        cabecera = cabeceras;
        modelo = new DefaultTableModel();
        modelo.setColumnIdentifiers(cabecera);
        jTable1.setModel(modelo);
        jTable1.setEnabled(false);
        
        for(Film pelicula : listaFilm){
            
                linea = 
                    pelicula.getTitle()+","+
                    pelicula.getDescription()+","+
                    pelicula.getSpecialFeatures();
                campos = linea.split(",");
                modelo.addRow(campos);
            }
        
        setVisible(true);
    }
    
    
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
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
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 528, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 438, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
