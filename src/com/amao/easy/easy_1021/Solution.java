package com.amao.easy.easy_1021;

public class Solution {
    public static String removeOuterParentheses(String S) {
        StringBuilder sb = new StringBuilder();
        int level = 0;
//        int count = 0;
        for (char c : S.toCharArray()) {
            //"(()())(())"
            if (c == ')') --level;
            if (level >= 1) sb.append(c);
            if (c == '(') ++level;
//            count++;
//            System.out.println("第"+count+"步");
//            System.out.println("c为" + c);
//            System.out.println("sb为" + sb);
//            System.out.println("level为:" + level);
//            System.out.println("---------------------");

        }

        return sb.toString();
    }

}
