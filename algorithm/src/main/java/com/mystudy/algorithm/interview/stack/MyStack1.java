package com.mystudy.algorithm.interview.stack;

import java.util.Stack;

/**
 * 设计一个有getMin功能的栈
 * 题目：实现一个特殊的栈，在实现栈的基本功能的基础上，再实现返回栈中最小元素的操作
 * 要求：
 * 1.pop、push、getMin操作的时间复杂度都是O(1)
 * 2.设计的栈类型可以使用现成的栈结构
 */
public class MyStack1 {
    private Stack<Integer> stackData;
    private Stack<Integer> stackMin;

    public MyStack1(){
        this.stackData = new Stack<Integer>();
        this.stackMin = new Stack<Integer>();
    }

    public void push(int newNum){
        if (this.stackMin.isEmpty()){
            this.stackMin.push(newNum);
        }else if (newNum <= this.getMin()){
            this.stackMin.push(newNum);
        }
        this.stackData.push(newNum);
    }

    public int pop(){
        if (this.stackData.isEmpty()){
            throw new RuntimeException("Your stack is empty.");
        }
        int value = this.stackData.pop();
        if (value == this.getMin()){
            this.stackMin.pop();
        }
        return value;
    }
    private int getMin() {
        if (this.stackMin.isEmpty()){
            throw new RuntimeException("Your stack is empty.");
        }
        return this.stackMin.peek();
    }

    public static void main(String[] args) {
        MyStack1 myStack1 = new MyStack1();
        int [] a = {3,4,5,1,2,1};
        for (int i=0;i<a.length;i++){
            myStack1.push(a[i]);
        }
        System.out.println(myStack1.stackData);
        System.out.println(myStack1.stackMin);
        System.out.println(myStack1.getMin());
        System.out.println(myStack1.pop());
    }
}
