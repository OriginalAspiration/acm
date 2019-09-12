package edu.hubu.acm.swordToOffer.common;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author zhoulei
 * @version 1.0.0
 * @ClassName SystemInput
 * @Description 当我们使用nextInt()从控制台输入时，无法用Enter回车符结束输入，解决办法如下
 * @createTime 2019年09月09日 21:52:00
 */
public class SystemInput {
    public void inputFromConsole() {
        ArrayList<Integer> arr = new ArrayList() ;
        System.out.println("Enter a space separated list of numbers:");
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        Scanner in2 = new Scanner(line);
        while(in2.hasNextInt()){
            arr.add(in2.nextInt());
        }
        System.out.println("The numbers were:"+arr.toString());
    }

//    public static int SumContinuousSequence(int target) {
//        int n = target;
//        if (n<3) {
//            return 0;
//        }
//        int count = 1;
//        for (int i = 2; (2 * i - 1) * (2 * i - 1) - 1 < 8 * n; i++) {//将求根转化为平方。例如 i<sqrt(x)-->i*i<n
//            if ((n - i * (i - 1) / 2) % i == 0) {
//                int x = (n - i * (i - 1) / 2) / i;
//                int j = 0;
//                while (j < i) {
//                    x++;
//                    j++;
//                }
//                ++count;
//            }
//        }
//        return count;
//    }

}
