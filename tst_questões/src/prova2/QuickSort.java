package prova2;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {

        int[] values = new int[]{3, 8, 7, 10, 23, 2, 1, 77, 8};
        quickSort(values, 0, values.length - 1);

        for (int value : values){
            System.out.print(value + " ");
        }
        System.out.println();
        
    }

    public static void quickSort(int[] values, int left, int right){
            if (left < right){
                int index_pivot = partition(values, left, right);

                // ordenação a esquerda do pivot
                quickSort(values, left, index_pivot - 1);

                // ordenação a direita do pivot
                quickSort(values, index_pivot + 1, right);
            }
    }

    private static int partition (int[] values, int left, int right){
        // escolhe o primeiro valor para ser o pivot
        int pivot = values[left];
        // indíce do pivot
        int i = left;

        // vai começar a iterar do elemento imediatamente ao pivot
        for (int j = i + 1; j <= right; j++){
            if (values[j] <= pivot){
                i++;
                int aux = values[i];
                values[i] = values[j];
                values[j] = aux;
            }
        }
        // troca pivot (values[left] com i)
        int aux = values[left];
        values[left] = values[i];
        values[i] = aux;

        return i;
    }

    private static int partitionHoare(int[] values, int left, int right){
        int pivot = values[left];
        int i = left + 1;
        int j = right;

        while (i <=j){
            while (i <= j && values[i] <= pivot){
                i++;
            }
            while (i <= j && values[j] > pivot){
                j++;
            }
            if(i < j){
                int aux = values[i];
                values[i] = values[j];
                values[j] = aux;
            }

        }
        int aux = values[left];
        values[left] = values[j];
        values[j] = aux;
        return j;

    }
    
    private int pickPivotIndexMedianaTres(int[] values, int left, int right){
        int mid = (left + right) / 2;

        int[] sorted = {values[left], values[mid], values[right]};
        Arrays.sort(sorted);

        if(sorted[1] == values[left]) return left;
        else if (sorted[1] == values[mid]) return mid;
        else return right;

    }

    private int pickPivotIndexRandom(int[] values, int left, int right){
        int range = right - left + 1;
        return (int)(Math.random() * range) + left;
    }
}
