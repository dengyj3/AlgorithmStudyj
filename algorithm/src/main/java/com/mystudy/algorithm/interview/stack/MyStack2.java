package com.mystudy.algorithm.interview.stack;

import java.util.Stack;

public class MyStack2 {
    private Stack<Integer> stackData;
    private Stack<Integer> stackMin;
    public MyStack2(){
        this.stackData = new Stack<>();
        this.stackMin = new Stack<>();
    }

    public void push(int newNum){
        if (this.stackMin.isEmpty()){
            this.stackMin.push(newNum);
        }else if (newNum <= this.getMin()){
            this.stackMin.push(newNum);
        }else {
            int newMin = this.stackMin.peek();
            this.stackMin.push(newMin);
        }
        this.stackData.push(newNum);
    }

    public int pop(){
        if (this.stackData.isEmpty()){
            throw new RuntimeException("Your stack is empty.");
        }
        this.stackMin.pop();
        return this.stackData.pop();
    }

    public int getMin(){
        if (this.stackMin.isEmpty()){
            throw new RuntimeException("Your stack is empty.");
        }
        return this.stackMin.peek();
    }

    public static void main(String[] args) {
        int [] a = {3,4,5,1,2,1};
        MyStack2 myStack2 = new MyStack2();
        for (int i=0;i<a.length;i++){
            myStack2.push(a[i]);
        }
        System.out.println(myStack2.stackData);
        System.out.println(myStack2.stackMin);
        System.out.println(myStack2.getMin());
    }
}

