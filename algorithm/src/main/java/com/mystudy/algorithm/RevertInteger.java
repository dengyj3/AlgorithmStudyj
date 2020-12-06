package com.mystudy.algorithm;

/**
 * 整数翻转
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 *
 * 示例 1:
 *
 * 输入: 123
 * 输出: 321
 *  示例 2:
 *
 * 输入: -123
 * 输出: -321
 * 示例 3:
 *
 * 输入: 120
 * 输出: 21
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-integer
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class RevertInteger {
    public static int reverse(int x) {
        int result = 0;
        while (x!=0) {
            int pop = x%10;
            if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && pop > 7))
                return 0;
            if (result < Integer.MIN_VALUE / 10 || (result == Integer.MIN_VALUE / 10 && pop < -8))
                return 0;
            result = result *10 + pop;
            x /= 10;
        }
        return result;
    }

    public static void main(String[] args) {
        int x = 123;
        System.out.println(reverse(x));
        x=120;
        System.out.println(reverse(x));
    }
}
