/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Nacho
 */
public class Calculo {
   int numero, numDividido, numMaximo;
   int i = 0;
   int numDivisor = 2;
   String res="";
   boolean primo=false;
   
   public Calculo(int numero){
       this.numero=numero;
       }
   
   //calcula el numero maximo dividiendo entre dos el numero, redondeadolo y sumandole 1
   public int calculaMaximo(int a){
       numMaximo=Math.round((a/2)+1);
       return numMaximo;
   }
   
   public void factorizacion(){
        numMaximo=calculaMaximo(numero);
        numDividido=numero;
        etiqueta01:
        do{
           numDivisor=2;
           do{
             numMaximo=calculaMaximo(numDividido);
            
            //al cumplirse la condicion, divide al numero, añade resultado y resetea variables 
             if(numDividido%numDivisor==0){
                 System.out.println(numDividido+" | "+numDivisor);
                 numDividido=numDividido/numDivisor;
                 res=res+" "+numDivisor;
                 numDivisor=1;
                 numMaximo=calculaMaximo(numDividido);
                }
            
            //rompe el bucle cuando el numero divisor es mayor que el numero maximo 
             if (numDivisor>numMaximo){
                 res=res+" "+numDividido;
                 System.out.println(numDividido+" | "+numDividido);
                 System.out.println("1");
                 break etiqueta01;
                }
             
            //modifica el contador de los numeros por los que se divide
             switch (numDivisor){
                case 5: numDivisor=7;break;  
                case 3: numDivisor=5;break;
                case 2: numDivisor=3;break;  
                case 1: numDivisor=2;break;
                default:  
                    numDivisor+=2;
                    break;        
                }
                
            }while(true);
                   
            
           
        }while(true);
   }
   
   public void calculaPrimo(int numDivisor){
       this.numDivisor=numDivisor++;
       
   }
   
}
