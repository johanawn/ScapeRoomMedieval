import javax.swing.text.DefaultStyledDocument;


public class Matriz {
    private String entrada; 
    private Imagen i;
    private int m[][];
    private int k[][];
    private int e[][];
    private int cr[][];
    private int dibujo[][];
    private int colorFondo;
    private static final int USADO = 999999999;
    private static final int FONDO = 0;
    private static final int BORDE = 12;
    private static final int CENTRO_ROCA = 1;
    private static final int MANCHA = 68;
    private static final int NEGRO = -16777216;
    private int[][] copia;
    private int[][] copia2;
    private int[][] b;
    private int cantidadMeteoritos = 0;
    private int cantidadManchas = 0;
    private int[] pesoMeteoritos;
    private int[] manchasMeteoritos;
    private Meteorito[] meteoritos;
    private int peso = 0;
    private int[][] filas;
    private int[][] columnas;
    private int meteoritosElegidos [];
    public void iniciarImagen(String archivo){
        entrada = archivo;
        i = new Imagen(entrada);
        m = i.getMatriz();
        k= i.getMatriz();
        e = i.getMatriz();
        cr = i.getMatriz();
        dibujo = i.getMatriz();
        colorFondo = m[0][0];
        copia = new int[m.length][m[0].length];
        copia2 = new int[m.length][m[0].length];
        b = new int[m.length][m[0].length];
    }
    /**
     * METODO APP, ES EL QUE EJECUTA
     *
     * @return
     */
    public int[][] crearMatriz() {
        int i = 0;
        int x = 0;
        int u = 1;
        int n = 0;
        int z = 0;
        int l = 1;
        for (int f = 0; f < copia.length; f += 1) {
            for (int c = 0; c < copia[f].length; c += 1) {
                copia[f][c] = -1;
                copia2[f][c] = -1;
            }
        }
        fondo(0, 0);
        for (int f = 0; f < copia.length; f += 1) {
            for (int c = 0; c < copia[f].length; c += 1) {
                if (copia[f][c] != FONDO && k[f][c] != USADO) {
                    cantidadMeteoritos += 1;
                    numMeteoritos(f, c, cantidadMeteoritos);
                }
            }
        }
        pesoMeteoritos = new int[cantidadMeteoritos];
        while (i < pesoMeteoritos.length) {
            for (int f = 0; f < copia.length; f += 1) {
                for (int c = 0; c < copia[f].length; c += 1) {
                    if (copia[f][c] != FONDO && e[f][c] != USADO) {
                        crearPeso(f, c);
                        pesoMeteoritos[i] = peso;
                        i += 1;
                        peso = 0;
                    }
                }
            }
        }
        for (int f = 0; f < m.length; f += 1) {
            for (int c = 0; c < m[f].length; c += 1) {
                int[] buscarFondo = buscarIguales(f, c, FONDO, copia);
                if (((buscarFondo[0] == 1 || buscarFondo[1] == 1 || buscarFondo[2] == 1 || buscarFondo[3] == 1) && copia[f][c] == -1 && copia[f][c] != FONDO)) {
                    borde(f, c);
                }
            }
        }
        for (int f = 0; f < m.length; f += 1) {
            for (int c = 0; c < m[f].length; c += 1) {
                int[] buscarBorde = buscarIguales(f, c, BORDE, copia);
                if (((buscarBorde[0] == 1 || buscarBorde[1] == 1 || buscarBorde[2] == 1 || buscarBorde[3] == 1) && copia[f][c] == -1 && m[f][c] != USADO && copia[f][c] != FONDO)) {
                    centro(f, c);
                }
            }
        }
        manchasMeteoritos = new int[cantidadMeteoritos];
        for (int f = 0; f < m.length; f += 1) {
            for (int c = 0; c < m[f].length; c += 1) {
                if (copia[f][c] == -1) {
                    mancha(f, c);
                }
            }
        }
        for (int fila = 0; fila < b.length; fila += 1) {
            for (int columna = 0; columna < b[fila].length; columna += 1) {
                if (copia[fila][columna] != MANCHA) {
                    b[fila][columna] = USADO;
                }
            }
        }
        for (int b = 0; b < manchasMeteoritos.length; b += 1) {
            manchasMeteoritos[b] = 0;
        }
        while (x < manchasMeteoritos.length) {
            for (int f = 0; f < copia.length; f += 1) {
                for (int c = 0; c < copia[f].length; c += 1) {
                    if (copia2[f][c] == u && copia[f][c] == MANCHA && b[f][c] != USADO) {
                        manchasMeteoritos[x] += 1;
                        contarManchas(f, c);
                    }
                }
            }
            x += 1;
            u += 1;
        }
        filas = new int[pesoMeteoritos.length][];
        columnas = new int[pesoMeteoritos.length][];
        for (int s = 0; s < pesoMeteoritos.length; s++) {
            filas[s] = new int[pesoMeteoritos[s]];
            columnas[s] = new int[pesoMeteoritos[s]];
        }
        for (int d = 0; d < filas.length; d++) {
            while (n < filas.length) {
                for (int f = 0; f < copia.length; f += 1) {
                    for (int c = 0; c < copia[f].length; c++) {
                        if (copia2[f][c] == l) {
                            filas[n][z] = f;
                            columnas[n][z] = c;
                            z++;
                        }
                    }
                }
                z = 0;
                n++;
                l++;
            }
            n = 0;
            z = 0;
        }

        meteoritos = new Meteorito[cantidadMeteoritos];
        for (int a = 0; a < meteoritos.length; a += 1) {
            meteoritos[a] = new Meteorito();
        }
        for (int p = 0; p < meteoritos.length; p += 1) {
            meteoritos[p].setID(p);
            meteoritos[p].setFilaC(((mayor(filas[p]) + menor(filas[p]))/2));
            meteoritos[p].setColumnaC(((mayor(columnas[p]) + menor(columnas[p]))/2));
            meteoritos[p].setPeso(pesoMeteoritos[p]);
            meteoritos[p].setValor(manchasMeteoritos[p]);
        }
        return copia;
    }
    public void ponerX (){
        for(int x = 0; x < meteoritosElegidos.length; x++){
            for(int i = 0; i < meteoritos.length; i++){
                if(meteoritos[i].getID() == meteoritosElegidos[x]){
                    int fila = meteoritos[i].getFilaC();
                    int columna = meteoritos[i].getColumnaC();
                    dibujo[fila][columna] = NEGRO;
                    for(int h = 1; h <= 4; h++){
                        dibujo[fila+h][columna] = NEGRO;
                        dibujo[fila-h][columna] = NEGRO;
                        dibujo[fila][columna-h] = NEGRO;
                        dibujo[fila][columna+h] = NEGRO;
                    }
                }
            }
        }
    }
    /**
     * verifica que la posicion sea valida
     *
     * @param fila    -la fila en la que se encuentra en la matriz
     * @param columna -la columna en la que se encuentra en la matriz
     * @return -true o false, sependiendo si es o no una posicion valida
     */
    private boolean esPosicionValida(int fila, int columna) {
        return fila >= 0 && columna >= 0 && fila < m.length && columna < m[fila].length;
    }

