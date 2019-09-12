package edu.hubu.acm.swordToOffer.part1;

import java.util.Stack;

/**
 * @author zhoulei
 * @version 1.0.0
 * @ClassName 用两个栈实现队列
 * @Description TODO
 * @createTime 2019年09月10日 11:54:00
 */
public class 用两个栈实现队列 {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();
    public void push(int node) {
        stack1.push(node);
    }
    public int pop() {
        if (stack2.size() > 0) {
        return stack2.pop();
    } else {
        while (stack1.size() > 0) {
            stack2.push(stack1.pop());
        }
        return stack2.pop();
    }
}
}
