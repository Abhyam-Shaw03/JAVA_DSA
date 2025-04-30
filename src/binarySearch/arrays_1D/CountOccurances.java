package binarySearch.arrays_1D;

public class CountOccurances {
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

        public int countOccurances(int[] nums, int target) {
            int first = firstIndex(nums, target);
            int n = nums.length;
            if (first == -1 || first == n || nums[first] != target) {
                return -1;
            }
            return (lastIndex(nums,target) - first + 1);
        }
}
