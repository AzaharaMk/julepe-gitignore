import java.util.Random;
public class Jugador
{
    // Guarda el nombre del jugador.
    private String nombre;
    //array que guarda las cartas.
    private Carta[]mano;
    //cartas que tiene el jugador en la mano.
    private int cartasDeMano;

    /**
     * Constructor for objects of class Jugador
     */
    public Jugador(String nombreJugador)
    {
         nombre = nombreJugador;
         mano = new Carta[5]; //array que permite guardar 5 cartas
         cartasDeMano = 0;
    }

    /**
     * Método que permite un parámetro de tipo Carta y hace que el jugador reciba una carta
     */
    public void recibirCarta(Carta nuevaCarta)
    {
        if (cartasDeMano < 5){
            mano[cartasDeMano] = nuevaCarta;
            cartasDeMano++;   
        }
    }
    
    /**
     * Método que imprime por pantalla las cartas del jugador, una por línea,
     * y que funcione tenga las cartas que tenga.
     */
    
    public void verCartasJugador()
    {
        for (int i = 0; i < mano.length; i++){ //for(Carta cartaActual:mano)
            if (mano[i] != null){
                System.out.println(mano[i]);    //System.out.println(cartaActual);
            }
        }
    }
    
    /**
     * Método que devuelve el nombre de los jugadores
     */
    public String getNombre() {
        return nombre;
    }
    
    
    /**
     * Método que admite un parámetro String que indica el nombre de la carta a tirar. 
     * Muestra por pantalla el nombre del jugador que ha tirado la carta y la carta tirada. 
     * Devuelve la carta tirada. En caso de que el jugador no tenga cartas o de que el nombre especificado 
     * como parámetro no coincida con ninguna carta, devuelve null
     */
    public Carta tirarCarta(String  nombreCarta)
    {
        Carta cartaTirada = null;
        
        //Miramos si tiene cartas en la mano.
        if(cartasDeMano > 0){
            //Bucle que se ejecute tantas veces como elementos tenga el array
            int cartaActual = 0;
            boolean buscando = true;
            while(cartaActual < mano.length){
               //comprueba que lo que está en la posicion sea diferente de null
               if(mano[cartaActual] !=null){
                /*Comprueba si la carta del array tiene el mismo nombre que la pasada
                por parámetro*/
                if(nombreCarta.equals(mano[cartaActual].toString())){
                    buscando = false;
                    cartaTirada = mano[cartaActual];
                    mano[cartaActual] = null;
                    cartasDeMano--;//Reduce en 1 las cartas que tiene el usuario en la mano
                    System.out.println(nombre + " ha tirado " +cartaTirada);
                }
                cartaActual++;
               }
            }
        }
        return cartaTirada;
    }
    
     /**
     * Método que muestra por pantalla el nombre del jugador que ha tirado la carta y la carta tirada. 
     * Devuelve la carta tirada. En caso de que el jugador no tenga cartas, devuelve null.
     */
    public Carta tirarCartaAleatoria()
    {
        Carta cartaTirada = null;
        //Comprueba si el jugador tiene cartas en la mano.
        if (cartasDeMano > 0){
            Random aleatorio = new Random();
            boolean elJugadorHaTiradoUnaCarta = false;
            //Bucle que se repita hasta que tire alguna carta.
            while(elJugadorHaTiradoUnaCarta == false){
                int posicionAleatoria = aleatorio.nextInt(5);
                // comprueba que el valor de posicionAleatoria es distinto de null
                if(mano[posicionAleatoria] != null){
                    cartaTirada = mano[posicionAleatoria];
                    mano[posicionAleatoria] = null;
                    cartasDeMano--;
                    System.out.println(nombre + " ha tirado " +cartaTirada);
                    elJugadorHaTiradoUnaCarta = true;
                }
            }
            
        }
        return cartaTirada;
        
    }
}

