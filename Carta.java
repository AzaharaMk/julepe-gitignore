
/**
 * Write a description of class Carta here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Carta
{
    // Valor de la carta; de 1 a 7 y de 10 a 12
    private int carta;
    //valor del palo: 0
    private int palo;

    /**
     * Constructor for objects of class Carta
     */
    public Carta(int valorCarta, int paloCarta)
    {
        carta = valorCarta;
        palo = paloCarta;
        
    }
    
    /**
     * Devuelve el valor de la carta y el palo
     */
    public String toString()
    {
       String textoPalo="";
        //muestra el palo de la carta según el valor introducido en el parámetro palo
       switch (palo)
        {
            case 0:
                textoPalo = " de oros";
                break;
            
            case 1:
                textoPalo =" de copas";
                break;
            
            case 2:
                textoPalo= " de espadas";
                break;
            
            case 3: 
                textoPalo = " de bastos";
                break;
        }
        
       String textoCarta = "" +carta;
       //muestra el nombre de la carta, teniendo en cuenta que el 1 es as, 10 sota, 11 caballo y 12 rey.
       switch (carta)
       {
           case 1:
                textoCarta ="as";
                break;
           
           case 10:
                textoCarta ="sota";
                break;
           
           case 11:
                textoCarta ="caballo";
                break;
           
           case 12:
                textoCarta ="rey";
                break;
       }
       return textoCarta + textoPalo;
    }
   
    public int getValorCarta()
    {
        return carta;
    }
    
    public int getPaloCarta()
    {
        return palo;
    }
    
    /**
     *  Exista un método llamado ganaA que reciba un parámetro de tipo Carta y un parámetro de tipo entero que indica el palo que pinta. 
     *  El método devuelve true en caso de que la carta sea superior a la carta pasada como parámetro conforme a las reglas del tute 
     *  y false en caso contrario.
     */
    
    public boolean ganaA(Carta cartaAComparar, int paloQuePinta)
    {
        boolean cartaGanadora = false;
        if (this.palo == cartaAComparar.getPaloCarta()){
            if(carta < cartaAComparar.getValorCarta()){
                    // En caso de que tengan el mismo palo...
                if (getPosicionEscalaTute() > cartaAComparar.getPosicionEscalaTute()) {
                    cartaGanadora = true;
                }
            } 
        
        else {
                    //En caso de que tengan distinto palo...
                if(cartaAComparar.getPaloCarta() != paloQuePinta){
                    cartaGanadora =  true;
                }
            }
       }
        return cartaGanadora;
    }
    
    /**
     * Método que devuelva el valor de la carta conforme el tute
     */
    public int getPosicionEscalaTute(){
        // inicializamos al valor de la carta
        int posicion = carta;
        if(carta == 3){
            posicion = 13;
        }
        else if (carta == 1){
            posicion = 14;
        }
        return posicion;
    }
}
