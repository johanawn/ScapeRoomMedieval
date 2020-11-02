import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.DefaultStyledDocument;

public class Matriz {
    String entrada = "meteoritos.png";
    Imagen i = new Imagen(entrada);
    int m[][] = i.getMatriz();
    private int colorFondo = m[0][0];
    public static final int USADO = 999999999;
    public static final int FONDO = 0;
    public static final int BORDE = 12;
    public static final int CENTRO_ROCA = 1;
    public static final int MANCHA = 68;
    public int[][] copia = new int[m.length][m[0].length];
    int colorFondoMeteorito = -92199899;

    /**
     * METODO APP, ES EL QUE EJUCUTA TODO
     * @return
     */
    public int[][] crearMatriz() {

        for (int f = 0; f < copia.length; f += 1) {
            for (int c = 0; c < copia[f].length; c += 1) {
                copia[f][c] = -1;
            }
        }
        for(int f =0; f<m.length; f+=1) {
            for (int c = 0; c < m[0].length; c += 1) {
                int[] buscarIguales = buscarIguales(f,c,colorFondo);
                if((f==0 || c == m[f].length - 1 || f==m.length - 1|| c==0) && (buscarIguales[0] ==1 ||buscarIguales[1] ==1 ||buscarIguales[2] ==1 ||buscarIguales[3] ==1 )) {
                    fondo(f,c);

                }

            }
        }
        for (int f = 0; f < m.length; f += 1) {
            for (int c = 0; c < m[f].length; c += 1) {
                int[] buscarFondo = buscarIgualesCopia(f, c, FONDO);

                if(((buscarFondo[0] ==1 ||buscarFondo[1] ==1 ||buscarFondo[2] ==1 ||buscarFondo[3] ==1) && copia[f][c] == -1 && copia[f][c] != FONDO)){
                    borde(f,c);
                }

            }

        }





        return copia;
    }

    /**
     * verifica que la posicion sea valida
     * @param fila
     * @param columna
     * @return
     */
    public boolean esPosicionValida(int fila, int columna) {
        return fila >= 0 && columna >= 0 && fila < m.length && columna < m[fila].length;
    }






    /**
     * SE CREA UN ARRAY DE 8 POSICIONES, CADA POSICION REPRESENTA UN LUGAR ALREDEDOR DE UN PUNTO
     *  sI TIENE EL VALOR DE 0, ES QUE ESE PUNTO NO TIENE SIMILARES EN ESA DIRECCION, SI EL VALOR ES 1, SIGNIFICA QUE SI
     *  0 ARRIBA, 1 ABAJO, 2 DERECHA, 3 IZQUIERDA, 4 DIAGONAL SUPERIOR IZQ, 5 DIAGONAL SUPERIOR DER, 6 DIAGONAL INFERIOR IZQ, 7 DIAGONAL INFERIOR DER
     * @param f
     * @param c
     * @param color
     * @return
     */
    public int[] buscarIguales(int f, int c, int color) {
        int p[] = {0, 0, 0, 0, 0, 0, 0, 0};
        if ( esPosicionValida(f - 1, c)) {
            if(m[f - 1][c] == color) {
                p[0] = 1;
            }
        }
        if (esPosicionValida(f + 1, c)) {
            if(m[f + 1][c] == color) {
                p[1] = 1;
            }
        }
        if (esPosicionValida(f, c + 1)) {
            if(m[f][c + 1] == color) {
                p[2] = 1;
            }
        }
        if (esPosicionValida(f, c - 1)) {
            if(m[f][c - 1] == color) {
                p[3] = 1;
            }
        }
        if ( esPosicionValida(f - 1, c - 1)) {
            if(m[f - 1][c - 1] == color) {
                p[4] = 1;
            }
        }
        if ( esPosicionValida(f - 1, c + 1)) {
            if(m[f - 1][c + 1] == color) {
                p[5] = 1;
            }
        }
        if ( esPosicionValida(f + 1, c - 1)) {
            if(m[f + 1][c - 1] == color) {
                p[6] = 1;
            }
        }
        if ( esPosicionValida(f + 1, c + 1)) {
            if(m[f + 1][c + 1] == color) {
                p[7] = 1;
            }
        }
        return p;
    }
    public int[] buscarIgualesCopia(int f, int c, int color) {
        int p[] = {0, 0, 0, 0, 0, 0, 0, 0};
        if ( esPosicionValida(f - 1, c)) {
            if(copia[f - 1][c] == color) {
                p[0] = 1;
            }
        }
        if (esPosicionValida(f + 1, c)) {
            if(copia[f + 1][c] == color) {
                p[1] = 1;
            }
        }
        if (esPosicionValida(f, c + 1)) {
            if(copia[f][c + 1] == color) {
                p[2] = 1;
            }
        }
        if (esPosicionValida(f, c - 1)) {
            if(copia[f][c - 1] == color) {
                p[3] = 1;
            }
        }
        if ( esPosicionValida(f - 1, c - 1)) {
            if(copia[f - 1][c - 1] == color) {
                p[4] = 1;
            }
        }
        if ( esPosicionValida(f - 1, c + 1)) {
            if(copia[f - 1][c + 1] == color) {
                p[5] = 1;
            }
        }
        if ( esPosicionValida(f + 1, c - 1)) {
            if(copia[f + 1][c - 1] == color) {
                p[6] = 1;
            }
        }
        if ( esPosicionValida(f + 1, c + 1)) {
            if(copia[f + 1][c + 1] == color) {
                p[7] = 1;
            }
        }
        return p;
    }


