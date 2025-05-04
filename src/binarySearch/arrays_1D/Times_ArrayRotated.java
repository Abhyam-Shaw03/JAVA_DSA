package binarySearch.arrays_1D;
/*
    Given an integer array nums of size n, sorted in ascending order with distinct values. The array has been right rotated an unknown number of times, between 1 and n. Determine the number of rotations performed on the array.


    Examples:
    Input : nums = [4, 5, 6, 7, 0, 1, 2, 3]

    Output: 4

    Explanation: The original array should be [0, 1, 2, 3, 4, 5, 6, 7]. So, we can notice that the array has been rotated 4 times.

    Input: nums = [3, 4, 5, 1, 2]

    Output: 3

    Explanation: The original array should be [1, 2, 3, 4, 5]. So, we can notice that the array has been rotated 3 times.
*/

public class Times_ArrayRotated {
    public int findKRotation(int[] nums) {
        int n = nums.length;
        int low = 0, high = n-1;
        int mini = Integer.MAX_VALUE, rotated = -1;

        // IF ARRAYS IS COMPLETELY SORTED
        if (nums[low] <= nums[high]) {
            return n;
        }

        while(low <= high){
            int mid = (low + high) / 2;

            // IF LEFT SPACE IS SORTED
            if(nums[low] <= nums[mid]){
                // TAKE MINIMUM AS NUMS[LOW] AND MOVE TOWARDS RIGHT-UNSORTED SPACE
                if(mini > nums[low]){
                    mini = nums[low];
                    rotated = low;
                }
                low = mid + 1;
            }
            // IF RIGHT SPACE IS SORTED
            else{
                // TAKE MINIMUM AS NUMS[MID] AND MOVE TOWARDS LEFT-UNSORTED SPACE
                if(mini > nums[mid]){
                    mini = nums[mid];
                    rotated = mid;
                }
                high = mid - 1;
            }
        }
        return rotated;
    }
}
