package com.mystudy.algorithm.sort;
/**
 * 给定正整数N,求小于等于N的全部素数
 * 1. 将2到N写成一排;
 * 2. 记排头元素为x,则x是素数;除x以外,将x的倍数全部划去;
 * 3. 重复以上操作,直到没有元素被划去,则剩余的即小于等于N的全部素数.
 *
 */
public class Eratosthenes {

	public static void main(String[] args) {
		int n = 100;
		boolean[] a = new boolean[n+1];
		eratosthenes(a, n);
		for(int i = 0; i<n+1; i++){
			if (a[i]) {
				System.out.print(i + ",");
			}
		}
	}

	public static void eratosthenes(boolean a[], int n){
		a[1] = false;//a[0]不可用
		int i;
		for(i = 2; i<=n; i++){//筛法,默认是素数
			a[i] = true;
		}
		int p = 2;//第一个是筛孔
		int j = p*p;
		while( j <= n){
			while(j<=n){
				a[j] = false;
				j+=p;
			}
			p++;
			while(!a[p]){//查找下一个素数
				p++;
			}
			j = p*p;
		}
	}
}
