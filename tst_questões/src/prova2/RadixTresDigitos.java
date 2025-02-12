import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] inputNumbers = scanner.nextLine().split(" ");
        int d = scanner.nextInt();
        scanner.close();
        
        int[] numbers = new int[inputNumbers.length];
        for (int i = 0; i < inputNumbers.length; i++) {
            numbers[i] = Integer.parseInt(inputNumbers[i]);
        }
        
        radixSortThreeDigits(numbers, d);
    }
    
    private static void radixSortThreeDigits(int[] numbers, int d) {
        int n = numbers.length;
        
        for (int exp = 3; exp <= d; exp += 3) {
            countingSort(numbers, n, exp);
            printArray(numbers);
        }
    }
    
    private static void countingSort(int[] numbers, int n, int exp) {
        int[] output = new int[n];
        int[] count = new int[1000]; // De 000 a 999
        
        Arrays.fill(count, 0);
        
        for (int i = 0; i < n; i++) {
            int index = getThreeDigits(numbers[i], exp);
            count[index]++;
        }
        
        for (int i = 1; i < 1000; i++) {
            count[i] += count[i - 1];
        }
        
        for (int i = n - 1; i >= 0; i--) {
            int index = getThreeDigits(numbers[i], exp);
            output[count[index] - 1] = numbers[i];
            count[index]--;
        }
        
        System.arraycopy(output, 0, numbers, 0, n);
    }
    
    private static int getThreeDigits(int num, int exp) {
        String numStr = String.format("%0" + exp + "d", num);
        return Integer.parseInt(numStr.substring(numStr.length() - exp, numStr.length() - exp + 3));
    }
    
    private static void printArray(int[] numbers) {
        System.out.println(Arrays.toString(numbers));
    }
}
