package com.amao.easy.easy_884;
/**
 * @description:
 * 给定 S 和 T 两个字符串，当它们分别被输入到空白的文本编辑器后，判断二者是否相等，并返回结果。 # 代表退格字符。
 * 注意：如果对空文本输入退格字符，文本继续为空。
示例 1：

输入：S = "ab#c", T = "ad#c"
输出：true
解释：S 和 T 都会变成 “ac”。
示例 2：

输入：S = "ab##", T = "c#d#"
输出：true
解释：S 和 T 都会变成 “”。
示例 3：

输入：S = "a##c", T = "#a#c"
输出：true
解释：S 和 T 都会变成 “c”。
示例 4：

输入：S = "a#c", T = "b"
输出：false
解释：S 会变成 “c”，但 T 仍然是 “b”。

 * @params:
 * @return:
 * @author: amao
 * @time: 2020/5/18 5:58 下午
 */ 
import java.util.Stack;

public class Solution {
    public boolean backspaceCompare(String S, String T) {
        Stack stack1 = new Stack();
        Stack stack2 = new Stack();
        for (int i = 0; i < S.length(); i++) {
            char a = S.charAt(i);//返回指定索引处的字符。
            if (a != '#') {
                stack1.push(a);
            } else {
                if (!stack1.isEmpty()) {
                    stack1.pop();
                }
            }
        }
        for (int j = 0; j < T.length(); j++) {
            char b = T.charAt(j);
            if (b != '#') {
                stack2.push(b);
            } else {
                if (!stack2.isEmpty()) {
                    stack2.pop();
                }
            }
        }
        if (stack1.equals(stack2)) {
            return true;
        } else {
            return false;
        }

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String S  = "a#c";
        String T = "b";
        System.out.println(solution.backspaceCompare(S, T));
    }
}
