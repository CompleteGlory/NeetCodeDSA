import java.util.Arrays;
import sorting.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        int[] nums = {2,1,2,0,0,2};
        int[] arr = {3,1,2,5,4};
        //        InsertionSort insertion = new InsertionSort();
        //        insertion.sort(nums);
        //        MergeSort merge = new MergeSort();
        //        merge.mergeSort(nums,0,nums.length-1);
        QuickSort quick = new QuickSort();
        quick.quickSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
        BucketSort bucket = new BucketSort();
        bucket.sort(nums,3);
        System.out.println(Arrays.toString(nums));
    }
}