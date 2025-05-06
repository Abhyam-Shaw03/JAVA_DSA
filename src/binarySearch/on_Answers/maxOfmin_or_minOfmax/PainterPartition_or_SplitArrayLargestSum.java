package binarySearch.on_Answers.maxOfmin_or_minOfmax;

/*
    Given an integer array nums and an integer k, split nums into k non-empty subarrays such that the largest sum of any subarray is minimized.
    Return the minimized largest sum of the split.
    A subarray is a contiguous part of the array.

    Example 1:

    Input: nums = [7,2,5,10,8], k = 2
    Output: 18
    Explanation: There are four ways to split nums into two subarrays.
    The best way is to split it into [7,2,5] and [10,8], where the largest sum among the two subarrays is only 18.
    Example 2:

    Input: nums = [1,2,3,4,5], k = 2
    Output: 9
    Explanation: There are four ways to split nums into two subarrays.
    The best way is to split it into [1,2,3] and [4,5], where the largest sum among the two subarrays is only 9.
*/

public class PainterPartition_or_SplitArrayLargestSum {

    public int[] range(int[] nums){
        int maxi = Integer.MIN_VALUE, sum = 0;
        for(int i : nums){
            maxi = Math.max(maxi, i);
            sum += i;
        }
        return new int[]{maxi, sum};
    }

    public boolean subArraySum(int[] nums, int k, int mid, int n){
        int sum = nums[0], parts = 1;
        for(int i = 1; i < n; i++){
            if(sum + nums[i] <= mid){
                sum += nums[i];
            }else{
                parts++;
                sum = nums[i];
            }
        }
        return (parts <= k);
    }

    public int splitArray(int[] nums, int k) {
        int n = nums.length;
        if(n < k) return -1;
        int[] arr = new int[2];
        arr = range(nums);
        int low = arr[0], high = arr[1];
        while(low <= high){
            int mid = (low + high) / 2;
            if(subArraySum(nums, k, mid,n))
                high = mid - 1;
            else low = mid + 1;
        }
        return low;
    }
}
