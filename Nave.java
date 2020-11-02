
/**
 * Write a description of class Nave here.
 * 
 * @author (Sabrina Brenes, Gabriel Bonilla, Johana Wu) 
 * @version (27/10)
 */
public class Nave{
    private int capacidadMaxima;
    private int cargaActual;
    private Meteorito meteoritos [];
    private int pesoTotalMeteoritos;
    private int [] meteoritoSeleccionado;
    private int valorActual;
    
    public Nave(int capacidadMaxima, Meteorito [] meteoritos){
        setCapacidadMaxima(capacidadMaxima);
        setCargaActual(0);
        setValorActual(0);
        this.meteoritos = meteoritos;
    }
    public int obtenerPesoMeteoritosSeleccionados(){
        int peso = 0;
        for(int i = 0; i < meteoritoSeleccionado.length; i++){
            peso += meteoritos[meteoritoSeleccionado[i]].getPeso();
        }
        return peso;
    }
    public int obtenerValorMeteoritosSeleccionados(){
        int valor = 0;
        for(int i = 0; i < meteoritoSeleccionado.length; i++){
            valor += meteoritos[meteoritoSeleccionado[i]].getValor();
        }
        return valor;
    }
    private int obtenerPesoTotalMeteoritos(){
        int pesoTotal = 0;
        for(int i = 0; i < meteoritos.length; i++){
            pesoTotal += meteoritos[i].getPeso();
        }
        return pesoTotal;
    }
    private int obtenerValorTotalMeteoritos(){
        int valorTotal = 0;
        for(int i = 0; i < meteoritos.length; i++){
            valorTotal += meteoritos[i].getValor();
        }
        return valorTotal;
    }
    public double [] obtenerRelacionCostoBeneficio(Meteorito [] meteoro){
        double [] relacion = new double [meteoro.length];
        for(int index = 0; index < meteoro.length; index++){
            relacion[index] = meteoro[index].getValor()/meteoro[index].getPeso();
        }
        return relacion;
    }
    public int [] obtenerId(){
        int [] id = new int[meteoritos.length];
        for(int index = 0; index < id.length; index++){
            id[index] = meteoritos[index].getId();
        }
        return id;
    }
    public double[] ordenarRelacion(double []relacion){
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
    public void seleccionarMeteoritos(){
        setMeteoritoSeleccionado();
        pesoTotalMeteoritos = obtenerPesoTotalMeteoritos();
        int peso = 0;
        int z = 0;
        if(pesoTotalMeteoritos <= capacidadMaxima){
            for(int i = 0; i < meteoritos.length; i++){
                meteoritoSeleccionado[i] = meteoritos[i].getId();
            }
            setCargaActual(pesoTotalMeteoritos);
            setValorActual(obtenerValorTotalMeteoritos());
        }
        else{
            double [] relacion = obtenerRelacionCostoBeneficio(meteoritos);
            relacion = ordenarRelacion(relacion);
            for(int index = 0; index < relacion.length; index++){
                if(meteoritos[index].getPeso()+peso <= this.capacidadMaxima){
                    meteoritoSeleccionado[z] = meteoritos[index].getId();
                    peso+= meteoritos[index].getPeso();
                    z++;
                }
            }
            setCargaActual(obtenerPesoMeteoritosSeleccionados());
            setValorActual(obtenerValorMeteoritosSeleccionados());
        }
    }
    public void setMeteoritoSeleccionado(){
        this.meteoritoSeleccionado = new int[meteoritos.length-1];
    }
    public void setMeteoritos(Meteorito [] meteoritos){
        this.meteoritos = meteoritos;
    }
    public void setCapacidadMaxima(int capacidadMaxima){
        this.capacidadMaxima = capacidadMaxima;
    }
    public void setValorActual(int valorActual){
        this.valorActual = valorActual;
    }
    public void setCargaActual(int cargaActual){
        this.cargaActual = cargaActual;
    }
    public int getCapacidadMaxima(){
        return capacidadMaxima;
    }
    public int getCargaActual(){
        return cargaActual;
    }
    public int [] getMeteoritosSeleccionados(){
        return meteoritoSeleccionado;
    }
    public String toString(){
        return "La capacidad de la RedWind es de: "+capacidadMaxima+", su carga actual es de: "+cargaActual+" y el valor de su carga es de: "+valorActual;
    }
}
