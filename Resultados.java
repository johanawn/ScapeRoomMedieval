
 
    import java.io.*;
public class Resultados {
    
    
    
    private File file;
    private FileWriter writer; //objeto para escribir datos en el archivo
    private BufferedWriter buffered; 
    private PrintWriter print;
    private Meteorito meteoritos [];
    private Nave nave;
    /**
     * Constructor sin parámetro de la clase Resultados
     */
    public Resultados(){
    	
    	setBuffered(null);
    	setFile(null);
    	setMeteoritos(null);
    	setNave(null);
    	setPrint(null);
    	setWriter(null);
    
    }
    /**
     * Constructor con parámetro de la clase Resultados
     * @param meteoritos -los meteoritos de la imagen
     */
         public Resultados( Meteorito [] meteoritos){
            this.meteoritos = meteoritos;
        }
         /**
          * El método swap intercambia la posición de los meteoritos
          * @param i -indice
          * @param j -indice
          * @param meteoritos -los meteoritos de la imagen
          */
       private void swap(int i, int j, Meteorito [] meteoritos){
           Meteorito temp = meteoritos[i];
           meteoritos[i]=meteoritos[j];
           meteoritos[j]=temp;
        }
       /**
        * El método ordenar ordena las posiciones de los meteoritos, de mayor a menor valor, y si es del mismo valor de menor a mayor peso
        * @param meteoritos -los meteoritos de la clase Meteorito
        */
        public void ordenar(Meteorito [] meteoritos){
           for(int i=0; i<meteoritos.length; ++i){
              for(int j=0; j<(meteoritos.length-1); ++j){
                 if(meteoritos[j].getValor() < meteoritos[j+1].getValor()){
                    swap(j,j+1, meteoritos);   
                 }else if (meteoritos[j].getValor() == meteoritos[j+1].getValor()) {
                     
                     if(meteoritos[j].getPeso() > meteoritos[j+1].getPeso()) {   
                         swap(j,j+1, meteoritos);    
                     }
                     
                     
                 }
              }
           }
        }
        
        /**
         * El método texto crea un archivo con la información del inventario de carga de la nave, también llama al método ordenar para ordenar la posición de los meteoritos seleccionados
         * @param nombreArchivo -nombre de archivo
         * @param meteoritos-los meteoritos de la imagen
         * @param nave - nave del jugador
         */
public void texto(String nombreArchivo, Meteorito [] meteoritos, Nave nave) {
      try{
          file = new File(nombreArchivo);
          writer = new FileWriter(file);
          buffered = new BufferedWriter(writer);
          print = new PrintWriter(buffered);
          boolean noHaySeleccion = true;
          for(int x = 0; x < meteoritos.length; x++){
              if(nave.getMeteoritosSeleccionados()[x] != -1){
                  noHaySeleccion = false;
                }
            }
            if(noHaySeleccion == true){
                print.println("\tINVENTARIO DE CARGA DE LA NAVE\t");
                print.println("\nCapacidad Máxima: "+nave.getCapacidadMaxima() + "\tCarga Actual: "+nave.getCargaActual()+"\tValor de la carga: "+nave.getValorActual());
                print.println( "\nNingún meteorito pudo ser seleccionado ya que la capacidad de la nave es demasiado pequeña para cargar alguno.");
            }
            else{
                print.println("\tINVENTARIO DE CARGA DE LA NAVE\t");
                print.println("\nCapacidad Máxima: "+nave.getCapacidadMaxima() + "\tCarga Actual: "+nave.getCargaActual()+"\tValor de la carga: "+nave.getValorActual());
                print.println("\n");
                print.println( "ID\tValor\tPeso\t(Fila, Columna)del Centro de la imagen en el mapa\n");
                ordenar(meteoritos);
                for(int i = 0; i < meteoritos.length; i++){
                    for(int j = 0; j < meteoritos.length; j++){
                        if(meteoritos[i].getID() == nave.getMeteoritosSeleccionados()[j]){
                            print.println(meteoritos[i].toString2());
                        }
                    }
                }
            }
            print.print("");
            print.close();
            buffered.close();

        } 
        catch(Exception e) {
       
            System.out.println("Hubo un error...");
       
        }
   
  }

  
  /**
   * El método texto crea un  con la información del inventario de carga de la nave, también llama al método ordenar para ordenar la posición de los meteoritos seleccionados
   * @param meteoritos -meteoritos de la imagen
   * @param nave -nave del jugador 
   * @return hilera- Información del inventario de la carga de la nave
   */
  
