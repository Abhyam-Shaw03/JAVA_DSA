package sorting.recursive;

public class RecursiveInsertionSort {
    public void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public void sort(int[] arr, int i, int n){
        if(i == n) return;
        int j = i;
        while(j > 0 && arr[j] < arr[j-1]){
            swap(arr, j, j-1);
            j--;
        }
        sort(arr, i+1, n);
    }
}
