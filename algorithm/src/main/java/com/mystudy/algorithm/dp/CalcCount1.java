package com.mystudy.algorithm.dp;

/**
 * 用dp(n)表示从1到n的最少操作步数
 * 若n为奇数,则n的前一步只能是n-1,即dp(n)=dp(n-1)+1
 * 若n为偶数,则n的前一步是n-1和n/2的操作步数的小者,即dp(n)=min(dp(n-1,dp(n/2))+1
 */
public class CalcCount1 {

    public static void main(String[] args) {
        int N = 2015;
        int[] pCount = new int[N + 1];
        int[] pPre = new int[N + 1];
        calcCount(N, pCount, pPre);
        int n = N;
        while (n != 1) {
            System.out.print(pPre[n] + "\t");
            n = pPre[n];
        }
    }

    public static int calcCount(int n, int pCount[], int pPre[]) {
        if (n == 1) {
            return 0;
        }
        if (n % 2 == 1) {//n是奇数
            if (pCount[n - 1] == 0) {
                pCount[n - 1] = calcCount(n - 1, pCount, pPre);
            }
            pPre[n] = n - 1;
            pCount[n] = pCount[n - 1] + 1;
        } else {//n是偶数
            int n2 = n / 2;
            if (pCount[n2] == 0) {
                pCount[n2] = calcCount(n2, pCount, pPre);
            }
            if (pCount[n - 1] == 0) {
                pCount[n - 1] = calcCount(n - 1, pCount, pPre);
            }
            if (pCount[n2] < pCount[n - 1]) {
                pPre[n] = n2;
                pCount[n] = pCount[n2] + 1;
            } else {
                pPre[n] = n - 1;
                pCount[n] = pCount[n - 1] + 1;
            }
        }
        return pCount[n];
    }

}
