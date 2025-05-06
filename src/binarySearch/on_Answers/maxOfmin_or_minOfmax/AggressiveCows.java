package binarySearch.on_Answers.maxOfmin_or_minOfmax;

/*
    Given an array nums of size n, which denotes the positions of stalls, and an integer k, which denotes the number of aggressive cows, assign stalls to k cows such that the minimum distance between any two cows is the maximum possible. Find the maximum possible minimum distance.


    Examples:
    Input: n = 6, k = 4, nums = [0, 3, 4, 7, 10, 9]

    Output: 3

    Explanation: The maximum possible minimum distance between any two cows will be 3 when 4 cows are placed at positions [0, 3, 7, 10]. Here the distances between cows are 3, 4, and 3 respectively. We cannot make the minimum distance greater than 3 in any ways.

    Input : n = 5, k = 2, nums = [4, 2, 1, 3, 6]

    Output: 5

    Explanation: The maximum possible minimum distance between any two cows will be 5 when 2 cows are placed at positions [1, 6].
*/

import java.util.Arrays;

public class AggressiveCows {
    public int range(int[] nums){
        int maxi = Integer.MIN_VALUE, mini = Integer.MAX_VALUE;
        for(int i : nums){
            maxi = Math.max(maxi, i);
            mini = Math.min(mini, i);
        }
        return (maxi-mini);
    }

    public boolean cowsPlace(int[] nums, int distance, int k){
        int n = nums.length;
        int countCows = 1, last = nums[0];
        for(int i = 1; i < n; i++){
            if(nums[i] - last >= distance){
                countCows++;
                last = nums[i];
            }
            if(countCows >= k) return true;
        }
        return false;
    }

    public int aggressiveCows(int[] nums, int k) {
        Arrays.sort(nums);
        int low = 1, high = range(nums);
        while(low <= high){
            int mid = (low + high)/2;
            if(cowsPlace(nums, mid, k))
                low = mid + 1;
            else high = mid - 1;
        }
        return high;
    }
}
