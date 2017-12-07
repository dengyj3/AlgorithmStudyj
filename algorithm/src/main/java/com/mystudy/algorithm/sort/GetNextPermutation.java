package com.mystudy.algorithm.sort;
/**
 * 字符串全排列的非递归算法,找到下一个比本身大的字符串
 *
 */
public class GetNextPermutation {

	public static void main(String[] args) {
		int[] arr = {1,4,2,5};
		print(arr);
		System.out.println("nextPermutation is : ");
		while(getNextPermutation(arr, arr.length)){
			print(arr);
		}
	}
	/**
	 * 把一个数组从from到to做反转
	 * @param arr
	 * @param from
	 * @param to
	 */
	public static void reverse(int arr[], int from, int to){
		int t;
		while(from < to){
			t = arr[from];
			arr[from] = arr[to];
			arr[to] = t;
			from++;
			to--;
		}
	}

	public static boolean getNextPermutation(int[] arr, int size) {
		int i = size-2;//后找
		while(i>=0 && arr[i]>=arr[i+1]){
			i--;
		}
		if (i<0) {
			return false;
		}
		//小大
		int j = size - 1;
		while(arr[j] <= arr[i]){
			j--;
		}
		//交换
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
		
		//反转
		reverse(arr,i+1,size-1);
		return true;
	}
	
	public static void print(int arr[]){
		for (int i : arr) {
			System.out.print(i + "\t");
		}
		System.out.println();
	}
}
