package com.amao.easy.easy_66;

/**
 * @description: 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,2,3]
 * 输出: [1,2,4]
 * 解释: 输入数组表示数字 123。
 * 示例 2:
 * <p>
 * 输入: [4,3,2,1]
 * 输出: [4,3,2,2]
 * 解释: 输入数组表示数字 4321。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/plus-one
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @params:
 * @return:
 * @author: ItAmao
 * @time: 2020/6/15 17:39
 */
public class Solution {
    public int[] plusOne(int[] digits) {
        //此题目需要数组从后往前遍历,因为遇到9+1的情况 要分1,0
        int len = digits.length;
        for (int i = len - 1; i >= 0; i--) {
            //先把最后一个元素加上1
            digits[i]++;
            //判断是否为10,对10取摸的原因是因为任何数%10 都为自己本身10%10=0
            digits[i] %= 10;
            //如果说最后一个数是10 就回到循环
            if (digits[i] != 0) {
                return digits;
            }
        }
        //如果说 数组中的数全部为9,则需要维护一下数组
        digits = new int[len + 1];//扩容一个单位
        digits[0] = 1;//变成1后边len+1个0
        return digits;
    }
}
