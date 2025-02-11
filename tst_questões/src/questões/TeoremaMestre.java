package questões;
import java.util.Scanner;

class TeoremaMestre {
    public static void main (String[] args) {

        Scanner sc = new Scanner(System.in);

        String[] entrada = sc.nextLine().split(" ");

        int a = Integer.parseInt(entrada[0]);
        int b = Integer.parseInt(entrada[1]);
        int ord = Integer.parseInt(entrada[2]);

        if (ord > log(b, a)) {
            System.out.format("T(n) = theta(n**%d)\n", ord);
        } else {
            System.out.format("T(n) = theta(n**%d * log n)\n", (int) log(b, a));
        }
    }
      
    private static double log (double base, double valor) {
        return Math.log(valor) / Math.log(base);
    }
}