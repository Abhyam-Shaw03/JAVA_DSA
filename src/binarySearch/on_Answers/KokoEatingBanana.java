package binarySearch.on_Answers;

/*
    Koko loves to eat bananas. There are n piles of bananas, the ith pile has piles[i] bananas. The guards have gone and will come back in h hours.

    Koko can decide her bananas-per-hour eating speed of k. Each hour, she chooses some pile of bananas and eats k bananas from that pile. If the pile has less than k bananas, she eats all of them instead and will not eat any more bananas during this hour.

    Koko likes to eat slowly but still wants to finish eating all the bananas before the guards return.

    Return the minimum integer k such that she can eat all the bananas within h hours.



    Example 1:

    Input: piles = [3,6,7,11], h = 8
    Output: 4
    Example 2:

    Input: piles = [30,11,23,4,20], h = 5
    Output: 30
    Example 3:

    Input: piles = [30,11,23,4,20], h = 6
    Output: 23
*/

public class KokoEatingBanana {
    public int findMaximum(int[] piles){
        int maxi = Integer.MIN_VALUE;
        for(int i : piles){
            maxi = Math.max(maxi, i);
        }
        return maxi;
    }

    public int calculateTotalHours(int[] piles, int h, int mid){
        long totalHours = 0;
        for(int i : piles){
            totalHours += (long)Math.ceil((double)i/(double)mid);
        }
        if(totalHours <= h) return 1;
        return 0;
    }

    public int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;
        if(n == h) return findMaximum(piles);
        int low = 1, high = findMaximum(piles);
        while(low <= high){
            int mid = (low + high) / 2;
            if(calculateTotalHours(piles, h, mid) == 1)
                high = mid - 1;
            else
                low = mid + 1;
        }
        return low;
    }
}
