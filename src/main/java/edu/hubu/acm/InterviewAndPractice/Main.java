package edu.hubu.acm.InterviewAndPractice;

import java.util.Scanner;

/**
 * @author zhoulei
 * @version 1.0.0
 * @ClassName Main
 * @Description TODO
 */

public class Main {
    public static void main(String [] args) {
      Solution.solution();
    }
}


class Solution {
    public static void solution() {
        Scanner in = new Scanner(System.in);
        Integer t = in.nextInt(), nums = 0;
        int[] result = new int[t];
        for (int i = 0; i < t; ++i) {
            nums = 0;
            Integer a = in.nextInt(), b = in.nextInt(), p = in.nextInt(), q = in.nextInt();
            while (a + p < b) {
                p *= q;
                nums++;
            }
            if (a < b) {
                result[i] = nums + 1;
            } else {
                result[i] = nums;
            }
        }
        for (int j = 0; j < t; ++j) {
            System.out.println(result[j]);
        }
    }
}










