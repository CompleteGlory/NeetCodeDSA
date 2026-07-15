package sorting;

public class MergeSort {
    public int[] mergeSort(int[] arr, int s,int e){
        if(e-s+1 <= 1){
            return arr;
        }
        int m = (s+e) / 2;
        mergeSort(arr,s,m);
        mergeSort(arr, m+1,e);

        _merge(arr,s,m,e);
        return arr;
    }

    private void _merge(int[] arr, int s , int m , int e){
        // Find lengths of two subarrays to be merged
        int l1 = m-s+1;
        int l2 = e-m;

        // Create temp arrays
        int[] L = new int[l1];
        int[] R = new int[l2];

        // copy the sorted left and right halfs to temp arrays
        for(int i = 0; i< l1;i++){
            L[i]=arr[s+i];
        }

        for(int j = 0; j<l2;j++){
            R[j] = arr[m+j+1];
        }

        // initial indexes for left and right subarrays
        int i = 0;
        int j = 0;
        int k = s;

        // merge two sorted halfs into the original array
        while(i<l1 && j<l2){
            if(L[i]<=R[j]){
                arr[k]=L[i];
                i++;
            }else{
                arr[k]=R[j];
                j++;
            }
            k++;
        }

        // copy the remainder of L[] if any
        while(i<l1){
            arr[k]=L[i];
            i++;
            k++;
        }
        // copy the remainder of R[] if any
        while(j<l2){
            arr[k]=R[j];
            j++;
            k++;
        }
    }
}
