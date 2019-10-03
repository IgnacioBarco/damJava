/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Nacho
 */
public class programa01 {

    static VentanaPrincipal aaa;
    static ReservaSalonPremium rsp;
    
    public static void main(String[] args) {
        // TODO code application logic here
        aaa = new VentanaPrincipal();
        aaa.setVisible(true);
        rsp = new ReservaSalonPremium();
    }
    
}
