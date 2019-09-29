package edu.hubu.acm.InterviewAndPractice;

import java.util.ArrayList;
import java.util.List;

public class Algorithm {
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

    /**
     * @Description:判断一个整数是否为2的幂
     * @Param: [num]
     * @return: boolean
     * @Author: zhoulei
     * @Date: 2019/9/29
     */
    public static boolean isPowerOfTwo(int num) {
        if (num <= 0) {
            throw new IllegalArgumentException("num is Illegal");
        }
        return (num & (num - 1)) == 0;
    }

}
