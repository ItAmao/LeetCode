package com.amao.easy.easy_101;

/**
 * @description: 给定一个二叉树，检查它是否是镜像对称的。 
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 * <p>
 * 1
 * / \
 * 2   2
 * / \ / \
 * 3  4 4  3
 *  
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 * <p>
 * 1
 * / \
 * 2   2
 * \   \
 * 3    3
 * @params:
 * @return:
 * @author: amao
 * @time: 2020/5/23 9:36 上午
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

    public boolean isSymmetric(TreeNode root) {
        //因为一个整的二分搜索树可以分为2个
        return matching(root, root);
    }

    public boolean matching(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return true;//为空
        }
        if (t1 == null || t2 == null) {
            return false;
        }
        boolean a = (t1.val == t2.val);
        boolean b = matching(t1.left, t2.right);
        boolean c = matching(t1.right, t2.left);
        return a && b && c;
    }
}
