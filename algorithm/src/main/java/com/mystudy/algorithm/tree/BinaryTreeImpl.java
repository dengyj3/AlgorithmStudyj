package com.mystudy.algorithm.tree;

import java.util.Random;

public class BinaryTreeImpl implements IBinaryTree {
	public static BinaryTree nRoot;

	@Override
	public boolean insert(BinaryTree binaryTree, int value) {
		if (null == binaryTree) {
			binaryTree = new BinaryTree(value);
			return true;
		}
		if (value < binaryTree.getData()) {
			return insert(binaryTree.getLeftChild(), value);
		}
		if (value > binaryTree.getData()) {
			return insert(binaryTree.getRightChild(), value);
		}
		return false;
	}

	@Override
	public boolean _insert(BinaryTree binaryTree, int value) {
		if (null == binaryTree) {
			binaryTree = new BinaryTree(value);
			return true;
		}
		BinaryTree pNode = binaryTree;
		BinaryTree pCur = binaryTree;
		while (pNode != null) {
			pCur = pNode;
			if (value < pNode.getData()) {
				pNode = pNode.getLeftChild();
			} else if (value > pNode.getData()) {
				pNode = pNode.getRightChild();
			} else {
				return false;
			}
		}
		if (value < pCur.getData()) {
			pCur.setLeftChild(new BinaryTree(value));
		} else if (value > pCur.getData()) {
			pCur.setRightChild(new BinaryTree(value));
		}
		return true;
	}

	@Override
	public BinaryTree find(BinaryTree nRoot, int value) {
		if (null == nRoot) {
			return null;
		}
		BinaryTree binaryTree = nRoot;
		while (binaryTree != null) {
			if (value < binaryTree.getData()) {
				binaryTree = binaryTree.getLeftChild();
			} else if (value > binaryTree.getData()) {
				binaryTree = binaryTree.getRightChild();
			} else {
				return binaryTree;
			}
		}
		return null;
	}

	@Override
	public boolean delete(BinaryTree nRoot, int value) {
		if (null == nRoot) {
			return false;
		}
		BinaryTree pNode = nRoot;
		BinaryTree pParent = null;
		while (pNode != null) {
			if (value < pNode.getData()) {
				pParent = pNode;
				pNode = pNode.getLeftChild();
			} else if (value > pNode.getData()) {
				pParent = pNode;
				pNode = pNode.getRightChild();
			} else {
				break;
			}
		}
		if (null == pNode) {
			return false;
		}
		if (pNode.getLeftChild() != null && pNode.getRightChild() != null) {
			deleteChildless(nRoot, pParent, pNode);
		} else if (pNode.getLeftChild() != null || pNode.getRightChild() != null) {
			deleteSingleSon(nRoot, pParent, pNode);
		} else {
			BinaryTree pCur = pNode;
			pParent = pNode;
			pNode = pNode.getLeftChild();
			while (pNode.getRightChild() != null) {
				pParent = pNode;
				pNode = pNode.getRightChild();
			}
			pCur.setData(pNode.getData());
			if (pNode.getLeftChild() != null) {
				deleteChildless(nRoot, pParent, pNode);
			} else {
				deleteSingleSon(nRoot, pParent, pNode);
			}
		}
		return true;
	}

	@Override
	public void deleteChildless(BinaryTree nRoot, BinaryTree pParent, BinaryTree pNode) {
		if (pNode.getData() == nRoot.getData()) {
			nRoot = null;
		} else if (pParent.getLeftChild().getData() == pNode.getData()) {
			pParent.setLeftChild(null);
		} else {
			pParent.setRightChild(null);
		}
	}

	@Override
	public void deleteSingleSon(BinaryTree nRoot, BinaryTree pParent, BinaryTree pNode) {
		BinaryTree pGrandSon = null;
		if (null != pNode.getLeftChild()) {
			pGrandSon = pNode.getLeftChild();
		} else {
			pGrandSon = pNode.getRightChild();
		}
		if (nRoot.getData() == pNode.getData()) {
			nRoot = pGrandSon;
		} else if (pParent.getLeftChild().getData() == pNode.getData()) {
			pParent.setLeftChild(pGrandSon);
		} else {
			pParent.setRightChild(pGrandSon);
		}
	}

	public static void main(String[] args) {
		BinaryTreeImpl binaryTreeImpl = new BinaryTreeImpl();
		BinaryTree binaryTree = null;
		for(int i=0;i<10;i++){
//			if (i == 0) {
//				binaryTree = new BinaryTree(new Random().nextInt(100));
//			}else {
				binaryTreeImpl.insert(binaryTree, new Random().nextInt(100));
//			}
		}
		System.out.println(binaryTree);
	}
}
