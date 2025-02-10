


public class QuickSortLomuto {

    public static void main(String[] args) {

        int[] values = new int[]{3, 8, 7, 10, 23, 2, 1, 77, 8};

        quickSort(values, 0, values.length - 1);

        for (int value : values){
            System.out.print(value + " ");
        }
        System.out.println();
        
    }

    private static int partition (int[] values, int left, int right){
        // escolhe o primeiro valor para ser o pivot
        int pivot = values[left];

        // indíce do pivot
        int i = left;

        // vai começar a iterar do elemento imediatamente ao pivot
        for (int j = left + 1; j <= right; j++){
            if (values[j] <= pivot){
                i++;
                swapp(values, i, j);
            }
        }
        // troca pivot (values[left] com i)
        swap(values, left, i);
        
                return i;
            }
        
    private static void swap (int[] values, int left, int i){
        int auxi = values[left];
        values[left] = values[i];
        values[i] = auxi;
    }
    
    private static void swapp(int[] values, int i, int j){
        int auxi = values[i];
        values[i] = values[j];
        values[j] = auxi;
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
}
