package com.amao.easy.easy_119;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。
 *
 *
 *
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 *
 * 示例:
 *
 * 输入: 3
 * 输出: [1,3,3,1]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/pascals-triangle-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *  @Author : ItAmao
 *  @Date   : 2020/7/1 20:14
 */
public class Solution {
    public static void main(String[] args) {
        List<Integer> row = getRow(3);
        System.out.println(row);
    }
    public static List<Integer> getRow(int rowIndex) {
        List<Integer> list = new ArrayList<>();
        //如果是第一行的话
        if (rowIndex == 1) {
            list.add(1);
            return list;
        }
        //如果是第二行的话
        if (rowIndex == 2) {
            list.add(1);
            list.add(1);
            return list;
        }
        int x;//用于记录各行的数
        //第三行以上
        //使用递归的方法 获取前两行
        List<Integer> list1 = getRow(rowIndex-1);
        //遍历rowIndex上一行的数,因为rowIndex为几,这个行的数字就有几个
        for (int i = 0; i < rowIndex; i++) {
            //说明是第一个数,或者最后一个数
            if (i == 0 || i == rowIndex - 1) {
                x = 1;
            } else {
                //这个数就是上边2个数的总和
                x = list1.get(i - 1) + list1.get(i);
            }
            list.add(x);
        }
        return list;
    }
}
