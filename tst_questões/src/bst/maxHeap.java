package bst;

import java.util.Collections;
import java.util.PriorityQueue;

public class maxHeap {
    public int kesimo(int[] v, int k){
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        
        for (int num : v){
            maxHeap.add(num);
        }

        for (int i = 0; i < k - 1; i++){
            maxHeap.poll();
        }
        return maxHeap.peek();
    }

}
