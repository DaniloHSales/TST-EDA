package questões;
import java.util.Arrays;
import java.util.Scanner;

class InsertionSortRecursivo {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        String[] input = sc.nextLine().split(" ");
        int[] numeros = new int[input.length];

        for (int i = 0; i < input.length; i++){
            numeros[i] = Integer.parseInt(input[i]);
        }

        insertionSortRecursivo(numeros, 1);
        sc.close();
        
    }

    public static void insertionSortRecursivo(int[] numeros, int index){
        if (index == numeros.length) {
            return; // Condição de parada
        }
        
        int elemento_atual = numeros[index];
        int j = index - 1;
        
        while (j >= 0 && numeros[j] > elemento_atual){
            numeros[j + 1] = numeros[j]; // Move o valor para a direita
            j--;   
        }
        numeros[j + 1] = elemento_atual; // Insere o elemento_atual na posição correta
        
        System.out.println(Arrays.toString(numeros)); // Mostra o estado do array após cada inserção ordenada
        
        insertionSortRecursivo(numeros, index + 1); // Chamada recursiva para a próxima posição
    }
}
