package bst;

import java.util.PriorityQueue;

public class minHeap {
    public int kesimo(int[] v, int k){
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int num : v){
            minHeap.add(num);
            if (minHeap.size() > k){
                minHeap.poll();
            }
        }
        return minHeap.peek();
    }
}
