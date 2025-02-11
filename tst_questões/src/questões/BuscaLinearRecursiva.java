package questões;
import java.util.Scanner;

class BuscaLinearRecursiva {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();
        String[] seq = input.split(" ");

        int n = Integer.parseInt(sc.nextLine());

        int[] numeros = new int[seq.length];
        for (int i = 0; i < seq.length; i++){
            numeros[i] = Integer.parseInt(seq[i]);
        }

        int resultado = buscaLinearRecursiva(numeros, n, 0);
        System.out.println(resultado);

        sc.close();
    }
    private static int buscaLinearRecursiva(int[] numeros, int n, int index){
        if (index >= numeros.length){
            return -1;
        }
        if (numeros[index] == n){
            return index;
        }

        return buscaLinearRecursiva(numeros, n, index + 1);
    }
}
