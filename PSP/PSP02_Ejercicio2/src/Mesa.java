
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Nacho
 */
public class Mesa {

    Semaphore semaforoMesa;
    Semaphore palillo1;
    Semaphore palillo2;
    Semaphore palillo3;
    Semaphore palillo4;
    Semaphore palillo5;
    int filosofo;
    

    public Mesa() {

        //creamos los semaforos
        semaforoMesa = new Semaphore(2, true);
        palillo1 = new Semaphore(1, true);
        palillo2 = new Semaphore(1, true);
        palillo3 = new Semaphore(1, true);
        palillo4 = new Semaphore(1, true);
        palillo5 = new Semaphore(1, true);

    }

    /**
     * realizamos la accion de comer
     * @param filosofo identifica el filosofo que come
     */
    public void comer(int filosofo) {

        //solicitamos permiso de de acceso
        try {
            semaforoMesa.acquire();
        } catch (InterruptedException ex) {
            System.out.println("Fallo al obtener el semaro mesa: " + ex);
        }

        //metodo auxiliar para que quede mas claro el programa
        comer2(filosofo);

        //liberamos el semaforo
        semaforoMesa.release();
    }

    /**
     * duerme 3 segundos
     * @param filosofo identifica al filosofo que duerme
     */
    public void pensar(int filosofo) {

        try {
            System.out.println("Filosofo " + filosofo + " pensando");
            Thread.sleep(3000);
        } catch (InterruptedException ex) {
            System.out.println("Fallo al intentar pensar: " + ex);
        }
    }

    /**
     * Identificamos el filosofo. 
     * Solicitamos acceso al palillo de la derecha:
     *     * Si obtenemos permiso, solicitamos el acceso al palillo de la izquierda
     *          * Si tenemos los dos permisos, comemos durante 2 sg 
     *              y liberamos los semaforos de los palillos
     *          * Si no obtenemos el segundo permiso, liberamos el  
     *              palillo de la derecha(seguiria pensando)
     *     * Si no nos da permiso el primer palillo no hacemos nada(seguiria pensando) 
     * 
     * @param filosofo identifica el filosofo que intenta comer
     */
    public void comer2(int filosofo) {
        if (filosofo == 1) {
            if (palillo5.tryAcquire()) {
                if (palillo1.tryAcquire()) {
                    try {
                        System.out.println("filosofo " + filosofo + " empieza a comer");
                        Thread.sleep(2000);
                        System.out.println("filosofo " + filosofo + " termina de comer");
                        palillo5.release();
                        palillo1.release();
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Mesa.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    palillo5.release();
                }
            }

        }
        if (filosofo == 2) {
            if (palillo1.tryAcquire()) {
                if (palillo2.tryAcquire()) {
                    try {
                        System.out.println("filosofo " + filosofo + " empieza a comer");
                        Thread.sleep(2000);
                        System.out.println("filosofo " + filosofo + " termina de comer");
                        palillo2.release();
                        palillo1.release();
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Mesa.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    palillo1.release();
                }
            }

        }
        if (filosofo == 3) {
            if (palillo2.tryAcquire()) {
                if (palillo3.tryAcquire()) {
                    try {
                        System.out.println("filosofo " + filosofo + " empieza a comer");
                        Thread.sleep(2000);
                        System.out.println("filosofo " + filosofo + " termina de comer");
                        palillo3.release();
                        palillo2.release();
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Mesa.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    palillo2.release();
                }
            }

        }
        if (filosofo == 4) {
            if (palillo3.tryAcquire()) {
                if (palillo4.tryAcquire()) {
                    try {
                        System.out.println("filosofo " + filosofo + " empieza a comer");
                        Thread.sleep(2000);
                        System.out.println("filosofo " + filosofo + " termina de comer");
                        palillo4.release();
                        palillo3.release();
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Mesa.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    palillo3.release();
                }
            }

        }
        if (filosofo == 5) {
            if (palillo4.tryAcquire()) {
                if (palillo5.tryAcquire()) {
                    try {
                        System.out.println("filosofo " + filosofo + " empieza a comer");
                        Thread.sleep(2000);
                        System.out.println("filosofo " + filosofo + " termina de comer");
                        palillo5.release();
                        palillo4.release();
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Mesa.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    palillo4.release();
                }
            }

        }
    }
}
