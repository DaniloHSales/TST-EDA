package questões;
import java.util.Scanner;

class Fibonacci {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();

        int resultado = fibonacci(num);
        System.out.println(resultado);
    }

    private static int fibonacci(int num){
        if (num <= 1){
            return num;
        }
        return fibonacci(num - 1) + fibonacci(num - 2);
    }
}
