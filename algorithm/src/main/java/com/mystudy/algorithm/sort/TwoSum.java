package com.mystudy.algorithm.sort;

import java.util.Arrays;
/**
 * TwoSum算法，在一个数组中两个数的和等于一个定值
 * @author 
 *
 */
public class TwoSum {

	public static void main(String[] args) {
		int a[] = {0,4,3,7,9,11,14,16,17};
		Arrays.sort(a);
		twoSum(a, 20);
	}

	public static void twoSum(int a[], int sum){
		int i = 0;
		int j = a.length - 1;
		while(i<j){
			if (a[i] + a[j] < sum) {
				i++;
			}else if (a[i] + a[j] > sum) {
				j--;
			}else {
				System.out.println(a[i] + "--->>>" + a[j]);
				i++;
				j--;
			}
		}
	}
}
