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

}
