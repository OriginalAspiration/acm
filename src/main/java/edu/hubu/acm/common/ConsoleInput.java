package edu.hubu.acm.common;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class ConsoleInput {
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

    /**
     * @Description:当我们使用nextInt()从控制台输入一行数据时，无法用Enter回车符结束输入，解决办法如下
     * @Param: []
     * @return: void
     * @Author: zhoulei
     * @Date: 2019/9/29
     */
    public static void inputIntegerWithoutLength() {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        Scanner numLine = new Scanner(line);
        List<Integer> list = new ArrayList<>();
        while (numLine.hasNextInt()) {
            list.add(numLine.nextInt());
        }
        Iterator<Integer> iterator = list.listIterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        scanner.close();
        numLine.close();
    }

}
