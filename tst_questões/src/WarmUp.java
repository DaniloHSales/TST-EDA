import java.util.Scanner;

class WarmUp {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        
        int n = Integer.parseInt(sc.nextLine());

        String[] numeros = sc.nextLine().split(" ");
        String out = "";

        for (int i = 0; i < numeros.length; i++){
            out += Integer.toString((Integer.parseInt(numeros[i])*n)) + " ";
        }

        System.out.println(out.trim());

    }
}
