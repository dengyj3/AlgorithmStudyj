package com.mystudy.algorithm;
/**
 * �۰�����㷨
 * @author 
 *
 */
public class BinarySearch {
	/**
	 * �ǵݹ��㷨
	 * @param a
	 * @param num
	 * @return
	 */
	public static String binarySearch(int[] a, int num){
		if (a.length == 0) {
			return "Error";
		}
		int startPos = 0;
		int endPos = a.length - 1;
		int mid = (startPos + endPos) / 2;
		while (startPos <= endPos) {
			if (num == a[mid]) {
				return "Array�±�: " + mid;
			}else if (num > a[mid]) {
				startPos = mid + 1;
			}else {
				endPos = mid - 1;
			}
			mid = (startPos + endPos) / 2;
		}
		return "�������޸���ֵ";
	}
	//�ݹ��㷨
	public static int binarySearch(int[] args, int i, int startPos, int endPos) {
		if (args == null || startPos > endPos) {
			return -1;
		}
		int midPos = (startPos + endPos) /2;
		if (i == args[midPos]) {
			return midPos;
		}else if (i<args[midPos]) {
			return binarySearch(args, i, startPos, midPos - 1);
		}else {
			return binarySearch(args, i, midPos + 1, endPos);
		}
	}
	
}
