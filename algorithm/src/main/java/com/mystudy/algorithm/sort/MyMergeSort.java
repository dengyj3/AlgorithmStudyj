package com.mystudy.algorithm.sort;

public class MyMergeSort {
	public static int number = 0;
	public static void main(String[] args) {
		int[] a = {3,56,2,7,45,8,1};
		printArray("before sort : ", a);
		mergeSort(a);
		printArray("after sort : ", a);
		
	}
	
	private static void printArray(String pre, int[] a){
		System.out.print(pre + "\n");
		for(int i=0;i<a.length;i++){
			System.out.print(a[i] + "\t");
		}
		System.out.println();
	}
	
	private static void mergeSort(int[] a){
		System.out.println("begin sort");
		sort(a, 0, a.length-1);
	}
	private static void sort(int a[], int left, int right){
		if (left>=right) {
			return;
		}
		int mid = (left + right) /2;
		sort(a, left, mid);
		sort(a, mid+1, right);
		merge(a, left, mid, right);
	}
	
	private static void merge(int a[], int left, int mid, int right){
		int[] tmp = new int[a.length];
		int r1 = mid + 1;
		int tIndex = left;
		int cIndex = left;
		while(left<=mid && r1<=right){
			if (a[left]<=a[r1]) {
				tmp[tIndex++] = a[left++];
			}else {
				tmp[tIndex++] = a[r1++];
			}
		}
		while(left<=mid){
			tmp[tIndex++] = a[left++];
		}
		while(r1<=right){
			tmp[tIndex++] = a[r1++];
		}
		System.out.println("The sort number is " + (++number) + ": \t");
		while(cIndex<=right){
			a[cIndex] = tmp[cIndex];
			System.out.print(a[cIndex]+"\t");
			cIndex++;
		}
		System.out.println();
	}
}
