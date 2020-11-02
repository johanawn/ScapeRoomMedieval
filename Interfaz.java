
/**
 * Write a description of class Interfaz here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.Scanner;
import javax.swing.*;
public class Interfaz{
    private Scanner lector;
    
    public Interfaz(){
        lector = new Scanner(System.in);
    }
    public void bienvenida(){
        System.out.println("Bienvenido al cudrante 7 cercano a la Nebulosa de Orión, eres el capitán de una nave de exploración espacial.\n Una estrella se encuentra al borde del colapso, por lo que fuiste enviado en una misión para rescatar la mayor cantidad de asteroides en el cuadrante, ya que no se podrá volver a esa parte de la galaxia en mucho tiempo.");
    }
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
    public void mostrarSeleccion(int [][] imagen){
        System.out.println("Después de arduos estudios realizados a los meteoritos del sector, has decidido junto a tus tripulantes que los meteoritos más valiosos son: ");
        Imagen imagen1 = new Imagen(imagen);
        imagen1.dibujar();
        
    }
    public void mostrarInventarioDeLaNave(String inventario){
        System.out.println("Ya recuperados los meteoritos con el rayo tractor de la RedWind, el comadante le hace entrega del nuevo inventario de la nave que comtempla los meteoritos.");
        System.out.print(inventario);
    }
}
