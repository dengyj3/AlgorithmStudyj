package com.mystudy.algorithm;

public class HammingWeight {
	public static void main(String[] args) {
		System.out.println(numberOf1_Solution(3));
	}
	
	public static int numberOf1_Solution(int i){
		int count = 0;
		while(i>0){
			if ((i & 1)!=0) {
				count ++ ;
			}
			i = i>>1;
		}
		return count;
	}
}
