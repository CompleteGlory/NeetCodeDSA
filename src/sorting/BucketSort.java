package sorting;

public class BucketSort {
    public int[] sort(int[] arr, int k){
        int[] freq = new int[k];
        for(int i = 0; i<arr.length;i++){
            freq[arr[i]]++;
        }
        int i = 0;
        for(int n = 0; n<freq.length;n++){
            for(int j = 0; j<freq[n];j++){
                arr[i]=n;
                i++;
            }
        }
        return arr;
    }
}
