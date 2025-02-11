package questões;
import java.util.Scanner;

class EncontraQuebraRecursivo {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String[] entrada = sc.nextLine().split(" ");
        int[] num = new int[entrada.length];

        for (int i = 0; i < entrada.length; i++){
            num[i] = Integer.parseInt(entrada[i]);
        }

        int resultado = quebraRecursivo(num, 1);

        System.out.println(resultado);

    }

    private static int quebraRecursivo(int[] num, int index){
        if (index >= num.length){
            return -1;
        }
        if (num[index] < num[index - 1]){
            return index;
        }
        return quebraRecursivo(num, index + 1);
    }
}
