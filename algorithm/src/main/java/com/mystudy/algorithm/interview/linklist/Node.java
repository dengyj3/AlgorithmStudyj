package com.mystudy.algorithm.interview.linklist;

import java.util.Stack;

public class Node {
    private int value;
    private Node next;

    Node(int data) {
        this.value = data;
    }

    public void printCommonPart(Node head1, Node head2) {
        System.out.println("Common Part : ");
        while (head1 != null && head2 != null) {
            if (head1.value != head2.value) {
                head1 = head1.next;
            } else if (head1.value > head2.value) {
                head2 = head2.next;
            } else {
                System.out.print(head1.value + " ");
                head1 = head1.next;
                head2 = head2.next;
            }
        }
    }

    public Node removeLastKthNode(Node head, int lastKth) {
        if (head == null || lastKth < 1) {
            return head;
        }
        Node cur = head;
        while (cur != null) {
            lastKth--;
            cur = cur.next;
        }
        if (lastKth == 0) {
            head = head.next;
        }
        if (lastKth < 0) {
            cur = head;
            while (++lastKth != 0) {
                cur = cur.next;
            }
            cur.next = cur.next.next;
        }
        return head;
    }

    /**
     * 判断一个链表是否为回文结构
     * 1. 时间复杂度O(N),  空间复杂度O(N)
     * 从左到右遍历链表，遍历的过程中把每个节点依次压入栈中。因为栈是先进后出的，所以在遍历完成后
     * 从栈顶到栈底的节点值出现顺序会与原链表中从左到右的值出现顺序反过来。那么，如果一个请了个假回文逆序之后，
     * 值出现的次序还是一样的，如果不是回文结构，顺序就肯定对不上
     *
     * @param head
     * @return
     */
    public static boolean isPalindrome1(Node head) {
        Stack<Node> stack = new Stack<>();
        Node cur = head;
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }
        while (head != null) {
            if (head.value != stack.pop().value) {
                return false;
            }
            head = head.next;
        }
        return true;
    }

    /**
     * 折半，首先假设链表长度N,如果N是偶数，前N/2作为左半区，后N/2作为右半区；
     * 如果N是奇数，忽略中间节点,前N/2作为左半区，后N/2作为右半区；
     *
     * @param head
     * @return
     */
    public static boolean isPalindrome2(Node head) {
        if (head == null || head.next == null) {
            return true;
        }
        Node right = head.next;
        Node cur = head;
        while (cur.next != null && cur.next.next != null) {
            right = right.next;
            cur = cur.next.next;
        }
        Stack<Node> stack = new Stack<>();
        while (right != null) {
            stack.push(right);
            right = right.next;
        }
        while (!stack.isEmpty()) {
            if (head.value != stack.pop().value) {
                return false;
            }
            head = head.next;
        }
        return true;
    }

    public static boolean isPalindrome3(Node head) {
        if (head == null || head.next == null) {
            return true;
        }
        Node node1 = head;
        Node node2 = head;
        while (node2.next != null && node2.next.next != null) {//查找中间节点
            node1 = node1.next;//n1->中部
            node2 = node2.next.next;//n2->结尾
        }
        node2 = node1.next;//n2->右部分第一个节点
        node1.next = null;//mid.next->null
        Node node3 = null;
        while (node2 != null) {//右半区反转
            node3 = node2.next;//n3->保存下一个节点
            node2.next = node1;//下一个反转节点
            node1 = node2;//n1移动
            node2 = node3;//n2移动
        }
        node3 = node1;//n3->保存最后一个节点
        node2 = head;//n2->左边第一个节点
        boolean res = true;
        while (node1 != null && node2 != null) {//检查回文
            if (node1.value != node2.value) {
                res = false;
                break;
            }
            node1 = node1.next;//从左到中部
            node2 = node2.next;//从右到中部
        }
        node1 = node3.next;
        node3.next = null;
        while (node1 != null) {//恢复链表
            node2 = node1.next;
            node1.next = node3;
            node3 = node1;
            node1 = node2;
        }
        return res;
    }

    /**
     * 判断一个单链表是否有环
     * @param L
     * @return
     */
    public static boolean hasCircle(Node L)
    {
        Node slow=L;//slow表示从头结点开始每次往后走一步的指针
        Node fast=L;//fast表示从头结点开始每次往后走两步的指针
        while(fast!=null && fast.next!=null)
        {
            if(slow==fast) return true;//p与q相等，单链表有环
            slow=slow.next;
            fast=fast.next.next;
        }
        return false;
    }
    public static void main(String[] args) {
//        Node head1 = new Node(4);
//        head1.next = new Node(5);
//        head1.next.next = new Node(6);
//        head1.next.next.next = new Node(7);
//
//        Node head2 = new Node(5);
//        head2.next = new Node(6);
//
////        head1.printCommonPart(head1, head2);
//
//        head1.removeLastKthNode(head1,5);
//        head1.removeLastKthNode(head1,4);
//        head1.removeLastKthNode(head1,3);
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(1);
//        System.out.println(""+isPalindrome1(head));
//        System.out.println("" + isPalindrome2(head));
        System.out.println("" + isPalindrome3(head));
        System.out.println(hasCircle(head));
    }
}
