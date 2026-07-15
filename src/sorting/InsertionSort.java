package sorting;

public class InsertionSort {
    public void sort(int[] arr){
        for(int i = 1; i < arr.length; i++){
            int j = i-1;
            while(j>=0 && arr[j+1]<arr[j]){
                // the second condition is for the previous element
                // will always be the greatest for the previous part is always sorted
                _swapInPlace(arr,j,j+1);
                j--;
            }
        }
    }
    private void _swapInPlace(int[] arr , int a , int b){
        int temp = arr[a];
        arr[a]=arr[b];
        arr[b]=temp;
    }
}
