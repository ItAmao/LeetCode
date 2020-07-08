package com.amao.easy.easy_119;

import java.util.ArrayList;
import java.util.List;

/**
 *  @Author : ItAmao
 *  @Date   : 2020/7/1 20:35
 */
public class Solution01 {
    public static void main(String[] args) {
        List<Integer> row = getRow(2);
        System.out.println(row);
    }

    public static List<Integer> getRow(int rowIndex) {
        List<Integer> list = new ArrayList<>();
        while (rowIndex-- >= 0) {
            list.add(1);
            System.out.println(list);
            for (int i = list.size() - 2; i > 0; i--) {
                list.set(i, list.get(i) + list.get(i - 1));
            }
        }
        return list;
    }
}
