package prova2;

import java.util.Arrays;

public class CountingSort {

    public static void main(String[] args) {
        
        int[] A = new int[]{3, 2, 4, 7, 4, 7, 1, 2, 3};

        System.out.print(Arrays.toString((countingSort(A, 7))));
    }

    

    private static int[] countingSort(int[] A, int k){

            // frequency
            int[] C = new int[k];
            
            for (int i = 0; i < A.length; i++){
                C[A[i] - 1] += 1;
            }

            // accumulate
            for (int i = 1; i < C.length; i++){
                C[i] += C[i - 1];
            }

            // sort
            int[] B = new int[A.length];
            for (int i = A.length - 1; i >= 0; i--){
                B[C[A[i] -1] -1] = A[i];
                C[A[i] - 1] -= 1;
            }

            return B;
    }


    



}
