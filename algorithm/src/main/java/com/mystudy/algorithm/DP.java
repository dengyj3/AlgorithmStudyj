package com.mystudy.algorithm;

public class DP {
	public static void main(String[] args) {
		int a[] = {1,3,5};
		int sum = 11;
		int cent = 0;
		int dp[] = new int[12];
		for(int i=0;i<=sum;i++){
			dp[i] = i;
		}
		for(int i=0;i<=sum;i++){
			for(int j=0;j<3;j++){
				if (i>=a[j] && (dp[i-a[j]] + 1 < dp[i])) {
					dp[i] = dp[i-a[j]] + 1;
					System.out.println(dp[i]);
				}
			}
		}
		System.out.println(dp[sum]);
	}
}
