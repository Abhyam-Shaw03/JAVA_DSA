package recursion.hard;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
    Given an integer array nums that may contain duplicates, return all possible subsets (the power set).

    The solution set must not contain duplicate subsets. Return the solution in any order.

    Example 1:
    Input: nums = [1,2,2]
    Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]

    Example 2:
    Input: nums = [0]
    Output: [[],[0]]

*/
public class SubsetSum_II {

    public void getAllCombination(int ind, int[] nums, int N, List<List<Integer>> ans, List<Integer> ds){
//        if(ind == N){
//            ans.add(new ArrayList<>(ds));
//            return;
//        }
        ans.add(new ArrayList<>(ds));
        for(int i = ind; i < N; i++){
            if(i != ind && nums[i] == nums[i-1]) continue;
            ds.add(nums[i]);
            getAllCombination(i+1, nums, N, ans, ds);
            ds.remove(ds.size() - 1);
        }
    }

    public List<List<Integer>> subsetSum_II(int[] nums){
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        getAllCombination(0, nums, nums.length, ans, new ArrayList<>());
        return ans;
    }
}
