package com.mystudy.algorithm;

import org.apache.commons.lang3.ArrayUtils;

public class BF {

	public static void main(String[] args) {
		String text = "aaabaaaabaaaabaaaabaaaabaaaab";
		String pattern = "aaaa";
//		System.out.println(bruteForceSearch(text.toCharArray(), pattern.toCharArray()));
		
		String pString = "abababa";
		System.out.println(ArrayUtils.toString(getNext(pString.toCharArray())));
		
	}

	public static int bruteForceSearch(char s[], char p[]) {
		int i = 0;
		int j = 0;
		int size = p.length;
		int nLast = s.length - size;
		while (i<nLast && j < size) {
			
			if (s[i+j] == p[j]) {
				j++;
			}else {
				i++;
				j=0;
			}
		}
		if (j>=size) {
			return i;
		}
		return -1;
	}
	
	public static int[] getNext(char[] p){
		int next[] = new int[p.length];
		next[0] = -1;
		int k = -1;
		int j = 0;
		while (j < p.length -1) {
			//此刻,k即next[j-1],且p[k]表示前缀,p[j]表示后缀
			//注:k==-1表示未找到k前缀与k后缀相等,首次分析可先忽略
			if (k==-1 || p[j] == p[k]) {
				++j;
				++k;
				next[j] = k;
			}else {//p[j]与p[k]失配,则继续递归计算前缀p[next[k]]
				k = next[k];
			}
		}
		return next;
	}
	
}
