package com.mystudy.algorithm;

public class LIS2 {

	public static void main(String[] args) {
//		int arr[] = {1,4,5,6,2,3,8,9,10,11,12,12,1};
		int arr[] = {1,4,6,2,8,9,7};
		int size = arr.length;
		int pre[] = new int[size];//record prior element location
		Integer nIndex = new Integer(0);
		int max = LIS(arr, size, pre, nIndex);
		System.out.println("max is : "+max);
		System.out.println("nIndex is : " + nIndex);
		for(int i=0;i<arr.length;i++){
			System.out.print(arr[i] + "\t");
		}
		System.out.println();
		for(int i=0;i<pre.length;i++){
			System.out.print(pre[i] + "\t");
		}
		System.out.println();
	}

	public static int LIS(int p[], int length, int pre[], Integer nIndex){
		int longest[] = new int[length];
		int i,j;
		for(i=0;i<length;i++){
			longest[i] = 1;
			pre[i] = -1;
		}
		int nLis = 1;
		nIndex = 0;
		for(i=1;i<length;i++){
			for(j=0;j<i;j++){
				if (p[j] <= p[i]) {
					if (longest[i] < longest[j] + 1) {
						longest[i] = longest[j] + 1;
						pre[i] = j;
					}
				}
			}
			if (nLis < longest[i]) {
				nLis = longest[i];
				nIndex = new Integer(i);
			}
		}
		return nLis;
	}
}
