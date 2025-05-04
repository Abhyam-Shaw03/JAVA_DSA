package binarySearch;

import binarySearch.arrays_1D.CountOccurances;
import binarySearch.arrays_1D.FirstAndLastOccurance;
import binarySearch.arrays_1D.FloorAndCeil;
import binarySearch.arrays_1D.Times_ArrayRotated;

public class BinarySearchMain {
    public static void main(String[] args) {
//        FloorAndCeil floorAndCeil = new FloorAndCeil();
//        FirstAndLastOccurance firstAndLastOccurance = new FirstAndLastOccurance();
//        CountOccurances countOccurances = new CountOccurances();
        Times_ArrayRotated timesArrayRotated = new Times_ArrayRotated();

        int[] arr = {3,4,5,6,7,1,2};

        System.out.println(timesArrayRotated.findKRotation(arr));
//        int[] arr = {1,3,4,5,8,8,8,11,13};
//        System.out.println(countOccurances.countOccurances(arr,8));
//        int[] ans = new int[2];
//        ans = firstAndLastOccurance.searchRange(arr, 8);
//        for(int i : ans){
//            System.out.print(i + " ");
//        }
    }
}
