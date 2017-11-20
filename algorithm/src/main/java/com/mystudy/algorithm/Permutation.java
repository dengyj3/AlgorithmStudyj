package com.mystudy.algorithm;

/**
 * 求字符串的全排列
 * 递归的思想
 * 比如  abcde  先求出abcd的全排列，然后将e分别插入全排列的5个位置
 * a 全排列  a
 * ab 全排列  ab ba
 * abd 全排列即是  cab acb abc cba bca bac
 *
 */
public class Permutation {
	public static void main(String[] args) {
		int a[] = {1,3,3,4};
		permutation(a, 0);
	}

	/**
	 * 求一个字符串的全排列
	 * @param string
	 * @return
	 */
	private static String[] getPermutaion(String string) {
		String[] rStrings = new String[1000];
		if (string == null || string.isEmpty()) {
			return null;
		}
		int strLen = string.length();
		if (strLen == 1) {
			rStrings[0] = string;
		}else if (strLen == 2) {
			rStrings[0] = string;
			rStrings[1] = ""+string.charAt(1)+string.charAt(0);
		}else if (strLen>2) {
			char c = string.charAt(strLen-1);
			String strBefore = string.substring(0, strLen-1);
			String[] tmpRsArr = getPermutaion(strBefore);
			int count = 0;
			for(int i=0;i<tmpRsArr.length;i++){
				String tmpRs = tmpRsArr[i];
				if (tmpRs != null) {
					for(int k=0;k<tmpRs.length()+1;k++){
						rStrings[count++] = tmpRs.substring(0, k) + c + tmpRs.substring(k, tmpRs.length());
					}
				}
			}
		}
		return rStrings;
	}
	
	public static void print(int[] a){
		for (int i : a) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
	/**
	 * 一个字符串的全排列递归算法,时间复杂度O((n+1)!)
	 * @param a
	 * @param n
	 */
	public static void permutation(int a[], int n){
		if (n == a.length - 1) {
			print(a);
			return;
		}
		for(int i = n; i < a.length; i++){
			int temp = a[i];//交换a[i],a[n]
			a[i] = a[n];
			a[n] = temp;
			permutation(a, n+1);
			temp = a[i];//交换a[i],a[n]
			a[i] = a[n];
			a[n] = temp;
		}
	}
	/**
	 * 判断一个数字是否在数组中
	 * @param a
	 * @param n
	 * @param t
	 * @return
	 */
	public static boolean isDuplicate(int[] a, int n, int t){
		while(n < t){
			if (a[n] == a[t]) {
				return false;
			}
			n++;
		}
		return true;
	}
	/**
	 * 去除重复元素的全排列
	 * @param a
	 * @param n
	 */
	public static void permutation1(int a[], int n){
		if (n == a.length - 1) {
			print(a);
			return;
		}
		for(int i = n; i < a.length; i++){
			if (!isDuplicate(a, n, i)) {//a[i]是否与[n,i)重复
				continue;
			}
			int temp = a[i];//交换a[i],a[n]
			a[i] = a[n];
			a[n] = temp;
			permutation1(a, n+1);
			temp = a[i];//交换a[i],a[n]
			a[i] = a[n];
			a[n] = temp;
		}
	}
}
