package com.amao.easy.easy_118;


/**
 * @description: 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 * 示例:
 * 输入: 5
 * 输出:
 * [
 * [1],
 * [1,1],
 * [1,2,1],
 * [1,3,3,1],
 * [1,4,6,4,1]
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/pascals-triangle
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @params:
 * @return:
 * @author: ItAmao
 * @time: 2020/6/17 08:16
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        //System.out.println(generate(1));
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入杨辉三角的层数:");
        int num = sc.nextInt();
        List<List<Integer>> list = generate(num);
        for (List<Integer> integers : list) {
            System.out.println(integers);
        }
    }

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> arr = new ArrayList<>();
        //1.如果传入的数小于等于0 返回空的数组
        if (numRows <= 0) {
            return arr;
        }
        //2.看图可以发现一个规律 从第1组开始
        /*
            1 1   +
            0 1 1
            ======
            1 2 1
            可以使用往后移动一位的 第一位补0的规律得到第2组的数
         */
        //先添加第一组:第一组为1
        List<Integer> firstRow = new ArrayList<>();
        firstRow.add(1);
        arr.add(new ArrayList(firstRow));
        //return arr;
        //循环遍历后几组
        int size = arr.size();
        while (size < numRows) {
            //后边相加的话 用链表比较好,可以插入头,移动元素
            //因为如果是第三组的话,集合中就嵌套3个集合
            LinkedList<Integer> first = new LinkedList<>();
            //原来的组需要往后边补一个0
            first.addLast(0);
            LinkedList<Integer> second = new LinkedList<>();
            //第二个需要往第一个数补0
            second.addFirst(0);
            //补空
            for (int num : arr.get(size - 1)) {
                first.addLast(num);
                second.addFirst(num);
            }
            //用一个新的集合存储 这两个集合相加的数
            List<Integer> list = new ArrayList<>();
            //循环遍历
            for (int i = 0; i < second.size(); i++) {
                //按顺序相加
                list.add(first.get(i) + second.get(i));
            }
            //把新的集合存储到原来集合中
            arr.add(list);
            //维护size
            size++;
        }
        return arr;
    }
}
