package sorting;

import sorting.normal.BubbleSort;
import sorting.normal.InsertionSort;
import sorting.normal.MergeSort;
import sorting.normal.SelectionSort;

public class SortingMain {
    public static void main(String[] args) {
        SelectionSort selSort = new SelectionSort();
        BubbleSort bubSort = new BubbleSort();
        InsertionSort insSort = new InsertionSort();
        MergeSort merSort = new MergeSort();

        int[] arr = {6,4,1,5,2,3};

        System.out.print("Array before sorting: ");
        for(int i : arr)
            System.out.print(i + " ");
        System.out.println();

//        arr = selSort.selectionSort(arr);
//        arr = bubSort.bubbleSort(arr);
//        arr = insSort.insertionSort(arr);
        arr = merSort.mergeSort(arr);

        System.out.print("Array after sorting: ");
        for(int i : arr)
            System.out.print(i + " ");
    }
}
