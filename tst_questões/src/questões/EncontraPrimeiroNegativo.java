package questões;
import java.util.Scanner;

class EncontraPrimeiroNegativo {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();
        String[] seq = input.split(" ");

        int[] numeros = new int[seq.length];
        for (int i = 0; i < seq.length; i++){
            numeros[i] = Integer.parseInt(seq[i]);
        }

        int resultado = primeiroNegativo(numeros, 0);

        if (resultado == Integer.MAX_VALUE){
            System.out.println("-");
        }else{
            System.out.println(resultado);
        }
        
    }

        private static int primeiroNegativo(int[] numeros, int i){
            if (i >= numeros.length){
                return Integer.MAX_VALUE;
            }
            if (numeros[i] < 0){
                return numeros[i];
            }
            return primeiroNegativo(numeros, i + 1);
        }
}