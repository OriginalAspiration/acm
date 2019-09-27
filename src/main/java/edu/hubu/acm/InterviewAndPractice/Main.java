package edu.hubu.acm.InterviewAndPractice;

public class Main {
    public static void main(String[] args) {
        int[] array = {-1, 2, 38, 9, 3,-2};
//        Sort.QuickSort.quick(array);
        Sort.HeapSort heapSort = new Sort.HeapSort();
        heapSort.heapSort(array);
        for (int tmp : array) {
            System.out.print(tmp + " ");
        }

    }
}


class Solution {
}










