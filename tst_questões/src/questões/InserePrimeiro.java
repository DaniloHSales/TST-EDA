package questões;
import java.util.Arrays;
import java.util.Scanner;

class InserePrimeiro {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        String[] input = sc.nextLine().split(" ");
        int[] numeros = new int[input.length];

        for (int i = 0; i < input.length; i++){
            numeros[i] = Integer.parseInt(input[i]);
        }

        inserePrimeiro(numeros);
        System.out.println(Arrays.toString(numeros));
        
    }

    public static void inserePrimeiro(int[] numeros){
        int primeiro = numeros[0]; 
        int i = 1;

        while (i < numeros.length && numeros[i] < primeiro) {
            numeros[i - 1] = numeros[i];
            i++;
        }
        numeros[i - 1] = primeiro;
    }    
}
