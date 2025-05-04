package binarySearch.arrays_1D;
/*
    There is an integer array nums sorted in non-decreasing order (not necessarily with distinct values).

    Before being passed to your function, nums is rotated at an unknown pivot index k (0 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,4,4,5,6,6,7] might be rotated at pivot index 5 and become [4,5,6,6,7,0,1,2,4,4].

    Given the array nums after the rotation and an integer target, return true if target is in nums, or false if it is not in nums.

    You must decrease the overall operation steps as much as possible.



    Example 1:

    Input: nums = [2,5,6,0,0,1,2], target = 0
    Output: true
    Example 2:

    Input: nums = [2,5,6,0,0,1,2], target = 3
    Output: false
*/

public class RotatedSortedArray_2 {
    public boolean search(int[] nums, int k) {
        int n = nums.length;
        int low = 0, high = n-1;
        while(low <= high){
            int mid = (low + high)/2;
            if(nums[mid] == k) return true;
            // EXTRA EDGE CASE TO ADD IN CASE OF DUPLICATES
            if(nums[low] == nums[mid] && nums[mid] == nums[high]){
                low = low + 1;
                high = high - 1;
                continue;// THIS IS DONE TO AGAIN CHECK IF THIS CONDITION RE-APPEARS
            }
            // LEFT HALF IS SORTED
            if(nums[low] <= nums[mid]){
                if(k >= nums[low] && k < nums[mid]){
                    high = mid - 1;
                }else{
                    low = mid + 1;
                }
                // RIGHT HALF IS SORTED
            }else{
                if(k > nums[mid] && k <= nums[high])
                    low = mid + 1;
                else
                    high = mid - 1;
            }
        }
        return false;
    }
}
