package recursion.medium;

import java.util.List;

public class Subsequence {

    public void print(List<Integer> ans){
        if(ans.isEmpty()){
            System.out.println("{}");
        }
        else{
            System.out.print("{ ");
            for(int i : ans){
                System.out.print(i + " ");
            }
            System.out.println(" }");
        }
    }

    public void allSubsequence(int index, List<Integer> ans, int[] arr, int n){
        if(index >= n){
            print(ans);
            return;
        }
        ans.add(arr[index]);
        allSubsequence(index + 1, ans, arr, n);
        ans.removeLast();
        allSubsequence(index + 1, ans , arr, n);
    }
}