    /**
     * Re
     *
     * @param f     -la fila en la que se encuentra
     * @param c     -la columna en la que se encuentra
     * @param color -el color del que se quieren buscar iguales
     * @return -SE CREA UN ARRAY DE 8 POSICIONES, CADA POSICION REPRESENTA UN LUGAR ALREDEDOR DE UN PUNTO, SI TIENE EL VALOR DE 0, ES QUE ESE PUNTO NO TIENE SIMILARES EN ESA DIRECCION, SI EL VALOR ES 1, SIGNIFICA QUE SI.
     */
    private int[] buscarIguales(int f, int c, int color, int[][] matriz) {
        int p[] = {0, 0, 0, 0, 0, 0, 0, 0};
        if (esPosicionValida(f - 1, c)) {
            if (matriz[f - 1][c] == color) {
                p[0] = 1;
            }
        }
        if (esPosicionValida(f + 1, c)) {
            if (matriz[f + 1][c] == color) {
                p[1] = 1;
            }
        }
        if (esPosicionValida(f, c + 1)) {
            if (matriz[f][c + 1] == color) {
                p[2] = 1;
            }
        }
        if (esPosicionValida(f, c - 1)) {
            if (matriz[f][c - 1] == color) {
                p[3] = 1;
            }
        }
        if (esPosicionValida(f - 1, c - 1)) {
            if (matriz[f - 1][c - 1] == color) {
                p[4] = 1;
            }
        }
        if (esPosicionValida(f - 1, c + 1)) {
            if (matriz[f - 1][c + 1] == color) {
                p[5] = 1;
            }
        }
        if (esPosicionValida(f + 1, c - 1)) {
            if (matriz[f + 1][c - 1] == color) {
                p[6] = 1;
            }
        }
        if (esPosicionValida(f + 1, c + 1)) {
            if (matriz[f + 1][c + 1] == color) {
                p[7] = 1;
            }
        }
        return p;
    }

