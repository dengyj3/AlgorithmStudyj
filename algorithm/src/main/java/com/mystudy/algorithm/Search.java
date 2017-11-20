package com.mystudy.algorithm;

import java.util.LinkedList;
import java.util.Queue;

public class Search {
	public static boolean[] accessed = new boolean[8];
	public static boolean[] accessed2 = new boolean[8];
	public static ArcNode[] heads = new ArcNode[8];
	public static Queue<Integer> queue = new LinkedList<>();

	public static void main(String[] args) {
		for (int i = 0; i < heads.length; i++) {
			heads[i] = new ArcNode(i + 1);
		}
		for (int i = 0; i < accessed.length; i++) {
			accessed[i] = false;
		}
		heads[0].nextArc = new ArcNode(2);
		heads[0].nextArc.nextArc = new ArcNode(3);

		heads[1].nextArc = new ArcNode(1);
		heads[1].nextArc.nextArc = new ArcNode(4);
		heads[1].nextArc.nextArc.nextArc = new ArcNode(5);

		heads[2].nextArc = new ArcNode(1);
		heads[2].nextArc.nextArc = new ArcNode(6);
		heads[2].nextArc.nextArc.nextArc = new ArcNode(7);

		heads[3].nextArc = new ArcNode(2);
		heads[3].nextArc.nextArc = new ArcNode(8);

		heads[4].nextArc = new ArcNode(2);
		heads[4].nextArc.nextArc = new ArcNode(8);

		heads[5].nextArc = new ArcNode(3);

		heads[6].nextArc = new ArcNode(3);

		heads[7].nextArc = new ArcNode(4);
		heads[7].nextArc.nextArc = new ArcNode(5);

		BroadFirstSearch(heads);
		DepthFirstSearch(heads);
	}

	private static void DepthFirstSearch(ArcNode[] heads2) {
		DepthFirstSearch(heads[0]);
	}

	private static void DepthFirstSearch(ArcNode arcNode) {
		ArcNode curNode = heads[arcNode.adjvex - 1];
		System.out.print(curNode);
		accessed[curNode.adjvex - 1] = true;

		curNode = curNode.nextArc;
		while (curNode != null) {
			if (!accessed[curNode.adjvex - 1]) {
				System.out.print(" -> ");
				DepthFirstSearch(curNode);
			}
			curNode = curNode.nextArc;
		}
	}

	private static void BroadFirstSearch(ArcNode[] heads2) {
		BroadFirstSearch(heads[0]);
	}

	private static void BroadFirstSearch(ArcNode arcNode) {
		queue.add(arcNode.adjvex);
		accessed2[arcNode.adjvex - 1] = true;
		while (queue.size() > 0) {
			Integer vex = queue.remove();
			ArcNode curNode = heads[vex - 1].nextArc;
			while (curNode != null) {
				if (!accessed2[curNode.adjvex - 1]) {
					queue.add(curNode.adjvex);
					accessed2[curNode.adjvex - 1] = true;
				}
				curNode = curNode.nextArc;
			}
			System.out.print(vex);
			if (queue.size() > 0)
				System.out.print(" -> ");
			else
				System.out.println("");
		}
	}
}

class ArcNode {
	private int i;
	public ArcNode nextArc;
	public int adjvex;

	public ArcNode(int i) {
		this.i = i;
	}
}
