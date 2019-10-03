/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Nacho
 */
public class Asignatura {
    
    private int horas,codigo;
    private String denom;
    
    public Asignatura(){
        
    }
    
    public Asignatura(int codigo, String denom, int horas){
        this.codigo=codigo;
        this.denom=denom;
        this.horas=horas;
    }

    
    /**
     * @return the horas
     */
    public int getHoras() {
        return horas;
    }

    /**
     * @param horas the horas to set
     */
    public void setHoras(int horas) {
        this.horas = horas;
    }

    /**
     * @return the denom
     */
    public String getDenom() {
        return denom;
    }

    /**
     * @param denom the denom to set
     */
    public void setDenom(String denom) {
        this.denom = denom;
    }

    /**
     * @return the codigo
     */
    public int getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    
}
