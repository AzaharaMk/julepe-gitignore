import java.util.Random;
import java.util.ArrayList;
/**
 * Write a description of class Juego here.
 * 
 * @author Azahara
 * @version (a version number or a date)
 */
public class Juego
{
        //Array que guarda los jugadores
    private Jugador[] jugadores;
        //crear baraja llamando a la clase Mazo;
    private Mazo mazo;
        //Ultima carta que se reparte
    private Carta paloQuePinta;
    
    private int paloQuePinta2;
   
    /**
     * Constructor for objects of class Juego
     */
    public Juego(int numeroJugadores, String nombreJugadorHumano)
    {
            //se crea un objeto de tipo de mazo. la variable mazo hace una referencia al objeto.
        mazo = new Mazo();
        
            //guarda en el array el número de jugadores metido por parámetro.
        jugadores = new Jugador [numeroJugadores];
        
            //ArrayList que guarda los posibles nombres.Metemos nombre en el ArraList
        ArrayList<String> posiblesNombres = new ArrayList<String>();
        posiblesNombres.add ("María");
        posiblesNombres.add ("Alberto");
        posiblesNombres.add ("Laura");
        posiblesNombres.add ("Pepe");
        posiblesNombres.add ("Lorena");
        posiblesNombres.add ("Manuel");
        posiblesNombres.add ("Sonia");
        posiblesNombres.add ("Omar");
       
            //La primera posición del array tendrá el hombre del jugadorHumano
        Jugador jugadorHumano = new Jugador(nombreJugadorHumano);
        jugadores[0] = jugadorHumano;
            //String que da la bienvenida al jugador humano.
        System.out.println("Bienvenid@ a esta partida del julepe "+nombreJugadorHumano);
            //String que muestra los nombres aleatorios.
            System.out.println("Tus rivales son: ");
        
            //creación de variable de tipo Random;
        Random aleatorio = new Random();
        
            //Bucle que se repite tantas veces como número de jugadores.
        for(int i = 1; i < numeroJugadores; i++){
            /**
             * numero aleatorio entre 0 y el numero de elementos del arraylist.
             * Al borrar un nombre se debe cambiar la posicion para que no quede un lugar vacio
             */
            int posicionNombreElegido = aleatorio.nextInt(posiblesNombres.size());
                //variable que guarde el nombre de aleatorio
            String nombreAleatorio = posiblesNombres.get(posicionNombreElegido);
                //eliminamos el nombre del ArrayList para que no se repitan.
            posiblesNombres.remove(posicionNombreElegido);
                //Variable local de tipo jugador
            Jugador jugador = new Jugador(nombreAleatorio);
                //guarda los jugadores en el array
            jugadores [i] = jugador;
            //muestra el nombre de los jugadores aleatorios
            System.out.println(nombreAleatorio);
        }
    }
    
    /**
     * Método llamado repartir que coge el mazo y da 5 cartas a los jugadores creados. 
     * La entrega de cartas debe ser al estilo del reparto que se hace en la realidad,es decir,
     * primero se baraja y luego se entrega una carta a cada jugador. 
     * La última carta entregada indica el palo que pinta, que debe registrarse de alguna foma.
     */
    public int repartir()
    {
        mazo.barajar();
        Carta nuevaCarta = null;
        for (int cartaARepartir = 0; cartaARepartir <5; cartaARepartir++){
            
           for (int jugadorActual = 0; jugadorActual < jugadores.length; jugadorActual++){
               nuevaCarta = mazo.sacarCarta();
               jugadores[jugadorActual].recibirCarta(nuevaCarta);
            }
        }
        paloQuePinta2 = nuevaCarta.getPaloCarta();
        
        switch(paloQuePinta2){
            case 0:
                System.out.println("Pintan oros");
                break;
            case 1:
                System.out.println("Pintan copas");
                break;
            case 2:
                System.out.println("Pintan espadas");
                break;
            case 3:
                System.out.println("Pintan bastos");
                break;
            
        }
        jugadores[0].verCartasJugador();
        return paloQuePinta2;
    }
    /*
     * public void repartir()
    {
            //baraja el mazo.
        mazo.barajar();
        int cont = 0;
            //Reparte una carta a cada jugador 5 veces.
        while (cont <5){
                //Da una carta a cada jugador.
            for( Jugador jugador:jugadores){
                    //guardda en una variable una carta extraida del mazo
                Carta cartaGuardada = mazo.sacarCarta();
                    //Da a cada jugador una carta
                jugador.recibirCarta(cartaGuardada);
                    //Varibale en la que se guarda la última carta que será la que pinta.
                paloQuePinta = cartaGuardada;
            }
            cont++;
        }
    } 
     */
    /**
     * Método que muestra las cartas del jugador metido por parámetro
     */
    
    public void hacerTrampasYVerCartasDeJugador(String nombreJugador)
    {
        for (int i = 0; i < jugadores.length; i++){
            
            if(nombreJugador.equals(jugadores[i].getNombre())){
              jugadores[i].verCartasJugador();
            }
        }
    }
    /*
     * public void hacerTrampasYVerCartasDeJugador(String nombre) {
        boolean buscando = true;
        int pos = 0;
        while(pos < jugadores.length && buscando) {
            if (jugadores[pos].getNombre().equals(nombre)){
                System.out.println("El jugador "+nombre+" tiene");
                jugadores[pos].verCartasJugador();
                buscando = false;
            }
            pos++;
        }
    }
     */
    /**
     * Método que muestra las cartas que tiene el jugador Humano.
     */
    
    public void verCartasJugadorHumano()
    {
        jugadores[0].verCartasJugador();
    }
}