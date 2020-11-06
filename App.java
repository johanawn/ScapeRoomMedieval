
/**
 * Write a description of class App here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class App{
    private Matriz matriz = new Matriz();
    private Interfaz interfaz = new Interfaz();
    private Nave nave = new Nave();
    private Resultados resultados = new Resultados();
    private Meteorito [] meteoritos;
    private int meteoritosSeleccionados [];
    private int dibujoFinal [][];
    public void ejecutar(String archivo){
        matriz.iniciarImagen(archivo);
        interfaz.bienvenida();
        int capacidad = interfaz.pedirCapacidadMaxima();
        nave.setCapacidadMaxima(capacidad);
        matriz.crearMatriz();
        meteoritos = matriz.getMeteoritos();
        nave.setMeteoritos(meteoritos);
        nave.seleccionarMeteoritos();
        meteoritosSeleccionados = nave.getMeteoritosSeleccionados();
        matriz.setMeteoritosSeleccionados(meteoritosSeleccionados);
        matriz.ponerX();
        dibujoFinal = matriz.getDibujo();
        interfaz.mostrarSeleccion(dibujoFinal);
        resultados.texto("ANALISIS DE LOS SCANERES DE LA REDWIND", meteoritos, nave);
    }
}
