package com.mystudy.algorithm.summary;

import java.util.Vector;

/**
 * 马踏棋盘:
 * 给定m*n的棋盘,将棋子"马"放在任意位置上,按照走棋规则将"马"移动,要求每个方格只能进入一次,最终使得"马"走遍棋盘的所有位置
 * 深度优先搜索
 * 假设从左上角开始跳
 */
public class HorseJump {
	//8*9的棋盘
	private static int M = 8;
	private static int N = 9;
	private static int iHorse[] = {-2,-2,-1,+1,+2,+2,+1,-1};
	private static int jHorse[] = {-1,+1,+2,+2,+1,-1,-2,-2};
	
	private static boolean canJump(Vector<Vector<Integer>> chess, int i, int j){
		if (i<0 || i>=M || j<0 || j>=N) {
			return false;
		}
		return chess.get(i).get(j) == 0;
	}
	
	private static boolean jump(Vector<Vector<Integer>> chess, int i, int j, int step){
		if (step == M*N) {//遍历结束
			return true;
		}
		int iCur, jCur;
		for(int k=0;k<M;k++){
			iCur = i + iHorse[k];
			jCur = j + jHorse[k];
			if (canJump(chess, iCur, jCur)) {
				chess.get(iCur).set(jCur, step+1);
				if (jump(chess, iCur, jCur, step+1)) {
					return true;
				}
				chess.get(iCur).set(jCur, 0);//回溯 DFS
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		Vector<Vector<Integer>> chess = new Vector<Vector<Integer>>();
		initVector(chess);
		printVector(chess);
//		chess.add(new Vector<Integer>());
		System.out.println("-------------------------------------");
		jump(chess, 0, 0, 1);//从左上角开始遍历
		printVector(chess);
	}
	
	private static void printVector(Vector<Vector<Integer>> chess){
		for(int i=0;i<M;i++){
			for(int j=0;j<N;j++){
				System.out.print(chess.get(i).get(j) + " ");
			}
			System.out.println();
		}
	}
	/**
	 * 实始化二维数组
	 * @param chess
	 */
	private static void initVector(Vector<Vector<Integer>> chess){
		Vector<Integer> jVector = new Vector<Integer>();
		for(int i=0;i<N;i++){
			jVector.addElement(0);
		}
		for(int i=0;i<M;i++){
			chess.addElement(jVector);
		}
	}
	
}