    private int[] buscarIgualesMancha(int f, int c) {
        int p[] = {0, 0, 0, 0, 0, 0, 0, 0};
        if (esPosicionValida(f - 1, c)) {
            if (copia[f - 1][c] == -1) {
                p[0] = 1;
            }
        }
        if (esPosicionValida(f + 1, c)) {
            if (copia[f + 1][c] == -1) {
                p[1] = 1;
            }
        }
        if (esPosicionValida(f, c + 1)) {
            if (copia[f][c + 1] == -1) {
                p[2] = 1;
            }
        }
        if (esPosicionValida(f, c - 1)) {
            if (copia[f][c - 1] == -1) {
                p[3] = 1;
            }
        }
        if (esPosicionValida(f - 1, c - 1)) {
            if (copia[f - 1][c - 1] == -1) {
                p[4] = 1;
            }
        }
        if (esPosicionValida(f - 1, c + 1)) {
            if (copia[f - 1][c + 1] == -1) {
                p[5] = 1;
            }
        }
        if (esPosicionValida(f + 1, c - 1)) {
            if (copia[f + 1][c - 1] == -1) {
                p[6] = 1;
            }
        }
        if (esPosicionValida(f + 1, c + 1)) {
            if (copia[f + 1][c + 1] == -1) {
                p[7] = 1;
            }
        }
        return p;
    }

    private void borde(int f, int c) {
        int color = m[f][c];
        int[] iguales = buscarIguales(f, c, color, m);
        if (esPosicionValida(f, c) && m[f][c] == color && m[f][c] != USADO) {
            copia[f][c] = BORDE;
            if (iguales[0] == 1) {
                m[f][c] = USADO;
                borde(f - 1, c);
            }
            if (iguales[1] == 1) {
                m[f][c] = USADO;
                borde(f + 1, c);
            }
            if (iguales[2] == 1) {
                m[f][c] = USADO;
                borde(f, c + 1);
            }
            if (iguales[3] == 1) {
                m[f][c] = USADO;
                borde(f, c - 1);
            }
            if (iguales[4] == 1) {
                m[f][c] = USADO;
                borde(f - 1, c - 1);
            }
            if (iguales[5] == 1) {
                m[f][c] = USADO;
                borde(f - 1, c + 1);
            }
            if (iguales[6] == 1) {
                m[f][c] = USADO;
                borde(f + 1, c - 1);
            }
            if (iguales[7] == 1) {
                m[f][c] = USADO;
                borde(f + 1, c + 1);
            }
            copia[f][c] = BORDE;
        }
    }

