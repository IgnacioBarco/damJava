/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Nacho
 */
public class CuentaCorrienteEmpresa extends CuentaCorriente{
    
    double tipoInteresDescubierto, maxDescubierto,comisionPorDescubierto;
    
    public CuentaCorrienteEmpresa(){
        
    }
    
    public CuentaCorrienteEmpresa(Persona titular, double saldo, String ccc, double maxDescubierto, 
            double tipoInteresDescubierto, double comisionPorDescubierto){
        comisionMantenimiento=false;
        this.titular=titular;
        this.saldo=saldo;
        this.ccc=ccc;
        this.tipoInteresDescubierto=tipoInteresDescubierto;
        this.maxDescubierto=maxDescubierto;
        this.comisionPorDescubierto=comisionPorDescubierto;
        
    }

    /**
     * @return the tipoInteresDescubierto
     */
    public double getTipoInteresDescubierto() {
        return tipoInteresDescubierto;
    }

    /**
     * @param tipoInteresDescubierto the tipoInteresDescubierto to set
     */
    public void setTipoInteresDescubierto(double tipoInteresDescubierto) {
        this.tipoInteresDescubierto = tipoInteresDescubierto;
    }

    /**
     * @return the maxDescubierto
     */
    public double getMaxDescubierto() {
        return maxDescubierto;
    }

    /**
     * @param maxDescubierto the maxDescubierto to set
     */
    public void setMaxDescubierto(double maxDescubierto) {
        this.maxDescubierto = maxDescubierto;
    }

    /**
     * @return the comisionPorDescubierto
     */
    public double getComisionPorDescubierto() {
        return comisionPorDescubierto;
    }

    /**
     * @param comisionPorDescubierto the comisionPorDescubierto to set
     */
    public void setComisionPorDescubierto(double comisionPorDescubierto) {
        this.comisionPorDescubierto = comisionPorDescubierto;
    }
    
    public String toString(){
        return titular.toString()+","+
                "saldo="+getSaldo()+","+
                "CCC="+getCcc()+","+
                "cuentaRem="+isCuentaRemunerada()+","+
                "com mant="+isComisionMantenimiento()+","+
                "MaxDescubierto="+getMaxDescubierto()+","+
                "tipoIntPorDesc="+getTipoInteresDescubierto()+","+
                "comPorDesc="+getComisionPorDescubierto();
                
    }
}
