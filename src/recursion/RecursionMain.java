package recursion;

import java.util.ArrayList;
import java.util.List;

public class RecursionMain {
    public static void main(String[] args) {
//        Factorial factorial = new Factorial();
//        Fibonacci fibonacci = new Fibonacci();
//        System.out.println(fibonacci.fibonacci(2));
        SubsequenceWithSum_K subsequence_sumK = new SubsequenceWithSum_K();
//        Subsequence subsequence = new Subsequence();
        List<Integer> ans = new ArrayList<>();
        int[] arr = {1,2,1};
//        subsequence.allSubsequence(0, ans, arr, arr.length);

//        subsequence_sumK.allSubsequence(0,arr,ans,arr.length,2,0);
//        subsequence_sumK.onlyFirstSubsequenceOccurance(0, arr, ans, arr.length, 2, 0);
        int count = subsequence_sumK.countAllSubsequncesWithSum_K(0, arr, ans, arr.length, 2, 0,0);
        System.out.println(count);
    }
}
