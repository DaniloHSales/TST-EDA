package prova2;

import java.util.Arrays;

public class Selection {
    public static void main(String[] args) {
        int[] v = new int[]{0,4,6,1,9,0};

        selectionSort(v);
        System.out.println(Arrays.toString(v));
    }
        
    private static void selectionSort(int[] v) {
        for (int i = 0; i < v.length; i++){
            int index_menor = i;
            for (int j = i + 1; j < v.length; j++){
                if (v[j] < v[index_menor]){
                    index_menor = j;
                }
            }
            int aux = v[i];
            v[i] = v[index_menor];
            v[index_menor] = aux;
        }
    }

}
