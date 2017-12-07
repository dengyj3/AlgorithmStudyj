package com.mystudy.algorithm.sort;
/**
 * 二分法插入
 *
 */
public class BinInsertSort {

	public static void main(String[] args) {
		int a[] = {49,38,65,97,76,13,27,49,78,34,12,64,1};
		System.out.println("before sort : ");
		for(int i=0;i<a.length;i++){
			System.out.print(a[i] + " ");
		}
		System.out.println();
		sort(a);
		System.out.println("after sort : ");
		for(int i=0;i<a.length;i++){
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}
	
	private static void sort(int[] a){
		for(int i=0;i<a.length;i++){
			int temp = a[i];
			int left = 0;
			int right = i-1;
			int mid = 0;
			while(left<=right){
				mid = (left+right)/2;
				if (temp<a[mid]) {
					right = mid - 1;
				}else {
					left = mid + 1;
				}
			}
			for(int j=i-1;j>=left;j--){
				a[j+1] = a[j];
			}
			if (left != i) {
				a[left] = temp;
			}
		}
	}
}
