package com.mystudy.algorithm.sort;

public class MergeSort2 {

	public static void main(String[] args) {
		/*int[] a = { 49, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12, 64, 1, 8 };
		System.out.println("排序之前：");
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		// 归并排序
		mergeSort(a, 0, a.length - 1);
		System.out.println();
		System.out.println("排序之后：");
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}*/
		int aInteger = 100, bInteger = 100;
		System.out.println(aInteger == bInteger);
		int cInteger = 150, dInteger = 150;
		System.out.println(cInteger == dInteger);
	}
	
	private static void mergeSort(int[] a, int left, int right){
		if (left < right) {
			int middle = (left + right)/2;
			mergeSort(a, left, middle);//对左边进行排序
			mergeSort(a, middle+1, right);//对右边进行排序
			merge(a, left, middle, right);
		}
	}
	
	private static void merge(int[] a, int left, int middle, int right){
		int[] tmpArr = new int[a.length];
		int mid = middle + 1;//右边的起始位置
		int tmp = left;
		int third = left;
		while(left<=middle && mid <=right){
			//从两个数组中选取较小的数放入中间数组
			if (a[left] <= a[mid]) {
				tmpArr[third++] = a[left++];
			}else {
				tmpArr[third++] = a[mid++];
				
			}
		}
		//将剩余的部分放入中间数组
		while(left<=middle){
			tmpArr[third++] = a[left++];
		}
		while (mid<=right) {
			tmpArr[third++] = a[mid++];
		}
		//将中间数组复制回原数组
		while(tmp<=right){
			a[tmp] = tmpArr[tmp++];
		}
	}
}
