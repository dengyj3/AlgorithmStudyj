package com.mystudy.algorithm.tree;

public class BinaryTree {
	private int data;// root
	private BinaryTree leftChild;//left child
	private BinaryTree rightChild;//right child
	
	public void visit() {
		System.out.println(this.data);
	}
	
	public BinaryTree(int data) {
		this.data = data;
		this.leftChild = null;
		this.rightChild = null;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public BinaryTree getLeftChild() {
		return leftChild;
	}

	public void setLeftChild(BinaryTree leftChild) {
		this.leftChild = leftChild;
	}

	public BinaryTree getRightChild() {
		return rightChild;
	}

	public void setRightChild(BinaryTree rightChild) {
		this.rightChild = rightChild;
	}

	@Override
	public String toString() {
		return "BinaryTree [data=" + data + ", leftChild=" + leftChild + ", rightChild=" + rightChild + "]";
	}
	
	
}
