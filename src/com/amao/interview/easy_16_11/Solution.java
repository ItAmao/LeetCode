package com.amao.interview.easy_16_11;

/**
 * 你正在使用一堆木板建造跳水板。有两种类型的木板，其中长度较短的木板长度为shorter，长度较长的木板长度为longer。你必须正好使用k块木板。编写一个方法，生成跳水板所有可能的长度。
 *
 * 返回的长度需要从小到大排列。
 *
 * 示例：
 *
 * 输入：
 * shorter = 1
 * longer = 2
 * k = 3
 * 输出： {3,4,5,6}
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/diving-board-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *  @Author : ItAmao
 *  @Date   : 2020/7/8 14:10
 */
class Solution{
    public static int[] divingBoard(int shorter,int longer,int k){
        //1.当k=0时,return一个空的数组
        if(k==0){
            return new int[0];
        }
        //2.当shorter=longer的时候,
        if(shorter==longer){
            int sum=shorter*k;
            return new int[]{sum};
        }
        //3.当shorter<longer,且k!=0的情况
        //有k+1中组合情况
        int []newNum=new int[k+1];
        //设长木板用i块,短木板就是(k-i)块
        for(int i=0;i<k+1;i++){
            newNum[i]=i*longer+(k-i)*shorter;
        }
        return newNum;
    }
    public static void main(String[] args){
        int []num=divingBoard(1,2,3);
        for(int nums:num){
            System.out.println(nums);
        }
    }
}
