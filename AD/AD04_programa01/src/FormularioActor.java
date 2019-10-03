
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import maps.Actor;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Nacho
 */
public class FormularioActor extends javax.swing.JFrame {

    List<Actor> listaResultadosBusquedasActor;
    VisualizarResultado vr;
    String[] cabeceras = new String[]{"ID", "Nombre", "Apellido", "Fecha"};
    Actor actor, actorMod;
    boolean ver;

    public FormularioActor() {
        initComponents();
        vr = new VisualizarResultado(this, true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jBalta = new javax.swing.JButton();
        jBbaja = new javax.swing.JButton();
        jBmodificar = new javax.swing.JButton();
        jBvarios = new javax.swing.JButton();
        jTextField5 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jTextField7 = new javax.swing.JTextField();
        jTextField8 = new javax.swing.JTextField();
        jBmodificar2 = new javax.swing.JButton();
        jBlistado = new javax.swing.JButton();

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("actor_id");

        jTextField1.setEnabled(false);

        jTextField2.setEnabled(false);

        jTextField3.setEnabled(false);

        jTextField4.setEnabled(false);

        jLabel2.setText("first_name");

        jLabel3.setText("last_name");

        jLabel4.setText("last_update");

        jBalta.setText("alta");
        jBalta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBaltaActionPerformed(evt);
            }
        });

        jBbaja.setText("baja");
        jBbaja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBbajaActionPerformed(evt);
            }
        });

        jBmodificar.setText("modificar");
        jBmodificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBmodificarActionPerformed(evt);
            }
        });

        jBvarios.setText(" ");
        jBvarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBvariosActionPerformed(evt);
            }
        });

        jTextField5.setEnabled(false);

        jTextField6.setEnabled(false);

        jTextField7.setEnabled(false);

        jTextField8.setEnabled(false);

        jBmodificar2.setText("Modificar");
        jBmodificar2.setEnabled(false);
        jBmodificar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBmodificar2ActionPerformed(evt);
            }
        });

        jBlistado.setText("Listado");
        jBlistado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBlistadoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jBlistado, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jBmodificar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jBbaja, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jBalta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jTextField2, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                                        .addComponent(jTextField3))
                                    .addComponent(jTextField4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addComponent(jBvarios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextField5)
                    .addComponent(jTextField6)
                    .addComponent(jTextField7)
                    .addComponent(jTextField8)
                    .addComponent(jBmodificar2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE))
                .addContainerGap(100, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(34, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBalta))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBbaja, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBmodificar))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBvarios)
                    .addComponent(jBmodificar2))
                .addGap(18, 18, 18)
                .addComponent(jBlistado)
                .addGap(70, 70, 70))
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

    private void jBmodificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBmodificarActionPerformed
        setTitle("Modificación de actor");
        visualizarCampos(true);
        jTextField1.setEnabled(true);
        jTextField2.setEnabled(false);
        jTextField3.setEnabled(false);
        jTextField4.setEnabled(false);
        jTextField5.setEnabled(false);
        jTextField6.setEnabled(false);
        jTextField7.setEnabled(false);
        jTextField8.setEnabled(false);
        jBvarios.setText("Buscar");
        jBmodificar2.setEnabled(false);
    }//GEN-LAST:event_jBmodificarActionPerformed

    private void jBaltaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBaltaActionPerformed
        setTitle("Alta de actor");
        visualizarCampos(false);
        jTextField1.setEnabled(true);
        jTextField2.setEnabled(true);
        jTextField3.setEnabled(true);
        jTextField4.setEnabled(false);
        jBvarios.setText("Dar de alta");
    }//GEN-LAST:event_jBaltaActionPerformed

    private void jBbajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBbajaActionPerformed
        setTitle("Baja de actor");
        visualizarCampos(false);
        jTextField1.setEnabled(true);
        jTextField2.setEnabled(false);
        jTextField3.setEnabled(false);
        jTextField4.setEnabled(false);
        jBvarios.setText("Dar de baja");
    }//GEN-LAST:event_jBbajaActionPerformed

    private void jBvariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBvariosActionPerformed

        jBmodificar2.setEnabled(false);

        if (jBvarios.getText().equals("Dar de alta")) {

            ver = false;
            actor = new Actor();
            //verificamos que no haya campos vacios
            if (jTextField1.getText().equals("") ||
                    jTextField2.getText().equals("") ||
                    jTextField3.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "los campos id, nombre o apellido no pueden estar vacios");

            } else {
                //si no ponemos nada en el id, lo coge por defecto
                /*if (jTextField1.getText().equals("")) {
                    actor.setActorId(null);
                    actor.setFirstName(jTextField2.getText());
                    actor.setLastName(jTextField3.getText());
                    actor.setLastUpdate(new Date());
                    //comprobamos que tenemos todos los datos
                    ver = true;
                } else {*/
                String hqlBusquedaActorTodos = "from Actor a where a.actorId=" + jTextField1.getText();
                listaResultadosBusquedasActor = HibernateUtil.realizarConsulta(hqlBusquedaActorTodos);
                if (listaResultadosBusquedasActor.isEmpty()) {
                    actor.setActorId(Short.valueOf(jTextField1.getText()));
                    actor.setFirstName(jTextField2.getText());
                    actor.setLastName(jTextField3.getText());
                    actor.setLastUpdate(new Date());
                    ver = true;
                } else {
                    JOptionPane.showMessageDialog(this, "ese id ya esta siendo usado");
                }
                //}
            }
            if (ver) {
                JOptionPane.showMessageDialog(this, HibernateUtil.insertarActor(actor, "creado"));
            }

        }

        if (jBvarios.getText().equals("Dar de baja")) {
            ver = false;
            actor = new Actor();
            String hqlBusquedaActorTodos = "from Actor a where a.actorId=" + jTextField1.getText();
            listaResultadosBusquedasActor = HibernateUtil.realizarConsulta(hqlBusquedaActorTodos);
            if (listaResultadosBusquedasActor.isEmpty()) {
                JOptionPane.showMessageDialog(this, "no existe ningun actor con ese id");
            } else {
                actor = listaResultadosBusquedasActor.get(0);
                ver = true;

            }

            if (ver) {
                JOptionPane.showMessageDialog(this, HibernateUtil.eliminarActor(actor));

            }

        }

        if (jBvarios.getText().equals("Buscar")) {

            ver = false;
            jBmodificar2.setEnabled(true);
            jTextField5.setEnabled(true);
            jTextField6.setEnabled(true);
            jTextField7.setEnabled(true);
            jTextField8.setEnabled(false);

            actorMod = new Actor();
            String hqlBusquedaActorTodos = "from Actor a where a.actorId=" + jTextField1.getText();
            listaResultadosBusquedasActor = HibernateUtil.realizarConsulta(hqlBusquedaActorTodos);
            if (listaResultadosBusquedasActor.isEmpty()) {
                JOptionPane.showMessageDialog(this, "no existe ningun actor con ese id");
            } else {
                actorMod = listaResultadosBusquedasActor.get(0);
                jTextField2.setText(actorMod.getFirstName());
                jTextField3.setText(actorMod.getLastName());
                jTextField4.setText(actorMod.getLastUpdate().toString());
            }
            
            jTextField5.setText(jTextField1.getText());
            jTextField5.setEnabled(false);
        
        }
    }//GEN-LAST:event_jBvariosActionPerformed

    private void jBlistadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBlistadoActionPerformed
        String hqlBusquedaActorTodos = "from Actor a";
        listaResultadosBusquedasActor = HibernateUtil.realizarConsulta(hqlBusquedaActorTodos);

        if (listaResultadosBusquedasActor.isEmpty()) {
            JOptionPane.showMessageDialog(this, "no hay resultados con esa busqueda");
        } else {
            vr.mostrarTablaActor(cabeceras, listaResultadosBusquedasActor);
        }
    }//GEN-LAST:event_jBlistadoActionPerformed

    private void jBmodificar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBmodificar2ActionPerformed
        ver = false;
        actor = new Actor();
        //verificamos que no haya campos vacios
        if (jTextField6.getText().equals("")
                || jTextField7.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "los campos de nombre o apellido no pueden estar vacios");

        } else {
            actorMod.setFirstName(jTextField6.getText());
            actorMod.setLastName(jTextField7.getText());
            actorMod.setLastUpdate(new Date());
            
            JOptionPane.showMessageDialog(this, HibernateUtil.insertarActor(actorMod,"modificado"));
        }

    }//GEN-LAST:event_jBmodificar2ActionPerformed

    public void visualizarCampos(boolean ocultar) {
        limpiarCampos();
        jTextField5.setVisible(ocultar);
        jTextField6.setVisible(ocultar);
        jTextField7.setVisible(ocultar);
        jTextField8.setVisible(ocultar);
        jBmodificar2.setVisible(ocultar);
    }

    public void limpiarCampos() {
        jTextField1.setText("");
        jTextField2.setText("");
        jTextField3.setText("");
        jTextField4.setText("");
        jTextField5.setText("");
        jTextField6.setText("");
        jTextField7.setText("");
        jTextField8.setText("");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBalta;
    private javax.swing.JButton jBbaja;
    private javax.swing.JButton jBlistado;
    private javax.swing.JButton jBmodificar;
    private javax.swing.JButton jBmodificar2;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jBvarios;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    // End of variables declaration//GEN-END:variables
}