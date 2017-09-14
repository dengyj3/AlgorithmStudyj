package com.mystudy.algorithm;

public class GetNextPermutation {

	public static void main(String[] args) {
		int[] arr = {1,4,2,5};
		reverse(arr);
	}
	
	public static void reverse(int arr[]){
		StringBuffer stringBuffer = new StringBuffer();
		for(int i=arr.length-1;i>=0;i--){
			stringBuffer.append(arr[i]);
			if (i>0) {
				stringBuffer.append(",");
			}
		}
		System.out.println(stringBuffer);
	}

	public static void getNextPermutation(int[] arr, int size) {
		int i = size-2;
		while(i>=0 && arr[i]>=arr[i+1]){
			i--;
		}
		if (i<0) {
			return;
		}
		int j = size - 1;
		while(arr[j] <= arr[i]){
			j--;
		}
		
//		swap(arr[j],arr[i]);//����
		
//		reverse(arr[]);//��ת
		
	}
}
