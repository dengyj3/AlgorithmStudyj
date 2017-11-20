package com.mystudy.algorithm.sort;

public class MergeSort {

	private static int count = 0;
	private static int temp[];
	public static void main(String[] args) {
		int a[] = {3,56,2,7,45,8,1};
//		int count = 0;
		temp = new int[a.length];
		System.out.println("before sort:");
		printArray(a);
		sort(a);
		System.out.println("aftter sort:");
		printArray(a);
//		System.out.println(count);
//		System.out.println("++++++++++++++++");
		
	}
	
	public static void printArray(int a[]){
		for(int i : a){
			System.out.print(i+",");
		}
		System.out.println();
	}
	
	public static void sort(int[] a){
//		System.out.println("start sort ...... ");
		mergeSort(a,0,a.length-1);
	}
	
	public static void mergeSort(int[] a, int low, int high){
		if (low >= high) {
			return;
		}
		int mid = (low + high) / 2;
		mergeSort(a, low, mid);
		mergeSort(a, mid+1, high);
		merge(a, low, mid, high);
	}
	
	public static void merge(int a[], int low, int mid, int high){
		int temp[] = new int[a.length];
		int i = low;
		int j = mid + 1;
		int size = 0;
		for(;i<mid && j<=high; size++){
			if (a[i] < a[j]) {
				temp[size] = a[i++];
			}else {
//				count += (mid-i+1);
//				printPair(a,j,i,mid);
				temp[size] = a[j++];
			}
		}
		while(i<=mid){
			temp[size++] = a[i++];
		}
		while(j<=high){
			temp[size++] = a[j++];
		}
//		System.out.println("第"+(++count)+"次排序:\t");
		for(i=0;i<size;i++){
			a[low+i] = temp[i];
//			System.out.print(a[low+i] + "\t");
		}
//		i=low;
//		while(i<=high){
//			a[i] = temp[i];
//			i++;
//		}
//		System.out.println();
	}
	
	public static void printPair(int a[], int j, int i, int mid){
		while(i<=mid){
			System.out.println(a[i++]+"--->>>"+a[j]);
		}
	}

}
