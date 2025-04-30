/*
    Given a sorted array nums and an integer x. Find the floor and ceil of x in nums. The floor of x is the largest element in the array which is smaller than or equal to x. The ceiling of x is the smallest element in the array greater than or equal to x. If no floor or ceil exists, output -1.


    Examples:
    Input : nums =[3, 4, 4, 7, 8, 10], x= 5

    Output: 4 7

    Explanation: The floor of 5 in the array is 4, and the ceiling of 5 in the array is 7.
    
    Input : nums =[3, 4, 4, 7, 8, 10], x= 8

    Output: 8 8

    Explanation: The floor of 8 in the array is 8, and the ceiling of 8 in the array is also 8.
*/
package binarySearch.arrays_1D;

public class FloorAndCeil {

    public int ceil(int[] nums, int x) {
        // It is the lower bound algo
        int n = nums.length;
        int low = 0, high = n-1,ans = -1;
        while(low <= high){
            int mid = (low + high)/2;
            if(nums[mid] >= x){
                ans = nums[mid];
                high = mid - 1;
            }else{
                low  = mid + 1;
            }
        }
        return ans;
    }

    public int floor(int[] nums, int x) {
        // It is kind of reverse of lower bound algo
        int n = nums.length;
        int low = 0, high = n-1, ans = -1;
        while(low <= high){
            int mid = (low + high)/2;
            if(nums[mid] <= x){
                ans = nums[mid];
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        return ans;
    }
    public int[] getFloorAndCeil(int[] nums, int x) {
        int[] ans = new int[2];
        ans[0] = floor(nums,x);
        ans[1] = ceil(nums,x);
        return ans;
    }
}
