package binarySearch.arrays_1D;

// THIS IS USING BASIC BINARY SEARCH APPLIED TWICE:
//      ONCE TO FIND THE FIRST INDEX OF OCCURANCE
//      SECOND TO FIND THE LAST INDEX OF OCCURANCE

public class FirstAndLastOccurance {
    public int firstIndex(int[] nums, int target){
        int n = nums.length;
        int low = 0, high = n-1,ans = -1;
        while(low <= high){
            int mid = (low + high)/2;
            if(nums[mid] == target){
                ans = mid;
                high = mid - 1;
            }else if(nums[mid] < target){
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        return ans;
    }

    public int lastIndex(int[] nums, int target){
        int n = nums.length;
        int low = 0, high = n-1,ans = -1;
        while(low <= high){
            int mid = (low + high)/2;
            if(nums[mid] == target){
                ans = mid;
                low = mid + 1;
            }else if(nums[mid] < target){
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        return ans;
    }

    public int[] searchRange(int[] nums, int target) {
        int first = firstIndex(nums, target);
        int n = nums.length;
        if (first == -1 || first == n || nums[first] != target) {
            return new int[]{-1, -1};
        }
        return new int[]{first, lastIndex(nums, target)};
    }
}

//THIS IS BASICALLY USING UPPER BOUND AND LOWER BOUND CONCEPT
//public class FirstAndLastOccurance {
//    public int lowerBound(int[] nums, int target){
//        int n = nums.length;
//        int low = 0, high = n-1,ans = -1;
//        while(low <= high){
//            int mid = (low + high)/2;
//            if(nums[mid] >= target){
//                ans = mid;
//                high = mid - 1;
//            }else{
//                low = mid + 1;
//            }
//        }
//        return ans;
//    }
//
//    public int upperBound(int[] nums, int target){
//        int n = nums.length;
//        int low = 0, high = n-1,ans = -1;
//        while(low <= high){
//            int mid = (low + high)/2;
//            if(nums[mid] > target){
//                ans = mid;
//                high = mid - 1;
//            }else{
//                low = mid + 1;
//            }
//        }
//        return ans;
//    }
//
//    public int[] searchRange(int[] nums, int target) {
//        int lb = lowerBound(nums, target);
//        int n = nums.length;
//        if (lb == -1 || lb == n || nums[lb] != target) {
//            return new int[]{-1, -1};
//        }
//        return new int[]{lb, upperBound(nums, target) - 1};
//    }
//}
