package sorting.normal;

public class BubbleSort {
    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public int[] bubbleSort(int[] nums) {
        int n = nums.length;
        for(int i = n-1; i >= 1; i--){
            int flag = 0;
            for(int j = 0; j < i; j++){
                if(nums[j] > nums[j+1]){
                    swap(nums, j, j+1);
                    flag = 1;
                }
            }
            if(flag == 0) break;
        }
        return nums;
    }
}
