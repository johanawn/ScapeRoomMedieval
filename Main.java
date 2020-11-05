public class Main {
    public static void main(String[] args) {
        Matriz matriz = new Matriz();
        matriz.crearMatriz();
        int[][] copia = matriz.getCopia();
        int[][] copia2 = matriz.getCopia2();
        int[] cantidadManchas = matriz.getManchasMeteoritos();
        for(int f =0; f< copia.length; f+=1){
            for(int c =0; c < copia[f].length; c+=1){
                System.out.print(copia2[f][c]+"\t");
            }
            System.out.println("\n");
        }
        System.out.println("\n");
        System.out.println(matriz.getCantidadMeteoritos());
        for(int y =0; y < cantidadManchas.length; y+=1){
            System.out.print(cantidadManchas[y]+ "\t");
        }
        System.out.println("");

       for(int i = 0; i < matriz.pesoMeteoritos.length; i+=1){
           System.out.print(matriz.pesoMeteoritos[i]+ "\t");
       }



    }
}