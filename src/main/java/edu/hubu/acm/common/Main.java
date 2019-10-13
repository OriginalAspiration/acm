package edu.hubu.acm.common;

/**
 * @author zhoulei
 * @version 1.0.0
 * @ClassName Main
 * @Description TODO
 */
public class Main {
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
        BTree.test();
    }
}

class Solution {
    public static void switchTest(String switchFlag) {
        switch (switchFlag) {
            case "zhoulei":
                System.out.println("I am zhoulei");
                break;
            default:
                System.out.println("I am not zhoulei");
        }

    }
}
