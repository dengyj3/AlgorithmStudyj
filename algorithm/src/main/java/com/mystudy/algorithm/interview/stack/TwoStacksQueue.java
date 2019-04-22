package com.mystudy.algorithm.interview.stack;

import java.util.Stack;

/**
 *  编写一个类，用两个栈实现队列，支持队列的基本操作(add、poll、peek)
 */
public class TwoStacksQueue {
    private Stack<Integer> stackPush;
    private Stack<Integer> stackPop;

    public TwoStacksQueue() {
        this.stackPush = new Stack<>();
        this.stackPop = new Stack<>();
    }

    public void add(int pushInt) {
        stackPush.push(pushInt);
    }

    public int poll() {
        if (stackPop.empty() && stackPush.empty()) {
            throw new RuntimeException("Queue is empty!");
        } else if (stackPop.empty()) {
            while (!stackPush.empty()) {
                stackPop.push(stackPush.pop());
            }
        }
        return stackPop.pop();
    }

    public int peek() {
        if (stackPop.empty() && stackPush.empty()) {
            throw new RuntimeException("Queue is empty!");
        } else if (stackPop.empty()) {
            while (!stackPush.empty()) {
                stackPop.push(stackPush.pop());
            }
        }
        return stackPop.peek();
    }

    public static void main(String[] args) {
        int a[] = {1, 2, 3, 4, 5};
        TwoStacksQueue twoStacksQueue = new TwoStacksQueue();
        for (int i = 0; i < a.length; i++) {
            twoStacksQueue.add(a[i]);
        }
        System.out.println(twoStacksQueue.stackPush);
        System.out.println(twoStacksQueue.poll());
        System.out.println(twoStacksQueue.poll());
        System.out.println(twoStacksQueue.poll());
        System.out.println(twoStacksQueue.poll());
        System.out.println(twoStacksQueue.poll());
        System.out.println(twoStacksQueue.poll());
    }
}
