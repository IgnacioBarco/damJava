/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Nacho
 */
public class Productor extends Thread{
    
    Bufer bufer;
    
    public Productor(Bufer bufer){
        
        this.bufer=bufer;
        
    }
    
    public void run(){
        
        for (int i=0; i<15; i++){
            bufer.meterDato("x"+(i+1), 14-i);            
        }
        
        
    }
}
