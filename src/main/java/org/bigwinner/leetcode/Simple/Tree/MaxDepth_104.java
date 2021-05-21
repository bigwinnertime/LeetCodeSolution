package org.bigwinner.leetcode.Simple.Tree;

/**
 * @author: bigwinner
 * @date: 2020/10/12 9:34 上午
 * @version: 1.0.0
 * @description: 求解最大深度
 */
public class MaxDepth_104 {
    public static int maxDepth(TreeNode root) {
        // root 为null 最大深度为0
        if (root == null) return 0;
        // 遍历左子树，求解左子树的最大深度
        int left = maxDepth(root.left);
        // 遍历右子树，求解右子树的最大深度
        int right = maxDepth(root.right);
        // 两者的最大值即为当前数的最大深度
        return Math.max(left, right) + 1;
    }

    public static void main(String[] args) {
        Integer[] nums1 = new Integer[]{3,9,20,null,null,15,7};
//        Integer[] nums1 = new Integer[]{1,2,3};
        TreeNode t = TreeNode.constructTree(nums1);
        System.out.println(maxDepth(t));
    }
}
