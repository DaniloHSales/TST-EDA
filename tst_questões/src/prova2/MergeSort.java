package prova2;

public class MergeSort {
    public static void main(String[] args) {
        
        // merge sort = recursively divide array in 2, sort, re-combine
        // run-time complexity = O(n Log n)
        // space complexity = O(n)
        
        int[] v = {8, 2, 5, 3, 4, 7, 6, 1};

        mergeSort(v, 0, v.length - 1);

        for (int i = 0; i < v.length; i++){
            System.out.print(v[i] + " ");
        }
    }

    public static void mergeSort(int[] v, int left, int right) {
		
		if (left < right) {
			
			int middle = (left + right) / 2;
			mergeSort(v, left, middle);
			mergeSort(v, middle + 1, right);
	
			merge(v, left, right);
		}
    }

	public static void merge(int[] v, int left, int right) {
		
		// transfere os elementos entre left e right para o array auxiliar.
		int rightHelper = right - left;
		int[] helper = new int[rightHelper + 1];
		for (int i = 0; i <= rightHelper; i++) {
			helper[i] = v[left + i];
		}
		
		int middleHelper = rightHelper / 2;

		int i = 0;
		int j = middleHelper + 1;
		int k = left;
		
		while (i <= middleHelper && j <= rightHelper) {
			
			if (helper[i] <= helper[j]) {
				v[k] = helper[i];
				i++;
			} else {
				v[k] = helper[j];
				j++;
			}
			k++;
			
		}
		
		// se a metade inicial não foi toda consumida, faz o append.
		while (i <= middleHelper) {
			v[k] = helper[i];
			i++;
			k++;
		}

		// Não precisamos nos preocupar se a metade final foi
		// toda consumida, já que, se esse foi o caso, ela já está
		// no array final.
    }
}