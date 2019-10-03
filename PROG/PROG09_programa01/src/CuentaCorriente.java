
import java.util.Hashtable;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Nacho
 */
public class CuentaCorriente extends CuentaBancaria{
        
    Hashtable<String,Double> listaEntidadesAutorizadas;
    boolean comisionMantenimiento;
    
    public CuentaCorriente(){
        listaEntidadesAutorizadas= new Hashtable();
        listaEntidadesAutorizadas.put("TELEFONICA",500d);
        listaEntidadesAutorizadas.put("BANKIA",1000d);
        listaEntidadesAutorizadas.put("ENDESA",500d);
        listaEntidadesAutorizadas.put("REPSOL",100d);
        listaEntidadesAutorizadas.put("ORANGE",200d);
    }

    /**
     * @return the listaEntidadesAutorizadas
     */
    public Hashtable<String,Double> getListaEntidadesAutorizadas() {
        return listaEntidadesAutorizadas;
    }

    /**
     * @param listaEntidadesAutorizadas the listaEntidadesAutorizadas to set
     */
    public void setListaEntidadesAutorizadas(Hashtable<String,Double> listaEntidadesAutorizadas) {
        this.listaEntidadesAutorizadas = listaEntidadesAutorizadas;
    }

    /**
     * @return the comisionMantenimiento
     */
    public boolean isComisionMantenimiento() {
        return comisionMantenimiento;
    }

    /**
     * @param comisionMantenimiento the comisionMantenimiento to set
     */
    public void setComisionMantenimiento(boolean comisionMantenimiento) {
        this.comisionMantenimiento = comisionMantenimiento;
    }
    
    
}
