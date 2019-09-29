package edu.hubu.acm.swordToOffer.part1;

import edu.hubu.acm.common.LinkNode;

import java.util.Scanner;

/**
 * @author zhoulei
 * @version 1.0.0
 * @ClassName 从尾到头打印链表
 * @Description TODO
 * @createTime 2019年09月09日 21:15:00
 */
public class 从尾到头打印链表 {
    public static void printReverse(LinkNode node) {
        if (node.getNext() != null) {
            printReverse(node.getNext());
        }
        System.out.print(node.getVal() + " ");
    }

    public static void test() {
        Scanner scanner1 = new Scanner(System.in);
        String line = scanner1.nextLine();
        Scanner scanner2 = new Scanner(line);
        int i = 0;
        LinkNode head, tail;
        head = tail = null;
        while (scanner2.hasNextInt()) {
            LinkNode tempNode = new LinkNode();
            tempNode.setVal(scanner2.nextInt());
            if (i == 0) {
                head = tail = tempNode;
            } else {
                tail.setNext(tempNode);
                tail = tail.getNext();
            }
            ++i;
        }
        printReverse(head);
    }
}
