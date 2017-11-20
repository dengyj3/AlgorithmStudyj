package com.mystudy.algorithm;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.TreeSet;
import java.util.Vector;

public class CalcWord {
	public static void main(String[] args) {
		Set<String> dict = new LinkedHashSet<>();
		dict.add("hot");
		dict.add("dot");
		dict.add("dog");
		dict.add("lot");
		dict.add("log");
		
		String start = "hit";
		String end = "cog";
		System.out.println(calcLadderLength(start,end,dict));
	}

	private static int calcLadderLength(String start, String end, Set<String> dict) {
		Queue<String> queue = new LinkedList<>();
		queue.add(start);
		Vector<String> children = new Vector<>();//从当前节点可扩展到的新节点集合
		TreeSet<String> visit = new TreeSet<>();
		int step = 0;
		String cur;
		int curNumber = 1;//当前剩余节点数目
		int nextNumber = 0;//下一层孩子节点数目
		while(!queue.isEmpty()){
			cur = queue.peek();//从cur开始扩展
			queue.poll();
			curNumber--;
			extend(cur, children, dict, end, visit);
			nextNumber += children.size();
			if (curNumber == 0) {//当前遍历完,则遍历下一层,所以step加1
				step++;
				curNumber = nextNumber;
				nextNumber = 0;
			}
			Iterator<String> iterator = children.iterator();
			while(iterator.hasNext()){
				String it = iterator.next();
				if (!it.equals(end)) {
					return step;
				}
				queue.add(it);
			}
		}
		return 0;
	}
	//搜索cur的孩子节点,存入children中
	public static void extend(String cur, Vector<String> children, Set<String> dict, String end, TreeSet<String> visit) {
		char[] child = cur.toCharArray();
		children.clear();
		int i;
		char c,t;
		for(i=0;i<child.length;i++){
			t = child[i];
			for(c = 'a'; c != 'z'; c++){
				if (c == t) {
					continue;
				}
				child[i] = c;
				
				if (((String.valueOf(child).equals(end))||(dict.contains(String.valueOf(child)) && !String.valueOf(child).equals(end))) 
						&& (visit.contains(String.valueOf(child)) && String.valueOf(child).equals(visit.last()))) {
					children.add(String.valueOf(child));
					visit.add(String.valueOf(child));
				}
			}
			child[i] = t;
		}
	}
}
