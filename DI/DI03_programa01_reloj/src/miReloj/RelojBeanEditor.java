/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miReloj;

import java.awt.Component;
import java.beans.*;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.JSpinner;

/**
 *
 * @author Nacho
 */
public class RelojBeanEditor extends PropertyEditorSupport implements PropertyEditor{
    
    Alarma aaa;
    
    private editorAlarma editor = null;
    
    public RelojBeanEditor() {
        this.editor = new editorAlarma();
        aaa = new Alarma(editorAlarma.jSpinner_Alarma.getValue());
        
        
    }
    
    @Override
    public Component getCustomEditor() {
        return editor;
    }
    
    @Override
    public boolean supportsCustomEditor() {
        return true;
    }
    
    @Override
    //public Object getValue() {
    public Alarma getValue() {
       return aaa;
        
    }
    
    public void setValue(Alarma aaa){
        
        GregorianCalendar a = new GregorianCalendar();
        a.setTime((Date)editorAlarma.jSpinner_Alarma.getValue());
        System.out.println(a);
        int horaAlarma=a.get(Calendar.HOUR_OF_DAY);
        int minutosAlarma=a.get(Calendar.MINUTE);
        aaa.setActiva(true);
        aaa.setHora(horaAlarma);
        aaa.setMinutos(minutosAlarma);
        
        super.setValue(aaa);
        
        
       
     }
    
    @Override
    public String getJavaInitializationString() {
        return aaa.toString();
    }
}
