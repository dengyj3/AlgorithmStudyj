package com.mystudy.algorithm.linklist;

import java.util.Random;
/**
 * 链表的操作
 */
public class LinkedList {
	public static class Node {
		public int value;
		public Node next;
		public Node(int data) {
			this.value = data;
		}
	}
	
	
	public static void printLinkedList(Node node) {
		System.out.print("Linked List: ");
		while (node != null) {
			System.out.print(node.value + "->");
			node = node.next;
		}
		System.out.println();
	}
	
	/**
	 * 链表相加
	 * 给定两个链表,分别表示非负整数.它们的数字逆序存储在链表中,且每个结点只存储一个数字,计算两个数的和,并且返回和的链表头指针
	 * 如输入: 2->4->3、5->6->4,输出: 7->0->8
	 */
	public static Node add(Node node1, Node node2){
		Node sumNode = new Node(0);
		Node pTail = sumNode;//新结点插入到pTail后面
		Node p1 = node1.next;
		Node p2 = node2.next;
		Node pCur;
		int carry = 0;//进位
		int value;
		while(p1 != null && p2 != null){
			value = p1.value + p2.value + carry;
			carry = value / 10;
			value %= 10;
			pCur = new Node(value);
			pTail.next = pCur;//新结点链接到pTail的后面
			pTail = pCur;
			
			p1 = p1.next;//处理下一位
			p2 = p2.next;
		}
		//处理较长的链
		Node pNode = p1 != null ? p1 : p2;
		while(pNode != null){
			value = pNode.value + carry;
			carry = value / 10;
			value %= 10;
			pCur = new Node(value);
			pTail.next = pCur;
			pTail = pCur;
			pNode = pNode.next;
		}
		if (carry != 0) {
			pTail.next = new Node(carry);
		}
		return sumNode;
	}
	/**
	 * 链表的部分翻转
	 * 给定一个链表,翻转该链表从m到n的位置
	 * 要求直接翻转而非申请新空间
	 * 如: 给定1->2->3->4->5, m=2,n=4, 返回1->4->3->2->5
	 * 假定给出的参数满足: 1<=m<=n<=链表长度
	 * 分析:
	 * 空转m-1次,找到第m-1个结点,即开始翻转的第一个结点的前驱,记做head
	 * 以head为起始结点遍历n-m次,将第i次时,将找到的结点插入的head的next中即可. 即头插法
	 * @param node
	 * @param from
	 * @param to
	 */
	public static void reverse(Node node, int from, int to){
		Node pCur = node.next;
		int i;
		for(i=0;i<from-1;i++){
			node = pCur;
			pCur = pCur.next;
		}
		
		Node pPre = pCur;
		pCur = pCur.next;
		to--;
		Node pNext;
		for(;i<to;i++){
			pNext = pCur.next;
			pCur.next = node.next;
			node.next = pCur;
			pPre.next = pNext;
			pCur = pNext;
		}
	}
	/**
	 * 给定排序的链表,删除重复元素,只保留重复元素第一次出现的结点
	 * 如: 
	 * 给定: 2->3->3->5->7->8->8->8->9->9->10
	 * 返回: 2->3->5->7->8->9->10
	 * 问题分析:
	 * 若p->next的值和p的值相等,则将p->next->next赋值给p,删除p->next;重复上述过程,直至链表尾端
	 * @param pHead
	 */
	public static void deleteDuplicateNode(Node pHead){
		Node pPre = pHead.next;
		Node pCur;
		while(pPre != null){
			pCur = pPre.next;
			if (pCur != null && pCur.value == pPre.value) {
				pPre.next = pCur.next;
//				delete(pCur);
			}else {
				pPre = pCur;
			}
		}
	}
	
	public static void deleteDuplicateNode2(Node pHead){
		Node pPre = pHead;
		Node pCur = pPre.next;
		Node pNext;
		while(pCur != null){
			pNext = pCur.next;
			while(pNext != null && pCur.value == pNext.value){
				pPre.next = pNext;
//				delete pCur;
				pCur = pNext;
				pNext = pCur.next;
			}
			pPre = pCur;
			pCur = pNext;
		}
	}
	/**
	 * 若发现生重复元素,则重复元素全部删除
	 * 如: 
	 * 给定: 2->3->3->5->7->8->8->8->9->9->10
	 * 返回: 2->5->7->10
	 * @param pHead
	 */
	public static void deleteDuplicateNode3(Node pHead){
		Node pPre = pHead;
		Node pCur = pPre.next;
		Node pNext;
		boolean bDup;
		while(pCur != null){
			pNext = pCur.next;
			bDup = false;
			while (pNext != null && pCur.value == pNext.value) {
				pPre.next = pNext;
//				delete pCur;
				pCur = pNext;
				pNext = pCur.next;
				bDup = true;
			}
			if (bDup) {//此刻的pCur与原数据重复,删之
				pPre.next = pNext;
//				delete pCur;
			}else {//pCur未发现重复,则pPre后移
				pPre = pCur;
			}
			pCur = pNext;
		}
	}
	
	public static void main(String[] args) {
		Node node1 = new Node(0);
		for(int i=0;i<6;i++){
			Node node = new Node(new Random().nextInt(10));
			node.next = node1.next;
			node1.next = node;
		}

		printLinkedList(node1);
		
		Node node2 = new Node(0);
		for(int i=0;i<9;i++){
			Node node = new Node(new Random().nextInt(10));
			node.next = node2.next;
			node2.next = node;
		}
		printLinkedList(node2);
		
		Node sum = add(node1, node2);
		printLinkedList(sum);
		
		reverse(sum, 4, 8);
		printLinkedList(sum);
		
		
		int data[] = {2,3,3,5,7,8,8,8,9,9,30};
		Node pHead = new Node(0);
		for(int i = data.length-1;i>=0;i--){
			Node pNode = new Node(data[i]);
			pNode.next = pHead.next;
			pHead.next = pNode;
		}
		printLinkedList(pHead);
//		deleteDuplicateNode(pHead);
//		deleteDuplicateNode2(pHead);
		deleteDuplicateNode3(pHead);
		printLinkedList(pHead);
	}
}
