package com.mystudy.algorithm;

/**
 * 字符串循环左移
 * 给定一个字符串S[0...N-1],要求把S的前k个字符移动到S的尾部,如把字符串"abcdef"前面的2个字符'a','b'移动到字符串的尾部,得到
 * 新字符串"cdefab":即字符串循环左移k
 * 循环左移n+k位和k位的效果相同(另:循环左移k位等价于循环右移n-k位)
 * 算法要求: 时间复杂度O(n),空间复杂度O(1)
 */
public class LeftReverseString {

	public static void main(String[] args) {
		String string = "abcdef";
		char[] cs = string.toCharArray();
		leftRatateString(cs, cs.length, 2);
		for (char c : cs) {
			System.out.print(c + ", ");
		}
		System.out.println();
	}
	/**
	 * 类似矩阵: (X'Y')' = YX
	 * 如: abcdef
	 * X=ab X'=ba
	 * Y=cdef Y'=fedc
	 * (X'Y')'=(bafedc)'=cdefab
	 * @param s
	 * @param from
	 * @param to
	 */
	public static void reverseString(char[] s, int from, int to){
		while(from<to){
			char t = s[from];
			s[from++] = s[to];
			s[to--] = t;
		}
	}

	/**
	 * 一个字符串的长度为n,循环左移m位
	 * @param s
	 * @param n
	 * @param m
	 */
	public static void leftRatateString(char[] s, int n, int m){
		m %= n;
		reverseString(s, 0, m-1);
		reverseString(s, m, n-1);
		reverseString(s, 0, n-1);
	}
}
