/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Nacho
 */
public class CuentaAhorro extends CuentaBancaria{
    double tipoInteres;
    
    public CuentaAhorro(){
        
    }
    
    public CuentaAhorro(Persona titular, double saldo,String ccc, double tipoInteres){
        cuentaRemunerada=true;
        this.titular=titular;
        this.saldo=saldo;
        this.ccc=ccc;
        this.tipoInteres=tipoInteres;
    }
    
    

    /**
     * @return the tipoInteres
     */
    public double getTipoInteres() {
        return tipoInteres;
    }

    /**
     * @param tipoInteres the tipoInteres to set
     */
    public void setTipoInteres(double tipoInteres) {
        this.tipoInteres = tipoInteres;
    }
    
    public String toString(){
        return titular.toString()+","+
                "saldo="+getSaldo()+","+
                "CCC="+getCcc()+","+
                "cuentaRem="+isCuentaRemunerada()+","+
                "TipoInteres="+getTipoInteres();
                
    }
}
