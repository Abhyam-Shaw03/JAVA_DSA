package sorting.normal;

public class SelectionSort {
    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public int[] selectionSort(int[] nums) {
        int n = nums.length;
        for(int i = 0; i < n-1; i++){
            int mini = i;
            for(int j = i+1; j < n; j++){
                if(nums[j] < nums[mini])
                    mini = j;
            }
            swap(nums, i, mini);
        }
        return nums;
    }
}
