package com.mystudy.algorithm;
/**
 * O(NlogN)的最长递增子序列算法
 * 对于数组A={1,4,6,2,8,9,7}
 * 1
 * 1,4
 * 1,4,6
 * 1,2,6
 * 1,2,6,8
 * 1,2,6,8,9
 * 1,2,6,7,9
 * 缓存区不是LIS本身,求LIS本身的方法只能通过记录前驱
 *
 */
public class LIS3 {

	public static int LIS(int a[]){
		int b[] = new int[a.length];//缓冲区用来存放子串
		int s = 0;
		int i;
		for(i = 0; i<a.length; i++){
			s = insert(b,s,a[i]);
		}
		return s;
	}
	
	public static int insert(int a[],int s,int x){
		if (s<=0) {
			a[0] = x;
			s++;
			return s;
		}
		int low = 0;
		int high = s - 1;
		int mid;
		while(low<=high){
			mid = (low+high)/2;
			if (x<a[mid]) {
				high = mid - 1;
			}else if (x>=a[mid]) {
				low = mid + 1;
			}
		}
		if (low>=s) {
			a[s] = x;
			s++;
		}else {
			if (a[low]<x) {
				a[low+1] = x;
			}else {
				a[low] = x;
			}
		}
		return s;
	}
	
	public static void main(String[] args) {
//		int a[] = {5,6,7,1,2,8};
		int a[] = {1,4,6,2,8,9,7};
		int len = LIS(a);
		System.out.println(len);
	}
}
