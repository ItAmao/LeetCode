package com.amao.easy.easy_167;

/**
 *  @Author : ItAmao
 *  @Date   : 2020/7/8 15:25
 */
class Solution{
    public static int[] twoSum(int[] numbers, int target) {
        int [] res=new int[2];
        int left=0;
        int right=numbers.length-1;
        while(left<right){
            int temp=numbers[left]+numbers[right];
            if(temp>target){
                right--;
            }else if(temp<target){
                left++;
            }else{
                res[0]=left+1;
                res[1]=right+1;
                return res;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] numbers={2, 7, 11, 15};
        int target=9;
        int[] ints = twoSum(numbers, 9);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }
}
