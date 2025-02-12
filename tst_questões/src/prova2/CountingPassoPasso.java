package prova2;

import java.util.*;

public class CountingPassoPasso {
    public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();
        String[] seq = input.split(" ");

        int k = sc.nextInt();

        int[] numeros = new int[seq.length];
        for (int i = 0; i < seq.length; i++){
            numeros[i] = Integer.parseInt(seq[i]);
        }  

        countingPassoPasso(numeros, k);
    }

    private static int[] countingPassoPasso(int[] numeros, int k){

        int[] c = new int[k+1];

        // registrando a preseça de numeros[i] na sequência
        for (int i = 0; i < numeros.length; i++) {
            c[numeros[i]] += 1;
            imprimirArray(c);
        }

        // accumulate
        for (int i = 1; i < c.length; i++){
            c[i] += c[i - 1];   
        }
        System.out.print("Cumulativa do vetor de contagem - ");
        imprimirArray(c);
        imprimirArray(c);

        //sort
        int[] b = new int[numeros.length];
        for (int i = numeros.length - 1; i >= 0; i--){
            b[c[numeros[i]]- 1] = numeros[i];
            c[numeros[i]] -= 1;
        }
        imprimirArray(b);
        return b;
        
        
    }

    private static void imprimirArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + (i == array.length - 1 ? "\n" : " "));
        }
    } 
}
