package com.mystudy.algorithm.summary;

import java.util.ArrayList;
import java.util.List;

/**
 * 3n+1猜想、角谷猜想、哈塞猜想、乌拉姆猜想、叙拉古猜想等
 * 给定某正整数N,若为偶数,则N被更新为N/2;否则,N被更新为3*N+1;
 * 问:(1)经过多少步N变成1?(2)是否存在某整数X无法变成1?
 *
 */
public class Callatz {

	private static int count = 0;
	public static void calc(int i, List<Integer> list){
		if (i > 1) {
			count++;
			if (i % 2 == 0) {
				i /= 2;
				System.out.println("偶数变化是: " + i);
			}else {
				i = i * 3 + 1;
				System.out.println("奇数数变化是: " + i);
			}
			list.add(i);
		}else {
			return;
		}
		calc(i,list);
	}
	
	
	public static void main(String[] args) {
//		scalc(5);
		List<Integer> list = new ArrayList<>();
		calc(27,list);
		System.out.println(list.size());
		System.out.println("共执行了: "+count);
		System.out.println(list);
	}
}
