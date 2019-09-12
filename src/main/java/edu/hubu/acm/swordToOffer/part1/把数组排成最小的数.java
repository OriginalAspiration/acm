package edu.hubu.acm.swordToOffer.part1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @author zhoulei
 * @version 1.0.0
 * @ClassName 把数组排成最小的数
 * @Description TODO
 * @createTime 2019年09月08日 16:01:00
 */
public class 把数组排成最小的数 {
    public static String PrintMinNumber(int [] numbers) {
        int size = 0;
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < numbers.length; i++) {
            list.add(numbers[i]);
        }
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                String a = String.valueOf(o1);
                String b = String.valueOf(o2);
                return (a + b).compareTo(b + a);
            }
        });
        StringBuffer sb = new StringBuffer();
        for (int i : list) {
            sb.append(i);
        }
        return sb.toString();
    }
    public static void test() {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        String[] stringValues = line.split(" ");
        int length = stringValues.length;
        int[] numbers = new int[length];
        for (int i=0;i<length;++i) {
            numbers[i] = Integer.valueOf(stringValues[i]);
        }
        System.out.println(PrintMinNumber(numbers));
    }
}
