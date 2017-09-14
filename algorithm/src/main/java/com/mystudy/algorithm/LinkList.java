package com.mystudy.algorithm;

import java.util.Random;

public class LinkList {
	public Node first; // ����һ��ͷ���
	private int pos = 0;// �ڵ��λ��

	public LinkList() {
		this.first = null;
	}

	// ����һ��ͷ�ڵ�
	public void addFirstNode(int data) {
		Node node = new Node(data);
		node.setNext(first);
		first = node;
	}

	// ɾ��һ��ͷ���,������ͷ���
	public Node deleteFirstNode() {
		Node tempNode = first;
		first = tempNode.getNext();
		return tempNode;
	}

	// ������λ�ò���ڵ� ��index�ĺ������
	public void add(int index, int data) {
		Node node = new Node(data);
		Node current = first;
		Node previous = first;
		while (pos != index) {
			previous = current;
			current = current.getNext();
			pos++;
		}
		node.setNext(current);
		previous.setNext(node);
		pos = 0;
	}

	// ɾ������λ�õĽڵ�
	public Node deleteByPos(int index) {
		Node current = first;
		Node previous = first;
		while (pos != index) {
			pos++;
			previous = current;
			current = current.getNext();
		}
		if (current == first) {
			first = first.getNext();
		} else {
			pos = 0;
			previous.setNext(current.getNext());
		}
		return current;
	}

	// ���ݽڵ��dataɾ���ڵ�(����ɾ����һ��)
	public Node deleteByData(int data) {
		Node current = first;
		Node previous = first; // ��ס��һ���ڵ�
		while (current.getData() != data) {
			if (current.getNext() == null) {
				return null;
			}
			previous = current;
			current = current.getNext();
		}
		if (current == first) {
			first = first.getNext();
		} else {
			previous.setNext(current.getNext());
		}
		return current;
	}

	// ��ʾ�����еĽڵ���Ϣ
	public void displayAllNodes() {
		Node current = first;
		while (current != null) {
			current.display();
			current = current.getNext();
		}
		System.out.println();
	}

	// ����λ�ò��ҽڵ���Ϣ
	public Node findByPos(int index) {
		Node current = first;
		if (pos != index) {
			current = current.getNext();
			pos++;
		}
		return current;
	}

	// �������ݲ��ҽڵ���Ϣ
	public Node findByData(int data) {
		Node current = first;
		while (current.getData() != data) {
			if (current.getNext() == null)
				return null;
			current = current.getNext();
		}
		return current;
	}

	public static LinkList sum(LinkList linkList1, LinkList linkList2){
		LinkList sum = new LinkList();
		LinkList tail = sum;
		boolean flag = true;
		int value;
		int carry = 0;
		int cur = 0;
		while(flag){
			value = linkList1.first.getData() + linkList2.first.getData() + carry;
			carry = value/10;
			value %= 10;
//			cur = new LinkList();
//			cur.addFirstNode(value);
//			tail.addFirstNode(value);
			if (cur == 0) {
				tail.addFirstNode(value);
			}else {
				tail.add(cur, value);
			}
			
			linkList1.first = linkList1.first.getNext();
			linkList2.first = linkList2.first.getNext();
			if (linkList1.first == null || linkList2.first == null) {
				flag = false;
			}
			cur++;
		}
		
		LinkList linkList = linkList1.first != null ? linkList1 : linkList2;
		while(true){
			value = linkList.first.getData() + carry;
			carry = value/10;
			value %= 10;
			tail.add(cur, value);
			linkList.first = linkList.first.getNext();
			if (linkList.first == null) {
				break;
			}
			cur++;
		}
		if (carry != 0) {
			LinkList linkList3 = new LinkList();
			linkList3.addFirstNode(carry);
			tail.first.setNext(linkList3.first);
		}
		return sum;
	}

	public static void main(String[] args) {
		LinkList linkList1 = new LinkList();
		int data = 0;
		for(int i=0; i<6; i++){
			data = new Random().nextInt(9);
//			System.out.print(data+"\t");
			linkList1.addFirstNode(data);
		}
//		System.out.println();
		linkList1.displayAllNodes();
		System.out.println("==============================");
		LinkList linkList2 = new LinkList();
		for(int i=0; i<9; i++){
			data = new Random().nextInt(9);
//			System.out.print(data+"\t");
			linkList2.addFirstNode(data);
		}
		linkList2.displayAllNodes();
//		System.out.println("-------------getSum-----------");
//		LinkList sum = sum(linkList1,linkList2);
//		sum.displayAllNodes();
//		System.out.println();
//		System.out.println("===============================");
		testAddLinkList();
	}
	
	public static void testAddLinkList(){
		LinkList linkList = new LinkList();
		linkList.addFirstNode(3);
		linkList.addFirstNode(4);
		linkList.addFirstNode(1);
		linkList.add(2, 5);
//		linkList.addFirstNode(5);
		linkList.displayAllNodes();
	}
	
}
