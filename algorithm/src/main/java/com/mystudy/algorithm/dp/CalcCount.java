package com.mystudy.algorithm.dp;

import java.util.Stack;
/**
 * 操作最少次数
 * 变量x从1开始变化,规则是: 要么变成x+1,要么变成2*x, 问:若想将x变成整数2015,最少需要多少次变化?
 *	计算一个数从n+1或2*n得到,一共需要多少步? 
 * 从后向前看: 
 * 如果当前数是奇数,则减一,即dp(n)=dp(n-1)+1
 * 如果是偶数,则折半--没有发生减一的情况,即dp(n)=dp(n/2)+1
 * 分析: 若n为偶数,选择减一操作,则n-1为奇数,对n-1的操作必然只能减一得到n-2,若此刻选择折半,则变成(n/2)-1,经历了3步;
 * 选择折半操作,然后再选择减一操作,则变成(n/2)-1,经历了2步;
 * 结论: 若n为偶数,则折半肯定能得到更少的步数
 *
 */
public class CalcCount {

	public static void main(String[] args) {
		calcCount(2017);
	}

	public static int calcCount(int n){
		if (n == 1) {
			return 0;
		}
		Stack<Integer> path = new Stack<Integer>();
		while(n>1){
			if (n % 2 == 0) {//偶数
				n /= 2;
			}else {//奇数
				n--;
			}
			path.push(n);
		}
		
		//输出
		int s = path.size();
		System.out.println(s);
		while(!path.isEmpty()){
			System.out.print(path.pop() + ", ");
		}
		System.out.println();
		return s;
	}
}
