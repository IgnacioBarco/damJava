package numeros;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Nacho
 */
public class Complejo {
   double numero;
   double real;
   double imag;
   
   public Complejo(){
       numero=0.0d;
       real=0.0d;
       imag=0.0d;
   }
   
   public Complejo(double real, double imag){
       this.real=real;
       this.imag=imag;
   }
   
   public double consulta_Real(){
       return real;
   }
   
   public double consulta_Imag(){
       return imag;
   }
   
   public void cambia_Real(double real){
       this.real=real;
   }
   
   public void cambia_Imag(double imag){
       this.imag=imag;
   }
   
   public String toString(){
       if (imag < 0){
           return real+" - "+Math.abs(imag)+"i";
       }
       else return real+" + "+imag+"i";
       
   }
   
   public void sumar(Complejo b){
       this.real=this.real+b.real;
       this.imag=this.imag+b.imag;
   }


}
