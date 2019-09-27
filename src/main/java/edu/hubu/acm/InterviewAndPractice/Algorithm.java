package edu.hubu.acm.InterviewAndPractice;

import java.util.ArrayList;
import java.util.List;

public class Algorithm {
    public boolean matrixFind_01(int target, int[][] array) {
        boolean exist = false;
        if (array == null) {
            return exist;
        } else {
            int rows = array.length, cols = array[0].length;
            for (int row = rows - 1, col = 0; row >= 0 && col < cols; ) {
                if (target == array[row][col]) {
                    return exist = true;
                } else {
                    if (target > array[row][col]) {
                        ++col;
                    } else {
                        --row;
                    }
                }
            }
            return exist;
        }
    }

    public String replaceBlankSpace_02(StringBuffer str) {
        StringBuffer result = new StringBuffer();
        int lastBlankIndex = -1, nextBlankIndex;
        while ((nextBlankIndex = str.indexOf(" ", lastBlankIndex + 1)) != -1) {
            result.append(str.substring(lastBlankIndex + 1, nextBlankIndex));
            result.append("%20");
            lastBlankIndex = nextBlankIndex;
        }
        if (lastBlankIndex < str.length() - 1) {
            result.append(str.substring(lastBlankIndex + 1));
        }
        return result.toString();
    }

    public ArrayList<Integer> reverseLinkedList_03(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList();
        ListNode tmpNode = listNode;
        while (tmpNode != null) {
            list.add(tmpNode.val);
            tmpNode = tmpNode.next;
        }
        for (int i = 0, length = list.size(), j = length - 1; i < j; ++i, --j) {
            int temp = list.get(i);
            list.set(i, list.get(j));
            list.set(j, temp);
        }
        return list;
    }

    /**
     * @Description:求给定整数范围内的所有素数
     * @Param: [num]
     * @return: java.util.List
     * @Author: zhoulei
     * @Date: 2019/9/27
     */
    public static List primes(int num) {
        List<Integer> list = new ArrayList<>();
        if (num < 0) {
            throw new IllegalArgumentException("num must be a non negative integer");
        }
        if (num == 1) {
            return list;
        }
        for (int i = 2; i <= num; ++i) {
            int j = 2;
            for (; j <= Math.sqrt(i); ++j) {
                if (i % j == 0) {
                    break;
                }
            }
            if (j > Math.sqrt(i)) {
                list.add(i);
            }
        }
        return list;

    }

}

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }

    public int getVal() {
        return val;
    }

    public ListNode getNext() {
        return next;
    }
}

