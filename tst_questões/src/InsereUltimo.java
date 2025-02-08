import java.util.Arrays;
import java.util.Scanner;

class InsereUltimo {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String[] input = sc.nextLine().split(" ");
        int[] numeros = new int[input.length];

        for (int i = 0; i < input.length; i++){
            numeros[i] = Integer.parseInt(input[i]);
        }

        insereUltimo(numeros);
        System.out.println(Arrays.toString(numeros));

    }

    public static void insereUltimo(int[] numeros){
        for (int i = 0; i < numeros.length; i++){
            int j = numeros.length - 1;
            while (j > 0 && numeros[j] < numeros[j - 1]){
                int aux = numeros[j];
                numeros[j] = numeros[j - 1];
                numeros[j - 1] =  aux;
                j -= 1;                
            } 
        }         
    }
}
