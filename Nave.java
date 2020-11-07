
/**
 * La clase Nave es la encargada de seleccionar los mejores meteoritos.
 * 
 * @author Sabrina Brenes
 * @author Gabriel Bonilla
 * @author Johana Wu
 * @version (06/11, final)
 */
public class Nave{
    private int capacidadMaxima;
    private int cargaActual;
    private Meteorito meteoritos [];
    private int pesoTotalMeteoritos;
    private int [] meteoritoSeleccionado;
    private int valorActual;
    /**
     * Efectúa: constructor por omisión de la clase Nave.
     * Modifica: los atributos de la clase Nave.
     */
    public Nave(){
        setCapacidadMaxima(-1);
        setCargaActual(-1);
        setValorActual(-1);
    }
    /**
     * Efectúa: constructor con parámetros de la clase Nave.
     * @param capacidadMaxima - la cantidad de peso que puede cargar la nave, se mide por la cantidad de puntos de un meteorito en una matriz.
     * @param meteoritos - los objetos de la clase meteoritos que se sacan a partir de una imagen dada.
     * Modifica: los atributos de la clase Nave.
     */
    public Nave(int capacidadMaxima, Meteorito [] meteoritos){
        setCapacidadMaxima(capacidadMaxima);
        setCargaActual(0);
        setValorActual(0);
        this.meteoritos = meteoritos;
    }
    /**
     * Efectúa: suma el peso de todos los meteoritos seleccionados.
     * @return peso - el peso total de todos los meteoritos seleccionados.
     */
    public int obtenerPesoMeteoritosSeleccionados(){
        int peso = 0;
        for(int i = 0; i < meteoritoSeleccionado.length; i++){
            if(meteoritoSeleccionado[i] != -1){
                peso += meteoritos[meteoritoSeleccionado[i]].getPeso();
            }
        }
        return peso;
    }
    /**
     * Efectúa: suma el valor de todos los meteoritos seleccionados.
     * @return valor - el valor total de todos los meteoritos selccionados.
     */
    public int obtenerValorMeteoritosSeleccionados(){
        int valor = 0;
        for(int i = 0; i < meteoritoSeleccionado.length; i++){
            if(meteoritoSeleccionado[i] != -1){
                valor += meteoritos[meteoritoSeleccionado[i]].getValor();
            }
        }
        return valor;
    }
    /**
     * Efectúa: en el caso de que el peso total de los meteoritos no exceda la capacidad máxima de la nave, este método suma esos pesos para sacar su total.
     * @return pesoTotal - el total del peso de todos los meteoritos en la imagen dada.
     */
    private int obtenerPesoTotalMeteoritos(){
        int pesoTotal = 0;
        for(int i = 0; i < meteoritos.length; i++){
            pesoTotal += meteoritos[i].getPeso();
        }
        return pesoTotal;
    }
    /**
     * Efectúa: en el caso de que el peso total de los meteoritos no exceda la capacidad máxima de la nave, este método suma el valor de esos meteoritos para sacar su total.
     * @return valorTotal - el valor total de todos los meteoritos en la imagen dada.
     */
    private int obtenerValorTotalMeteoritos(){
        int valorTotal = 0;
        for(int i = 0; i < meteoritos.length; i++){
            valorTotal += meteoritos[i].getValor();
        }
        return valorTotal;
    }
    /**
     * Efectúa: saca la relación costo-beneficio de cada meteorito con la intención de saber cuáles son más valiosos de manera que se elijan los que distribuyan mejor su área con respecto a su valor.
     * @param meteoro - una lista de los meteoritos encontrados en la imagen.
     * @return relacion - una lista con el resultado de calcular su relación costo-beneficio de cada meteorito.
     */
    private double [] obtenerRelacionCostoBeneficio(Meteorito [] meteoro){
        double [] relacion = new double [meteoro.length];
        for(int index = 0; index < meteoro.length; index++){
            relacion[index] = meteoro[index].getValor()/meteoro[index].getPeso();
        }
        return relacion;
    }
    /**
     * Efectúa: obtiene los ID de cada meteorito.
     * @return id - una lista con los ID de cada meteorito.
     */
    public int [] obtenerId(){
        int [] id = new int[meteoritos.length];
        for(int index = 0; index < id.length; index++){
            id[index] = meteoritos[index].getID();
        }
        return id;
    }
    /**
     * Efectúa: una vez sacada la relación costo-beneficio de cada meteorito, este método los ordena de mayor a menor valor.
     * @param relacion - la lista con el valor costo-beneficio de cada meteorito en la imagen.
     * @return relacion - la lista ordenada de mayor beneficio a menor beneficio según los valores de cada meteorito.
     * Modifica: el orden de los meteoritos.
     */
    private double[] ordenarRelacion(double []relacion){
        for (int index = 0 ; index < relacion.length - 1 ; index++) {
            int max = index;
            for (int mayor = index + 1 ; mayor < relacion.length ; mayor++) {
                if (relacion[mayor] > relacion[max]) {
                    max = mayor;
                }
            }
            if (index != max) {
                double aux = relacion[index];
                relacion[index] = relacion[max];
                relacion[max] = aux;
                Meteorito meteoro = meteoritos[index];
                meteoritos[index] = meteoritos[max];
                meteoritos[max] = meteoro;
            }
        }
        return relacion;
    }
    /**
     * Efectúa: este método selcciona los mejores meteoritos para llevarse según los resultados de sacar su relación costo-beneficio.
     * Modifica: los atributos de cargaActual con el peso de los meteoritos elegidos, valorActual con el valor de los meteoritos elegidos y la lista de meteoritoSeleccionado con los ID de aquellos elegidos para llevarse.
     */
    public void seleccionarMeteoritos(){
        setMeteoritoSeleccionado();
        pesoTotalMeteoritos = obtenerPesoTotalMeteoritos();
        int peso = 0;
        int z = 0;
        if(pesoTotalMeteoritos <= capacidadMaxima){
            for(int i = 0; i < meteoritos.length; i++){
                meteoritoSeleccionado[i] = meteoritos[i].getID();
            }
            setCargaActual(pesoTotalMeteoritos);
            setValorActual(obtenerValorTotalMeteoritos());
        }
        else{
            double [] relacion = obtenerRelacionCostoBeneficio(meteoritos);
            relacion = ordenarRelacion(relacion);
            for(int index = 0; index < relacion.length; index++){
                if(meteoritos[index].getPeso()+peso <= capacidadMaxima){
                    meteoritoSeleccionado[z] = meteoritos[index].getID();
                    peso+= meteoritos[index].getPeso();
                    z++;
                }
            }
            setCargaActual(obtenerPesoMeteoritosSeleccionados());
            setValorActual(obtenerValorMeteoritosSeleccionados());
        }
    }
    /**
     * Efectúa: este método asigna el tamaño que podría llegar a tener la lista de meteoritos seleccionados, además la llena de -1 para que no se confundan los ID.
     * Modifica: el atributo meteoritoSeleccionado de la clase Nave.
     */
    public void setMeteoritoSeleccionado(){
        this.meteoritoSeleccionado = new int[meteoritos.length];
        for(int i = 0; i < meteoritoSeleccionado.length; i++){
            meteoritoSeleccionado[i] = -1;
        }
    }
    /**
     * Efectúa: a partir de la imagen dada y la lista de meteoritos obtenida en la clase Matriz, la lista de meteoritos de la Nave se modifica.
     * Modifica: el atributo meteoritos de la clase Nave.
     * @param meteoritos - la lista de meteoritos obtenida a partir de la imagen.
     */
    public void setMeteoritos(Meteorito [] meteoritos){
        this.meteoritos = meteoritos;
    }
    /**
     * Efectúa: asigna un valor a la capacidad máxima de la nave.
     * @param capacidadMaxima - el valor de la capacidad de la nave dada por el usuario.
     * Modifica: el atributo capacidadMaxima de la clase Nave.
     */
    public void setCapacidadMaxima(int capacidadMaxima){
        this.capacidadMaxima = capacidadMaxima;
    }
    /**
     * Efectúa: le asigna un valor a la carga de la nave.
     * Modifica: el atributo valorActual de la clase Nave.
     * @param valorActual - el valor de la carga de la nave.
     */
    public void setValorActual(int valorActual){
        this.valorActual = valorActual;
    }
    /**
     * Efectúa: le asigna el peso a la carga de la nave.
     * Modifica: el atributo cargaActual de la clase Nave.
     * @param cargaActual - el peso de la carga de la nave.
     */
    public void setCargaActual(int cargaActual){
        this.cargaActual = cargaActual;
    }
    /**
     * Efectúa: devuelve la capacidad maxima de la nave.
     * @return capacidadMaxima - la capacidad de la nave para cargar meteoritos.
     */
    public int getCapacidadMaxima(){
        return capacidadMaxima;
    }
    /**
     * Efectúa: devuelve la carga actual de la nave.
     * @return cargaActual - el peso que tiene la carga de la nave.
     */
    public int getCargaActual(){
        return cargaActual;
    }
    /**
     * Efectúa: devuelve el valor de la carga de la nave.
     * @return valorActual - el valor de la carga de la nave.
     */
    public int getValorActual(){
        return valorActual;
    }
    /**
     * Efectúa: devuelve la lista con los ID de los meteoritos selecionados.
     * @return meteoritoSeleccionado - ID de los meteoritos elgidos.
     */
    public int [] getMeteoritosSeleccionados(){
        return meteoritoSeleccionado;
    }
    /**
     * Efectúa: da la información más importante de la nave.
     * @return la información de la nave.
     */
    public String toString(){
        return "La capacidad de la RedWind es de: "+capacidadMaxima+", su carga actual es de: "+cargaActual+" y el valor de su carga es de: "+valorActual;
    }
}
