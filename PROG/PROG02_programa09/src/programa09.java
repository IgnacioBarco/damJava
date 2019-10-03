


import java.util.Scanner;
/**
 *
 * @author Nacho
 */
public class programa09 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        Scanner datos = new Scanner(System.in);
        System.out.println("Dame un numero de 5 digitos");
        String cadena = Integer.toString(datos.nextInt());
        
        String res=cadena.substring(0,1)+" "+cadena.substring(1,2)+" "+cadena.substring(2,3)+" "+cadena.substring(3,4)+" "+cadena.substring(4,5);
        
        System.out.println("El numero separado es: " + res); 
    }
    
}
