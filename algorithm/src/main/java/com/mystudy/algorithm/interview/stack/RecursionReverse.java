package com.mystudy.algorithm.interview.stack;

import java.util.Stack;

/**
 * 如何仅用递归函数和栈操作逆序一个栈
 * 题目：
 *  一个栈依次压入1、2、3、4、5，那么从栈顶到栈底分别 为5、4、3、2、1.将这个栈转置后，
 *  从栈顶到栈底为1、2、3、4、5，也就是实现栈中元素的逆序，但是只能用递归函数来实现，
 *  不能用其他数据结构
 */
public class RecursionReverse {
    /**
     * 将栈底元素返回并移除
     * @param stack
     * @return
     */
    public static int getAndRemoveLastElement(Stack<Integer> stack){
        int result = stack.pop();
        if (stack.isEmpty()){
            return result;
        }else {
            int last = getAndRemoveLastElement(stack);
            stack.push(result);
            return last;
        }
    }

    /**
     * 逆序一个栈
     * @param stack
     */
    public static void reverse(Stack<Integer> stack){
        if (stack.isEmpty()){
            return;
        }
        int i = getAndRemoveLastElement(stack);
        reverse(stack);
        stack.push(i);
    }

    public static void main(String[] args) {
        int a[] = {1,2,3,4,5};
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i<a.length; i++){
            stack.push(a[i]);
        }

        System.out.println(getAndRemoveLastElement(stack));

    }

}
