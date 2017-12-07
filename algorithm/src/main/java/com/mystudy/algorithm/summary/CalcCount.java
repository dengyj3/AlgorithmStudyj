package com.mystudy.algorithm.summary;
/**
 * 三字母字符串组合
 * 仅由三个字符A,B,C构成字符串,且字符串任意三个相邻元素不能完全相同.如"ACCCAB"不合法,"ABBCBCA"合法.
 * 求满足条件的长度为n的字符串个数?
 * 假定不考虑整数溢出
 * 要求时间和空间复杂度不高于O(N)
 * dp[n][0]结尾不相等/dp[n][1]结尾相等
 * n-1的字符串最后两个不相同,长度为n的字符串最后两个不相同: 如: ABCAABAB 后面只能再加A或C
 * n-1的字符串最后两个相同,长度为n的字符串最后两个不相同: 如: ABCAABABB 后面只再加A或C
 * 因此状态转移方程为:1. (dp[n][0]=2*dp[n-1][0]+2*dp[n-1][1])
 * 
 * 要想使长度为n的字符串最后两个相同,则长度为n-1的字符串最后两个字符只能不相等,且只有一种情况
 * ABCAAB 后面只能加B
 * 因此状态转移方程为: 2. (dp[n][1]=dp[n-1][0]) 
 * 
 * 初始条件
 * dp[1][0]=3 (即: A,B,C)
 * dp[1][1]=0 
 * 状态转移方程:
 * 1. dp[n][0]=2*dp[n-1][0]+2*dp[n-1][1]
 * 2. dp[n][1]=dp[n-1][0]
 * 滚动数组:
 * dp[0]=2*dp[0]+2*dp[1]
 * dp[1]=dp[0]
 * 使用滚动数组,将空间复杂度由O(N)降到O(1)
 *
 */
public class CalcCount {

	public static int calcCount(int n){
		int nNonRepeat = 3;
		int nRepeat = 0;
		int t;
		for(int i=2;i<=n;i++){
			t = nNonRepeat;
			nNonRepeat = 2 * (nNonRepeat + nRepeat);
			nRepeat = t;
		}
		return nRepeat + nNonRepeat;
	}
	
	public static void main(String[] args) {
		System.out.println(calcCount(4));
		System.out.println(calcCount2(4));
	}
	/**
	 * 矩阵相乘
	 * @param mMatrix22
	 * @param nMatrix22
	 */
	public static Matrix22 matrixMulti(Matrix22 mMatrix22, Matrix22 nMatrix22){
		int a = mMatrix22.a * nMatrix22.a + mMatrix22.c * nMatrix22.b;
		int b = mMatrix22.b * nMatrix22.a + mMatrix22.d * nMatrix22.b;
		int c = mMatrix22.a * nMatrix22.c + mMatrix22.c * nMatrix22.d;
		int d = mMatrix22.b * nMatrix22.c + mMatrix22.d * nMatrix22.d;
		mMatrix22 = new Matrix22(a, b, c, d);
		return mMatrix22;
	}
	/**
	 * 矩阵的n次方
	 * @param matrix22
	 * @param n
	 */
	public static Matrix22 matrixN(Matrix22 matrix22, int n){
		if (n == 0) {
			matrix22 = new Matrix22(1, 0, 0, 1);//单位阵
			return matrix22;
		}
		if (n == 1) {
			return matrix22;
		}
		if (n % 2 == 0) {//偶数
			matrix22 = matrixN(matrix22, n/2);
			matrix22 = matrixMulti(matrix22, matrix22);
		}else {//奇数
			Matrix22 xMatrix22 = matrix22;
			matrix22 = matrixN(matrix22, n/2);
			matrix22 = matrixMulti(matrix22, matrix22);
			matrix22 = matrixMulti(matrix22, xMatrix22);
		}
		return matrix22;
	}
	
	public static int calcCount2(int n){
//		int nNonRepeat = 3;
//		int nRepeat = 0;
		Matrix22 matrix22 = new Matrix22(2, 2, 1, 0);
		matrix22 = matrixN(matrix22, n-1);
		return 3*(matrix22.a + matrix22.c);//(3 0)*m
	}
	
}
/**
 * 2*2的矩阵
 *
 */
class Matrix22{
	//第一列
	public int a;
	public int b;
	//第二列
	public int c;
	public int d;
	public Matrix22(int a, int b, int c, int d){
		this.a = a;
		this.b = b;
		this.c = c;
		this.d = d;
	}
}

