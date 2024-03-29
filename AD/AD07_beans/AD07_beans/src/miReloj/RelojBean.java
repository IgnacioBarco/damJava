package miReloj;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.Timer;

/**
 *
 * @author Nacho
 */
public class RelojBean extends javax.swing.JPanel implements Serializable, ActionListener {

    private Timer timer;
    private GregorianCalendar horaActual;
    private String horas,  minutos, segundos;
    private Color color;
    private Color colorFondo;
    private Font fuente;

    private boolean format24H = false;

    public RelojBean() {
        initComponents();
        cambiaHora();

    }

    /**
     * Ponemos un contador cada medio segundo, para que actualice la hora
     */
    private void cambiaHora() {
        timer = new Timer(1000, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                horaActual = new GregorianCalendar();

                if (!isFormat24H()) {
                    if (horaActual.get(Calendar.AM_PM) == 1) {
                        jLabel_AmPm.setText("PM");
                    } else {
                        jLabel_AmPm.setText("AM");
                    }
                    if (horaActual.get(Calendar.HOUR) < 10) {
                        horas = "0" + String.valueOf(horaActual.get(Calendar.HOUR));
                    } else {
                        horas = String.valueOf(horaActual.get(Calendar.HOUR));
                    }

                } else if (isFormat24H()) {
                    jLabel_AmPm.setText(" ");
                    if (horaActual.get(Calendar.HOUR_OF_DAY) < 10) {
                        horas = "0" + String.valueOf(horaActual.get(Calendar.HOUR_OF_DAY));
                    } else {
                        horas = String.valueOf(horaActual.get(Calendar.HOUR_OF_DAY));
                    }
                }

                //añadimos los minutos 
                if (horaActual.get(Calendar.MINUTE) < 10) {
                    minutos = "0" + String.valueOf(horaActual.get(Calendar.MINUTE));
                } else {
                    minutos = String.valueOf(horaActual.get(Calendar.MINUTE));
                }

                //añadimos los segundos
                if (horaActual.get(Calendar.SECOND) < 10) {
                    segundos = "0" + String.valueOf(horaActual.get(Calendar.SECOND));
                } else {
                    segundos = String.valueOf(horaActual.get(Calendar.SECOND));
                }

                jTF_Hora.setText(horas);
                jTF_Minutos.setText(minutos);
                jTF_Segundos.setText(segundos);
                repaint();

            }
        }
        );
        timer.start();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jTF_Hora = new javax.swing.JTextField();
        jTF_Minutos = new javax.swing.JTextField();
        jTF_Segundos = new javax.swing.JTextField();
        jTF_Hora1 = new javax.swing.JTextField();
        jTF_Hora2 = new javax.swing.JTextField();
        jLabel_AmPm = new javax.swing.JLabel();

        setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jTF_Hora.setEditable(false);
        jTF_Hora.setFont(new java.awt.Font("Wide Latin", 1, 36)); // NOI18N
        jTF_Hora.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTF_Hora.setText("12");
        jTF_Hora.setBorder(null);
        jTF_Hora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTF_HoraActionPerformed(evt);
            }
        });

        jTF_Minutos.setEditable(false);
        jTF_Minutos.setFont(new java.awt.Font("Wide Latin", 1, 36)); // NOI18N
        jTF_Minutos.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTF_Minutos.setText("00");
        jTF_Minutos.setBorder(null);
        jTF_Minutos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTF_MinutosActionPerformed(evt);
            }
        });

        jTF_Segundos.setEditable(false);
        jTF_Segundos.setFont(new java.awt.Font("Wide Latin", 1, 36)); // NOI18N
        jTF_Segundos.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTF_Segundos.setText("00");
        jTF_Segundos.setBorder(null);
        jTF_Segundos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTF_SegundosActionPerformed(evt);
            }
        });

        jTF_Hora1.setEditable(false);
        jTF_Hora1.setFont(new java.awt.Font("Wide Latin", 1, 36)); // NOI18N
        jTF_Hora1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTF_Hora1.setText(":");
        jTF_Hora1.setBorder(null);
        jTF_Hora1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTF_Hora1ActionPerformed(evt);
            }
        });

        jTF_Hora2.setEditable(false);
        jTF_Hora2.setFont(new java.awt.Font("Wide Latin", 1, 36)); // NOI18N
        jTF_Hora2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTF_Hora2.setText(":");
        jTF_Hora2.setBorder(null);
        jTF_Hora2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTF_Hora2ActionPerformed(evt);
            }
        });

        jLabel_AmPm.setFont(new java.awt.Font("Sylfaen", 1, 14)); // NOI18N
        jLabel_AmPm.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_AmPm.setText("am");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel_AmPm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTF_Hora, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTF_Hora1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTF_Minutos, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTF_Hora2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTF_Segundos, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel_AmPm)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTF_Minutos, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTF_Hora2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTF_Segundos, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTF_Hora1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTF_Hora, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(29, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jTF_HoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTF_HoraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTF_HoraActionPerformed

    private void jTF_Hora1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTF_Hora1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTF_Hora1ActionPerformed

    private void jTF_Hora2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTF_Hora2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTF_Hora2ActionPerformed

    private void jTF_SegundosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTF_SegundosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTF_SegundosActionPerformed

    private void jTF_MinutosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTF_MinutosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTF_MinutosActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel_AmPm;
    private javax.swing.JTextField jTF_Hora;
    private javax.swing.JTextField jTF_Hora1;
    private javax.swing.JTextField jTF_Hora2;
    private javax.swing.JTextField jTF_Minutos;
    private javax.swing.JTextField jTF_Segundos;
    // End of variables declaration//GEN-END:variables

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");

        //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * @return the format24H
     */
    public boolean isFormat24H() {
        return format24H;
    }

    /**
     * @param format24H the format24H to set
     */
    public void setFormat24H(boolean format24H) {
        this.format24H = format24H;

    }

    /**
     * @return the color
     */
    public Color getColor() {
        return jTF_Hora.getBackground();
    }

    /**
     * @param color the color to set
     */
    public void setColor(Color color) {
        this.color = color;
        jTF_Hora.setForeground(color);
        jTF_Hora1.setForeground(color);
        jTF_Hora2.setForeground(color);
        jTF_Minutos.setForeground(color);
        jTF_Segundos.setForeground(color);
        jLabel_AmPm.setForeground(color);

    }

    /**
     * @return the fuente
     */
    public Font getFuente() {
        return jTF_Hora.getFont();
    }

    /**
     * @param fuente the fuente to set
     */
    public void setFuente(Font fuente) {
        this.fuente = fuente;
        jTF_Hora.setFont(fuente);
        jTF_Hora1.setFont(fuente);
        jTF_Hora2.setFont(fuente);
        jTF_Minutos.setFont(fuente);
        jTF_Segundos.setFont(fuente);
        jLabel_AmPm.setFont(fuente);
    }

    /**
     * @return the colorFondo
     */
    public Color getColorFondo() {
        return getBackground();
    }

    /**
     * @param colorFondo the colorFondo to set
     */
    public void setColorFondo(Color colorFondo) {
        this.colorFondo = colorFondo;
        setBackground(color);
    }

}
