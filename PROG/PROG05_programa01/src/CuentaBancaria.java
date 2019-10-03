import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.lang.IllegalStateException;
import java.util.Scanner;

/**
 *
 * @author Nacho
 */

public class CuentaBancaria {
    
    String titular;
    String cuenta,codEntidad, codOficina, codControl, codCuenta, cant;
    private Integer saldo;
    int cantidad;
    boolean verificacion;
    int ver;
    Scanner dato = new Scanner(System.in);  
    
    public CuentaBancaria(String titular, String cuenta){
        this.titular = titular;
        this.cuenta = cuenta;
        
        //ponemos un saldo aleatorio entre 0 y 100.000€
        saldo=(int)Math.round(Math.random()*100000);
        //separamos la cuenta en entidad, oficina, control y cuenta
        codEntidad=cuenta.substring(0,4);
        codOficina=cuenta.substring(4,8);
        codControl=cuenta.substring(8,10);
        codCuenta=cuenta.substring(10,20);
    }
    
    //metodo que nos muestra el menu
    public void mostrarMenu(){
        System.out.println("\n1. Ver el número de cuenta completo: (CCC - código Cuenta Cliente)");
        System.out.println("2. Ver el titular de la cuenta");
        System.out.println("3. Ver el código de la entidad");
        System.out.println("4. Ver el código de la oficina");
        System.out.println("5. Ver el número de la cuenta");
        System.out.println("6. Ver los dígitos de control de la cuenta");
        System.out.println("7. Realizar un ingreso");
        System.out.println("8. Retirar efectivo");
        System.out.println("9. Consultar saldo");
        System.out.println("10.Salir de la aplicación");
    }
 
    //muestra el numero de cuenta completo
    public void mostrarOpcion1(){
        System.out.println("\nEl numero CCC es "+codEntidad+" - "+codOficina+" - "+codControl+" - "+codCuenta);
    }
    
    //muestra el titular
    public void mostrarOpcion2(){
        System.out.println("\nEl titular de la cuenta es: "+titular);
    }
    
    //muestra la entidad
    public void mostrarOpcion3(){
        System.out.println("\nEl código de la entidad es: "+codEntidad);
    }
    
    //muestra la oficina
    public void mostrarOpcion4(){
        System.out.println("\nEl código de la oficina es: "+codOficina);
    }
    
    
    //muestra la cuenta
    public void mostrarOpcion5(){
        System.out.println("\nEl número de la cuenta es: "+codCuenta);
    }
    
    //muestra los digitos de control
    public void mostrarOpcion6(){
        System.out.println("\nEl código de control es: "+codControl);
    }
    
    //realiza un ingreso
    public void mostrarOpcion7(){
        verificacion=false;
        
        //utilizamos un do-while para que se repita hasta que se haga un ingreso bien
        do{
            System.out.print("\n¿Que cantidad quiere ingresar?: ");
            //capturamos excepciones y las tratamos
            try{
                cant = dato.next();
            }
            catch(NoSuchElementException excepcion){
                ver=1;
            }
            catch(IllegalStateException excepcion){
                ver=2;
            }
            if (ver==1 || ver==2){
                System.out.println("La cantidad introducida es incorrecta");
                ver=0;
            }
            
            //si la cantidad es solo numeros, pasamos la variable a int
            if (cant.matches("[0-9]*")){
                cantidad=Integer.parseInt(cant);
                //si es  repetimos el bucle
                if (cantidad==0){
                    System.out.print("\nNo se puede ingresar 0 euros.\n");
                }
                //si es mayor que 0 y multiplo de 10 ingresamos la cantidad y lo mostramos saliendonos luego del bucle
                if (cantidad>0){
                    if ( cantidad%10==0){
                        ingresarSaldo(cantidad);
                        System.out.println("\nHa ingresado "+cantidad+" euros");
                        verificacion=true;
                    //si no es multiplo de 10 repetimos bucle
                    } else {
                        System.out.println("\nSolo se pueden ingresar billetes, por lo que debe introducir un importe que sea multiplo de 10\n");
                    }
                }    
            //si no son numeros, repetimos bucle
            }else {
                System.out.print("La cantidad introducida es incorrecta");
                }
            
        }while(verificacion==false);    
        
        
    }    
            
    //retira dinero
    public void mostrarOpcion8(){
        verificacion=false;
        //si el saldo esta entre 0 y 10, indicamos que no se puede retirar ya quedebe ser multiplo de 10€
        if (getSaldo()>=0 && getSaldo()<10){
                System.out.println("\nNo tiene suficiente saldo para hacer una retirada mínima de 10€");
                System.out.println("Salimos de la opcion 8\n");
                verificacion=true;
            }
        
        //utilizamos un do-while para que se repita hasta que se indique una cantidad a retirar correcta
        do{
            System.out.println("\n¿Que cantidad quiere sacar?");
            //capturamos excepciones y las tratamos
            try{
                cant = dato.next();
            }
            catch(NoSuchElementException excepcion){
                ver=1;
            }
            catch(IllegalStateException excepcion){
                ver=2;
            }
            if (ver==1 || ver==2){
                System.out.println("La cantidad introducida es incorrecta");
                cant="mal";
                ver=0;
            }
            
            //si se introducen solo numeros, pasamos la variable a int
            if (cant.matches("[0-9]*")){
                cantidad=Integer.parseInt(cant);
                //si es 0 repetimos el bucle
                if (cantidad==0){
                    System.out.println("No se puede retirar 0 euros");
                }
                //si es mayor que 0
                if (cantidad>0){
                    //si la cantidad es menor que el saldo y multiplo de 10, retiramos la cantidad, la mostramos y salimos del bucle
                    if (cantidad<=saldo && cantidad%10==0){
                        retirarSaldo(cantidad);        
                        System.out.println("\nHa sacado "+cantidad+" euros");
                        verificacion=true;
                    //si la cantidad es menos que el saldo y no es multiplo de 10 repetimos bucle    
                    } else if (cantidad<=saldo && cantidad%10!=0){
                        System.out.println("\nSolo se puede retirar billetes, por lo que el importe debe ser multiplo de 10\n");
                    //en los casos contrarios, es decir, que intentamos sacar mas del saldo disponible, repetimos bucle
                    } else {
                        System.out.println("\nNo tiene suficiente saldo para retirar esa cantidad de dinero\n");
                    }
                }
                //si no son numeros repetimos el bucle
                } else {
                    System.out.println("La cantidad introducida es incorrecta");
            }  
        
        }while (verificacion==false);
    }    
    
    //muestra el saldo
    public void mostrarOpcion9(){
        System.out.println("\nEl saldo actual es de "+getSaldo()+" euros");
    }

    //devuelve el saldo
    public int getSaldo(){
        return saldo;
    }
    
    //ingresa saldo
    public void ingresarSaldo(int cantidad){
        saldo=saldo+cantidad;
    }
    
    //retira saldo
    public void retirarSaldo(int cantidad){
        saldo=saldo-cantidad;
    }
    
}
