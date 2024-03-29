
import generated.DatosempledepartType;
import java.io.IOException;
import java.math.BigDecimal;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import generated.*;
import java.io.File;
import java.math.BigInteger;
import java.nio.file.Files;
import static java.nio.file.StandardCopyOption.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor
 */
/**
 *
 * @author Nacho
 */
public class VentanaPrincipal extends javax.swing.JFrame {

    File xml, xmlOriginal;
    
    Empleados empleados;
    Empleados.Emple emple1, emple2, emple3, empleNuevo;
    DatosempledepartType datostype;
    JAXBContext contexto;
    JAXBElement<DatosempledepartType> elemento;
    ObjectFactory mixml;
    Marshaller m;

    DatosempledepartType datosempledeparttype;
    static Departamento departamento;

    ModificaDepartamento mod;
    AnadirEmpleado ae;
    EliminarEmpleado ee;
    BigInteger cod;
    Boolean ver;

    /**
     * Creates new form VentanaPrincipal
     */
    public VentanaPrincipal() {
        initComponents();

        xml = new File("datosXML.xml");
        xmlOriginal = new File("datosXMLOriginal.xml");

        mod = new ModificaDepartamento(this, true);
        ae = new AnadirEmpleado(this, true);
        ee = new EliminarEmpleado(this, true);

        crearXMLOriginal();
        
        
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Tarea2 Apartado1");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setPreferredSize(new java.awt.Dimension(500, 250));
        setResizable(false);

        jButton1.setText("Restablecer XML inicial");
        jButton1.setToolTipText("Restablece el xml original, que tiene como departamento AccesoDatos y 3 empleados");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Modifica Departamento");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Añadir empleado");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Eliminar Empleado");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("Visualizar los datos");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(170, 170, 170)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(169, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addGap(18, 18, 18)
                .addComponent(jButton2)
                .addGap(18, 18, 18)
                .addComponent(jButton3)
                .addGap(17, 17, 17)
                .addComponent(jButton4)
                .addGap(19, 19, 19)
                .addComponent(jButton5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        try {

            Files.copy(xmlOriginal.toPath(), xml.toPath(), REPLACE_EXISTING);
            JOptionPane.showMessageDialog(this,"Fichero restaurado");
        } catch (IOException ex) {
            System.out.println("Error al intentar restaurar los archivos: " + ex);
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        
        mod.rellenarDatos(elemento);
        mod.setVisible(true);

        departamento.setLocalidad(mod.getLoc());
        departamento.setPresupuesto(BigDecimal.valueOf(Double.valueOf(mod.getPre())));

        JOptionPane.showMessageDialog(this, "departamento modificado");
        actualizarDatosXML();
        actualizarFicheroXML(xml);
        


    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
       
        try {
            m.marshal(elemento, System.out);
        } catch (JAXBException ex) {
            Logger.getLogger(VentanaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
     
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        ae.setVisible(true);
        
        empleNuevo = new Empleados.Emple();
        
        empleNuevo.setApellido(ae.getApel());
        empleNuevo.setEmpno(ae.getCod());
        empleNuevo.setOficio(ae.getOfic());
        empleNuevo.setSalario(ae.getSal());
        
        if(empleados.getEmple().add(empleNuevo)){
            JOptionPane.showMessageDialog(this, "usuario creado");
        }
        
        actualizarDatosXML();
        actualizarFicheroXML(xml);
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        ver=false;
        ee.setVisible(true);
        cod = ee.getCod();
        
        for (Empleados.Emple obj : empleados.getEmple()){
            if (obj.getEmpno()==cod){
                empleados.getEmple().remove(obj);
                JOptionPane.showMessageDialog(this, "empleado borrado");
                actualizarFicheroXML(xml);
                ver = true;
                return;
            } 
        }
        
        if (ver==false){
            JOptionPane.showMessageDialog(this, "No hay usuario con ese codigo");
        }
        
    }//GEN-LAST:event_jButton4ActionPerformed

    public void crearXMLOriginal() {

        datostype = new DatosempledepartType();
        departamento = new Departamento();
        empleados = new Empleados();
        emple1 = new Empleados.Emple();
        emple2 = new Empleados.Emple();
        emple3 = new Empleados.Emple();
        
        
        departamento.setCodigodep(BigInteger.valueOf(1));
        departamento.setLocalidad("Talavera");
        departamento.setNombredep("AccesoDatos");
        departamento.setPresupuesto(BigDecimal.valueOf(100000));

        emple1.setApellido("aaaa");
        emple1.setEmpno(BigInteger.valueOf(1));
        emple1.setOficio("AAAA");
        emple1.setSalario(10000);
        empleados.getEmple().add(emple1);

        emple2.setApellido("bbbb");
        emple2.setEmpno(BigInteger.valueOf(2));
        emple2.setOficio("BBBB");
        emple2.setSalario(20000);
        empleados.getEmple().add(emple2);

        emple3.setApellido("cccc");
        emple3.setEmpno(BigInteger.valueOf(3));
        emple3.setOficio("CCCC");
        emple3.setSalario(30000);
        empleados.getEmple().add(emple3);

        datostype.setDepartamento(departamento);
        datostype.setEmpleados(empleados);

        actualizarDatosXML();
        actualizarFicheroXML(xmlOriginal);
        

    }
    
    //crea el fichero .xml
    public void actualizarFicheroXML(File fichero){
        
        if (fichero.exists()){
            fichero.delete();
        }
        
        try {
            m.marshal(elemento, fichero);
        } catch (JAXBException ex) {
            System.out.println("fallo al guardar el archivo: "+ex);
        }
        
    }

    public void actualizarDatosXML() {
        //crear el marshaller, volcar la lista al fichero XML 
        mixml = new ObjectFactory();
        // El JAXBElement lo obtenemos del ObjectFactory y del DatoscentroType
        elemento = mixml.createDatosempledepart(datostype);

        try {
            contexto = JAXBContext.newInstance(ObjectFactory.class);
            m = contexto.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            m.marshal(elemento, System.out);
        } catch (JAXBException ex) {
            System.out.println("fallo " + ex);
        }

    }

    


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
