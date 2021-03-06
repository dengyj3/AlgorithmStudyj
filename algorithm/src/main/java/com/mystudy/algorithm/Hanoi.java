package com.mystudy.algorithm;

import java.util.Stack;

/**
 * 汉诺塔
 */
public class Hanoi {

    /**
     * 表示的是把n个圆盘成功的从A移动到C
     *
     * @param n
     * @param A
     * @param B
     * @param C
     */
    public static void hanoi(int n, char A, char B, char C) {
        if (n == 1) {
            //如果只有一个，直接从A移动到C即可
            System.out.println("从" + A + "移动到" + C);
        } else {
            //表示先把n-1个圆盘成功从A经过C移动到B
            hanoi(n - 1, A, C, B);
            //把第n个圆盘从A移动到C
            System.out.println("从" + A + "移动到" + C);
            //表示把n-1个圆盘再成功从B经过A移动到C
            hanoi(n - 1, B, A, C);
        }
    }

    // stackA 源柱  stackB 借助柱  stackC目的柱
    public static void move(Stack<Integer> stackA, Stack<Integer> stackB, Stack<Integer> stackC, int n) {
        if (n == 1) {
            System.out.println("从" + stackA + "移动到" + stackC);
            stackC.push(stackA.pop());
        } else {
            move(stackA, stackC, stackB, n - 1);
            stackC.push(stackA.pop());
            move(stackB, stackA, stackC, n - 1);
        }
    }

    public static long hanoiCount(int n) {
        return (1L << n) - 1;
    }

    public static void main(String[] args) {
        hanoi(2, 'A', 'B', 'C');
        System.out.println(hanoiCount(2));
        hanoi(3, 'A', 'B', 'C');
        System.out.println(hanoiCount(3));
        hanoi(4, 'A', 'B', 'C');
        System.out.println(hanoiCount(4));
        Stack<Integer> stackA = new Stack<>();
        stackA.push(5);
        stackA.push(4);
        stackA.push(3);
        stackA.push(2);
        stackA.push(1);
        move(stackA,new Stack<Integer>(),new Stack<Integer>(),5);
    }
}
