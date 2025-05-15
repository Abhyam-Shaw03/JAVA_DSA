package recursion.medium;
/*
    Given an array nums of n integers.Return sum of all subsets of the array nums.

    Output can be printed in any order.

    Examples:
    Input : nums = [2, 3]
    Output : [0, 2, 3, 5]

    Explanation :
    When no elements is taken then Sum = 0.
    When only 2 is taken then Sum = 2.
    When only 3 is taken then Sum = 3.
    When element 2 and 3 are taken then sum = 2+3 = 5.

    Input : nums = [5, 2, 1]
    Output : [0, 1, 2, 3, 5, 6, 7, 8]

    Explanation :
    When no elements is taken then Sum = 0.
    When only 5 is taken then Sum = 5.
    When only 2 is taken then Sum = 2.
    When only 1 is taken then Sum = 1.
    When element 2 and 1 are taken then sum = 2+1 = 3.

*/

import java.util.ArrayList;
import java.util.List;

public class SubsetSum_I {

    public void sumOfAllSubset(int ind, int[] nums, int N, List<Integer> ans, int sum){
        if(ind == N){
            ans.add(sum);
            return;
        }
        //PICKING THE ELEMENT AND MOVE TO NEXT INDEX
        sumOfAllSubset(ind + 1, nums, N, ans, sum + nums[ind]);
        // NOT PICKING THE ELEMENT AND MOVIE TO NEXT INDEX
        sumOfAllSubset(ind + 1, nums, N, ans, sum);
    }

    public List<Integer> subsetSums(int[] nums) {
        //your code goes here
        List<Integer> ans = new ArrayList<>();
        sumOfAllSubset(0, nums, nums.length, ans, 0);
        return ans;
    }

}
