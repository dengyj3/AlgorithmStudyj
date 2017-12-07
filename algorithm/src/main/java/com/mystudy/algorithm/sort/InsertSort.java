package com.mystudy.algorithm.sort;
/**
 * 直接插入排序,平均时间复杂度O(n^2)
 *
 */
public class InsertSort {

	public static void main(String[] args) {
		int a[] = {49,38,65,97,76,13,27,49,78,34,12,64,1};
		System.out.println("before sort : ");
		for(int i=0;i<a.length;i++){
			System.out.print(a[i] + " ");
		}
		System.out.println();
		for(int i=1;i<a.length;i++){
			int temp = a[i];//待插入元素
			int j;
			for(j=i-1;j>=0;j--){
				if (a[j] > temp) {//将大于temp的往后移动一位
					a[j+1] = a[j];
				}else {
					break;
				}
			}
			a[j+1] = temp;
		}
		System.out.println("after sort : ");
		for(int i=0;i<a.length;i++){
			System.out.print(a[i] + " ");
		}
	}

}
