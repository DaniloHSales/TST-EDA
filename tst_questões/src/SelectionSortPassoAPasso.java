import java.util.Arrays;
import java.util.Scanner;

class SelectionSortPassoAPasso {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        String[] input = sc.nextLine().split(" ");
        int[] numeros = new int[input.length];

        for (int i = 0; i < input.length; i++){
            numeros[i] = Integer.parseInt(input[i]);
        }
        selectionSort(numeros);
    }

    private static void selectionSort(int[] numeros){
        int n = numeros.length;

        for (int i = 0; i < n - 1; i++){
            int index_menor = i;

            for (int j = i + 1; j < n; j++){
                if (numeros[j] < numeros[index_menor]){
                    index_menor = j;
                }
            }
            int aux = numeros[i];
            numeros[i] = numeros[index_menor];
            numeros[index_menor] = aux;
            System.out.println(Arrays.toString(numeros));  
        }      
    }
}
