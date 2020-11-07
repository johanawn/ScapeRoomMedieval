
/**
 * Clase MainEjecutarApp es el disparador del programa.
 * 
 * @author Saindell Sabrina Brenes Hernández C01309
 * @author Gabriel Bonilla Rivera C01252
 * @author Johana Wu Nie C08591
 * @version 06/11, final
 */
public class MainEjecutarApp{
    public static void main(String trigger[]){
        String archivo = "";
        if(trigger.length > 0){
            archivo = trigger[0];
        }
        else{
            archivo = "meteoritos.png";
        }
        App app = new App();
        app.ejecutar(archivo);
    }
}
