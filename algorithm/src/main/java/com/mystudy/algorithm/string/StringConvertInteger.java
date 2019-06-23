package com.mystudy.algorithm.string;

/**
 * 给定一个字符串str，如果str符合日常书写的整数形式，并且属于32位整数的范围，
 * 返回str所代表的整数值，否则返回0
 * eg.
 *  str="123", return 123
 *  str="023", 不符合日常书写习惯, return 0
 *  str="A13", return 0
 *  str="0",return 0
 *  str="2147483647", return 2147483647
 *  str="2147483648", 因为溢出了，所以return 0
 *  str="-123", return -123
 */
public class StringConvertInteger {
    public static boolean isValid(char[] chars) {
        // str不以'-'开头，也不以数字开头
        if (chars[0] != '-' && chars[0] < '0' || chars[0] > '9') {
            return false;
        }
        // 以'-'开头，但是str的长度为1，如果str长度大于1，但是'-'后面紧跟着'0'
        if (chars[0] == '-' && (chars.length == 1 || chars[1] == 0)) {
            return false;
        }
        // 以‘0’开头，但是str的长度大于1
        if (chars[0] == '0' && chars.length > 1) {
            return false;
        }
        for (int i = 1; i < chars.length; i++) {
            // 从1到N，如果有一个不是数字
            if (chars[i] < '0' || chars[i] > '9') {
                return false;
            }
        }
        return true;
    }

    public static int convert(String str) {
        if (str == null || str.equals("")) {
            return 0;// 不能转
        }
        char[] chars = str.toCharArray();
        if (!isValid(chars)) {
            return 0; //不能转
        }
        boolean posi = chars[0] == '-' ? false : true;
        int minq = Integer.MIN_VALUE / 10;
        int minr = Integer.MIN_VALUE % 10;
        int res = 0;
        int cur = 0;
        for (int i = posi ? 0 : 1; i < chars.length; i++) {
            cur = '0' - chars[i];
            if ((res < minq) || (res == minq && cur < minr)) {
                System.out.println("enter this");
                return 0;
            }
            res = res * 10 + cur;
        }
        if (posi && res == Integer.MIN_VALUE) {
            return 0;
        }
        return posi ? -res : res;
    }

    public static void main(String[] args) {
//        System.out.println(convert("123"));
//        System.out.println(convert("023"));
//        System.out.println(convert("A23"));
//        System.out.println(convert("0"));
//        System.out.println(convert("2147483647"));
//        System.out.println(convert("2147483648"));
        System.out.println(convert("2147483649"));
//        System.out.println(convert("-123"));
    }
}
