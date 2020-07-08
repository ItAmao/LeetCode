package com.amao.easy.easy_07;

/**
 * @description: 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 * <p>
 * 示例 1:
 * 输入: 123
 * 输出: 321
 * <p>
 *  示例 2:
 * 输入: -123
 * 输出: -321
 * <p>
 * 示例 3:
 * 输入: 120
 * 输出: 21
 * @params:
 * @return:
 * @author: amao
 * @time: 2020/6/9 19:08
 */
public class Solution {
    /*
        思路: 32位有效符号整数,int类型的范围
     */
    public static void main(String[] args) {
        System.out.println(reverse(1234));
    }

    public static int reverse(int x) {
        long temp = 0;//用来存反转后的数
        //用循环不断分离x位数
        while (x != 0) {
            int p = x % 10;
            temp = temp * 10 + p;
            //需要判断是否越界
            if (temp > Integer.MAX_VALUE || temp < Integer.MIN_VALUE) {
                return 0;
            }
            x = x / 10;
        }
        return (int) temp;//转型
    }

}
