package Heap;

import java.util.ArrayList;
import java.util.List;

public class Heap {
    List<Integer> heap;

    public Heap(){
        heap = new ArrayList<Integer>();
        heap.add(0);
    }

    public void push(int val){
        heap.add(val);
        int i = heap.size()-1;
        // percolate up
        while(i>1 && heap.get(i)< heap.get(i/2)){
            int temp = heap.get(i);
            heap.set(i,heap.get(i/2));
            heap.set(i/2,temp);
            i=i/2;
        }
    }

    public int pop(){
        if (heap.size() == 1) {
            return 0;
        }
        if (heap.size() == 2) {
            return heap.remove(heap.size() - 1);
            // equivalent to heap.remove(1)
        }
        int res = heap.get(1);
        heap.set(1,heap.remove(heap.size()-1));
        int i = 1;
        // while the next child exists percolate down
        while (2 * i < heap.size()) {
            int child = 2 * i;
            if (child + 1 < heap.size() && heap.get(child + 1) < heap.get(child)) child++;
            if (heap.get(i) <= heap.get(child)) break;
            swap(i, child, heap);
            i = child;
        }
        return res;
    }

    public void heapify(ArrayList<Integer> arr){
        // Sustain the structure property
        arr.add(arr.get(0));
        // sustain the order property for the half that has descendants.
        int cur = arr.size()/2;
        while(cur>0){
            int i = cur;
            // run percolate down for current
            int n = arr.size();
            while(2 * i < n) {
                int child = 2 * i;
                // get the smallest
                if (child + 1 < n && arr.get(child) > arr.get(child + 1)) child++;
                // no swap needed, current is in it's right position
                if (arr.get(i) <= arr.get(child)) break;
                swap(i,child,arr);
                i=child;
                }
                cur--;
            }

        }

    public void swap(int a , int b, List<Integer> arr){
        int temp = arr.get(a);
        arr.set(a,arr.get(b));
        arr.set(b,temp);
    }
}
