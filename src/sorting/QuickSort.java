package sorting;

public class QuickSort {
    public int[] quickSort(int[] arr, int s, int e){
        if(e-s+1<=1){
            return arr;
        }

        int pivot = arr[e];
        int left = s;
        for(int i = s ; i<e;i++){
            if(arr[i]<pivot){
                _swapInPlace(arr,left,i);
                left++;
            }
        }
        arr[e]=arr[left];
        arr[left]=pivot;
        quickSort(arr,s,left-1);
        quickSort(arr,left+1,e);
        return arr;
    }
    private void _swapInPlace(int[] arr , int a , int b){
        int temp = arr[a];
        arr[a]=arr[b];
        arr[b]=temp;
    }
}
