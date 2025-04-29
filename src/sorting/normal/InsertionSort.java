package sorting.normal;

public class InsertionSort {
    public void swap(int[] nums, int i , int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public int[] insertionSort(int[] nums) {
        int n = nums.length;
        if(n == 0) return new int[0];
        if(n == 1) return nums;
        for(int i = 1; i < n; i++){
            for(int j = i; j > 0; j--){
                if(nums[j] < nums[j-1]){
                    swap(nums, j , j-1);
                }else break;
            }
        }
        return nums;
    }
}
