package com.mystudy.algorithm.tree;

public class Btree {
	private Node root = null;
	
	public void insert(int val){
		Node node = new Node();
		node.setValue(val);
		//如果二叉树为空,直接将要插入的值作为根
		if (this.root == null) {
			this.root = node;
		} else {//如果二叉树不为空,判断要插入的数与此时p所指结点的值的大小,如果插入的数大,那么就插到右孩子，反之插入到左孩子。
			Node qNode = this.root;
			while(true){
				if (val < qNode.getValue()) {
					if (qNode.getLeftChild() == null) {
						qNode.setLeftChild(node);
						node.setParent(qNode);
						break;
					}else {
						qNode = qNode.getLeftChild();
					}
				}else if (val > qNode.getValue()) {
					if (qNode.getRightChild() == null) {
						qNode.setRightChild(node);
						node.setParent(qNode);
						break;
					}else {
						qNode = qNode.getRightChild();
					}
				}else {
					System.out.println("已存在");
				}
			}
		}
		
	}
	
	public static void main(String[] args) {
		Btree btree = new Btree();
		int[] data = {3,2,5,4,8,7,9};
		for(int i=0;i<data.length;i++){
			btree.insert(data[i]);
		}
	}
}
