package edu.hubu.acm.swordToOffer.part1;

/**
 * @author zhoulei
 * @version 1.0.0
 * @ClassName 斐波那契数列
 * @Description TODO
 * @createTime 2019年09月11日 17:34:00
 */
public class 斐波那契数列 {
    public  int Fibonacci(int n) {
        if (n<2){
            return n;
        }
        return Fibonacci(n - 1) + Fibonacci(n - 2);
    }
}