    private void numMeteoritos(int f, int c, int numero) {
        int[] iguales = buscarIguales(f, c, -1, copia);
        if (esPosicionValida(f, c) && copia[f][c] == -1 && k[f][c] != USADO) {
            copia2[f][c] = numero;
            if (iguales[0] == 1) {
                k[f][c] = USADO;
                numMeteoritos(f - 1, c, numero);
            }
            if (iguales[1] == 1) {
                k[f][c] = USADO;
                numMeteoritos(f + 1, c, numero);
            }
            if (iguales[2] == 1) {
                k[f][c] = USADO;
                numMeteoritos(f, c + 1, numero);
            }
            if (iguales[3] == 1) {
                k[f][c] = USADO;
                numMeteoritos(f, c - 1, numero);
            }
            if (iguales[4] == 1) {
                k[f][c] = USADO;
                numMeteoritos(f - 1, c - 1, numero);

            }
            if (iguales[5] == 1) {
                k[f][c] = USADO;
                numMeteoritos(f - 1, c + 1, numero);
            }
            if (iguales[6] == 1) {
                k[f][c] = USADO;
                numMeteoritos(f + 1, c - 1, numero);
            }
            if (iguales[7] == 1) {
                k[f][c] = USADO;
                numMeteoritos(f + 1, c + 1, numero);
            }
        }
    }

    private void crearPeso(int f, int c) {
        int[] iguales = buscarIguales(f, c, -1, copia);
        if (esPosicionValida(f, c) && copia[f][c] == -1 && e[f][c] != USADO) {
            peso += 1;
            if (iguales[0] == 1) {
                e[f][c] = USADO;
                crearPeso(f - 1, c);
            }
            if (iguales[1] == 1) {
                e[f][c] = USADO;
                crearPeso(f + 1, c);
            }
            if (iguales[2] == 1) {
                e[f][c] = USADO;
                crearPeso(f, c + 1);
            }
            if (iguales[3] == 1) {
                e[f][c] = USADO;
                crearPeso(f, c - 1);
            }
            if (iguales[4] == 1) {
                e[f][c] = USADO;
                crearPeso(f - 1, c - 1);
            }
            if (iguales[5] == 1) {
                e[f][c] = USADO;
                crearPeso(f - 1, c + 1);
            }
            if (iguales[6] == 1) {
                e[f][c] = USADO;
                crearPeso(f + 1, c - 1);
            }
            if (iguales[7] == 1) {
                e[f][c] = USADO;
                crearPeso(f + 1, c + 1);
            }
        }
    }

    private void mancha(int f, int c) {
        int[] iguales = buscarIgualesMancha(f, c);
        if (esPosicionValida(f, c) && copia[f][c] == -1 && m[f][c] != USADO) {
            copia[f][c] = MANCHA;
            if (iguales[0] == 1) {
                m[f][c] = USADO;
                mancha(f - 1, c);
            }
            if (iguales[1] == 1) {
                m[f][c] = USADO;
                mancha(f + 1, c);
            }
            if (iguales[2] == 1) {
                m[f][c] = USADO;
                mancha(f, c + 1);
            }
            if (iguales[3] == 1) {
                m[f][c] = USADO;
                mancha(f, c - 1);
            }
            if (iguales[4] == 1) {
                m[f][c] = USADO;
                mancha(f - 1, c - 1);
            }
            if (iguales[5] == 1) {
                m[f][c] = USADO;
                mancha(f - 1, c + 1);
            }
            if (iguales[6] == 1) {
                m[f][c] = USADO;
                mancha(f + 1, c - 1);
            }
            if (iguales[7] == 1) {
                m[f][c] = USADO;
                mancha(f + 1, c + 1);
            }
            copia[f][c] = MANCHA;
        }
    }

