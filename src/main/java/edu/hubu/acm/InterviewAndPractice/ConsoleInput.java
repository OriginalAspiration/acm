package edu.hubu.acm.InterviewAndPractice;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class ConsoleInput {
    public static int[][] inputTwoDimensionalArray() {
        int m, n;
        Scanner reader = new Scanner(System.in);
        System.out.print("请以空格分隔输入二维数组的行列数：");
        m = reader.nextInt();
        n = reader.nextInt();
        if (m <= 0 || n < 0) {
            System.out.println("输入数据不合法");
            reader.close();
            return null;
        }
        int[][] array = new int[m][n];
        System.out.println("请按行输入该二维数组，各元素以空格分隔：");
        reader.nextLine();
        for (int i = 0; i < m; ++i) {
            String line = reader.nextLine().trim();
            if (reader.hasNextLine()) {
                String[] decimalArray = line.split(" ");
                for (int j = 0, length = decimalArray.length; j < length && j < n; ++j) {
                    array[i][j] = Integer.valueOf(decimalArray[j]);
                }
            } else {
                reader.close();
                return array;
            }
        }
        reader.close();
        return array;
    }

    public static void calculateGradePercentage() {
        int n, q;
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入班级人数：");
        n = scanner.nextInt();
        while (n < 1) {
            System.out.print("人数输入不合法请重新输入：");
            n = scanner.nextInt();
        }
        int[] scoreArray = new int[n];
        System.out.println("请输入各位同学的成绩并以空格分隔：");
        for (int i = 0; i < n; ++i) {
            scoreArray[i] = scanner.nextInt();
        }
        System.out.print("请输要询问的次数：");
        q = scanner.nextInt();
        while (q > 10000) {
            System.out.print("请输入10000以内的数字：");
            q = scanner.nextInt();
        }
        double[] scorePercentageArray = new double[q];
        System.out.println("请输入要询问成绩同学的序号，每行代表一个序号：");
        for (int j = 0; j < q; ++j) {
            int indexScore = scoreArray[scanner.nextInt() - 1];
            double count = 0;
            for (int k = 0; k < n; ++k) {
                if (indexScore >= scoreArray[k]) {
                    ++count;
                }
            }
            double p = (count - 1) / n * 100;
            BigDecimal bg = new BigDecimal(p).setScale(6, RoundingMode.UP);
            scorePercentageArray[j] = bg.doubleValue();
        }
        System.out.println("计算结果为：");
        for (double p : scorePercentageArray) {
            System.out.println(p);
        }

    }

    public static void scannerTest() {
        Scanner scan = new Scanner(System.in);
        // 从键盘接收数据

        // nextLine方式接收字符串
        System.out.println("nextLine方式接收：");
        // 判断是否还有输入
        String str2;
        while ((str2 = scan.nextLine()) != "") {
            System.out.println("输入的数据为：" + str2);
        }
        scan.close();
    }

}
