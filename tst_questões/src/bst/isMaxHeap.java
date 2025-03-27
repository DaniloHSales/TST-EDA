
package bst;

import java.util.*;


public class isMaxHeap {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] entrada = sc.nextLine().split(" ");

        int[] v = new int[entrada.length];
        for (int i = 0; i < entrada.length; i++){
            v[i] = Integer.parseInt(entrada[i]);
        }
        Heap1 h = new Heap1(v.length);
        for (int num : v){
            h.add(num);
        }
        System.out.println(h.isMaxHeap(v));
    }
}

class Heap1 {
    int tail;
    int[] heap;

    public Heap1(int capacidade){
        this.tail = -1;
        this.heap = new int[capacidade];
    }


    public boolean isMaxHeap(int[] heap){
        int n = heap.length;
 
        for (int i = 0; i <= (n - 2) / 2; i++) {  // Percorre apenas os nós que possuem filhos
            int left = 2 * i + 1;
            int right = 2 * i + 2;

            if (left < n && heap[i] < heap[left]) return false;  // Filho esquerdo maior que o pai
            if (right < n && heap[i] < heap[right]) return false;  // Filho direito maior que o pai
        }
        return true;
    }

    public boolean isValidIndex(int index){
        return index >= 0 && index <= tail;

    }

    public int left(int i){return 2 * i + 1;}

    public int right(int i){return 2*i + 2;}

    public int parent(int i){return (i-1)/2;}

    public void add(int element){
        if (this.tail >= heap.length-1) resize();

        this.tail++;
        this.heap[tail] = element;

        int i = tail;
        while (i > 0 && this.heap[parent(i)] < this.heap[i]){
            int aux = heap[i];
            heap[i] = heap[parent(i)];
            heap[parent(i)] = aux;
            i = parent(i);
        }
    }

    private void resize() {
        int[] novoHeap = new int[this.heap.length * 2];
        for (int i = 0; i <= tail; i++)
            novoHeap[i] = this.heap[i];
        
        this.heap = novoHeap;
    }

}
