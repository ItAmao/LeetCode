package com.amao;

import java.util.Scanner;

/**
 * @author Mr.G
 * @since 2020/6/10 17:31
 */
public class Test {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入一个有符号整数");
        String s=sc.next();
        Integer integer = Integer.valueOf(s);
        if (integer>0){
        }else if(integer<0){
            int i = negativeNumber(integer);
            System.out.println(i);
            System.exit(0);
        }
        int abs = Math.abs(integer);
        String s1 = String.valueOf(abs);
        StringBuilder sb=new StringBuilder(s1);
        StringBuilder reverse = sb.reverse();
        String sb1=reverse.toString();
        Integer integer1=Integer.valueOf(sb1);
        System.out.println(integer1);
    }
    public static int negativeNumber(Integer integer){
        int abs = Math.abs(integer);
        String s1 = String.valueOf(abs);
        StringBuilder sb=new StringBuilder(s1);
        StringBuilder reverse = sb.reverse();
        String sb1 = reverse.toString();
        Integer integer1 = Integer.valueOf(sb1);
        return -integer1;
    }
}
