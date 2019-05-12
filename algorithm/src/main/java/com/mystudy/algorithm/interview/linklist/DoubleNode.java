package com.mystudy.algorithm.interview.linklist;

public class DoubleNode {
    private int value;
    private DoubleNode last;
    private DoubleNode next;
    DoubleNode(int data){
        this.value = data;
    }

    public DoubleNode removeLastKthNode(DoubleNode head, int lastKth){
        if (head == null || lastKth < 1){
            return head;
        }
        DoubleNode cur = head;
        while (cur != null){
            lastKth--;
            cur = cur.next;
        }
        if (lastKth == 0){
            head = head.next;
            head.last = null;
        }
        if (lastKth < 0){
            cur = head;
            while (++lastKth != 0){
                cur = cur.next;
            }
            DoubleNode newNext = cur.next.next;
            cur.next = newNext;
            if (newNext != null){
                newNext.last = cur;
            }
        }
        return head;
    }
}
