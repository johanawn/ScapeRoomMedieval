
    
/**
 * Clase Interfaz
 *
 * @author Saindell Sabrina Brenes Hernández C01309
 * @author Gabriel Bonilla Rivera C01252
 * @author Johana Wu Nie C08591
 * @version 09/11/2020
 */
import java.util.Scanner;
import javax.swing.*;
public class Interfaz{
    private Scanner lector;
    /**
     * Constructor sin parámetros
     */
    public Interfaz(){
        lector = new Scanner(System.in);
    }
    /**
     * El método bienvenida imprime la historia y el propósito del jugador en el programa
     */
    public void bienvenida(){
        System.out.println("Bienvenido al cudrante 7 cercano a la Nebulosa de Orión, eres el capitán de una nave de exploración espacial.\nUna estrella se encuentra al borde del colapso.\nPor lo que fuiste enviado en una misión para rescatar la mayor cantidad de asteroides en el cuadrante, ya que no se podrá volver a esa parte de la galaxia en mucho tiempo.");
    }
    /**
     * El método pedirCapacidadMaxima pide al usuario que inserte un número que será asignado como la capacidadMaxima de la nave 
     * @return capacidad Máxima - capacidad máxima de la nave
     */
    public int pedirCapacidadMaxima(){
        int capacidadMaxima = 0;
        System.out.print("Tu nave, la U.S.S RedWind, tiene una capacidad de carga en toneladas de: ");
        try{
            capacidadMaxima = lector.nextInt();
            if(capacidadMaxima < 0){
                capacidadMaxima *= -1;
            }
            else{
                if(capacidadMaxima == 0){
                    capacidadMaxima = 2000;
                }
            }
        }
        catch(Exception e){
            capacidadMaxima = 2000;
        }
        return capacidadMaxima;
    }
    /**
     * El método mostrarSeleccion imprime un mensaje y muestra la imagen de la matriz imagen insertado
     * @param imagen - matriz 
     */
    public void mostrarSeleccion(int [][] imagen){
        System.out.println("Después de arduos estudios realizados a los meteoritos del sector, has decidido junto a tus tripulantes que los meteoritos más valiosos son: ");
        Imagen imagen1 = new Imagen(imagen);
        imagen1.dibujar();
        
    }
    /**
     * 
     * El método mostrarInventarioDeLaNave imprime un mensaje y lo que se encuentra en el parámetro. 
     * 
     * @param inventario - información del inventario de carga de la nave
     */
    public void mostrarInventarioDeLaNave(String inventario){
        System.out.println("Ya recuperados los meteoritos con el rayo tractor de la RedWind, el comandante le hace entrega del nuevo inventario de la nave que comtempla los meteoritos.");
        System.out.print(inventario);
    }
}
