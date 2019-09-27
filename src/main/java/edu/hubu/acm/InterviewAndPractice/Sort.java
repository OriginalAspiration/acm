package edu.hubu.acm.InterviewAndPractice;

/**
 * @author zhoulei
 * @version 1.0.0
 * @ClassName Sort.java
 * @Description TODO
 * @createTime 2019年08月09日 22:09:00
 */
public class Sort {
    //快排的算法时间复杂度为O(nlogn)，且为不稳定的排序算法
    public static class QuickSort {
        public static void quick(int[] a) {
            if (a.length > 0) {
                quickSort(a, 0, a.length - 1);
            }
        }

        public static void quickSort(int[] a, int low, int high) {
            if (low < high) { //如果不加这个判断递归会无法退出导致堆栈溢出异常
                int middle = getMiddle(a, low, high);
                quickSort(a, 0, middle - 1);
                quickSort(a, middle + 1, high);
            }
        }

        public static int getMiddle(int[] a, int low, int high) {
            int temp = a[low];//基准元素
            while (low < high) {
                //找到比基准元素小的元素位置
                while (low < high && a[high] >= temp) {
                    high--;
                }
                a[low] = a[high];
                while (low < high && a[low] <= temp) {
                    low++;
                }
                a[high] = a[low];
            }
            a[low] = temp;
            return low;
        }
    }
    //堆排的时间复杂度为O(nlogn)，且为不稳定的排序算法
    public static class HeapSort {
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
    //归并排序的时间复杂度为O(nlogn),且为稳定的排序算法
    public static class MergeSort {
        public static void mergeSort(int[] a, int left, int right) {
            if (left < right) {
                int middle = (left + right) / 2;
                //对左边进行递归
                mergeSort(a, left, middle);
                //对右边进行递归
                mergeSort(a, middle + 1, right);
                //合并
                merge(a, left, middle, right);
            }
        }

        public static void merge(int[] a, int left, int middle, int right) {
            int[] tmpArr = new int[a.length];
            int mid = middle + 1; //右边的起始位置
            int tmp = left;
            int third = left;
            while (left <= middle && mid <= right) {
                //从两个数组中选取较小的数放入中间数组
                if (a[left] <= a[mid]) {
                    tmpArr[third++] = a[left++];
                } else {
                    tmpArr[third++] = a[mid++];
                }
            }
            //将剩余的部分放入中间数组
            while (left <= middle) {
                tmpArr[third++] = a[left++];
            }
            while (mid <= right) {
                tmpArr[third++] = a[mid++];
            }
            //将中间数组复制回原数组
            while (tmp <= right) {
                a[tmp] = tmpArr[tmp++];
            }
        }
    }


}


