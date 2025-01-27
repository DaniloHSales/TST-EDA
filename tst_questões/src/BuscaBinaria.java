import java.util.Scanner;

class BuscaBinaria {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] input = sc.nextLine().split(" ");
        int[] numeros = new int[input.length];

        for (int i = 0; i < input.length; i++){
            numeros[i] = Integer.parseInt(input[i]);
        }
        
        int num = Integer.parseInt(sc.nextLine());

        System.out.println(buscaBinaria(numeros, num, 0, numeros.length - 1));
            
    }
        
    private  static int buscaBinaria(int[] numeros, int num, int ini, int fim) {
        int meio = (ini + fim)/2;
        int retorno = -1;

        if (numeros[meio] == num){
            retorno = meio;
            
        }else{
            System.out.println(meio);
            if (ini < fim){
                if (num < numeros[meio]){
                    // meio - 1 é o fim, pois o num buscado está do meio para a esquerda
                    return buscaBinaria(numeros, num, ini, meio - 1);
                }
                else{
                    // meio + 1 é o ini, pois o num buscado está do meio para a direita
                    return buscaBinaria(numeros, num, meio + 1, fim);
                }
            }
        }
        return retorno;
    }
}
