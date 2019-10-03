/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Nacho
 */
public class Compara {
    int a,b,c;
    String res;
    
    public Compara(int a, int b, int c){
        this.a=a;
        this.b=b;
        this.c=c;       
    }
    
    public void condiciones(){
        
        if (a>=b && b>=c){
            res="El mayor numero introducido es "+a;
        }
        if (b>=c && c>=a){
            res="El mayor numero introducido es "+b;
        }
        if (c>=b && b>=a){
            res="El mayor numero introducido es "+c;
        }
        if (a==b && b==c){
            res="Los tres números introducidos, "+a+", son iguales";
            }
    }
        
    public String devuelve_resultado(){
        return res;
    } 
}
