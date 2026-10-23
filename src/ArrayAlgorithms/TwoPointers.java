package ArrayAlgorithms;

public class TwoPointers {
    public int[] indices(int[] nums,int target){
        int l =0;
        int r = nums.length-1;
        while(r>l){
            if(nums[r]+nums[l]>target){
                r--;
            }else if (nums[r]+nums[l]<target){
                l++;
            }else{
                return new int[]{l,r};
            }
        }
        return new int[]{-1,-1};
    }
}
