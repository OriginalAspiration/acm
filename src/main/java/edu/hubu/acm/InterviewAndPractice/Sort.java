package edu.hubu.acm.InterviewAndPractice;

/**
 * @author zhoulei
 * @version 1.0.0
 * @ClassName Sort.java
 * @Description TODO
 * @createTime 2019年08月09日 22:09:00
 */
public class Sort {
    public void quickSort(int[] array,int left,int end) {
        int i =left;
        int j = end;
        int temp=array[i];
        while(i<j){
            while(i<j&&temp<array[j]){
                --j;
            }
            if(i<j){
                array[i]=array[j];
                ++i;
            }
            while(i<j&&temp>array[i]){
                ++i;
            }
            if(i<j){
                array[j]=array[i];
                --j;
            }
        }
        array[i]=temp;
        quickSort(array,left,i-1);
        quickSort(array,i+1,end);
    }

}

class HeapSort {
    //调整某棵子树使其满足堆的定义
    public int[] adjustHeap(int[] heap, int begin, int end) {
        int temp = heap[begin];
        int j = 2 * begin + 1;
        while (j <= end) {
            if (j < end && heap[j] < heap[j + 1]) {
                ++j;
            }
            if (temp < heap[j]) {
                heap[begin] = heap[j];
                begin = j;
                j = 2 * begin + 1;
            } else {
                break;
            }
        }
        heap[begin] = temp;
        return heap;
    }

    //从下标最大的非叶节点开始，从下至上调整各棵子树使其满足堆的定义，构造初始堆
    public int[] initializeHeap(int[] initArray) {
        for (int i = (initArray.length - 2) / 2; i >= 0; --i) {
            adjustHeap(initArray, i, initArray.length - 1);
        }
        return initArray;
    }

    //第一步让堆顶与未排空间的最后一个元素交换，使得未排空间的长度减1，第二步调用调整函数使未排空间满足堆；重复上述操作直至未排空间减少到1
    public int[] heapSort(int[] array) {
        initializeHeap(array);
        for (int end = array.length - 1; end > 0; --end) {
            int temp = array[0];
            array[0] = array[end];
            array[end] = temp;
            adjustHeap(array, 0, end - 1);

        }
        return array;
    }
}
