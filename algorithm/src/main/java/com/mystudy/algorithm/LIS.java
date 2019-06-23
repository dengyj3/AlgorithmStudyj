package com.mystudy.algorithm;

/**
 * 最长递增子序列LIS(Longest Increasing Subsequence)
 * 给定长度为N的数组A,计算A的最长的单调递增的子序列(不一定连续)
 * 如：给定数组A{5,6,7,1,2,8}, 则A的LIS为{5,6,7,8}, 长度为4
 */
public class LIS {

    public static int lis1(int a[], int length) {
        int longest[] = new int[length];
        int i, j;
        for (i = 0; i < length; i++) {
            longest[i] = 1;
        }
        int nLis = 1;
        for (i = 1; i < length; i++) {
            for (j = 0; j < i; j++) {
                if (a[j] <= a[i]) {
                    longest[i] = Math.max(longest[i], longest[j] + 1);
                }
            }
            nLis = Math.max(nLis, longest[i]);
        }
        return nLis;
    }

    /**
     * 给定数组a 1,4,6,2,8,9,7
     * 以Array中字符为结尾的最长递增子序列
     * Array:1	4	6	2	8	9	7
     * LIS  :1	2	3	2	4	5	4
     *
     * @param args
     */
    public static void main(String[] args) {
        int a[] = {1, 4, 6, 2, 8, 9, 7};
        System.out.println(lis1(a, 5));
    }

}
