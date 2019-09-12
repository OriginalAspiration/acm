package edu.hubu.acm.swordToOffer.part1;

import java.util.PriorityQueue;

/**
 * @author zhoulei
 * @version 1.0.0
 * @ClassName 旋转数组的最小数字
 * @Description TODO
 * @createTime 2019年09月10日 16:50:00
 */
public class 旋转数组的最小数字 {
    public int minNumberInRotateArray(int [] array) {
        int length = array.length;
        if (length==0) {
            return 0;
        }
        else {
            PriorityQueue<Integer> queue = new PriorityQueue<>();
            for (int i=0;i<length;++i) {
                queue.add(array[i]);
            }
            return queue.poll();
        }
    }
}
