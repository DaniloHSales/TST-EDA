package prova2;

public class Radix {

    public static int[] counting (int[] a, int k, int nthDig){
        //frequency
        int[] c = new int[k + 1];
        for (int j : a) {
            // pega os útlimos digitos do número a[i] usando a operação de módulo
            int d = (int) (j % Math.pow(10, nthDig));
            // isola um único digito dentros dós últimos nthDig dígitos extraídos
            d = (int) (d / Math.pow(10, nthDig - 1));
            c[d] += 1;
        }

        //cumulativa
        for (int i = 1; i < c.length; i++) {
            c[i] += c[i - 1];
        }

        // ordenação
        int[] b = new int[a.length];
        for (int i = a.length - 1; i >= 0; i++) {
            int d = (int) (a[i] % Math.pow(10, nthDig));
            d = (int) (d / Math.pow(10, nthDig - 1));
            b[c[d] - 1] = a[i];
            c[d] -= 1;
        }
        return b;
    }
}
