    
/**
 * Clase Meteoritos
 *
 * @author Saindell Sabrina Brenes Hernández C01309
 * @author Gabriel Bonilla Rivera C01252
 * @author Johana Wu Nie C08591
 * @version 09/10/2020
 */

import java.util.Arrays;

public class Meteorito {
    public static final int COLOR_NEGRO = 1;
    private int id;
    private int valor;
    private int peso;
    private String centroP;
    private int filaC;
    private int columnaC;
    private String centro;
    private int x;
    private int y;
    private int[][] matriz;
    

    
    public Meteorito(int id, int valor, int peso, int columna, int fila, int filaCentro, int columnaCentro) {
        this.filaC = filaCentro;
        this.columnaC = columnaCentro;
        this.id = id;
        this.valor = valor;
        this.peso = peso;
        matriz = new int[fila][columna];
        this.x = x;
        this.y = y;
        this.centroP = "("+filaC+","+columnaC+")";

    }
    
    

    public String punteroX() {
        String matriz2 = "";
    
        int mitadF = matriz.length/2;
        int mitadC = matriz[0].length/2;
        
    for (int fila = 0; fila < matriz.length; fila++) { 
            for (int columna = 0; columna < matriz[fila].length; columna++) {
                if (fila==0 || fila == matriz.length-1 ||  columna == 0 || columna == matriz[fila].length-1){
                    matriz[fila][columna]= COLOR_NEGRO;
                }
                
            }
             
        }
        
    for (int fila = 0; fila < matriz.length; fila++) { 
            for (int columna = 0; columna < matriz[fila].length; columna++) {
                if (fila== mitadF || columna == mitadC ){
                    matriz[fila][columna]= COLOR_NEGRO;
                }
                matriz2 += matriz[fila][columna] + " ";
            }
            matriz2 += "\n";
        }
        return matriz2;
    }
    
    public String centroMatriz(){
       
        if( matriz.length % 2 == 0 && matriz[0].length % 2 == 0 ){
              x = matriz.length/2;
              y =  matriz[0].length/2;
           }
       
       if( matriz.length % 2 != 0 && matriz[0].length % 2 == 0 ){
              x = (matriz.length-1)/2;
              y =  matriz[0].length/2;
           }
       
         if( matriz.length % 2 == 0 && matriz[0].length % 2 != 0 ){
              x = matriz.length/2;
              y = ( matriz[0].length-1)/2;
           }
           
            if( matriz.length % 2 != 0 && matriz[0].length % 2 != 0 ){
              x = (matriz.length-1)/2;
              y = ( matriz[0].length-1)/2;
           }
           centro = "("+x+","+y+")";
       return centro;
       }
    
    public void ver() {
        String matriz2 = "";
    
        int mitadF = matriz.length/2;
        int mitadC = matriz[0].length/2;
        
    for (int i = 0; i < matriz.length; i++) { 
            for (int columna = 0; columna < matriz[i].length; columna++) {
                if (i==0 || i == matriz.length-1 ||  columna == 0 || columna == matriz[i].length-1){
                    matriz[i][columna]= COLOR_NEGRO;
                }
                
            }
             
        }
        
    for (int i = 0; i < matriz.length; i++) { 
            for (int columna = 0; columna < matriz[i].length; columna++) {
                if (i== mitadF || columna == mitadC ){
                    matriz[i][columna]= COLOR_NEGRO;
                }
                 System.out.print(matriz[i][columna]+ " ");
            }
           System.out.println();
        }
        
    }
    /**
     * Efectua : el método toString, muestra un mensaje que enseña la información que contiene el atributo iD, valor, peso y centro de la clase Meteoritos
     * @return  String- mensaje: Meteorito [iD= iD, valor= valor, peso= peso, centro= centro]
     */
    public String toString() {
        return "Meteorito [iD=" + id + ", valor=" + valor + ", peso=" + peso + ", centro=" + centro+"]";
    }
    /**
     * Método para para conseguir el iD del la clase Meteorito
     *
     * @return int iD - ID del meteorito
     *
     */
    public int getId() {
        return id;
        }

/**
     * Método para para conseguir el valor de la clase Meteorito
     *
     * @return int valor - valor de la clase Meteorito
     *
     */
    public int getValor() {
        return valor;
    }
         /**
     * Método para modificar el valor de la clase Meteorito
     *
     * @param  valor -valor del meteorito
     *
     * Modifica : el valor del meteorito por el valor del parámetro
     */
    

    public void setValor(int valor) {
        this.valor = valor;
    }
/**
     * Método para para conseguir el eso de la clase Meteorito
     *
     * @return int peso - peso de la clase Meteorito
     *
*/
    public int getPeso() {
        return peso;
    }

  /**
     * Método para modificar el peso de la clase Meteorito
     *
     * @param  peso -peso del meteorito
     *
     * Modifica : el peso del meteorito por el valor del parámetro
     */
    public void setPeso(int peso) {
        this.peso = peso;
    }
/**
     * Método para para conseguir el tipo del la clase Cartas
     *
     * @return String tipo - tipo de la clase Cartas
     *
     */

    public String getCentro() {
        return centro;
    }

  /**
     * Método para modificar el centro de la clase Meteorito
     *
     * @param  centro -centro del meteorito en el Imagen
     *
     * Modifica : el centro del meteorito por el valor del parámetro
     */
    public void setCentro(String centro) {
        this.centro = centro;
    }

/**
     * Método para para conseguir el matriz de la clase Meteorito
     *
     * @return int matriz - matriz de la clase Meteorito
     *
     */  
    public int[][] getMatriz() {
        return matriz;
    }
/**
     * Método para modificar el matriz de la clase Meteorito
     *
     * @param  matriz -matriz del meteorito
     *
     * Modifica : el matriz del meteorito por el valor del parámetro
     */

    public void setMatriz(int[][] matriz) {
        this.matriz = matriz;
    }
    
    
public int getX() {
    return x;
}


public void setX(int x) {
    this.x = x;
}


public int getY() {
    return y;
}


public void setY(int y) {
    this.y = y;
}
  
}

