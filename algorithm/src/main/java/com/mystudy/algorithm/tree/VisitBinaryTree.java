package com.mystudy.algorithm.tree;

import java.util.Stack;

public class VisitBinaryTree {

	// 先序遍历非递归算法
	private void preOrder(BinaryTree root) {
		if (null != root) {
			Stack<BinaryTree> stack = new Stack<BinaryTree>();
			for (BinaryTree node = root; !stack.isEmpty() || node != null;) {
				// 当遍历至节点位空的时候出栈
				if (null == node) {
					node = stack.pop();
				}

				node.visit();
				// 遍历右孩子入栈
				if (node.getRightChild() != null) {
					stack.push(node.getRightChild());
				}
				// 遍历左子树节点
				node = node.getLeftChild();
			}
		}
	}

	// 先序遍历递归算法
	private void preOrderRecursion(BinaryTree root) {
		if (root != null) {
			root.visit();
			preOrderRecursion(root.getLeftChild());
			preOrderRecursion(root.getRightChild());
		}
	}

	// 中序遍历的非递归算法
	public void inOrder(BinaryTree root) {

		if (root != null) {

			Stack<BinaryTree> stack = new Stack<BinaryTree>();

			for (BinaryTree node = root; !stack.empty() || node != null;) {

				// 寻找最左的左子树节点,并将遍历的左节点进栈
				while (node != null) {
					stack.push(node);
					node = node.getLeftChild();
				}

				if (!stack.empty()) {
					node = stack.pop(); // 出栈
					node.visit(); // 读取节点值
					node = node.getRightChild();
				}
			}
		}
	}

	// 中序遍历的递归算法
	public void inOrderRecursion(BinaryTree root) {

		if (root != null) {
			inOrderRecursion(root.getLeftChild());
			root.visit();
			inOrderRecursion(root.getRightChild());
		}

	}

	// 后序遍历非递归算法
	private void postOrder(BinaryTree root) {
		if (root != null) {
			Stack<BinaryTree> stack = new Stack<BinaryTree>();

			for (BinaryTree node = root; !stack.empty() || node != null;) {
				while (root != null) {
					stack.push(root);
					root = root.getLeftChild();
				}

				while (!stack.empty() && root == stack.peek().getRightChild()) {
					root = stack.pop();
					root.visit();
				}

				if (stack.empty()) {
					return;
				} else {
					root = stack.peek().getRightChild();
				}
			}
		}
	}

	// 后序遍历递归算法
	private void postOrderRecursion(BinaryTree root) {
		if (root != null) {
			postOrderRecursion(root.getLeftChild());
			postOrderRecursion(root.getRightChild());
			root.visit();
		}
	}
}
