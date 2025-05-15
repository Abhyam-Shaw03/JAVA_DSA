package recursion.medium;

import java.util.ArrayList;
import java.util.List;

public class AllPermutationof_anArray {

    /*
        // FOR EXTRA SPACE COMPLEXITY WHICH INCLUDES A HASHARRAY AND LIST<INTEGER>

    public void findAllPermutation(int[] nums, int N, List<List<Integer>> ans, boolean[] hash, List<Integer> ds){
        if(ds.size() == N){
            ans.add(new ArrayList<>(ds));
            return;
        }
        for(int i = 0; i < N; i++){
            if(!hash[i]){
                ds.add(nums[i]);
                hash[i] = true;
                findAllPermutation(nums, N, ans, hash, ds);
                ds.remove(ds.size()-1);
                hash[i] = false;
            }
        }
    }


    public List<List<Integer>> allPermutation(int[] nums){
        List<List<Integer>> ans = new ArrayList<>();
        boolean[] hash = new boolean[nums.length];
        findAllPermutation(nums,nums.length, ans, hash, new ArrayList<>());
        return ans;
    }
    */

    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void findAllPermutation(int ind, int[] nums, int N, List<int[]> ans){
        if(ind == N){
            ans.add(nums.clone()); // HERE USE .clone() TO COPY NOT THE ORIGINAL REFERRED ARRAY BUT THE CHANGED ONE.
            return;
        }
        for(int i = ind; i < N; i++){
            swap(nums, ind, i);
            findAllPermutation(ind+1, nums, N, ans);
            swap(nums, ind, i);
        }

    }

    public List<int[]> allPermutation(int[] nums){
        List<int[]> ans = new ArrayList<>();
        findAllPermutation(0, nums,nums.length, ans);
        return ans;
    }
}