    private void contarManchas(int f, int c) {
        int[] iguales = buscarIguales(f, c, MANCHA, copia);
        if (esPosicionValida(f, c) && copia[f][c] == MANCHA && b[f][c] != USADO) {
            if (iguales[0] == 1) {
                b[f][c] = USADO;
                contarManchas(f - 1, c);
            }
            if (iguales[1] == 1) {
                b[f][c] = USADO;
                contarManchas(f + 1, c);
            }
            if (iguales[2] == 1) {
                b[f][c] = USADO;
                contarManchas(f, c + 1);
            }
            if (iguales[3] == 1) {
                b[f][c] = USADO;
                contarManchas(f, c - 1);
            }
            if (iguales[4] == 1) {
                b[f][c] = USADO;
                contarManchas(f - 1, c - 1);
            }
            if (iguales[5] == 1) {
                b[f][c] = USADO;
                contarManchas(f - 1, c + 1);
            }
            if (iguales[6] == 1) {
                b[f][c] = USADO;
                contarManchas(f + 1, c - 1);
            }
            if (iguales[7] == 1) {
                b[f][c] = USADO;
                contarManchas(f + 1, c + 1);
            }
        }
    }

    private void fondo(int f, int c) {
        int[] iguales = buscarIguales(f, c, m[f][c], m);
        if (esPosicionValida(f, c) && m[f][c] != USADO && m[f][c] == colorFondo) {
            copia[f][c] = FONDO;
            if (iguales[0] == 1) {
                m[f][c] = USADO;
                fondo(f - 1, c);
            }
            if (iguales[1] == 1) {
                m[f][c] = USADO;
                fondo(f + 1, c);
            }
            if (iguales[2] == 1) {
                m[f][c] = USADO;
                fondo(f, c + 1);
            }
            if (iguales[3] == 1) {
                m[f][c] = USADO;
                fondo(f, c - 1);
            }
            copia[f][c] = FONDO;
        }
    }

    private void centro(int f, int c) {
        int[] iguales = buscarIguales(f, c, m[f][c], m);
        if (esPosicionValida(f, c) && m[f][c] != USADO) {
            copia[f][c] = CENTRO_ROCA;
            if (iguales[0] == 1) {
                m[f][c] = USADO;
                centro(f - 1, c);
            }
            if (iguales[1] == 1) {
                m[f][c] = USADO;
                centro(f + 1, c);
            }
            if (iguales[2] == 1) {
                m[f][c] = USADO;
                centro(f, c + 1);
            }
            if (iguales[3] == 1) {
                m[f][c] = USADO;
                centro(f, c - 1);
            }
            copia[f][c] = CENTRO_ROCA;
        }
    }

    public int mayor(int[] matriz) {
        int numeroMayor = matriz[0];
        for (int i = 0; i < matriz.length ; i++) {
            if (matriz[i] > numeroMayor) {
                numeroMayor = matriz[i];
            }
        }
        return numeroMayor;
    }
    public int menor(int[] matriz) {
        int numeroMenor = matriz[0];
        for (int i = 0; i < matriz.length ; i++) {
            if (matriz[i] < numeroMenor) {
                numeroMenor = matriz[i];
            }
        }
        return numeroMenor;
    }


    public void setMeteoritosSeleccionados(int [] meteoritos){
        this.meteoritosElegidos = meteoritos;
    }
    public int [][] getDibujo(){
        return dibujo;
    }
    public int[][] getCopia(){
        return copia;
    }
    public int[][] getCopia2(){
        return copia2;
    }
    public int getCantidadMeteoritos(){
        return cantidadMeteoritos;
    }
    public int getCantidadMachas(){
        return cantidadManchas;
    }
    public int[] getPesoMeteoritos(){
        return pesoMeteoritos;
    }
    public int[] getManchasMeteoritos(){
        return manchasMeteoritos;
    }
    public int [][] getFilas(){
        return filas;
    }
    public int [][] getColumnas(){
        return columnas;
    }
    public Meteorito[] getMeteoritos(){
        return meteoritos;
    }
}
