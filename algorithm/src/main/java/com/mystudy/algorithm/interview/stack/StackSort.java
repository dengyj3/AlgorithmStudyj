package com.mystudy.algorithm.interview.stack;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.Stack;

/**
 *  用一个栈实现另一个栈的排序
 *  题目：一个栈中元素的类型为整形，现在想将该栈从顶到底按从大到小的顺序排序，只许申请一个栈。除此之外，可以申请新的变量，但不能申请额外的数据结构。如何完成排序？
 */
public class StackSort {
    public static void sortStackByStack(Stack<Integer> stack){
        Stack<Integer> help = new Stack<>();
        while (!stack.isEmpty()){
            int cur = stack.pop();
            while (!help.isEmpty() && help.peek() < cur){
                stack.push(help.pop());
            }
            help.push(cur);
        }
        while (!help.isEmpty()){
            stack.push(help.pop());
        }
        System.out.println(stack);
    }

    public static void main(String[] args) {
        int a[] = {3,5,2,6,9,8};
        Stack<Integer> stack = new Stack<>();
        for (int i=0; i<a.length; i++){
            stack.push(a[i]);
        }
        sortStackByStack(stack);
    }
}
