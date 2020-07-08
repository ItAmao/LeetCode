package com.amao.easy.easy_01;

import java.util.Map;
import java.util.TreeMap;

/**
 * @description: 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 * <p>
 * 示例:
 * 给定 nums = [2, 7, 11, 15], target = 9
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @params:
 * @return:
 * @author: amao
 * @time: 2020/5/28 10:22 上午
 */
public class Solution {
    /*
        解题思路:
        map:代表由关键字以及它们的值组成的一些项的集合
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < nums.length; i++) { //遍历数组
            int temp = target - nums[i];
            if (map.containsKey(temp)) {
                return new int[]{map.get(temp), i};
            }
            map.put(nums[i], i);//把数组元素和它的索引存入map中
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}
