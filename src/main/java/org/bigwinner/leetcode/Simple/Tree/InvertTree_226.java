package org.bigwinner.leetcode.Simple.Tree;

import static org.bigwinner.leetcode.Simple.Tree.TreeNode.constructTree;

/**
 * @author: bigwinner
 * @date: 2021/2/14 下午10:42
 * @version: 1.0.0
 * @description: 翻转二叉树
 */
public class InvertTree_226 {
    /**
     * 翻转一棵二叉树。
     *
     * 示例：
     *
     * 输入：
     *
     *      4
     *    /   \
     *   2     7
     *  / \   / \
     * 1   3 6   9
     * 输出：
     *
     *      4
     *    /   \
     *   7     2
     *  / \   / \
     * 9   6 3   1
     *
     * @param root
     * @return
     */
    public static TreeNode invertTree1(TreeNode root) {
        if (root == null) return root;
        // 交换左右子树
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        // 递归遍历左右子树
        invertTree1(root.right);
        invertTree1(root.left);
        return root;

    }

    public static TreeNode invertTree2(TreeNode root) {
        if (root == null) return root;
        // 递归遍历左右子树
        TreeNode left = invertTree2(root.left);
        TreeNode right = invertTree2(root.right);
        // 交换左右子树
        root.left = right;
        root.right = left;
        return root;

    }

    public static void main(String[] args) {
        Integer[] nums1 = new Integer[]{4,2,7,1,3,6,9};
        TreeNode a = constructTree(nums1);
        invertTree2(a);

    }

}
