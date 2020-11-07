
/**
 * La clase App ejecuta el programa para la selección de los meteoritos en la imagen dada.
 * 
 * @author Sabrina Brenes
 * @author Gabriel Bonilla 
 * @author Johana Wu
 * @version (06/11, final)
 */
public class App{
    private Matriz matriz = new Matriz();
    private Interfaz interfaz = new Interfaz();
    private Nave nave = new Nave();
    private Resultados resultados = new Resultados();
    private Meteorito [] meteoritos;
    private int meteoritosSeleccionados [];
    private int dibujoFinal [][];

    /**
     * Efectúa: ejecuta todo el programa de la selcción de los meteoritos.
     * @param archivo - el nombre de la imagen que se desea usar.
     */
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
        String hilera = resultados.mostrar(meteoritos, nave);
        interfaz.mostrarInventarioDeLaNave(hilera);
    }
}
