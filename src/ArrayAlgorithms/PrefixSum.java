package ArrayAlgorithms;

import java.util.ArrayList;

public class PrefixSum {
    ArrayList<Integer> prefix;
    public void init(ArrayList<Integer> nums){
        prefix = new ArrayList<>();
        int total = 0;
        for(int num:nums){
            total+=num;
            prefix.add(total);
        }
    }

    public int rangeSum(int left, int right){
        int preRight = prefix.get(right);
        int preLeft = left > 0 ? prefix.get(left-1):0;
        return preRight - preLeft;
    }
}
