package edu.hubu.acm.InterviewAndPractice;

/**
 * @author zhoulei
 * @version 1.0.0
 * @ClassName Demo03.java
 * @Description TODO
 * @createTime 2019年08月11日 20:38:00
 */

import java.util.Scanner;

public class Demo03 {
    public static void bonusDistribution() {
        Scanner scanner = new Scanner(System.in);
//		样例个数
        int exam_num = 1;
//        if (scanner.hasNext()) {
//            exam_num = scanner.nextInt();
//        }
//		样例数组
        int[] exams = new int[exam_num];

        for (int i = 0; i < exam_num; i++) {
            int num = 0;
            if (scanner.hasNext()) {
                num = scanner.nextInt();
            }
//			分数数组
            int[] grade_num = new int[num];
//			奖品数量数组
            int[] prize_num = new int[num];

            for (int j = 0; j < grade_num.length; j++) {
                grade_num[j] = scanner.nextInt();
            }

//			反推标记
            boolean reverse = false;

            for (int j = 0; j < grade_num.length; j++) {
                if (j == 0) {
                    if (grade_num[j] > grade_num[grade_num.length - 1]) {
                        prize_num[j] = prize_num[prize_num.length - 1] + 1;
                    } else if (grade_num[j] < grade_num[grade_num.length - 1]) {
                        prize_num[j] = prize_num[prize_num.length - 1] - 100;
                    }
                } else if (j == grade_num.length - 1) {
                    if (grade_num[j] > grade_num[j - 1]) {
                        prize_num[j] = prize_num[j - 1] + 1;
                    } else if (grade_num[j] < grade_num[j - 1]) {
                        prize_num[j] = prize_num[j - 1] - 100;
                    }
//					如果最后一个分数比第一个分数大但是奖品数量小于等于第一个，就开始反推
                    if (grade_num[j] > grade_num[0] && prize_num[j] <= prize_num[0]) {
                        prize_num[j] = prize_num[0] + 100;
                        reverse = false;
//						指针跳到前一个分数
                        j -= 2;
                    }
                } else {
                    if (grade_num[j] > grade_num[j - 1]) {
                        prize_num[j] = prize_num[j - 1] + 1;
                    } else if (grade_num[j] < grade_num[j - 1]) {
                        prize_num[j] = prize_num[j - 1] - 100;
                    }
//					判断反推，只有在最后冲突时才能进去
                    if (reverse) {
                        if (grade_num[j] > grade_num[j + 1] && prize_num[j] <= prize_num[j + 1]) {
                            prize_num[j] = prize_num[j + 1] + 100;
                            j -= 2;
                        } else {
//							不进if说明前面正常，跳出循环
                            break;
                        }
                    }
                }
            }
//			找出奖品数量最小值，计算最小值和1的增量，全体自增。
            int min = 0;
            for (int j : prize_num) {
                min = j < min ? j : min;
            }
            int count = 0;
            for (int j = 0; j < prize_num.length; j++) {
                prize_num[j] += (100- min);
                count += prize_num[j];
            }
            exams[i] = count;
        }
        for (int j : exams) {
            System.out.println(j);
        }
    }
}
