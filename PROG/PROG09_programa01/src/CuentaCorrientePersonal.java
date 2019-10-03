/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Nacho
 */
public class CuentaCorrientePersonal extends CuentaCorriente{
    
    double comMant;
    
    public CuentaCorrientePersonal(){
        
    }
    
    public CuentaCorrientePersonal(Persona titular, double saldo, String ccc, double comMant){
        comisionMantenimiento=true;
        this.titular=titular;
        this.saldo=saldo;
        this.ccc=ccc;
        this.comMant=comMant;
    }

    /**
     * @return the comMant
     */
    public double getComMant() {
        return comMant;
    }

    /**
     * @param comMant the comMant to set
     */
    public void setComMant(double comMant) {
        this.comMant = comMant;
    }
    
    public String toString(){
        return titular.toString()+","+
                "saldo="+getSaldo()+","+
                "CCC="+getCcc()+","+
                "cuentaRem="+isCuentaRemunerada()+","+
                "com mant="+isComisionMantenimiento()+","+
                "ComMant="+getComMant();
                
    }
    
}
