package binarySearch.on_Answers.maxOfmin_or_minOfmax;

/*
    Given an array nums of n integers, where nums[i] represents the number of pages in the i-th book, and an integer m representing the number of students, allocate all the books to the students so that each student gets at least one book, each book is allocated to only one student, and the allocation is contiguous.



    Allocate the books to m students in such a way that the maximum number of pages assigned to a student is minimized. If the allocation of books is not possible, return -1.


    Examples:
    Input: nums = [12, 34, 67, 90], m=2

    Output: 113

    Explanation: The allocation of books will be 12, 34, 67 | 90. One student will get the first 3 books and the other will get the last one.

    Input: nums = [25, 46, 28, 49, 24], m=4

    Output: 71

    Explanation: The allocation of books will be 25, 46 | 28 | 49 | 24.
*/

public class BookAllocation {

    // minOfMax will always have range from maxElement->sumOfAllElements
    public int[] range(int[] nums){
        int maxi = Integer.MIN_VALUE, sum = 0;
        for(int i : nums){
            maxi = Math.max(maxi, i);
            sum += i;
        }
        return new int[]{maxi, sum};
    }

    public boolean booksGiven(int[] nums, int m, int pagesAlloted, int n){
        int pageCount = nums[0], studentCount = 1;
        for(int i = 1; i < n; i++){
            if(pageCount + nums[i] <= pagesAlloted){
                pageCount += nums[i];
            }else{
                studentCount++;
                pageCount = nums[i];
            }
        }
        return (studentCount <= m);
    }

    public int findPages(int[] nums, int m) {
        int n = nums.length;
        if(n < m) return -1;
        int[] arr = new int[2];
        arr = range(nums);
        int low = arr[0], high = arr[1];
        while(low <= high){
            int mid = (low + high) / 2;
            if(booksGiven(nums, m, mid,n))
                high = mid - 1;
            else low = mid + 1;
        }
        return low;
    }
}
