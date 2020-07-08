package com.amao.easy.easy_1441;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 给你一个目标数组 target 和一个整数 n。每次迭代，需要从  list = {1,2,3..., n} 中依序读取一个数字。
 * 请使用下述操作来构建目标数组 target ：
 * Push：从 list 中读取一个新元素， 并将其推入数组中。
 * Pop：删除数组中的最后一个元素。
 * 如果目标数组构建完成，就停止读取更多元素。
 * 题目数据保证目标数组严格递增，并且只包含 1 到 n 之间的数字。
 * 请返回构建目标数组所用的操作序列。
 * 题目数据保证答案是唯一的。
 * 示例 1：
 * 输入：target = [1,3], n = 3
 * 输出：["Push","Push","Pop","Push"]
 * 解释：
 * 读取 1 并自动推入数组 -> [1]
 * 读取 2 并自动推入数组，然后删除它 -> [1]
 * 读取 3 并自动推入数组 -> [1,3]
 * <p>
 * 示例 2：
 * 输入：target = [1,2,3], n = 3
 * 输出：["Push","Push","Push"]
 * <p>
 * 示例 3：
 * 输入：target = [1,2], n = 4
 * 输出：["Push","Push"]
 * 解释：只需要读取前 2 个数字就可以停止。
 * <p>
 * 示例 4：
 * 输入：target = [2,3,4], n = 4
 * 输出：["Push","Pop","Push","Push","Push"]
 * @params:
 * @return:
 * @author: amao
 * @time: 2020/5/21 9:20 上午
 */
public class Solution {
    //这道题的意思是.先遍历target, 如果说target中的每个元素大于 1-n的数 那么就push pop
    //如果说 target中的元素小于的话 就push
    public  List<String> buildArray(int[] target, int n) {
        int j = 1;
        List<String> list = new ArrayList<>();
        for (int i = 0; i < target.length; i++) {
            while (target[i] > j) {
                list.add("Push");
                list.add("Pop");
                j++;
            }
            list.add("Push");
            j++;
        }
        return list;
    }
}
