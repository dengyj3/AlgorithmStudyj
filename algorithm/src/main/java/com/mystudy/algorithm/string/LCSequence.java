package com.mystudy.algorithm.string;

import java.util.Stack;

/**
 * 最长公共子序列
 */
public class LCSequence {

	public static int LCS(String str1, String str2, StringBuilder lcs) {
		Stack<Character> stack = new Stack<>();
		
		char[] c1 = str1.toCharArray();
		char[] c2 = str2.toCharArray();
		
		int[][] c = new int[str1.length() + 1][str2.length() + 1];//构建m+1,n+1的二维数组
		for (int row = 0; row <= str1.length(); row++) {//第0行全部填充0
			c[row][0] = 0;
		}
		for (int column = 0; column <= str2.length(); column++) {//第0列全部填充0
			c[0][column] = 0;
		}
		for (int i = 1; i <= c1.length; i++) {
			for (int j = 1; j <= c2.length; j++) {
				if (c1[i-1] == c2[j-1]) {//i,j相等
					c[i][j] = c[i - 1][j - 1] + 1;
				} /*else if (c[i][j - 1] > c[i - 1][j]) {//下面两个else求c[i][j-1]和c[i-1][j]的最大值(max(c[i][j-1],c[i-1][j])),即c[i][j]左边和上边的相邻元素的最大值
					c[i][j] = c[i][j - 1];
				} else {
					c[i][j] = c[i - 1][j];
				}*/
				else {
					c[i][j] = Math.max(c[i][j - 1], c[i - 1][j]);
				}
			}
		}
		
		int i = c1.length-1;
		int j = c2.length-1;
		while( i>=0 && j>=0){//从后往前遍历字符串,入栈
			if (c1[i] == c2[j]) {
				stack.push(c1[i]);
				i--;
				j--;
			}else {
				if (c[i][j-1] > c[i-1][j]) {
					j--;
				}else {
					i--;
				}
			}
		}
		while (!stack.isEmpty()) {
			lcs.append(stack.pop());//出栈,类似于做了个字符串反转
		}
		return c[str1.length()][str2.length()];

	}

	public static void main(String[] args) {
		String str1 = "BDCABA";
		String str2 = "ABCBDAB";
		StringBuilder lcs = new StringBuilder();
		int result = LCS(str1, str2, lcs);
		System.out.println(result);
		System.out.println(lcs);

	}

}
