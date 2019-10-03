/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miReloj;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author Nacho
 */
public class Alarma implements Serializable {
    
    private int hora, minutos;
    private boolean format24H; 
    private boolean activa=false;
    
    public Alarma(){
    
    }
    
    public Alarma(int hora, int minutos, boolean format24H, boolean activa){
        this.hora=hora;
        this.minutos=minutos;
        this.format24H=format24H;
        this.activa=activa;
        
    }
    
    public Alarma(Object obj){
        GregorianCalendar a = new GregorianCalendar();
        a.setTime((Date)obj);
        int horaAlarma=a.get(Calendar.HOUR_OF_DAY);
        int minutosAlarma=a.get(Calendar.MINUTE);
        this.hora=horaAlarma;
        this.minutos=minutosAlarma;
        this.format24H=true;
        this.activa=false;
        
    }

    /**
     * @return the hora
     */
    public int getHora() {
        return hora;
    }

    /**
     * @param hora the hora to set
     */
    public void setHora(int hora) {
        this.hora = hora;
    }

    /**
     * @return the minutos
     */
    public int getMinutos() {
        return minutos;
    }

    /**
     * @param minutos the minutos to set
     */
    public void setMinutos(int minutos) {
        this.minutos = minutos;
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
     * @return the activa
     */
    public boolean isActiva() {
        return activa;
    }

    /**
     * @param activa the activa to set
     */
    public void setActiva(boolean activa) {
        this.activa = activa;
    }
    
    @Override
    public String toString(){
        return getHora()+","+getMinutos()+","+isFormat24H()+","+isActiva();
    }
            
}
