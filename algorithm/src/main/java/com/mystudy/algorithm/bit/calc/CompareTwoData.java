package com.mystudy.algorithm.bit.calc;

/**
 * 给定两个32位整数a和b，返回a和b中较大的
 * 要求：不用任何比较判断。
 */
public class CompareTwoData {
    public int flip(int n){
        return n^1;
    }
    public int sign(int n){
        return flip((n>>31)&1);
    }
    public int getMax1(int a, int b){
        int c=a-b;
        int scA=sign(c);
        int scB=flip(scA);
        return a*scA+b*scB;
    }
}
