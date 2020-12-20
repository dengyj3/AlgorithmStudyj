package com.mystudy.algorithm;

import java.util.Objects;

/**
 * leetcode,是否是回文数字
 */
public class PalindromeSolution {
    public static boolean isPalindrome1(int x) {
        if (x < 0) {
            return false;
        }
        if (x % 10 == 0 && x != 0) {
            return false;
        }
        int res = 0;
        while (x > res) {
            res = res * 10 + x % 10;
            x /= 10;
        }
        return x == res || x == res / 10;
    }

    public static boolean isPalindrome2(int x) {
        StringBuffer s = new StringBuffer(String.valueOf(x));
        return Objects.equals(s, s.reverse());
    }

    public static boolean isPalindrome3(int x) {
        if (x < 0) {
            return false;
        }
        if (x != 0 && x % 10 == 0) {
            return false;
        }
        int div = 1;
        while (x / div >= 10) {
            div *= 10;
        }
        while (x > 0) {
            int left = x / div;
            int right = x % 10;
            if (left != right) {
                return false;
            }
            x = (x % div) / 10;
            div /= 100;
        }
        return true;
    }

    public static void main(String[] args) {
        int x = 121;
        System.out.println(isPalindrome2(x));
        System.out.println(isPalindrome3(x));
    }
}
