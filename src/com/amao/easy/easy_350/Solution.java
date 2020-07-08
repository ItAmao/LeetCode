package com.amao.easy.easy_350;

/**
 * @description: 给定两个数组，编写一个函数来计算它们的交集。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出: [2,2]
 * 示例 2:
 * <p>
 * 输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出: [4,9]
 * 说明：
 * <p>
 * 输出结果中每个元素出现的次数，应与元素在两个数组中出现的次数一致。
 * 我们可以不考虑输出结果的顺序。
 * 进阶:
 * <p>
 * 如果给定的数组已经排好序呢？你将如何优化你的算法？
 * 如果 nums1 的大小比 nums2 小很多，哪种方法更优？
 * 如果 nums2 的元素存储在磁盘上，磁盘内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？
 * @params:
 * @return:
 * @author: amao
 * @time: 2020/5/24 8:41 上午
 */

import java.util.ArrayList;
import java.util.TreeMap;//基于搜索树映射

public class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        TreeMap<Integer, Integer> map = new TreeMap<>();//第一个Integer是相应的数组中的元素,第二个是频次
        for (int num : nums1) {
            if (!map.containsKey(num)) {//如果不存在则添加 然后计数1
                map.put(num, 1);
            } else {
                map.put(num, map.get(num) + 1);//如果存在,在原有的数字上+1
            }
        }
        ArrayList<Integer> list = new ArrayList<>();
        for (int num : nums2) {
            if (map.containsKey(num)) {//如果包含,则说明找到这个元素
                list.add(num);//把重复的元素添加到list中
                map.put(num, map.get(num) - 1);//然后把map中这个元素的次数减去1
                if (map.get(num) == 0) {//如果这个元素为0
                    map.remove(num);//删除这个元素
                }
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}
