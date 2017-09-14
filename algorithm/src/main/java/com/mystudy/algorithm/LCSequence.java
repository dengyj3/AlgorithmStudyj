package com.mystudy.algorithm;

import java.util.Iterator;
import java.util.Stack;

public class LCSequence {

	public static int LCS(String str1, String str2) {
		Stack<Character> stack = new Stack<>();
		int[][] c = new int[str1.length() + 1][str2.length() + 1];
		for (int row = 0; row <= str1.length(); row++) {
			c[row][0] = 0;
		}
		for (int column = 0; column <= str2.length(); column++) {
			c[0][column] = 0;
		}
		for (int i = 1; i <= str1.length(); i++) {
			for (int j = 1; j < str2.length(); j++) {
				if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
					c[i][j] = c[i - 1][j - 1] + 1;
				} else if (c[i][j - 1] > c[i - 1][j]) {
					c[i][j] = c[i][j - 1];
				} else {
					c[i][j] = c[i - 1][j];
				}
//				System.out.println(c[i][j]);
			}
		}
		
		char c1[] = str1.toCharArray();
		char c2[] = str2.toCharArray();
		int i = c1.length-1;
		int j = c2.length-1;
		while( i>=0 && j>=0){
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
		System.out.println("===================");
		while (!stack.isEmpty()) {
			System.out.print(stack.pop() + "\t");
		}
		System.out.println("===================");
		return c[str1.length()][str2.length()];

	}

	public static void main(String[] args) {
		String str1 = "BDBC";
		String str2 = "ABCBDAB";
		int result = LCS(str1, str2);
		System.out.println(result);

	}

}
