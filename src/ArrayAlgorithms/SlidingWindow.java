package ArrayAlgorithms;

import java.util.HashSet;

public class SlidingWindow {
    // Fixed Size
    // return true if there are two elements within a window of size k that are
    // equal
    public Boolean closeDuplicates(int[] nums, int k) {
        HashSet<Integer> set = new HashSet<>();
        int l = 0;
        for (int r = 0; r < nums.length; r++) {
            if (r - l + 1 > k) {
                set.remove(nums[l]);
                l++;
            }
            if (set.contains(nums[r])) {
                return true;
            }
            set.add(nums[r]);
        }
        return false;
    }

    // variable size
    // Find the length of the longest subarray with the same value at each position
    public int longestSubarray(int[] nums) {
        int l = 0;
        int current = 1;
        int max = 1;
        for (int r = 1; r < nums.length; r++) {
            if (nums[l] != nums[r]) {
                max = Math.max(max, current);
                l = r;
                current = 1;
            } else {
                current++;
            }
        }
        return Math.max(max, current);
    }

    // find the minimum lentgh subarray, where the sum is greater than or equal to
    // target
    public int shorterSubarray(int[] nums, int target) {
        int ans = Integer.MAX_VALUE;
        int l = 0;
        int curSum = 0;
        for (int r = 0; r < nums.length; r++) {
            curSum += nums[r];
            while (l <= r && curSum >= target) {
                ans = Math.min(ans, r - l + 1);
                curSum -= nums[l];
                l++;
            }
        }
       return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}