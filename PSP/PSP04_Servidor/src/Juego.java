/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Usuario
 */
public class Juego {

    int[] baraja;
    boolean ver = true;
    String res = "";
    String cartaJ = "";
    String cartaB = "";
    int cartaJugador = -1;
    int cartaBanca = -1;
    int jugadas;
    int a;
    boolean ganadorBanca;

    public Juego() {
        //creamos una nueva baraja
        baraja = new int[51];
        inicializarBaraja();
        jugadas = 0;

    }

    /**
     * ponemos todas las cartas a 1
     */
    public void inicializarBaraja() {
        for (int i = 0; i < 51; i++) {
            baraja[i] = 1;
        }
    }

    /**
     * sacamos una carta aleatoria, si ya la hemos usado, volvemos a sacar otra
     *
     * @return devolvemos el numero de la carta
     */
    public int sacarCarta() {
        ver = true;

        do {

            a = (int) (Math.random() * 51);

            if (baraja[a] == 1) {
                baraja[a] = 0; //carta usada
                ver = false;
            }

        } while (ver);

        return a;
    }

    /**
     * calculamos que carta es
     *
     * @param numeroCarta el numero de carta
     * @return devolvemos el valor de la carta
     */
    public String carta(int numeroCarta) {
        res = "";
        //2, 3, 4, 5, 6, 7, 8, 9, 10, J, Q, K, AS
        switch (numeroCarta) {
            case 0:
                res = "Dos";
                break;
            case 1:
                res = "Tres";
                break;
            case 2:
                res = "Cuatro";
                break;
            case 3:
                res = "Cinco";
                break;
            case 4:
                res = "Seis";
                break;
            case 5:
                res = "Siete";
                break;
            case 6:
                res = "Ocho";
                break;
            case 7:
                res = "Nueve";
                break;
            case 8:
                res = "Diez";
                break;
            case 9:
                res = "Sota";
                break;
            case 10:
                res = "Caballo";
                break;
            case 11:
                res = "Rey";
                break;
            case 12:
                res = "As";
                break;
        }
        return res;
    }

    /**
     * calculamos el palo
     *
     * @param carta el numero de la carta
     * @return devolvemos el palo que es
     */
    public String textoCarta(int carta) {
        res = "";
        if (carta <= 12) {

            return carta(carta) + " de picas";

        } else if (carta <= 25) {

            return carta(carta - 13) + " de corazones";

        } else if (carta <= 38) {

            return carta(carta - 26) + " de diamantes";

        } else if (carta > 38) {

            return carta(carta - 39) + " de treboles";

        }

        return res;
    }

    /**
     * comparamos las cartas mediante su modulo
     *
     * @param cartaJugador la carta del jugador
     * @param cartaBanca la carta de la banca
     * @return devolvemos quien gana
     */
    public String compararCartas(int cartaJugador, int cartaBanca) {
        if ((cartaJugador % 13) > (cartaBanca % 13)) {
            ganadorBanca = false;
            return "Gana el jugador";
        } else {
            ganadorBanca = true;
            return "Gana la Banca";
        }

    }

    /**
     * recrea una partida
     *
     * @return devuelve el resultado
     */
    public String jugar() {
        res = "";

        //si llevamos 26 jugadas, "cogemos" una baraja nueva, inicializandola
        if (jugadas == 26) {
            inicializarBaraja();
            jugadas = 0;
        }

        //sacamos las cartas
        cartaJugador = sacarCarta();
        cartaJ = textoCarta(cartaJugador);
        cartaBanca = sacarCarta();
        cartaB = textoCarta(cartaBanca);

        //aumentamos las jugadas hechas
        jugadas++;

        return "El jugador ha sacado la carta " + cartaJ
                + "\nLa banca ha sacado la carta " + cartaB
                + "\n" + compararCartas(cartaJugador, cartaBanca);
    }

}
