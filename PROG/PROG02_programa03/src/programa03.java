/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Nacho
 */
public class programa03 {

//nos muestra por pantalla varias variables usando println, print y printf   
    
public enum sexo{V,M};
    
public static void main(String[ ] args) { 

 //inicializamos variables y las damos valor
 boolean casado=true;
 int MAXIMO=999999;    
 byte diasem=1;
 short diaanual=300;
 long miliseg=1298332800000L;
 float totalfactura=10350.678f;
 long poblacion=6775235741L;
 
 //usando la orden println
 System.out.println("----- EJERCICIO DE VARIABLES Y TIPO DE DATOS -----");
 System.out.println("\tEl valor de la variable casado es " + casado);
 System.out.println("\tEl valor de la variable MAXIMO es " + MAXIMO);
 System.out.println("\tEl valor de la variable diasem es " + diasem);
 System.out.println("\tEl valor de la variable diaanual es " + diaanual);
 System.out.println("\tEl valor de la variable miliseg es " + miliseg);
 System.out.println("\tEl valor de la variable totalfactura es " + totalfactura);
 System.out.println("\tEl valor de la variable poblacion es " + poblacion);
 System.out.println("\tEl valor de la variable sexo es "+ sexo.M);
 
 
 //usando la orden print
 System.out.print("\n----- EJERCICIO DE VARIABLES Y TIPO DE DATOS -----\n");
 System.out.print("\tEl valor de la variable casado es " + casado + "\n");
 System.out.print("\tEl valor de la variable MAXIMO es " + MAXIMO+ "\n");
 System.out.print("\tEl valor de la variable diasem es " + diasem+ "\n");
 System.out.print("\tEl valor de la variable diaanual es " + diaanual+ "\n");
 System.out.print("\tEl valor de la variable miliseg es " + miliseg+ "\n");
 System.out.print("\tEl valor de la variable totalfactura es " + totalfactura+ "\n");
 System.out.print("\tEl valor de la variable poblacion es " + poblacion+ "\n");
 System.out.print("\tEl valor de la variable sexo es "+ sexo.M+ "\n");
 
 
  //usando la orden printf
 totalfactura=10350.677734f; //modificamos el valor de totalfactura
 System.out.printf("\n----- EJERCICIO DE VARIABLES Y TIPO DE DATOS -----\n");
 System.out.printf("\tEl valor de la variable casado es " + casado + "\n");
 System.out.printf("\tEl valor de la variable MAXIMO es " + MAXIMO+ "\n");
 System.out.printf("\tEl valor de la variable diasem es " + diasem+ "\n");
 System.out.printf("\tEl valor de la variable diaanual es " + diaanual+ "\n");
 System.out.printf("\tEl valor de la variable miliseg es " + miliseg+ "\n");
 System.out.printf("\tEl valor de la variable totalfactura es " + totalfactura+ "\n");
 System.out.printf("\tEl valor de la variable totalfactura en notación cientifica es %1.6e%n",totalfactura);
 System.out.printf("\tEl valor de la variable poblacion es " + poblacion+ "\n");
 System.out.printf("\tEl valor de la variable sexo es "+ sexo.M);
} 

}    
    

