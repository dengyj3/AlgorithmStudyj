package com.mystudy.algorithm.summary;
/**
 * 给定一个32位无符号整数N,求整数N的二进制数中1的个数
 * 可以通过不断的将整数N右移,判断当前数字的最低位是否为1,直到整数N为0为止
 * 平均情况下,大约需要16次移位和16次加法
 *
 */
public class OneNumber {
	private static int oneNumber(int n){
		int c = 0;
		while (n!=0) {
			c+=n&1;//奇数则累加1
			n>>=1;
		}
		return c;
	}
	
	private static int oneNumber2(int n){
		int c=0;
		while (n!=0) {
			n &= (n-1);
			c++;
		}
		return c;
	}
	
	public static void main(String[] args) {
		int c1 = oneNumber(101);
		int c2 = oneNumber2(101);
		System.out.println(c1);
		System.out.println(c2);
	}
}
