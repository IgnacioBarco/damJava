/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Nacho
 */
public class AplicacionCuentaBancaria {

    static CuentaBancaria cuentaBancaria;
    static VentanaPrincipal vPrincipal;
    
    public static void main(String[] args) {
        
        
        
        //creamos el objeto cuentaBancaria y 3 ejemplos, uno de cada tipo de cuenta
        cuentaBancaria = new CuentaBancaria();
        CuentaCorriente cuentaCorriente = new CuentaCorriente();
        
        Persona titularEjemplo1 = new Persona("titular1", "apellidos1", "01/01/1995");
        CuentaAhorro cuentaEjemplo1 = new CuentaAhorro(titularEjemplo1, 500, "1234-1234-16-1234567890", 2);
        cuentaBancaria.listadoObjetos.add(cuentaEjemplo1);
        
        Persona titularEjemplo2 = new Persona("titular2", "apellidos2", "03/03/2000");
        CuentaCorrientePersonal cuentaEjemplo2 = new CuentaCorrientePersonal(titularEjemplo2, 600d, "2100-0813-61-0123456789", 10d);
        cuentaBancaria.listadoObjetos.add(cuentaEjemplo2);
        
        Persona titularEjemplo3 = new Persona("titular3", "apellidos3", "06/06/2005");
        CuentaCorrienteEmpresa cuentaEjemplo3 = new CuentaCorrienteEmpresa(titularEjemplo3, 700d, "3030-4332-57-6005246706", 5d, 6d, 100d);
        cuentaBancaria.listadoObjetos.add(cuentaEjemplo3);
        
        //creamos la tabla con los objetos creados
        cuentaBancaria.introducirDatosTabla(cuentaBancaria.listadoObjetos);
        
        //para visualizaren consola los objetos creados
        for (CuentaBancaria obj : cuentaBancaria.listadoObjetos) {
            System.out.println(obj.getClass().toString()+" lll "+obj.toString());
        }
        
        //creamos la ventana del programa y la hacemos visible
        vPrincipal= new VentanaPrincipal();
        vPrincipal.setVisible(true);
        
    }
    
}
