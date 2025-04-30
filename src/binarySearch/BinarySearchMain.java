package binarySearch;

import binarySearch.arrays_1D.FloorAndCeil;

public class BinarySearchMain {
    public static void main(String[] args) {
        FloorAndCeil floorAndCeil = new FloorAndCeil();

        int[] arr = {10,30,40,50};
        int[] ans = new int[2];
        ans = floorAndCeil.getFloorAndCeil(arr,25);
        for(int i : ans){
            System.out.print(i + " ");
        }
    }
}
