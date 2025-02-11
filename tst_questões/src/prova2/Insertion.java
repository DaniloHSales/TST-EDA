package prova2;

public class Insertion {

    public static void main(String[] args) {
        int[] v = new int[]{0,4,6,1,9,0};

        insertionSort(v);
    }
        
    private static void insertionSort(int[] v) {
        for(int i = 1; i < v.length; i++){
            int j = i;
            while (j > 0 && v[j] < v[j-1]){
                int aux = v[j];
                v[j] = v[j-1];
                v[j-1] = aux;
                j -= 1;
            }
        }
    }

}
