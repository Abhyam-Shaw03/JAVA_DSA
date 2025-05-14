package recursion.medium;

/*
       Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sum to target.

    Each number in candidates may only be used once in the combination.

    Note: The solution set must not contain duplicate combinations.

    Example 1:

    Input: candidates = [10,1,2,7,6,1,5], target = 8
    Output:
    [
    [1,1,6],
    [1,2,5],
    [1,7],
    [2,6]
    ]

    Example 2:

    Input: candidates = [2,5,2,1,2], target = 5
    Output:
    [
    [1,2,2],
    [5]
    ]
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum_II {

    public void combinationSum(int ind, int[] arr, int k, int N, List<List<Integer>> ans, List<Integer> ds){
        if(ind == N || k == 0){
            if(k == 0){
                ans.add(new ArrayList<>(ds));
            }
            return;
        }

        for(int i = ind; i < N; i++){
            if(i > ind && arr[i] == arr[i - 1]) continue;
            if(arr[i] > k) break;
            ds.add(arr[i]);
            combinationSum(i+1, arr, k - arr[i], N, ans, ds);
            ds.remove(ds.size()-1);
        }

    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        combinationSum(0, candidates, target, candidates.length, ans, new ArrayList<>());
        return ans;
    }
}
