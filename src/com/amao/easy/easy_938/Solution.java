package com.amao.easy.easy_938;

/**
 * @description: 给定二叉搜索树的根结点 root，
 * 返回 L 和 R（含）之间的所有结点的值的和。
 * 二叉搜索树保证具有唯一的值。
 * 示例 1：
 * 输入：root = [10,5,15,3,7,null,18], L = 7, R = 15
 * 输出：32
 * 意思是取  7<=x<=15的和
 * <p>
 * 示例 2：
 * 输入：root = [10,5,15,3,7,13,18,1,null,6], L = 6, R = 10
 * 输出：23
 * @params:
 * @return:
 * @author: amao
 * @time: 2020/5/22 10:01 上午
 */

public class Solution {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int rangeSumBST(TreeNode root, int L, int R) {
        if (root == null) {
            return 0;
        }
        if (root.val < L) {//如果说根节点小于L 则需要递归右子树
            return rangeSumBST(root.right, L, R);
        }
        if (root.val > R) {//如果说根节点大于[L,R] 则需要递归右子树
            return rangeSumBST(root.left, L, R);
        }
        return root.val + rangeSumBST(root.left, L, R) + rangeSumBST(root.right, L, R);
    }
}
