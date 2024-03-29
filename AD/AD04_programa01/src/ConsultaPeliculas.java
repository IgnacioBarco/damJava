
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import maps.Actor;
import maps.Film;
import org.hibernate.Query;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Nacho
 */
public class ConsultaPeliculas extends javax.swing.JFrame {

    String busquedaPulsada = "todo";
    List<Film> listaResultadoBusquedasFilm;
   
    VisualizarResultado vr;
    String cabeceras[];
    
    public ConsultaPeliculas() {
        initComponents();
        limpiarCampos();
        vr = new VisualizarResultado(this, true);
        

    }

    public void limpiarCampos() {
        jTextField1.setText("");
        jTextField2.setText("");
        jTextField3.setText("");
        jTextField4.setText("");

    }

    public void habilitarCampos(int a) {
        if (a == 1) {
            limpiarCampos();
            jTextField1.setEnabled(true);
            jTextField2.setEnabled(false);
            jTextField3.setEnabled(false);
            jTextField4.setEnabled(false);
            busquedaPulsada = "titulo";
        }
        if (a == 2) {
            limpiarCampos();
            jTextField1.setEnabled(false);
            jTextField2.setEnabled(true);
            jTextField3.setEnabled(false);
            jTextField4.setEnabled(false);
            busquedaPulsada = "descripcion";
        }
        if (a == 3) {
            limpiarCampos();
            jTextField1.setEnabled(false);
            jTextField2.setEnabled(false);
            jTextField3.setEnabled(true);
            jTextField4.setEnabled(false);
            busquedaPulsada = "caracteristicas";
        }
        if (a == 4) {
            limpiarCampos();
            jTextField1.setEnabled(false);
            jTextField2.setEnabled(false);
            jTextField3.setEnabled(false);
            jTextField4.setEnabled(false);
            busquedaPulsada = "autor";
        }
        if (a == 5) {
            limpiarCampos();
            jTextField1.setEnabled(true);
            jTextField2.setEnabled(true);
            jTextField3.setEnabled(true);
            jTextField4.setEnabled(false);
            busquedaPulsada = "todo";
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        titulo = new javax.swing.JButton();
        descripcion = new javax.swing.JButton();
        caracteristicas = new javax.swing.JButton();
        actor = new javax.swing.JButton();
        todo = new javax.swing.JButton();
        Busqueda = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Consulta de peliculas");

        titulo.setText("Titulo");
        titulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tituloActionPerformed(evt);
            }
        });

        descripcion.setText("Descripcion");
        descripcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                descripcionActionPerformed(evt);
            }
        });

        caracteristicas.setText("Caracteristicas");
        caracteristicas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                caracteristicasActionPerformed(evt);
            }
        });

        actor.setText("Actor");
        actor.setToolTipText("Boton desactivado ya que no me funciona la busqueda");
        actor.setEnabled(false);
        actor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actorActionPerformed(evt);
            }
        });

        todo.setText("Todo");
        todo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                todoActionPerformed(evt);
            }
        });

        Busqueda.setText("Buscar");
        Busqueda.setToolTipText("Si no se introduce ningun dato buscara todas las posibilidades");
        Busqueda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BusquedaActionPerformed(evt);
            }
        });

        jTextField1.setEnabled(false);

        jTextField2.setEnabled(false);

        jTextField3.setEnabled(false);

        jTextField4.setEnabled(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Busqueda, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(caracteristicas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(titulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(descripcion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(actor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTextField4)
                            .addComponent(jTextField1)
                            .addComponent(jTextField3))))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(todo, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(51, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(todo)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(titulo)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(descripcion)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(caracteristicas)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(actor)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(Busqueda)
                .addContainerGap(61, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tituloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tituloActionPerformed
        habilitarCampos(1);
    }//GEN-LAST:event_tituloActionPerformed

    private void descripcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_descripcionActionPerformed
        habilitarCampos(2);
    }//GEN-LAST:event_descripcionActionPerformed

    private void caracteristicasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_caracteristicasActionPerformed
        habilitarCampos(3);
    }//GEN-LAST:event_caracteristicasActionPerformed

    private void actorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actorActionPerformed
        habilitarCampos(4);
    }//GEN-LAST:event_actorActionPerformed

    private void todoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_todoActionPerformed
        habilitarCampos(5);
    }//GEN-LAST:event_todoActionPerformed

    private void BusquedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BusquedaActionPerformed
        
        String mostrarResultado = "";
        cabeceras = new String[]{"Titulo","Descripcion","Caracteristicas"};
        
        if (busquedaPulsada.equals("titulo")){
            System.out.println("1");
            String hqlBusquedaTitulo = "from Film f where f.title like '%"+jTextField1.getText()+"%'";
            listaResultadoBusquedasFilm = HibernateUtil.realizarConsulta(hqlBusquedaTitulo);
            
            
            
            
        }
        if (busquedaPulsada.equals("descripcion")){
            System.out.println("2");
            String hqlBusquedaDescripcion = "from Film f where f.description like '%"+jTextField2.getText()+"%'";
            listaResultadoBusquedasFilm = HibernateUtil.realizarConsulta(hqlBusquedaDescripcion);
            for(Film pelicula : listaResultadoBusquedasFilm){
                mostrarResultado=mostrarResultado+pelicula.getTitle()+"\n";
            }
        }
        if (busquedaPulsada.equals("caracteristicas")){
            System.out.println("3");
            String hqlBusquedaCaracteristicas = "from Film f where f.specialFeatures like '%"+jTextField3.getText()+"%'";
            listaResultadoBusquedasFilm = HibernateUtil.realizarConsulta(hqlBusquedaCaracteristicas);
            for(Film pelicula : listaResultadoBusquedasFilm){
                mostrarResultado=mostrarResultado+pelicula.getTitle()+"\n";
            }
        }
        
        //esta es la parte de busqueda por autor
        //no se que le pasa, ya que en una busqueda HQL si funciona
        //pero aqui me da error: java.lang.String cannot be cast to maps.Film
        /*
        if (busquedaPulsada.equals("autor")){
            System.out.println("4");
            String hqlBusquedaAutor = "select f.title from Film f "    
                +"inner join f.filmActors fa where fa.actor.firstName like '%"+jTextField4.getText()+"%'";
            listaResultadoBusquedasFilm = HibernateUtil.realizarConsulta(hqlBusquedaAutor);
        }  */
        
        
        if (busquedaPulsada.equals("todo")){
            System.out.println("5");
            String hqlBusquedaTitulo = "from Film f where "
                    + "f.title like '%"+jTextField1.getText()+"%'"
                    + " AND f.description like '%"+jTextField2.getText()+"%'"
                    + " AND f.specialFeatures like '%"+jTextField3.getText()+"%'";
            listaResultadoBusquedasFilm = HibernateUtil.realizarConsulta(hqlBusquedaTitulo);
        }
        
        if (listaResultadoBusquedasFilm.isEmpty()){
                JOptionPane.showMessageDialog(this, "no hay resultados con esa busqueda");
            } else {
                vr.mostrarTablaFilm(cabeceras, listaResultadoBusquedasFilm);
        }
    }//GEN-LAST:event_BusquedaActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Busqueda;
    private javax.swing.JButton actor;
    private javax.swing.JButton caracteristicas;
    private javax.swing.JButton descripcion;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JButton titulo;
    private javax.swing.JButton todo;
    // End of variables declaration//GEN-END:variables
}
