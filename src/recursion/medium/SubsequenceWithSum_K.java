package recursion.medium;

import java.util.List;

public class SubsequenceWithSum_K {

    public void print(List<Integer> ans){
        System.out.print("{ ");
        for(int i : ans)
            System.out.print(i + " ");
        System.out.println(" }");
    }

    public void allSubsequence(int i, int[] arr, List<Integer> ans, int n, int k, int sum){
        if(i == n){
            if(sum == k){
                print(ans);
            }
            return;
        }
        ans.add(arr[i]);
        sum += arr[i];
        allSubsequence(i+1, arr,ans, n,k,sum);
        sum -= arr[i];
        ans.removeLast();
        allSubsequence(i+1, arr, ans, n, k, sum);
    }

    public boolean onlyFirstSubsequenceOccurance(int i, int[] arr, List<Integer> ans, int n, int k, int sum){
        if(i == n){
            if(sum == k){
                print(ans);
                return true;
            }
            return false;
        }
        ans.add(arr[i]);
        sum += arr[i];
        if(onlyFirstSubsequenceOccurance(i+1, arr, ans, n, k, sum)) return true;
        sum -= arr[i];
        ans.removeLast();
        if(onlyFirstSubsequenceOccurance(i+1, arr, ans, n,k, sum)) return true;
        return false;
    }

//    public int countAllSubsequncesWithSum_K(int i, int[] arr, int n, int k, int sum){
//        if(i == n){
//            if(sum == k) return 1;
//            else return 0;
//        }
//        sum += arr[i];
//        int l = countAllSubsequncesWithSum_K(i+1, arr, n,k,sum);
//        sum -= arr[i];
//        int r = countAllSubsequncesWithSum_K(i+1, arr, n, k, sum);
//        return l+r;
//    }

    public int countAllSubsequncesWithSum_K(int i, int[] arr, int n, int k, int sum, int cnt){
        if(i == n){
            if(sum == k) return cnt+1;
            return cnt;
        }
        sum += arr[i];
        cnt = countAllSubsequncesWithSum_K(i+1, arr, n,k,sum,cnt);
        sum -= arr[i];
        cnt = countAllSubsequncesWithSum_K(i+1, arr, n, k, sum,cnt);
        return cnt;
    }
}
