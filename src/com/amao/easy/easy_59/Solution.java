package com.amao.easy.easy_59;

/**
 * @description: 给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。
 * 示例:
 * 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
 * 输出: [3,3,5,5,6,7]
 * 解释:
 * 滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 * 1 [3  -1  -3] 5  3  6  7       3
 * 1  3 [-1  -3  5] 3  6  7       5
 * 1  3  -1 [-3  5  3] 6  7       5
 * 1  3  -1  -3 [5  3  6] 7       6
 * 1  3  -1  -3  5 [3  6  7]      7
 * @params:
 * @return:
 * @author: amao
 * @time: 2020/5/17 7:52 下午
 */
import java.util.Queue;
public class Solution {
    Queue<Integer> queue;
    int size;

    public int maxSlidingWindow(int[] nums, int k) {
        return size;
    }

}
