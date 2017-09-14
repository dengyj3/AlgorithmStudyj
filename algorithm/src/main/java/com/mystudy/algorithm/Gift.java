package com.mystudy.algorithm;

import java.util.Arrays;
/**
 * 求某个红包出现次数大于红包总数的一半
 * @author 58
 *
 */
public class Gift {
	public static int getValue(int[] gifts, int n){
		System.out.println("before : ");
		for(int i=0; i<gifts.length; i++){
			System.out.print(gifts[i]+"\t");
		}
		if(gifts.length == 0 || gifts.length !=n){
			return 0;
		}
		//先给红包数组排序 algorithm
		Arrays.sort(gifts);
		System.out.println();
		System.out.println("after : ");
		for(int i=0; i<gifts.length; i++){
			System.out.print(gifts[i]+"\t");
		}
		System.out.println();
		//取数组中间值
		int value = gifts[n/2];
		//取中间值出现的次数 algorithm
		int count = count(gifts, value);
		//如果中间值出现的次数不超过红包总数的一半
		//则不符合条件，反之
		if(count>=(n/2)+1){
			return value;
		}else{
			return 0;
		}
	}
	
	public static int count(int[] a, int value){
		int count = 0;
		for(int i=0; i<a.length; i++){
			if(a[i] == value){
				count++;
			}
		}
		return count;
	}
	
	public static void main(String[] args){
		int[] a = {1,2,3,2,2};
		int x = getValue(a, 5);
		System.out.println(x);
	}
}
