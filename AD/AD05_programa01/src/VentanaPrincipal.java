
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Administrador
 */
public class VentanaPrincipal extends javax.swing.JFrame {

    int contador = 0;
    OperacionesBD operacion;
    String alum, asig, notS, idAsigS;

    public VentanaPrincipal() {
        initComponents();
        operacion = new OperacionesBD();

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
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton6 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("Crear BBDD");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Consultar notas");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Visualizar alumnos");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Insertar datos");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("Eliminar asignatura");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setEnabled(false);
        jScrollPane1.setViewportView(jTextArea1);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        jTextField1.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jTextField1.setEnabled(false);

        jButton6.setText(" ");
        jButton6.setEnabled(false);
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton5))
                    .addComponent(jScrollPane1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton3)
                    .addComponent(jButton4)
                    .addComponent(jButton5)
                    .addComponent(jButton2))
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextField1)
                        .addComponent(jButton6))
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 227, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        contador = 0;
        jLabel1.setText("Alumno");
        jTextField1.setEnabled(true);
        jButton6.setText("Aceptar");
        jButton6.setEnabled(true);

    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        contador = 3;
        jLabel1.setText("Asignatura");
        jTextField1.setEnabled(true);
        jButton6.setText("Eliminar");
        jButton6.setEnabled(true);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        jLabel1.setText("");
        jTextField1.setEnabled(false);
        jButton6.setText(" ");
        jButton6.setEnabled(false);

        //borramos todo lo que esta creado
        operacion.borrarDatosAlumnos();
        operacion.borrarDatosAsignaturas();
        operacion.borrarDatosNotas();

        String res = "";

        Alumno alumno1 = new Alumno(1, "AAAA", "Madrid");
        Alumno alumno2 = new Alumno(2, "BBBB", "Talavera");
        Alumno alumno3 = new Alumno(3, "CCCC", "Sevilla");
        Alumno alumno4 = new Alumno(4, "DDDD", "Barcelona");
        Alumno alumno5 = new Alumno(5, "EEEE", "Madrid");
        Alumno alumno6 = new Alumno(6, "FFFF", "Caceres");
        Alumno alumno7 = new Alumno(7, "GGGG", "Talavera");

        res = operacion.almacenarAlumno("Alumno1", alumno1) + "\n";
        res = res + operacion.almacenarAlumno("Alumno2", alumno2) + "\n";
        res = res + operacion.almacenarAlumno("Alumno3", alumno3) + "\n";
        res = res + operacion.almacenarAlumno("Alumno4", alumno4) + "\n";
        res = res + operacion.almacenarAlumno("Alumno5", alumno5) + "\n";
        res = res + operacion.almacenarAlumno("Alumno6", alumno6) + "\n";
        res = res + operacion.almacenarAlumno("Alumno7", alumno7) + "\n";

        res = res + "---------------------\n";

        Asignatura asignatura1 = new Asignatura(1, "Programacion", 100);
        Asignatura asignatura2 = new Asignatura(2, "AccesoDatos", 200);
        Asignatura asignatura3 = new Asignatura(3, "BaseDatos", 300);
        Asignatura asignatura4 = new Asignatura(4, "Entornos", 400);
        Asignatura asignatura5 = new Asignatura(5, "PSP", 500);

        res = res + operacion.almacenarAsignatura("Asignatura1", asignatura1) + "\n";
        res = res + operacion.almacenarAsignatura("Asignatura2", asignatura2) + "\n";
        res = res + operacion.almacenarAsignatura("Asignatura3", asignatura3) + "\n";
        res = res + operacion.almacenarAsignatura("Asignatura4", asignatura4) + "\n";
        res = res + operacion.almacenarAsignatura("Asignatura5", asignatura5) + "\n";

        res = res + "---------------------\n";

        Nota nota1 = new Nota();
        nota1.setIdNota(1);
        nota1.setAlumno(alumno1);
        nota1.setAsignatura(asignatura1);
        nota1.setNota(10);
        res = res + operacion.almacenarNota("nota1", nota1) + "\n";

        Nota nota2 = new Nota();
        nota2.setIdNota(2);
        nota2.setAlumno(alumno1);
        nota2.setAsignatura(asignatura2);
        nota2.setNota(10);
        res = res + operacion.almacenarNota("nota2", nota2) + "\n";

        Nota nota3 = new Nota();
        nota3.setIdNota(3);
        nota3.setAlumno(alumno1);
        nota3.setAsignatura(asignatura3);
        nota3.setNota(10);
        res = res + operacion.almacenarNota("nota3", nota3) + "\n";

        Nota nota4 = new Nota();
        nota4.setIdNota(4);
        nota4.setAlumno(alumno2);
        nota4.setAsignatura(asignatura3);
        nota4.setNota(8);
        res = res + operacion.almacenarNota("nota4", nota4) + "\n";

        Nota nota5 = new Nota();
        nota5.setIdNota(5);
        nota5.setAlumno(alumno2);
        nota5.setAsignatura(asignatura4);
        nota5.setNota(9);
        res = res + operacion.almacenarNota("nota5", nota5) + "\n";

        Nota nota6 = new Nota();
        nota6.setIdNota(6);
        nota6.setAlumno(alumno2);
        nota6.setAsignatura(asignatura2);
        nota6.setNota(10);
        res = res + operacion.almacenarNota("nota6", nota6) + "\n";

        Nota nota7 = new Nota();
        nota7.setIdNota(7);
        nota7.setAlumno(alumno3);
        nota7.setAsignatura(asignatura1);
        nota7.setNota(4);
        res = res + operacion.almacenarNota("nota7", nota7) + "\n";

        Nota nota8 = new Nota();
        nota8.setIdNota(8);
        nota8.setAlumno(alumno3);
        nota8.setAsignatura(asignatura2);
        nota8.setNota(5);
        res = res + operacion.almacenarNota("nota8", nota8) + "\n";

        Nota nota9 = new Nota();
        nota9.setIdNota(9);
        nota9.setAlumno(alumno3);
        nota9.setAsignatura(asignatura3);
        nota9.setNota(6);
        res = res + operacion.almacenarNota("nota9", nota9) + "\n";

        Nota nota10 = new Nota();
        nota10.setIdNota(10);
        nota10.setAlumno(alumno4);
        nota10.setAsignatura(asignatura4);
        nota10.setNota(2);
        res = res + operacion.almacenarNota("nota10", nota10) + "\n";

        Nota nota11 = new Nota();
        nota11.setIdNota(11);
        nota11.setAlumno(alumno4);
        nota11.setAsignatura(asignatura2);
        nota11.setNota(3);
        res = res + operacion.almacenarNota("nota11", nota11) + "\n";

        Nota nota12 = new Nota();
        nota12.setIdNota(12);
        nota12.setAlumno(alumno4);
        nota12.setAsignatura(asignatura1);
        nota12.setNota(4);
        res = res + operacion.almacenarNota("nota12", nota12) + "\n";

        Nota nota13 = new Nota();
        nota13.setIdNota(13);
        nota13.setAlumno(alumno5);
        nota13.setAsignatura(asignatura1);
        nota13.setNota(4);
        res = res + operacion.almacenarNota("nota13", nota13) + "\n";

        Nota nota14 = new Nota();
        nota14.setIdNota(14);
        nota14.setAlumno(alumno5);
        nota14.setAsignatura(asignatura2);
        nota14.setNota(8);
        res = res + operacion.almacenarNota("nota14", nota14) + "\n";

        Nota nota15 = new Nota();
        nota15.setIdNota(15);
        nota15.setAlumno(alumno5);
        nota15.setAsignatura(asignatura3);
        nota15.setNota(6);
        res = res + operacion.almacenarNota("nota15", nota15) + "\n";

        Nota nota16 = new Nota();
        nota16.setIdNota(16);
        nota16.setAlumno(alumno6);
        nota16.setAsignatura(asignatura3);
        nota16.setNota(5);
        res = res + operacion.almacenarNota("nota16", nota16) + "\n";

        Nota nota17 = new Nota();
        nota17.setIdNota(17);
        nota17.setAlumno(alumno6);
        nota17.setAsignatura(asignatura4);
        nota17.setNota(8);
        res = res + operacion.almacenarNota("nota17", nota17) + "\n";

        Nota nota18 = new Nota();
        nota18.setIdNota(18);
        nota18.setAlumno(alumno6);
        nota18.setAsignatura(asignatura2);
        nota18.setNota(9);
        res = res + operacion.almacenarNota("nota18", nota18) + "\n";

        jTextArea1.setText(res);

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        jLabel1.setText("");
        jTextField1.setEnabled(false);
        jButton6.setText(" ");
        jButton6.setEnabled(false);

        String res = "";
        jTextArea1.setText(res);
        jTextArea1.setText(operacion.consultarNotas());

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        contador = 4;
        jLabel1.setText("Id");
        jTextField1.setEnabled(true);
        jButton6.setText("Aceptar");
        jButton6.setEnabled(true);

    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed

        //si esta marcado el boton insertar datos
        if (contador == 2) {
            notS = jTextField1.getText();
            jTextField1.setText("");
            jTextField1.setEnabled(false);
            jButton6.setEnabled(false);

            System.out.println(alum + " " + asig + " " + notS);
            jTextArea1.setText(operacion.InsertarNota(alum, asig, notS));

        }
        if (contador == 1) {
            asig = jTextField1.getText();
            jTextField1.setText("");
            jLabel1.setText("Nota");
            jTextField1.setEnabled(true);
            contador = 2;
        }
        if (contador == 0) {
            alum = jTextField1.getText();
            jTextField1.setText("");
            jLabel1.setText("Asignatura");
            jTextField1.setEnabled(true);
            contador = 1;
        }

        //si esta marcado el boton eliminar asignatura
        if (contador == 3) {
            idAsigS = jTextField1.getText();
            jButton6.setEnabled(false);
            System.out.println(idAsigS);

            jTextArea1.setText(operacion.borrarDatosAsignaturasId(idAsigS));
        }

        //si esta marcado consultar alumno
        if (contador == 4) {
            if (jTextField1.equals("")) {

            } else {
                jTextArea1.setText(operacion.consultarAlumno(Integer.valueOf(jTextField1.getText())));
            }

        }

    }//GEN-LAST:event_jButton6ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
