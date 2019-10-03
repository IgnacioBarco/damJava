/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Nacho
 */
public class Articulo {

    private Integer cod;
    private String den;
    private Double precio;
    private Integer stock;
    private String zona;
    private Integer codProv;

    public Articulo() {
    }

    public Articulo(Integer cod, String den, Double precio, Integer stock, String zona, Integer codProv) {
        this.cod = cod;
        this.den = den;
        this.precio = precio;
        this.stock = stock;
        this.zona = zona;
        this.codProv = codProv;
    }

    /**
     * @return the cod
     */
    public Integer getCod() {
        return cod;
    }

    /**
     * @param cod the cod to set
     */
    public void setCod(Integer cod) {
        this.cod = cod;
    }

    /**
     * @return the den
     */
    public String getDen() {
        return den;
    }

    /**
     * @param den the den to set
     */
    public void setDen(String den) {
        this.den = den;
    }

    /**
     * @return the precio
     */
    public Double getPrecio() {
        return precio;
    }

    /**
     * @param precio the precio to set
     */
    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    /**
     * @return the stock
     */
    public Integer getStock() {
        return stock;
    }

    /**
     * @param stock the stock to set
     */
    public void setStock(Integer stock) {
        this.stock = stock;
    }

    /**
     * @return the zona
     */
    public String getZona() {
        return zona;
    }

    /**
     * @param zona the zona to set
     */
    public void setZona(String zona) {
        this.zona = zona;
    }

    /**
     * @return the codProv
     */
    public Integer getCodProv() {
        return codProv;
    }

    /**
     * @param codProv the codProv to set
     */
    public void setCodProv(Integer codProv) {
        this.codProv = codProv;
    }
    
    public String toString(){
        
        return  cod+"\t"+den+"\t"+precio+"\t"+stock+"\t"+zona+"\t"+codProv;
    }
}

