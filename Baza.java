import java.util.*;
/**
 * Write a description of class Baza here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Baza
{
    // numero de jugadores
    private int numeroJugadores;
    //palo que pinta
    private int paloQuePintaCartaTirada;
    //Array que guarda los jugadores
    private Jugador[] jugadores;
    //Array que guarda las cartas.
    private Carta[] baza;
    private int contadorBaza;
    
    /**
     *  Constructor que admita dos parametros. 
     *  El primero es un entero que indica el número de jugadores que van a tirar carta 
     *  y el segundo es otro entero que indica el palo que pinta.
     */
    public Baza(int numeroDeJugadores,int paloQuePinta)
    {
       numeroJugadores = numeroDeJugadores;
       paloQuePintaCartaTirada = paloQuePintaCartaTirada;
       jugadores = new Jugador[numeroDeJugadores];
       baza = new Carta[numeroDeJugadores];
       contadorBaza = 0;
    }
    
    /**
     * Admite un parámetro de tipo Carta y un segundo parámetro de tipo String. 
     * El primer parámetro representa la carta que tira un jugador a la mesa y que, 
     * por tanto, se añade a la baza. No hace falta comprobar que la carta añadida 
     * sea o no null, se supone que es una carta. El segundo parámetro indica el 
     * nombre del jugador que tiro la carta. El método no devuelve nada
     */
    public void addCarta(Carta cartaTirada, String nombreJugador)
    {
        if (contadorBaza < numeroJugadores)
        {
            //guarda la carta tirada en el array
            baza[contadorBaza]=cartaTirada;
            contadorBaza++;
        }
    }
    
    /**
     * Tenga un método llamado getPaloPrimeraCartaDeLaBaza sin parámetros que devuelva un entero que 
     * representa el palo de la primera carta añadida a la baza o -1 en caso de que no se haya añadido aún ninguna carta.
     */
    public int getPaloPrimeraCartaDeLaBaza()
    {
        int posicionCarta= -1;
        if (baza[0] != null)
        {
            posicionCarta = baza[0].getPaloCarta();
        }
        return posicionCarta;
    }
}
