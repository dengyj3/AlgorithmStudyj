package com.mystudy.algorithm.tree;

public interface IBinaryTree {
	public boolean insert(BinaryTree binaryTree, int value);//递归
	public boolean _insert(BinaryTree binaryTree, int value);//非递归
	public BinaryTree find(BinaryTree nRoot, int value);//查找
	public boolean delete(BinaryTree nRoot, int value);//删除
	public void deleteChildless(BinaryTree nRoot, BinaryTree pParent, BinaryTree pNode);
	public void deleteSingleSon(BinaryTree nRoot, BinaryTree pParent, BinaryTree pNode);
}
