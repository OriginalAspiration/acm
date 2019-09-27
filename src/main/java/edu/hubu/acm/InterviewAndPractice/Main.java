package edu.hubu.acm.InterviewAndPractice;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        List list = Algorithm.primes(num);
        System.out.println(list.size());
        int size = list.size();
        for (int i = 0; i < size; ++i) {
            if (i %4== 0&&i!=0) {
                System.out.print(list.get(i));
                System.out.println();
            } else {
                System.out.print(list.get(i) + " ");
            }

        }

    }
}


class Solution {
}










