    
    
/**
 * Clase Meteoritos
 *
 * @author Saindell Sabrina Brenes Hernández C01309
 * @author Gabriel Bonilla Rivera C01252
 * @author Johana Wu Nie C08591
 * @version 09/11/2020
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
    private int[] columnas;
    private int[] filas;
    
/**
 * Constructor con parámetros
 * @param id - ID del meteorito
 * @param valor - valor del meteorito
 * @param peso - peso del meteorito
 * @param filaCentro - la fila que corresponde al centro del meteorito
 * @param columnaCentro - la columna que corresponde al centro del meteorito
 */
    
    public Meteorito(int id, int valor, int peso,  int filaCentro, int columnaCentro) {
        this.filaC = filaCentro;
        this.columnaC = columnaCentro;
        this.id = id;
        this.valor = valor;
        this.peso = peso;  
        this.centroP = "("+filaC+","+columnaC+")";

    }
    /**
     * Constructor sin parámetros
     */
    public Meteorito(){
        setID(-1);
        setValor(0);
        setPeso(0);
        setColumnaC(-1);
        setFilaC(-1);
       
    }
    

    /**
	 * Efectua : el método toString2, muestra un mensaje que enseña la información que contiene el atributo iD, valor, peso y centro de la clase Meteoritos
	 * @return  String- mensaje: iD+"\t"+valor+"\t"+peso+"\t"+centro+"\n";
	 */
		public String toString2() {
		return id+"\t"+valor+"\t"+peso+"\t ("+filaC+")\t("+columnaC+")\n";
	}
    /**
     * Efectua : el método toString, muestra un mensaje que enseña la información que contiene el atributo iD, valor, peso y centro de la clase Meteoritos
     * @return  String- mensaje: Meteorito [iD= iD, valor= valor, peso= peso, centro= centro]
     */
    public String toString() {
        return "Meteorito [iD=" + id + ", valor=" + valor + ", peso=" + peso + ", centro=" + filaC+" , "+columnaC+"]";
    }
    /**
     * Método para para conseguir el iD del la clase Meteorito
     *
     * @return id - ID del meteorito
     *
     */
    public int getID() {
        return id;
        }

/**
     * Método para para conseguir el valor de la clase Meteorito
     *
     * @return valor - valor de la clase Meteorito
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
     * @return peso - peso de la clase Meteorito
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
     * @return tipo - tipo de la clase Cartas
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
 * Método para modificar el id de la clase Meteorito
 * @param id - ID del meteorito
 */
    public void setID(int id) {
        this.id = id;
    }
    /**
 * Método para modificar la filaC de la clase Meteorito
 * @param filaC - fila del centro del meteorito de la clase Resultados
 */
    public void setFilaC(int filaC) {
        this.filaC = filaC;
    }
 /**
 * Método para modificar la ColumnaC de la clase Meteorito
 * @param columnaC - columnaC del centro del meteorito de la clase Resultados
 */
    public void setColumnaC(int columnaC) {
        this.columnaC = columnaC;
    }

   /**
   * Método para conseguir la filaC del la Meteorito
   * @return filaC - fila del centro del meteorito 
   */
    public int getFilaC(){
        return filaC;
    }
     /**
   * Método para conseguir la columnaC del la Meteorito
   * @return columnaC - columna del centro del meteorito 
   */
    public int getColumnaC(){
        return columnaC;
    }


  
}
