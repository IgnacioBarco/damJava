/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Nacho
 */
public class Consulta {
    
    short mes, dias;
    int año;

    public Consulta(short mes, int año){
        this.mes=mes;
        this.año=año;
        
    }
    
    public void calcula_Dias(){
        switch (mes){
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                dias = 31;
                break;            
            case 4: case 6: case 9: case 11:
                dias = 30;
                break;
            case 2:
                if (año%4!=0){ //si el año no es multiplo de 4, dias es 28
                dias=28;
                }else{
                    if (año%100==0 && año%400==0){ //si es multiplo de 100 y 400, dias vale 28
                        dias=28;
                    } else dias=29; //en el resto de casos es bisiesto y vale 29
                }
                break;
            default:
            }
    }
    
    public short devuelve_Dias(){
        return dias;
    }
}
