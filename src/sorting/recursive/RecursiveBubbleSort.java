package sorting.recursive;

public class RecursiveBubbleSort {
    public void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    /*
        public void sort(int[] arr, int i, int j, int flag){
            if(i <= 0) return;

            if(arr[j] > arr[j+1]){
                swap(arr, j, j+1);
                flag = 1;
            }
            if(j < i-1)
                sort(arr, i, j+1, flag);
            else {
                if(flag == 0) return;
                for (int k : arr) {
                    System.out.print(k + " ");
                }
                System.out.println();
                sort(arr, i - 1, 0, 0);
            }
        }
    */
    public void sort(int[] arr, int i, int flag){
        if(i == 0) return;
        for(int j = 0; j <= i-1; j++){
            if(arr[j] > arr[j+1]) {
                swap(arr, j, j + 1);
                flag = 1;
            }
        }
        if(flag == 0) return;
        sort(arr, i-1, 0);
    }
}
