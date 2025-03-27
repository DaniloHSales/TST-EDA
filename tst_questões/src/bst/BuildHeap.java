package bst;

import java.util.*;

public class BuildHeap {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] entrada = sc.nextLine().split(" ");

        int[] v = new int[entrada.length];
        for (int i = 0; i < entrada.length; i++){
            v[i] = Integer.parseInt(entrada[i]);
        }
        Heap h = new Heap(v);
        h.BuildHeap();
        h.printHeap();
        Arrays.toString(v);

    }

}

class Heap {
    int tail;
    int[] heap;

    /* public Heap(int capacidade){
        this.heap = new int[capacidade];
        this.tail = -1;
    } */

    public Heap(int[] heap){
        this.heap = heap;
        this.tail = heap.length - 1;
        BuildHeap();
    }

    public void printHeap() {
        System.out.println(Arrays.toString(Arrays.copyOfRange(heap, 0, tail + 1)));
    }

    public void BuildHeap(){
        for (int i = parent(tail); i >= 0; i--){
            heapify(i);
        }
    }

    public void heapify(int index){
        if ((index > parent(tail) && index <= tail) || (!isValidIndex(index))) return;

        int index_max = maxIndex(index, left(index), right(index));

        if (index_max != index){
            swap(index, index_max);
            heapify(index_max); 
        }
    }

    private int maxIndex(int index, int left, int right){
        int max = index;
        if (isValidIndex(left) && this.heap[left] > this.heap[max]) max = left;

        if (isValidIndex(right) && this.heap[right] > this.heap[max]) max = right;

        return max;
    }

    private void swap(int i, int j){
        int aux = this.heap[i];
        this.heap[i] = this.heap[j];
        this.heap[j] = aux;
    }

    public boolean isValidIndex(int index){
        return index >= 0 && index <= tail;
    }

    public boolean isEmpty(){
        return this.tail == -1;
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

    public int size() {
        return this.tail + 1;
    }
    
    public String toString() {
        return Arrays.toString(this.heap);
    }

}

