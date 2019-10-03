
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Nacho
 */
public class CuentaBancaria {
     double saldo;
     String ccc;
     boolean cuentaRemunerada;
     Persona titular;
     ArrayList<CuentaBancaria> listadoObjetos;
     DefaultTableModel datosTabla;
     Vector titulos;
     JList<String> listaCombo;
     DefaultComboBoxModel<String> modeloLista;
    
    public CuentaBancaria(){
        listadoObjetos = new ArrayList<>();
        
        
    }

    /**
     * @return the saldo
     */
    public double getSaldo() {
        return saldo;
    }

    /**
     * @param saldo the saldo to set
     */
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    /**
     * @return the ccc
     */
    public String getCcc() {
        return ccc;
    }

    /**
     * @param ccc the ccc to set
     */
    public void setCcc(String ccc) {
        this.ccc = ccc;
    }

    /**
     * @return the cuentaRemunerada
     */
    public boolean isCuentaRemunerada() {
        return cuentaRemunerada;
    }

    /**
     * @param cuentaRemunerada the cuentaRemunerada to set
     */
    public void setCuentaRemunerada(boolean cuentaRemunerada) {
        this.cuentaRemunerada = cuentaRemunerada;
    }

    /**
     * @return the titular
     */
    public Persona getTitular() {
        return titular;
    }

    /**
     * @param titular the titular to set
     */
    public void setTitular(Persona titular) {
        this.titular = titular;
    }

    /**
     * @return the listadoObjetos
     */
    public ArrayList<CuentaBancaria> getListadoObjetos() {
        return listadoObjetos;
    }

    /**
     * @param listadoObjetos the listadoObjetos to set
     */
    public void setListadoObjetos(ArrayList<CuentaBancaria> listadoObjetos) {
        this.listadoObjetos = listadoObjetos;
    }
    
    public void introducirDatosTabla(ArrayList<CuentaBancaria> array ){
        //para el combobox
        listaCombo = new JList<>();
        modeloLista = new DefaultComboBoxModel<>();
        
        //para la jtable
        datosTabla = new DefaultTableModel();
        titulos= new Vector();
        titulos.add("Titular");
        titulos.add("Codigo de cuenta");
        titulos.add("Saldo");
        datosTabla.setColumnIdentifiers(titulos);
        
        for (CuentaBancaria obj : array) {
            //para rellenar la jtable
            String datos = obj.titular.getNombre()+","+obj.getCcc()+","+obj.getSaldo();
            String[] campos = new String[3];
            campos=datos.split(",");
            datosTabla.addRow(campos);
            
            //añadimos una linea al combo para la eleccion de CCC
            modeloLista.addElement(obj.getCcc());
        }
        
        //
        
        
        
    }
    
    
}
