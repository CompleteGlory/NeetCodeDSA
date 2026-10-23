package ArrayAlgorithms;

import Graphs.MatrixDFS;

public class KadaneAlgorithm {
    public int bruteForce(int[] nums){
        int maxSum = nums[0];
        for(int i=0;i<nums.length;i++){
            int sum = 0;
            for(int j=i;j<nums.length;j++){
                sum += nums[j];
                maxSum = Math.max(maxSum, sum);
            }
        }
        return maxSum;
    }

    public int kadanes(int[] nums){
        int maxSum = nums[0];
        int curSum = 0;
        for(int n : nums){
            curSum = Math.max(0, curSum);
            curSum += n ;
            maxSum = Math.max(maxSum, curSum);
        }
        return maxSum;
    }

    public int[] kadaneIndices(int[] nums){
        int maxSum = nums[0], curSum = 0, maxL = 0, maxR = 0, L = 0;
        for(int R = 0; R<nums.length;R++){
           if(curSum<0){
            curSum = 0;
            L=R;
           }
           curSum +=nums[R];
           if(curSum>maxSum){
            maxSum = curSum;
            maxL = L;
            maxR = R;
           }
        }

        return new int[]{maxL,maxR};
    }
}
