package com.amao.easy.easy_387;

/**
 * @description: 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 * 示例：
 * s = "leetcode"
 * 返回 0
 * s = "loveleetcode"
 * 返回 2
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/first-unique-character-in-a-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @params:
 * @return:
 * @author: ItAmao
 * @time: 2020/6/19 15:51
 */
public class Solution {
    public static void main(String[] args) {
        String s = "leetcode";
        s = "abbalc";
        System.out.println(firstUniqChar(s));
    }

    public static int firstUniqChar(String s) {
        int[] freq = new int[26];
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            if ((freq[s.charAt(i) - 'a']) == 1) {
                return i;
            }
        }
        return -1;
    }
}
