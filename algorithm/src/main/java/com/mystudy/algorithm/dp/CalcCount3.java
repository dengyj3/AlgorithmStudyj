package com.mystudy.algorithm.dp;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 如果n从100开始
 *
 */
public class CalcCount3 {

	private static int stop = 100;
	public static int calcCount3(int n, int pCount[], int pPre[]){
		if (n == stop) {
			pCount[n] = 0;
			return 0;
		}
		if (n%2 == 1) {//奇数
			if (pCount[n-1] == 0) {
				pCount[n-1] = calcCount3(n-1, pCount, pPre);
			}
			pPre[n] = n-1;
			pCount[n] = pCount[n-1] + 1;
		}else {//偶数
			int n2 = n/2;
			if (n2>=stop && pCount[n2]==0) {
				pCount[n2] = calcCount3(n2, pCount, pPre);
			}
			if (pCount[n-1] == 0) {
				pCount[n-1] = calcCount3(n-1, pCount, pPre);
			}
			if (n2>=stop && pCount[n2]<pCount[n-1]) {
				pPre[n] = n2;
				pCount[n] = pCount[n2] + 1;
			}else {
				pPre[n] = n-1;
				pCount[n] = pCount[n-1] + 1;
			}
		}
		return pCount[n];
	}
	
	private static int calcCount4(int n, Stack<Integer> path){
		if (n == stop) {
			return 0;
		}
		while(n>stop){
			if (n%2 == 0 && n/2>stop) {
				n/=2;
			}else {//n为奇数,或者比较小
				n--;
			}
			path.push(n);
		}
		return path.size();
	}
	private static int calcCount5(int n, Queue<Integer> path){
		if (n == stop) {
			return 0;
		}
		while(n>stop){
			if (n%2 == 0 && n/2>stop) {
				n/=2;
			}else {//n为奇数,或者比较小
				n--;
			}
			path.add(n);
		}
		return path.size();
	}
	
	public static void main(String[] args) {
		int N = 2016;
		int[] pCount = new int[N+1];
		int[] pPre = new int[N+1];
		calcCount3(N, pCount, pPre);
		int n = N;
		while(n != stop){
			System.out.print(pPre[n] + "\t");
			n = pPre[n];
		}
		System.out.println();
		System.out.println("=====================");
		Stack<Integer> path = new Stack<Integer>();
		calcCount4(N, path);
		while(!path.isEmpty()){
			System.out.print(path.pop() + "\t");
		}
		System.out.println();
		System.out.println("=====================");
		Queue<Integer> queue = new LinkedList<Integer>();
		calcCount5(N, queue);
		while(!queue.isEmpty()){
			System.out.print(queue.poll() + "\t");
		}
		System.out.println();
	}
}
