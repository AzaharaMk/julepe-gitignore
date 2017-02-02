import java.util.ArrayList;
import java.util.Random;
/**
 * Write a description of class Mazo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Mazo
{
    private ArrayList <Carta> mazo;

    /**
     * El constructor de la clase Mazo debe encargrse de crear las 40 cartas de la baraja española. 
     * Crear un método toString que muestra linea a linea todas los nombres de las cartas existentes en el mazo.
     */
    /**
     * Constructor que se encargar de guardar las 40 cartas
     * excluyendo el 8 y el 9
     */
    public Mazo()
    {
        mazo = new ArrayList<Carta>();
        //recorre los palos de la baraja
       for(int valorPalo = 0; valorPalo < 4; valorPalo++){
            //Recorre el valor de las cartas excluyendo el 8  y el 9
           for(int valorCarta = 1; valorCarta <= 12; valorCarta++){
               if (valorCarta != 8 && valorCarta != 9){
                   mazo.add(new Carta(valorCarta,valorPalo));
               }
           }
       }
    }
    
    /**
     * Método que muestra línea a línea todos los nombres de las cartas
     * existentes en el mazo.
     */
    
    public void verCartasDelMazo()
    {
        for(int i = 0; i < mazo.size(); i++){
            System.out.println(mazo.get(i));
        }
    }
    
    /**
     * Método que no devuelve nada y consigue mezclar las cartas existentes en ese momento en el mazo
     */
    public void barajar()
    {
            //Recorre todas las cartas y para cada carta la cambia por una aleatoria
        for(int posicionActual = 0; posicionActual < mazo.size(); posicionActual++){
                //Se extrae una carta del arraylist y se guarda en una variable
            Carta carta1 = mazo.get(posicionActual);
                // variable que guarda un número aleatorio de la baraja
            Random aleatorio = new Random();
            int posicionAleatoria = aleatorio.nextInt(mazo.size());
                //intercambia la carta actual por una aleatoria
            mazo.set(posicionActual, mazo.get(posicionAleatoria));
            mazo.set(posicionAleatoria,carta1);
        }
    }
    
    /**
     * Método que devuelve un objeto Carta.
     * Devuelve la primera carta del mazo, eliminando esta del mazo.
     */
    public Carta sacarCarta()
    {
        //Si no hay cartas en el mazo devolverá null
        Carta cartaASacar = null;
        //Comprueba si existen cartas en el arrayList
        if (mazo.size() > 0){
            cartaASacar = mazo.remove(0);
        }
        return cartaASacar;
    }
    
    
}
