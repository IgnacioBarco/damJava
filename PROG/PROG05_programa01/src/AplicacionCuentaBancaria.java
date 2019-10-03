
import java.util.NoSuchElementException;
import java.util.NoSuchElementException;
import java.lang.IllegalStateException;
import java.util.Scanner;
/**
 *
 * @author Nacho
 */
public class AplicacionCuentaBancaria {
    
    public static void main(String[] args) {
   
    String titular, opcion, cuenta;
    Scanner dato = new Scanner(System.in);
    
    //usamos los metodos estaticos para conseguir las variables
    titular=verificarUsuario();
    cuenta=verificarNumeroCuenta();
    
    //creamos un objeto CuentaBancaria pasandole el titular y la cuenta 
    CuentaBancaria ccc = new CuentaBancaria(titular, cuenta);
  
    //usamos un bucle do-while hasta que el usuario  pulse la opcion 10 
    do{
        //mostramos el menu
        ccc.mostrarMenu();
        //obtenemos la opcion pulsada
        opcion = dato.nextLine();
        switch(opcion){
            //segun la opcion, ejecutamos el metodo de CuentaBancaria
            case "1":
                ccc.mostrarOpcion1();
                break;
            case "2":
                ccc.mostrarOpcion2();
                break;
            case "3":
                ccc.mostrarOpcion3();
                break;
            case "4":
                ccc.mostrarOpcion4();
                break;
            case "5":       
                ccc.mostrarOpcion5();
                break;
            case "6":
                ccc.mostrarOpcion6();
                break;
            case "7":
                ccc.mostrarOpcion7();
                break;
            case "8":
                ccc.mostrarOpcion8();
                break;
            case "9":
                ccc.mostrarOpcion9();
                break;
            case "10":
                System.out.println("\n\n Ha elegido salir de la aplicación");
                //cambiamos el valor de opcion para salir del bucle
                opcion="salir";
                break;
            //para cuando el usuario teclee algo que no sea del 1 al 10
            default:    
                System.out.println("Opción incorrecta\n\n");
                break;
        }
    }while(opcion != "salir");
        
       
   
       
}

//metodo que nos pide un usuario y verifica que los datos introducidos son correctos    
public static String verificarUsuario(){
    //inicializamos variables
    String titular = null; 
    Scanner dato = new Scanner(System.in);
    int ver = 0;
    boolean verificacionNombre = false;

    //Utilizamos un do while para que se repita mientras el numero de cuenta no se a correcto
    do{
        //capturamos excepciones y las tratamos
        try {
            System.out.print("\n\nNombre del titular(maximo 15 caracteres, solo letras): ");
            titular = dato.nextLine();
        }
        catch(NoSuchElementException excepcion){
            ver=1;
        }
        catch(IllegalStateException excepcion){
            ver=2;
        }
        if (ver==1 || ver==2){
            System.out.println("El nombre introducido es incorrecto");
            ver=0;
        }
        
        //si el titular tiene mas de 15 cararcteres, repetimos el bucle
        if (titular.length()>15){
            System.out.println("El titular debe de tener menos de 15 caracteres");
        }
        //si el titular esta entre 1 y 15 digitos y son todo letras, salimos del bucle
        if (titular.length()>0 && titular.length()<16 && titular.matches("[a-zA-Z]*")){
            System.out.println(titular+" ok");
            verificacionNombre=true;
        //si no, repetimos el bucle
        } else {
            System.out.println("El usuario no puede contener caracteres que no sean letras");
        }
    }while(verificacionNombre==false);
    return titular;
}



//metodo que pide el numero de cuenta y verifica que los datos son correctos
public static String verificarNumeroCuenta(){
    
    //inicializamos variables
    String cuenta = null; 
    Scanner dato = new Scanner(System.in);
    int ver = 0;
    boolean verificacionCuenta = false;
    int primerDigitoControl, segundoDigitoControl;
    String digControl, codControl, codControlDado;
    
    
    //Utilizamos un do while para que se repita mientras el numero de cuenta no se a correcto
    do{ 
        //capturamos excepciones y las tratamos
        try {
            System.out.print("\n\nNumero de cuenta: ");
            cuenta = dato.nextLine();
        }
        catch(NoSuchElementException excepcion){
            ver=1;
        }
        catch(IllegalStateException excepcion){
            ver=2;
        }
        if (ver==1 || ver==2){
            System.out.println("El numero de cuenta introducido es incorrecto");
            ver=0;
        }
    //si la cuenta no tiene 20 digitos numericos se repite el bucle
        if (!cuenta.matches("[0-9]{20}") ){
            System.out.println("Cuenta incorrecta. La cuenta debe tener 20 caracteres numericos");
        } else {
        //si tiene 20 digitos, comprobamos que el digito de control sea el correcto    
            int e1=(Integer.parseInt(cuenta.substring(0,1)))*4;
            int e2=(Integer.parseInt(cuenta.substring(1,2)))*8;
            int e3=(Integer.parseInt(cuenta.substring(2,3)))*5;
            int e4=(Integer.parseInt(cuenta.substring(3,4)))*10;
            int o1=(Integer.parseInt(cuenta.substring(4,5)))*9;
            int o2=(Integer.parseInt(cuenta.substring(5,6)))*7;
            int o3=(Integer.parseInt(cuenta.substring(6,7)))*3;
            int o4=(Integer.parseInt(cuenta.substring(7,8)))*6;
            
            primerDigitoControl=11-((e1+e2+e3+e4+o1+o2+o3+o4)%11);
            if (primerDigitoControl==11){
                primerDigitoControl=0;
            }
            if (primerDigitoControl==10){
                primerDigitoControl=1;
            }
            
            int c1=(Integer.parseInt(cuenta.substring(10,11)))*1;
            int c2=(Integer.parseInt(cuenta.substring(11,12)))*2;
            int c3=(Integer.parseInt(cuenta.substring(12,13)))*4;
            int c4=(Integer.parseInt(cuenta.substring(13,14)))*8;
            int c5=(Integer.parseInt(cuenta.substring(14,15)))*5;
            int c6=(Integer.parseInt(cuenta.substring(15,16)))*10;
            int c7=(Integer.parseInt(cuenta.substring(16,17)))*9;
            int c8=(Integer.parseInt(cuenta.substring(17,18)))*7;
            int c9=(Integer.parseInt(cuenta.substring(18,19)))*3;
            int c10=(Integer.parseInt(cuenta.substring(19,20)))*6;
            
            segundoDigitoControl=11-((c1+c2+c3+c4+c5+c6+c7+c8+c9+c10)%11);
            if (segundoDigitoControl==11){
                segundoDigitoControl=0;
            }
            if (segundoDigitoControl==10){
                segundoDigitoControl=1;
            }
            
            //comprobamos los datos 
            codControl=cuenta.substring(8,10);
            codControlDado=String.valueOf(primerDigitoControl)+String.valueOf(segundoDigitoControl);
            
            //si son iguales, salimos del bucle
            if (codControl.equalsIgnoreCase(codControlDado)){
                System.out.println("Cuenta correcta, entrando a la aplicación");
                verificacionCuenta=true;
            //si no, se repite el bucle
            } else {
                System.out.println("Codigo de control incorrecto");
            }
            
        }
    
    
    }while(verificacionCuenta==false);
    
    return cuenta;
}
    
    
    

    
} 