  public String mostrar(Meteorito [] meteoritos, Nave nave) {
       String hilera = "";
       boolean noHaySeleccion = true;
       hilera+="\tINVENTARIO DE CARGA DE LA NAVE\t";
       hilera+="\nCapacidad Máxima: "+nave.getCapacidadMaxima() + "\tCarga Actual: "+nave.getCargaActual()+"\tValor de la carga: "+nave.getValorActual();
       hilera+= "\nID\tValor\tPeso\t(Fila, Columna)del Centro de la imagen en el mapa\n";
      ordenar(meteoritos);
        for(int i = 0; i < meteoritos.length; i++){
            for(int j = 0; j < meteoritos.length; j++){
                if(meteoritos[i].getID() == nave.getMeteoritosSeleccionados()[j]){
                    hilera+=meteoritos[i].toString2();
                }
            }
        }
        for(int x = 0; x < meteoritos.length; x++){
            if(nave.getMeteoritosSeleccionados()[x] != -1){
                noHaySeleccion = false;
            }
        }
        if(noHaySeleccion == true){
            hilera = "";
            hilera+="\tINVENTARIO DE CARGA DE LA NAVE\t";
            hilera+="\nCapacidad Máxima: "+nave.getCapacidadMaxima() + "\tCarga Actual: "+nave.getCargaActual()+"\tValor de la carga: "+nave.getValorActual();
            hilera+= "\nNingún meteorito pudo ser seleccionado ya que la capacidad de la nave es demasiado pequeña para cargar alguno.";
        }
       return hilera;
  }
  /**
   * Método para conseguir la file del la Resultados
   * @return file - file de la clase Resultados
   */
public File getFile() {
	return file;
}
/**
 * Método para modificar el file de la clase Resultados
 * @param file - file de la clase Resultados
 */
public void setFile(File file) {
	this.file = file;
}
  /**
   * Método para conseguir la writer del la Resultados
   * @return writer - FileWriter de la clase Resultados
   */
public FileWriter getWriter() {
	return writer;
}
/**
 * Método para modificar el writer de la clase Resultados
 * @param writer - FileWriter de la clase Resultados
 */
public void setWriter(FileWriter writer) {
	this.writer = writer;
}
 /**
   * Método para conseguir la buffered del la clase Resultados
   * @return buffered - BufferedWriter de la clase Resultados
   */
public BufferedWriter getBuffered() {
	return buffered;
}
/**
 * Método para modificar el buffered de la clase Resultados
 * @param buffered - BufferedWriter de la clase Resultados
 */
public void setBuffered(BufferedWriter buffered) {
	this.buffered = buffered;
}
 /**
   * Método para conseguir la print del la clase Resultados
   * @return print - PrintWriter de la clase Resultados
   */
public PrintWriter getPrint() {
	return print;
}
/**
 * Método para modificar el print de la clase Resultados
 * @param print - PrintWriter de la clase Resultados
 */
public void setPrint(PrintWriter print) {
	this.print = print;
}
 /**
   * Método para conseguir los meteoritos del la clase Meteorito
   * @return meteoritos - meteoritos de la imagen
   */
public Meteorito[] getMeteoritos() {
	return meteoritos;
}
/**
 * Método para modificar los meteoritos de la clase Meteoritos
 * @param meteoritos - meteoritos de la imagen
 */
public void setMeteoritos(Meteorito[] meteoritos) {
	this.meteoritos = meteoritos;
}
 /**
   * Método para conseguir la nave del la clase Nave
   * @return nave - nave del jugador
   */
public Nave getNave() {
	return nave;
}
/**
 * Método para modificar el nave de la clase Resultados
 * @param nave - nave del jugador
 */
public void setNave(Nave nave) {
	this.nave = nave;
}
  
  

}