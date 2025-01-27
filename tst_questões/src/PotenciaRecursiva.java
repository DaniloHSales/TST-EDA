import java.util.Scanner;

class PotenciaRecursiva {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        int i = Integer.parseInt(sc.nextLine());

        int j = Integer.parseInt(sc.nextLine());

        int resultado = potenciaRecursiva(i, j);
        System.out.println(resultado);

    }
    public static int potenciaRecursiva(int base, int expoente) {
        if (expoente == 0) {
            return 1;
        }
        return base * potenciaRecursiva(base, expoente - 1);
    }
}