    public void borde(int f, int c) {
        int color = m[f][c];
        int[] iguales = buscarIguales(f, c, color);
        copia[f][c] = BORDE;
        if (esPosicionValida(f, c) && m[f][c] == color && m[f][c] != USADO) {
            if (iguales[0] == 1) {
                m[f][c] = USADO;
                f -= 1;
                borde(f, c);
            } else if (iguales[1] == 1) {
                m[f][c] = USADO;
                f += 1;
                borde(f, c);
            } else if (iguales[2] == 1) {
                m[f][c] = USADO;
                c += 1;
                borde(f, c);
            } else if (iguales[3] == 1) {
                m[f][c] = USADO;
                c -= 1;
                borde(f, c);
            } else if (iguales[4] == 1) {
                m[f][c] = USADO;
                f -= 1;
                c -= 1;
                borde(f, c);
            } else if (iguales[5] == 1) {
                m[f][c] = USADO;
                f -= 1;
                c += 1;
                borde(f, c);
            } else if (iguales[6] == 1) {
                m[f][c] = USADO;
                f += 1;
                c -= 1;
                borde(f, c);
            } else if (iguales[7] == 1) {
                m[f][c] = USADO;
                f += 1;
                c += 1;
                borde(f, c);
            }
            copia[f][c] = BORDE;
        }
    }
    public void fondo(int f, int c) {
        int color = m[f][c];
        int[] iguales = buscarIguales(f, c, m[f][c]);

        if (esPosicionValida(f, c) && m[f][c] == color && m[f][c] != USADO && m[f][c] == colorFondo) {
            copia[f][c] = FONDO;
            if (iguales[0] == 1) {
                m[f][c] = USADO;
                f -= 1;
                fondo(f, c);
            }if (iguales[1] == 1) {
                m[f][c] = USADO;
                f += 1;
                fondo(f, c);
            }if (iguales[2] == 1) {
                m[f][c] = USADO;
                c += 1;
                fondo(f, c);
            }if (iguales[3] == 1) {
                m[f][c] = USADO;
                c -= 1;
                fondo(f, c);
            }
            copia[f][c] = FONDO;
        }
    }
    public void centro(int f, int c) {
        int color = m[f][c];
        int[] iguales = buscarIguales(f, c, m[f][c]);

        if (esPosicionValida(f, c) && m[f][c] == color && m[f][c] != USADO) {
            if (iguales[0] == 1) {
                m[f][c] = USADO;
                copia[f][c] = CENTRO_ROCA;
                f -= 1;

                centro(f, c);
            }if (iguales[1] == 1) {
                m[f][c] = USADO;
                copia[f][c] = CENTRO_ROCA;
                f += 1;
                centro(f, c);
            }if (iguales[2] == 1) {
                m[f][c] = USADO;
                copia[f][c] = CENTRO_ROCA;
                c += 1;
                centro(f, c);
            }if (iguales[3] == 1) {
                m[f][c] = USADO;
                copia[f][c] = CENTRO_ROCA;
                c -= 1;
                centro(f, c);
            }
            copia[f][c] = CENTRO_ROCA;
        }
    }


    public int[] buscarIgualesMancha(int f, int c, int centro, int borde, int fondo, int copia[][]) {
        int p[] = {0, 0, 0, 0, 0, 0, 0, 0};
        if (copia[f - 1][c] != centro && copia[f - 1][c] != borde && copia[f - 1][c] != fondo && esPosicionValida(f - 1, c)) {
            p[0] = 1;
        }
        if (copia[f + 1][c] != centro && copia[f + 1][c] != borde && copia[f + 1][c] != fondo && esPosicionValida(f + 1, c)) {
            p[1] = 1;
        }
        if (copia[f][c + 1] != centro && copia[f][c + 1] != borde && copia[f][c + 1] != fondo && esPosicionValida(f, c + 1)) {
            p[2] = 1;
        }
        if (copia[f][c - 1] != centro && copia[f][c - 1] != borde && copia[f][c - 1] != fondo && esPosicionValida(f, c - 1)) {
            p[3] = 1;
        }
        if (copia[f - 1][c - 1] != centro && copia[f - 1][c - 1] != borde && copia[f - 1][c - 1] != fondo && esPosicionValida(f - 1, c - 1)) {
            p[4] = 1;
        }
        if (copia[f - 1][c + 1] != centro && copia[f - 1][c + 1] != borde && copia[f - 1][c + 1] != fondo && esPosicionValida(f - 1, c + 1)) {
            p[5] = 1;
        }
        if (copia[f + 1][c - 1] != centro && copia[f + 1][c - 1] != borde && copia[f + 1][c - 1] != fondo && esPosicionValida(f + 1, c - 1)) {
            p[6] = 1;
        }
        if (copia[f + 1][c + 1] != centro && copia[f + 1][c + 1] != borde && copia[f + 1][c + 1] != fondo && esPosicionValida(f + 1, c + 1)) {
            p[7] = 1;
        }
        return p;
    }


    public int[][] getCopia(){
        return copia;
    }
}









//METODO RECURSIVO QUE TOMA AL METODO buscarIguales y a dod valores dentro de un array como parametro
//Con base al metodod buscarIguales, verifica en que direccion x posicion en la imagen tiene iguales.
//SI ES IGUAL SE LE DA EL VALOR DEL COLOR CON EL QUE SE INICIO LA CADENA Y SE LE APLICA EL METODO buscarIGUALES A ESA POSICION, Y LUEGO EL METODO crearBordes















